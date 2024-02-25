package com.example.demo.controller;

import com.example.demo.dto.ClientUserDTO;
import com.example.demo.entity.ClientUser;
import com.example.demo.service.ContactService;
import com.example.demo.util.ConvertToEntityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/contact/")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @PostMapping("/receiveUserInfo")
    public String receiveUserInfo(ClientUserDTO clientUserDTO) {

        //TODO
        // validate the parameter of clientUserDTO include xss and ddos attack
        // validate(ClientUserDTO clientUserDTO) is duplicate
        ClientUser clientUser = ConvertToEntityUtil.dtoConvertToEntity(clientUserDTO);
        if (!contactService.checkContactMessageIsDuplicate(clientUser)) {
            //if not duplicate ,saveToDB and sendEmail
            contactService.saveAndSendCommentToReceiver(ConvertToEntityUtil.dtoConvertToEntity(clientUserDTO));
            return HttpStatus.OK.name();
        } else {
            return HttpStatus.CONFLICT.name();
        }
    }
}
