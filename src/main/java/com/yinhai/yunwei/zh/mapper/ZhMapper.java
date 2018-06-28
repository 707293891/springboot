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


    @Select("select name,info,concat('人员基础信息表(A_PERSONAL_BASE)：',baseData,convert(char(10),char),'人员基础信息表(A_PERSONAL_BASE_YINHAI)：',yinhaiData) as dataInfo,\n" +
            "note from ( select '纵横数据交换数据库' as name ,'只有人员基础数据' as info,\n" +
            "concat('纵横mysql数据表情况：',convert(char(10),char),'目前只有人员基础信息，暂无工会和单位数据') as note,\n" +
            "(select count(1) from A_PERSONAL_BASE a) as baseData,\n" +
            "(select count(1) from A_PERSONAL_BASE_YINHAI b) as yinhaiData ) a")
    YunweiInfo count();
}
