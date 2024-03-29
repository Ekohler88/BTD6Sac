package tower;
//reading value of a particular cell
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.SystemOutLogger;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class Tower {
	String temp = "hello world? This is Tower Class what do you want?";
	String upgradePath = "555";
	int cost = 0;
	double discount = 0.0;
	String category = temp;
	int size = 0;
	boolean discountTower = false;

	/**
	 * Getter for the temp, which will be a key value for testing.
	 * This will be the default value for strings instead of null for now until the code develops more because it will be used in the following:
	 * 1) It will be used to help with parsing string practice
	 * 2) Help with local testing on whether a String variable has changed locally or global.
	 * 3) Having a unique String value will be used as a place holder for the common practice if company coding having a certain set value for helping debug.
	 * @return the value of specific value for setting up code that will be the key value to know if variable has been updated or not
	 */
	public String getTemp() {
		return temp;
	}

	/**
	 * Setter for the temp value used for general debugging use.
	 * @param temp
	 *
	 */
	public void setTemp(String temp) {
		this.temp = temp;
	}

	/** Getter for the upgradePath to help describe the tower's upgrades it will be using at that point.
	 *
	 * @return String value in format 000 or 100 or 010 etc...
	 */
/*
 * Was thing of changing the specifics of the this setter and getter to help
 * keep format but realized that brakes programming principles.
 * Will have another method or methods work with proper formating. EK
 */
	public String getUpgradePath() {
		return upgradePath;
	}

	/**
	 * Setter for the value of the upgradePath for articulating the various upgrade paths a single tower can take.
	 * @param upgradePath
	 */
	public void setUpgradePath(String upgradePath) {
		this.upgradePath = upgradePath;
	}

	/**
	 * Getter for the cost
	 * The value of denomination of the tower based on its base cost along with its upgrade
	 * Will be updated with any value greater than zero since each tower has a base cost and this will start with that and add value when upgrades made.
	 * @return value of the worth of the tower
	 */
	public int getCost() {
		return cost;
	}

	/**
	 * Setter for the cost
	 * @param cost
	 */
	public void setCost(int cost) {
		this.cost = cost;
	}

	/**
	 * Getter for discount
	 * Game mechanic has discounting cost of towers and will be used in keeping the track of the discounts.
	 * General Note: this end program design is being designed to test whether these discounts or other in game mechanics effects the strength of tower upgrade through the sacrifice mechanic.
	 * More details in the notes section but once this program is stable and working as intended this value will help keep track of the several in game denomination discounts.
	 * @return
	 */
	public double getDiscount() {
		return discount;
	}

	/**
	 * Setter for discount
	 * @param discount
	 */
	public void setDiscount(double discount) {
		this.discount = discount;
	}

	/**
	 * Getter for the category
	 * Category value represents the different kinds of monkeys and will give different benfints in the sacrifice mechanic and will need to tracked through out.
	 * @return
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * Setter for the category
	 * @param catagory
	 */
	public void setCategory(String catagory) {
		this.category = catagory;
	}

	/**
	 * Getter for size
	 * A made up value to represent the size of the tower as it will fit onto the screen.
	 * In the game there seems to be at least 2 sizes and potentially 3.
	 * This will effect how many realistically towers would actually be in range to count for the sacrifice mechanic.
	 * @return
	 */
	public int getSize() {
		return size;
	}

	/**
	 * Setter for size
	 * @param size
	 */
	public void setSize(int size) {
		this.size = size;
	}

	/**
	 * Getter for discountTower
	 * A boolean to help navigate whether a tower has a discount or not.
	 * A use case for this that certain towers will have upgrades to lessen the in game denomination for other towers and this will help track whether towers in range of this tower will be effected.
	 * @return
	 */
	public boolean isDiscountTower() {
		return discountTower;
	}

	/**
	 * Setter for discountTower
	 * @param discountTower
	 */
	public void setDiscountTower(boolean discountTower) {
		this.discountTower = discountTower;
	}
//End of Getters and Setters

//Methods related tower
	//TODO:
	// format method: DONE
		//Keep upgradePath in format 000 etc...
		//Might want a converting methods to help have:
			//value of each upgradePath character be represented
			//make a string value for the total upgrade so 000 does not change to 0 numerically speaking
				//meaning that this should be a list where the data type is [0,0,0] or [2,0,5] but not [3,5,4]
					//not [3,5,4] because a cross upgrade of 2 and one other upgrade is only allowed so there for:
						// tower can not have a upgrade in each path
						// if a upgrade increases to 3 or greater than only one other path can go up to 2 and no greater.
	// Totaling cost method: DONE until updated .xml part
		//this will take the base cost and add the upgrades.

//Going to add the file object methods here before the reading classes in order to get something to read.
	/**
	 * Method to just read the whole xml sheet.
	 *
	 * @return String of the whole sheet.
	 */
	@SuppressWarnings("deprecation")
	public String[][] readSheet() {

		int i=483; int j=23;
		String[][] sheet = new String[i][j];
		try {
			i = 0;
			j = 0;
			FileInputStream xmlFile = new FileInputStream(new File("C:\\Users\\ekohl\\OneDrive\\Documents\\GitHub\\BTD6Sac\\Data_Sheets\\Btd6 tower spread sheet.xlsx"));
			XSSFWorkbook workBook = new XSSFWorkbook(xmlFile);
			XSSFSheet workBookSheet = workBook.getSheetAt(0);
			Iterator<Row> itrerate = workBookSheet.iterator();
			while(itrerate.hasNext()) {
				Row row = itrerate.next();
				Iterator<Cell> cellIterator = row.cellIterator();

				while(cellIterator.hasNext() ) {
					Cell cell = cellIterator.next();
					switch(cell.getCellType() ) {
						case Cell.CELL_TYPE_STRING:
							//sheet.concat(cell.getStringCellValue() + "\t\t\t");
							System.out.print(cell.getStringCellValue() + "\t\t\t");
							sheet[i][j] = cell.getStringCellValue();

							break;
						case Cell.CELL_TYPE_NUMERIC:
						//	sheet.concat(cell.getStringCellValue() + "\t\t\t");
							System.out.print(cell.getNumericCellValue() + "\t\t\t");
							sheet[i][j] = String.valueOf(cell.getNumericCellValue());

							break;
						case Cell.CELL_TYPE_BOOLEAN:
						//	sheet.concat(cell.getStringCellValue() + "\t\t\t");
							System.out.print(cell.getBooleanCellValue() + "\t\t\t");
							sheet[i][j] = String.valueOf(cell.getBooleanCellValue());

							break;
						default:

					}
					i++;
				}
				System.out.println("");
				j++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sheet;
	}

	/**
	 * Method for make reading rest of code easier.
	 * @param pathlist Char
	 * @return int value
	 */
	public int charToInt(char pathlist)
	{
		int i = 0;
		i = (int)pathlist - (int)'0';
		return i;
	}

// Thinking of making a [5,5,5] the monkey type that error that lets the program run but show a logic problem for formating.
	public int[] converPathToList(String path) {
		int pathList[] = {5, 5, 5};
		if(path.length() > 4) {
			System.out.println("The Value for FORMAT is too long");
		}//end of if
		else {
			char pathl[] = path.toCharArray();
			if(Character.isDigit(path.charAt(0)) && Character.isDigit(path.charAt(1)) && Character.isDigit(path.charAt(2))
			&& charToInt(pathl[0]) < 6 && charToInt(pathl[1]) < 6  && charToInt(pathl[2]) < 6) {
				// - '0' to convert the char to ints
				pathList[0] = charToInt(pathl[0]);
				pathList[1] = charToInt(pathl[1]);
				pathList[2] = charToInt(pathl[2]);
			}//end of if
			else {
				System.out.println("The format values are not numbers");
			}//end of else
		}//end of else
		return pathList;
	}

	/**
	 * Method to sum up the tower upgrades to update the cost of the tower.
	 * Still need to update .xml translation portion.
	 */
	public void summingUpTower() {
		String path = this.upgradePath;
		//lol i wanted to this one because it looked easier but need a converter here
		int[] pathList = converPathToList(path);
		int top = pathList[0];
		int mid = pathList[1];
		int bot = pathList[2];
		// this part will need practice .xml file to locate the values so will notetate for now and update later.
//------------------
		cost = top + mid + bot;
	}//END of summingUpTower

//MAIN
	public static void main(String[] args)
	{

		System.out.println("hello world? This is Tower Class what do you want?");
		System.out.println("testing for this class with this main section");
		Tower t1 = new Tower();
		int list[] = t1.converPathToList("131");
		System.out.println(t1.cost);
		System.out.println(list[0]+" "+list[1]+" "+list[2]);
		t1.summingUpTower();
		System.out.println(t1.cost);
		String[][] matrix = t1.readSheet();
		for(int r=0;r<matrix.length; r++) {
			 for (int c=0; c<matrix [r].length; c++) {
			     System.out.print(matrix [r][c] + " ");
			 }
			 System.out.println();
			}
		System.out.println(matrix[0][4]);
	}//end of main
}//end of class tower
