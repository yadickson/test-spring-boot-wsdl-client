package com.example.wsdl.controller;

import com.example.wsdl.UserStatus;
import com.example.wsdl.UserStatusResponse;
import com.example.wsdl.config.WsdlClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service")
public class UserStatusController {

    @Autowired
    private WsdlClient wsdlClient;

    @GetMapping(value = "/user-status")
    public ResponseEntity<String> getUserStatus() {
        UserStatus userStatus = new UserStatus();
        userStatus.setUserId("25446781-2");
        UserStatusResponse response = (UserStatusResponse) wsdlClient.callWebService(userStatus);

        String status = response.getUserStatusResponseReq().getDescription();

        return new ResponseEntity<>(status, HttpStatus.OK);
    }
}
