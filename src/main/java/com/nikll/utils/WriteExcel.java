/**
 * @program: myautotest
 * @description: WriteExcel
 * @author Nikll
 * @date 2019/5/22 21:29
 */
package com.nikll.utils;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Nikll

 * @date 2019/5/22 21:29

 */
public class WriteExcel {
    private static final String EXCEL_XLS = "xls";
    private static final String EXCEL_XLSX = "xlsx";

    public static void main(String[] args) {

        Map<String, String> dataMap=new HashMap<String, String>();
        dataMap.put("BankName", "BankName111");
        dataMap.put("Addr", "Addr222");
        dataMap.put("Phone", "Phone333");
        List<Map> list=new ArrayList<Map>();
        list.add(dataMap);
        writeExcel(list, 3, "D:/writeExcel.xlsx");

    }

    public static void writeExcel(List<Map> dataList, int cloumnCount,String finalXlsxPath){
        OutputStream out = null;
        try {
            // 获取总列数
            int columnNumCount = cloumnCount;
            // 读取Excel文档
            File finalXlsxFile = new File(finalXlsxPath);
            Workbook workBook = getWorkbok(finalXlsxFile);
            // sheet 对应一个工作页
            Sheet sheet = workBook.getSheetAt(0);
            /**
             * 删除原有数据，除了属性列
             */
            int rowNumber = sheet.getLastRowNum();    // 第一行从0开始算
            System.out.println("原始数据总行数，除属性列：" + rowNumber);
            for (int i = 1; i <= rowNumber; i++) {
                Row row = sheet.getRow(i);
                for (int j = 0; j <cloumnCount ; j++) {
                    System.out.println(row.getCell(j));
                }
                sheet.removeRow(row);
            }
            // 创建文件输出流，输出电子表格：这个必须有，否则你在sheet上做的任何操作都不会有效
            out =  new FileOutputStream(finalXlsxPath);
            workBook.write(out);
            /**
             * 往Excel中写新数据
             */
            for (int j = 0; j < dataList.size(); j++) {
                // 创建一行：从第二行开始，跳过属性列
//                Row row = sheet.createRow(j + 1);
                Row row = sheet.createRow(j);
                // 得到要插入的每一条记录
                Map dataMap = dataList.get(j);
//                while (dataMap.keySet().iterator().hasNext()){
//
//                    for (int i = 0; i < dataMap.keySet().size(); i++) {
//
//                    }Cell first = row.createCell(0);
//                    first.setCellValue(dataMap.keySet().iterator().next().toString());
//
//                    Cell second = row.createCell(1);
//                    second.setCellValue(address);
//
//                    Cell third = row.createCell(2);
//                    third.setCellValue(phone);
//                };
                    Cell first = row.createCell(0);
                    first.setCellValue(dataMap.keySet().toArray()[0].toString());
                System.out.println("dataMap.keySet().toArray()[0].toString()   "+dataMap.keySet().toArray()[0].toString());

                    Cell second = row.createCell(1);
                    second.setCellValue(dataMap.keySet().toArray()[1].toString());
                System.out.println("dataMap.keySet().toArray()[1].toString()   "+dataMap.keySet().toArray()[1].toString());

                    Cell third = row.createCell(2);
                    third.setCellValue(dataMap.keySet().toArray()[2].toString());
                System.out.println("dataMap.keySet().toArray()[2].toString()   "+dataMap.keySet().toArray()[2].toString());

                String name = dataMap.get("BankName").toString();
                String address = dataMap.get("Addr").toString();
                String phone = dataMap.get("Phone").toString();
                for (int k = 0; k <= columnNumCount; k++) {
                    // 在一行内循环
                    Cell confirst = row.createCell(0);
                    System.out.println("name   "+name);
                    first.setCellValue(name);

                    Cell consecond = row.createCell(1);
                    second.setCellValue(address);
                    System.out.println("address   "+address);

                    Cell conthird = row.createCell(2);
                    third.setCellValue(phone);
                    System.out.println("phone   "+phone);
                }
            }
            // 创建文件输出流，准备输出电子表格：这个必须有，否则你在sheet上做的任何操作都不会有效
            out =  new FileOutputStream(finalXlsxPath);
            workBook.write(out);
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            try {
                if(out != null){
                    out.flush();
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("数据导出成功");
    }

    /**
     * 判断Excel的版本,获取Workbook
     * @param in
     * @param filename
     * @return
     * @throws IOException
     */
    public static Workbook getWorkbok(File file) throws IOException{
        Workbook wb = null;
        FileInputStream in = new FileInputStream(file);
        if(file.getName().endsWith(EXCEL_XLS)){     //Excel&nbsp;2003
            wb = new HSSFWorkbook(in);
        }else if(file.getName().endsWith(EXCEL_XLSX)){    // Excel 2007/2010
            wb = new XSSFWorkbook(in);
        }
        return wb;
    }
}