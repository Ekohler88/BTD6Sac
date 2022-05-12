//reading value of a particular cell  
import java.io.FileInputStream;  
import java.io.FileNotFoundException;  
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;  
import org.apache.poi.ss.usermodel.*;  
import org.apache.poi.ss.usermodel.Sheet;  
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.SystemOutLogger;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;  
public class TestProg   
{  
	public static void main(String[] args)   
	{  
		TestProg rc=new TestProg();   //object of the class  
			//reading the value of 2nd row and 2nd column  
			String vOutput=rc.ReadCellData(1, 1);   
			System.out.println(vOutput);  
			rc.ReadWhole();
			int value = rc.monkeyUpgradTotalCost(0,0,1);
			System.out.println(value);
			
	}  
	//method defined for reading a cell  
	public String ReadCellData(int vRow, int vColumn)  
	{  
		String value=null;          //variable for storing the cell value  
		Workbook wb=null;           //initialize Workbook null  
		try  
		{  
			//reading data from a file in the form of bytes  
			FileInputStream fis=new FileInputStream("C:\\Users\\ekohl\\Documents\\GitHub\\BTD6Sac\\ProgramIdeas\\Downloads\\Btd6TowerSpreadSheet.xlsx");  
			//constructs an XSSFWorkbooFileInputStreamk object, by buffering the whole stream into the memory  
			wb=new XSSFWorkbook(fis);  
		}  
		catch(FileNotFoundException e)  
		{  
			e.printStackTrace();  
		}  
		catch(IOException e1)  
		{  
			e1.printStackTrace();  
		}  
		Sheet sheet=wb.getSheetAt(0);   //getting the XSSFSheet object at given index  
		Row row=sheet.getRow(vRow); //returns the logical row  
		Cell cell=row.getCell(vColumn); //getting the cell representing the given column  
		value=cell.getStringCellValue();    //getting cell value  
		return value;               //returns the cell value  
	}  
	public void ReadWhole() {
		String listOfIt = null;
		Workbook wb = null;
		try
		{
			FileInputStream fis=new FileInputStream("C:\\Users\\ekohl\\Documents\\GitHub\\BTD6Sac\\ProgramIdeas\\Downloads\\Btd6TowerSpreadSheet.xlsx");  
			wb = new XSSFWorkbook(fis);
			Sheet sheet = wb.getSheetAt(0);
			Iterator<Row> itr = sheet.iterator();
			while (itr.hasNext())
			{
				Row row = itr.next();
				Iterator<Cell> cellIterator = row.cellIterator();
				while(cellIterator.hasNext())
				{
					Cell cell = cellIterator.next();
					switch(cell.getCellType())
					{
					case Cell.CELL_TYPE_STRING:
						listOfIt += cell.getStringCellValue();
						System.out.print(cell.getStringCellValue() + "\t\t\t");
						break;
					case Cell.CELL_TYPE_NUMERIC:
						System.out.print(cell.getNumericCellValue() + "\t\t\t");
						listOfIt += cell.getNumericCellValue();
						break;
					default:
					{
					}
						System.out.println("");
					}
				}
				System.out.println(listOfIt);
			}
		}
		catch(FileNotFoundException e)  
		{  
			e.printStackTrace();  
		}  
		catch(IOException e1)  
		{  
			e1.printStackTrace();  
		}  
	}
	/**
	 * ToDo need to get values from the target upgrade and the clumitive cost of it.
	 * @param u
	 * @param m
	 * @param b
	 * @return
	 */
	public int monkeyUpgradTotalCost(int u, int m, int b) {
		int value=0;          //variable for storing the cell value  
		Workbook wb=null;           //initialize Workbook null  
		try  
		{  
			//reading data from a file in the form of bytes  
			FileInputStream fis=new FileInputStream("C:\\Users\\ekohl\\Documents\\GitHub\\BTD6Sac\\ProgramIdeas\\Downloads\\Btd6TowerSpreadSheet.xlsx");  
			//constructs an XSSFWorkbooFileInputStreamk object, by buffering the whole stream into the memory  
			wb=new XSSFWorkbook(fis);  
		}  
		catch(FileNotFoundException e)  
		{  
			e.printStackTrace();  
		}  
		catch(IOException e1)  
		{  
			e1.printStackTrace();  
		}  
		
		
		int tempValue = 0;
		Sheet sheet=wb.getSheetAt(0); 
		if(u + m +b ==0) {
		
		Row row=sheet.getRow(1); //returns the logical row of the first tower in this case
		Cell cell=row.getCell(2); //getting the cell representing the given column  
		value=(int) cell.getNumericCellValue();    //getting cell value  
		}
		else {
			switch(u) {
			case 0:
				tempValue = 30;
			case 1:
				tempValue = 3;
				break;
			case 2:
				tempValue = 4;
				break;
			case 3:
				tempValue = 5;
				break;
			case 4:
				tempValue = 6;
				break;
			case 5:
				tempValue = 7;
				break;
			}
			Row row=sheet.getRow(1); //returns the logical row of the first tower in this case
			Cell cell=row.getCell(tempValue); //getting the cell representing the given column  
			value+=(int) cell.getNumericCellValue();    //getting cell value  
			switch(m) {
			case 0:
				tempValue = 30;
			case 1:
				tempValue = 8;
				break;
			case 2:
				tempValue = 9;
				break;
			case 3:
				tempValue = 10;
				break;
			case 4:
				tempValue = 11;
				break;
			case 5:
				tempValue = 12;
				break;
			}
			row=sheet.getRow(1); //returns the logical row of the first tower in this case
			cell=row.getCell(tempValue); //getting the cell representing the given column  
			value+=(int) cell.getNumericCellValue();    //getting cell value  
			switch(b) {
			case 0:
				tempValue = 30;
			case 1:
				tempValue = 13;
				break;
			case 2:
				tempValue = 14;
				break;
			case 3:
				tempValue = 15;
				break;
			case 4:
				tempValue = 16;
				break;
			case 5:
				tempValue = 17;
				break;
			}
			row=sheet.getRow(1); //returns the logical row of the first tower in this case
			cell=row.getCell(tempValue); //getting the cell representing the given column  
			value=(int) cell.getNumericCellValue();    //getting cell value  
		}
		Row row = sheet.getRow(1);
		Cell cell = row.getCell(2);
		return value +=(int) cell.getNumericCellValue();               //returns the cell value            
	}
}  