//package com.diros.util;
//
//import java.io.File;
//import java.util.Date;
//import java.util.Properties;
//
//import javax.activation.DataHandler;
//import javax.activation.FileDataSource;
//import javax.mail.Authenticator;
//import javax.mail.Message;
//import javax.mail.Multipart;
//import javax.mail.PasswordAuthentication;
//import javax.mail.Session;
//import javax.mail.Transport;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeBodyPart;
//import javax.mail.internet.MimeMessage;
//import javax.mail.internet.MimeMultipart;
//import javax.mail.internet.MimeUtility;
//
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.core.io.Resource;
//import org.springframework.core.io.support.PropertiesLoaderUtils;
//
///**
// * é‚®ä»¶å�‘é€�å·¥å…·ç±»
// * @author Administrator
// *
// */
//public class EmailSender {
//    private static final String charset = "GBK";
//    private static final String defaultMimetype = "text/plain";
//
//    /**
//     * å�‘é€�é‚®ä»¶
//     * @param receiver æ”¶ä»¶äºº
//     * @param subject æ ‡é¢˜
//     * @param mailContent é‚®ä»¶å†…å®¹
//     * @param mimetype å†…å®¹ç±»åž‹ é»˜è®¤ä¸ºtext/plain,å¦‚æžœè¦�å�‘é€�HTMLå†…å®¹,åº”è®¾ç½®ä¸ºtext/html
//     * @throws Exception 
//     */
//    public static void send(String receiver, String subject, String mailContent, String mimetype) throws Exception {
//    	send(new String[]{receiver}, subject, mailContent, mimetype);
//    }
//    /**
//     * å�‘é€�é‚®ä»¶
//     * @param receivers æ”¶ä»¶äºº
//     * @param subject æ ‡é¢˜
//     * @param mailContent é‚®ä»¶å†…å®¹
//     * @param mimetype å†…å®¹ç±»åž‹ é»˜è®¤ä¸ºtext/plain,å¦‚æžœè¦�å�‘é€�HTMLå†…å®¹,åº”è®¾ç½®ä¸ºtext/html
//     * @throws Exception 
//     */
//    public static void send(String[] receivers, String subject, String mailContent, String mimetype) throws Exception {
//    	send(receivers, subject, mailContent, null, mimetype);
//    }
//    /**
//     * å�‘é€�é‚®ä»¶
//     * @param receivers æ”¶ä»¶äºº
//     * @param subject æ ‡é¢˜
//     * @param mailContent é‚®ä»¶å†…å®¹
//     * @param attachements é™„ä»¶
//     * @param mimetype å†…å®¹ç±»åž‹ é»˜è®¤ä¸ºtext/plain,å¦‚æžœè¦�å�‘é€�HTMLå†…å®¹,åº”è®¾ç½®ä¸ºtext/html
//     * @throws Exception 
//     */
//    public static void send(String[] receivers, String subject, String mailContent, File[] attachements, String mimetype) throws Exception {
//        try {
//            Resource resource = new ClassPathResource("config/email.properties");
//            final Properties props = PropertiesLoaderUtils.loadProperties(resource);
//            
//            Session session = Session.getDefaultInstance(props, new Authenticator() {
//                protected PasswordAuthentication getPasswordAuthentication() {
//                    return new PasswordAuthentication(props.getProperty("mail.userName"),props.getProperty("mail.password"));//ç™»å½•ç”¨æˆ·å��/å¯†ç �
//                }
//            });
//            
//            MimeMessage mimeMessage = new MimeMessage(session);
//            mimeMessage.setFrom(new InternetAddress(props.getProperty("mail.from")));//å�‘ä»¶äººé‚®ä»¶
//
//            InternetAddress[] toAddress = new InternetAddress[receivers.length];
//            for (int i=0; i<receivers.length; i++) {
//                toAddress[i] = new InternetAddress(receivers[i]);
//            }
//            mimeMessage.setRecipients(Message.RecipientType.TO, toAddress);//æ”¶ä»¶äººé‚®ä»¶
//            mimeMessage.setSubject(subject, charset);
//            
//            Multipart multipart = new MimeMultipart();
//            //æ­£æ–‡
//            MimeBodyPart body = new MimeBodyPart();
//           // body.setText(message, charset);ä¸�æ”¯æŒ�html
//            body.setContent(mailContent, (mimetype!=null && !"".equals(mimetype) ? mimetype : defaultMimetype)+ ";charset="+ charset);
//            multipart.addBodyPart(body);//å�‘ä»¶å†…å®¹
//            //é™„ä»¶
//            if(attachements!=null){
//	            for (File attachement : attachements) {
//	                MimeBodyPart attache = new MimeBodyPart();
//	               //ByteArrayDataSource bads = new ByteArrayDataSource(byte[],"application/x-any");
//	                attache.setDataHandler(new DataHandler(new FileDataSource(attachement)));
//	                String fileName = getLastName(attachement.getName());
//	                attache.setFileName(MimeUtility.encodeText(fileName, charset, null));
//	                multipart.addBodyPart(attache);
//	            }
//            }
//            mimeMessage.setContent(multipart);
//            mimeMessage.setSentDate(new Date());
//            Transport.send(mimeMessage);
//        } catch (Exception e) {
//        	e.printStackTrace();
//        	throw e;
//        }
//    }
//
//    private static String getLastName(String fileName) {
//        int pos = fileName.lastIndexOf("\\");
//        if (pos > -1) {
//            fileName = fileName.substring(pos + 1);
//        }
//        pos = fileName.lastIndexOf("/");
//        if (pos > -1) {
//            fileName = fileName.substring(pos + 1);
//        }
//        return fileName;
//    }
//}
