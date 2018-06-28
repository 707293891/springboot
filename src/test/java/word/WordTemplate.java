package word;


import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.junit.Test;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 范超
 * @version V1.0
 * @Title WordTemplate
 * @Package word
 * @Descript :TODO()
 * @date : 2018/6/28  上午10:21
 */
public class WordTemplate {
    private Configuration cfg;
    OutputStream os;

    {
        cfg=new Configuration(Configuration.VERSION_2_3_27);
        try {
            os=new FileOutputStream(new File("/Users/fanchao/Desktop/wordtemplate.doc"));
            cfg.setDirectoryForTemplateLoading(new File("/Users/fanchao/Desktop/yunwei/src/main/resources/wordTemplate"));
            cfg.setDefaultEncoding("UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void word() throws IOException, TemplateException {
        Map<String, Object> root = new HashMap<>();
        root.put("lizhen", "李震做的事");
        root.put("fc", "范超做的事");
        root.put("liwei", "李委做的事");
        root.put("myc", "马英超做的事");
        Template temp=cfg.getTemplate("wordTemplate.xml");
        Writer out = new OutputStreamWriter(os);
        temp.process(root,out);
    }
}
