package com.rainycrying.nginxavailability.Services;


public interface MailService {

    void sendMessageMail(Object params, String title, String templateName);

}
