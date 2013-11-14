package pn.components;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ProductsCatalog extends Component{
	
	public static final String ITEMS_OF_CATALOG = ".catalog > div.item";
	public static final String NAME_OF_PRODUCTS = "div.name a";
	public static final String PRICE_OF_PRODUCTS = "div.price strong";
	public static final String DESCRIPTION_OF_PRODUCTS = "div.item .description";
	public static final String HREF_OF_PRODUCTS = "div.name>a";
	public static final String ADD_LINK_TO_COMPARE = ".compare_add_link.comparep.cs";
	public static final String COMPARE_LINK = ".head-compare-link";

			
	@FindBy (css=ProductsCatalog.ITEMS_OF_CATALOG)
	private List<WebElement> itemsOfProductCatalog;
	
	@FindBy (css=ProductsCatalog.NAME_OF_PRODUCTS)
	private List<WebElement> productsName;
	
	@FindBy (css=ProductsCatalog.PRICE_OF_PRODUCTS)
	private List<WebElement> productsPrice;
	
	@FindBy (css=ProductsCatalog.DESCRIPTION_OF_PRODUCTS)
	private List<WebElement> productsDescription;
	
	@FindBy (css=ProductsCatalog.HREF_OF_PRODUCTS)
	private List<WebElement> productsHref;
	
	@FindBy (css=ProductsCatalog.ADD_LINK_TO_COMPARE)
	private List<WebElement> addLinkToCompare;
	
	@FindBy (css=ProductsCatalog.COMPARE_LINK)
	private List<WebElement> compareLink;

	
	public static ProductsCatalog getProductsList() {
		ProductsCatalog productsList = PageFactory.initElements(Component.getDriver(), ProductsCatalog.class);
		return productsList;
	}
	
	public List<WebElement> getItemsOfProductCatalog() {
		return itemsOfProductCatalog;
	}

	public List<WebElement> getProductsName() {
		return  productsName;
	}

	public List<WebElement> getProductsPrice() {
		return productsPrice;
	}

	public List<WebElement> getProductsHref() {
		return productsHref;
	}
	
	public List<WebElement> getProductsDescription() {
		return productsDescription;
	}

	public List<WebElement> getAddLinkToCompare() {
		return addLinkToCompare;
	}

	public List<WebElement> getCompareLink() {
		return compareLink;
	}
	
	public ProductDescription openDescriptByProductWithCompare(double element){
		getAddLinkToCompare().get((int)element-1).click();
		getProductsName().get((int)element-1).click();
		return PageFactory.initElements(Component.getDriver(), ProductDescription.class);
	}
	
	public ProductDescription openDescriptionProduct(double element){
		getProductsName().get((int)element).click();
		return PageFactory.initElements(Component.getDriver(), ProductDescription.class);
	}
	
	public void openCompare(){
		getCompareLink().get(1).click();
	}
	
}
