package pn.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pn.components.ProductsCatalog;
import pn.pages.Product;
import pn.pages.ProductsListPage;

public class ProductHelper {
	static ProductsListPage page;

	public static void setProductHelper(ProductsListPage pageMain) {
		page = pageMain;
	}

	public static Product convertRowToProduct(WebElement item) {
		String name, price, description, href;
		name = item.findElement(
				By.cssSelector(ProductsCatalog.NAME_OF_PRODUCTS)).getText();
		price = item.findElement(
				By.cssSelector(ProductsCatalog.PRICE_OF_PRODUCTS)).getText();
		description = item.findElement(
				By.cssSelector(ProductsCatalog.DESCRIPTION_OF_PRODUCTS))
				.getText();
		href = item.findElement(
				By.cssSelector(ProductsCatalog.HREF_OF_PRODUCTS)).getAttribute(
						PricePageHelper.ATTRIBURE_HREF);
		return new Product().withName(name)
				.withPrice(parceStringToInt(price))
				.wihtDescription(description).wihtHref(href);
	}

	public static int parceStringToInt(String price) {
		String s = "";
		for (int i = 0; i < price.length(); i++) {
			if (Character.isDigit(price.charAt(i)))
				s += price.charAt(i);
		}
		return Integer.parseInt(s);
	}
	
}
