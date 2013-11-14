package pn.components;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static pn.helpers.BaseTestHelper.*;
public class MenuNextPrevSort extends Component{
	
	public static final String PREV_LINK = "ul.pager li.pager-previous.first a";
	public static final String NEXT_LINK = "ul.pager li.pager-next a";
	public static final String PRISE_PAGE_LINK = "div.links-bar div.link a";
	public static final String TOTAL_PRODUCT_LIST = "div.total b";
	public static final String ALL_PRODUCTS_LINK = "div.total a";
	public static final String SEARCH_LINK = "input#edit-submit-1";
	public static final String SEARCH_INPUT = "input#edit-name-1";
	
	
	
	@FindBy (css=MenuNextPrevSort.PREV_LINK)
	private WebElement prevLink;
	
	
	@FindBy (css = MenuNextPrevSort.NEXT_LINK)
	private WebElement nextLink;
	
	
	@FindBy (css=MenuNextPrevSort.PRISE_PAGE_LINK)
	private WebElement pricePageLink;
	
	@FindBy (css=MenuNextPrevSort.TOTAL_PRODUCT_LIST)
	private WebElement totalProductsLink;

	
	@FindBy (css=MenuNextPrevSort.ALL_PRODUCTS_LINK)
	private WebElement allProductsLink;
	
	
	@FindBy (css=MenuNextPrevSort.SEARCH_LINK)
	private WebElement searchLink;

	
	@FindBy (css=MenuNextPrevSort.SEARCH_INPUT)
	private WebElement searchInput;
	
	
	public static MenuNextPrevSort getMenuComp() {
		MenuNextPrevSort menuSort = PageFactory.initElements(Component.getDriver(), MenuNextPrevSort.class);
		return menuSort;
	}
	
	
	public WebElement getAllProductsLink() {
		return allProductsLink;
	}

	public WebElement getPrevLink() {
		return prevLink;
	}

	public WebElement getNextLink() {
		return nextLink;
	}


	public WebElement getPricePageLink() {
		return pricePageLink;
	}

	public WebElement getTotalProductsLink() {
		return totalProductsLink;
	}
	
	
	public WebElement getSearchLink() {
		return searchLink;
	}


	public WebElement getSearchInput() {
		return searchInput;
	}

	public void clickPricePage(){
		getPricePageLink().click();
	}
	
	public void clickTotalProducts(){
		getTotalProductsLink().click();
	}
	
	public void clickAllProductsLink(){
		getAllProductsLink().click();
	}
	
	public void clickGoToNextPage(){
		getNextLink().click();
	}
	
	public static boolean isNextPage() {
		boolean flag = true;
		if (Component.getDriver().findElements(By.cssSelector(NEXT_LINK))
				.size() == 0)
			flag = false;
		return flag;
	}
	
	public static boolean isElementPresent(String name) {
		boolean flag = true;
		if (Component.getDriver().findElements(By.linkText(name))
				.size() == 0)
			flag = false;
		return flag;
	}
	
	
	public void clickGoToPrevPage(){
		getPrevLink().click();
	}
	
	public PricePage clickGoToPricePage(){
		getPricePageLink().click();
		return PageFactory.initElements(Component.getDriver(), PricePage.class);
	}
	
	public void searchString(String search){
		log("Finding elements by name " + search + " on the Price page ");
		getSearchInput().clear();
		getSearchInput().sendKeys(search);
		getSearchLink().click();
	}
	
}
