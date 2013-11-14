package pn.helpers;

import java.util.HashSet;
import java.util.Set;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import static pn.helpers.BaseTestHelper.*;

import pn.components.Component;
import pn.components.FunctionMenu;
import pn.components.MenuNextPrevSort;
import pn.pages.ProductsListPage;

public class FunctionMenuHelper {
	
	public static final int SORTED_BY_MAX = -1;
	public static final int SORTED_BY_MIN = 1;
	public static final int SORTED_BY_MIN_MAX = 2;
	public static final int NO_SORTED = 0;
	public static final String SHOW_ALL_LINK = "показать все";
	public static final String HIDE_OTHER_LINK = "скрыть остальные";
	
	private static ProductsListPage mainPage;
	protected static boolean flag;
	
	
	public static void setFunctionMenuHelper(ProductsListPage page){
		mainPage = page;
	}
	
	public static Set<String> getListOfVendors() {
		log("Reading of all list of vendors ");
		Set<String> set = new HashSet<String>();
		for (WebElement item : mainPage.getFunctionalPanel().getProducersList()) {
			if (!item.getText().equals(SHOW_ALL_LINK)
					&& !item.getText().equals(HIDE_OTHER_LINK))
				set.add(item.getText().toLowerCase());
			else
				break;
		}
		for (WebElement item : mainPage.getFunctionalPanel().getProducersHideList()) {
			set.add(item.getText().toLowerCase());
		}
		return set;
	}
	
	
	public static boolean checkListByVendorsName(Set<String> vendors) {
		flag = true;
		log("Verification of all list of goods on the vendors");
		String fullName = null;
		String[] name;
		while (true) {
			for (WebElement item : mainPage.listOfGoods) {
				fullName = ProductHelper.convertRowToProduct(item).getName().toLowerCase();
				name = fullName.split(" ");
				if (!vendors.contains(name[0])) {
					log("These goods with such vendor " + name[0] 
							+ " aren't found in the list of vendors!");
					flag = false;
					Assert.assertTrue("Not all vendors of goods are carried out in the list of goods!", flag);
				}
			}
			if (MenuNextPrevSort.isNextPage()) {
				mainPage.getMenu().clickGoToNextPage();
			} else
				break;
		}
		return flag;
	}
	
	
	public static ProductsListPage getNameVendorsOfGoods(){
		mainPage.getFunctionalPanel().clickToCommonVendorList(FunctionMenu.COMMON_VENDORS);
		Set<String> vendors = new HashSet<String>();
		vendors = getListOfVendors();
		checkListByVendorsName(vendors);
		return PageFactory.initElements(Component.getDriver(), ProductsListPage.class);
	}
	
	public static ProductsListPage checkListByVendorsName (){
		Assert.assertTrue("Not all vendors of goods are carried out in the list of goods!", flag);
		return PageFactory.initElements(Component.getDriver(), ProductsListPage.class);
	}
	
	
	
	
	/////////////////////////////////////////////////////////////////////////////
	
	public static ProductsListPage goToListProductsSortedByMinMax(double min,
			double max, int correct) {
		String minPrice = "";
		String maxPrice = "";
		minPrice += (int)min;
		maxPrice += (int)max;
		switch (correct) {
		case SORTED_BY_MIN_MAX:
			mainPage.getFunctionalPanel().clickToMinLink(minPrice);
			mainPage.getFunctionalPanel().clickToMaxLink(maxPrice);
			break;
		case SORTED_BY_MIN:
			mainPage.getFunctionalPanel().clickToMinLink(minPrice);
			break;
		case SORTED_BY_MAX:
			mainPage.getFunctionalPanel().clickToMaxLink(maxPrice);
			break;
		}
		return PageFactory.initElements(Component.getDriver(), ProductsListPage.class);
	}
	
	////////////////////////////////////////////////////////////////////////////

	public static ProductsListPage sortProductsByFunction(String function) {
		goToListProductsSortedByFuncrion(function);
		return PageFactory.initElements(Component.getDriver(), ProductsListPage.class);

	}
	
	public static ProductsListPage goToListProductsSortedByFuncrion(
			String function) {
		log("Sorting of the list of goods by function ");
		if (ProductsListHelper.elementIsExist(function)) {
			mainPage.getFunctionalPanel().clickToFunction(function);
			return PageFactory.initElements(Component.getDriver(), ProductsListPage.class);
		} else
			Assert.fail("Such function is not found!");
		return null;
	}
	

	public static void checkSortedListOfProductsByFunction(String function) {
		Assert.assertTrue("Not all goods are sorted by the function", getItemsOfCatalogByFunction(function));
	}
	
	public static boolean getItemsOfCatalogByFunction(String function) {
		flag = true;
		log("Verification of all list of goods on the function");
		while (true) {
			for (WebElement item : mainPage.listOfGoods) {
				if (ProductHelper.convertRowToProduct(item).getDescription()
						.indexOf(function) == -1) {
					
					log("This element " + ProductHelper.convertRowToProduct(item).toString() 
							+ " has no such function " + function);
					flag = false;
					Assert.assertTrue("The good does not have such function!", flag);
				}
			}
			if (MenuNextPrevSort.isNextPage()) {
				mainPage.getMenu().clickGoToNextPage();
			} else
				break;
		}
		return flag;
	}
	
	
	
	public static ProductsListPage getFuncCompoment() {
		return mainPage;
	}

	
}
