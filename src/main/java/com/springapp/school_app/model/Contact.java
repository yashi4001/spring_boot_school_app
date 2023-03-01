package com.springapp.school_app.model;

import lombok.Data;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class Contact {

    @NotBlank(message="Name must not be blank")
    @Size(min=3,message="Name must be atleast 3 characters")
    private String name;

    @NotBlank(message="Mobile number should not be blank")
    @Pattern(regexp="(^$|[0-9]{10})",message="Mobile number must be 10 digits")
    private String mobileNum;

    @NotBlank(message="Email must not be blank")
    @Email(message="Please provide valid email address")
    private String email;

    @NotBlank(message = "Subject should not be blank")
    @Size(min=5,message = "Subject must be atleast 5 characters")
    private String subject;

    @NotBlank(message = "Message should not be blank")
    @Size(min=10,message = "Message must be atleast 10 characters")
    private String message;


}
