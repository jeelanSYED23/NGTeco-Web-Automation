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

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
public class Dashboard {
   

    private WebDriver driver;
    JavascriptExecutor javascriptExecutor;
    Actions actions;
    Robot robot;
    static WebDriverWait wait;

    public Properties properties;
    public Login login;

    public Dashboard(WebDriver driver) throws IOException {
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
    }
@FindBy(xpath = "//li[@class='MuiBreadcrumbs-li']")
private WebElement dashboardHead;
@FindBy(xpath = "//img[contains(@src, 'logo-zkbiobiotime-ngteco.png')]")
private WebElement logo;

@FindBy(xpath = "//div[@id='notistack-snackbar']")
private WebElement Incorrectauthenticationcredentialmessage;
@FindBy(xpath = "//div[@aria-label='Logout']")
private WebElement logoutIcon;
@FindBy(xpath = "//button[.='Confirm']")
private WebElement  confirmButton;
@FindBy(xpath = "//button[.='Cancel']")
private WebElement  CancelButton;
@FindBy(xpath = "//div[@aria-label='User Profile']")
private WebElement userProfileIcon;

@FindBy(xpath = "//ul[@role='menu']/div[@class='MuiBox-root css-0']")
private List<WebElement> userprofileDropdownOptionList;
@FindBy(xpath = "//input[@name='oldPassword']")
private WebElement oldpasswordField;
@FindBy(xpath = "//input[@name='newPassword']")
private WebElement newPasswordField;
@FindBy(xpath = "//input[@name='confirm_new_password']")
private WebElement confirmPasswordField;
@FindBy(xpath = "//button[@aria-label='toggle password visibility']")
private List<WebElement> resetPasswordEyeIcon;
@FindBy(xpath = "//div[@class='MuiGrid-root css-wstr4s']/p[.='Attendance']")
private WebElement AttendanceOverviewHeading;
@FindBy(xpath = "//p[.='Device Overview']")
private WebElement DeviceOverview;
@FindBy(xpath = "//p[.='Daily Attendance Records']")
private WebElement DailyAttendanceRecords;
@FindBy(xpath = "//p[.='Attendance Status']")
private WebElement AttendanceStatus;
@FindBy(xpath = "//div[@aria-label='Announcement']")
private WebElement AnnouncementIcon;

@FindBy(xpath = "//div[@aria-label='Help Info']")
private WebElement HelpInfoIcon;
@FindBy(xpath = "//div[@class='MuiBox-root css-9g4yx1']")
private WebElement languageIcon;
@FindBy(xpath = "//div[@class='MuiGrid-root css-rfnosa']/div[5]/div")
private List<WebElement> listOfModules;
@FindBy(xpath = "//div[.='Help Video']")
private WebElement HelpVideopageHeading;
@FindBy(xpath = "//div[contains(text(), 'Step')]")
private List<WebElement> listofVideos;

@FindBy(xpath = "//ul[@role=\"menu\"]/li[@role='menuitem']/div[contains(@class, \"MuiListItemText-root\")]")
private WebElement dashboadLanguageList;
@FindBy(xpath = "//div[.='Change Logs']")
private WebElement ChangeLogsOption;
@FindBy(xpath = "//h3[.='Change Logs']")
private WebElement ChangeLogsPageHeading;
@FindBy(xpath = "//div[@class='MuiGrid-root css-jx9mt8']")
private WebElement ChangeLogsInfo;
@FindBy(xpath = "//*[local-name()='svg']/*[local-name()='path' and @class='black']")
private WebElement ChangeLogQRCode;
@FindBy(xpath = "//a[.='View more details']")
private WebElement ChangeLogMoreDetailLink;
@FindBy(xpath = "//p[.='History version']")
private WebElement ChangelogHistoryversion;
@FindBy(xpath = "//a[contains(@href, 'User+Manual.pdf')]")
private WebElement userManualDocument;
@FindBy(xpath = "//div[.='New Timesheet']")
private WebElement NewTimesheetOption;
@FindBy(xpath = "//div[@class='MuiGrid-root css-rfnosa']/p/li")
private List<WebElement> timesheetNotes;
@FindBy(xpath = "//div[.='New Mobile Apps']")
private WebElement announcementMobileApps;
@FindBy(xpath = "//h2[contains(text(), 'NGTeco Application Support')]")
private WebElement NGTecoApplicationSupportHeading;
@FindBy(xpath = "//h6[contains(text(), 'Contact us through E-mail:')]")
private WebElement contactUsEmail;
@FindBy(xpath = "//input[@name='contactNumber']")
private WebElement ContactUscontactNumber;
@FindBy(xpath = "//textarea[@name='summary']")
private WebElement ContactUsSummary; 
@FindBy(xpath = "//textarea[@name='description']")
private WebElement ContactUsDescription;
@FindBy(xpath = "//textarea[@name='steps2reproduce']")
private WebElement ContactUsSteps2reproduce;
@FindBy(xpath = "//button[.='Save']")
private WebElement saveButton;
@FindBy(xpath = "//input[@name='companyName']")
private WebElement ContactUscompanyName;
@FindBy(xpath = "//input[@name='contactPerson']")
private WebElement ContactUscontactPerson;
@FindBy(xpath = "//input[@aria-autocomplete='list']")
private WebElement ContactUsCountryField;
@FindBy(xpath = "//input[@name='emailAddress']")
private WebElement contactUsEmailAddress;
@FindBy(xpath = "//div[@id='mui-component-select-impact']")
private WebElement contactUsImpactfield;
@FindBy(xpath = "//div[@id='mui-component-select-frequency']")
private WebElement contactUsFrequencyField;
@FindBy(xpath = "//div[@class='MuiDropzoneArea-textContainer']")
private WebElement contactUsDragAndDropfield;
@FindBy (xpath = "//li[@role='option']")
private List<WebElement> ContactUsDropDownList;
@FindBy(xpath = "//p[.='Organization Management']")
private WebElement OrganizationManagementModule;
@FindBy(xpath = "//input[@name='name']")
private WebElement organizationNameTextfield;
@FindBy(xpath = "//input[@name='code']")
private WebElement organizationCodeTextfield;
@FindBy(xpath = "//div[@aria-haspopup='listbox']")
private WebElement organizationCountryTextfield;
@FindBy(xpath = "//p[.='Organization Profile']")
private WebElement OrganizationProfileSubModule;
@FindBy (xpath = "//input[@name='firstName']")
private WebElement userfirstnametextfield;

@FindBy (xpath = "//input[@name='lastName']")
private WebElement userlastNametextfield;
@FindBy (xpath = "//input[@name='email']")
private WebElement useremailtextfield;
@FindBy(xpath = "//button[@aria-label='Edit']")
private WebElement AccountProfileEditIcon;

@FindBy(xpath = "//div[@class='MuiGrid-root css-1n92fa1']")
private WebElement editAccountProfilePageheading;

@FindBy (xpath = "(//input[@name='firstName'])[2]")
private WebElement editAccountProfileFirstname;
@FindBy (xpath = "(//input[@name='lastName'])[2]")
private WebElement editAccountProfileLastname;
@FindBy (xpath = "(//input[@name='email'])[2]")
private WebElement editAccountProfileemail;
@FindBy(xpath = "//label[@role='button']")
private WebElement addPhotoButton;
@FindBy(xpath = "//div[@class='MuiBox-root css-1kh8zkl']/div")
private List<WebElement> AboutPageList;
@FindBy(xpath = "//*[name()='svg' and @data-testid='ChevronLeftIcon']")
private WebElement backIcon;
@FindBy(xpath = "//ol[@class='MuiBreadcrumbs-ol css-nhb8h9']")
private WebElement AboutSectionHeading;
@FindBy(xpath = "//div[@class='MuiDialogContent-root css-1pov941']")
private WebElement deleteaccountPopUpWindowinfo;
@FindBy(xpath = "//button[.='OK']")
private WebElement OkButton;
@FindBy(xpath = "//button[@aria-label='Delete']")
private WebElement deleteIcon;
@FindBy(xpath = "//button[.='Check Asset']")
private WebElement CheckAssetButton;
@FindBy(xpath = "//div[.='The organization does not contain any other person or equipment.']")
private WebElement organiztaiondataValidationMessage;
@FindBy(xpath = "//div[@class='MuiGrid-root css-6m74ru']")
private WebElement activateDeleteAccountEmail;
@FindBy(xpath = "//input[@class='MuiInputBase-input MuiOutlinedInput-input css-1vvjlaa']")
private WebElement deleteOrganizationTextField;
@FindBy(xpath = "//button[.='Delete organization permanently']")
private WebElement DeleteOrganizationPermanentlyButtton;


public WebElement getDeleteOrganizationPermanentlyButtton() {
	return DeleteOrganizationPermanentlyButtton;
}
public WebElement getDeleteOrganizationTextField() {
	return deleteOrganizationTextField;
}
public WebElement getOrganiztaiondataValidationMessage() {
	return organiztaiondataValidationMessage;
}
public WebElement getActivateDeleteAccountEmail() {
	return activateDeleteAccountEmail;
}
public WebElement getCheckAssetButton() {
	return CheckAssetButton;
}
public WebElement getDeleteIcon() {
	return deleteIcon;
}
public WebElement getOkButton() {
	return OkButton;
}
public WebElement getDeleteaccountPopUpWindowinfo() {
	return deleteaccountPopUpWindowinfo;
}
public WebElement getAboutSectionHeading() {
	return AboutSectionHeading;
}
public WebElement getBackIcon() {
	return backIcon;
}
public List<WebElement> getAboutPageList() {
	return AboutPageList;
}
public WebElement getAddPhotoButton() {
	return addPhotoButton;
}
public WebElement getEditAccountProfilePageheading() {
	return editAccountProfilePageheading;
}
public WebElement getEditAccountProfileFirstname() {
	return editAccountProfileFirstname;
}
public WebElement getEditAccountProfileLastname() {
	return editAccountProfileLastname;
}
public WebElement getEditAccountProfileemail() {
	return editAccountProfileemail;
}
public WebElement getAccountProfileEditIcon() {
	return AccountProfileEditIcon;
}
public WebElement getUserfirstnametextfield() {
	return userfirstnametextfield;
}
public WebElement getUserlastNametextfield() {
	return userlastNametextfield;
}
public WebElement getUseremailtextfield() {
	return useremailtextfield;
}
public WebElement getOrganizationProfileSubModule() {
	return OrganizationProfileSubModule;
}
public WebElement getOrganizationManagementModule() {
	return OrganizationManagementModule;
}
public WebElement getOrganizationNameTextfield() {
	return organizationNameTextfield;
}
public WebElement getOrganizationCodeTextfield() {
	return organizationCodeTextfield;
}
public WebElement getOrganizationCountryTextfield() {
	return organizationCountryTextfield;
}
public List<WebElement> getContactUsDropDownList() {
	return ContactUsDropDownList;
}
public WebElement getContactUscompanyName() {
	return ContactUscompanyName;
}
public WebElement getContactUscontactPerson() {
	return ContactUscontactPerson;
}
public WebElement getContactUsCountryField() {
	return ContactUsCountryField;
}
public WebElement getContactUsEmailAddress() {
	return contactUsEmailAddress;
}
public WebElement getContactUsImpactfield() {
	return contactUsImpactfield;
}
public WebElement getContactUsFrequencyField() {
	return contactUsFrequencyField;
}
public WebElement getContactUsDragAndDropfield() {
	return contactUsDragAndDropfield;
}
public WebElement getSaveButton() {
	return saveButton;
}
public WebElement getContactUsDescription() {
	return ContactUsDescription;
}
public WebElement getContactUsSteps2reproduce() {
	return ContactUsSteps2reproduce;
}
public WebElement getContactUscontactNumber() {
	return ContactUscontactNumber;
}
public WebElement getContactUsSummary() {
	return ContactUsSummary;
}
public WebElement getContactUsEmail() {
	return contactUsEmail;
}
public WebElement getNGTecoApplicationSupportHeading() {
	return NGTecoApplicationSupportHeading;
}
public WebElement getAnnouncementMobileApps() {
	return announcementMobileApps;
}
public List<WebElement> getTimesheetNotes() {
	return timesheetNotes;
}
public WebElement getNewTimesheetOption() {
	return NewTimesheetOption;
}
public WebElement getUserManualDocument() {
	return userManualDocument;
}
public WebElement getChangelogHistoryversion() {
	return ChangelogHistoryversion;
}
public WebElement getChangeLogMoreDetailLink() {
	return ChangeLogMoreDetailLink;
}
public WebElement getChangeLogQRCode() {
	return ChangeLogQRCode;
}
public WebElement getChangeLogsPageHeading() {
	return ChangeLogsPageHeading;
}
public WebElement getChangeLogsInfo() {
	return ChangeLogsInfo;
}

public WebElement getChangeLogsOption() {
	return ChangeLogsOption;
}
public WebElement getDashboadLanguageList() {
	return dashboadLanguageList;
}
public WebElement getCancelButton() {
	return CancelButton;
}
public List<WebElement> getListofVideos() {
	return listofVideos;
}
public WebElement getHelpVideopageHeading() {
	return HelpVideopageHeading;
}
public WebElement getAnnouncementIcon() {
	return AnnouncementIcon;
}
public WebElement getHelpInfoIcon() {
	return HelpInfoIcon;
}
public WebElement getLanguageIcon() {
	return languageIcon;
}
public List<WebElement> getListOfModules() {
	return listOfModules;
}
public WebElement getAttendanceOverviewHeading() {
	return AttendanceOverviewHeading;
}
public WebElement getDeviceOverview() {
	return DeviceOverview;
}
public WebElement getDailyAttendanceRecords() {
	return DailyAttendanceRecords;
}
public WebElement getAttendanceStatus() {
	return AttendanceStatus;
}
public List<WebElement> getResetPasswordEyeIcon() {
	return resetPasswordEyeIcon;
}
public WebElement getUserProfileIcon() {
	return userProfileIcon;
}
public List<WebElement> getUserprofileDropdownOptionList() {
	return userprofileDropdownOptionList;
}
public WebElement getOldpasswordField() {
	return oldpasswordField;
}
public WebElement getNewPasswordField() {
	return newPasswordField;
}
public WebElement getConfirmPasswordField() {
	return confirmPasswordField;
}
public WebElement getConfirmButton() {
	return confirmButton;
}

public WebElement getLogoutIcon() {
	return logoutIcon;
}
public WebElement getDashboardHead() {
	return dashboardHead;
}
public WebElement getLogo() {
	return logo;
}

public WebElement getIncorrectauthenticationcredentialmessage() {
	return Incorrectauthenticationcredentialmessage;
}

public void dashboardValidation() {
	wait.until(ExpectedConditions.urlContains("/dashboard"));
//	wait.until(ExpectedConditions.visibilityOf(getDashboardHead()));
//	Assert.assertTrue(getDashboardHead().getText().equals("Dashboard"));
//	Assert.assertTrue(getLogo().isDisplayed());
//	Assert.assertTrue(getAttendanceOverviewHeading().isDisplayed());
//	Assert.assertTrue(getDeviceOverview().isDisplayed());
//	Assert.assertTrue(getDailyAttendanceRecords().isDisplayed());
//	Assert.assertTrue(getAttendanceStatus().isDisplayed());
//	Assert.assertTrue(getHelpInfoIcon().isDisplayed());
//	Assert.assertTrue(getAnnouncementIcon().isDisplayed());
//	Assert.assertTrue(getUserProfileIcon().isDisplayed());
//	Assert.assertTrue(getLogoutIcon().isDisplayed());
//	Assert.assertTrue(getLanguageIcon().isDisplayed());
//	List<WebElement> modulenames=getListOfModules();
//	for(int i=0;i<modulenames.size();i++) {
//		if(i==0) {
//			Assert.assertEquals(modulenames.get(i).getText(),"Dashboard");
//		}
//		else if(i==1){
//			Assert.assertEquals(modulenames.get(i).getText(),"Quickly Setting");
//		}
//		else if(i==2){
//			Assert.assertEquals(modulenames.get(i).getText(),"Organization Management");
//		}
//		else if(i==3){
//			Assert.assertEquals(modulenames.get(i).getText(),"Device Management");
//		}
//		else if(i==4){
//			Assert.assertEquals(modulenames.get(i).getText(),"Attendance");
//		}
//		else if(i==5){
//			Assert.assertEquals(modulenames.get(i).getText(),"Setting");
//		}
//		else if(i==6){
//			Assert.assertEquals(modulenames.get(i).getText(),"Operation Log");
//		}
//		else {
//			System.out.println("List is more");
//		}
//	}
//
//
}
public void clickOnUserProfileOptions(String option) {
	List<WebElement>userprofileDropdownOptions=getUserprofileDropdownOptionList();
	for(WebElement Singleoption:userprofileDropdownOptions) {
		if(Singleoption.getText().equals(option)) {
			Singleoption.click();
			break;
		}
	}
}
public void provideResetPasswordAllFieldsData(String oldpassword,String newpassword,String confirmPassword) {
	getOldpasswordField().sendKeys(oldpassword);
	getNewPasswordField().sendKeys(newpassword);
	getConfirmPasswordField().sendKeys(confirmPassword);
}
public void clearAllFieldInResetPasswordpage() {
	getOldpasswordField().clear();
	getNewPasswordField().clear();
	getConfirmPasswordField().clear();
}
public void ResetPasswordEyeIconValidation() throws InterruptedException {
	List<WebElement>eyeIconList=getResetPasswordEyeIcon();
	for (int i = 0; i < eyeIconList.size(); i++) {
	    // Click current eye icon
		eyeIconList.get(i).click();

	    // Wait briefly if needed (optional)
	    Thread.sleep(500);

	    // Validate only the corresponding field is of type 'text', others are 'password'
	    if (i == 0) {
	        assert getOldpasswordField().getAttribute("type").equals("text");
	        assert getNewPasswordField().getAttribute("type").equals("password");
	        assert getConfirmPasswordField().getAttribute("type").equals("password");
	    } else if (i == 1) {
	        assert getOldpasswordField().getAttribute("type").equals("password");
	        assert getNewPasswordField().getAttribute("type").equals("text");
	        assert getConfirmPasswordField().getAttribute("type").equals("password");
	    } else if (i == 2) {
	        assert getOldpasswordField().getAttribute("type").equals("password");
	        assert getNewPasswordField().getAttribute("type").equals("password");
	        assert getConfirmPasswordField().getAttribute("type").equals("text");
	    }

	    // Click again to hide
	    eyeIconList.get(i).click();
	}
	
}
public void playsHelpVideos(WebElement CancelConfirmButton) throws InterruptedException {
	wait.until(ExpectedConditions.visibilityOf(getHelpVideopageHeading()));
	
	Assert.assertTrue(getHelpVideopageHeading().isDisplayed());
	
	List<WebElement> listOfVideos=getListofVideos();
	for(int i=0;i<listOfVideos.size();i++) {
		if(listOfVideos.get(i).getText().equals("Step1: Power Connection")) {
		listOfVideos.get(i).click();
	WebElement video = wait.until(ExpectedConditions.visibilityOfElementLocated(
		    By.xpath("//video/source[contains(@src, 'Step1PowerConnection')]/parent::video")));	
		Assert.assertTrue(video.isDisplayed());
		javascriptExecutor.executeScript("document.querySelector('video').play();");
		Thread.sleep(3000); 
		javascriptExecutor.executeScript("document.querySelector('video').volume = 1.0;");

		javascriptExecutor.executeScript("document.querySelector('video').pause();");

		CancelConfirmButton.click();
		
}
		else if(listOfVideos.get(i).getText().equals("Step2: Configuring the Network")) {
			listOfVideos.get(i).click();
			WebElement video = wait.until(ExpectedConditions.visibilityOfElementLocated(
				    By.xpath("//video/source[contains(@src, 'Step2 Configuring the Network')]/parent::video")));	
				Assert.assertTrue(video.isDisplayed());
				javascriptExecutor.executeScript("document.querySelector('video').play();");
				Thread.sleep(3000); 
				javascriptExecutor.executeScript("document.querySelector('video').volume = 1.0;");
				javascriptExecutor.executeScript("document.querySelector('video').pause();");

				CancelConfirmButton.click();
		}
		else if(listOfVideos.get(i).getText().equals("Step3: Access the website")) {
			listOfVideos.get(i).click();
			WebElement video = wait.until(ExpectedConditions.visibilityOfElementLocated(
				    By.xpath("//video/source[contains(@src, 'Step3 Access the website')]/parent::video")));	
				Assert.assertTrue(video.isDisplayed());
				javascriptExecutor.executeScript("document.querySelector('video').play();");
				Thread.sleep(3000); 
				javascriptExecutor.executeScript("document.querySelector('video').volume = 1.0;");


				// Pause the video
				javascriptExecutor.executeScript("document.querySelector('video').pause();");

				CancelConfirmButton.click();
		}
		else if(listOfVideos.get(i).getText().equals("Step4: Add information")) {
			listOfVideos.get(i).click();
			WebElement video = wait.until(ExpectedConditions.visibilityOfElementLocated(
				    By.xpath("//video/source[contains(@src, 'Step4 add information')]/parent::video")));	
				Assert.assertTrue(video.isDisplayed());
				javascriptExecutor.executeScript("document.querySelector('video').play();");
				Thread.sleep(3000); 
				javascriptExecutor.executeScript("document.querySelector('video').volume = 1.0;");


				// Pause the video
				javascriptExecutor.executeScript("document.querySelector('video').pause();");

				CancelConfirmButton.click();
		}
		else if(listOfVideos.get(i).getText().equals("Step5: Add devices")) {
			listOfVideos.get(i).click();
			WebElement video = wait.until(ExpectedConditions.visibilityOfElementLocated(
				    By.xpath("//video/source[contains(@src, 'Step5 add devices')]/parent::video")));	
				Assert.assertTrue(video.isDisplayed());
				javascriptExecutor.executeScript("document.querySelector('video').play();");
				Thread.sleep(3000); 
				javascriptExecutor.executeScript("document.querySelector('video').volume = 1.0;");


				// Pause the video
				javascriptExecutor.executeScript("document.querySelector('video').pause();");

				
				CancelConfirmButton.click();
		}
		else if(listOfVideos.get(i).getText().equals("Step6: Synchronize Persons to device")) {
			listOfVideos.get(i).click();
			WebElement video = wait.until(ExpectedConditions.visibilityOfElementLocated(
				    By.xpath("//video/source[contains(@src, 'Step6 Synchronize Persons to Device')]/parent::video")));	
				Assert.assertTrue(video.isDisplayed());
				javascriptExecutor.executeScript("document.querySelector('video').play();");
				Thread.sleep(3000); 
				javascriptExecutor.executeScript("document.querySelector('video').volume = 1.0;");

				javascriptExecutor.executeScript("document.querySelector('video').pause();");

				CancelConfirmButton.click();
		}
		else if(listOfVideos.get(i).getText().equals("Step7: Timecard Management")) {
			listOfVideos.get(i).click();
			WebElement video = wait.until(ExpectedConditions.visibilityOfElementLocated(
				    By.xpath("//video/source[contains(@src, 'Step7 Timecard Management')]/parent::video")));	
				Assert.assertTrue(video.isDisplayed());
				javascriptExecutor.executeScript("document.querySelector('video').play();");
				Thread.sleep(3000); 
				javascriptExecutor.executeScript("document.querySelector('video').volume = 1.0;");

				javascriptExecutor.executeScript("document.querySelector('video').pause();");
//				getConfirmButton().click();
				CancelConfirmButton.click();
		}
	}
}
List<WebElement> languagelist;
public void DashboardlanguageValidation(String language) throws InterruptedException {
	languagelist= wait.until(ExpectedConditions.visibilityOfAllElements(getDashboadLanguageList()));
	System.out.println("Found all the list size"+languagelist.size());
  	 for(WebElement ele:languagelist) {
  			if(ele.getText().trim().equals(language)) {
  				System.out.println("the language matched");
  				ele.click();
  				System.out.println("The user clicked on language is :"+ele.getText());
  				Thread.sleep(2000);
  			
  			WebElement dashboardHeading	=getDashboardHead();
  		       String dashboardHeadingText=dashboardHeading.getText();
  		       System.out.println("Login button text is:"+dashboardHeading);
  			if(dashboardHeading.equals("Dashboard")
  					||dashboardHeading.equals("主页")
  					||dashboardHeading.equals("Tablero")
  					||dashboardHeading.equals("ダッシュボード")
  					||dashboardHeading.equals("Tableau de bord")
  					||dashboardHeading.equals("Dashboard")
  					||dashboardHeading.equals("Dashboard")
  					||dashboardHeading.equals("Tablero")) {
  		    System.out.println("The Sign in button name changed to:"+dashboardHeading);
              break; // Break the loop if successful
  			}else {
  				System.out.println("Language is not present");
  			}
  			}
  	 }
  }
public void ChnagelogAnnouncementValidation() {
getChangeLogsOption().click();
String changeLogHead=getChangeLogsPageHeading().getText();
Assert.assertEquals(changeLogHead,"Change Logs");
Assert.assertTrue(getChangeLogsInfo().getText().equals("Scan the QR code or click on the link to enter the comprehensive page of 'Changelog and Usage Guide'."));
Assert.assertTrue(getChangeLogQRCode().isDisplayed());
ChnagelogAnnouncementViewMoreDetailsPageValidation();

}
public void ChnagelogAnnouncementViewMoreDetailsPageValidation() {
	getChangeLogMoreDetailLink().click();
	Assert.assertTrue(getChangelogHistoryversion().isDisplayed());
	getUserManualDocument().click();
	String currentUrl=driver.getCurrentUrl();
	Assert.assertTrue(currentUrl.contains("/User+Manual"));
	driver.navigate().back();
	wait.until(ExpectedConditions.visibilityOf(AnnouncementIcon));
	
}
public void AnnouncementTimeSheetValidation() {
	getNewTimesheetOption().click();
	List<WebElement> timesheetInfoList=getTimesheetNotes();
	for(WebElement note:timesheetInfoList) {
		Assert.assertTrue(note.getText().contains("Timesheet"));
	}
	getConfirmButton().click();	
}
public void MobileAppsAnnouncement() {
	getAnnouncementMobileApps().click();
	List<WebElement> timesheetInfoList=getTimesheetNotes();
	for(WebElement note:timesheetInfoList) {
		Assert.assertTrue(note.isDisplayed());
	}
	getConfirmButton().click();	
	
}
public void CreateContactUsTicket(String impactOption, String frequencyOption) {
Assert.assertTrue(getNGTecoApplicationSupportHeading().isDisplayed());
Assert.assertTrue(getContactUsEmail().isDisplayed());
getContactUscontactNumber().sendKeys(properties.getProperty("ContactNumber"));
getContactUsSummary().sendKeys(properties.getProperty("ContactUsSummery"));
getContactUsDescription().sendKeys(properties.getProperty("contactUsDescription"));
getContactUsSteps2reproduce().sendKeys(properties.getProperty("contactUsStepsToReproduced"));
ContactUsImpactDropdownlistSelection(impactOption);
ContactUsFrequencyDropdownlistSelection(frequencyOption);
	getSaveButton().click();
	Assert.assertTrue(getIncorrectauthenticationcredentialmessage().getText().equals("Success"));
}
public void contactUsPageValidation() {
	Assert.assertTrue(getNGTecoApplicationSupportHeading().isDisplayed());
	Assert.assertTrue(getContactUsEmail().isDisplayed());
	Assert.assertTrue(getContactUscontactNumber().isDisplayed());
	Assert.assertTrue(getContactUsSummary().isDisplayed());
	Assert.assertTrue(getContactUsDescription().isDisplayed());
	Assert.assertTrue(getContactUsSteps2reproduce().isDisplayed());
	Assert.assertTrue(getContactUscompanyName().isDisplayed());
	Assert.assertTrue(getContactUscontactPerson().isDisplayed());
	Assert.assertTrue(getContactUsCountryField().isDisplayed());
	Assert.assertTrue(getContactUsDragAndDropfield().isDisplayed());
	Assert.assertTrue(getContactUsEmailAddress().isDisplayed());
	Assert.assertTrue(getContactUsImpactfield().isDisplayed());
	Assert.assertTrue(getContactUsFrequencyField().isDisplayed());
		
}
public void ContactUsImpactDropdownlistSelection(String Option) {
	getContactUsImpactfield().click();
List<WebElement>impactList=getContactUsDropDownList();

for (WebElement impactOption : impactList) {
	    String impactText = impactOption.getText().trim();
	    
	    if (impactText.equals(Option)) {
	        System.out.println("Handle Extensive/Outage case");
	        impactOption.click();
	        break;
	          
	    }else {
	        System.out.println("Unexpected option: " + impactText);
	    }
	}
}

public void ContactUsFrequencyDropdownlistSelection(String Option) {
	getContactUsFrequencyField().click();
List<WebElement>impactList=getContactUsDropDownList();

for (WebElement impactOption : impactList) {
	    String impactText = impactOption.getText().trim();
	    
	    if (impactText.equals(Option)) {
	        System.out.println("frequenct selecion: " +Option);
	        impactOption.click();
	        break;
	          
	    }else {
	        System.out.println("Unexpected option: " + impactText);
	    }
	}
}
public void contactUsPageFieldErrorvalidation() {
	getSaveButton().click();	
}
public String organizationName;
public String organizationCode;
public String organizationCountry;
public void OrganizationProfilePage() throws InterruptedException {
	getOrganizationManagementModule().click();
	getOrganizationProfileSubModule().click();
	Thread.sleep(1000);
	organizationName=getOrganizationNameTextfield().getAttribute("value");
	organizationCode=getOrganizationCodeTextfield().getAttribute("value");
	organizationCountry=getOrganizationCountryTextfield().getText();
	System.out.println("the org name is :"+organizationName);
	System.out.println("the org code is :"+organizationCode);
	System.out.println("the org country is :"+organizationCountry);
	
}
public String userfirstname;
public String userlastname;
public String useremail;
String fullName;
public void AccountProfilePage(String firstname,String lastname,String email  ) {
	getUserProfileIcon().click();
	
	userfirstname = getUserfirstnametextfield().getAttribute("value");
	userlastname=getUserlastNametextfield().getAttribute("value");
	useremail=getUseremailtextfield().getAttribute("value");
	fullName = userfirstname + " " + userlastname;
	System.out.println("Full Name: " + fullName); // Output: kunu sonu

	
	System.out.println("the user firstname is :"+userfirstname);
	System.out.println("the user lastname is :"+userlastname);
	System.out.println("the user email is :"+useremail);
	System.out.println("the user fullName is :"+fullName);
	
	Assert.assertTrue(!getUserfirstnametextfield().isEnabled());
	Assert.assertTrue(!getUserlastNametextfield().isEnabled());
	Assert.assertTrue(!getUseremailtextfield().isEnabled());
	Assert.assertTrue(getAccountProfileEditIcon().isDisplayed());
	
	Assert.assertTrue(userfirstname.equals(firstname));
	Assert.assertTrue(userlastname.equals(lastname));
	Assert.assertTrue(useremail.equals(email));
	
	driver.navigate().refresh();
	
}

public void contactUsPageDefaultDataFetchValidation() {
	String contactUsCompanyName=getContactUscompanyName().getAttribute("value");
	String contactUsContactPerson=getContactUscontactPerson().getAttribute("value");
	String contactUsCountry=getContactUsCountryField().getAttribute("value");
	String contactUsEmail=getContactUsEmailAddress().getAttribute("value");
	
	System.out.println("the contact us company name is :"+contactUsCompanyName);
	System.out.println("the contact us contact person is :"+contactUsContactPerson);
	System.out.println("the contact us country is :"+contactUsCountry);
	System.out.println("the contact us emailAdress is :"+contactUsEmail);
	
	Assert.assertTrue(contactUsCompanyName.equals(organizationName));
	Assert.assertTrue(contactUsContactPerson.equals(fullName));
	Assert.assertTrue(contactUsCountry.equals(organizationCountry));
	Assert.assertTrue(contactUsEmail.equals(useremail));
	
}
public void EditAccountProfile() throws InterruptedException {
	getAccountProfileEditIcon().click();
	Thread.sleep(2000);
	
	WebElement firstName = getEditAccountProfileFirstname();
	firstName.click();
	firstName.sendKeys(Keys.CONTROL + "a"); 
	firstName.sendKeys(Keys.BACK_SPACE);    
	firstName.sendKeys(properties.getProperty("editfirstname")); 
	
	
	WebElement lastname =getEditAccountProfileLastname();
	lastname.click();
	lastname.sendKeys(Keys.CONTROL + "a");
	lastname.sendKeys(Keys.BACK_SPACE);
	lastname.sendKeys(properties.getProperty("editlastname"));
	WebElement email=getEditAccountProfileemail();
	email.click();
	email.sendKeys(Keys.CONTROL + "a"); 
	email.sendKeys(Keys.BACK_SPACE);
	email.sendKeys(properties.getProperty("editemail"));
	getConfirmButton().click();
	
	
}
public void AccountProfilePhotoValidation() throws InterruptedException {
	WebElement addphotoButton=getAddPhotoButton();
	addphotoButton.click();
	Thread.sleep(2000);
	 String relativePath = "src/test/resources/4mb.jpg";
	File file = new File(relativePath);

	String absolutePath = file.getAbsolutePath();
	StringSelection selection = new StringSelection(absolutePath);
	Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
	//StringSelection selection = new StringSelection(filePath);
	 //   Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
	    System.out.println("Pasting file path...");
	    robot.keyPress(KeyEvent.VK_CONTROL);
	    robot.keyPress(KeyEvent.VK_V);
	    robot.keyRelease(KeyEvent.VK_V);
	    robot.keyRelease(KeyEvent.VK_CONTROL);

	    Thread.sleep(3000);

	    robot.keyPress(KeyEvent.VK_ENTER);
	    robot.keyRelease(KeyEvent.VK_ENTER);

	    Thread.sleep(2000); 
}
public void aboutPageValidation() throws InterruptedException {
	String[] sectionNames = {
	        "User Agreement",
	        "Privacy Policy",
	        "Info Collection Form",
	        "Compliance"
	    };

	    for (String section : sectionNames) {
	       
	        WebElement sectionElement = driver.findElement(By.xpath("//p[contains(text(),'" + section + "')]"));
	        sectionElement.click();
	        
	        WebElement content = wait.until(ExpectedConditions.visibilityOf(getAboutSectionHeading()));

	        Assert.assertTrue(content.isDisplayed());

	        System.out.println(section + " content: " + content.getText());

	        WebElement closeBtn = getBackIcon();
	        closeBtn.click();
	        Thread.sleep(1000);
	    }
}
public void deleteAccountValidation() {
	String deleteAccountInfo=getDeleteaccountPopUpWindowinfo().getText();
	Assert.assertTrue(deleteAccountInfo.equals(properties.getProperty("DeleteAccountInfo")));
	getConfirmButton().click();	
}
public void deleteAccountValidationwarningpopupWindow() {
	String deleteAccountwarning=getDeleteaccountPopUpWindowinfo().getText();
	Assert.assertTrue(deleteAccountwarning.equals(properties.getProperty("DeleteAccountWarningMessage")));
	getOkButton().click();
}
public void deleteOrganization() throws InterruptedException {
	getOrganizationManagementModule().click();
	getOrganizationProfileSubModule().click();
	getDeleteIcon().click();
	getCheckAssetButton().click();
	if(getOrganiztaiondataValidationMessage().getText().equals("The organization does not contain any other person or equipment.")) {
		String deleteAccountMail=getActivateDeleteAccountEmail().getText().trim();
		System.out.println("the email is :"+deleteAccountMail);
		getDeleteOrganizationTextField().click();
		getDeleteOrganizationTextField().sendKeys(deleteAccountMail);
		Assert.assertTrue(getDeleteOrganizationPermanentlyButtton().isEnabled());
		getDeleteOrganizationPermanentlyButtton().click();
		getConfirmButton().click();
		Thread.sleep(1000);
	}
}


//syed's code
@FindBy(xpath = "//button[@class='MuiButtonBase-root MuiFab-root MuiFab-circular MuiFab-sizeLarge MuiFab-default MuiFab-root MuiFab-circular MuiFab-sizeLarge MuiFab-default css-2pvxx0']//*[name()='svg']")
private WebElement chatBot;

