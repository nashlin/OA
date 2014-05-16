package com.itheima.utils;

import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ExportExcelUtils {

	
	/**
	 * @param title��excel�ļ�����
	 * @param headers����ͷ
	 * @param dataset��Ҫ���浽���Ķ��󼯺�
	 * @param attrList������Ҫ���������
	 * @param out�����Ŀ�ĵ�
	 */
	public static void exportExcel(String title, String[] headers, Collection dataset,String attrList[], OutputStream out) {
		
		// ����һ��������
		Workbook workbook = new HSSFWorkbook();
		
		// ����һ�����
		Sheet sheet = workbook.createSheet(title);
		
		// ���ñ��Ĭ���п��Ϊ15
		sheet.setDefaultColumnWidth((short) 15);
		
		// ������ͷ
		Row row = sheet.createRow(0);
		
		//�����ͷ����
		for (short i = 0; i < headers.length; i++) {
			Cell cell = row.createCell(i);
			//������ʽ
			cell.setCellStyle(createHeaderStyle(workbook));
			HSSFRichTextString text = new HSSFRichTextString(headers[i]);
			cell.setCellValue(text);
		}

		int index = 1;
		for(Object bean : dataset){
			//�õ�һ��bean�������ɱ���һ��
			row = sheet.createRow(index++);
			for(int i=0;i<attrList.length;i++){
				PropertyDescriptor pd = null;
				try{
					pd = new PropertyDescriptor(attrList[i],bean.getClass());
				}catch (Exception e) {
					throw new RuntimeException("bean��û�����ԣ�" + attrList[i]);
				}
				
				//�õ�bean������ֵ
				Object attrValue = null;
				try {
					attrValue = pd.getReadMethod().invoke(bean, null);
				} catch (Exception e) {
					throw new RuntimeException("�޷���ȡbean������ֵ��" + pd.getName());
				} 
				
				//ת���ַ���
				String cellValue = "";
				if(attrValue instanceof Date){
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
					cellValue = df.format(attrValue);
				}else{
					if(attrValue!=null){
						cellValue = attrValue.toString();
					}
				}
				
				Cell cell = row.createCell(i);
				cell.setCellStyle(createDataStyle(workbook));
				cell.setCellValue(cellValue);
			}
		}
		try {
			workbook.write(out);
		} catch (IOException e) {	
			throw new RuntimeException(e);
		}
	}
	
	private static CellStyle createHeaderStyle(Workbook workbook){
		// ����һ����ʽ
		CellStyle style = workbook.createCellStyle();

		// ���ñ�ͷ����ʽ
		style.setFillForegroundColor(HSSFColor.BLUE.index);
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);

		// ���ɱ�ͷ������
		Font font = workbook.createFont();
		font.setColor(HSSFColor.VIOLET.index);
		font.setFontHeightInPoints((short) 12);
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		// ������Ӧ�õ���ǰ����ʽ
		style.setFont(font);
		return style;
	}
	
	private static CellStyle createDataStyle(Workbook workbook){
		
		// ���������е���ʽ
		CellStyle style = workbook.createCellStyle();
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		// ���������е�����
		Font font = workbook.createFont();
		font.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
		// ������Ӧ�õ���ǰ����ʽ
		style.setFont(font);
		return style;
	}

}
