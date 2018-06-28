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
    @Select("*******************")
    public YunweiInfo count();

}
