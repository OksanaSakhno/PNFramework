package pn.tests;


import org.testng.annotations.Test;
import pn.components.ListOfCategories;
import pn.dataProvider.DataProviderTest;
import pn.helpers.FunctionMenuHelper;
import pn.helpers.ListOfCategoriesHelper;
import pn.pages.ProductsListPage;

public class CheckVendorsOfGoods extends BaseTest{
	
	@Test(dataProvider = "readForTest", dataProviderClass = DataProviderTest.class)
	public void checkVendorsTest(String section, String category) {

			ListOfCategories listOfCategoryPage = goToMailPage();
			ListOfCategoriesHelper
					.setListOfCategoriesHelper(listOfCategoryPage);

			ProductsListPage productListPage = ListOfCategoriesHelper
					.goToCategoryProducts(category, section);
			
			FunctionMenuHelper.setFunctionMenuHelper(productListPage);
			FunctionMenuHelper.getNameVendorsOfGoods();
			FunctionMenuHelper.checkListByVendorsName();
		
	}
	
}
