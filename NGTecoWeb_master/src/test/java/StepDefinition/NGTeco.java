package StepDefinition;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static pageObject.Attendance.*;
import static pageObject.Attendance.scrollTopToBottomAndBack;
import static pageObject.Login.loginScenariomethod;
import static pageObject.OrganizationManagement.ValidateAllTheMentionedCountryListInEditOrganization;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.Set;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import pageObject.*;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.core.gherkin.Argument;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
//import pageObjects.Login;
//import pageObjects.Superuser;
//import pageObjects.customerPageObjects;
//import pageObjects.graphicDesignerPageObjects;
import utils.Base;

import utils.ReusableFunctions;

public class NGTeco extends Base {

	//	private static final int T = 0;
	String email = "test" + RandomStringUtils.randomAlphanumeric(5) + "@example.com";
	String password = "R" + RandomStringUtils.randomAlphanumeric(5) + "a1@";
	String randomPersonId = RandomStringUtils.randomAlphanumeric(5);
	String organizationName_200 = RandomStringUtils.randomAlphabetic(201);
	String YourNewOrganizationName = RandomStringUtils.randomAlphabetic(10);
	String Invalid_personId = RandomStringUtils.randomAlphabetic(5);
	String Invalid_personName = RandomStringUtils.randomAlphabetic(5);
	String RandomTimeSheetName = RandomStringUtils.randomAlphabetic(5);


	private WebDriver driver;
	private Properties properties;
	private JavascriptExecutor js;
	public Login login;
	public Dashboard dashboard;
	public OrganizationManagement organizationManagement;
	public DeviceManagement deviceManagement;
	public OrganizationManagement organization;

	WebDriverWait wait;
	public Robot robot;
	static File upload_file;
	public Attendance attendance;
	public ReusableFunctions reus;

	@Before("@NGTeco")
	public void setup() throws Exception {
		properties = new Properties();
		FileInputStream fis1 = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\data.properties");
		FileInputStream fis = new FileInputStream(".//src//test//resources//data.properties");
		upload_file = new File(System.getProperty("user.dir") + "//src//test//resources//3MB_Pic.lnk");
		upload_file = new File(System.getProperty("user.dir") + "//src//test//resources//4mb_image.jpg");
		properties.load(fis1);

		properties.load(fis1);
		// driver = initializeDriver("chrome", "x64", "Linux");
		driver = initializeDriver("chrome", "x64", "windows");
		driver.manage().window().maximize();


		login = new Login(driver);
		dashboard = new Dashboard(driver);
		organizationManagement = new OrganizationManagement(driver);
		deviceManagement = new DeviceManagement(driver);
		attendance = new Attendance(driver);
		organization = new OrganizationManagement(driver);

		reus = new ReusableFunctions();
		wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		js = (JavascriptExecutor) driver;
		js.executeScript("document.body.style.zoom='67%'");
		robot = new Robot();

	}
	public String getTodayDateAsNumber() {
		return LocalDate.now().format(DateTimeFormatter.ofPattern("ddMMyyyy"));
	}

	public String getCurrentTimeAsNumber() {
		return LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm"));
	}
	@After("@NGTeco")
	public void teardown(Scenario scenario) throws IOException, InterruptedException {
		if (scenario.isFailed()) {
			scenario.attach(getByteScreenshot(driver), "image/png", "screenshot name");
			driver.close();

		}
		driver.close();
		driver.quit();
	}

