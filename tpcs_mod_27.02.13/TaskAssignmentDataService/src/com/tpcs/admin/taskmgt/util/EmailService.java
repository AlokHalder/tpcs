/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tpcs.admin.taskmgt.util;

import java.util.Properties;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author ALOK
 */
public class EmailService {

    public String sendEmail(int associateId, String msg) throws Exception {

        String emailMessage = "";
        Transport transport = null;

        try {
             Properties props = System.getProperties();
            props.setProperty("mail.transport.protocol", "smtp");
            props.setProperty("mail.host", "mail.tpcsglobal.com");
            props.put("mail.smtp.port", "25");
            props.put("mail.smtp.auth", "true");
            props.setProperty("mail.user", "hrd@tpcsglobal.com");
            props.setProperty("mail.password", "Global#@!");


            Session mailSession = Session.getDefaultInstance(props, null);
            mailSession.setDebug(true);
            transport = mailSession.getTransport("smtp");
            MimeMessage message = new MimeMessage(mailSession);
            message.setSentDate(new java.util.Date());
            message.setSubject("The Office Entering Time:" + associateId);
            message.setFrom(new InternetAddress("hrd@tpcsglobal.com"));

            //message.setRecipient(Message.RecipientType.TO, new InternetAddress(sendTo));
            //message.setRecipient(Message.RecipientType.CC, new InternetAddress("admin@theprofessionaltutors.com"));
            message.setRecipient(Message.RecipientType.BCC, new InternetAddress("alokhalder@gmail.com"));
            //message.setRecipient(Message.RecipientType.TO, new InternetAddress("sanando.career@gmail.com"));

            MimeMultipart multipart = new MimeMultipart("related");
            BodyPart messageBodyPart = new MimeBodyPart();


            String content = "<html><head><title>"
                    + message.getSubject()
                    + "</title></head><body><h4>"
                    + message.getSubject()
                    + "<p>To login, visit http://www.tpcsglobal.com </p>"
                    + "<p>Assuring you of our best, fast & effective education services </p>"
                    + "<p>&nbsp;</p>"
                    + "The Office Enter of Empolyee"
                    + associateId + ":" + msg
                    + "<p>Warm Regards</p>"
                    + "<p>The Professional Consultancy Services</p>"
                    + "<p>Land Phone : (033) 65400826 Mobile:919163527795</p>"
                    + "</body></html>";

            //  String content  = goDaddySubjectContent(message,membershipId,senderName, sendTo ,userName,password);
            messageBodyPart.setContent(content, "text/html");
            multipart.addBodyPart(messageBodyPart);
            message.setContent(multipart);

            transport.connect("mail.tpcsglobal.com", "hrd@tpcsglobal.com", "Global#@!");
            // setHTMLContent(message,membershipId,senderName, sendTo,userName,password);
            message.saveChanges(); // don't forget this
            transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
            //transport.sendMessage(message, message.getRecipients(Message.RecipientType.CC));
            //transport.sendMessage(message, message.getRecipients(Message.RecipientType.BCC));

            System.out.println("Mail Sent  ");


        } catch (MessagingException messagingException) {
            emailMessage = messagingException.getMessage();
        } catch (Exception e) {
            emailMessage = e.getMessage();

            e.printStackTrace();
        }
        return emailMessage;
    }
     public String sendEmailGriveance(int associateId, String msg,String sendTo) throws Exception {

        String emailMessage = "";
        Transport transport = null;

        try {
             Properties props = System.getProperties();
            props.setProperty("mail.transport.protocol", "smtp");
            props.setProperty("mail.host", "mail.tpcsglobal.com");
            props.put("mail.smtp.port", "25");
            props.put("mail.smtp.auth", "true");
            props.setProperty("mail.user", "hrd@tpcsglobal.com");
            props.setProperty("mail.password", "Global#@!");


            Session mailSession = Session.getDefaultInstance(props, null);
            mailSession.setDebug(true);
            transport = mailSession.getTransport("smtp");
            MimeMessage message = new MimeMessage(mailSession);
            message.setSentDate(new java.util.Date());
            message.setSubject("The Grivance Of " + associateId);
            message.setFrom(new InternetAddress("hrd@tpcsglobal.com"));

            message.setRecipient(Message.RecipientType.TO, new InternetAddress("hr@tpcsglobal.com"));
            //message.setRecipient(Message.RecipientType.CC, new InternetAddress("admin@theprofessionaltutors.com"));
            message.setRecipient(Message.RecipientType.CC, new InternetAddress("alokhalder@gmail.com"));
            message.setRecipient(Message.RecipientType.BCC, new InternetAddress(sendTo));
            //message.setRecipient(Message.RecipientType.TO, new InternetAddress("sanando.career@gmail.com"));

            MimeMultipart multipart = new MimeMultipart("related");
            BodyPart messageBodyPart = new MimeBodyPart();


            String content = "<html><head><title>"
                    + message.getSubject()
                    + "</title></head><body><h4>"
                    + message.getSubject()
                    + "<p>To login, visit http://www.tpcsglobal.com </p>"
                    + "<p>Assuring you of our best, fast & effective education services </p>"
                    + "<p>&nbsp;</p>"
                    + "The Grivance of the Employee :"+associateId
                    + "<p><B>" +msg+"</B></p>"
                    + "<p>Warm Regards</p>"
                    + "<p>The Professional Consultancy Services</p>"
                    + "<p>Land Phone : (033) 65400826 Mobile:919163527795</p>"
                    + "</body></html>";

            //  String content  = goDaddySubjectContent(message,membershipId,senderName, sendTo ,userName,password);
            messageBodyPart.setContent(content, "text/html");
            multipart.addBodyPart(messageBodyPart);
            message.setContent(multipart);

            transport.connect("mail.tpcsglobal.com", "hrd@tpcsglobal.com", "Global#@!");
            // setHTMLContent(message,membershipId,senderName, sendTo,userName,password);
            message.saveChanges(); // don't forget this
            transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
            transport.sendMessage(message, message.getRecipients(Message.RecipientType.CC));
            transport.sendMessage(message, message.getRecipients(Message.RecipientType.BCC));
            emailMessage="Mail Sent Successfully";
            System.out.println("Mail Send Successfully ");


        } catch (MessagingException messagingException) {
            emailMessage = messagingException.getMessage();
        } catch (Exception e) {
            emailMessage = e.getMessage();

            e.printStackTrace();
        }
        return emailMessage;
    }
}
