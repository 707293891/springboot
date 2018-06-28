package com.yinhai.yunwei;

import com.yinhai.yunwei.center.mapper.CenterMapper;
import com.yinhai.yunwei.hbzgh.mapper.HbzghMapper;
import com.yinhai.yunwei.yunwei.mapper.YunweiMapper;
import com.yinhai.yunwei.zh.SqlCreate;
import com.yinhai.yunwei.zh.mapper.ZhMapper;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class YunweiApplicationTests {
    @Autowired
    private YunweiMapper yunweiMapper;
    @Autowired
    private HbzghMapper hbzghMapper;
    @Autowired
    private CenterMapper centerMapper;
    @Autowired
    private ZhMapper zhMapper;
    @Autowired
    private SqlCreate sqlCreate;
    @Test
    public void contextLoads() throws IOException, InvalidFormatException {
        //System.out.println(zhMapper.count());

    }

}
