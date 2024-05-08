package com.authservice.authservice.services;

public interface EmailService {
  void sendEmail(String userEmail, String content);
}
