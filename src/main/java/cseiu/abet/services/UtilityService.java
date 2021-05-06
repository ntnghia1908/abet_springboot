package cseiu.abet.services;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.*;
import cseiu.abet.model.Result;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import cseiu.abet.model.Student;
import org.springframework.stereotype.Service;

@Service
public class UtilityService {
    private Object getCellValue(Cell cell) {
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                return cell.getNumericCellValue();
        }
        return null;
    }

    public List<Result> readStudentScoreFromExcelFile (String excelFilePath) throws IOException{
        List<Result> resultList = new ArrayList<>();
        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));

        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet firstSheet = workbook.getSheetAt(0);
        Iterator<Row> iterator = firstSheet.iterator();

        iterator.next(); // skip the first row
        while (iterator.hasNext()){
            Row nextRow = iterator.next();
            Iterator<Cell> cellIterator = nextRow.cellIterator();
            Result student_result = new Result();
            Student student = new Student();
            while (cellIterator.hasNext()){
                Cell nextCell = cellIterator.next();
                int columnIndex = nextCell.getColumnIndex();
                switch(columnIndex){
                    case 1:
                        student.setId((String) getCellValue(nextCell));
                        student_result.setStudent(student);
                        break;
                    case 2:
                        student_result.setInClassScore((int) (double)getCellValue(nextCell));
                        break;
                    case 3:
                        student_result.setMidScore((int) (double) getCellValue(nextCell));
                        break;
                    case 4:
                        student_result.setFinalScore((int) (double) getCellValue(nextCell));
                        break;
                }
            }
            resultList.add(student_result);
        }
        workbook.close();
        inputStream.close();
        return resultList;
    }

    private void writeResult(Result student_result, Row row, int index){
        Cell cell = row.createCell(0);
        cell.setCellValue(index);

        cell = row.createCell(1);
        cell.setCellValue(student_result.getStudent().getId());

        cell = row.createCell(2);
        cell.setCellValue(student_result.getInClassScore());

        cell = row.createCell(3);
        cell.setCellValue(student_result.getMidScore());

        cell = row.createCell(4);
        cell.setCellValue(student_result.getFinalScore());

        cell = row.createCell(5);
        cell.setCellValue(student_result.getGpa());
    }

    private void createHeaderRow(Sheet sheet){
        CellStyle cellStyle = sheet.getWorkbook().createCellStyle();
        Font font = sheet.getWorkbook().createFont();
        font.setBold(true);
        font.setFontHeightInPoints((short) 12);
        cellStyle.setFont(font);
        List<String> header_name = Arrays.asList
                ("No","StudentID","Assignment","Midterm","Final","GPA",
                        "abet1","abet2","abet3","abet4","abet5","abet6","abet_avg");
        Row row = sheet.createRow(0);
        for (int i=0; i<header_name.size(); i++) {
            Cell new_cell = row.createCell(i);
            new_cell.setCellStyle(cellStyle);
            new_cell.setCellValue(header_name.get(i));
        }
    }

    public void writeResultToExcelFile(List<Result> listStudentResult, String excelFilePath) throws IOException{
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet();
        createHeaderRow(sheet);
        int rowCount = 0;

        for (Result student_result : listStudentResult) {
            Row row = sheet.createRow(++rowCount);
            writeResult(student_result, row, rowCount);
        }

        try (FileOutputStream outputStream = new FileOutputStream(excelFilePath)) {
            workbook.write(outputStream);
        }
    }
}
