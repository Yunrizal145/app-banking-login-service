package com.spring.loginservice.service;

import com.spring.loginservice.dto.LoginMobileRequest;
import com.spring.loginservice.dto.LoginMobileResponse;
import com.spring.myaccountmanagementservice.dto.GetMutasiByAccountNumberRequest;
import com.spring.usermanagementservice.dto.GetUserAuthenticationRequest;
import com.spring.usermanagementservice.dto.GetUserProfileRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Slf4j
@Service
public class LoginService {

    @Autowired
    private UserManagementService userManagementService;

    @Autowired
    private MyAccountManagementService myAccountManagementService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public LoginMobileResponse loginMobile(LoginMobileRequest request){
        log.info("start login mobile ... ");
        Boolean isLogin = Boolean.FALSE;
        try {
            var userAuthentication = userManagementService.getUserAuthenticationByUsername(GetUserAuthenticationRequest.builder()
                    .username(request.getUsername())
                    .build());
            log.info("data userAuth : {}", userAuthentication);
            if (Objects.nonNull(userAuthentication.getUserAuthentication())) {
                var userAuth = userAuthentication.getUserAuthentication();
                var userProfile = userManagementService.getUserProfileById(GetUserProfileRequest.builder()
                            .userProfileId(userAuth.getId())
                        .build());
                log.info("data userProfile : {}", userProfile);

                var accountUser = myAccountManagementService.getAccountUser(GetMutasiByAccountNumberRequest.builder()
                        .userProfileId(userProfile.getUserProfile().getId())
                        .build());
                log.info("data userAccount : {}", accountUser);

                if (passwordEncoder.matches(request.getPassword(), userAuth.getPassword())) {
                    isLogin = Boolean.TRUE;
                    return LoginMobileResponse.builder()
                            .fullName(userProfile.getUserProfile().getFullName())
                            .accountNumber(accountUser.getAccountNumber())
                            .balance(accountUser.getBalance())
                            .isLogin(isLogin)
                            .build();
                }
                return LoginMobileResponse.builder()
                        .fullName(userProfile.getUserProfile().getFullName())
                        .accountNumber(accountUser.getAccountNumber())
                        .balance(accountUser.getBalance())
                        .isLogin(isLogin)
                        .build();
            }
            return null;
        } catch (Exception e) {
            throw new RuntimeException("error when login mobile");
        }
    }
}
