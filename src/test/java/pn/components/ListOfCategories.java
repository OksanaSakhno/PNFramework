package pn.components;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import static pn.helpers.BaseTestHelper.*;

public class ListOfCategories extends Component {

	public static ListOfCategories getListOfCategories() {
		ListOfCategories listOfCategories = PageFactory.initElements(
				Component.getDriver(), ListOfCategories.class);
		return listOfCategories;
	}

	public static void gotoCategoryOrSection(String category) {
		log("Click on the category link");
		Component.getDriver().findElement(By.linkText(category)).click();
	}

}
