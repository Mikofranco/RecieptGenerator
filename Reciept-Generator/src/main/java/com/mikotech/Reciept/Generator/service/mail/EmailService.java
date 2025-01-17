package com.mikotech.Reciept.Generator.service.mail;


import com.mikotech.Reciept.Generator.dto.request.SendEmailRequest;
import com.mikotech.Reciept.Generator.dto.response.SendEmailResponse;

public interface EmailService {
    SendEmailResponse sendEmail(SendEmailRequest sendEmailRequest);
}
