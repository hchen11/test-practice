package com.example.demo.service;

import org.springframework.stereotype.Service;

public interface EmailService {
    public void sendContentToReceiver(String receiver,String content);
}
