package com.yinhai.yunwei.excel;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * @author 范超
 * @version V1.0
 * @Title ExcelFactory
 * @Package com.yinhai.yunwei.excel
 * @Descript :TODO()
 * @date : 2018/6/22  下午12:40
 */
public interface ExcelCreate {
    public OutputStream excelStream(List list) throws IOException;
}
