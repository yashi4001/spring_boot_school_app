package com.springapp.school_app.service;

import com.springapp.school_app.model.Contact;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;


@Service
@Slf4j
//@RequestScope
//@SessionScope
@ApplicationScope
public class ContactService {
    private int counter;

    public ContactService() {
        System.out.println("Contact service bean initialized");
    }

    public boolean saveMessageDetails(Contact contact){
        log.info(contact.toString());
        return true;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}
