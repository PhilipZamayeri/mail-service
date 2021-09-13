package com.example.service.Email;

import com.example.service.customerOrder.CustomerOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class EmailController {

    @Autowired
    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/send/{email}")
    public String sendEmail(@PathVariable("email") String email) throws IOException {
        return emailService.sendEmail(email);
    }

    @PostMapping("/sendObj")
    public String sendEmailOrder(@RequestBody CustomerOrder order) throws IOException {

        emailService.sendEmailOrderObj(order);
        return "shue";
    }
}