package pageObject;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import static pageObject.OrganizationManagement.resetZoomToDefault;

public class Login {

    private WebDriver driver;
    JavascriptExecutor javascriptExecutor;
    Actions actions;
    Robot robot;
    static WebDriverWait wait;

    public static Properties properties;

    public Login(WebDriver driver) throws IOException {
        this.driver = driver;
        actions = new Actions(driver);
        try {
            robot = new Robot();
        } catch (AWTException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        wait=new WebDriverWait(driver,Duration.ofSeconds(101));
        javascriptExecutor = (JavascriptExecutor)this.driver;
        PageFactory.initElements(driver, this);
        properties = new Properties();
        FileInputStream fis1 = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\data.properties");
        properties.load(fis1);
    }
    @FindBy(xpath = "//input[@name='username']")
    private WebElement usernameTextField;
    @FindBy(xpath = "//input[@name='password']")
    private WebElement userpasswordTextField;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButton;
    @FindBy(xpath = "//p[.='Sign up']")
    private WebElement signUpLink;
    @FindBy(xpath = "//h5[.='Ready to sign up?']")
    private WebElement signUpHeader;
	@FindBy(xpath = "//input[@name='first_name']")
    private WebElement firstnameTextField;
    @FindBy(xpath = "//input[@name='last_name']")
    private WebElement lastnameTextField;
    @FindBy(xpath = "//input[@name='email']")
    private WebElement emailTextField;
    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordTextField;
    @FindBy(xpath = "//button[.='User Agreement']")
    private WebElement userAgreementLink;
	@FindBy(xpath = "//button[.='Privacy policy']")
    private WebElement privacyPolicyLink;
	@FindBy(xpath = "//button[.='Sign up']")
	private WebElement signUpButton;
	@FindBy(xpath = "//p[.='Login']")
	private WebElement loginLink;
	@FindBy(xpath = "//p[.='This field is required!']")	
	private List<WebElement> MandatoryfieldErrorMessage;
	@FindBy(xpath = "//button[@aria-label='toggle password visibility']/*[name()='svg' and @data-testid='VisibilityOffOutlinedIcon']")
    private List<WebElement> eyeIconList;
	@FindBy(xpath = "//p[contains(text(), \"Confirm Password don't match\")]")
	private WebElement passwordMismatchText;
	@FindBy(xpath = "//div[@id='notistack-snackbar']")
	private WebElement useragreementAndPrivacyPolicyToastMessage;
	@FindBy(xpath = "//input[@name='confirm_password']")
	private WebElement confirmpasswordTextField;
	@FindBy(xpath = "//h2[@id='scroll-dialog-title']")
	private WebElement useragreementAndPrivacyPolicyPageHeading;
	@FindBy(xpath = "//button[.='Read and agree']")
	private WebElement readAndAgreeButton;
	@FindBy(xpath = "//*[name()='svg' and @data-testid='CheckBoxIcon']")
	private List<WebElement> useragreementPrivacyPolicyCheckboxselected;
	@FindBy(xpath = "//button[.='Not agree and quit']")
	private WebElement NotAgreeAndQuitButton;
	@FindBy(xpath = "//*[name()='svg' and @data-testid='CheckBoxOutlineBlankIcon']")
	private List<WebElement> useragreementPrivacyPolicyCheckboxblank;
	@FindBy(xpath = "//*[name()='svg' and @data-testid='ArrowDropDownIcon']")
	private WebElement globalLanguageIcon;
	@FindBy(xpath = "//li[@role=\"menuitem\"]")
	private List<WebElement> lanuageList;
	@FindBy(xpath = "//p[.='Invalid email format']")
	private WebElement emailFormatErrorMessage;
	@FindBy(xpath = "//p[.='The password must be at least six digits and must contain numbers, large letters, lowercase, and special symbols']")
	private WebElement passwordFormatErrorMessage;
	
	@FindBy(xpath = "//p[.='Remember account in 5 day']")
	private WebElement RememberAccountIn5Day;
	
	@FindBy(xpath = "//p[.='Forgot password?']")
	private WebElement ForgotPasswordLink;
	
	@FindBy(xpath = "//input[@type='checkbox']")
	private WebElement  rememberAccountCheckbox;
	@FindBy(xpath = "//h6[.='Select organization']")
	private WebElement SelectOrganizationPageHeading;
	@FindBy(xpath = "//input[@role='combobox']")
	private WebElement selectOrganizationdropdownfield;
	@FindBy(xpath = "//button[.='Enter']")
	private WebElement EnterButton;
	@FindBy(xpath = "//p[.='Back to login']")
	private WebElement BackToLoginLink;
	
	public WebElement getBackToLoginLink() {
		return BackToLoginLink;
	}
	public WebElement getEnterButton() {
		return EnterButton;
	}
	public WebElement getSelectOrganizationPageHeading() {
		return SelectOrganizationPageHeading;
	}
	public WebElement getSelectOrganizationdropdownfield() {
		return selectOrganizationdropdownfield;
	}
	
	public WebElement getRememberAccountCheckbox() {
		return rememberAccountCheckbox;
	}
	public WebElement getRememberAccountIn5Day() {
		return RememberAccountIn5Day;
	}
	public WebElement getForgotPasswordLink() {
		return ForgotPasswordLink;
	}
	
	public WebElement getEmailFormatErrorMessage() {
		return emailFormatErrorMessage;
	}
	public WebElement getPasswordFormatErrorMessage() {
		return passwordFormatErrorMessage;
	}
	public WebElement getGlobalLanguageIcon() {
		return globalLanguageIcon;
	}
	public List<WebElement> getLanuageList() {
		return lanuageList;
	}
	
	
	public List<WebElement> getUseragreementPrivacyPolicyCheckboxblank() {
		return useragreementPrivacyPolicyCheckboxblank;
	}
	public WebElement getNotAgreeAndQuitButton() {
		return NotAgreeAndQuitButton;
	}
	public List<WebElement> getuseragreementPrivacyPolicyCheckboxselected() {
		return useragreementPrivacyPolicyCheckboxselected;
	}
	public WebElement getReadAndAgreeButton() {
		return readAndAgreeButton;
	}
	public WebElement getUseragreementAndPrivacyPolicyPageHeading() {
		return useragreementAndPrivacyPolicyPageHeading;
	}
	public WebElement getUseragreementAndPrivacyPolicyToastMessage() {
		return useragreementAndPrivacyPolicyToastMessage;
	}
	public WebElement getPasswordMismatchText() {
		return passwordMismatchText;
	}
	public List<WebElement> getEyeIconList() {
		return eyeIconList;
	}
	public WebElement getConfirmpasswordTextField() {
		return confirmpasswordTextField;
	}
	public List<WebElement> getMandatoryfieldErrorMessage() {
		return MandatoryfieldErrorMessage;
	}
	public WebElement getSignUpButton() {
		return signUpButton;
	}
	public WebElement getLoginLink() {
		return loginLink;
	}
	
	public WebElement getUserAgreementLink() {
		return userAgreementLink;
	}
	public WebElement getPrivacyPolicyLink() {
		return privacyPolicyLink;
	}
   
    public WebElement getSignUpHeader() {
		return signUpHeader;
	}
	public WebElement getFirstnameTextField() {
		return firstnameTextField;
	}
	public WebElement getLastnameTextField() {
		return lastnameTextField;
	}
	public WebElement getEmailTextField() {
		return emailTextField;
	}
	public WebElement getPasswordTextField() {
		return passwordTextField;
	}
    
    public WebElement getSignUpLink() {
		return signUpLink;
	}
	public WebElement getLoginButton() {
		return loginButton;
	}
	public void setLoginButton(WebElement loginButton) {
		this.loginButton = loginButton;
	}
	public WebElement getusernameTextField() {
		return usernameTextField;
	}
    public WebElement getuserpasswordTextField() {
		return userpasswordTextField;


	}
    
    public void SignUpPageElementsValidation() {
    	wait.until(ExpectedConditions.urlContains("/user/sign-up"));
    	Assert.assertTrue(getSignUpHeader().isDisplayed());
    	Assert.assertTrue(getFirstnameTextField().isDisplayed());
    	Assert.assertTrue(getLastnameTextField().isDisplayed());
    	Assert.assertTrue(getEmailTextField().isDisplayed());
    	Assert.assertTrue(getPasswordTextField().isDisplayed());
    	Assert.assertTrue(getConfirmpasswordTextField().isDisplayed());
    	Assert.assertTrue(getUserAgreementLink().isDisplayed());
    	Assert.assertTrue(getPrivacyPolicyLink().isDisplayed());
    	Assert.assertTrue(getSignUpButton().isDisplayed());
    	Assert.assertTrue(getLoginLink().isDisplayed());
    	
		
	}
    public void provideSignUpAllField(String firstname,String lastname,String email,String password,String confirmPassword) {
        getFirstnameTextField().sendKeys(firstname);
        getLastnameTextField().sendKeys(lastname);
    	getEmailTextField().sendKeys(email);
    	getPasswordTextField().sendKeys(password);
    	getConfirmpasswordTextField().sendKeys(confirmPassword);

	}
    public void validateUserAgreementPageForReadAndAgreeButton() {
    	String useragreementHeading=getUseragreementAndPrivacyPolicyPageHeading().getText();
    	if(useragreementHeading.contains("User Agreement")) {
    		getReadAndAgreeButton().click();
    	}
    List<WebElement>checkbox=getuseragreementPrivacyPolicyCheckboxselected();
    for(WebElement singleCheckbox:checkbox) {
    	singleCheckbox.isSelected();
    }	
	}
    public void validatePrivacyPolicyPageForReadAndAgreeButton() {
    	String useragreementHeading=getUseragreementAndPrivacyPolicyPageHeading().getText();
    	if(useragreementHeading.contains("Personal Data Protection and Privacy Policy")) {
    		getReadAndAgreeButton().click();
    	}
    List<WebElement>checkbox=getuseragreementPrivacyPolicyCheckboxselected();
    for(WebElement singleCheckbox:checkbox) {
    	singleCheckbox.isSelected();
	}
    }
    public void validateUserAgreementPageForNotAgreeAndQuit() {
    	String useragreementHeading=getUseragreementAndPrivacyPolicyPageHeading().getText();
    	if(useragreementHeading.contains("User Agreement")) {
    		getNotAgreeAndQuitButton().click();
    	}
    List<WebElement>checkbox=getUseragreementPrivacyPolicyCheckboxblank();
    for(WebElement singleCheckbox:checkbox) {
  boolean flag  =singleCheckbox.isSelected();
  Assert.assertTrue(flag==false);

    }
 	
	}
    public void validatePrivacyPolicyPageForNotAgreeAndQuit() {
    	String useragreementHeading=getUseragreementAndPrivacyPolicyPageHeading().getText();
    	if(useragreementHeading.contains("Personal Data Protection and Privacy Policy")) {
    		getNotAgreeAndQuitButton().click();
    	}
    List<WebElement>checkbox=getUseragreementPrivacyPolicyCheckboxblank();
    for(WebElement singleCheckbox:checkbox) {
    	 boolean flag  =singleCheckbox.isSelected();
    	Assert.assertTrue(flag==false);	
	}
    }
    public void validateLoginPage() {
    	wait.until(ExpectedConditions.urlContains("/user/login"));
    	Assert.assertTrue(getusernameTextField().isDisplayed());
    	Assert.assertTrue(getPasswordTextField().isDisplayed());
    	Assert.assertTrue(getLoginButton().isDisplayed());
    	Assert.assertTrue(getSignUpLink().isDisplayed());	
	}
    
    List<WebElement> languagelist;
    public void clickedOnGlobalLanguageIcon() {
   	 wait.until(ExpectedConditions.elementToBeClickable(getGlobalLanguageIcon()));
       WebElement langIcon	= getGlobalLanguageIcon();
       langIcon.click();
//   	 JavascriptExecutor jse = (JavascriptExecutor)driver;
//        jse.executeScript("arguments[0].click();", langIcon);
   	 System.out.println("Clicked on Language icon"); 	
   }
    public void languageValidation(String language) throws InterruptedException {
    	 languagelist= wait.until(ExpectedConditions.visibilityOfAllElements(getLanuageList()));
    		System.out.println("Found all the list size"+languagelist.size());
   	 for(WebElement ele:languagelist) {
   			if(ele.getText().trim().equals(language)) {
   				System.out.println("the language matched");
   				ele.click();
   				System.out.println("The user clicked on language is :"+ele.getText());
   				Thread.sleep(2000);
//   				Assert.assertTrue(driver.findElement(languageChangeToastMessage).isDisplayed()); 
   			WebElement loginButton	=getLoginButton();
   		       String signInButtonText=loginButton.getText();
   		       System.out.println("Login button text is:"+signInButtonText);
   			if(signInButtonText.equals("Login")
   					||signInButtonText.equals("登录")
   					||signInButtonText.equals("Iniciar sesión")
   					||signInButtonText.equals("ログイン")
   					||signInButtonText.equals("Se connecter")
   					||signInButtonText.equals("Anmeldung")
   					||signInButtonText.equals("Accedi")
   					||signInButtonText.equals("Iniciar sesión")) {
   		    System.out.println("The Sign in button name changed to:"+signInButtonText);
               break; // Break the loop if successful
   			}else {
   				System.out.println("Language is not present");
   			}
   			}
   	 }
   }
    public void login(String username,String password) {
    	getusernameTextField().sendKeys(username);
    	   getuserpasswordTextField().sendKeys(password);
	}



	//Syed's code
	public static void loginScenariomethod(WebDriver driver,Login login) throws Exception {
		resetZoomToDefault();
		driver.get(properties.getProperty("URL"));
		login.getusernameTextField().sendKeys(properties.getProperty("AdminEmailId"));
		login.getuserpasswordTextField().sendKeys(properties.getProperty("AdminPassword"));
		wait.until(ExpectedConditions.elementToBeClickable(login.getLoginButton())).click();
		wait.until(ExpectedConditions.urlContains("/dashboard"));
	}

}
