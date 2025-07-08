package pageObject;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

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
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.Base;
import java.util.ArrayList;


public class DeviceManagement {

	private WebDriver driver;
    JavascriptExecutor javascriptExecutor;
    Actions actions;
    Robot robot;
    WebDriverWait wait;

    public Properties properties;
    public Login login;
    public Dashboard dashboard;
    public Base base;
    
    
    public DeviceManagement(WebDriver driver) throws IOException {
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
    }

@FindBy(xpath = "//p[.='Device Management']")
private WebElement DeviceManagementModule;
@FindBy(xpath = "//p[.='Device']")
private WebElement DevicePageHeading;
@FindBy(xpath = "//div[@role='rowgroup']/div/div")
private List<WebElement> deviceColumnHeader;
@FindBy(xpath = "//div[@class='MuiGrid-root css-1t8v9jn']/div[2]/div/div/div")
private List<WebElement> devicePageIconList;

@FindBy(xpath = "//div[@class='MuiGrid-root css-1x1r1rn']/label/span/input")
private WebElement addDeviceCheckbox;
@FindBy(xpath = "//button[.='Continue']")
private WebElement addDeviceContinueButton;
@FindBy(xpath = "//div[@class='MuiGrid-root css-10w8u0j']")
private List<WebElement> stepsInstrctionsList;
@FindBy(xpath = "//div[@class='MuiBox-root css-1fjsjgq']/div/p")
private List<WebElement> addDeviceInfo;
@FindBy(xpath = "//input[@name='sn']")
private WebElement deviceSerialNoTextfield;
@FindBy(xpath = "//div[.='Bind device to your organization']")
private WebElement BindDevicePageHeading;
@FindBy(xpath = "//div[@class='MuiBox-root css-a2wsy3']")
private WebElement bindedDeviceSerialNo;
@FindBy(xpath = "//input[@role='combobox']")
private WebElement bindDeviceSitetextfield;
@FindBy(xpath = "//div[@class='MuiDataGrid-virtualScrollerContent css-0']/div/div")
private List<WebElement> deviceList;
@FindBy(xpath = "//div[@data-field='sn']")
private List<WebElement>addedDeviceSerialNoList;
@FindBy(xpath = "//div[@class='MuiDataGrid-virtualScrollerContent css-0']/div/div/div")
private List<WebElement>eachColoum;
@FindBy(xpath = "//div[@class='MuiStack-root css-1xedvb2']/div")
private List<WebElement> ActionIconList;
@FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body1 css-9l3uo3']")
private List<WebElement> deviceDetailPageTextFields;
@FindBy(xpath = "//input[@class='MuiInputBase-input MuiOutlinedInput-input Mui-disabled css-1vvjlaa']")
private List<WebElement>deviceDetailtextfieldValue;
@FindBy(xpath = "//input[@name='alias']")
private WebElement editdeviceAliastextfield;
@FindBy(xpath = "//li[@role='menuitem' and .='Reboot device']")
private WebElement RebootDeviceOption;
@FindBy(xpath = "//li[@role='menuitem' and .='Person in this device']")
private WebElement PersonInThisDeviceOption;
@FindBy(xpath = "//div[@class='MuiDataGrid-virtualScrollerRenderZone css-1inm7gi']/div")
List<WebElement>personListInPersonInThisDevicePage;

public WebElement getPersonInThisDeviceOption() {
	return PersonInThisDeviceOption;
}
public List<WebElement> getPersonListInPersonInThisDevicePage() {
	return personListInPersonInThisDevicePage;
}

public WebElement getRebootDeviceOption() {
	return RebootDeviceOption;
}

public WebElement getEditdeviceAliastextfield() {
	return editdeviceAliastextfield;
}

public List<WebElement> getDeviceDetailtextfieldValue() {
	return deviceDetailtextfieldValue;
}

public List<WebElement> getDeviceDetailPageTextFields() {
	return deviceDetailPageTextFields;
}

public List<WebElement> getActionIconList() {
	return ActionIconList;
}

public List<WebElement> getEachColoum() {
	return eachColoum;
}

public List<WebElement> getAddedDeviceSerialNoList() {
	return addedDeviceSerialNoList;
}

public List<WebElement> getDeviceList() {
	return deviceList;
}

public WebElement getBindDevicePageHeading() {
	return BindDevicePageHeading;
}

public WebElement getBindedDeviceSerialNo() {
	return bindedDeviceSerialNo;
}

public WebElement getBindDeviceSitetextfield() {
	return bindDeviceSitetextfield;
}
public WebElement getDeviceSerialNoTextfield() {
	return deviceSerialNoTextfield;
}

public List<WebElement> getAddDeviceInfo() {
	return addDeviceInfo;
}

public List<WebElement> getStepsInstrctionsList() {
	return stepsInstrctionsList;
}

public WebElement getAddDeviceCheckbox() {
	return addDeviceCheckbox;
}
public WebElement getAddDeviceContinueButton() {
	return addDeviceContinueButton;
}
public List<WebElement> getDevicePageIconList() {
	return devicePageIconList;
}
public List<WebElement> getDeviceColumnHeader() {
	return deviceColumnHeader;
}
public WebElement getDevicePageHeading() {
	return DevicePageHeading;
}
public WebElement getDeviceManagementModule() {
	return DeviceManagementModule;
}








public void validate_DeviceManagement_Page() {
	wait.until(ExpectedConditions.urlContains("/dms/device"));
	Assert.assertTrue(getDevicePageHeading().isDisplayed());
	List<String> expectedHeaders = Arrays.asList(
		    "Device name", "SN", "Site name", "Status", "User Count", "Operation"
		);

	List<WebElement> deviceColumnHeaders=getDeviceColumnHeader();
	
	List<String> actualHeaders = new ArrayList<>();
	
	for (WebElement header : deviceColumnHeaders) {
	    actualHeaders.add(header.getText().trim());
	}
	boolean allHeadersPresent = actualHeaders.containsAll(expectedHeaders);

	if (allHeadersPresent) {
	    System.out.println("All expected headers are present.");
	} else {
	    System.out.println("Missing headers: ");
	    for (String expected : expectedHeaders) {
	        if (!actualHeaders.contains(expected)) {
	            System.out.println("- " + expected);
	        }
	    }
	}

}
public void clickOnDevicePageIcons(String iconName ) throws InterruptedException {
	List<WebElement> devicePageIconList=getDevicePageIconList();
	for(WebElement icon:devicePageIconList) {
		if(icon.getText().equals(iconName)) {
		icon.click();
		break;
		}
	}
	Thread.sleep(1000);
	
}

public void validateStepsToAddDevicePage() throws InterruptedException {
	wait.until(ExpectedConditions.visibilityOfAllElements(getStepsInstrctionsList()));
	List<WebElement> stepsInstuction=getStepsInstrctionsList();
	int stepsSize=stepsInstuction.size();
	
		for(int i=0;i<stepsSize;i++) {
		if(stepsInstuction.get(i).getText().equals("Power up and turn on the device")) {
			System.out.println("User read the step1");
		}else if(stepsInstuction.get(i).getText().equals("Configure the network")) {
			System.out.println("User read the step2");
		
		}else if(stepsInstuction.get(i).getText().equals("Register the device to your organization")) {
			System.out.println("User read the step3");
		
		}
		else {
			System.out.println("There are more steps need to read");
		}
}
		Thread.sleep(1000);
		javascriptExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		
           
		Assert.assertTrue(!getAddDeviceContinueButton().isEnabled());
		getAddDeviceCheckbox().click();
		Assert.assertTrue(getAddDeviceCheckbox().isSelected());
		Assert.assertTrue(getAddDeviceContinueButton().isEnabled());
		getAddDeviceContinueButton().click();
		Thread.sleep(2000);
		
}
public void AddDeviceSerialNoPage(String DeviceserialNum) {
	wait.until(ExpectedConditions.visibilityOfAllElements(getAddDeviceInfo()));
	List<WebElement> deviceInfo=getAddDeviceInfo();
	int addDeviceInfo=deviceInfo.size();
	for(int j=0;j<addDeviceInfo;j++) {
		if(j==0) {
			Assert.assertTrue(deviceInfo.get(j).getText().equals("1. Plug in the network cable if device support Ethernet function."));
		}else if(j==1) {
			Assert.assertTrue(deviceInfo.get(j).getText().equals("2. Enter your device Ethernet setting/WiFi setting menu to enter communication setting page Network setup is successful, device will display a OR code in standby page."));
		}
		else if(j==2) {
			Assert.assertTrue(deviceInfo.get(j).getText().equals("3. On the side of device box or on the back of device, can find the device serial number."));
		}
		else if(j==3) {
			Assert.assertTrue(deviceInfo.get(j).getText().equals("4. Fill in device serial number on system."));
		}
		else {
			System.out.println("There are more points are there");
		}
	}
	getDeviceSerialNoTextfield().sendKeys(DeviceserialNum);
	getAddDeviceContinueButton().click();
	
}
public void BindDeviceToYourOrganizationpage(String DeviceSn) throws InterruptedException, AWTException {
	wait.until(ExpectedConditions.visibilityOf(getBindDevicePageHeading()));
	Assert.assertTrue(getBindedDeviceSerialNo().getText().contains(DeviceSn));
	getBindDeviceSitetextfield().click();
	Thread.sleep(1000);
	base.downArrowKey();	
}
public void DeviceAddeddSuccessfullyValidation() throws InterruptedException {
	wait.until(ExpectedConditions.visibilityOf(login.getUseragreementAndPrivacyPolicyToastMessage()));
	Assert.assertTrue(login.getUseragreementAndPrivacyPolicyToastMessage().isDisplayed());
	Assert.assertEquals(login.getUseragreementAndPrivacyPolicyToastMessage().getText(),properties.getProperty("deviceAddSuccessMessage"));
	
	Thread.sleep(1000);
	List<WebElement> addedDeviceSNList=getAddedDeviceSerialNoList();
	
	boolean snFound = false;

	for (WebElement snElement : addedDeviceSNList) {
	    String actualSN = snElement.getText().trim();
	    if (actualSN.equals(properties.getProperty("deviceSerialNumber1"))) {
	        snFound = true;
	        break;
	    }
	}

	Assert.assertTrue(snFound);
}
public void addedDeviceDetailsValidation() {
List<WebElement> rows=getDeviceList();
for (WebElement row : rows) {
List<WebElement>eachcellValue=row.findElements(By.xpath("//div[@class='MuiDataGrid-virtualScrollerContent css-0']/div/div/div"));
if (eachcellValue.size() >= 6) {
String deviceName = eachcellValue.get(1).getText().trim();
String serialNumber = eachcellValue.get(2).getText().trim();
String siteName = eachcellValue.get(3).getText().trim();
String status = eachcellValue.get(4).getText().trim();
String userCount = eachcellValue.get(5).getText().trim();

System.out.println("Validating -> Device: " + deviceName + ", SN: " + serialNumber);
Assert.assertEquals(serialNumber,properties.getProperty("deviceSerialNumber1"));
}else {
    System.out.println("Skipping row due to insufficient columns");
}
}
}
public void unregisteredDeviceMessageValidation() {
	wait.until(ExpectedConditions.visibilityOf(login.getUseragreementAndPrivacyPolicyToastMessage()));
	Assert.assertTrue(login.getUseragreementAndPrivacyPolicyToastMessage().isDisplayed());
	Assert.assertEquals(login.getUseragreementAndPrivacyPolicyToastMessage().getText(),properties.getProperty("invalidDeviceSnMessage"));
}
public void clickOnDeviceIconList(String iconName) {
	List<WebElement>AdddeddeviceList=getDeviceList();
	if(AdddeddeviceList.size()>0) {
	List<WebElement>deviceActionIcon=getActionIconList();
	for(WebElement Icon:deviceActionIcon) {
		if(Icon.getText().equals(iconName)) {
			Icon.click();
			break;
		}
	}
	}else {
		System.out.println("There are no device added");
		Assert.fail();
	}
}
public void deviceDetailPageValidation() {
	wait.until(ExpectedConditions.urlContains("/dms/device/view"));
	String currentUrl=driver.getCurrentUrl();
	Assert.assertTrue(currentUrl.contains("/dms/device/view"));
	List<WebElement>devicedetailtextfields=getDeviceDetailPageTextFields();
	for(WebElement devicedetailfield:devicedetailtextfields) {
	System.out.println(devicedetailfield.getText());
	}
	List<WebElement> textFieldValues=getDeviceDetailtextfieldValue();
	for(WebElement fieldvalue:textFieldValues) {
	if(fieldvalue.getAttribute("value").equals(properties.getProperty("deviceSerialNumber1"))) {
		Assert.assertTrue(true);
		break;
	}
	}	
}
public void deviceEditPageValidation() throws InterruptedException, AWTException {
	wait.until(ExpectedConditions.urlContains("/dms/device/edit"));
	String currentUrl=driver.getCurrentUrl();
	Assert.assertTrue(currentUrl.contains("/dms/device/edit"));
	getBindDeviceSitetextfield().click();
	Thread.sleep(1000);
      base.downArrowKey();
      getEditdeviceAliastextfield().sendKeys("123");
      
}
public void EditDeviceSuucesssMessageValidation() {
	wait.until(ExpectedConditions.visibilityOf(login.getUseragreementAndPrivacyPolicyToastMessage()));
	Assert.assertTrue(login.getUseragreementAndPrivacyPolicyToastMessage().isDisplayed());
	Assert.assertEquals(login.getUseragreementAndPrivacyPolicyToastMessage().getText(),properties.getProperty("SuccessMessage"));
}
public void DeviceReboot() {
    List<WebElement> rows = getDeviceList();

    boolean anyDeviceFound = false;
    if(rows.size()>0) {
    for (WebElement row : rows) {
        List<WebElement> statusCells = row.findElements(By.xpath(".//div[@role='cell' and @data-field='status']"));

        if (!statusCells.isEmpty()) {
            String statusText = statusCells.get(0).getText().trim();

            
            anyDeviceFound = true;

            
            List<WebElement> Operations = row.findElements(By.xpath(".//i[@class='icon iconfont icon-operation']"));

            if (!Operations.isEmpty()) {
            	Operations.get(0).click();
                System.out.println("Clicked action for a device with status: " + statusText);

               
                getRebootDeviceOption().click();
                
                WebElement messageElement= wait.until(ExpectedConditions.visibilityOf(login.getUseragreementAndPrivacyPolicyToastMessage()));

                String messageText = messageElement.getText().trim();
                System.out.println("UI Message: " + messageText);

                if (statusText.equalsIgnoreCase("Online") && messageText.toLowerCase().contains("successful")) {
                    System.out.println("Reboot successful for online device.");
                } else if (statusText.equalsIgnoreCase("Offline") && messageText.toLowerCase().contains("offline")) {
                    System.out.println("Device offline. Reboot not possible.");
                } else {
                    System.out.println("Unexpected message: " + messageText);
                }
            }
            }
        }
    }else {
    	System.out.println("There are no device added");
    	Assert.fail();
    }
    
}
public void syncPersonToDevice() {
    List<WebElement> rows = getDeviceList(); 
    if(rows.size()>0) {
    for (WebElement row : rows) {
        WebElement statusElement = row.findElement(By.xpath(".//div[@role='cell' and @data-field='status']"));
        String statusText = statusElement.getText().trim();
        System.out.println("Device status: " + statusText);

        if (statusText.equalsIgnoreCase("Online")) {
            List<WebElement> syncIcons = row.findElements(By.xpath(".//i[@class='icon iconfont icon-ic_syncperson']"));

            if (!syncIcons.isEmpty()) {
                WebElement syncIcon = syncIcons.get(0);
                WebElement syncText = row.findElement(By.xpath(".//span[contains(text(), 'Sync')]"));

                String style = syncText.getAttribute("style");

                if (style != null && style.contains("cursor: pointer")) {
                    syncIcon.click();
                    System.out.println("Clicked on enabled Sync icon for online device.");
                } else {
                    System.out.println("Sync icon found but not enabled (no pointer cursor).");
                }
            } else {
                System.out.println("No Sync icon found in the row.");
            }
        } else {
            System.out.println("Skipping offline device.");
        }
    }
    }else {
    	System.out.println("There are no device added");
    	Assert.fail();
    }
}
public void ClickOnPersonInThisDevice() {
    List<WebElement> rows = getDeviceList(); 
    if(rows.size()>0) {
      for (WebElement row : rows) {
        WebElement statusElement = row.findElement(By.xpath(".//div[@role='cell' and @data-field='status']"));
        String statusText = statusElement.getText().trim();
        System.out.println("Device status: " + statusText);

//        if (statusText.equalsIgnoreCase("Online")) {
            List<WebElement> Operations = row.findElements(By.xpath(".//i[@class='icon iconfont icon-operation']"));
            if (!Operations.isEmpty()) {
            	Operations.get(0).click();
                System.out.println("Clicked action for a device with status: " + statusText);
                getPersonInThisDeviceOption().click();
                
        } 
//        }
//    else {
//            System.out.println("Skipping offline device.");
//    }
    }
    }else {
    	System.out.println("There are no device added");
    	Assert.fail();
    }
}
public void validatePersonListInPersonInThisDevicePage() {
	List<WebElement> personList=getPersonListInPersonInThisDevicePage();
	if(personList.size()>0) {
	System.out.println("the person present in in the list is: "+personList.size());
	
}else {
	System.out.println("the person list is empty");
}
}
public void DeleteDeviceSuucesssMessageValidation() {
	wait.until(ExpectedConditions.visibilityOf(login.getUseragreementAndPrivacyPolicyToastMessage()));
	Assert.assertTrue(login.getUseragreementAndPrivacyPolicyToastMessage().isDisplayed());
	Assert.assertEquals(login.getUseragreementAndPrivacyPolicyToastMessage().getText(),properties.getProperty("SuccessMessage"));
}
public void DayLightSavingTime() throws InterruptedException {
    List<WebElement> rows = getDeviceList();

    boolean anyDeviceFound = false;
    if(rows.size()>0) {
    	boolean onlineDeviceFound = false;
    for (WebElement row : rows) {
    	        WebElement statusElement = row.findElement(By.xpath(".//div[@role='cell' and @data-field='status']"));
    	        String statusText = statusElement.getText().trim();
    	        System.out.println("Device status: " + statusText);

    	        if (statusText.equalsIgnoreCase("Online")) {
    	        	onlineDeviceFound = true;
    	                List<WebElement> deviceCheckboxes = row.findElements(By.xpath("//input[@aria-label='Select row']"));
            WebElement eachdevicecheckbox = deviceCheckboxes.get(0);
            eachdevicecheckbox.click();
                clickOnDevicePageIcons("Daylight Saving Time");
                dashboard.getConfirmButton().click();
                
                WebElement messageElement= wait.until(ExpectedConditions.visibilityOf(login.getUseragreementAndPrivacyPolicyToastMessage()));
//
                String messageText = messageElement.getText().trim();
                System.out.println("UI Message: " + messageText);

                if (messageText.toLowerCase().contains("successful")) {
                    System.out.println("✅ Daylight Saving Time successful for online device.");
                } else {
                    System.out.println("❌ Unexpected message for online device: " + messageText);
                    Assert.fail("Expected success message but got: " + messageText);
                }
                break;
            }   	        
}
    if (!onlineDeviceFound) {
        System.out.println("All devices are offline. Failing the test.");
        Assert.fail("No online devices found. DST sync failed for all.");
    }
}else {
	System.out.println("There are no device added");
	Assert.fail("There are no device added");
}
}
public void PleaseSelectDevicefirstMessageValidation() {
	wait.until(ExpectedConditions.visibilityOf(login.getUseragreementAndPrivacyPolicyToastMessage()));
	Assert.assertTrue(login.getUseragreementAndPrivacyPolicyToastMessage().isDisplayed());
	Assert.assertEquals(login.getUseragreementAndPrivacyPolicyToastMessage().getText(),properties.getProperty("withoutSelctingdeviceErrorMessage"));
}
public void CancelDayLightSavingTime() throws InterruptedException {
    List<WebElement> rows = getDeviceList();

    boolean anyDeviceFound = false;
    if(rows.size()>0) {
    	boolean onlineDeviceFound = false;
    for (WebElement row : rows) {
    	    List<WebElement> deviceCheckboxes = row.findElements(By.xpath("//input[@aria-label='Select row']"));
            WebElement eachdevicecheckbox = deviceCheckboxes.get(0);
            eachdevicecheckbox.click();
                clickOnDevicePageIcons("Daylight Saving Time");
                dashboard.getCancelButton().click();
                
                Boolean messageElement= wait.until(ExpectedConditions.invisibilityOf(login.getUseragreementAndPrivacyPolicyToastMessage()));
                Assert.assertTrue(messageElement);
                
            }
    	        
}else {
	System.out.println("There are no device added");
	Assert.fail("There are no device added");
}
}
public void DeleteDayLightSavingTime() throws InterruptedException {
    List<WebElement> rows = getDeviceList();

    boolean anyDeviceFound = false;
    if(rows.size()>0) {
    	boolean onlineDeviceFound = false;
    for (WebElement row : rows) {
    	        WebElement statusElement = row.findElement(By.xpath(".//div[@role='cell' and @data-field='status']"));
    	        String statusText = statusElement.getText().trim();
    	        System.out.println("Device status: " + statusText);

    	        if (statusText.equalsIgnoreCase("Online")) {
    	        	onlineDeviceFound = true;
    	                List<WebElement> deviceCheckboxes = row.findElements(By.xpath("//input[@aria-label='Select row']"));
            WebElement eachdevicecheckbox = deviceCheckboxes.get(0);
            eachdevicecheckbox.click();
                clickOnDevicePageIcons("Delete Daylight Saving Time");
                dashboard.getConfirmButton().click();
                
                WebElement messageElement= wait.until(ExpectedConditions.visibilityOf(login.getUseragreementAndPrivacyPolicyToastMessage()));
//
                String messageText = messageElement.getText().trim();
                System.out.println("UI Message: " + messageText);

                if (messageText.toLowerCase().contains("successful")) {
                    System.out.println("✅ Daylight Saving Time successful for online device.");
                } else {
                    System.out.println("❌ Unexpected message for online device: " + messageText);
                    Assert.fail("Expected success message but got: " + messageText);
                }
                break;
            }   	        
}
    if (!onlineDeviceFound) {
        System.out.println("All devices are offline. Failing the test.");
        Assert.fail("No online devices found. Delete DST sync failed for all.");
    }
}else {
	System.out.println("There are no device added");
	Assert.fail("There are no device added");
}
}
}
