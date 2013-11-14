package pn.pages;

import java.util.HashMap;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pn.components.CompareComponent;
import pn.components.Component;
import pn.components.FunctionMenu;
import pn.components.MenuNextPrevSort;
import pn.components.ProductsCatalog;


public class ProductsListPage extends Component{

	private ProductsCatalog productList;
	private MenuNextPrevSort menu;
	private FunctionMenu functionalPanel;
	private CompareComponent compareComp;
	public HashMap<Integer, Product> listOfcatalog = new HashMap<Integer, Product>();
	public List<WebElement> listOfGoods;
	

	public ProductsListPage() {
		this.productList = ProductsCatalog.getProductsList();
		this.menu = MenuNextPrevSort.getMenuComp();
		this.functionalPanel = FunctionMenu.getFunctionMenuPanel();
		this.compareComp = CompareComponent.getCompareComponent();
		listOfGoods = productList.getItemsOfProductCatalog();
	}
	
	
	public static ProductsListPage getProductListPage() {
		ProductsListPage productListPage = PageFactory.initElements(Component.getDriver(), ProductsListPage.class);
		return productListPage;
	}


	public ProductsCatalog getProductList() {
		return productList;
	}

	public MenuNextPrevSort getMenu() {
		return menu;
	}


	public FunctionMenu getFunctionalPanel() {
		return functionalPanel;
	}


	public CompareComponent getCompareComp() {
		return compareComp;
	}
	
	
	public void clickByFilter(String filter) {
		Component.getDriver().findElement(By.linkText(filter)).click();
	}
	

}
