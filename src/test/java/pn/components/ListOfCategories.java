package pn.components;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;



public class ListOfCategories extends Component{

	public static ListOfCategories getListOfCategories() {
		ListOfCategories listOfCategories = PageFactory.initElements(Component.getDriver(), ListOfCategories.class);
		return listOfCategories;
	}
	
	public static void gotoCategoryOrSection(String category) {
		Component.getDriver().findElement(By.linkText(category)).click();
	}
	
}