	@FindBy(xpath="(//div[@class='MuiBox-root css-u420fw'])[1]")
	private  WebElement ChatBotFrame;

	@FindBy(xpath = "//input[@placeholder='Type your message']")
	private WebElement enterDataInsideChatBot;

	@FindBy(xpath = "//button[@title='Send Message']//*[name()='svg']")
	private WebElement chatBotSendButton;

	@FindBy(css="#chat-send-message-button")
	private WebElement chatBotButton;

	@FindBy(xpath="//p[text()='Greeting for the day! How can I assist you today?']")
	private WebElement DisplayedTextAfterAfterEnteringDataOnChatBot;

	@FindBy(xpath="(//button[@type='button'])[3]")
	private WebElement EndChatButton;

	@FindBy(xpath ="(//button[@type='button'])[3]")
	private WebElement MinimizeChatBotButton;

	@FindBy(xpath="//button[@id='richToolbarButton_0']")
	private WebElement Boldselect;

	@FindBy(xpath="//button[@id='richToolbarButton_1']")
	private WebElement Italicselect;

	@FindBy(xpath="//button[@id='richToolbarButton_2']")
	private WebElement orderListItems ;

	@FindBy(xpath="//button[@id='richToolbarButton_3']")
	private WebElement UnorderList;

	@FindBy(xpath="//button[@id='richToolbarButton_4']")
	private WebElement HyperLinkcommand;

