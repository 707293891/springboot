package com.yinhai.yunwei.excel;

import com.yinhai.yunwei.util.CalendarUtil;
import org.jxls.area.XlsArea;
import org.jxls.command.EachCommand;
import org.jxls.common.CellRef;
import org.jxls.common.Context;
import org.jxls.transform.Transformer;
import org.jxls.util.TransformerFactory;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 范超
 * @version V1.0
 * @Title ExcelCtreate
 * @Package com.yinhai.yunwei.excel
 * @Descript :TODO()
 * @date : 2018/6/22  下午12:39
 */
@Component("excelCreate")
public class ExcelCtreateImpl implements ExcelCreate {
    //private OutputStream os=;

    public ExcelCtreateImpl() throws FileNotFoundException {
    }

    @Override
    public OutputStream excelStream(List list) throws IOException {
        Transformer transformer = TransformerFactory.createTransformer(getFileInputStream(),
                new FileOutputStream(
                        new File(
                                Thread.currentThread().getContextClassLoader().
                                        getResource("excelTemplates/result").getFile()+"/result.xls")));
        XlsArea xlsArea=new XlsArea("Sheet1!A1:F3",transformer);
        XlsArea employeeArea = new XlsArea("Sheet1!A3:F3", transformer);
        employeeArea.addAreaListener(new SimpleAreaListener(employeeArea));
        EachCommand eachCommand=new EachCommand("item","items",employeeArea);
        xlsArea.addCommand("A3:F3", eachCommand);
        Context context = new Context();
        Map map=new HashMap();
        // map.put("list",getData());
        map.put("week",CalendarUtil.getWeekNum());
        map.put("month",CalendarUtil.getMonth());
        context.putVar("print", map);
        context.putVar("items",list);
        xlsArea.applyAt(new CellRef("Sheet1!A1"), context);
        transformer.write();
        return null;
    }
    private InputStream getFileInputStream(){
        return Thread.currentThread().getContextClassLoader().getResourceAsStream("excelTemplates/template.xls");
    }

}
