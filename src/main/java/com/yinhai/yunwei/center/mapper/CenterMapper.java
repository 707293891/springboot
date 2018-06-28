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
    @Select("********************")
    YunweiInfo count();
}
