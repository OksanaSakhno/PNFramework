package pn.tests;

import org.testng.annotations.Test;

import pn.components.ListOfCategories;
import pn.dataProvider.DataProviderTest;
import pn.helpers.ListOfCategoriesHelper;
import pn.helpers.ProductsListHelper;
import pn.pages.ProductsListPage;

public class CheckMinMaxTest extends BaseTest {
	@Test(dataProvider = "readForTest", dataProviderClass = DataProviderTest.class)
	public void checkMinMaxFolter(String section, String category, double min,
			double max) {
		try {
			
			ListOfCategories listOfCategoryPage = goToMailPage();
			ListOfCategoriesHelper
					.setListOfCategoriesHelper(listOfCategoryPage);

			ProductsListPage productListPage = ListOfCategoriesHelper
					.goToCategoryProducts(category, section);

			ProductsListHelper.setProductsListHelper(productListPage);
			ProductsListHelper.sortProductsByMinMax(min, max);
			ProductsListHelper.checkSortedListOfProductsByMinMax();

		} catch (NullPointerException e) {
			log("<b><h3>" + "Some element is NOT FOUND!Maybe you have entered INCORRECT DATA!" + "</h3></b>");
		}

	}

}
