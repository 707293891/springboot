package com.yinhai.yunwei.yunwei.mapper;

import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 * @author 范超
 * @version V1.0
 * @Title YunweiInfo
 * @Package com.yinhai.yunwei.yunwei.mapper
 * @Descript :TODO()
 * @date : 2018/6/22  下午3:46
 */
public class YunweiInfo {
    private String name;
    private Date time;
    private String info;
    private String dataInfo;
    private String note;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日");
        return sdf.format(this.time);
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getDataInfo() {
        return dataInfo;
    }

    public void setDataInfo(String dataInfo) {
        this.dataInfo = dataInfo;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "YunweiInfo{" +
                "name='" + name + '\'' +
                ", time=" + time +
                ", info='" + info + '\'' +
                ", dataInfo='" + dataInfo + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
