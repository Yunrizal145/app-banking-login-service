package com.spring.loginservice.service;

import com.spring.usermanagementservice.dto.GetUserAuthenticationRequest;
import com.spring.usermanagementservice.dto.GetUserAuthenticationResponse;
import com.spring.usermanagementservice.dto.GetUserProfileRequest;
import com.spring.usermanagementservice.dto.GetUserProfileResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class UserManagementService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${url.getUserProfile}")
    private String getUserProfileUrl;

    @Value("${url.getUserProfileById}")
    private String getUserProfileByIdUrl;

    @Value("${url.getUserAuthentication}")
    private String getUserAuthenticationUrl;

    @Value("${url.getUserAuthenticationByUsername}")
    private String getUserAuthenticationByUsernameUrl;

    public GetUserProfileResponse getUserProfile(GetUserProfileRequest request) {
        log.info("Start getValueFromUserMS ... ");
        log.info("getUserProfile ... ");

        ResponseEntity<GetUserProfileResponse> getUserProfile = restTemplate.postForEntity(getUserProfileUrl, request, GetUserProfileResponse.class);
        return getUserProfile.getBody();
    }

    public GetUserProfileResponse getUserProfileById(GetUserProfileRequest request) {
        log.info("Start getValueFromUserMS ... ");
        log.info("getUserProfile by id ... ");

        ResponseEntity<GetUserProfileResponse> getUserProfile = restTemplate.postForEntity(getUserProfileByIdUrl, request, GetUserProfileResponse.class);
        return getUserProfile.getBody();
    }

    public GetUserAuthenticationResponse getUserAuthentication(GetUserAuthenticationRequest request) {
        log.info("Start getValueFromUserMS ... ");
        log.info("getUserAuthentication ... ");

        ResponseEntity<GetUserAuthenticationResponse> getUserAuthentication = restTemplate.postForEntity(getUserAuthenticationUrl, request, GetUserAuthenticationResponse.class);
        return getUserAuthentication.getBody();
    }

    public GetUserAuthenticationResponse getUserAuthenticationByUsername(GetUserAuthenticationRequest request) {
        log.info("Start getValueFromUserMS ... ");
        log.info("getUserAuthentication by username ... ");

        ResponseEntity<GetUserAuthenticationResponse> getUserAuthentication = restTemplate.postForEntity(getUserAuthenticationByUsernameUrl, request, GetUserAuthenticationResponse.class);
        return getUserAuthentication.getBody();
    }
}
