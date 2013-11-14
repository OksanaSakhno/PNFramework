package pn.components;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CompareComponent extends Component{
	
	public static final String NAME_PRODUCTS = "th.row-2>a";
	public static final String VALUE_ROW = "table.compare>tbody>tr>td+td";
	public static final String KEY_ROW = "//table[@class='compare']/tbody/tr/td[1]";
	public static final String DIFFERENT_VALUE_ROW = "//tr[@class='different']/td[1]";
	
	@FindBy (css=NAME_PRODUCTS)
	private List<WebElement> nameProducts;
	
	
	@FindBy (css=VALUE_ROW)
	private List<WebElement> valueRow;
	
	
	@FindBy (xpath=DIFFERENT_VALUE_ROW)
	private List<WebElement> differentValueRow;
	
	
	@FindBy (xpath=KEY_ROW)
	private List<WebElement> keyRow;
	
	public static CompareComponent getCompareComponent() {
		CompareComponent compareComp = PageFactory.initElements(Component.getDriver(), CompareComponent.class);
		return compareComp;
	}

	public List<WebElement> getNameProducts() {
		return nameProducts;
	}


	public List<WebElement> getValueRow() {
		return valueRow;
	}


	public List<WebElement> getKeyRow() {
		return keyRow;
	}

	
	public List<WebElement> getDifferentValueRow() {
		return differentValueRow;
	}



}
