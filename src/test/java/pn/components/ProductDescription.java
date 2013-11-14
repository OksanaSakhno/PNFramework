package pn.components;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDescription extends Component{
	
	public static final String INFO_ABOUT_PRODUCT = ".panel.corner.item-stats div.row span";
	public static final String INFO_KEY = ".panel.corner.item-stats div.row span.pr";
	public static final String INFO_VALUE = ".panel.corner.item-stats div.row span.val";
	
	
	@FindBy (css=ProductDescription.INFO_ABOUT_PRODUCT)
	private List<WebElement> fullInfoAboutProduct;
	
	
	@FindBy (css=ProductDescription.INFO_KEY)
	private List<WebElement> infoKey;
	
	
	@FindBy (css=ProductDescription.INFO_VALUE)
	private List<WebElement> infoValue;
	

	public static ProductDescription getInfoAboutProduct() {
		ProductDescription productInfo = PageFactory.initElements(Component.getDriver(), ProductDescription.class);
		return productInfo;
	}

	
	public List<WebElement> getInfoKey() {
		return infoKey;
	}


	public List<WebElement> getInfoValue() {
		return infoValue;
	}
	
	public List<WebElement> getFullInfoAboutProduct() {
		return fullInfoAboutProduct;
	}
	
	
}
