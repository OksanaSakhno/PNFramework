package pn.helpers;


import org.junit.Assert;
import org.openqa.selenium.WebElement;
import static pn.helpers.BaseTestHelper.*;
import pn.components.PricePage;
import pn.pages.ProductsListPage;


public class PricePageHelper {
	
	private static ProductsListPage page;
	public static final String ATTRIBURE_HREF = "href";
	
	public static void setPricePageHelper(ProductsListPage productPage){
		page = productPage;
	}
	
	public static boolean checkLinkByHref(PricePage pricePage, int index) {
		boolean flag = true;
		log("Cheking elements by href on the Price page ");
		for (WebElement item : pricePage.getDescriptionLink()) {
			if (!item.getAttribute(ATTRIBURE_HREF).equals(ProductsListHelper.href[index])) {
				log("This href refers to the description of other product "
						+ item.getAttribute(ATTRIBURE_HREF));
				flag = false;
			}
			Assert.assertTrue("Not all goods refer to the description of one goods!", flag);
		}
		return flag;
	}
	
	public static void checkSameLink() {
		log("Going to Price page ");
		PricePage pricePage = page.getMenu().clickGoToPricePage();
		for (int i = 0; i < ProductsListHelper.name.length; i++) {
			page.getMenu().searchString(ProductsListHelper.name[i]);
			checkLinkByHref(pricePage, i);
		}

	}
}
