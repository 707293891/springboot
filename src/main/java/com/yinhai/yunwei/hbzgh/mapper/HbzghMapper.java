package com.yinhai.yunwei.hbzgh.mapper;

import com.yinhai.yunwei.yunwei.mapper.YunweiInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author 范超
 * @version V1.0
 * @Title HbzghMapper
 * @Package com.yinhai.yunwei.hbzgh.mapper
 * @Descript :TODO()
 * @date : 2018/6/22  上午11:27
 */
public interface HbzghMapper {
    @Select("select name,info,\n" +
            "'会员数据量：'||member||chr(10)||'单位数据量：'||company||chr(10)||'工会数据量：'||unionData as datainfo,note from (\n" +
            "  select  '湖北省总工会信息管理系统' as name,'运行良好' as info,'无' as note,\n" +
            "    (select count(1) from a01) as member,(select count(1) from b01) as company,(select count(1) from b02) as unionData from dual\n" +
            ")")
    public YunweiInfo count();

}
