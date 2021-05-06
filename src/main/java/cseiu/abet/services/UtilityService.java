package cseiu.abet.services;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.*;
import cseiu.abet.model.Result;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
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
}
