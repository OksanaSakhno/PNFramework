package pn.helpers;


import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import static pn.helpers.BaseTestHelper.*;
import pn.components.Component;
import pn.components.MenuNextPrevSort;
import pn.components.ProductDescription;
import pn.pages.ProductsListPage;

public class ProductsListHelper {

	public static final int PARAMETR_NOT_SET = -1;
	private static boolean flag;
	private static ProductsListPage pageHelper;

	public static String[] href;
	public static String[] name;
	ProductHelper productHelper;

	public static void setProductsListHelper(ProductsListPage page) {
		pageHelper = page;
		ProductHelper.setProductHelper(page);
	}

	// /////////////////////////////////////////////////////////////////////////////////////////////////
	public static ProductsListPage sortProductsByFilter(String filter) {
		log("Sorting all products by filter " + filter);
		if (elementIsExist(filter)) {
			pageHelper.clickByFilter(filter);
			return PageFactory.initElements(Component.getDriver(),
					ProductsListPage.class);
		} else{
			log("<b><h3>" + filter + " Such filter is not found!" + "</h3></b>");
			Assert.fail("Filter not found!");
		}
		return null;
	}

	public static void checkSortedListByPrice() {
		log("Check sorting of all the products at the price ");
		Assert.assertTrue("Not all goods are sorted by the price", getItemsOfCatalogByPrice());
	}

	public static void checkSortedListByName() {
		log("Check sorting of all the products at the name ");
		Assert.assertTrue("Not all goods are sorted by the name", getItemsOfCatalogName());
	}

	public static boolean getItemsOfCatalogName() {
		setFlag(true);
		String name = null;
		while (true) {
			for (WebElement item : pageHelper.listOfGoods) {
				if (name == null) {
					name = ProductHelper.convertRowToProduct(item).getName();
				} else {
					if (name.compareTo(ProductHelper.convertRowToProduct(item).getName()) == 1) {
						log("This element "
								+ ProductHelper.convertRowToProduct(item).toString()
								+ " isn't sorted!");
						setFlag(false);
						Assert.fail("Not all goods are sorted by the name");
					} else {
						name = ProductHelper.convertRowToProduct(item).getName();
					}
				}

			}
			if (MenuNextPrevSort.isNextPage()) {
				pageHelper.getMenu().clickGoToNextPage();
			} else
				break;
		}
		return flag;
	}

	public static boolean getItemsOfCatalogByPrice() {
		setFlag(true);
		int price = 0;
		while (true) {
			for (WebElement item : pageHelper.listOfGoods) {
				if (price == 0) {
					price = ProductHelper.convertRowToProduct(item).getPrice();
				} else {
					if (price <= ProductHelper.convertRowToProduct(item).getPrice()) {
						price = ProductHelper.convertRowToProduct(item).getPrice();
					} else {
						log("This element "
								+ ProductHelper.convertRowToProduct(item).toString()
								+ " isn't sorted!");
						setFlag(false);
						Assert.fail("Not all goods are sorted by the price");
					}
				}

			}
			if (MenuNextPrevSort.isNextPage()) {
				pageHelper.getMenu().clickGoToNextPage();
			} else
				break;
		}
		return flag;
	}

