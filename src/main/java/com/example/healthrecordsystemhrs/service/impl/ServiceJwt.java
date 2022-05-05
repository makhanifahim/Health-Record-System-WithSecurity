package com.example.healthrecordsystemhrs.service.impl;

import com.example.healthrecordsystemhrs.model.Credential;
import com.example.healthrecordsystemhrs.model.JwtRequest;
import com.example.healthrecordsystemhrs.model.JwtResponse;
import com.example.healthrecordsystemhrs.repo.CredentialRepo;
import com.example.healthrecordsystemhrs.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ServiceJwt implements UserDetailsService {

    @Autowired
    private CredentialRepo credentialRepo;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    public JwtResponse createJwtToken(JwtRequest jwtRequest) throws Exception{
        String userName=jwtRequest.getUserName();
        String userPassword=jwtRequest.getUserPassword();
        authenticate(userName,userPassword);
        final UserDetails userDetails=loadUserByUsername(userName);
        String newGeneratedToken=jwtUtil.generateToken(userDetails);
        Credential credential=credentialRepo.findById(credentialRepo.idByUserName(userName)).get();
        return new JwtResponse(credential,newGeneratedToken);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Credential credential=credentialRepo.findById(credentialRepo.idByUserName(username)).get();
        Credential credential = credentialRepo.findusername(username);
        if(credential!=null){
            return new User(
                credential.getUserName(),credential.getPassWord(),getAuthorities(credential)
            );
        }else{
            throw new UsernameNotFoundException("Username is not valid");
        }
    }
    private Set getAuthorities(Credential credential){
        Set authorities=new HashSet();
        credential.getRole().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getRole()));
        });

        return authorities;
    }

    private void authenticate(String userName,String userPassword) throws Exception{
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName,userPassword));
        }
        catch(DisabledException e){
            throw new Exception("User is disabled");
        }
        catch(BadCredentialsException e){
            throw new Exception("Bad Credentials from user");
        }
    }
}
