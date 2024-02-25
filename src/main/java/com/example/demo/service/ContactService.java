package com.example.demo.service;

import com.example.demo.entity.ClientUser;
import org.springframework.stereotype.Service;

public interface ContactService {

    ClientUser  saveAndSendCommentToReceiver (ClientUser clientUser);

    Boolean checkContactMessageIsDuplicate(ClientUser clientUser);
}
