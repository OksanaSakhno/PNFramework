package pn.tests;


import org.testng.annotations.Test;
import pn.components.ListOfCategories;
import pn.dataProvider.DataProviderTest;
import pn.helpers.ListOfCategoriesHelper;
import pn.helpers.PricePageHelper;
import pn.helpers.ProductsListHelper;
import pn.pages.ProductsListPage;

public class CheckInfoAndLinkTest extends BaseTest {

	@Test(dataProvider = "readForTest", dataProviderClass = DataProviderTest.class)
	public void checkLinkOfProduct(String section, String category,
			double countGoods) {

			ListOfCategories listOfCategoryPage = goToMailPage();
			ListOfCategoriesHelper
					.setListOfCategoriesHelper(listOfCategoryPage);

			ProductsListPage productListPage = ListOfCategoriesHelper
					.goToCategoryProducts(category, section);

			ProductsListHelper.setProductsListHelper(productListPage);
			ProductsListHelper.saveLinksAndNameGoods(countGoods);

			PricePageHelper.setPricePageHelper(productListPage);
			PricePageHelper.checkSameLink();
		
	}

	@Test(dataProvider = "readForTest", dataProviderClass = DataProviderTest.class)
	public void checkDescription(String section, String category,
			double countGoods) {
			
			ListOfCategories listOfCategoryPage = goToMailPage();
			ListOfCategoriesHelper
					.setListOfCategoriesHelper(listOfCategoryPage);

			ProductsListPage productListPage = ListOfCategoriesHelper
					.goToCategoryProducts(category, section);

			ProductsListHelper.setProductsListHelper(productListPage);
			ProductsListHelper.openProductsAndCheckDescription(countGoods);
			
	}
}
