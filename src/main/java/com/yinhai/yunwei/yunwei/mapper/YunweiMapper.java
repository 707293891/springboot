package com.yinhai.yunwei.yunwei.mapper;

import org.apache.ibatis.annotations.*;

import java.sql.Date;
import java.util.List;
import java.util.Map;

/**
 * @author 范超
 * @version V1.0
 * @Title YunweiMapper
 * @Package com.yinhai.yunwei.yunwei.mapper
 * @Descript :TODO()
 * @date : 2018/6/22  下午3:07
 */
public interface YunweiMapper {
    @Select("select * from info where time >= to_date(#{date},'yyyy-MM-dd')")
    List<YunweiInfo> info(@Param(value = "date") String date);

    @Insert("insert into info (name,time,info,dataInfo,note) values(#{name},sysdate,#{info},#{dataInfo},#{note})")
    void insertInfo(YunweiInfo info);
}
