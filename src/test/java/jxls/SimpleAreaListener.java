package jxls;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.jxls.area.Area;
import org.jxls.area.XlsArea;
import org.jxls.common.AreaListener;
import org.jxls.common.CellRef;
import org.jxls.common.Context;
import org.jxls.transform.poi.PoiTransformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * @author 范超
 * @version V1.0
 * @Title SimpleAreaListener
 * @Package jxls
 * @Descript :TODO()
 * @date : 2018/6/25  上午10:22
 */
public class SimpleAreaListener implements AreaListener {
    private Area area;
    PoiTransformer transformer;
    public SimpleAreaListener(XlsArea xlsArea) {
        this.area=xlsArea;
        transformer= (PoiTransformer) xlsArea.getTransformer();
    }

    @Override
    public void beforeApplyAtCell(CellRef cellRef, Context context) {

    }

    @Override
    public void afterApplyAtCell(CellRef cellRef, Context context) {
    }

    @Override
    public void beforeTransformCell(CellRef cellRef, CellRef cellRef1, Context context) {

    }

    @Override
    public void afterTransformCell(CellRef cellRef, CellRef cellRef1, Context context) {
        if (cellRef.getCol()!=3&&cellRef.getCol()!=5){
            return;
        }
        Workbook workbook=transformer.getWorkbook();
        Cell cell=workbook.getSheet(cellRef.getSheetName()).getRow(cellRef.getRow()).getCell(cellRef.getCol());
        CellStyle cellStyle=cell.getCellStyle();
        Font font=workbook.createFont();
        CellStyle resultCell=workbook.createCellStyle();
        Object item=context.getVar("item");
        System.out.println(item instanceof Map);
        System.out.println("我是名字1".equals(((Map) item).get("name")));
        if(item!=null&&item instanceof Map&&"我是名字11".equals(((Map) item).get("name"))){
            font.setColor(XSSFFont.COLOR_RED);
            resultCell.setFont(font);
            cell.setCellStyle(resultCell);
        }
    }

}
