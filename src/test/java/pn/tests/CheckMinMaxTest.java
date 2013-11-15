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
			
			ListOfCategories listOfCategoryPage = goToMailPage();
			ListOfCategoriesHelper
					.setListOfCategoriesHelper(listOfCategoryPage);

			ProductsListPage productListPage = ListOfCategoriesHelper
					.goToCategoryProducts(category, section);

			ProductsListHelper.setProductsListHelper(productListPage);
			ProductsListHelper.sortProductsByMinMax(min, max);
			ProductsListHelper.checkSortedListOfProductsByMinMax();


	}

}