	@FindBy(xpath="(//button[@type='button'])[2]")
	private WebElement DeleteChatBtn;

	@FindBy(xpath="(//div[@class='MuiBox-root css-1pr80hd'])[1]")
	private WebElement ChatBotScrollContainer;

	public WebElement getChatBot() {
		return chatBot;
	}

	public WebElement getenterDataInsideChatBot() {
		return enterDataInsideChatBot;
	}

	public WebElement getChatBotSendButton() {
		return chatBotSendButton;
	}

	public WebElement getchatBotButton() {
		return chatBotButton;
	}

	public WebElement getDisplayedTextAfterAfterEnteringDataOnChatBot(){
		return DisplayedTextAfterAfterEnteringDataOnChatBot;
	}

	public WebElement getEndChatButton(){
		return EndChatButton;
	}

	public WebElement getMinimizeChatBotButton(){
		return MinimizeChatBotButton;
	}

	public WebElement getItalicselect(){
		return Italicselect;
	}

	public WebElement getBoldselect(){
		return Boldselect;
	}

	public WebElement getOrderListItems(){
		return orderListItems;
	}

	public WebElement getUnorderList(){
		return UnorderList;
	}

	public WebElement getHyperLinkcommand(){
		return HyperLinkcommand;
	}

	public WebElement getDeleteChatBtn(){
		return DeleteChatBtn;
	}

