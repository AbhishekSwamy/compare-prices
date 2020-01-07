package genericUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.imageio.ImageIO;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class Utility {

	public static String currentTimeStampConverter() {

		DateFormat df = new SimpleDateFormat("dd_MM_yy" + "_" + "HH_mm_ss_SSS");
		Calendar calobj = Calendar.getInstance();
		return df.format(calobj.getTime());
	}
	
	public static String getData(String filepath, String sheetname, int rowIndex, int cellIndex) {
		String data = null;
		try {
			File f = new File(filepath);
			FileInputStream fis = new FileInputStream(f);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet st = wb.getSheet(sheetname);
			Row r = st.getRow(rowIndex);
			Cell c = r.getCell(cellIndex);
			data = c.toString();
		} catch (Exception e) {

		}
		return data;
	}
	
	public String screenshot(String screenshotname, WebDriver driver, String screenshotLocation) throws IOException {

		Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000))
				.takeScreenshot(driver);
		ImageIO.write(screenshot.getImage(), "PNG", new File(screenshotLocation + screenshotname + ".png"));

		return null;
		
	}
	
	public static int getRandomInteger(int maximum, int minimum) {
		return ((int) (Math.random() * (maximum - minimum))) + minimum;
	}

	// ---------------------------Random Value Generator-----------------------

	public int randomvalue() {
		int randomInterger = getRandomInteger(999, 1);
		return randomInterger;
	}
	
	
}
