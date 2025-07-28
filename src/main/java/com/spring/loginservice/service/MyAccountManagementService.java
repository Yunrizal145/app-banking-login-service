package com.spring.loginservice.service;

import com.spring.myaccountmanagementservice.dto.GetMutasiByAccountNumberRequest;
import com.spring.myaccountmanagementservice.model.AccountUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class MyAccountManagementService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${url.getAccountUser}")
    private String getAccountUserUrl;

    public AccountUser getAccountUser(GetMutasiByAccountNumberRequest request) {
        log.info("Start getValueFromMyAccountMS ... ");
        log.info("getAccountUser ... ");

        ResponseEntity<AccountUser> getAccountUser = restTemplate.postForEntity(getAccountUserUrl, request, AccountUser.class);
        return getAccountUser.getBody();
    }
}
