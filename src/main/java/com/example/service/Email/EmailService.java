package com.example.service.Email;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.io.IOException;

@Slf4j
public class EmailService {


    @Autowired
    private final SendGrid sendGrid;

    public EmailService(SendGrid sendGrid) {
        this.sendGrid = sendGrid;
    }


    public String sendEmail(String email) throws IOException {

        Email from = new Email("hakimlivsonline@gmail.com");
        Email to = new Email(email); // use your own email address here

        String subject = "Kära kund";
        Content content = new Content("text/html", "Tack för att du valt att handla hos Hakim Livs");

        Mail mail = new Mail(from, subject, to, content);


        Request request = new Request();

        request.setMethod(Method.POST);
        request.setEndpoint("mail/send");
        request.setBody(mail.build());

        Response response = sendGrid.api(request);

        System.out.println(response.getStatusCode());
        System.out.println(response.getHeaders());
        System.out.println(response.getBody());

        return "Email sent";

    }
}
