package com.hrs.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
public class FeedBack {
    private String feedbackOn;
    private String Subject;
    private String Description;
    private String email;
}
