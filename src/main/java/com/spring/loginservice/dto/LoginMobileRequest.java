package com.spring.loginservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginMobileRequest implements Serializable {
    private static final long serialVersionUID = -1184747617408824122L;

    private String username;
    private String password;
}
