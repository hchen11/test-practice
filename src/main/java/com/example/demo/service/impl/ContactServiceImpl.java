package com.example.demo.service.impl;

import com.example.demo.dao.ClientUserDao;
import com.example.demo.entity.ClientUser;
import com.example.demo.service.ContactService;
import com.example.demo.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ClientUserDao clientUserDao;

    @Autowired
    private EmailService emailService;

    @Override
    @Transactional
    public ClientUser saveAndSendCommentToReceiver(ClientUser clientUser) {
        ClientUser createClientUser = clientUserDao.save(clientUser);
        emailService.sendContentToReceiver(clientUser.getEmail(), clientUser.getComment());
        return createClientUser;
    }

    @Override
    public Boolean checkContactMessageIsDuplicate(ClientUser clientUser) {
        if (clientUserDao.findClientUserByNameAndCompanyAndAndEmailAndAndComment(clientUser.getName(),
                clientUser.getCompany(),
                clientUser.getEmail(),
                clientUser.getComment()) == null) {
            return Boolean.FALSE;
        } else {
            return Boolean.TRUE;
        }
    }
}
