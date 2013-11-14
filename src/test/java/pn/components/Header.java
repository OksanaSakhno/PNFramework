package pn.components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Header extends Component{
	
	public static final String LOGIN_LINK = "div.enterBlock a.login_block_link";
	public static final String MAIN_LOGO = "a.mlogo img";
	public static final String REGISTRATION_LINK = "div.enterBlock a[href*='register']";
	
	
	@FindBy (css=Header.MAIN_LOGO)
	private WebElement mainLogo;
	
	
	@FindBy (css=Header.LOGIN_LINK)
	private WebElement logInLink;
	
	@FindBy (css=Header.REGISTRATION_LINK)
	private WebElement registrationLink;
	
	
	public static Header getHeader() {
		Header logoImg = PageFactory.initElements(Component.getDriver(), Header.class);
		return logoImg;
	}

			
	public WebElement getMainLogo() {
		return mainLogo;
	}
	
	public WebElement getLogInLink() {
		return logInLink;
	}
	
	
	public WebElement getRegistrationLink() {
		return registrationLink;
	}

		
	public void clickLogo(){
		getMainLogo().click();
	}
	
}
