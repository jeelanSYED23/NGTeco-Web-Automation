package pageObject;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import javax.management.loading.PrivateClassLoader;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mongodb.selector.PrimaryServerSelector;

import freemarker.ext.jsp.TaglibFactory.ClearMetaInfTldSource;
import utils.Base;

public class OrganizationManagement {
	public static OrganizationManagement organization;
	private WebDriver driver;
    JavascriptExecutor javascriptExecutor;
	private Actions actions;
    Robot robot;
	private static WebDriverWait wait;

    public Properties properties;
    public Login login;
    public Dashboard dashboard;
    public Base base;
    
    
    public OrganizationManagement(WebDriver driver) throws IOException {
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
        login=new Login(driver);
        dashboard=new Dashboard(driver);

        base=new Base();
		javascriptExecutor = (JavascriptExecutor) driver;
		PageFactory.initElements(driver, this); // ✅ Essential
    }
	public static void resetZoomToDefault() throws Exception {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_0);
		r.keyRelease(KeyEvent.VK_0);
		r.keyRelease(KeyEvent.VK_CONTROL);
	}


	@FindBy(xpath = "//p[.='Person']")
    private WebElement OrganizationPersonSubModule;
	@FindBy(xpath = "//i[@class='icon iconfont icon-ic_add']")
    private WebElement personAddIcon;
	@FindBy(xpath = "//input[@placeholder='Person ID']")
    private WebElement PersonIDTextField;
    @FindBy(xpath = "//input[@role='combobox']")
    private WebElement departmentTextField;
    @FindBy(xpath = "//input[@placeholder='First Name']")
    private WebElement FirstNameTextField;
    @FindBy(xpath = "//input[@placeholder='Last Name']")
    private WebElement LastNameTextField;
    @FindBy(xpath = "//input[@placeholder='Email']")
    private WebElement EmailTextField;
    @FindBy(xpath = "//p[.='No special character allowed!']")
    private WebElement specialCharMessage;
    @FindBy(xpath = "//i[@class='icon iconfont icon-ic_refresh']")
    private WebElement refreshIcon;
    @FindBy(xpath = "//div[@class='MuiDataGrid-row MuiDataGrid-row--lastVisible']")
    private WebElement personRow;
	@FindBy(xpath = "//input[@type='search']")
    private WebElement searchField;
	@FindBy(xpath = "(//div[@role='row']/div[@data-field='firstName'])[2]/div/div[2]")
	private WebElement personFirstnameData;
	@FindBy(xpath = "//div[@class='MuiDataGrid-virtualScrollerContent css-0']")
	private WebElement noRow;
	@FindBy(xpath = "//div[@aria-label='Person ID']")
	private WebElement PersonIDColumn;
	@FindBy(xpath = "//button[@aria-label='Edit']")
	private WebElement editIcon;
	@FindBy(xpath = "//button[@aria-label='Delete']")
	private WebElement deleteIcon;
	@FindBy(xpath = "//button[@aria-label='Mark as resigned']")
	private WebElement MarkasresignedIcon;
	@FindBy(xpath = "//div[@role='combobox']")
	private WebElement perPageDropdown;
	@FindBy(xpath = "//li[@role='option']")
	private List<WebElement>perpageDropdownList;
	@FindBy(xpath = "//p[@class='MuiTablePagination-displayedRows css-1chpzqh']")
	private WebElement totalRecordsValue;
	@FindBy(xpath = "//button[@aria-label='Go to previous page']")
	private WebElement previousPage;
	@FindBy(xpath = "//button[@aria-label='Go to next page']")
	private WebElement nextPage;
	@FindBy(xpath = "//div[@class='MuiAccordionDetails-root css-11fsdqv']/p[.='Resignation']")
	private WebElement ResignationSubModule;
	
	@FindBy(xpath = "//div[@role='columnheader']")
	private List<WebElement> columnheader;
	@FindBy(xpath = "//div[@class='MuiDataGrid-row MuiDataGrid-row--lastVisible']/div[@data-field='actions']/div/button")
	private List<WebElement> resignationpageIconList;
	@FindBy(xpath = "//div[@class='MuiDataGrid-row MuiDataGrid-row--lastVisible']")
    private List<WebElement> ResignpersonRowList;
	@FindBy(xpath = "//div[@class='MuiBox-root css-xi5klr' and .='Resume resignation']")
	private WebElement resumeResignationDialogpage;
	@FindBy(xpath = "//div[@role='row' and @aria-selected='false']")
	private List<WebElement>applicationTableList;
	@FindBy(xpath = "//div[@class='MuiBox-root css-xi5klr' and .='Delete Employee']")
	private WebElement deleteResignationDialogpage;
	@FindBy(xpath = "//span[.='Usage Tips']")
	private WebElement UsageTipsIcon;
	@FindBy(xpath = "//h2[.='Usage Tips']")
	private WebElement UsageTipsDialogHeading;
	@FindBy(xpath = "//div[@role='dialog']/div/div")
	private List<WebElement> UsageTipsPoints;
	
	public WebElement getUsageTipsDialogHeading() {
		return UsageTipsDialogHeading;
	}

	public List<WebElement> getUsageTipsPoints() {
		return UsageTipsPoints;
	}
	public WebElement getUsageTipsIcon() {
		return UsageTipsIcon;
	}

	public WebElement getDeleteResignationDialogpage() {
		return deleteResignationDialogpage;
	}

	public List<WebElement> getApplicationTableList() {
		return applicationTableList;
	}

	public WebElement getResumeResignationDialogpage() {
		return resumeResignationDialogpage;
	}

	public List<WebElement> getResignpersonRowList() {
		return ResignpersonRowList;
	}

	public WebElement getResignationSubModule() {
		return ResignationSubModule;
	}

	public List<WebElement> getResignationpageIconList() {
		return resignationpageIconList;
	}
	public List<WebElement> getColumnheader() {
		return columnheader;
	}
	public WebElement getPreviousPage() {
		return previousPage;
	}
	public WebElement getNextPage() {
		return nextPage;
	}

	public WebElement getTotalRecordsValue() {
		return totalRecordsValue;
	}
	public WebElement getPerPageDropdown() {
		return perPageDropdown;
	}
	public List<WebElement> getPerpageDropdownList() {
		return perpageDropdownList;
	}

	public WebElement getMarkasresignedIcon() {
		return MarkasresignedIcon;
	}
	public WebElement getDeleteIcon() {
		return deleteIcon;
	}
	public WebElement getEditIcon() {
		return editIcon;
	}
	public WebElement getPersonIDColumn() {
		return PersonIDColumn;
	}
	public WebElement getNoRow() {
		return noRow;
	}
	public WebElement getPersonFirstnameData() {
		return personFirstnameData;
	}
	public WebElement getSearchField() {
		return searchField;
	}
    public WebElement getPersonRow() {
		return personRow;
	}
	public WebElement getRefreshIcon() {
		return refreshIcon;
	}
	public WebElement getSpecialCharMessage() {
		return specialCharMessage;
	}
	public WebElement getPersonAddIcon() {
		return personAddIcon;
	}
    public WebElement getPersonIDTextField() {
		return PersonIDTextField;
	}

	public WebElement getDepartmentTextField() {
		return departmentTextField;
	}

	public WebElement getFirstNameTextField() {
		return FirstNameTextField;
	}

	public WebElement getLastNameTextField() {
		return LastNameTextField;
	}

	public WebElement getEmailTextField() {
		return EmailTextField;
	}
    public WebElement getOrganizationPersonSubModule() {
    	return OrganizationPersonSubModule;
    }

