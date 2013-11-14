package pn.components;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static pn.helpers.BaseTestHelper.*;

public class FunctionMenu extends Component {

	public static final String MIN_PRICE = "//div[@class='group'][1]/div[@class='is_empty_items']";
	public static final String MAX_PRICE = "//div[@class='group'][2]/div[@class='is_empty_items']";
	public static final String COMMON_VENDORS = "показать все";
	public static final String PRODUCERS = "//div[@class='group'][3]/div[@class='is_empty_items']/a";
	public static final String PRODUCERS_HIDE = "div.common_group_producer.hide a";

	@FindBy(xpath = MIN_PRICE)
	private WebElement minLink;

	@FindBy(xpath = MAX_PRICE)
	private WebElement maxLink;

	@FindBy(xpath = PRODUCERS)
	private List<WebElement> producersList;

	@FindBy(css = PRODUCERS_HIDE)
	private List<WebElement> producersHideList;

	public static FunctionMenu getFunctionMenuPanel() {
		FunctionMenu functionMenu = PageFactory.initElements(Component.getDriver(),
				FunctionMenu.class);
		return functionMenu;
	}

	

	public void clickToMinLink(String min) {
		try {
			getMinLink().findElement(By.linkText(min)).click();
		} catch (NoSuchElementException e) {
			log("<b><h3>" + "For these goods there is no such filter at the price!"  + "</h3></b>");
			Assert.fail();
		}
	}

	public void clickToMaxLink(String max) {
		try {
			getMaxLink().findElement(By.linkText(max)).click();
		} catch (NoSuchElementException e) {
			log("<b><h3>" + "For these goods there is no such filter at the price!"  + "</h3></b>");
			Assert.fail();
		}
	}

	public static void clickToCommonVendorList(String linkName) {
		try {
			Component.getDriver().findElement(By.linkText(linkName)).click();
		} catch (NoSuchElementException e) {
			log("<b><h3>" + "The link is not found!"  + "</h3></b>");
			Assert.fail();
		}
	}
	
	public static void clickToFunction(String function){
		Component.getDriver().findElement(By.linkText(function)).click();
	}

	public WebElement getMinLink() {
		return minLink;
	}

	public WebElement getMaxLink() {
		return maxLink;
	}

	public List<WebElement> getProducersList() {
		return producersList;
	}

	public List<WebElement> getProducersHideList() {
		return producersHideList;
	}

	
}
