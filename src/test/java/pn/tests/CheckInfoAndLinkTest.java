package pn.tests;

import org.testng.annotations.Test;

import pn.components.ListOfCategories;
import pn.dataProvider.DataProviderTest;
import pn.helpers.ListOfCategoriesHelper;
import pn.helpers.PricePageHelper;
import pn.helpers.ProductsListHelper;
import pn.pages.ProductsListPage;

public class CheckInfoAndLinkTest extends BaseTest {

	/*@Test(dataProvider = "readForTest", dataProviderClass = DataProviderTest.class)
	public void checkLinkOfProduct(String section, String category,
			double countGoods) {
		try {

			ListOfCategories listOfCategoryPage = goToMailPage();
			ListOfCategoriesHelper
					.setListOfCategoriesHelper(listOfCategoryPage);

			ProductsListPage productListPage = ListOfCategoriesHelper
					.goToCategoryProducts(category, section);

			ProductsListHelper.setProductsListHelper(productListPage);
			ProductsListHelper.saveLinksAndNameGoods(countGoods);

			PricePageHelper.setPricePageHelper(productListPage);
			PricePageHelper.checkSameLink();
			
		} catch (NullPointerException e) {
			log("<b><h3>" + "Some element is NOT FOUND!Maybe you have entered INCORRECT DATA!" + "</h3></b>");
		}
	}*/

	@Test(dataProvider = "readForTest", dataProviderClass = DataProviderTest.class)
	public void checkDescription(String section, String category,
			double countGoods) {
		try {
			
			ListOfCategories listOfCategoryPage = goToMailPage();
			ListOfCategoriesHelper
					.setListOfCategoriesHelper(listOfCategoryPage);

			ProductsListPage productListPage = ListOfCategoriesHelper
					.goToCategoryProducts(category, section);

			ProductsListHelper.setProductsListHelper(productListPage);
			ProductsListHelper.openProductsAndCheckDescription(countGoods);
			
		} catch (NullPointerException e) {
			log("<b><h3>" + "Some element is NOT FOUND!Maybe you have entered INCORRECT DATA!" + "</h3></b>");
		}

	}
}