	public void resetZoomToDefault() throws Exception {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_0);
		r.keyRelease(KeyEvent.VK_0);
		r.keyRelease(KeyEvent.VK_CONTROL);
	}

	private byte[] getByteScreenshot(WebDriver driver) {
		// TODO Auto-generated method stub
		return null;
	}

	@Given("User has launched the URL")
	public void User_has_launched_the_URL() throws Exception {
		driver.get(properties.getProperty("URL"));
		windowMinimize(4);

	}

	@Given("user will provide valid username and password")
	public void userWillProvideValidUsernameAndPassword() {
		login.login(properties.getProperty("email"), properties.getProperty("password1"));
	}

	@When("user will click on Login button")
	public void userWillClickOnLoginButton() {
//login.getLoginButton().click();
		wait.until(ExpectedConditions.elementToBeClickable(login.getLoginButton())).click();

	}

	@Then("user will validate user navigate to login page")
	public void userWillValidateDashboardPage() {

		wait.until(ExpectedConditions.urlContains("/user/login"));
	}

	@When("User will click on SignUp link in login page")
	public void userWillClickOnSignUpLinkInLoginPage() {
		login.getSignUpLink().click();

	}
	//syed's code

	@Given("user login to the application")
	public void userlogintotheapplication() throws Exception {

		Login loginFeature = new Login(driver);
		loginScenariomethod(driver, login);
//		driver.get(properties.getProperty("URL"));
//		login.getusernameField().sendKeys(properties.getProperty("AdminEmailId"));
//		login.getuserpasswordTextField().sendKeys(properties.getProperty("AdminPassword"));
//		wait.until(ExpectedConditions.elementToBeClickable(login.getLoginButton())).click();
//		wait.until(ExpectedConditions.urlContains("/dashboard"));
	}

	@Given("when Admin click on Attendance module")
	public void whenAdminclickonAttendancemodule() {
		AttendanceModuleMethod(driver, attendance);
		//wait.until(ExpectedConditions.elementToBeClickable(attendance.getAttendance_Module())).click();
	}
	@When("User navigates to Shift schedule sub module")
	public void userNavigatesToShiftScheduleSubModule() {
		WebElement ScrollUntil = wait.until(ExpectedConditions.elementToBeClickable(attendance.getShiftScheduleSubModule()));
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true);", ScrollUntil);
		ScrollUntil.click();
	}
	@Then("user can create shift schedule with valid timesheet and person")
	public void userCanCreateShiftScheduleWithValidTimesheetAndPerson() {
		wait.until(ExpectedConditions.visibilityOf(attendance.getAddShiftScheduleBtn())).click();
		wait.until(ExpectedConditions.visibilityOf(attendance.getAddShiftPerson())).click();
		wait.until(ExpectedConditions.visibilityOf(attendance.getAddPersonUnderShift())).click();
		wait.until(ExpectedConditions.visibilityOf(attendance.getAddpersonConfirmBtn())).click();
		wait.until(ExpectedConditions.visibilityOf(attendance.getAddShifttimesheetBtn())).click();
		wait.until(ExpectedConditions.visibilityOf(attendance.getAddTimeShiftForShift())).click();

	}
	@Then("User is trying to add a shift schedule by leaving mandatory fields")
	public void userIsTryingToAddAShiftScheduleByLeavingMandatoryFields() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(attendance.getAddShiftScheduleBtn())).click();
		wait.until(ExpectedConditions.visibilityOf(attendance.getAddShiftPerson())).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(attendance.getAddpersonConfirmBtn())).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(attendance.getAddShifttimesheetBtn())).click();
		wait.until(ExpectedConditions.visibilityOf(attendance.getAddpersonConfirmBtn())).click();

		Actions actions = new Actions(driver);
		WebElement selectStartTime = wait.until(ExpectedConditions.visibilityOf(attendance.getAddStartDateBtn()));
		actions.click(selectStartTime)
				.keyDown(Keys.CONTROL)
				.sendKeys("a")
				.keyUp(Keys.CONTROL)
				.sendKeys(Keys.BACK_SPACE)
				.perform();

		WebElement endTimeClick = wait.until(ExpectedConditions.visibilityOf(attendance.getAddEndTimeBtn()));
		Thread.sleep(1000);
		actions.click(endTimeClick)
				.keyDown(Keys.CONTROL)
				.sendKeys("a")
				.keyUp(Keys.CONTROL)
				.sendKeys(Keys.BACK_SPACE)
				.perform();
		wait.until(ExpectedConditions.elementToBeClickable(attendance.getShiftConfirmBtn())).click();
		Thread.sleep(2000);
	}
	@Then("User should validate the presence of all components in Shift shedule page")
	public void userShouldValidateThePresenceOfAllComponentsInShiftShedulePage() {

		wait.until(ExpectedConditions.visibilityOf(attendance.getAddShiftScheduleBtn())).isDisplayed();
		wait.until(ExpectedConditions.visibilityOf(attendance.getDeleteShiftScheduleBtn())).isDisplayed();
		WebElement ContextClick= wait.until(ExpectedConditions.visibilityOf(attendance.getShiftRefreshicon()));
		Actions Action=new Actions(driver);
		Action.doubleClick(ContextClick).perform();

		List<WebElement> HeaderList = attendance.getView_Attendance_All_Headers();
		System.out.println("Available Headers:");
		for (WebElement headers : HeaderList) {
			System.out.println(headers.getText() + "\t");
		}
		List<WebElement> listrecords = attendance.getTo_Display_All_records();
		System.out.println("Available records");
		for (WebElement total_Rec : listrecords) {
			System.out.println(total_Rec.getText());
		}


		WebElement CalculateICon= wait.until(ExpectedConditions.visibilityOf(attendance.getShiftCalculatorICon()));
		Actions actions = new Actions(driver);
		actions.moveToElement(CalculateICon).perform();


	}

	@And("Selected View Attendance punch")
	public void SelectedViewAttendancepunch() {

		Attendance.SelectedViewAttendancepunch(driver, attendance);
//		wait.until(ExpectedConditions.elementToBeClickable(attendance.getView_Attendance_Punch())).click();
//		wait.until(ExpectedConditions.urlContains("/transaction"));
	}

	@Then("User validate the SignUp page elements")
	public void userValidateTheSignUpPageElements() {
		login.SignUpPageElementsValidation();
	}

	@And("User click on SignUp button")
	public void userClickOnSignUpButton() {
		login.getSignUpButton().click();

	}

	@Then("validate the error message for all the text field")
	public void validateTheErrorMessageForAllTheTextField() {
		List<WebElement> manadatoryFieldList = login.getMandatoryfieldErrorMessage();
		for (WebElement ele : manadatoryFieldList) {
			Assert.assertTrue(ele.getText().equals("This field is required!"));

		}
	}

	@Then("User will provide password and confirm password field")
	public void userWillProvidePasswordAndConfirmPasswordField() {
		login.getPasswordTextField().sendKeys(properties.getProperty("password"));
		login.getConfirmpasswordTextField().sendKeys(properties.getProperty("password"));
	}

	@Then("User will provide password and confirm password field data mismatch")
	public void userWillProvidePasswordAndConfirmPasswordFieldDataMismatch() {
		login.getPasswordTextField().sendKeys(properties.getProperty("password"));
		login.getConfirmpasswordTextField().sendKeys("random@123");
		login.getSignUpButton().click();
	}

	@Then("User will validate hidden password visibility by clicking Eye icon")
	public void userWillValidateHiddenPasswordVisibilityByClickingEyeIcon() {
		List<WebElement> passwordEyeList = login.getEyeIconList();
		for (WebElement eye : passwordEyeList) {
			eye.click();
			boolean flag = true;
			if (flag) {
				String passwordValue = login.getPasswordTextField().getAttribute("value");
				Assert.assertTrue(passwordValue.equals(properties.getProperty("password")));

			} else {
				String confirmpasswordValue = login.getConfirmpasswordTextField().getAttribute("value");
				Assert.assertTrue(confirmpasswordValue.equals(properties.getProperty("password")));

			}
			flag = false;
		}

	}

	@Then("User will validate password mismatch message")
	public void userWillValidatePasswordMismatchMessage() {
		String passwordmismatchText = login.getPasswordMismatchText().getText();
		System.out.println("the text is :" + passwordmismatchText);
		Assert.assertTrue(passwordmismatchText.equals("Confirm Password don't match"));
	}

	@Then("user provide all the sign up page textfield data")
	public void userProvideAllTheSignUpPageTextfieldData() {
		login.provideSignUpAllField("fghj", "dfdfghj", "fghj@fghj.fgh", "Admin@123", "Admin@123");

	}

	@Then("user validate userAgreement and privacy policy toast message")
	public void userValidateUserAgreementAndPrivacyPolicyToastMessage() {
		Assert.assertTrue(login.getUseragreementAndPrivacyPolicyToastMessage().isDisplayed());
	}

	@And("User click on User agreement read and agree button and validate user agreement checkbox")
	public void userClickOnUserAgreementAndValidateUserAgreementCheckbox() {
		login.getUserAgreementLink().click();
		login.validateUserAgreementPageForReadAndAgreeButton();


	}

	@Then("User click on privacy policy read and agree button and validate user agreement checkbox")
	public void userClickOnPrivacyPolicyAndValidateUserAgreementCheckbox() {
		login.getPrivacyPolicyLink().click();
		login.validatePrivacyPolicyPageForReadAndAgreeButton();
	}

	@And("User click on User agreement Not agree and quit button and validate user agreement checkbox")
	public void userClickOnUserAgreementNotAgreeAndQuitButtonAndValidateUserAgreementCheckbox() {
		login.getUserAgreementLink().click();
		login.validateUserAgreementPageForNotAgreeAndQuit();
	}

	@And("User click on privacy policy Not agree and quit button and validate user agreement checkbox")
	public void userClickOnPrivacyPolicyNotAgreeAndQuitButtonAndValidateUserAgreementCheckbox() {
		login.getPrivacyPolicyLink().click();
		login.validatePrivacyPolicyPageForNotAgreeAndQuit();
	}

	@And("User click on Login link in SignUp page")
	public void userClickOnLoginLinkInSignUpPage() {
		login.getLoginLink().click();
		;

	}

	@Then("validate user navigate to Login page")
	public void validateUserNavigateToLoginPage() {
		login.validateLoginPage();
	}

	@When("User click on Language Icon")
	public void userClickOnLanguageIcon() {
		login.clickedOnGlobalLanguageIcon();

	}

	@And("Select the respective language and validate the application page language is getting change")
	public void selectOneByOneLanguageAndValidateTheApplicationPageLanguageIsGettingChange() throws InterruptedException {
		login.languageValidation(properties.getProperty("SpanishLanguage"));
	}

	@And("User provide all the mandatory fields for sign up")
	public void userProvideAllTheMandatoryFieldsForSignUp() {
		login.provideSignUpAllField(properties.getProperty("firstname"), properties.getProperty("lastname"), properties.getProperty("email"), properties.getProperty("password1"), properties.getProperty("ConfirmPassword"));
	}

	@And("Validate user login to the application using the same credntial")
	public void validateUserLoginToTheApplicationUsingTheSameCredntial() {
		login.getusernameTextField().sendKeys(properties.getProperty("emailAddress"));
		login.getuserpasswordTextField().sendKeys(properties.getProperty("password"));
		wait.until(ExpectedConditions.elementToBeClickable(login.getLoginButton())).click();

	}

	@Then("user will validate dashboard page")
	public void userWillValidateDashboardPage1() {
		dashboard.dashboardValidation();

	}

	@Then("User validate user already exist toast message")
	public void userValidateUserAlreadyExistToastMessage() {
		String userExistMessage = login.getUseragreementAndPrivacyPolicyToastMessage().getText();
		assertEquals(userExistMessage, properties.getProperty("UserAlreadyExist"));

	}

	@And("User provide invalid format mail,password fields for sign up")
	public void userProvideInvalidFormatMailPasswordFieldsForSignUp() {
		login.provideSignUpAllField(properties.getProperty("firstname"), properties.getProperty("lastname"), properties.getProperty("InvalidFormatEmailId"), properties.getProperty("InvalidFormatpassword"), properties.getProperty("InvalidFormatpassword"));

	}

	@Then("Validate format error message for email, password")
	public void validateFormatErrorMessageForEmailPassword() {
		Assert.assertTrue(login.getEmailFormatErrorMessage().getText().equals("Invalid email format"));
		Assert.assertTrue(login.getPasswordFormatErrorMessage().getText().equals("The password must be at least six digits and must contain numbers, large letters, lowercase, and special symbols"));
	}

	@Then("User has already launch the application in background and validating login page elements")
	public void userHasAlreadyLaunchTheApplicationInBackgroundAndValidatingLoginPageElements() {
		wait.until(ExpectedConditions.urlContains("/user/login"));
		Assert.assertTrue(login.getusernameTextField().isDisplayed());
		Assert.assertTrue(login.getPasswordTextField().isDisplayed());
		Assert.assertTrue(login.getLoginButton().isDisplayed());
		Assert.assertTrue(login.getRememberAccountIn5Day().isDisplayed());
		Assert.assertTrue(login.getForgotPasswordLink().isDisplayed());


	}

	@Given("user will provide invalid username and password")
	public void userWillProvideInvalidUsernameAndPassword() {
		login.login(properties.getProperty("WrongUsername"), properties.getProperty("WrongPassword"));

	}

	@Then("user will validate error toast message")
	public void userWillValidateErrorToastMessage() {
		wait.until(ExpectedConditions.visibilityOf(dashboard.getIncorrectauthenticationcredentialmessage())).isDisplayed();
	}

	@And("user select the remember account for {int} days checkbox")
	public void userSelectTheRememberAccountForDaysCheckbox(int arg0) {
		login.getRememberAccountCheckbox().click();
		Assert.assertTrue(login.getRememberAccountCheckbox().isSelected());
	}

	@And("Again launch the application url in new tab in the same browser window")
	public void closeTheBrowserTab() throws Exception {

		String parentTab = driver.getWindowHandle();
		Thread.sleep(1000);
		((JavascriptExecutor) driver).executeScript("window.open('about:blank','_blank');");
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> tabs = new ArrayList<>(windowHandles);

		driver.switchTo().window(tabs.get(tabs.size() - 1));
		driver.get(properties.getProperty("URL"));

	}


	@And("Logout from the application")
	public void logoutFromTheApplication() {
		dashboard.getLogoutIcon().click();
		dashboard.getConfirmButton().click();
	}

	@Given("user will provide old user username and password")
	public void userWillProvideOldUserUsernameAndPassword() {
		login.login(properties.getProperty("oldUsername"), properties.getProperty("oldUserPassword"));
	}

	@Then("user validate select Organization page")
	public void userValidateSelectOrganizationPage() {
		wait.until(ExpectedConditions.urlContains("/user/organ-selection"));
		Assert.assertTrue(login.getSelectOrganizationPageHeading().isDisplayed());
		Assert.assertTrue(login.getSelectOrganizationdropdownfield().isDisplayed());


	}

	@And("select the organization from the dropdown")
	public void selectTheOrganizationFromTheDropdown() throws InterruptedException {
		login.getSelectOrganizationdropdownfield().click();
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);

		Thread.sleep(500); // Let it settle
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		login.getEnterButton().click();
	}

	@Then("user validate error message for email and password field")
	public void userValidateErrorMessageForEmailAndPasswordField() {
		List<WebElement> loginFieldError = login.getMandatoryfieldErrorMessage();
		for (WebElement ele : loginFieldError) {
			Assert.assertTrue(ele.getText().equals("This field is required!"));
			Assert.assertTrue(ele.getText().equals("This field is required!"));
		}
	}

	@And("user click on the enter button without selecting organization from dropdown")
	public void userClickOnTheEnterButtonWithoutSelectingOrganizationFromDropdown() {
		login.getEnterButton().click();
	}

	@Then("user will validate toast message for select organization")
	public void userWillValidateToastMessageForSelectOrganization() throws InterruptedException {
		Thread.sleep(5000);
		Assert.assertTrue(login.getUseragreementAndPrivacyPolicyToastMessage().getText().equals(properties.getProperty("emptyOrganizationErrorMessage")));
	}

	@Given("User click on Forgot password link in login page")
	public void userClickOnForgotPasswordLinkInLoginPage() {
		login.getForgotPasswordLink().click();

	}

	@When("user click on Send Link button")
	public void userClickOnSendLinkButton() {
		login.getLoginButton().click();
	}

	@Then("user validate the please fill out this field  error message")
	public void userValidateThePleaseFillOutThisFieldErrorMessage() {
		WebElement emailField = login.getEmailTextField();
		String validationMessage = (String) js.executeScript("return arguments[0].validationMessage;", emailField);

		System.out.println("Validation Message: " + validationMessage);
		String expectedMessage = "Please fill out this field.";
		assertEquals(expectedMessage, validationMessage);
	}

	@And("user provide invalid email id")
	public void userProvideInvalidEmailId() {
		login.getEmailTextField().sendKeys(properties.getProperty("InvalidFormatEmailId"));

	}

	@Then("user validate invalid email format error message")
	public void userValidateInvalidEmailFormatErrorMessage() {
		assertEquals(login.getEmailFormatErrorMessage().getText(), properties.getProperty("InvalidEmailErrorMessage"));
	}

	@And("user provide unregistered email id")
	public void userProvideUnregisteredEmailId() {
		login.getEmailTextField().clear();
		login.getEmailTextField().sendKeys(email);
	}

	@Then("user validate user does not exist toast message")
	public void userValidateUserDoesNotExistToastMessage() {

		Assert.assertTrue(login.getUseragreementAndPrivacyPolicyToastMessage().getText().equals(properties.getProperty("unregisterUserErrorMeesage")));

	}

	@And("user provide registered email id")
	public void userProvideRegisteredEmailId() {
		login.getEmailTextField().sendKeys(properties.getProperty("email"));
	}

	@Then("user validate success message")
	public void userValidateSuccessMessage() {
		wait.until(ExpectedConditions.visibilityOf(login.getUseragreementAndPrivacyPolicyToastMessage()));
		Assert.assertTrue(login.getUseragreementAndPrivacyPolicyToastMessage().getText().equals(properties.getProperty("SuccessMessage")));

	}

	@When("User click on back to login link")
	public void userClickOnBackToLoginLink() {
		login.getBackToLoginLink().click();

	}

	@Then("User validate Login page")
	public void userValidateLoginPage() {
		wait.until(ExpectedConditions.urlContains("/user/login"));
		Assert.assertTrue(login.getusernameTextField().isDisplayed());
		Assert.assertTrue(login.getPasswordTextField().isDisplayed());
		Assert.assertTrue(login.getLoginButton().isDisplayed());
		Assert.assertTrue(login.getRememberAccountIn5Day().isDisplayed());
		Assert.assertTrue(login.getForgotPasswordLink().isDisplayed());
	}

	@And("user click on user profile icon")
	public void userClickOnUserProfileIcon() throws InterruptedException {
		dashboard.getUserProfileIcon().click();
		Thread.sleep(1000);
	}

	@Then("user click on Reset password option from dropdown")
	public void userClickOnResetPasswordOptionFromDropdown() {
		dashboard.clickOnUserProfileOptions(properties.getProperty("ResetPassword"));
	}

	@And("user provide old,new and confirmed password")
	public void userProvideOldNewAndConfirmedPassword() {
		dashboard.provideResetPasswordAllFieldsData(properties.getProperty("password1"), properties.getProperty("ResetPassword1"), properties.getProperty("ResetPassword1"));
	}

	@And("user click on Confirm button")
	public void userClickOnConfirmButton() {
		dashboard.getConfirmButton().click();
	}


	@When("user navigates to Timesheet submodule page")
	public void userNavigatesToTimesheetSubmodulePage() {

		WebElement ScrollUntil = wait.until(ExpectedConditions.elementToBeClickable(attendance.getAttendance_Timesheetpage()));
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true);", ScrollUntil);
		ScrollUntil.click();

	}
	@Then("User should search by timesheet name")
	public void userShouldSearchByTimesheetName() throws InterruptedException {
		WebElement FindRecord = wait.until(ExpectedConditions.visibilityOf(attendance.getSearchtextField()));
		Thread.sleep(2000);
		FindRecord.sendKeys(properties.getProperty("SearchTimesheetname"));
		if (FindRecord.isDisplayed()) {
			WebElement EntredRecord = attendance.getFindRecordIsdisplayed();
			System.out.println("Record found!!!!");
		} else {
			System.out.println("Sorry! No record found");
		}
	}
	@Then("User can navigate to next page by clicking on next page by selecting Ten twenty and fifty")
	public void userCanNavigateToNextPageByClickingOnNextPageBySelectingTenTwentyAndFifty() throws Exception {

		attendance.userShouldListTheRecordsBySelecting(driver, attendance);
		Next_Page_Previous_page_With_single_record(driver, attendance);


	}


	@Then("User unable to create timesheet if breakTime is Eighter outside the checkIn or Checkout Range")
	public void userUnableToCreateTimesheetIfBreakTimeIsEighterOutsideTheCheckInOrCheckoutRange() throws InterruptedException {

		wait.until(ExpectedConditions.elementToBeClickable(attendance.getAddTimeSheetBtn())).click();
		WebElement EditTimesheetName = wait.until(ExpectedConditions.elementToBeClickable(attendance.getEdit_TimeSheet_NamePh()));
		EditTimesheetName.click();
		Actions actions = new Actions(driver);
		actions.click(EditTimesheetName).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE);
		EditTimesheetName.sendKeys(RandomTimeSheetName);
		WebElement scrollToLastRecord = attendance.getKnow_more_about_this();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", scrollToLastRecord);
		Thread.sleep(1000);
		WebElement BreakTimeToggle = wait.until(ExpectedConditions.visibilityOf(attendance.getBreakTimeEnabled()));
		if (!BreakTimeToggle.isEnabled()) {
			System.out.println("BreakTime is Disabled, Now Enabling");
			BreakTimeToggle.click();
		} else {
			Thread.sleep(3000);
			System.out.println("Break Time is Enabled!!!");
		}
		Thread.sleep(2000);
		WebElement StartTimefied=wait.until(ExpectedConditions.visibilityOf(attendance.getStartTimeTimesheet()));
		actions.click(StartTimefied).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE);
		StartTimefied.sendKeys(properties.getProperty("StartTimetimsheet"));
		Thread.sleep(2000);
		WebElement StartTime=wait.until(ExpectedConditions.visibilityOf(attendance.getStartTimeTimesheet()));
		Actions action = new Actions(driver);
		StartTime.sendKeys(properties.getProperty("sameTimeASChekIn"));
		WebElement EndTimeCheckin=wait.until(ExpectedConditions.visibilityOf(attendance.getEndTimeCheckin()));
		Actions action1 = new Actions(driver);
		action1.moveToElement(EndTimeCheckin).click().keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).perform();
		//Thread.sleep(3000);

		WebElement BreakTimeToast=wait.until(ExpectedConditions.visibilityOf(attendance.getBreakTimeErrorMessage()));
		if(BreakTimeToast.isDisplayed())
			System.out.println("Unable to create Break time!!!!!!! "+BreakTimeToast.getText());
		else System.out.println("User can create break time");
		Thread.sleep(2000);

		//WebElement EndTimeCheckin = wait.until(ExpectedConditions.visibilityOf(attendance.getEndTimeCheckin()));
		Actions action2 = new Actions(driver);
		action2
				.moveToElement(EndTimeCheckin)
				.click()
				.keyDown(Keys.CONTROL)
				.sendKeys("a")
				.keyUp(Keys.CONTROL)
				.sendKeys(Keys.BACK_SPACE);