public void AddPerson(String personID,String personfirstname,String perspnlastname ,String personemail ) throws InterruptedException {
	
	getPersonIDTextField().sendKeys(personID);
	getDepartmentTextField().click();
	getDepartmentTextField().sendKeys(Keys.ARROW_DOWN);
	getDepartmentTextField().sendKeys(Keys.ENTER);
	getFirstNameTextField().sendKeys(personfirstname);
	getLastNameTextField().sendKeys(perspnlastname);
	getEmailTextField().sendKeys(personemail);
	dashboard.getConfirmButton().click();
	Thread.sleep(500);
	
}
public void EditPerson(String personfirstname,String perspnlastname ) throws InterruptedException, AWTException {
	
   Assert.assertTrue(!getPersonIDTextField().isEnabled());
	getDepartmentTextField().click();
	getDepartmentTextField().sendKeys(Keys.ARROW_DOWN);
	getDepartmentTextField().sendKeys(Keys.ENTER);
	
	base.Clear(getFirstNameTextField());
	getFirstNameTextField().sendKeys(personfirstname);
	
	base.Clear(getLastNameTextField());
	getLastNameTextField().sendKeys(perspnlastname);
	Assert.assertTrue(!getEmailTextField().isEnabled());
	dashboard.getConfirmButton().click();
	Thread.sleep(500);
	
}
public void PerPageDropdownOptionSelection(int perPageNumber) throws InterruptedException {
getPerPageDropdown().click();
Thread.sleep(1000);
wait.until(ExpectedConditions.visibilityOfAllElements(getPerpageDropdownList()));
List<WebElement> perPageOptions=getPerpageDropdownList();
Assert.assertTrue(perPageOptions.size()==3);
for(WebElement option:perPageOptions) {
	String perpageValue=option.getText();
	int number = Integer.parseInt(perpageValue);
	if(number==perPageNumber) {
		option.click();
		Thread.sleep(1000);
		break;
	}
}
	
}
public void validatePagination() {
	String totalRecordsValue=getTotalRecordsValue().getText();
	String[] parts = totalRecordsValue.split(" of ");
	String result = parts[1];
	int totalRecords=Integer.parseInt(result);
	if(totalRecords>10 && getNextPage().isEnabled()) {
		getNextPage().click();
		Assert.assertTrue(getPreviousPage().isEnabled());
		getPreviousPage().click();
		
	}
	else {
		System.out.println("the prevoius page and next page is disable as there are only one page records are available ");
	}
	
}
public void ResignationPageValidation() {
	List<WebElement> Columnheaders=getColumnheader();
	
	for(WebElement column:Columnheaders) {
	String columnText=column.getText();
	if(columnText.equals("Person Name")) {
		System.out.println("the Person Name column is present");
	}
	else if(columnText.equals("Person ID")){
		System.out.println("the Person ID column is present");
	}else if(columnText.equals("Department")){
		System.out.println("the Department column is present");
	}else if(columnText.equals("Action")){
		System.out.println("the Action column is present");
	}
	else {
		System.err.println("Coulmn are different");
	}
	}
	ResignedPersonActionIcon();
	
	
}
public void ResignedPersonActionIcon() {
	if(getResignpersonRowList().size()>0) {
		List<WebElement> resignationActionIcons=getResignationpageIconList();
		for(WebElement ActionIcon:resignationActionIcons) {
			String actioniconName=ActionIcon.getText();
			if(actioniconName.equals("Resume resignation")) {
				System.out.println("Resume resignation is present");
			}
			else if(actioniconName.equals("View")) {
				System.out.println("View is present");
			}
			else if(actioniconName.equals("Delete")) {
				System.out.println("Delete is present");
			}
			else{
				System.out.println("new icon added or deleted old icon");
			}
		}	
		}
		else {
			System.out.println("There are no resigned person");
			throw new RuntimeException("There are no resigned person");
		}
	
}
public void clickOnResignedPersonIcons(String iconName) {
	if(getResignpersonRowList().size()>0) {
		List<WebElement> resignationActionIcons=getResignationpageIconList();
		for(WebElement ActionIcon:resignationActionIcons) {
			String actioniconName=ActionIcon.getText();
			if(actioniconName.equals(iconName)) {
				ActionIcon.click();
			}
		}
			
		}
}
public void ViewResignedPerson() throws InterruptedException, AWTException {
	
	   Assert.assertTrue(!getPersonIDTextField().isEnabled());
	   Assert.assertTrue(!getDepartmentTextField().isEnabled());
	   Assert.assertTrue(!getFirstNameTextField().isEnabled());
	   Assert.assertTrue(!getLastNameTextField().isEnabled());
		dashboard.getCancelButton().click();
		
		
	}
