package com.example.service.Email;

import com.sendgrid.helpers.mail.objects.Content;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class EmailSend {

    private String sender;
    private String receiver;
    private String subject;
    //    private String message;
    private Content content;

    public EmailSend(String receiver) {
        this.receiver = receiver;
        this.sender = "hakimlivsonline@gmail.com";
        this.subject = "Välkommen till Hakimlivs!";
//        this.message = "Tack för ditt köp!";
        this.content = new Content("text/html", "Tack för att du valt att handla hos Hakim Livs");
    }

}