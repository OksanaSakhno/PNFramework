package pn.helpers;


import org.openqa.selenium.support.PageFactory;
import static pn.helpers.BaseTestHelper.*;
import pn.components.Component;
import pn.components.ListOfCategories;
import pn.pages.ProductsListPage;

public class ListOfCategoriesHelper{
	
	private static ListOfCategories listCategories;
	
	public static void setListOfCategoriesHelper(ListOfCategories listCategy){
		listCategories = listCategy;
	}
	
	public static ProductsListPage goToCategoryProducts(String category,
			String section) {

		log("Selecting category " + category);

		if (ProductsListHelper.elementIsExist(category)) {
			ListOfCategories.gotoCategoryOrSection(category);
			return PageFactory.initElements(Component.getDriver(),
					ProductsListPage.class);
		} else {
			log("Category not found " + category);
			
			goToSectionProducts(section);
			if (ProductsListHelper.elementIsExist(category)) {
				ListOfCategories.gotoCategoryOrSection(category);
				return PageFactory.initElements(Component.getDriver(),
						ProductsListPage.class);
			}
		}
		return null;
	}

	public static ListOfCategories goToSectionProducts(String section) {

		log("Selecting section " + section);

		if (ProductsListHelper.elementIsExist(section)) {			
			ListOfCategories.gotoCategoryOrSection(section);
			return PageFactory.initElements(Component.getDriver(),
					ListOfCategories.class);
		} else {
			log("Section not found " + section);
		}
		return null;
	}

	public static ListOfCategories getListCategories() {
		return listCategories;
	}

}