public void resumeResignationDialogPageValiadation() {
	
	
Assert.assertTrue(getResumeResignationDialogpage().isDisplayed());

	
}
int BeforeDeletelistCount;
public void tableListValidationBeforeDeleteOrResumeResignation() {
	List<WebElement> tabelListCount=getApplicationTableList();
	BeforeDeletelistCount=tabelListCount.size();
	
}
int afterDeletelistCount;
public void tableListValidationAfterDeleteOrResumeResignation() {
	
	List<WebElement> tabelListCount=getApplicationTableList();
	afterDeletelistCount=tabelListCount.size();
	if(afterDeletelistCount<BeforeDeletelistCount) {
		System.out.println("Resource deleted/Resume resignation successfully");
	}
	
}
public void deleteResignedDialogPageValiadation() {	
Assert.assertTrue(getDeleteResignationDialogpage().isDisplayed());	
}


//syed's code

	@FindBy(css = "input[id=':r3:']")
	private WebElement SelectOrganizationdropdown;


	@FindBy(css = "body > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(5) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > p:nth-child(2)")
	private WebElement OrganizationManagementBtn;

	@FindBy(xpath = "(//p[text()='Organization Profile'])[1]")
	private WebElement organization_profile_btn;

	@FindBy(xpath = "//p[text()='Edit']")
	private WebElement EditButton_Hover;

	@FindBy(xpath = "//p[text()='Delete']")
	private WebElement DeleteHover_btn;

	@FindBy(xpath = "//button[@aria-label='Organization is one of your family, restaurant, office, working space, etc. Inside an organization, you can create some groups, departments. Groups can have family members or some of your employees']//i[@class='icon iconfont icon-ic_about']")
	private WebElement Information_Icon1;

	@FindBy(xpath = "//button[@aria-label='Organization code is the unique code for the system to identify your organization. You can modify the organization name later, but the organization code will not change. You can use combinations of letters and numbers to form an organization code. Easy-to-remember organization code will help you find relevant information faster. Example: Office954, MyHome001']//i[@class='icon iconfont icon-ic_about']")
	private WebElement Information_Icon2;

	@FindBy(xpath = "(//button[normalize-space()='Enter'])[1]")
	private WebElement EnterOrganizationBtn;

	@FindBy(css = "button[aria-label='Delete'] svg")
	private WebElement DeleteOrganizationBtn;

	@FindBy(xpath = "(//button[normalize-space()='Check Asset'])[1]")
	private WebElement AssertBtn;

	@FindBy(xpath = "//*[text()='to activate delete']/following::div[1]//input")
	private WebElement ActivationCodeField;

	@FindBy(xpath = "(//button[normalize-space()='Delete organization permanently'])[1]")
	private WebElement DeletePermanetlybtn;

	@FindBy(xpath = "//button[normalize-space()='Confirm']")
	private WebElement DeleteOrgPopupWindow;

	@FindBy(xpath = "//button[@aria-label='Edit']//*[name()='svg']")
	private WebElement EditorganizationBtn;

	@FindBy(css = "div[class='MuiInputBase-root MuiOutlinedInput-root MuiInputBase-colorPrimary MuiInputBase-fullWidth MuiInputBase-formControl css-msgv56']")
	private WebElement EditOrganizationtextField;

	@FindBy(xpath = "(//button[normalize-space()='Confirm'])[1]")
	private WebElement organizationEditConfirmbtn;

	@FindBy(xpath = ("//div[@id='notistack-snackbar']//*[name()='svg']"))
	private WebElement Validate_Edit_Toast_message;

	@FindBy(xpath = "//p[text()='This field is required!']")
	private WebElement Validate_OrgNametextfield;

	@FindBy(css = "input[id=':r14:']")
	private WebElement EnterOrganizatioName;

	@FindBy(xpath = "//button[normalize-space()='Cancel']")
	private WebElement OrgCancelBtn;

	@FindBy(css = "body > div.MuiDrawer-root.MuiDrawer-modal.MuiModal-root.css-y28f86 > div.MuiPaper-root.MuiPaper-elevation.MuiPaper-elevation16.MuiDrawer-paper.MuiDrawer-paperAnchorRight.css-1ab2xsx > div > div.MuiGrid-root.css-lac5ca > div.MuiGrid-root.css-rfnosa > div > div")
	private WebElement changeCountryDropdown;

	@FindBy(xpath = "//label[text()='Add photos']")
	private WebElement EditProfilePhotoIcon;

	@FindBy(xpath = "(//ul[@role='listbox'])[1]//li")
	private List<WebElement> CountryListFororganization;

	@FindBy(xpath="//*[text()='Name cannot exceed 200 characters in length.']")
	private WebElement Org_Name_Exceeds_200chars;

	@FindBy(xpath = "//*[text()='Organization Deleted Successfully']")
	private WebElement Organization_Deleted_Successfully;

	@FindBy(xpath="//button[text()='Cancel']")
	private WebElement Organization_Delete_Cancel_btn;

	@FindBy(xpath="//input[@type='file']")
	private WebElement Upload_Photo_uploadicon;

	@FindBy(xpath="(//*[text()='Photos size up to maximum 3 MB'])[1]")
	private WebElement ProfilePhoto_With_4MB;



	public WebElement getOrganizationManagementBtn() {
		return OrganizationManagementBtn;
	}

	public WebElement getOrganization_profile_btn() {
		return organization_profile_btn;
	}

	public WebElement getEditButton_Hover() {
		return EditButton_Hover;
	}

	public WebElement getDeleteHover_btn() {
		return DeleteHover_btn;
	}

	public WebElement getInformation_Icon1() {
		return Information_Icon1;
	}

	public WebElement getInformation_Icon2() {
		return Information_Icon2;
	}

	public WebElement getSelectOrganizationdropdown() {
		return SelectOrganizationdropdown;
	}

	public WebElement getEnterOrganizationBtn() {
		return EnterOrganizationBtn;
	}

	public WebElement getDeleteOrganizationBtn() {

		return DeleteOrganizationBtn;
	}

	public WebElement getAssertBtn() {
		return AssertBtn;
	}

	public WebElement getActivationCodeField() {
		return ActivationCodeField;
	}

	public WebElement getDeletePermanetlybtn() {
		return DeletePermanetlybtn;
	}

	public WebElement getDeleteOrgPopupWindow() {
		return DeleteOrgPopupWindow;
	}

	public WebElement getEditorganizationBtn() {
		return EditorganizationBtn;
	}

	public WebElement getEditOrganizationtextField() {
		return EditOrganizationtextField;
	}

	public WebElement getorganizationEditConfirmbtn() {
		return organizationEditConfirmbtn;
	}

	public WebElement getValidate_Edit_Toast_message() {
		return Validate_Edit_Toast_message;
	}

	public WebElement getValidate_OrgNametextfield() {
		return Validate_OrgNametextfield;
	}

	public WebElement getEnterOrganizatioName() {
		return EnterOrganizatioName;
	}

	public WebElement getOrgCancelBtn() {
		return OrgCancelBtn;
	}

	public WebElement getchangeCountryDropdown() {
		return changeCountryDropdown;
	}

	public WebElement getEditProfilePhotoIcon() {
		return EditProfilePhotoIcon;
	}

	public List<WebElement> getCountryListFororganization() {
		return CountryListFororganization;
	}

	public WebElement   getOrg_Name_Exceeds_200chars(){
		return  Org_Name_Exceeds_200chars;
	}

	public WebElement getOrganization_Deleted_Successfully(){
		return Organization_Deleted_Successfully;
	}

	public WebElement getOrganization_Delete_Cancel_btn(){
		return Organization_Delete_Cancel_btn;
	}

	public WebElement getUpload_Photo_uploadicon(){
		return Upload_Photo_uploadicon;
	}

	public WebElement getProfilePhoto_With_4MB(){
		return ProfilePhoto_With_4MB;
	}



	public static void ValidateAllTheMentionedCountryListInEditOrganization(WebDriver driver, OrganizationManagement organization) throws Exception {
		resetZoomToDefault();
//        wait.until(ExpectedConditions.elementToBeClickable(organization.getOrganization_profile_btn())).click();
//        wait.until(ExpectedConditions.elementToBeClickable(organization.getEditorganizationBtn())).click();
		Thread.sleep(2000);
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(organization.getchangeCountryDropdown())).click();
		WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(organization.getchangeCountryDropdown()));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", dropdown);
		Thread.sleep(2000);
		List<WebElement> countryList = organization.getCountryListFororganization();
		System.out.println("Available Countries:");
		for (WebElement country : countryList) {
			System.out.println(country.getText());
		}
		WebElement unitedKingdomOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='United Kingdom']")));
		unitedKingdomOption.click();
	}
	public static void userCanUpdateTheProfilePhotoWhichIsMoreThanMBSize(WebDriver driver,OrganizationManagement organization) throws Exception {
		resetZoomToDefault();
		wait.until(ExpectedConditions.elementToBeClickable(organization.getOrganization_profile_btn())).click();
		wait.until(ExpectedConditions.elementToBeClickable(organization.getEditorganizationBtn())).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(organization.getEditProfilePhotoIcon())).click();
		Thread.sleep(4000);
		File file1 = new File("src/test/resources/3MB_Pic.lnk");
		WebElement uploadElement = organization.getUpload_Photo_uploadicon();
		uploadElement.sendKeys(file1.getAbsolutePath());
		Thread.sleep(2000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ESCAPE);
		robot.keyRelease(KeyEvent.VK_ESCAPE);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(organization.getOrgCancelBtn())).click();
		wait.until(ExpectedConditions.elementToBeClickable(organization.getEditorganizationBtn())).click();
// wait.until(ExpectedConditions.elementToBeClickable(organization.getEditProfilePhotoIcon())).click();
		File file2 = new File("src/test/resources/4mb_image.jpg");
		WebElement uploadElement1 = organization.getUpload_Photo_uploadicon();
		uploadElement1.sendKeys(file2.getAbsolutePath());
		robot.keyPress(KeyEvent.VK_ESCAPE);
		robot.keyRelease(KeyEvent.VK_ESCAPE);
		wait.until(ExpectedConditions.visibilityOf(organization.getProfilePhoto_With_4MB())).isDisplayed();


	}


}


