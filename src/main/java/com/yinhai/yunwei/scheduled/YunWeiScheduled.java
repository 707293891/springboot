package com.yinhai.yunwei.scheduled;

import com.yinhai.yunwei.center.mapper.CenterMapper;
import com.yinhai.yunwei.email.EmailSend;
import com.yinhai.yunwei.hbzgh.mapper.HbzghMapper;
import com.yinhai.yunwei.yunwei.mapper.YunweiMapper;
import com.yinhai.yunwei.zh.mapper.ZhMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

/**
 * @author 范超
 * @version V1.0
 * @Title YunWeiScheduled
 * @Package com.yinhai.yunwei.scheduled
 * @Descript :TODO()
 * @date : 2018/6/26  上午11:33
 *
 *   0 0 3 * * ?     每天3点执行
 *   0 5 3 * * ?     每天3点5分执行
 *   0 5 3 ? * *     每天3点5分执行，与上面作用相同
 *   0 5/10 3 * * ?  每天3点的 5分，15分，25分，35分，45分，55分这几个时间点执行
 *   0 10 3 ? * 1    每周星期天，3点10分 执行，注：1表示星期天
 *   0 10 3 ? * 1#3  每个月的第三个星期，星期天 执行，#号只能出现在星期的位置
 *     "0 0 * * * *"                      表示每小时0分0秒执行一次
 *
 *
 */

@Component
public class YunWeiScheduled {
    private Logger logger=LoggerFactory.getLogger(YunWeiScheduled.class);
    /**
     * 周一到周五 每天统计数据
     * 每天23：00执行统计数据
     */
    @Autowired
    private HbzghMapper hbzghMapper;
    @Autowired
    private CenterMapper centerMapper;
    @Autowired
    private ZhMapper zhMapper;
    @Autowired
    private YunweiMapper yunweiMapper;
    @Scheduled(cron = "0 0 23 * * 2-6")
    public void countData(){
        logger.info("开始统计数据");
        yunweiMapper.insertInfo(hbzghMapper.count());
        yunweiMapper.insertInfo(centerMapper.count());
        yunweiMapper.insertInfo(zhMapper.count());
        logger.info("统计数据完成");
    }
    @Autowired
    private EmailSend emailSend;
    /**
     * 设置收件人
     * @param message
     * @throws MessagingException
     */
    @Value("${mail.recipients}")
    private String recipients;
    /**
     * 周一发送邮件
     */
    @Scheduled(cron = "0 0 8 * * 2")
    public void sendEmail(){
        logger.info("开始发送邮件");
        try {
            emailSend.sendEmail(recipients);
        } catch (MessagingException e) {
            logger.error("邮件创建失败",e);
        } catch (IOException e) {
            logger.error("io异常",e);
        }
        logger.info("邮件发送完成");
    }

    /**
     * 邮件预览
     */
    @Value("${myemail}")
    private String myEmail;
    @Scheduled(cron = "0 0 17 * * 6")
    public void sendMyEmail(){
        logger.info("开始给自己发送邮件");
        try {
            emailSend.sendEmail(myEmail);
        } catch (MessagingException e) {
            logger.error("邮件创建失败",e);
        } catch (IOException e) {
            logger.error("io异常",e);
        }
        logger.info("自我邮件发送完成");
    }

    @Scheduled(cron = "0 0 18 * * 2-6")
    public void validateMysql(){
        logger.info("开始验证mysql数据库");
        List list=zhMapper.getAllTables("STU");
        if(list.size()!=2){
            try {
                emailSend.sendMysqlChange(myEmail);
            } catch (MessagingException e) {
                logger.error("邮件创建失败",e);
            } catch (IOException e) {
                logger.error("io异常",e);
            }
        }
        logger.info("mysql数据库验证完成");
    }
}
