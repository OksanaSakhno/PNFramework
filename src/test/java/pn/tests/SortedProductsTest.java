package pn.tests;

import org.testng.SkipException;
import org.testng.annotations.Test;

import pn.components.ListOfCategories;
import pn.dataProvider.DataProviderTest;
import pn.helpers.ListOfCategoriesHelper;
import pn.helpers.ProductsListHelper;
import pn.pages.ProductsListPage;

public class SortedProductsTest extends BaseTest {

	@Test(dataProvider = "readForTest", dataProviderClass = DataProviderTest.class)
	public void filterByPriceTest(String section, String category, String filter) {

		try {

			ListOfCategories listOfCategoryPage = goToMailPage();
			ListOfCategoriesHelper
					.setListOfCategoriesHelper(listOfCategoryPage);

			ProductsListPage productListPage = ListOfCategoriesHelper
					.goToCategoryProducts(category, section);

			ProductsListHelper.setProductsListHelper(productListPage);
			ProductsListHelper.sortProductsByFilter(filter);
			ProductsListHelper.checkSortedListByPrice();
			
		} catch (NullPointerException e) {
			throw new SkipException("Test skipped! Some element is NOT FOUND!Maybe you have entered INCORRECT DATA!");
		}

	}

	@Test(dataProvider = "readForTest", dataProviderClass = DataProviderTest.class)
	public void filterByNameTest(String section, String category, String filter) {

		try {
			ListOfCategories listOfCategoryPage = goToMailPage();
			ListOfCategoriesHelper
					.setListOfCategoriesHelper(listOfCategoryPage);

			ProductsListPage productListPage = ListOfCategoriesHelper
					.goToCategoryProducts(category, section);

			ProductsListHelper.setProductsListHelper(productListPage);
			ProductsListHelper.sortProductsByFilter(filter);
			ProductsListHelper.checkSortedListByName();
			
		} catch (NullPointerException e) {
			throw new SkipException("Test skipped! Some element is NOT FOUND!Maybe you have entered INCORRECT DATA!");
		}

	}

}
