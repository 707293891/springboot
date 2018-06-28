package mail;

import com.yinhai.yunwei.util.CalendarUtil;
import org.junit.Test;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class SendMail
 */
public class SendMail extends HttpServlet{

	public void test(){
		String mail="707293891@qq.com";
		System.out.println(mail);
		MailUtil mu=new MailUtil();
		mu.sendMail(mail);
		System.out.println("���ͳɹ�");	
	}
	public void javaMailSender() {
		Properties prop = new Properties();
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		prop.put("mail.smtp.auth", true);
		prop.put("mail.smtp.starttls.enable", true);
		prop.put("mail.smtp.timeout", 5000);
		mailSender.setUsername("fc18681680583@aliyun.com");
		mailSender.setPassword("920406chao");
		mailSender.setHost("smtp.aliyun.com");

		mailSender.setJavaMailProperties(prop);
		SimpleMailMessage smm = new SimpleMailMessage();
		// 设定邮件参数
		smm.setFrom(mailSender.getUsername());
		smm.setTo("fanchao@yinhai.com");
		smm.setSubject("Hello world");
		smm.setText("Hello world via spring mail sender");
		// 发送邮件
		mailSender.send(smm);
	}

	@Test
	public void calandler() throws AddressException {
		String str="707293891@qq.com,fc18681680583@aliyun.com";
		InternetAddress[] address=InternetAddress.parse(str);
		for (int i=0;i<address.length;i++){
			System.out.println(address[i]);
		}

	}
}
