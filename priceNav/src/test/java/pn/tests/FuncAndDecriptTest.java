package pn.tests;

import org.testng.annotations.Test;

import pn.components.ListOfCategories;
import pn.dataProvider.DataProviderTest;
import pn.helpers.FunctionMenuHelper;
import pn.helpers.ListOfCategoriesHelper;
import pn.pages.ProductsListPage;

public class FuncAndDecriptTest extends BaseTest {

	@Test(dataProvider = "readForTest", dataProviderClass = DataProviderTest.class)
	public void funcAndDecriptTest(String section, String category,
			String function) {
		try {
			
			ListOfCategories listOfCategoryPage = goToMailPage();
			ListOfCategoriesHelper
					.setListOfCategoriesHelper(listOfCategoryPage);

			ProductsListPage productListPage = ListOfCategoriesHelper
					.goToCategoryProducts(category, section);

			FunctionMenuHelper.setFunctionMenuHelper(productListPage);
			FunctionMenuHelper.sortProductsByFunction(function);
			FunctionMenuHelper.checkSortedListOfProductsByFunction(function);

		} catch (NullPointerException e) {
			log("<b><h3>" + "Some element is NOT FOUND!Maybe you have entered INCORRECT DATA!" + "</h3></b>");
		}
	}

}
