package com.yinhai.yunwei.email;

import javax.mail.MessagingException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * @author 范超
 * @version V1.0
 * @Title EmailSend
 * @Package com.yinhai.yunwei.email
 * @Descript :TODO()
 * @date : 2018/6/22  下午12:53
 */
public interface EmailSend{
    boolean sendEmail(String recipients) throws MessagingException, IOException;

    void sendMysqlChange(String recipient) throws IOException, MessagingException;
}
