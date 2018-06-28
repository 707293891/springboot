package com.yinhai.yunwei.excel;

import com.yinhai.yunwei.yunwei.mapper.YunweiInfo;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.jxls.area.Area;
import org.jxls.area.XlsArea;
import org.jxls.common.AreaListener;
import org.jxls.common.CellRef;
import org.jxls.common.Context;
import org.jxls.transform.poi.PoiTransformer;

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
        if (cellRef1.getCol()!=3&&cellRef1.getCol()!=5){
            return;
        }
        Workbook workbook=transformer.getWorkbook();
        Cell cell=workbook.getSheet(cellRef1.getSheetName()).getRow(cellRef1.getRow()).getCell(cellRef1.getCol());
        CellStyle cellStyle=cell.getCellStyle();
        Font font=workbook.createFont();
        CellStyle resultCell=workbook.createCellStyle();
        Object item=context.getVar("item");
        if(item!=null&&item instanceof YunweiInfo &&"纵横数据交换数据库".equals(((YunweiInfo) item).getName())){
            font.setColor(XSSFFont.COLOR_RED);
            resultCell.setFont(font);
            cell.setCellStyle(resultCell);
        }
    }

}
