package com.example.service.Email;

import com.example.service.customerOrder.Customer;
import com.example.service.customerOrder.CustomerOrder;
import com.example.service.customerOrder.Products;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.List;

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

    public void sendEmailOrderObj(CustomerOrder order) throws IOException {

        String orderToMail = customerToEmail(order) + printList(order.getProductsList());

        Email from = new Email("hakimlivsonline@gmail.com");
        Email to = new Email(order.getCustomer().getEmail());

        String subject = "Tack för din beställning!";
        Content content = new Content("text/html", orderToMail);

        Mail mail = new Mail(from, subject, to, content);

        Request request = new Request();

        request.setMethod(Method.POST);
        request.setEndpoint("mail/send");
        request.setBody(mail.build());

        Response response = sendGrid.api(request);

        System.out.println(response.getStatusCode());
        System.out.println(response.getHeaders());
        System.out.println(response.getBody());
    }

    private String printList(List<Products> productsList){
        String products = "";
        int nr = 1;
        int totalCost = 0;

        for (Products p : productsList){
            products += nr++ + ". " + p + " kr <br>";
            totalCost += p.getProduct().getPrice();
        }
        return "<br>Din order: " + "<br>" + products + "<br>" +
                "Totalpris: " + totalCost + " kr";
    }

    private String customerToEmail(CustomerOrder customer){
        return "Kunduppgifter: " + "<br>" +
                customer.getCustomer().getFirstName() + " " + customer.getCustomer().getLastName() + "<br>" +
                customer.getCustomer().getEmail() + "<br>" +
                customer.getCustomer().getPhoneNumber() + "<br>" +
                customer.getCustomer().getAdress() + "<br>" +
                customer.getCustomer().getCity().getName()+ "<br>" +
                customer.getCustomer().getZipcode() + "<br>";
    }

}
