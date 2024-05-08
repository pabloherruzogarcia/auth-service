package com.authservice.authservice.services.impl;


import com.authservice.authservice.services.EmailService;
import com.resend.Resend;
import com.resend.core.exception.ResendException;
import com.resend.services.emails.model.SendEmailRequest;
import org.springframework.beans.factory.annotation.Value;

public class EmailServiceImpl implements EmailService {
  private final Resend resend;

  public EmailServiceImpl(Resend resend, @Value("${resend.apikey}") String apiKey) {
    this.resend = new Resend(apiKey);
  }

  @Override
  public void sendEmail(String userEmail, String content) {
    SendEmailRequest sendEmailRequest = SendEmailRequest.builder()
      .from("Acme <onboarding@resend.dev>")
      .to(userEmail)
      .subject("Hello!")
      .html(content)
      .build();

    try {
      resend.emails().send(sendEmailRequest);
    } catch (ResendException e) {
      e.printStackTrace();
    }
  }
}
