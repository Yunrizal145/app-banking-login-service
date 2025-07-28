package com.spring.loginservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginMobileResponse implements Serializable {
    private static final long serialVersionUID = 7366557048664285664L;

    private String fullName;
    private String accountNumber;
    private BigDecimal balance;
    private Boolean isLogin;
}
