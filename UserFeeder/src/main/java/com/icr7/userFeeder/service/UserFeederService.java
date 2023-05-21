package com.icr7.userFeeder.service;

import com.icr7.model.UserTable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class UserFeederService {
    public void insertUsers(int n){

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        for(int i=1;i<=n;i++){
            UserTable userTable = new UserTable("Admin"+i,"A"+i,"ADMIN");
            HttpEntity<UserTable> httpEntity = new HttpEntity<>(userTable,httpHeaders);
            restTemplate.postForObject("http://localhost:8080/sign-up/add-account",httpEntity,UserTable.class);
        }

        for(int i=1;i<=n;i++){
            UserTable userTable = new UserTable("User"+i,"U"+i,"USER");
            HttpEntity<UserTable> httpEntity = new HttpEntity<>(userTable,httpHeaders);
            restTemplate.postForObject("http://localhost:8080/sign-up/add-account",httpEntity,UserTable.class);
        }
    }
}
