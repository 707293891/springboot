package com.yinhai.yunwei.zh;

import com.yinhai.yunwei.zh.mapper.ZhMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author 范超
 * @version V1.0
 * @Title SqlCreate
 * @Package com.yinhai.yunwei.zh
 * @Descript :TODO()
 * @date : 2018/6/26  下午2:49
 */
@Component
public class SqlCreate {
    @Autowired
    private ZhMapper zhMapper;

    /**
     * select name, info,\n" +
     *             "'会员数据量：'||member||chr(10)||'单位数据量：'||company||chr(10)||'工会数据量：'||unionData as datainfo,note from (\n" +
     *             "  select  '湖北省总工会信息管理系统' as name,'运行良好' as info,'无' as note,\n" +
     *             "    (select count(1) from a01) as member,(select count(1) from b01) as company,(select count(1) from b02) as unionData from dual\n" +
     *             ")")
     * @return
     */
    public String createSql(){
        StringBuilder builder=new StringBuilder();
        builder.append("select name,info,");
        builder.append("'人员基础信息表(A_PERSONAL_BASE)：'||baseData||chr(10)||" +
                "'人员基础信息表(A_PERSONAL_BASE_YINHAI)：'||yinhaiData as dataInfo,note from ( select '纵横数据交换数据库' as name ,'只有人员基础数据' as info,'纵横mysql数据表情况：'||chr(10)||'" +
                "'目前只有人员基础信息，暂无工会和单位数据' as note,");
        builder.append("(select count(1) from A_PERSONAL_BASE) as baseData,");
        builder.append("(select count(1) from A_PERSONAL_BASE_YINHAI) as yinhaiData) a");
        return builder.toString();
    }
}
