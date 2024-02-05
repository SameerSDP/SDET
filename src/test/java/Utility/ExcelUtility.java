package Utility;

import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtility {

    private Workbook workbook;
    private static Sheet sheet;
    String filepath = "data/TestData.xlsx";
    String sheetName = "Sheet1";

    public ExcelUtility() {
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(this.filepath));
            workbook = WorkbookFactory.create(fileInputStream);
            sheet = workbook.getSheet(this.sheetName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    

	public static String getCellValue(int rowNumber, int cellNumber) {
        Row row = sheet.getRow(rowNumber - 1);
        Cell cell = row.getCell(cellNumber - 1);

        if (cell.getCellType() == CellType.STRING) {
            return cell.getStringCellValue();
        } else if (cell.getCellType() == CellType.NUMERIC) {
            return String.valueOf(cell.getNumericCellValue());
        } else {
            return "";
        }
    }

    public void closeWorkbook() {
        try {
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
