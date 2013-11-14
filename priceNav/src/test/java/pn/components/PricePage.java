package pn.components;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PricePage extends Component{
	
	public static final String DESCRIPTION_LINK = "a.description-link";
	
	
	@FindBy (css=PricePage.DESCRIPTION_LINK)
	private List<WebElement> descriptionLink;


	public static PricePage getPricePage() {
		PricePage pricePage = PageFactory.initElements(Component.getDriver(), PricePage.class);
		return pricePage;
	}
	
	
	public List<WebElement> getDescriptionLink() {
		return descriptionLink;
	}


}
