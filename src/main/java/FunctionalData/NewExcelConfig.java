package FunctionalData;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import ObjRepo.ObjInfo;

public class NewExcelConfig {
	
	Workbook wb;
	Sheet sh;
	ObjInfo oInfo=new ObjInfo();
	public void readExcel(String filePath,String fileName,String SheetName) throws Exception
	{
		File file=new File(filePath+"\\"+fileName);
		FileInputStream fis=new FileInputStream(file);
		String fileExtn=fileName.substring(fileName.indexOf("."));
		if(fileExtn.equals(".xlsx"))
		{
			wb=new XSSFWorkbook(fis);
		}
		else if(fileExtn.equals(".xls"))
		{
			wb=new HSSFWorkbook(fis);
		}
	}
	
	public String GetData(int shno,int row,int col)
	{
		sh=wb.getSheetAt(shno);
		String data=sh.getRow(row).getCell(col).getStringCellValue();
		return data;
		
	}
	
	public String GetData1(int shno,int row,int col)
	{
		Cell cell = sh.getRow(row).getCell(col);
		FormulaEvaluator formulaEval = wb.getCreationHelper().createFormulaEvaluator();
		String value=formulaEval.evaluate(cell).formatAsString();
		return value;
		
	}
	
	@SuppressWarnings("deprecation")
    public void setCellData(int shno,int rownum, int colnum,String ident ) throws Exception
    {
                    //FileInputStream fis = new FileInputStream(new File("C:\\Users\\10840\\Desktop\\Projects\\SampleExcelforWrite.xlsx"));
                    //wb=new XSSFWorkbook(fis);
                    sh=wb.getSheetAt(shno);
                    Row row=sh.getRow(rownum);
                    Cell col=row.getCell(colnum);
                    //col.setCellValue(data);
                    col.setCellValue(ident);
                    col.setCellType(Cell.CELL_TYPE_STRING);
                    //col.setCellValue(data);
                    //fis.close();
                    /*DataFormatter formatter = new DataFormatter();
formatter.formatCellValue(col);*/
                    
                    FileOutputStream fos=new FileOutputStream(new File(oInfo.ExcelPath+"\\"+oInfo.ExcelFile));
                    wb.write(fos);
                    fos.close();
                    
	
    }
	
	/*public int GetData1(int shnum,int row1,int col1)
	{
		sh=wb.getSheetAt(shnum);
		int data1=(int) sh.getRow(row1).getCell(col1).getNumericCellValue();
		return data1;
		
	}*/
	
	public int rowCount(int shno)
	{
		int rows=wb.getSheetAt(shno).getLastRowNum();
		//rows=rows+1;
		return rows;
		
	}
	
	public int colCount(int shno)
	{
		/*sh=wb.getSheetAt(shno);
		int NoOfCells=0;
		Iterator<Row> RowItr=sh.rowIterator();
		if (RowItr.hasNext())
        {l
            Row headerRow = (Row) RowItr.next();
            //get the number of cells in the header row
            NoOfCells = sh.getRow(shno).getPhysicalNumberOfCells();
        }*/
        //System.out.println("number of cells "+NoOfCells);
		int NoOfCells=sh.getRow(shno).getLastCellNum();
		return NoOfCells;
		
      
	}
	/*public int GetNumber(int shnum,int row,int col)
	{
		sh=wb.getSheetAt(shnum);
		int data1= (int) sh.getRow(row).getCell(col).getNumericCellValue();
		//String readnumber = data1.toString();
		//String val=String.valueOf(data1);
		return data1;
		
	}*/
	
}
	
	