	// ///////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static ProductsListPage sortProductsByMinMax(double min, double max) {
		int isCorrect = ProductsListHelper.isCorrectPrice(min, max);
		if (isCorrect != FunctionMenuHelper.NO_SORTED) {
			FunctionMenuHelper.setFunctionMenuHelper(pageHelper);
			FunctionMenuHelper.goToListProductsSortedByMinMax(min, max,
					isCorrect);
			sortedByMinMax(min, max, isCorrect);
		} else
			Assert.fail("Parameters for sorting are specified incorrectly!");
		return PageFactory.initElements(Component.getDriver(),
				ProductsListPage.class);
	}

	public static void checkSortedListOfProductsByMinMax() {

		Assert.assertTrue("Not all goods are sorted by the filter of a minimum and maximum price.", getFlag());
	}

	public static int isCorrectPrice(double min, double max) {
		log("Checking of input MIN MAX parameters ");

		if (min == PARAMETR_NOT_SET) {
			log("Specify only one parameter to check the price (MAX) ");
			return FunctionMenuHelper.SORTED_BY_MAX;
		}
		if (max == PARAMETR_NOT_SET) {
			log("Specify only one parameter to check the price (MIN) ");
			return FunctionMenuHelper.SORTED_BY_MIN;
		} else {
			if (max < min) {
				log("<b><h3>" + "The prices are incorrectly specified! Minimum price must be less maximum." + "<h3></b>");
				return FunctionMenuHelper.NO_SORTED;
			}
			if (max == min) {
				log("The prices are incorrectly specified! As, minimum is equal to maximum price, sorting will be made at minimum price. "
						+ "Sorting at the MIN price!");
				return FunctionMenuHelper.SORTED_BY_MIN;
			}
		}
		return FunctionMenuHelper.SORTED_BY_MIN_MAX;
	}

	public static boolean sortedByMinMax(double min, double max, int correct) {

		log("Check of sorting of all products on the filter the price(min, max) ");
		setFlag(true);
		while (true) {
			for (WebElement item : pageHelper.listOfGoods) {
				if (correct == FunctionMenuHelper.SORTED_BY_MIN_MAX) {
					if (ProductHelper.convertRowToProduct(item).getPrice() < (int) min
							|| ProductHelper.convertRowToProduct(item).getPrice() > (int) max) {
						log("This element "
								+ ProductHelper.convertRowToProduct(item).toString()
								+ " is not included in the preset range of values!");
						flag = false;
					}
				} else if (correct == FunctionMenuHelper.SORTED_BY_MAX) {
					if (ProductHelper.convertRowToProduct(item).getPrice() > (int) max) {
						log("This element "
								+ ProductHelper.convertRowToProduct(item).toString()
								+ " is more than maximum!");
						setFlag(false);
					}
				} else if (correct == FunctionMenuHelper.SORTED_BY_MIN) {
					if (ProductHelper.convertRowToProduct(item).getPrice() < (int) min) {
						log("This element "
								+ ProductHelper.convertRowToProduct(item).toString()
								+ " is less than minimum!");
						setFlag(false);
					}
				}
			}
			if (MenuNextPrevSort.isNextPage()) {
				pageHelper.getMenu().clickGoToNextPage();
			} else
				break;
		}
		return flag;
	}

	// ///////////////////////////////////////////////////////////////////////////////////////////////

	public static boolean elementIsExist(String name) {
		if (!MenuNextPrevSort.isElementPresent(name)) {
			log(" The filter or category is not found!");
			return false;
		} else {
			return true;
		}
	}
	// ////////////////////////////////////////////////////////////////////////////////////////////////

	public static ProductsListPage saveLinksAndNameGoods(double count) {
		log("Saving of href and names of goods");
		name = new String[(int) count];
		href = new String[(int) count];
		for (int index = 1; index <= (int) count; index++) {
			name[index - 1] = pageHelper.getProductList().getProductsName()
					.get(index - 1).getText().replaceAll(" / ", "/");
			href[index - 1] = pageHelper.getProductList().getProductsName()
					.get(index - 1).getAttribute(PricePageHelper.ATTRIBURE_HREF);
		}
		return PageFactory.initElements(Component.getDriver(),
				ProductsListPage.class);
	}

	public static void openProductsAndCheckDescription(double count) {
		ProductDescription descriptionPage;
		List<String> listDescription;
		if(isCorrectCount(count)){
		log("Opening full description of goods");
		for (int index = 1; index <= count; index++) {
			String[] description;
			description = pageHelper.getProductList().getProductsDescription()
					.get(index - 1).getText().split(";");
			descriptionPage = pageHelper.getProductList()
					.openDescriptionProduct(index - 1);
			ProductDescriptionHelper
					.setProductDescriptionHelper(descriptionPage);
			listDescription = ProductDescriptionHelper.getInfoByProductToList();

			Assert.assertTrue("Full and summary description not the identical", checkFullDescriptionAndSummary(listDescription, description));
			Component.getDriver().navigate().back();
		}
		}else Assert.fail("Invalid input data!");

	}
	
	public static boolean isCorrectCount(double count) {
		boolean flag = true;
		if (count == -1 ) {
			log("<b><h3>"
					+ "The amount of goods for check isn't entered!"
					+ "</h3></b>");
			flag = false;
		} else if (count <= 0 ) {
			log("<b><h3>" + "Incorrect numbers of goods!" + "</h3></b>");
			flag = false;
		} else if (count > 20 ) {
			log("<b><h3>"
					+ "You can check the goods on the first page!Goods on page at most 20."
					+ "</h3></b>");
			flag = false;
		}
		return flag;
	}

	public static boolean checkFullDescriptionAndSummary(
			List<String> list, String[] description) {
		int count = 0;
		int countDescript = description.length - 1;

		log("Cheking full and summary description ");
		for (int index = 1; index < description.length; index++) {
			for(String row : list){
				if (row.indexOf(description[index].trim().replaceAll(":", "").toLowerCase()) != -1)
					count++;
			}
		}
		if (count != countDescript)
			return false;
		return true;
	}
	

	// //////////////////////////////////////////////////

	public static boolean getFlag() {
		return flag;
	}

	public static void setFlag(boolean flag) {
		ProductsListHelper.flag = flag;
	}

	public static ProductsListPage getPage() {
		return pageHelper;
	}
}
