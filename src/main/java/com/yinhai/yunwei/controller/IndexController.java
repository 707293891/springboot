package com.yinhai.yunwei.controller;

import com.yinhai.yunwei.center.mapper.CenterMapper;
import com.yinhai.yunwei.email.EmailSend;
import com.yinhai.yunwei.excel.ExcelCreate;
import com.yinhai.yunwei.yunwei.mapper.YunweiMapper;
import com.yinhai.yunwei.zh.mapper.ZhMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.mail.MessagingException;
import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author 范超
 * @version V1.0
 * @Title IndexController
 * @Package com.yinhai.yunwei.controller
 * @Descript :TODO()
 * @date : 2018/6/22  上午10:37
 */
@Controller
public class IndexController {
    @Autowired
    private CenterMapper centerMapper;
    @Autowired
    private ZhMapper zhMapper;
    @Autowired
    private EmailSend emailSend;
    @RequestMapping("index.do")
    public String index() throws MessagingException, IOException {
        return "index";
    }
    @Autowired
    private YunweiMapper yunweiMapper;
    @RequestMapping("info.do")
    @ResponseBody
    public List info(){
        Calendar calendar=Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR,-7);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        List list=yunweiMapper.info(sdf.format(calendar.getTime()));
        return list;
    }
}
