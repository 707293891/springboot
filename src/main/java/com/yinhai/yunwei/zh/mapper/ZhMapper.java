package com.yinhai.yunwei.zh.mapper;

import com.yinhai.yunwei.yunwei.mapper.YunweiInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @author 范超
 * @version V1.0
 * @Title ZhMapper
 * @Package com.yinhai.yunwei.zh.mapper
 * @Descript :TODO()
 * @date : 2018/6/22  上午11:28
 */
public interface ZhMapper {
    @Select("select table_name from information_schema.TABLES where TABLE_SCHEMA=#{database}")
    List<Map> getAllTables(@Param(value = "database") String database);


    @Select("**************")
    YunweiInfo count();
}