	public  WebElement getChatBotScrollContainer(){
		return ChatBotScrollContainer;
	}

	public static void userSelectsTheChatbotAndEnteredTheMessage(WebDriver driver,Dashboard dashboard) throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(dashboard.getChatBot())).click();
		Thread.sleep(4000);
		WebElement inputBoxes = dashboard.getenterDataInsideChatBot();
		wait.until(ExpectedConditions.visibilityOf(inputBoxes));
		inputBoxes.sendKeys("Hello, how can I get help?");
		Thread.sleep(4000);
	}

	public static void userShouldAbleToGetTheResponseFromChatBot(WebDriver driver,Dashboard dashboard) throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(dashboard.getChatBotSendButton())).click();
		Thread.sleep(4000);
		WebElement chatResponse = dashboard.getDisplayedTextAfterAfterEnteringDataOnChatBot();
		try {
			if (wait.until(ExpectedConditions.visibilityOf(chatResponse)).isDisplayed()) {
				String botResponseText = chatResponse.getText();
				System.out.println("Chatbot replied: " + botResponseText);
			} else {System.out.println("Oops! Something went wrong. Could you please check back later?");
			}
		} catch (TimeoutException e) {
			System.out.println("Oops! Something went wrong. Could you please check back later?");}}

	public static void UsershouldscrollthechatBotwindowfrombottomtotopandfromtoptobottom(WebDriver driver,Dashboard dashboard) throws InterruptedException {

		WebElement inputBoxes = dashboard.getenterDataInsideChatBot();
		wait.until(ExpectedConditions.visibilityOf(inputBoxes));
		inputBoxes.sendKeys("I want more information about NGteco Application");
		wait.until(ExpectedConditions.elementToBeClickable(dashboard.getChatBotSendButton())).click();
		Thread.sleep(4000);
		wait.until(ExpectedConditions.visibilityOf(inputBoxes));
		inputBoxes.sendKeys("Hello, how can I get help?");
		WebElement chatScrollContainer = dashboard.getChatBotScrollContainer(); // Replace with actual method
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollTop = arguments[0].scrollHeight;", chatScrollContainer);
		Thread.sleep(2000); // Optional: wait to observe scroll
		js.executeScript("arguments[0].scrollTop = 0;", chatScrollContainer);
		wait.until(ExpectedConditions.elementToBeClickable(dashboard.getMinimizeChatBotButton())).click();
	}





}