//				.perform();

		Thread.sleep(500);
		WebElement BreakTimeMoreThanCheckin=wait.until(ExpectedConditions.visibilityOf(attendance.getBreakTimeMoreThanCheckin()));
		BreakTimeMoreThanCheckin.sendKeys(properties.getProperty("MoreThanCheckInTime"));
		wait.until(ExpectedConditions.visibilityOf(attendance.gettranscation_Confirm_btn())).click();
		WebElement BreakTimeMoreThanCheckinToastMessage=wait.until(ExpectedConditions.visibilityOf(attendance.getBreakTimeMoreThanCheckinToastMessage()));

		BreakTimeMoreThanCheckinToastMessage.getText();


	}

	@Then("User should not create Timesheet by leaving mandatory field")
	public void userShouldNotCreateTimesheetByLeavingMandatoryField() throws InterruptedException{

		wait.until(ExpectedConditions.elementToBeClickable(attendance.getAddTimeSheetBtn())).click();
		WebElement EditTimesheetName = wait.until(ExpectedConditions.elementToBeClickable(attendance.getEdit_TimeSheet_NamePh()));
		EditTimesheetName.click();
		Actions actions = new Actions(driver);
		actions.click(EditTimesheetName).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE);
		wait.until(ExpectedConditions.elementToBeClickable(attendance.getView_TimeSheet_Cycle())).click();
		WebElement ScrollUntilCycelDisplay = wait.until(ExpectedConditions.elementToBeClickable(attendance.getRepeatCycleIcon()));
		ScrollUntilCycelDisplay.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(attendance.gettranscation_Confirm_btn())).click();


	}
	@Then("User should delete the Timesheet Successfully")
	public void userShouldDeleteTheTimesheetSuccessfully() {
		wait.until(ExpectedConditions.elementToBeClickable(attendance.getDeleteTimesheetBtn())).click();
		wait.until(ExpectedConditions.elementToBeClickable(attendance.getDeletTimesheetconfimBtn())).click();
		WebElement cannotDeleteToastMessage=wait.until(ExpectedConditions.visibilityOf(attendance.getTimesheetcannotDeletetoast()));
		if(cannotDeleteToastMessage.isEnabled()) {
			System.out.println("TimeSheet is already in use Deletion is prohibited!!!!");
		}
		else {
			wait.until(ExpectedConditions.visibilityOf(attendance.getSuccess_Popup_Message())).isDisplayed();

		}
	}
	@Then("User should cancel the timesheet delete operation")
	public void userShouldCancelTheTimesheetDeleteOperation() {

		wait.until(ExpectedConditions.elementToBeClickable(attendance.getDeleteTimesheetBtn())).click();
		wait.until(ExpectedConditions.visibilityOf(attendance.getAdd_medAtt_Cancel_btn())).click();
	}


	@Then("User should update the recently created timesheet")
	public void userShouldUpdateTheRecentlyCreatedTimesheet() throws InterruptedException {

// Determine which radio button is selected
		wait.until(ExpectedConditions.elementToBeClickable(attendance.getEdit_Timesheet_Page())).click();
		WebElement EditTimesheetName = wait.until(ExpectedConditions.elementToBeClickable(attendance.getEdit_TimeSheet_NamePh()));
		EditTimesheetName.click();
		Actions actions = new Actions(driver);
		actions.click(EditTimesheetName).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE);
		EditTimesheetName.sendKeys(RandomTimeSheetName);
		WebElement EditTimesheetDescription = wait.until(ExpectedConditions.elementToBeClickable(attendance.getEdit_TimeSheet_Description()));
		actions.click(EditTimesheetDescription).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE);
		EditTimesheetDescription.sendKeys(RandomTimeSheetName);
		wait.until(ExpectedConditions.elementToBeClickable(attendance.getView_TimeSheet_Cycle())).click();
		//String timesheetType = attendance.getNormalTimesheetRadioBtn().isSelected() ? "NORMAL" : "FLEXIBLE";
		String timesheetType = attendance.getFlexibleTimesheetRadioBtn().isSelected() ? "NORMAL" : "FLEXIBLE";

		//WebElement FlexibleTimesheetRBtn = wait.until(ExpectedConditions.elementToBeClickable(attendance.getFlexibleTimesheetRadioBtn()));


		switch (timesheetType) {
			case "NORMAL":
				WebElement NormalTimeSheetRadioBtn = wait.until(ExpectedConditions.visibilityOf(attendance.getNormalTimesheetRadioBtn()));
				if (NormalTimeSheetRadioBtn.isSelected()) {
					NormalTimeSheetRadioBtn.click();
					Thread.sleep(1500);
				}

				List<WebElement> AllRowheaders = attendance.getAllheadersAvailableonEditTS();
				for (WebElement AllDataDisplay : AllRowheaders) {
					System.out.println("All headers Available" + AllDataDisplay);
				}

				WebElement ScrollUntilCycelDisplay = wait.until(ExpectedConditions.elementToBeClickable(attendance.getRepeatCycleIcon()));
				ScrollUntilCycelDisplay.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
				Thread.sleep(1000);
				ScrollUntilCycelDisplay.sendKeys(properties.getProperty("Cycle1"));

				WebElement LastRec = wait.until(ExpectedConditions.visibilityOf(attendance.getlastRowForCycle1()));
				js.executeScript("arguments[0].scrollIntoView(true);", LastRec);
				Thread.sleep(2000);
				js.executeScript("arguments[0].scrollIntoView(true);", ScrollUntilCycelDisplay);
				Thread.sleep(2000);

				WebElement ToTime1 = wait.until(ExpectedConditions.visibilityOf(attendance.getChangeTimePH()));
				new Actions(driver).click(ToTime1)
						.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
						.sendKeys(Keys.BACK_SPACE)
						.sendKeys(getCurrentTimeAsNumber())
						.perform();

				wait.until(ExpectedConditions.elementToBeClickable(attendance.getStatisticRuleMode())).click();
				wait.until(ExpectedConditions.visibilityOf(attendance.getFirstAndLastDP())).click();

				WebElement BreakTimeToggle = wait.until(ExpectedConditions.visibilityOf(attendance.getBreakTimeEnabled()));
				if (!BreakTimeToggle.isEnabled()) {
					System.out.println("BreakTime is Disabled, Now Enabling");
					BreakTimeToggle.click();
				} else {
					Thread.sleep(3000);
					System.out.println("Break Time is Enabled!!!");
				}

				WebElement BreakTimeToggleBtn = wait.until(ExpectedConditions.visibilityOf(attendance.getEnableOverTimeToggle()));
				if (!BreakTimeToggleBtn.isEnabled()) {
					System.out.println("Break Time is not enabled");
					BreakTimeToggleBtn.click();
				} else {
					System.out.println("BreakTime is already enabled!!!");
				}

				int maxAttempts = 3;
				for (int i = 0; i < maxAttempts; i++) {
					WebElement breakTimeEnabled = wait.until(ExpectedConditions.elementToBeClickable(attendance.getbreakTimeCyclebtn()));
					breakTimeEnabled.click();
					Thread.sleep(1000);
					try {
						WebElement breakTimeExceeds = wait.until(ExpectedConditions.visibilityOf(attendance.getBreakTimeExceeds()));
						if (breakTimeExceeds.isDisplayed()) {
							System.out.println("BreakTimeExceeds appeared!");
							break;
						}
					} catch (TimeoutException e) {
						// Try again
					}
				}

				wait.until(ExpectedConditions.visibilityOf(attendance.gettranscation_Confirm_btn())).click();
				break;

			case "FLEXIBLE":
				//wait.until(ExpectedConditions.elementToBeClickable(attendance.getEdit_Timesheet_Page())).click();
				WebElement ScrollUntilCycelDisplayF = wait.until(ExpectedConditions.elementToBeClickable(attendance.getRepeatCycleIcon()));
				WebElement FlexibleTimesheetRBtn = wait.until(ExpectedConditions.elementToBeClickable(attendance.getFlexibleTimesheetRadioBtn()));
				FlexibleTimesheetRBtn.click();
				List<WebElement> AllRowheader = attendance.getAllheadersAvailableonEditTS();
				for (WebElement AllDataDisplay : AllRowheader) {
					System.out.println("All headers Available" + AllDataDisplay);
				}

				ScrollUntilCycelDisplayF.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
				Thread.sleep(1000);
				ScrollUntilCycelDisplayF.sendKeys(properties.getProperty("Cycle2"));

				WebElement ScrollUntilLastCycelFlexible = wait.until(ExpectedConditions.visibilityOf(attendance.getlastIndexForCycle2()));
				js.executeScript("arguments[0].scrollIntoView(true);", ScrollUntilLastCycelFlexible);
				Thread.sleep(2000);
				js.executeScript("arguments[0].scrollIntoView(true);", ScrollUntilCycelDisplayF);
				Thread.sleep(2000);

				WebElement scrollToLastRecord = attendance.getKnow_more_about_this();
				js.executeScript("arguments[0].scrollIntoView(true);", scrollToLastRecord);
				Thread.sleep(1000);

				WebElement ToTime2 = wait.until(ExpectedConditions.visibilityOf(attendance.getChangeTimePH()));
				new Actions(driver).click(ToTime2)
						.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
						.sendKeys(Keys.BACK_SPACE)
						.sendKeys(getCurrentTimeAsNumber())
						.perform();

				wait.until(ExpectedConditions.elementToBeClickable(attendance.getStatisticRuleMode())).click();
				wait.until(ExpectedConditions.elementToBeClickable(attendance.getODDAndEvenDp())).click();

				WebElement BreakTimeToggle2 = wait.until(ExpectedConditions.visibilityOf(attendance.getBreakTimeEnabled()));
				if (!BreakTimeToggle2.isEnabled()) {
					System.out.println("BreakTime is Disabled, Now Enabling");
					BreakTimeToggle2.click();
				} else {
					System.out.println("Break Time is Enabled!!!");
				}

				WebElement BreakTimeToggleBtn2 = wait.until(ExpectedConditions.visibilityOf(attendance.getEnableOverTimeToggle()));
				if (!BreakTimeToggleBtn2.isEnabled()) {
					System.out.println("Break Time is not enabled");
					BreakTimeToggleBtn2.click();
				} else {
					System.out.println("BreakTime is already enabled!!!");
				}


				int maxAttempts2 = 3;
				for (int i = 0; i < maxAttempts2; i++) {
					WebElement breakTimeEnabled = wait.until(ExpectedConditions.elementToBeClickable(attendance.getbreakTimeCyclebtn()));
					breakTimeEnabled.click();
					Thread.sleep(1000);
					try {
						WebElement breakTimeExceeds = wait.until(ExpectedConditions.visibilityOf(attendance.getBreakTimeExceeds()));
						if (breakTimeExceeds.isDisplayed()) {
							System.out.println("BreakTimeExceeds appeared!");
							break;
						}
					} catch (TimeoutException e) {
						// Try again
					}
				}

				wait.until(ExpectedConditions.visibilityOf(attendance.gettranscation_Confirm_btn())).click();
				break;
		}

	}


	@Then("User Should view the recently created record")
	public void userShouldViewTheRecentlyCreatedRecord() throws InterruptedException {

		WebElement viewTimesheeticon = wait.until(ExpectedConditions.elementToBeClickable(attendance.getView_Attendance_page()));
		if (viewTimesheeticon.isDisplayed()) {
			viewTimesheeticon.click();
		} else System.out.println("Element is not displayed!!! Create a new timesheet");
		WebElement hoverIcon = attendance.getView_Hover_icon();
		Actions actions = new Actions(driver);
		actions.moveToElement(hoverIcon).perform();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(attendance.getView_TimeSheet_Cycle())).click();
		Thread.sleep(3000);
		WebElement scrollToLastRecord = attendance.getKnow_more_about_this();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", scrollToLastRecord);
		Thread.sleep(1000);
		scrollToLastRecord.click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(organization.getorganizationEditConfirmbtn())).click();
		WebElement ScrollToTopViewAtt = attendance.getScrollToTopViewAtt();
		JavascriptExecutor ScrollToTop = (JavascriptExecutor) driver;
		ScrollToTop.executeScript("arguments[0].scrollIntoView(true);", ScrollToTopViewAtt);
		Thread.sleep(3000);
		ScrollToTopViewAtt.click();


	}
	@Then("user click on add timesheet module")
	public void userClickOnAddTimesheetModule() {
		wait.until(ExpectedConditions.visibilityOf(attendance.getAddTimeSheetBtn())).click();
	}
	@And("the user enters valid data in the Add timesheet and create the flexible timesheet")
	public void theUserEntersValidDataInTheAddTimesheetAndCreateTheFlexibleTimesheet() {
		reus.enterRandomAlphanumeric(attendance.getTimeSheetNametext());
		reus.enterRandomAlphanumeric(attendance.getTimesheetDescription());
		reus.performClickAction(attendance.getArrowForwardicontimesheet());
		reus.performClickAction(attendance.getFlexiblecheckbox());

	}

	@And("the user enters valid data in the Add timesheet")
	public void theUserEntersValidDataInTheAddTimesheet() {
		reus.enterRandomAlphanumeric(attendance.getTimeSheetNametext());
		reus.enterRandomAlphanumeric(attendance.getTimesheetDescription());
		reus.enterRandomTime(attendance.getDayChangeTime());
	}

	@And("the user enter click on confirm button.")
	public void theUserEnterClickOnConfirmButton() {
		reus.performClickAction(attendance.getConfirmbutton());


	}
	@Then("user should validate the timesheet page")
	public void userShouldValidateTheTimesheetPage() {
		List<WebElement> HeaderList = attendance.getView_Attendance_All_Headers();
		System.out.println("Available Headers:");
		for (WebElement headers : HeaderList) {
			System.out.println(headers.getText() + "\t");
		}
	}
	@Then("user validate the success message")
	public void userValidateTheSuccessMessage() {
		wait.until(ExpectedConditions.visibilityOf(login.getUseragreementAndPrivacyPolicyToastMessage()));
		String toastmessage=login.getUseragreementAndPrivacyPolicyToastMessage().getText();
		WebDriverWait Wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		 Assert.assertEquals(toastmessage,properties.getProperty("Success1"));
		
	}

	@And("user login to the application with new password")
	public void userLoginToTheApplicationWithNewPassword() {
		login.login(properties.getProperty("email"),properties.getProperty("ResetPassword1"));
	}

	@And("user provide same old password for old,new and confirmed password")
	public void userProvideSameOldPasswordForOldNewAndConfirmedPassword() {
		dashboard.provideResetPasswordAllFieldsData(properties.getProperty("ResetPassword1"), properties.getProperty("ResetPassword1"),properties.getProperty("ResetPassword1"));
		
	}

	@Then("user validate new password can not be same as old password")
	public void userValidateNewPasswordCanNotBeSameAsOldPassword() throws InterruptedException {
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(login.getUseragreementAndPrivacyPolicyToastMessage()));
		String toastmessage=login.getUseragreementAndPrivacyPolicyToastMessage().getText();
		assertEquals(toastmessage,properties.getProperty("OldPasswordCannotbeSameAsNewPasswordErrorMessage"));
	}

	@And("user clear all fields and enter invalid password format")
	public void userClearAllFieldsAndEnterInvalidPasswordFormat() {
		dashboard.clearAllFieldInResetPasswordpage();
		dashboard.provideResetPasswordAllFieldsData(properties.getProperty("ResetPassword1"), properties.getProperty("InvalidFormatpassword"),properties.getProperty("InvalidFormatpassword"));
		
	}

	@Then("user validate password format error message")
	public void userValidatePasswordFormatErrorMessage() throws InterruptedException {
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(login.getUseragreementAndPrivacyPolicyToastMessage()));
		String toastmessage=login.getUseragreementAndPrivacyPolicyToastMessage().getText();
		assertEquals(toastmessage,properties.getProperty("invalidFormatPasswordErrorMessage"));
		Thread.sleep(2000);
	}

	@And("user clear all fields and enter not matching new password and confirm password")
	public void userClearAllFieldsAndEnterNotMatchingNewPasswordAndConfirmPassword() {
		dashboard.clearAllFieldInResetPasswordpage();
		dashboard.provideResetPasswordAllFieldsData(properties.getProperty("ResetPassword1"), properties.getProperty("password1"),properties.getProperty("InvalidFormatpassword"));
		
	}

	@Then("user validate password mismatch error message")
	public void userValidatePasswordMismatchErrorMessage() throws InterruptedException {
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(login.getUseragreementAndPrivacyPolicyToastMessage()));
		String toastmessage=login.getUseragreementAndPrivacyPolicyToastMessage().getText();
		assertEquals(toastmessage,properties.getProperty("PasswordMismatchErrorMessage"));
	
	
	}

	@Then("User validate each field data is getting hide and unhide")
	public void userValidateEachFieldDataIsGettingHideAndUnhide() throws InterruptedException {
		dashboard.ResetPasswordEyeIconValidation();
	}

	@Given("User click on Help Info icon")
	public void userClickOnHelpInfoIcon() {
		dashboard.getHelpInfoIcon().click();
		
		
	}

	@Then("User will click one by one videos and validate video plays")
	public void userWillClickOneByOneVideosAndValidateVideoPlays() throws InterruptedException {
		dashboard.playsHelpVideos(dashboard.getConfirmButton());
	}
	@Then("User will click one by one videos and validate video plays and click on Cancel button to close the window")
	public void userWillClickOneByOneVideosAndValidateVideoPlaysAndCloseTheWindowByCancelButton() throws InterruptedException {
		dashboard.playsHelpVideos(dashboard.getCancelButton());
	}

	@And("Logout from the application by canceling the logout")
	public void logoutFromTheApplicationByCancelingTheLogout() {
		dashboard.getLogoutIcon().click();
		dashboard.getCancelButton().click();
	}
	@And("Select the respective language and validate the dashboard page language is getting change")
	public void selectOneByOneLanguageAndValidateThedashboardPageLanguageIsGettingChange() throws InterruptedException {
		dashboard.DashboardlanguageValidation(properties.getProperty("ChineseLanguage"));
	}


	@And("user click on Announcement Icon")
	public void userClickOnAnnouncementIcon() {
		dashboard.getAnnouncementIcon().click();
		
	}
	@And("validate Change Logs Announcement")
	public void validate_Change_Logs_Announcement() {	
		dashboard.ChnagelogAnnouncementValidation();
		
	}
	@Then("user click on Contact Us option from dropdown")
	public void userClickOnContactUsOptionFromDropdown() {
		dashboard.clickOnUserProfileOptions(properties.getProperty("ContactUs"));
	}

	@Then("validate New Timesheet Announcement")
	public void validateNewTimesheetAnnouncement() {
		dashboard.AnnouncementTimeSheetValidation();
	}

	@Then("validate New Mobile Apps Announcement")
	public void validateNewMobileAppsAnnouncement() {
	dashboard.MobileAppsAnnouncement();
	}

	@And("user created one Help Desk ticket")
	public void userCreatedOneHelpDeskTicket() {
		dashboard.CreateContactUsTicket(properties.getProperty("impactOption"),properties.getProperty("frequencyOption"));
	}

	@Then("validate Contact Us Application Support page")
	public void validateContactUsApplicationSupportPage() {
		dashboard.contactUsPageValidation();
	}


	@And("user click on Save button")
	public void userClickOnSaveButton() {
		dashboard.getSaveButton().click();
	}

	@And("user fetch the organization details")
	public void userFetchTheOrganizationDetails() throws InterruptedException {
		dashboard.OrganizationProfilePage();
	}

	@Then("Validate the default Company Name,Contact person,Country and email address is reflecting in the respective field")
	public void validateTheDefaultCompanyNameContactPersonCountryAndEmailAddressIsReflectingInTheRespectiveField() {
		dashboard.contactUsPageDefaultDataFetchValidation();
	}

	@Then("user click on Profile option from dropdown")
	public void userClickOnProfileOptionFromDropdown() {
		dashboard.clickOnUserProfileOptions(properties.getProperty("Profile"));
		
	}

	@And("user validate Account Profile page")
	public void userValidateAccountProfilePage() {
		dashboard.AccountProfilePage(properties.getProperty("firstname"),properties.getProperty("lastname"),properties.getProperty("email"));
	}

	@And("user validate validate account profile edited successfully")
	public void userValidateValidateAccountProfileEditedSuccessfully() throws InterruptedException {
		dashboard.EditAccountProfile();
	}

	@Then("validate User updated successfully. success message")
	public void validateUserUpdatedSuccessfullySuccessMessage() {
		Assert.assertTrue(login.getUseragreementAndPrivacyPolicyToastMessage().isDisplayed());
	Assert.assertTrue(login.getUseragreementAndPrivacyPolicyToastMessage().getText().equals(properties.getProperty("EditAccountProfileSuccessMessage")));
		
	}
	@And("user validate Account Profile updated successfully in Account profile page")
	public void userValidateEditAccountProfileupdatedsuccessfullyinAccountprofilepage() throws InterruptedException {
		Thread.sleep(1000);
		dashboard.AccountProfilePage(properties.getProperty("editfirstname"),properties.getProperty("editlastname"),properties.getProperty("editemail"));
	}
	@And("user login to the application with updated email and password")
	public void userLoginToTheApplicationWithupdatedemailAndPassword() {
		login.login(properties.getProperty("editemail"),properties.getProperty("ResetPassword1"));
	}

	@Then("user uploaded photo more than {int}mb")
	public void userUploadedPhotoMoreThanMb(int arg0) throws InterruptedException {
		dashboard.getAccountProfileEditIcon().click();
		Thread.sleep(2000);
	dashboard.AccountProfilePhotoValidation();

		
	}
	@Then("user click on About option from dropdown")
	public void userClickOnAboutOptionFromDropdown() {
		dashboard.clickOnUserProfileOptions(properties.getProperty("About"));
	}

	@Then("validate one by one About page option")
	public void validateOneByOneAboutPageOption() throws InterruptedException {
		dashboard.aboutPageValidation();
	}
	@Then("user click on Delete Account option from dropdown")
	public void userClickOnDeletAccountOptionFromDropdown() throws InterruptedException {
		dashboard.clickOnUserProfileOptions(properties.getProperty("DeleteAccount"));
		Thread.sleep(1000);
	}

	@And("validate  delete organization permanently and delete account permanently.pop up window")
	public void validateDeleteOrganizationPermanentlyAndDeleteAccountPermanentlyPopUpWindow() {
		dashboard.deleteAccountValidation();
		
	}

	@Then("validate The account still has organization pop up window")
	public void validateTheAccountStillHasOrganizationPopUpWindow() {
		dashboard.deleteAccountValidationwarningpopupWindow();
	}

	@And("user delete organization")
	public void userDeleteOrganization() throws InterruptedException {
		dashboard.deleteOrganization();
	}

	@Then("validate oragnization and account got deleted")
	public void validateOragnizationAndAccountGotDeleted() {
//		Assert.assertTrue(dashboard.getIncorrectauthenticationcredentialmessage().isDisplayed());
		wait.until(ExpectedConditions.urlContains("/user/login"));
		Assert.assertTrue(login.getusernameTextField().isDisplayed());
		Assert.assertTrue(login.getPasswordTextField().isDisplayed());
		Assert.assertTrue(login.getLoginButton().isDisplayed());
		Assert.assertTrue(login.getRememberAccountIn5Day().isDisplayed());
		Assert.assertTrue(login.getForgotPasswordLink().isDisplayed());
		
	}

	@And("user click on Organization Management module")
	public void userClickOnOrganizationManagementModule() throws InterruptedException {
		dashboard.getOrganizationManagementModule().click();
		Thread.sleep(500);
	}

	@Then("user user click on person sub module")
	public void userUserClickOnPersonSubModule() {
		organizationManagement.getOrganizationPersonSubModule().click();
	}

	@And("user click on Add person icon")
	public void userClickOnAddPersonIcon() {
		organizationManagement.getPersonAddIcon().click();
		
	}

	@Then("user provide all the details to add a person")
	public void userProvideAllTheDetailsToAddAPerson() throws InterruptedException {
		organizationManagement.AddPerson(properties.getProperty("personId"),properties.getProperty("personfirstname"),properties.getProperty("perspnlastname"),"");
	}

	@Then("user validate person added successfully")
	public void userValidatePersonAddedSuccessfully() {
		Assert.assertTrue(login.getUseragreementAndPrivacyPolicyToastMessage().isDisplayed());
	String personAddSuccessmessage=login.getUseragreementAndPrivacyPolicyToastMessage().getText();
	assertEquals(personAddSuccessmessage,properties.getProperty("personAddSuccessfullymesssage") );
		
	}

	@Then("user provide special char in personid")
	public void userProvideSpecialCharInPersonid() throws InterruptedException {
		organizationManagement.AddPerson(properties.getProperty("specialcharpersonId"),properties.getProperty("personfirstname"),properties.getProperty("perspnlastname"),properties.getProperty("personemail"));
	}

	@Then("user validate special error message")
	public void userValidateSpecialErrorMessage() {
		Assert.assertTrue(organizationManagement.getSpecialCharMessage().isDisplayed());
	}
	@Then("user provide all the details not to add a person")
	public void userProvideAllTheDetailsNotToAddAPerson() throws InterruptedException {
		organizationManagement.AddPerson(properties.getProperty("personId"),properties.getProperty("personfirstname"),properties.getProperty("perspnlastname"),properties.getProperty("personemail"));
	}

	@Then("click on Cancel buttton")
	public void clickOnCancelButtton() {
		dashboard.getCancelButton().click();
	}

	@Then("user Email already exists.")
	public void userEmailAlreadyExists() throws InterruptedException {
		Thread.sleep(1000);
		assertTrue(dashboard.getIncorrectauthenticationcredentialmessage().isDisplayed());
		String actualmessage=dashboard.getIncorrectauthenticationcredentialmessage().getText();
		assertEquals(actualmessage,properties.getProperty("duplicatePersonEmailMessage"));
		
	}
	@Then("user validate Employee code already exist.")
	public void useruservalidateEmployeecodealreadyexist() throws InterruptedException {
		Thread.sleep(1000);
		assertTrue(dashboard.getIncorrectauthenticationcredentialmessage().isDisplayed());
		String actualmessage=dashboard.getIncorrectauthenticationcredentialmessage().getText();
		assertEquals(actualmessage,properties.getProperty("duplicatePersonIdMessage"));
		
	}

	@And("user refresh the page")
	public void userRefreshThePage() {
		organizationManagement.getRefreshIcon().click();
	}

	@And("user validate the list of person records")
	public void userValidateTheListOfPersonRecords() {
	Assert.assertTrue(organizationManagement.getPersonRow().isDisplayed());
	}

	@And("user filter person data based on firstname")
	public void userFilterPersonDataBasedOnFirstname() throws InterruptedException {
		organizationManagement.getSearchField().sendKeys(properties.getProperty("personfirstname"));
		Thread.sleep(1000);
		
	}

	@Then("user validate filter data")
	public void userValidateFilterData() {
		String personname=organizationManagement.getPersonFirstnameData().getText();
		System.out.println("the person name is :"+personname);
		Assert.assertTrue(personname.contains(properties.getProperty("personfirstname")));
	}

	@And("user filter person data based on invalid data")
	public void userFilterPersonDataBasedOnInvalidData() throws InterruptedException {
		organizationManagement.getSearchField().sendKeys(properties.getProperty("personId"));
		Thread.sleep(1000);
	}

	@Then("user validate no rows message")
	public void userValidateNoRowsMessage() {
		Assert.assertTrue(organizationManagement.getNoRow().isDisplayed());
	}

	@Then("user provide all the details with existing person email")
	public void userProvideAllTheDetailsWithExistingPersonEmail() throws InterruptedException {
		organizationManagement.AddPerson(randomPersonId,properties.getProperty("personfirstname"),properties.getProperty("perspnlastname"),properties.getProperty("personemail"));
		String personnid=randomPersonId;
	}

	@And("user click on Person id to sort the list and validate the sorting")
	public void userClickOnPersonIdToSortTheListAndValidateTheSorting() {
		String nonSorting=organizationManagement.getPersonIDColumn().getAttribute("aria-sort");
		organizationManagement.getPersonIDColumn().click();
		assertTrue(!nonSorting.equals("ascending"));
		organizationManagement.getPersonIDColumn().click();
		assertTrue(!nonSorting.equals("descending"));
	}

	@And("user click on Edit person icon")
	public void userClickOnEditPersonIcon() {
		organizationManagement.getEditIcon().click();
	}

	@Then("user provide all the edit field data")
	public void userProvideAllTheEditFieldData() throws InterruptedException, AWTException {
		organizationManagement.EditPerson(properties.getProperty("Editpersonfirstname"),properties.getProperty("Editperspnlastname"));
	}

	@Then("validate person updated successfully")
	public void validatePersonUpdatedSuccessfully() {
		Assert.assertTrue(login.getUseragreementAndPrivacyPolicyToastMessage().isDisplayed());
		String personAddSuccessmessage=login.getUseragreementAndPrivacyPolicyToastMessage().getText();
		assertEquals(personAddSuccessmessage,properties.getProperty("personEditSuccessfullymesssage") );
	}

	@And("user click on Delete person icon")
	public void userClickOnDeletePersonIcon() throws InterruptedException {
		organizationManagement.getDeleteIcon().click();
		
		
	}

	@Then("validate person deleted successfull")
	public void validatePersonDeletedSuccessfull() throws InterruptedException {
		
		Thread.sleep(500);
		Assert.assertTrue(login.getUseragreementAndPrivacyPolicyToastMessage().isDisplayed());
		String personAddSuccessmessage=login.getUseragreementAndPrivacyPolicyToastMessage().getText();
		assertEquals(personAddSuccessmessage,properties.getProperty("SuccessMessage") );
	}

	@And("user click on Mark as resign icon")
	public void userClickOnMarkAsResignIcon() throws InterruptedException {
		organizationManagement.getMarkasresignedIcon().click();
		Thread.sleep(1000);
	}

	@Then("validate person resigned successfully")
	public void validatePersonResignedSuccessfully() throws InterruptedException {

		Thread.sleep(500);
		assertTrue(login.getUseragreementAndPrivacyPolicyToastMessage().isDisplayed());
		String personAddSuccessmessage=login.getUseragreementAndPrivacyPolicyToastMessage().getText();
		assertEquals(personAddSuccessmessage,properties.getProperty("SuccessMessage") );
	}

	@And("user select per page value")
	public void userSelectPerPageValue() throws InterruptedException {
		organizationManagement.PerPageDropdownOptionSelection(10);
	}

	@Then("validate pagination")
	public void validatePagination() {
		organizationManagement.validatePagination();
	}

	@And("user user click on Resignation sub module")
	public void userUserClickOnResignationSubModule() {
		
		wait.until(ExpectedConditions.visibilityOf(organizationManagement.getResignationSubModule()));
		WebElement ResignationModule=organizationManagement.getResignationSubModule();
		
		js.executeScript("arguments[0].click();", ResignationModule);

		
		
	}

	@Then("user validate Resignation page")
	public void userValidateResignationPage() {
		organizationManagement.ResignationPageValidation();
	}

	@And("user validate resigned persons are present")
	public void userValidateResignedPersonsArePresent() {
		organizationManagement.ResignedPersonActionIcon();
	}

	@Then("user click on View icon of resigned person")
	public void userClickOnViewIconOfResignedPerson() {
	organizationManagement.clickOnResignedPersonIcons("View");
		
		
	}

	@And("user validate resigned person details")
	public void userValidateResignedPersonDetails() throws InterruptedException, AWTException {
		organizationManagement.ViewResignedPerson();
	}
	@Then("user click on Resume resignation icon of resigned person")
	public void userClickOnResumeResignationIconOfResignedPerson() {
	organizationManagement.tableListValidationBeforeDeleteOrResumeResignation();
	organizationManagement.clickOnResignedPersonIcons("Resume resignation");
   
		
		
	}

	@And("user validate the resume resignation dialog page")
	public void userValidateTheResumeResignationDialogPage() {
		organizationManagement.resumeResignationDialogPageValiadation();
	}

	@Then("user validate person removed from Resigned list")
	public void userValidatePersonRemovedFromResignedList() {
		organizationManagement.tableListValidationAfterDeleteOrResumeResignation();
	}
	@Then("user click on Delete icon of resigned person")
	public void userClickOnDeleteIconOfResignedPerson() {
	organizationManagement.tableListValidationBeforeDeleteOrResumeResignation();
	organizationManagement.clickOnResignedPersonIcons("Delete");
 	
	}
	@And("user validate the delete resignation dialog page")
	public void userValidateThedeleteResignationDialogPage() {
		organizationManagement.deleteResignedDialogPageValiadation();
	}

	@Then("user click on Usage Tips icon")
	public void userClickOnUsageTipsIcon() {
		organizationManagement.getUsageTipsIcon().click();
	}

	@And("validate Usage Tips information")
	public void validateUsageTipsInformation() {
	List<WebElement> usageTips=organizationManagement.getUsageTipsPoints();
	int usagetipsPointCount=usageTips.size();
	System.out.println("the list size are :"+usagetipsPointCount);
	for(int i=0;i<usagetipsPointCount;i++) {
		if(i==0) {
		System.out.println("test1 " +usageTips.get(i).getText());
			assertEquals(usageTips.get(i).getText(),"1.The information of resigned person will not be deleted from the system.You can view this person in the resignation list.");
		}
		else if(i==1){
			System.out.println("test1 " +usageTips.get(i).getText());
			assertEquals(usageTips.get(i).getText(),"2.The software will handle the operation authority of the resigned person.");
		}
		else if(i==2){
			System.out.println("test1 " +usageTips.get(i).getText());
			assertEquals(usageTips.get(i).getText(),"3.Whether to save the information of resigned persons needs to be handled according to the laws and regulations of your country. This system does not assume legal responsibility for this. This system recommends that you use the delete personnel function to completely delete personnel information from company.");
		}else {
			System.out.println("List is more");
		}
	}
	
	}

	@And("user click on Device Management Module")
	public void userClickOnDeviceManagementModule() {
		deviceManagement.getDeviceManagementModule().click();
	}

	@Then("validate device page elements")
	public void validateDevicePageElements() {
		deviceManagement.validate_DeviceManagement_Page();
	}

	@Then("user click on Add device icon")
	public void userClickOnAddDeviceIcon() throws InterruptedException {
		deviceManagement.clickOnDevicePageIcons("Add");
		
	}

	@And("validate add device page with Steps page and will select the checkbox with confirm the page")
	public void validateAddDevicePageWithStepsPageAndWillSelectTheCheckboxWithConfirmThePage() throws InterruptedException {
		deviceManagement.validateStepsToAddDevicePage();
	}

	@Then("user enters registered device serial number in serial number text field after reading user manual")
	public void userEntersRegisteredDeviceSerialNumberInSerialNumberTextFieldAfterReadingUserManual() {
		deviceManagement.AddDeviceSerialNoPage(properties.getProperty("deviceSerialNumber1"));
	}

	@And("user validate Bind device to your organization page and select Bind site")
	public void userValidateBindDeviceToYourOrganizationPageAndSelectBindSite() throws InterruptedException, AWTException {
		deviceManagement.BindDeviceToYourOrganizationpage(properties.getProperty("deviceSerialNumber1"));
	}

	@Then("user validate device added successfully")
	public void userValidateDeviceAddedSuccessfully() throws InterruptedException {
		deviceManagement.DeviceAddeddSuccessfullyValidation();
	}

	@Then("user validate added device details")
	public void userValidateAddedDeviceDetails() {
		deviceManagement.addedDeviceDetailsValidation();
	}

	@Then("user enters unregistered\\/invalid device serial number in serial number text field after reading user manual")
	public void userEntersUnregisteredInvalidDeviceSerialNumberInSerialNumberTextFieldAfterReadingUserManual() {
		deviceManagement.AddDeviceSerialNoPage(properties.getProperty("invalidDeviceSerialNum"));
	}
	@And("user validate Bind device to your organization page and select Bind site for invalid Device Serial no")
	public void userValidateBindDeviceToYourOrganizationPageAndSelectBindSiteForInvalidDeviceSN() throws InterruptedException, AWTException {
		deviceManagement.BindDeviceToYourOrganizationpage(properties.getProperty("invalidDeviceSerialNum"));
	}

	@Then("user validate The device pre-registration information is not matched error message")
	public void userValidateTheDevicePreRegistrationInformationIsNotMatchedErrorMessage() {
		deviceManagement.unregisteredDeviceMessageValidation();
	}

	@Then("user click on device detail icon")
	public void userClickOnDeviceDetailIcon() {
		deviceManagement.clickOnDeviceIconList("Detail");
		
	}

	@And("user validate the device detail page")
	public void userValidateTheDeviceDetailPage() {
		deviceManagement.deviceDetailPageValidation();
		
	}
	@Then("user click on device edit icon")
	public void userClickOnDeviceEditIcon() {
		deviceManagement.clickOnDeviceIconList("Edit");
		
	}

	@And("user validate edit device page and update the device alias name with site")
	public void userValidateEditDevicePageAndUpdateTheDeviceAliasNameWithSite() throws InterruptedException, AWTException {
		deviceManagement.deviceEditPageValidation();
		
	}

	@Then("validate device details updated successfully")
	public void validateDeviceDetailsUpdatedSuccessfully() {
		deviceManagement.EditDeviceSuucesssMessageValidation();
	}

	@Then("user click on Reboot device option")
	public void userClickOnRebootDeviceOption() {
		deviceManagement.DeviceReboot();
	}

	@Then("user click on Sync device option")
	public void userClickOnSyncDeviceOption() {
		deviceManagement.syncPersonToDevice();
	}

	@Then("user click on Person in this device option")
	public void userClickOnPersonInThisDeviceOption() {
		deviceManagement.ClickOnPersonInThisDevice();
	}

	@And("user validate person list in person in this device page")
	public void userValidatePersonListInPersonInThisDevicePage() {
		deviceManagement.validatePersonListInPersonInThisDevicePage();
	}
	@Then("user click on device Delete icon")
	public void userClickOnDeviceDeleteIcon() {
		deviceManagement.clickOnDeviceIconList("Delete");		
	}

	@Then("validate device deleted successfully")
	public void validateDeviceDeletedSuccessfully() {
		deviceManagement.DeleteDeviceSuucesssMessageValidation();
	}
	@And("user filter device based on valid device serial num")
	public void userFilterDeviceBasedOnDeviceSerialNo() throws InterruptedException {
		organizationManagement.getSearchField().sendKeys(properties.getProperty("deviceSerialNumber1"));
		Thread.sleep(1000);
		
	}
	@And("user filter device based on invalid device serial num")
	public void userFilterDeviceBasedOninvalidDeviceSerialNo() throws InterruptedException {
		organizationManagement.getSearchField().sendKeys(properties.getProperty("invalidDeviceSerialNum"));
		Thread.sleep(2000);
		
	}
	@Then("user validate device filter data")
	public void userValidateDeviceFilterData() {
		 List<WebElement> rows = deviceManagement.getDeviceList();
		    if(rows.size()>0) {
		      for (WebElement row : rows) {
		        WebElement deviceSn = row.findElement(By.xpath(".//div[@role='cell' and @data-field='sn']"));
		String serialNum=deviceSn.getText();
		        Assert.assertTrue(serialNum.contains(properties.getProperty("deviceSerialNumber1")));
	}
		    }
}
	@Then("user click on Day light saving Time option by selecting device")
	public void userClickOnDayLightSavingTimeOption() throws InterruptedException {
		deviceManagement.DayLightSavingTime();
	}

	@Then("user click on Day light saving Time option without selecting device")
	public void userClickOnDayLightSavingTimeOptionWithoutSelectingDevice() throws InterruptedException {
		deviceManagement.clickOnDevicePageIcons("Daylight Saving Time");
	}

	@And("user validate Please select device first error message")
	public void userValidatePleaseSelectDeviceFirstErrorMessage() {
		deviceManagement.PleaseSelectDevicefirstMessageValidation();
	}
	@Then("user click Cancel button on Day light saving Time option")
	public void userClickOnCancelButtonDayLightSavingTimeOption() throws InterruptedException {
		deviceManagement.CancelDayLightSavingTime();
	}
	@Then("user click on Delete Day light saving Time option by selecting device")
	public void userClickOnDeleteDayLightSavingTimeOption() throws InterruptedException {
		deviceManagement.DeleteDayLightSavingTime();
	}









