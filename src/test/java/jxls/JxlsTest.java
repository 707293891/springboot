package jxls;

import org.junit.Test;
import org.jxls.area.XlsArea;
import org.jxls.command.EachCommand;
import org.jxls.command.IfCommand;
import org.jxls.common.CellRef;
import org.jxls.common.Context;
import org.jxls.transform.Transformer;
import org.jxls.util.JxlsHelper;
import org.jxls.util.TransformerFactory;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author 范超
 * @version V1.0
 * @Title JxlsTest
 * @Package jxls
 * @Descript :TODO()
 * @date : 2018/6/25  上午9:56
 */
public class JxlsTest {
    InputStream is=Thread.currentThread().getContextClassLoader().getResourceAsStream("excelTemplates/template.xls");
    OutputStream os=new FileOutputStream(new File("/Users/fanchao/Desktop/object_collection_template.xls"));

    public JxlsTest() throws FileNotFoundException {
        String url=Thread.currentThread().getContextClassLoader().getResource("excelTemplates/result").getFile();
        os=new FileOutputStream(new File(url+"/result.xls"));
    }

    public void myTest() throws IOException {
        Transformer transformer = TransformerFactory.createTransformer(is, os);
        XlsArea xlsArea=new XlsArea("Sheet1!A1:F3",transformer);
        XlsArea employeeArea = new XlsArea("Sheet1!A3:F3", transformer);
        employeeArea.addAreaListener(new SimpleAreaListener(employeeArea));
        EachCommand eachCommand=new EachCommand("item","datas",employeeArea);
        xlsArea.addCommand("A3:F3", eachCommand);
        Context context = new Context();
        Calendar calendar=Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR,-7);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Map map=new HashMap();
       // map.put("list",getData());
        map.put("week",calendar.get(Calendar.WEEK_OF_MONTH));
        map.put("month",calendar.get(Calendar.MONTH)+1);
        context.putVar("print", map);
        context.putVar("datas",getData());
        xlsArea.applyAt(new CellRef("Sheet1!A1"), context);
        transformer.write();
    }

    public void test() throws IOException {
        Transformer transformer = TransformerFactory.createTransformer(is, os);
       // XlsArea xlsArea = new XlsArea("Sheet1!E4:E100", transformer);
        Calendar calendar=Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR,-7);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        List prints=getData();
        Map map=new HashMap();
        map.put("list",prints);
        map.put("week",calendar.get(Calendar.WEEK_OF_MONTH));
        map.put("month",calendar.get(Calendar.MONTH));
       // xlsArea.addAreaListener(new SimpleAreaListener());
        Context context = new Context();
        context.putVar("print", map);
        JxlsHelper.getInstance().processTemplate(context,transformer);
        //transformer.write();
    }
    private List getData(){
        List list=new ArrayList();
        for (int i=0;i<12;i++){
            Map map =new HashMap();
            map.put("name","我是名字"+i);
            map.put("time","2018-11-11");
            map.put("info","我是信息");
            map.put("dataInfo","我是数据信息0");
            map.put("note","我是备注信息");
            list.add(map);
        }
        return list;
    }
}
