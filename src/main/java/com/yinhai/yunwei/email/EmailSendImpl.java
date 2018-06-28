package com.yinhai.yunwei.email;


import com.yinhai.yunwei.excel.ExcelCreate;
import com.yinhai.yunwei.util.CalendarUtil;
import com.yinhai.yunwei.yunwei.mapper.YunweiInfo;
import com.yinhai.yunwei.yunwei.mapper.YunweiMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.apache.commons.io.IOUtils;


import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.Message.RecipientType;
import javax.mail.internet.*;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @author 范超
 * @version V1.0
 * @Title EmailUtil
 * @Package com.yinhai.yunwei.email
 * @Descript :TODO()
 * @date : 2018/6/22  上午11:56
 */
@Component("emailSend")
public class EmailSendImpl implements EmailSend{
    @Value("${email.user}")
    private String username;
    @Value("${email.password}")
    private String password;
    @Override
    public boolean sendEmail(String recipients) throws MessagingException, IOException {
        MimeMessage message=createMessage();
        setRecipient(message,recipients);
        addBody(message);
        Transport.send(message);
        return true;
    }

    @Override
    public void sendMysqlChange(String recipient) throws IOException, MessagingException {
        MimeMessage message=createMessage();
        setRecipient(message,recipient);
        message.setContent("mysql数据库有变","text/html;charset=utf-8");
        Transport.send(message);
    }

    private void setRecipient(MimeMessage message,String recipients) throws MessagingException {
        message.addRecipients(RecipientType.TO,InternetAddress.parse(recipients));
    }

    /**
     * 创建邮件主体
     * @return
     */
    private MimeMessage createMessage() throws MessagingException, UnsupportedEncodingException {
        Properties prop=new Properties();
        prop.setProperty("mail.host","smtp.qq.com");
        prop.setProperty("mail.smtp.auth", "true");
        Authenticator auth=new Authenticator(){
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username,
                        password);
            }
        };
        Session session=Session.getInstance(prop,auth);
        MimeMessage mimeMessage=new MimeMessage(session);
        mimeMessage.setFrom(new InternetAddress(MimeUtility.encodeText("久远银海(工会组)")+"<"+username+">"));
        mimeMessage.setSubject("湖北省总工会基础库数据运维日志");
        return mimeMessage;
    }
    private void addBody(MimeMessage message) throws IOException, MessagingException {
        MimeMultipart list=new MimeMultipart();
        MimeBodyPart content=new MimeBodyPart();
        content.setContent(createHtml(),"text/html;charset=utf-8");
        list.addBodyPart(content);
        MimeBodyPart filePart=new MimeBodyPart();
        filePart.attachFile(new File(Thread.currentThread().getContextClassLoader().getResource("excelTemplates/result/result.xls").getFile()));
        filePart.setFileName(MimeUtility.encodeText("湖北省总工会基础库数据运维日志"+CalendarUtil.yearMonthWeek()+".xls","UTF-8",null));
        list.addBodyPart(filePart);
        message.setContent(list);
    }



    @Autowired
    public YunweiMapper mapper;

    private String createHtml() throws IOException {
        String temples=IOUtils.toString(Thread.currentThread().getContextClassLoader().getResourceAsStream("template.html"),"utf-8");

        return temples.replaceAll("###date###",CalendarUtil.yearMonthWeek());
    }
    @Autowired
    private ExcelCreate excelCreate;
    private void createExcel() throws IOException {
        List<YunweiInfo> list=mapper.info(CalendarUtil.dateFormate());
        excelCreate.excelStream(list);
    }
}
