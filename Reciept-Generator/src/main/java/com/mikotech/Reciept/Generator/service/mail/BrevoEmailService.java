package com.mikotech.Reciept.Generator.service.mail;

import com.mikotech.Reciept.Generator.config.AppConfig;
import com.mikotech.Reciept.Generator.dto.request.SendEmailRequest;
import com.mikotech.Reciept.Generator.dto.response.SendEmailResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.net.URI;
import java.util.List;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.http.MediaType.APPLICATION_JSON;

@Service
public class BrevoEmailService implements EmailService{
    private final AppConfig appConfig;
    private final RestTemplate restTemplate;

    public BrevoEmailService(AppConfig appConfig, RestTemplate restTemplate) {
        this.appConfig = appConfig;
        this.restTemplate = restTemplate;
    }

    @Override
    public SendEmailResponse sendEmail(SendEmailRequest sendEmailRequest) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(APPLICATION_JSON);
        headers.setAccept(List.of(APPLICATION_JSON));
        headers.set("api-key", appConfig.getEmailApiKey());

        RequestEntity<SendEmailRequest> requestEntity =
                new RequestEntity<>(
                        sendEmailRequest,
                        headers,
                        POST,
                        URI.create(appConfig.getEmailServiceUrl()));
        ResponseEntity<SendEmailResponse> emailResponse =
                restTemplate.postForEntity(
                        appConfig.getEmailServiceUrl(),
                        requestEntity,
                        SendEmailResponse.class);

        HttpStatusCode code = emailResponse.getStatusCode();
        SendEmailResponse response = emailResponse.getBody();
        if (response == null) throw new RuntimeException("Failed to send Email");
        response.setStatusCode(code.value());
        return response;
    }
}
