package pn.tests;

import org.testng.annotations.Test;

import pn.components.ListOfCategories;
import pn.dataProvider.DataProviderTest;
import pn.helpers.CompareComponentHelper;
import pn.helpers.ListOfCategoriesHelper;
import pn.pages.ProductsListPage;

public class CompareProducts extends BaseTest {
	@Test(dataProvider = "readForTest", dataProviderClass = DataProviderTest.class)
	public void checkCompareTest(String section, String category,
			double firstGood, double secondGood) {
		try {
			
			ListOfCategories listOfCategoryPage = goToMailPage();
			ListOfCategoriesHelper
					.setListOfCategoriesHelper(listOfCategoryPage);

			ProductsListPage productListPage = ListOfCategoriesHelper
					.goToCategoryProducts(category, section);

			CompareComponentHelper.setCompareComponentHelper(productListPage);
			CompareComponentHelper.openDescriptionProducts(firstGood,
					secondGood);
			CompareComponentHelper.openComparePage();
			CompareComponentHelper.checkDescriptionOfProducts();
			
		} catch (NullPointerException e) {
			log("<b><h3>" + "Some element is NOT FOUND!Maybe you have entered INCORRECT DATA!" + "</h3></b>");
		}

	}

}
