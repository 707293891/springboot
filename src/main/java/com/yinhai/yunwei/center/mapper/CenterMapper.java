package com.yinhai.yunwei.center.mapper;

import com.yinhai.yunwei.yunwei.mapper.YunweiInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author 范超
 * @version V1.0
 * @Title HbzghMapper
 * @Package com.yinhai.yunwei.center.mapper
 * @Descript :TODO()
 * @date : 2018/6/22  上午10:35
 */

public interface CenterMapper {
    @Select("select name,info,\n" +
            "'会员数据量：'||member||chr(10)||'单位数据量：'||company||chr(10)||'工会数据量：'||unionData as datainfo,note from (\n" +
            "  select  '数据资源中心' as name,'运行良好' as info,'无' as note,\n" +
            "    (select count(1) from a01) as member,(select count(1) from b01) as company,(select count(1) from b02) as unionData from dual\n" +
            ")")
    YunweiInfo count();
}