//syed's code
@Then("validated all the components are displaying or not")
public void validatedallthecomponentsaredisplayingornot() {
	attendance.getViewAllHeadersData();
}

	@Then("upload the transcations for the selected date")
	public void uploadthetranscationsfortheselecteddate() {
		attendance.getUploadTranscationIcon().click();
	}

	@When("user selects the chatbot and entered the message")
	public void userSelectsTheChatbotAndEnteredTheMessage() throws Exception {
		Dashboard dashboard = new Dashboard(driver);
		dashboard.userSelectsTheChatbotAndEnteredTheMessage(driver, dashboard);
	}

	@Then("user should able to get the response from chat bot")
	public void userShouldAbleToGetTheResponseFromChatBot() throws AWTException, InterruptedException {

		dashboard.userShouldAbleToGetTheResponseFromChatBot(driver, dashboard);

	}

	@Then("user close the chatBot window")
	public void userCloseTheChatBotWindow() {
		wait.until(ExpectedConditions.elementToBeClickable(dashboard.getEndChatButton())).click();
	}

	@When("User launch the chatBot window")
	public void userLaunchTheChatBotWindow() throws Exception {
		resetZoomToDefault();
		wait.until(ExpectedConditions.elementToBeClickable(dashboard.getChatBot())).click();
	}

	@Then("User should scroll the chatBot window from bottom to top and from top to bottom")
	public void UsershouldscrollthechatBotwindowfrombottomtotopandfromtoptobottom() throws InterruptedException {

		dashboard.UsershouldscrollthechatBotwindowfrombottomtotopandfromtoptobottom(driver, dashboard);
	}

	@Then("User should delete the conversation by clicking on delete button")
	public void userEnteredDataBySelectingBoldItalicOrderedListItemAndUnorderedListItem() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(dashboard.getDeleteChatBtn())).click();
	}

	@When("user click on organization management submodule")
	public void userClickOnOrganizationManagementSubmodule() throws Exception {
		resetZoomToDefault();
		wait.until(ExpectedConditions.elementToBeClickable(organization.getOrganizationManagementBtn())).click();
	}

	@Given("user login to the application with valid credentials")
	public void userLoginToTheApplicationWithValidCredentials() throws InterruptedException {
		driver.get(properties.getProperty("URL"));
		login.getusernameTextField().sendKeys(properties.getProperty("OldEmailId"));
		login.getuserpasswordTextField().sendKeys(properties.getProperty("Oldpassword"));
		wait.until(ExpectedConditions.elementToBeClickable(login.getLoginButton())).click();
		WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(organization.getSelectOrganizationdropdown()));
		dropdown.click();
		Actions actions = new Actions(driver);
		String organizationName = "DKMk";
		actions.sendKeys(dropdown, organizationName).perform();
		Thread.sleep(500);
		actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
		organization.getEnterOrganizationBtn().click();
		wait.until(ExpectedConditions.urlContains("/dashboard"));
	}

	@Then("User entered inside organization profile home page")
	public void userEnteredInsideOrganizationProfileHomePage() throws Exception {
		resetZoomToDefault();
		wait.until(ExpectedConditions.elementToBeClickable(organization.getOrganization_profile_btn())).click();
		assertTrue(organization.getEditButton_Hover().isDisplayed());
		assertTrue(organization.getDeleteHover_btn().isDisplayed());
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
		organization.getInformation_Icon1().click();
		Thread.sleep(4000);
		organization.getInformation_Icon2().click();
	}

	@Then("User trying to delete the organization permanently")
	public void userTryingToDeleteTheOrganizationPermanently() throws Exception {
		//wait.until(ExpectedConditions.elementToBeClickable(organization.getOrganization_profile_btn())).click();
		wait.until(ExpectedConditions.elementToBeClickable(organization.getDeleteOrganizationBtn())).click();
		wait.until(ExpectedConditions.elementToBeClickable(organization.getAssertBtn())).click();
		wait.until(ExpectedConditions.elementToBeClickable(organization.getActivationCodeField())).sendKeys(properties.getProperty("DeleteorganizationCode"));
		wait.until(ExpectedConditions.elementToBeClickable(organization.getDeletePermanetlybtn())).click();
		wait.until(ExpectedConditions.elementToBeClickable(organization.getDeleteOrgPopupWindow())).click();
		WebElement Delete_Account=wait.until(ExpectedConditions.visibilityOf(organization.getOrganization_Deleted_Successfully()));
		if(Delete_Account.isDisplayed()){
			System.out.println("User is able to delete the Organization successfully");
		}
		else System.out.println("Deletion is not possible");
	}

	@Then("User is trying to edit profile by leaving Mandatory field")
	public void userIsTryingToEditProfileByLeavingMandatoryField() throws Exception {
		resetZoomToDefault();
		wait.until(ExpectedConditions.elementToBeClickable(organization.getEditorganizationBtn())).click();
		WebElement editField = wait.until(ExpectedConditions.visibilityOf(organization.getEditOrganizationtextField()));
		Actions actions = new Actions(driver);
		actions.click(editField).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).perform();
		wait.until(ExpectedConditions.elementToBeClickable(organization.getorganizationEditConfirmbtn())).click();
		wait.until(ExpectedConditions.visibilityOf(organization.getValidate_OrgNametextfield())).getText();
	}

	@Then("user Edit the organization profile and saving the details")
	public void userEditTheOrganizationProfileAndSavingTheDetails() throws Exception {
		resetZoomToDefault();
		wait.until(ExpectedConditions.elementToBeClickable(organization.getOrganization_profile_btn())).click();
		wait.until(ExpectedConditions.elementToBeClickable(organization.getEditorganizationBtn())).click();
		WebElement editField = wait.until(ExpectedConditions.visibilityOf(organization.getEditOrganizationtextField()));
		Actions actions = new Actions(driver);
		actions.click(editField).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).sendKeys(YourNewOrganizationName).perform();
	}

	@Then("User click on cancel button and redirecting to organization profile page")
	public void userClickOnCancelButtonAndRedirectingToOrganizationProfilePage() throws Exception {
		wait.until(ExpectedConditions.elementToBeClickable(organization.getOrgCancelBtn())).click();
	}

	@Then("User is trying to delete the organization")
	public void userIsTryingToDeleteTheOrganization() {
		wait.until(ExpectedConditions.visibilityOf(organization.getDeleteHover_btn())).click();
	}

	@Then("User enters the invalid country name and trying to save the details")
	public void userEntersTheInvalidCountryNameAndTryingToSaveTheDetails() throws Exception {
		resetZoomToDefault();
		wait.until(ExpectedConditions.elementToBeClickable(organization.getOrganization_profile_btn())).click();
		wait.until(ExpectedConditions.elementToBeClickable(organization.getEditorganizationBtn())).click();
		organization.getchangeCountryDropdown().click();
		WebElement editField = wait.until(ExpectedConditions.visibilityOf(organization.getchangeCountryDropdown()));
		Actions actions = new Actions(driver);
		actions.click(editField).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).perform();
		wait.until(ExpectedConditions.elementToBeClickable(organization.getorganizationEditConfirmbtn())).click();
	}

	@Then("User selects the country from the dropdown and save the organization details")
	public void userSelectsTheCountryFromTheDropdownAndSaveTheOrganizationDetails() throws Exception {
		resetZoomToDefault();
		wait.until(ExpectedConditions.elementToBeClickable(organization.getOrganization_profile_btn())).click();
		wait.until(ExpectedConditions.elementToBeClickable(organization.getEditorganizationBtn())).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		wait.until(ExpectedConditions.elementToBeClickable(organization.getchangeCountryDropdown())).click();
		WebElement dropdown = wait.until(ExpectedConditions.visibilityOf(organization.getchangeCountryDropdown()));
		js.executeScript("arguments[0].click();", dropdown);
		Thread.sleep(2000);
		WebElement unitedKingdomOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='United Kingdom']")));
		unitedKingdomOption.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(organization.getorganizationEditConfirmbtn())).click();
		wait.until(ExpectedConditions.visibilityOf(organization.getValidate_Edit_Toast_message())).isDisplayed();
	}

	@Then("User upload the organization profile image successfully")
	public void userUploadTheOrganizationProfileImageSuccessfully() throws Exception {
		resetZoomToDefault();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(organization.getEditProfilePhotoIcon())).click();
		Thread.sleep(4000);
		File imageFile = new File("src/test/resources/1.jpg");
		String imagePath = imageFile.getAbsolutePath();
		WebElement uploadElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='file']")));
		uploadElement.sendKeys(imagePath);  // ✅ Pass absolute path
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(organization.getorganizationEditConfirmbtn())).click();
		boolean isUploaded = wait.until(ExpectedConditions.visibilityOf(organization.getValidate_Edit_Toast_message())).isDisplayed();
		if (isUploaded) {
			System.out.println("Profile picture uploaded successfully.");
		} else {
			System.out.println("Failed to upload profile picture.");
		}

	}

	@Then("User validate all the mentioned country list in Edit organization")
	public void userValidateAllTheMentionedCountryListInEditOrganization() throws Exception {

		OrganizationManagement organization = new OrganizationManagement(driver);
		ValidateAllTheMentionedCountryListInEditOrganization(driver, organization);
	}

	@Then("user should validate the all the components inside View Attendance punch")
	public void userShouldValidateTheAllTheComponentsInsideViewAttendancePunch() {
		ValidateTheAllTheComponentsInsideViewAttendancePunch(driver, attendance);
	}

	@Then("User should delete the chatBot successfully")
	public void userShouldDeleteTheChatBotSuccessfully() throws InterruptedException {
		WebElement inputBoxes = dashboard.getenterDataInsideChatBot();
		wait.until(ExpectedConditions.visibilityOf(inputBoxes));
		inputBoxes.sendKeys("I want more information about NGteco Application");
		wait.until(ExpectedConditions.elementToBeClickable(dashboard.getChatBotSendButton())).click();
		Thread.sleep(4000);
		wait.until(ExpectedConditions.visibilityOf(inputBoxes));
		inputBoxes.sendKeys("Hello, how can I get help?");
		WebElement chatScrollContainer = dashboard.getChatBotScrollContainer();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollTop = arguments[0].scrollHeight;", chatScrollContainer);
		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollTop = 0;", chatScrollContainer);
		wait.until(ExpectedConditions.elementToBeClickable(dashboard.getDeleteChatBtn())).click();
		wait.until(ExpectedConditions.elementToBeClickable(dashboard.getEndChatButton())).click();
	}

	@Then("User is trying to update the name field by entering more than {int} characters")
	public void userIsTryingToUpdateTheNameFieldByEnteringMoreThanCharacters(int arg0) throws Exception {
		resetZoomToDefault();
		wait.until(ExpectedConditions.elementToBeClickable(organization.getOrganization_profile_btn())).click();
		wait.until(ExpectedConditions.elementToBeClickable(organization.getEditButton_Hover())).click();
		WebElement inputField = wait.until(ExpectedConditions.elementToBeClickable(organization.getEditOrganizationtextField()));
		Actions actions = new Actions(driver);
		actions.click(inputField).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).sendKeys(organizationName_200).perform();
		wait.until(ExpectedConditions.elementToBeClickable(organization.getorganizationEditConfirmbtn())).click();
		WebElement toastMessage = wait.until(ExpectedConditions.visibilityOf(organization.getOrg_Name_Exceeds_200chars()));
		if (toastMessage.isDisplayed())
			System.out.println("Stating the error message" + toastMessage);
	}

	@Then("User trying to delete the organization permanently by having atleast one employee")
	public void userTryingToDeleteTheOrganizationPermanentlyByHavingAtleastOneEmployee() throws Exception {
		resetZoomToDefault();
		wait.until(ExpectedConditions.elementToBeClickable(organization.getOrganization_profile_btn())).click();
		wait.until(ExpectedConditions.elementToBeClickable(organization.getDeleteOrganizationBtn())).click();
		wait.until(ExpectedConditions.elementToBeClickable(organization.getAssertBtn())).click();
	}

	@Then("User trying to cancel the delete organization operation")
	public void userTryingToCancelTheDeleteOrganizationOperation() {
		wait.until(ExpectedConditions.elementToBeClickable(organization.getOrganization_profile_btn())).click();
		wait.until(ExpectedConditions.elementToBeClickable(organization.getDeleteOrganizationBtn())).click();
		wait.until(ExpectedConditions.elementToBeClickable(organization.getAssertBtn())).click();
		wait.until(ExpectedConditions.elementToBeClickable(organization.getActivationCodeField())).sendKeys(properties.getProperty("Delete_organizationCode"));
		wait.until(ExpectedConditions.elementToBeClickable(organization.getDeletePermanetlybtn())).click();
		wait.until(ExpectedConditions.elementToBeClickable(organization.getOrganization_Delete_Cancel_btn())).click();
	}

	@Given("user login to the application with new credentials")
	public void userLoginToTheApplicationWithNewCredentials() throws InterruptedException {
		driver.get(properties.getProperty("URL"));
		login.getusernameTextField().sendKeys(properties.getProperty("New_EmailID"));
		login.getuserpasswordTextField().sendKeys(properties.getProperty("New_Password"));
		wait.until(ExpectedConditions.elementToBeClickable(login.getLoginButton())).click();
		wait.until(ExpectedConditions.urlContains("/dashboard"));
	}

	@Then("User should view the mend punches by enabling mend attendance")
	public void userShouldViewTheMendPunchesByEnablingMendAttendance() {
		MendPunch_Enable_code(driver, attendance);
	}
	@Then("user can update the profile photo which is more than {int}MB size")
	public void userCanUpdateTheProfilePhotoWhichIsMoreThanMBSize(int arg0) throws Exception {
		organization.userCanUpdateTheProfilePhotoWhichIsMoreThanMBSize(driver, organization);
	}

	@Then("User will perform the sort operation using person name,person id,Attendance record,Time Zone and Source")
	public void userWillPerformTheSortOperationUsingPersonNamePersonIdAttendanceRecordTimeZoneAndSource() throws InterruptedException, IOException {
		Attendance attendance = new Attendance(driver);
		Sort_ArrowClass(driver, attendance);
	}

	@Then("user filter the record using person name and id fields")
	public void userFilterTheRecordUsingPersonNameAndIdFields() throws IOException, InterruptedException {
		Attendance attendance = new Attendance(driver);
		FilterClass(driver, attendance, Invalid_personId, Invalid_personName);
	}

	@Then("User should able to glance the the information in the usage Tips")
	public void userShouldAbleToGlanceTheTheInformationInTheUsageTips() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(attendance.getUsage_tips_icon())).click();
		Thread.sleep(2000);
	}

	@Then("user should be able to export the records in CSV and Excel format")
	public void userShouldBeAbleToExportTheRecordsInCSVAndExcelFormat() {

		FileDownloadFormat(driver, attendance);

	}

	@Then("user upload the transcations from the given input date")
	public void userUploadTheTranscationsFromTheGivenInputDate() {
		wait.until(ExpectedConditions.elementToBeClickable(attendance.getDownload_transcation_icon())).click();
		wait.until(ExpectedConditions.elementToBeClickable(attendance.getFromDate_label())).click();
		WebElement FromDate = wait.until(ExpectedConditions.elementToBeClickable(attendance.getFromDate_label()));
		Actions actions = new Actions(driver);
		actions.click(FromDate).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).sendKeys(properties.getProperty("From_Date")).perform();
		WebElement ToDate = wait.until(ExpectedConditions.elementToBeClickable(attendance.getToDate_label()));
		Actions action = new Actions(driver);
		action.click(ToDate).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).sendKeys(properties.getProperty("Future_Date")).perform();
		wait.until(ExpectedConditions.elementToBeClickable(attendance.gettranscation_Confirm_btn())).click();
		action.click(ToDate).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).sendKeys(getTodayDateAsNumber()).perform();
		wait.until(ExpectedConditions.elementToBeClickable(attendance.gettranscation_Confirm_btn())).click();
	}

	@Then("User will refresh the page and records should listed properly")
	public void userWillRefreshThePageAndRecordsShouldListedProperly() {
		wait.until(ExpectedConditions.elementToBeClickable(attendance.getView_Attedance_refresh())).click();
	}

	@Then("user should list the records by selecting Ten twenty and Fifty per page")
	public void usershouldlisttherecordsbyselectingTentwentyandFiftyperpage() throws Exception {
		userShouldListTheRecordsBySelecting(driver, attendance);
	}

	@Then("user should navigate to next and previous page")
	public void userShouldNavigateToNextAndPreviousPage() throws Exception {
		attendance.Next_previous_page(driver, attendance);
	}

	@When("user select the Mend Attendance punch")
	public void userSelectTheMendAttendancePunch() {
		SelectMendAtt_Punch_Method(driver, attendance);
		//wait.until(ExpectedConditions.elementToBeClickable(attendance.getMend_Attendance_punch_submodule())).click();
	}

	@Then("User should validate the presence of all components in that page")
	public void userShouldValidateThePresenceOfAllComponentsInThatPage() throws Exception {
		resetZoomToDefault();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(attendance.getMend_Attendance_punch_Header())).isDisplayed();
		wait.until(ExpectedConditions.visibilityOf(attendance.getSearch_Field_display_btn())).isDisplayed();
		List<WebElement> HeaderList = attendance.getView_Attendance_All_Headers();
		System.out.println("Available Headers:");
		for (WebElement headers : HeaderList) {
			System.out.println(headers.getText() + "\t");
		}
		List<WebElement> listrecords = attendance.getView_Page_Records();
		System.out.println("Available records");
		for (WebElement total_Rec : listrecords) {
			System.out.println(total_Rec.getText());
		}
	}

	@Then("User should filter the records based on punch date")
	public void userShouldFilterTheRecordsBasedOnPunchDate() throws InterruptedException {

		Attendance.userShouldFilterTheRecordsBasedOnPunchDate(driver, attendance);
	}

	@Then("user should validate the Add mend attendance page")
	public void userShouldValidateTheAddMendAttendancePage() {
		wait.until(ExpectedConditions.elementToBeClickable(attendance.getAdd_mend_Attendance_btn())).click();
		wait.until(ExpectedConditions.elementToBeClickable(attendance.getAdd_MendAtt_confirm_btn())).click();

	}

	@Then("User should successfully add person to the mend punch")
	public void userShouldSuccessfullyAddPersonToTheMendPunch() throws Exception {
		Attendance.userShouldSuccessfullyAddPersonToTheMendPunch(driver, attendance);

	}

	@Then("user should add the mend attendance successfully")
	public void userShouldAddTheMendAttendanceSuccessfully() {

		Attendance.userShouldAddTheMendAttendanceSuccessfully(driver, attendance);
	}

	@Then("User should able to cancel the add functionality")
	public void userShouldAbleToCancelTheAddFunctionality() {

		Attendance.userShouldAbleToCancelTheAddFunctionality(driver, attendance);
	}


	@Then("User should refresh the Mend attendance page and record should listed properly")
	public void userShouldRefreshTheMendAttendancePageAndRecordShouldListedProperly() {

		wait.until(ExpectedConditions.elementToBeClickable(attendance.getMend_ATT_Refresh_icon())).click();
	}

	@Then("user can update the mend record punch")
	public void userCanUpdateTheMendRecordPunch() {
		Attendance.userCanUpdateTheMendRecordPunch(driver, attendance);
	}

	@Then("User can cancel the update functionality")
	public void userCanCancelTheUpdateFunctionality() {

		Attendance.userCanCancelTheUpdateFunctionality(driver, attendance);


	}

	@Then("user can delete the mend attendance punch")
	public void userCanDeleteTheMendAttendancePunch() {
		Attendance.userCanDeleteTheMendAttendancePunch(driver, attendance);

	}

	@Then("User can cancel the delete operation")
	public void userCanCancelTheDeleteOperation() {
		Attendance.userCanCancelTheDeleteOperation(driver, attendance);


	}

	@Then("User can sort the record by using Mend record headers")
	public void userCanSortTheRecordByUsingMendRecordHeaders() {
		Sort_ArrowClass(driver, attendance);

	}

	@Then("user should to next page and the previous page")
	public void userShouldToNextPageAndThePreviousPage() throws Exception {

		Next_Page_Previous_page_With_single_record(driver, attendance);
	}

	@When("User selects Time card management submodule")
	public void userSelectsTimeCardManagementSubmodule() throws Exception {

		WebElement ScrollUntil = wait.until(ExpectedConditions.elementToBeClickable(attendance.getTime_card_Management_subModule()));
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true);", ScrollUntil);
		ScrollUntil.click();
		Thread.sleep(2000);
	}

	@Then("user should list the records by selecting Ten twenty and Fifty per pages")
	public void userShouldListTheRecordsBySelectingTenTwentyAndFiftyPerPages() throws Exception {

		attendance.userShouldListTheRecordsBySelecting(driver, attendance);

	}


	@Then("user can download the report by using XLSX or CSV format")
	public void userCanDownloadTheReportByUsingXLSXOrCSVFormat() throws InterruptedException {

		wait.until(ExpectedConditions.elementToBeClickable(attendance.getDownload_Hover_Btn())).click();
		List<WebElement> redTextRecords = attendance.getExportListRecord();
		for (WebElement record : redTextRecords) {
			record.click();
			wait.until(ExpectedConditions.elementToBeClickable(attendance.getSuccessToastMessage())).isDisplayed();
		}
		wait.until(ExpectedConditions.elementToBeClickable(attendance.getDownload_Hover_Btn())).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(attendance.getCSV_Download_Format())).click();
		wait.until(ExpectedConditions.elementToBeClickable(attendance.getSuccessToastMessage())).isDisplayed();
		Thread.sleep(2000);
	}
	@Then("User can export the record by disabling timeZone")
	public void userCanExportTheRecordByDisablingTimeZone() throws InterruptedException {
		attendance.CodeForDisableTimeZone(driver, attendance);
	}

	@Then("user can Refresh the page and records should get listed properly")
	public void userCanRefreshThePageAndRecordsShouldGetListedProperly() throws InterruptedException {
		attendance.userCanRefreshThePageAndRecordsShouldGetListedProperly(driver, attendance);

	}
		@Then("User should validate all the components in Time card management page")
	public void userShouldValidateAllTheComponentsInTimeCardManagementPage() throws InterruptedException {
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(attendance.getTime_card_Management_header())).isDisplayed();
		wait.until(ExpectedConditions.visibilityOf(attendance.getFilter_search_bar_ViewAtt())).isDisplayed();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement hoverElement = wait.until(ExpectedConditions.visibilityOf(attendance.getDownload_Hover_Btn()));
		Actions actions = new Actions(driver);
		actions.moveToElement(hoverElement).perform();
		WebElement FromDateVisibility = wait.until(ExpectedConditions.visibilityOf(attendance.getFrom_Date_Visibility()));
		Actions action = new Actions(driver);
		action.moveToElement(FromDateVisibility).perform();
		WebElement ToDate_Visibility = wait.until(ExpectedConditions.visibilityOf(attendance.getTo_Date_Visibility()));
		Actions action2 = new Actions(driver);
		action2.moveToElement(ToDate_Visibility).perform();
		List<WebElement> HeaderList = attendance.getView_Attendance_All_Headers();
		System.out.println("Available Headers:");
		for (WebElement headers : HeaderList) {
			System.out.println(headers.getText() + "\t");
		}
	}

	@Then("User should view all the punches done for the current month")
	public void userShouldViewAllThePunchesDoneForTheCurrentMonth() throws InterruptedException {
		Thread.sleep(4000);
		List<WebElement> listrecords = attendance.getTo_Display_All_records();
		System.out.println("Available records");
		for (WebElement total_Rec : listrecords) {
			System.out.println(total_Rec.getText());
		}
	}

	@Then("User should view the abnormal reports by selecting abnormal records button")
	public void userShouldViewTheAbnormalReportsBySelectingAbnormalRecordsButton() throws InterruptedException {
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(attendance.getAbNormalRecordsCB())).click();
		Thread.sleep(2000);
		List<WebElement> listrecords = attendance.getTo_Display_All_records();
		System.out.println("Available records");
		for (WebElement total_Rec : listrecords) {
			System.out.println(total_Rec.getText());
		}
	}

	@Then("User should able to filter the records using person name and timesheet")
	public void userShouldAbleToFilterTheRecordsUsingPersonNameAndTimesheet() throws InterruptedException {
		WebElement inputFile1 = wait.until(ExpectedConditions.elementToBeClickable(attendance.getFilter_search_bar_ViewAtt()));
		inputFile1.sendKeys(properties.getProperty("TMCard_PersonID"));
		Thread.sleep(3000);
		Actions actions = new Actions(driver);
		actions.click(inputFile1).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).sendKeys(properties.getProperty("TimeSheet_Name")).perform();
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		WebElement inputFile = wait.until(ExpectedConditions.elementToBeClickable(attendance.getFilter_search_bar_ViewAtt()));
		action.click(inputFile1).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).perform();
		inputFile.sendKeys(properties.getProperty("TMCard_personName"));
		Thread.sleep(2000);
	}

	@Then("User can view the usage tips in Timecard_management")
	public void userCanViewTheUsageTipsInTimecard_management() throws Exception {
		resetZoomToDefault();
		wait.until(ExpectedConditions.elementToBeClickable(attendance.getUsage_tips_icon())).click();
		Thread.sleep(2000);
	}

	@Then("User can export the records by selecting from and Todate")
	public void userCanExportTheRecordsBySelectingFromAndTodate() throws InterruptedException {

		wait.until(ExpectedConditions.elementToBeClickable(attendance.getExport_RecordsBtn())).click();
		WebElement FromDate_textField = wait.until(ExpectedConditions.elementToBeClickable(attendance.getExport_From_Date()));
		FromDate_textField.click();
		Actions actions = new Actions(driver);
		actions.click(FromDate_textField).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).sendKeys(properties.getProperty("From_Date")).perform();
		Thread.sleep(3000);
		WebElement ToDate = wait.until(ExpectedConditions.elementToBeClickable(attendance.getExport_To_Date()));
		ToDate.click();
		Actions action = new Actions(driver);
		action.click(ToDate).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).sendKeys(properties.getProperty("Future_Date")).perform();
		wait.until(ExpectedConditions.elementToBeClickable(attendance.gettranscation_Confirm_btn())).click();
		action.click(ToDate).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).sendKeys(getTodayDateAsNumber()).perform();
		wait.until(ExpectedConditions.visibilityOf(attendance.getText_Area_Field())).sendKeys(properties.getProperty("Email_id_Field"));
		wait.until(ExpectedConditions.elementToBeClickable(attendance.gettranscation_Confirm_btn())).click();

	}

	@Then("User should filter the records based on the selected date from the calender")
	public void userShouldFilterTheRecordsBasedOnTheSelectedDateFromTheCalender() throws InterruptedException {
		Thread.sleep(2000);
		WebElement FromDate_textField = wait.until(ExpectedConditions.elementToBeClickable(attendance.getFromDate_label()));
		FromDate_textField.click();
		Actions actions = new Actions(driver);
		actions.click(FromDate_textField).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE);
		FromDate_textField.sendKeys(properties.getProperty("From_Date"));
		Thread.sleep(3000);
		WebElement ToDate = wait.until(ExpectedConditions.elementToBeClickable(attendance.getToDate_label()));
		ToDate.click();
		Actions action = new Actions(driver);
		action.click(ToDate).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE);
		ToDate.sendKeys(properties.getProperty("Future_Date"));
	}

	@Then("User can enable and send automatic report sending")
	public void userCanEnableAndSendAutomaticReportSending() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(attendance.getExport_RecordsBtn())).click();
		WebElement FromDate_textField = wait.until(ExpectedConditions.elementToBeClickable(attendance.getExport_From_Date()));
		FromDate_textField.click();
		Actions actions = new Actions(driver);
		actions.click(FromDate_textField).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).sendKeys(properties.getProperty("From_Date")).perform();
		Thread.sleep(3000);
		WebElement ToDate = wait.until(ExpectedConditions.elementToBeClickable(attendance.getExport_To_Date()));
		ToDate.click();
		Actions action = new Actions(driver);
		action.click(ToDate).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).sendKeys(getTodayDateAsNumber()).perform();
		wait.until(ExpectedConditions.visibilityOf(attendance.getText_Area_Field())).sendKeys(properties.getProperty("Email_id_Field"));
		WebElement chatScrollContainer = attendance.getScroll_bar_viewAtt();
		scrollTopToBottomAndBack(chatScrollContainer, driver);
		WebElement Automatic_SendingFRTDate = wait.until(ExpectedConditions.elementToBeClickable(attendance.getAutomatic_SendingFRTDate()));
		Automatic_SendingFRTDate.click();
		Actions act = new Actions(driver);
		act.click(Automatic_SendingFRTDate).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).sendKeys(properties.getProperty("From_Date")).perform();
		WebElement TimeForSendingReport = wait.until(ExpectedConditions.elementToBeClickable(attendance.getTimeForSendingReport()));
		TimeForSendingReport.click();
		Actions Input = new Actions(driver);
		Input.click(TimeForSendingReport).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE);
		TimeForSendingReport.sendKeys(properties.getProperty("ClockTime"));
		WebElement EmailShareList = wait.until(ExpectedConditions.elementToBeClickable(attendance.getEmailShareList()));
		EmailShareList.click();
		Actions EmailShare = new Actions(driver);
		EmailShare.click(EmailShareList).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).sendKeys(properties.getProperty("EmailShareList")).perform();
		wait.until(ExpectedConditions.elementToBeClickable(attendance.getSecondConfirmBtn())).click();
		wait.until(ExpectedConditions.visibilityOf(attendance.getSuccessToastMessage())).isDisplayed();
	}

	@Then("User can export report sending in daily weekly or monthly wise")
	public void userCanExportReportSendingInDailyWeeklyOrMonthlyWise() throws InterruptedException {
		attendance.ExportRecordusingAutomaticReportToggle(driver, attendance);
		wait.until(ExpectedConditions.elementToBeClickable(attendance.getWeeklYToggleBtn())).click();
		wait.until(ExpectedConditions.elementToBeClickable(attendance.getSecondConfirmBtn())).click();
		wait.until(ExpectedConditions.visibilityOf(attendance.getSuccessToastMessage())).isDisplayed();
		wait.until(ExpectedConditions.elementToBeClickable(attendance.getMonthlyToggleBtn())).click();
		wait.until(ExpectedConditions.visibilityOf(attendance.getSuccessToastMessage())).isDisplayed();

	}
	}
