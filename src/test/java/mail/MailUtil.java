package mail;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailUtil {
	String username="707293891@qq.com";
	String password="avrnxkweblnubebd";
	public void sendMail(String mail){
		Properties prop=new Properties();
		prop.setProperty("mail.host","smtp.aliyun.com");
		prop.setProperty("mail.smtp.auth", "true");
		Authenticator auth=new Authenticator(){
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {

				return new PasswordAuthentication(username, 
						password);
			}
			//������javax.mail��	
		};
		Session session=Session.getInstance(prop,auth);
		MimeMessage message=new MimeMessage(session);
		try {

			message.setFrom(new InternetAddress(username));

			message.setRecipients(RecipientType.TO, mail);

			message.setSubject("1515555155151");
			message.setContent("5151515151515","text/html;charset=utf-8");
			Transport.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}
