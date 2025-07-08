@NGTeco @System
Feature: NGTeco

  Background:
    Given User has launched the URL
    
    #SignUp page
    @TC_01 @TC_SignUp_01 @TC_SignUp
    Scenario: Verify whether Sign Up page contains:1. Language icon 2. “Ready to sign up?“ heading 3.Firstname,lastname,enter your email,password,Confirm password with eye icon.5."I have Read and Agreed to the User Agreement and Privacy Policy"link text with Check box in Sky Blue color.6.Sign up Button 7.Information “Already have an Account? Login link text
    When User will click on SignUp link in login page
    Then User validate the SignUp page elements
    
    @TC_02 @TC_SignUp_02 @TC_SignUp
    Scenario: Verify whether user is getting error message for without providing manadatory fields
    When User will click on SignUp link in login page
    Then User validate the SignUp page elements
    And User click on SignUp button
    Then validate the error message for all the text field
    
     @TC_03 @TC_SignUp_03 @TC_SignUp
    Scenario: Verify whether user able to view the hidden password by clicking on Eye Icon for password and Confirm password field
    When User will click on SignUp link in login page
    Then User will provide password and confirm password field
    Then User will validate hidden password visibility by clicking Eye icon
    
     @TC_04 @TC_SignUp_04 @TC_SignUp
    Scenario: Verify whether user is getting error message for mismatching password for Password and confirm password field
    When User will click on SignUp link in login page
    Then User will provide password and confirm password field data mismatch
    Then User will validate password mismatch message
    
    @TC_05 @TC_SignUp_05 @TC_SignUp
    Scenario: Verify whether user is getting the error message for not selecting the User Agreement and Privacy Policy checkbox
    When User will click on SignUp link in login page
    Then user provide all the sign up page textfield data
    And User click on SignUp button
    Then user validate userAgreement and privacy policy toast message
    
    @TC_06 @TC_SignUp_06 @TC_SignUp
    Scenario: Verify user is able to Read and agree the User Agreement and Privacy Policy pop up page
    When User will click on SignUp link in login page
    And User click on User agreement read and agree button and validate user agreement checkbox
    Then User click on privacy policy read and agree button and validate user agreement checkbox
    
    @TC_07 @TC_SignUp_07 @TC_SignUp
    Scenario: Verify whether user is able to choose the Not agree and quit option in  User Agreement and Privacy Policy pop up page
    When User will click on SignUp link in login page
    And User click on User agreement Not agree and quit button and validate user agreement checkbox
    Then User click on privacy policy Not agree and quit button and validate user agreement checkbox
    
    @TC_08 @TC_SignUp_08 @TC_SignUp
    Scenario: Verify whether user is navigating to Login page from Sign Up page 
    When User will click on SignUp link in login page
    And User click on Login link in SignUp page
    Then validate user navigate to Login page
    
   @TC_09 @TC_SignUp_09 @TC_SignUp
    Scenario: Verify whether user is able to change the application language by choosing the language from the Global Language dropdown menu
    When User click on Language Icon
    And Select the respective language and validate the application page language is getting change
    
    @TC_10 @TC_SignUp_10 @TC_SignUp
    Scenario: Verify whether user is able to Sign Up to the application by providing all the mandatory fields
    When User will click on SignUp link in login page
    And User provide all the mandatory fields for sign up
    And User click on User agreement read and agree button and validate user agreement checkbox
    Then User click on privacy policy read and agree button and validate user agreement checkbox
    And User click on SignUp button
    Then user will validate user navigate to login page
    And Validate user login to the application using the same credntial
    
    @TC_11 @TC_SignUp_11 @TC_SignUp
    Scenario: Verify whether user is getting toast message for creating account with already registered email id
    When User will click on SignUp link in login page
    And User provide all the mandatory fields for sign up
    And User click on User agreement read and agree button and validate user agreement checkbox
    Then User click on privacy policy read and agree button and validate user agreement checkbox
    And User click on SignUp button
    Then User validate user already exist toast message

     @TC_12 @TC_SignUp_11 @TC_SignUp
    Scenario: Verify whether user is getting error message for invalid format for email, password and confirm password
    When User will click on SignUp link in login page
    And User provide invalid format mail,password fields for sign up 
    And User click on SignUp button
    Then Validate format error message for email, password
    
    @TC_13 @TC_Login_01 @TC_Login
    Scenario: Verify whether Login  page contains the below elements:1.Email and password with eye icon text field.2.Remember account in 5 day checkbox.3.Forgot password? link6.Login Button7.Information “Don't have an account? Please Sign up link text
    Then User has already launch the application in background and validating login page elements
   
    @TC_14 @TC_Login_02 @TC_Login
    Scenario: Verify whether user can Login with valid email,companyName and password
    Given user will provide valid username and password
    When user will click on Login button
    Then user will validate dashboard page
    
     @TC_15 @TC_Login_03 @TC_Login
    Scenario: Verify whether user is getting toast message for login with  invalid email and password 
    Given user will provide invalid username and password
    When user will click on Login button
    Then user will validate error toast message
    
    @TC_16 @TC_Login_04 @TC_Login
    Scenario: Verify whether browser is not remember the user's login credentials when user not selecting the Remember account in 5 day check box
    Given user will provide valid username and password
     When user will click on Login button
    Then user will validate dashboard page
    And Again launch the application url in new tab in the same browser window
    Then User has already launch the application in background and validating login page elements
    
		@TC_17 @TC_Login_05 @TC_Login
    Scenario: Verify whether browser is remember the user's login credentials when user selecting the Remember account in 5 day check box
    Given user will provide valid username and password
    And user select the remember account for 5 days checkbox
     When user will click on Login button
    Then user will validate dashboard page
    And Again launch the application url in new tab in the same browser window
    Then user will validate dashboard page
   
    #Not Possible to validate
    @TC_18 @TC_Login_06 @TC_Login
    Scenario: Verify browser is remembering the login creddential only for 5 days on selecting Remember account in 5 day checkbox
    
    @TC_19 @TC_Login_07 @TC_Login
    Scenario: Verify whether Remember account in 5 day is getting reset once user logout from the application
    Given user will provide valid username and password
    And user select the remember account for 5 days checkbox
     When user will click on Login button
    Then user will validate dashboard page
    And Logout from the application
    Then User has already launch the application in background and validating login page elements
    And Again launch the application url in new tab in the same browser window
    Then User has already launch the application in background and validating login page elements

		@TC_20 @TC_Login_08 @TC_Login
    Scenario: Verify whether user is able to navigate to select organization page by login with old creddential
    Given user will provide old user username and password
    When user will click on Login button
    Then user validate select Organization page
    
    @TC_21 @TC_Login_09 @TC_Login
    Scenario: Verify Whether user is not  able to login to the application without  provide mandatory fields
    When user will click on Login button
    Then user validate error message for email and password field

    @TC_22 @TC_Login_10 @TC_Login
    Scenario: Verify whether user is able to select organization from the organization drop-down while login with old user credential
    Given user will provide old user username and password
    When user will click on Login button
    Then user validate select Organization page
    And select the organization from the dropdown
    Then user will validate dashboard page
    
     @TC_23 @TC_Login_11 @TC_Login
    Scenario: Verify whether user is getting error message for without selecting organization when user is login with old user credentials
    Given user will provide old user username and password
    When user will click on Login button
    Then user validate select Organization page
    And user click on the enter button without selecting organization from dropdown
    Then user will validate toast message for select organization
    
    @TC_24 @TC_Forgot_Password_01 @TC_Forgot_Password
    Scenario: Verify error message is displaying when user enters invalid email/empty email/unregistered email
    Given User click on Forgot password link in login page
    When user click on Send Link button
    Then user validate the please fill out this field  error message
    And user provide invalid email id
    When user click on Send Link button
    Then user validate invalid email format error message
    And user provide unregistered email id
    When user click on Send Link button
    Then user validate user does not exist toast message
     
    @TC_25 @TC_Forgot_Password_02 @TC_Forgot_Password
    Scenario: Verify whether the Email is delivered to the user with  proper Content
    Given User click on Forgot password link in login page
    And user provide registered email id
    When user click on Send Link button
    Then user validate success message
    
    @TC_26 @TC_Forgot_Password_03 @TC_Forgot_Password
    Scenario: Verify whether the back to log-In Link is redirecting to the log-in page 
    Given User click on Forgot password link in login page
    When User click on back to login link
    Then User validate Login page
    #Not able to validate in automation as mail things needs to verify
    @TC_27 @TC_Forgot_Password_04 @TC_Forgot_Password
    Scenario: Verify whether user able to reset the password by using reset password link in user email
    
    @TC_28 @TC_Reset_Password_01 @TC_Reset_Password
    Scenario: Verify whether user is able to reset the password successfully
    Given user will provide valid username and password
    When user will click on Login button
    Then user will validate dashboard page
    And user click on user profile icon
    Then user click on Reset password option from dropdown
    And user provide old,new and confirmed password
    And user click on Confirm button
    Then user validate the success message
    And user login to the application with new password
    When user will click on Login button
    Then user will validate dashboard page
    
    @TC_29 @TC_Reset_Password_02 @TC_Reset_Password
    Scenario: Verify whether user able to get the error message for below scenarios:1.New password,confirmed password can not be same as old password.2.Invalid password format3.New password and confirm password mismatch.4.Wrong old password.
    And user login to the application with new password
    When user will click on Login button
    Then user will validate dashboard page
    And user click on user profile icon
    Then user click on Reset password option from dropdown
    And user provide same old password for old,new and confirmed password
    And user click on Confirm button
    Then user validate new password can not be same as old password
    And user clear all fields and enter invalid password format
    And user click on Confirm button
    Then user validate password format error message
    And user clear all fields and enter not matching new password and confirm password
    And user click on Confirm button
    Then user validate password mismatch error message
    
     @TC_30 @TC_Reset_Password_03 @TC_Reset_Password
    Scenario: Verify whether user is getting error message for not providing value to the each mandatory field data. 
    And user login to the application with new password
    When user will click on Login button
    Then user will validate dashboard page
    And user click on user profile icon
    Then user click on Reset password option from dropdown
    And user click on Confirm button
    Then validate the error message for all the text field
    
    @TC_31 @TC_Reset_Password_04 @TC_Reset_Password
    Scenario: Verify user able to hide and unhide the old password,New password,confirmed password field data by clicking on Eye icon
    And user login to the application with new password
    When user will click on Login button
    Then user will validate dashboard page
    And user click on user profile icon
    Then user click on Reset password option from dropdown
    And user provide same old password for old,new and confirmed password
    Then User validate each field data is getting hide and unhide
    
    @TC_32 @TC_Dashboard_01 @TC_Dashboard
    Scenario: Verify presence below mentioned count tabs in Dashboard Page a)Attendance b)Device Overview c)Daily Attendance Records d)Attendance Status e)Announcement f)Help Info g)Language h)User Profile i)Logout icon j)List of all modules
    And user login to the application with new password
    When user will click on Login button
    Then user will validate dashboard page
    
    #The below 2 test cases can't be validate in automation as everytime value will be different based on user login and it should be validate manually
    @TC_33 @TC_Dashboard_02 @TC_Dashboard
    Scenario: Verify whether the user is able to refresh  a)Attendance b)Device Overview c)Daily Attendance Records d)Attendance Status  record by clicking on refresh icon 
    @TC_34 @TC_Dashboard_03 @TC_Dashboard
    Scenario: Verify whether user is getting  Today, This Week,This Month attendance count under Attendance section
   
    @TC_35 @TC_Dashboard_04 @TC_Dashboard
    Scenario: Verify whether the user is able to  get the list of mend attendence record and attendance punch records 
   
    @TC_36 @TC_Help_Info_01 @TC_Dashboard
    Scenario: Verify whether user is able to  play each video content under Help Videos list
     And user login to the application with new password
    When user will click on Login button
    Then user will validate dashboard page
    Given User click on Help Info icon
    Then User will click one by one videos and validate video plays
    
    @TC_37 @TC_Help_Info_02 @TC_Dashboard
    Scenario: Verify user is able to close the video window on clicking the Cancel button
    And user login to the application with new password
    When user will click on Login button
    Then user will validate dashboard page
    Given User click on Help Info icon
    Then User will click one by one videos and validate video plays and click on Cancel button to close the window
   
   @TC_38 @TC_Dashboard_Language_01 @TC_Dashboard
    Scenario: Verify whether user is able to change the application language by choosing the language from the  Language dropdown menu
    And user login to the application with new password
    When user will click on Login button
    Then user will validate dashboard page
    When User click on Language Icon
    And Select the respective language and validate the dashboard page language is getting change
    
    #Can't validate bewlow test cases in automation, needs to validate manually.
    @TC_39 @TC_Device_Overview_01 @TC_Dashboard
    Scenario: Verify whether the user is able to get the list of online and offline devices .
   @TC_40 @TC_Attendance_06 @TC_Dashboard
    Scenario: Verify user can able to see the count of abnormal and normal perons.
    @TC_41 @TC_Daily_Attendance_Records_01 @TC_Dashboard
    Scenario: Verify whether user is able to get all the list of attendance records in Daily attendance records section on daily basis
    @TC_42 @TC_Attendance_Status_01 @TC_Dashboard
    Scenario: Verify whether the user is able to see the Attendance Status  Present and Absent Records  Records 
   #Below feature are not present in application
    @TC_43 @TC_Dashboard_05 @TC_Dashboard
    Scenario: Verify for first-time logged in users, the notification dialog box is popped up and will only disappear after clicking Confirm button.
    @TC_44 @TC_Dashboard_06 @TC_Dashboard
    Scenario: Verify whether announcement pop up page is not displaying for 30 days by selecting 30 days off checkbox
    @TC_45 @TC_Dashboard_07 @TC_Dashboard
    Scenario: Verify user is getting Announcement pop up page after every login by unselecting the 30 days checkbox
    
    @TC_46 @TC_Announcement_01 @TC_Dashboard
    Scenario: Verify user is able to see the announcement for Chnagelogs,New Timesheet,New mobile apps 
    And user login to the application with new password
    When user will click on Login button
    Then user will validate dashboard page
    And user click on Announcement Icon
    Then validate Change Logs Announcement
    And user click on Announcement Icon
    Then validate New Timesheet Announcement
    And user click on Announcement Icon
    Then validate New Mobile Apps Announcement
     
    @TC_47 @TC_Logout_01 @TC_Logout
    Scenario: Verify whether user can logout from the application 
    And user login to the application with new password
    When user will click on Login button
    Then user will validate dashboard page
    And Logout from the application
    Then User has already launch the application in background and validating login page elements
    
    @TC_48 @TC_Logout_02 @TC_Logout
    Scenario: Verify whether user can not logout from the application via cancel button
    And user login to the application with new password
    When user will click on Login button
    Then user will validate dashboard page
    And Logout from the application by canceling the logout
    Then user will validate dashboard page
    
    @TC_49 @TC_Contact_Us_01 @TC_ContactUs @TC_Dashboard
    Scenario: Verify whether user able to contact the application support team by creating a ticket in Contact Us page
    And user login to the application with new password
    When user will click on Login button
    Then user will validate dashboard page
    And user click on user profile icon
    Then user click on Contact Us option from dropdown
    And user created one Help Desk ticket
    
     @TC_50 @TC_Contact_Us_02 @TC_ContactUs @TC_Dashboard
    Scenario: Verify whether Contact Us window containes:
1.Header-“NGTeco Help Desk - NGTeco Application Support“
2.Information -“Contact us through E-mail: ngtime@ngteco.com“
3.Text field “Email Address“ with Mandatory field
4.“Country “Drop Down Menu with List - List of countries in NGTeco
5. “Summary“Text field with Mandatory field
6.“Description“ Text field with Mandatory field
7.“Country Code“ Drop Down with Place Holder “Select Country“with  list of countries code which is Mandatory field

    And user login to the application with new password
    When user will click on Login button
    Then user will validate dashboard page
    And user click on user profile icon
    Then user click on Contact Us option from dropdown
    Then validate Contact Us Application Support page
    
    @TC_51 @TC_Contact_Us_03 @TC_ContactUs @TC_Dashboard
    Scenario: Verify whether user is getting error message for mandatory fields
    And user login to the application with new password
    When user will click on Login button
    Then user will validate dashboard page
    And user click on user profile icon
    Then user click on Contact Us option from dropdown
    And user click on Save button
    Then validate the error message for all the text field
    
    @TC_52 @TC_Contact_Us_04 @TC_ContactUs @TC_Dashboard
    Scenario: Verify whether by default Company Name,Contact person,Country and email address is taking for the logined user
    And user login to the application with new password
    When user will click on Login button
    Then user will validate dashboard page
    And user fetch the organization details
    And user click on user profile icon
    Then user click on Profile option from dropdown 
    And user validate Account Profile page
    And user click on user profile icon
    Then user click on Contact Us option from dropdown
    Then Validate the default Company Name,Contact person,Country and email address is reflecting in the respective field
    
    @TC_53 @TC_Profile_01 @TC_Profile @TC_Dashboard
    Scenario: Verify whether Account profile page contains below elements:1.Firstname,lastname,email with non edditable field with default user details.2.Edit icon
     And user login to the application with new password
    When user will click on Login button
    Then user will validate dashboard page
     And user click on user profile icon
    Then user click on Profile option from dropdown
    And user validate Account Profile page
    
   @TC_54 @TC_Profile_02 @TC_Profile @TC_Dashboard
    Scenario: Verify whether user able to edit the user details 1.Firstname,lastname,email 
     And user login to the application with new password
    When user will click on Login button
    Then user will validate dashboard page
     And user click on user profile icon
     Then user click on Profile option from dropdown
    And user validate validate account profile edited successfully
    Then validate User updated successfully. success message
    And user validate Account Profile updated successfully in Account profile page
    
    
    @TC_55 @TC_Profile_03 @TC_Profile @TC_Dashboard
    Scenario: Verify whether user is not able to login to the application with old email after updating the email in Account profile page
    And user login to the application with new password
    When user will click on Login button
    Then user will validate error toast message
    
     @TC_56 @TC_Profile_04 @TC_Profile @TC_Dashboard
    Scenario: Verify whether user is  able to login to the application with new email after updating the email in Account profile page
    And user login to the application with updated email and password
    When user will click on Login button
    Then user will validate dashboard page
    
    @TC_57 @TC_Profile_05 @TC_Profile @TC_Dashboard
    Scenario: verify whether user unable to upload more than 3mb photo
    And user login to the application with updated email and password
    When user will click on Login button
    Then user will validate dashboard page
     And user click on user profile icon
     Then user click on Profile option from dropdown
     Then user uploaded photo more than 3mb
     Then user will validate error toast message
    
    @TC_58 @TC_About_01 @TC_About @TC_Dashboard
    Scenario: verify whether user can able to know abow about user agreement,Privacy policy,Info Collection Form,Compliance from respective tab
    And user login to the application with updated email and password
    When user will click on Login button
    Then user will validate dashboard page
     And user click on user profile icon
     Then user click on About option from dropdown
     Then validate one by one About page option
     
    @TC_59 @TC_Delete_Account_01 @TC_DeleteAccount @TC_Dashboard
    Scenario: Verify whether user is unable to delete the account if organization & Devices/person are present.
     And user login to the application with updated email and password
    When user will click on Login button
    Then user will validate dashboard page
    And user click on user profile icon
    Then user click on Delete Account option from dropdown
    And validate  delete organization permanently and delete account permanently.pop up window
    Then validate The account still has organization pop up window
    
    @TC_60 @TC_Delete_Account_01 @TC_DeleteAccount @TC_Dashboard
    Scenario: Verify whether User account is getting deleted as soon as user delete the organization
    And user login to the application with updated email and password
    When user will click on Login button
    Then user will validate dashboard page
    And user delete organization
    Then validate oragnization and account got deleted
    And user login to the application with updated email and password
    When user will click on Login button
    Then user will validate error toast message
    
    #Organization Person
     @TC_146 @TC_Person_01 @TC_Person @TC_Organization_Management
    Scenario: Verify whether user can create the person by entering valid data into mentioned text fields-
		a)Department,
		b)Person ID,
		c)First Name,
		D)Last Name.
		Cancel and confirm button.
		
		And user login to the application with updated email and password
    When user will click on Login button
    Then user will validate dashboard page
    And user click on Organization Management module
    Then user user click on person sub module
    And user click on Add person icon
    Then user provide all the details to add a person
    Then user validate person added successfully
    
    @TC_147 @TC_148 @TC_149 @TC_152 @TC_Person_02 @TC_Person @TC_Organization_Management
    Scenario: Verify whether person is not adding without providing all the manadatory field data
    And user login to the application with updated email and password
    When user will click on Login button
    Then user will validate dashboard page
    And user click on Organization Management module
    Then user user click on person sub module
    And user click on Add person icon
    And user click on Confirm button
   Then user validate error message for email and password field
   
    @TC_150 @TC_Person_03 @TC_Person @TC_Organization_Management
    Scenario: Verify user can not enter any special character into Person ID text field
    And user login to the application with updated email and password
    When user will click on Login button
    Then user will validate dashboard page
    And user click on Organization Management module
    Then user user click on person sub module
    And user click on Add person icon
    Then user provide special char in personid
    Then user validate special error message
    
    @TC_153 @TC_Person_04 @TC_Person @TC_Organization_Management
    Scenario: verify whether user is adding person and the clicking on cross or Cancel button then person is not creating.
     And user login to the application with updated email and password
    When user will click on Login button
    Then user will validate dashboard page
    And user click on Organization Management module
    Then user user click on person sub module
    And user click on Add person icon
    Then click on Cancel buttton
    
    @TC_154 @TC_Person_05 @TC_Person @TC_Organization_Management
    Scenario: verify whether user can not create person by providing duplicate person iD 
    And user login to the application with updated email and password
    When user will click on Login button
    Then user will validate dashboard page
    And user click on Organization Management module
    Then user user click on person sub module
    And user click on Add person icon
    Then user provide all the details to add a person
    Then user validate Employee code already exist.
    
    
    @TC_155 @TC_Person_06 @TC_Person @TC_Organization_Management
    Scenario: Verify whether user can see updated/added records after refreshing the page.
    And user login to the application with updated email and password
    When user will click on Login button
    Then user will validate dashboard page
    And user click on Organization Management module
    Then user user click on person sub module
    And user refresh the page
    And user validate the list of person records
    
    @TC_156 @TC_Person_07 @TC_Person @TC_Organization_Management
    Scenario: Verify whether user can Search/filter the person in list based on first name
    And user login to the application with updated email and password
    When user will click on Login button
    Then user will validate dashboard page
    And user click on Organization Management module
    Then user user click on person sub module
    And user filter person data based on firstname
    Then user validate filter data
    
    @TC_157 @TC_Person_08 @TC_Person @TC_Organization_Management
    Scenario: Verify whether user can not Search/filter the person in list based on LastName/Email/Person ID,Department
    And user login to the application with updated email and password
    When user will click on Login button
    Then user will validate dashboard page
    And user click on Organization Management module
    Then user user click on person sub module
    And user filter person data based on invalid data
    Then user validate no rows message
    
    @TC_158 @TC_Person_09 @TC_Person @TC_Organization_Management
    Scenario: verify whether user can not create person by providing duplicate person iD 
    And user login to the application with updated email and password
    When user will click on Login button
    Then user will validate dashboard page
    And user click on Organization Management module
    Then user user click on person sub module
    And user click on Add person icon
    Then user provide all the details with existing person email
    Then user Email already exists.
    
    @TC_159 @TC_Person_10 @TC_Person @TC_Organization_Management
    Scenario: Verify whether user can sort the department by department name/code/PersonID,PersonName and email
    And user login to the application with updated email and password
    When user will click on Login button
    Then user will validate dashboard page
    And user click on Organization Management module
    Then user user click on person sub module
    And user click on Person id to sort the list and validate the sorting
    
    @TC_160 @TC_Person_11 @TC_Person @TC_Organization_Management
    Scenario: Verify whether user can edit the addded person by "FirstName","LastName","Department","Email" text fields.
     And user login to the application with updated email and password
    When user will click on Login button
    Then user will validate dashboard page
    And user click on Organization Management module
    Then user user click on person sub module
    And user click on Edit person icon
    Then user provide all the edit field data
    Then validate person updated successfully
    
    @TC_161 @TC_Person_12 @TC_Person @TC_Organization_Management
    Scenario: Verify whether user can delete the person and successful message is displaying.
    And user login to the application with updated email and password
    When user will click on Login button
    Then user will validate dashboard page
    And user click on Organization Management module
    Then user user click on person sub module
    And user click on Delete person icon
    And user click on Confirm button
    Then validate person deleted successfull
    Then user validate no rows message
    
    @TC_162 @TC_Person_13 @TC_Person @TC_Organization_Management
    Scenario: Verify whether user can not delete the person by clicking on cancel/Cross button and person page is displaying.
    And user login to the application with updated email and password
    When user will click on Login button
    Then user will validate dashboard page
    And user click on Organization Management module
    Then user user click on person sub module
    And user click on Add person icon
    Then user provide all the details to add a person
    Then user validate person added successfully
    And user click on Delete person icon
    Then click on Cancel buttton
    
    @TC_163 @TC_Person_14 @TC_Person @TC_Organization_Management
    Scenario: Verify whether user can not "Mark as resign" the person by resignation icon when clicking on cancel/cross icon
    And user login to the application with updated email and password
    When user will click on Login button
    Then user will validate dashboard page
    And user click on Organization Management module
    Then user user click on person sub module
    And user click on Mark as resign icon
    Then click on Cancel buttton
    
    @TC_164 @TC_Person_15 @TC_Person @TC_Organization_Management
    Scenario: Verify whether user can perform "Mark as resign" the person by resignation icon
    And user login to the application with updated email and password
    When user will click on Login button
    Then user will validate dashboard page
    And user click on Organization Management module
    Then user user click on person sub module
    And user click on Mark as resign icon
    And user click on Confirm button
    Then validate person resigned successfully
    
    
    @TC_165 @TC_Person_16 @TC_Person @TC_Organization_Management
    Scenario: Verify user can navigate to next page by clicking on-
1.Next button,
2.Previous button.
    And user login to the application with updated email and password
    When user will click on Login button
    Then user will validate dashboard page
    And user click on Organization Management module
    Then user user click on person sub module
    And user select per page value
    Then validate pagination
    
    @TC_166 @TC_Person_17 @TC_Person @TC_Organization_Management
    Scenario: Verify proper number of records are displaying per page according to selected page size (Ex-10,20,50)
    And user login to the application with updated email and password
    When user will click on Login button
    Then user will validate dashboard page
    And user click on Organization Management module
    Then user user click on person sub module
    And user select per page value
    
    #Organization Management>Resignation
    @TC_193 @TC_Resignation_01 @TC_Resignation @TC_Organization_Management
    Scenario: verify whether the user can view  Person Name,Person ID,department and Action of Resignations when click on Resignations module and view and user can see manage the resignations. and verify that user has to have three options.
1.Resume Resignation,2.View Person Details and 3.Delete Person 
    And user login to the application with updated email and password
    When user will click on Login button
    Then user will validate dashboard page
    And user click on Organization Management module
    And user user click on Resignation sub module
    Then user validate Resignation page
    
    @TC_194 @TC_203 @TC_Resignation_02 @TC_Resignation @TC_Organization_Management
    Scenario: verify whether user can see the resigned person's details by clicking on "eye" icon located in the upper left corner of the resignation page.
    And user login to the application with updated email and password
    When user will click on Login button
    Then user will validate dashboard page
    And user click on Organization Management module
    And user user click on Resignation sub module
    And user validate resigned persons are present
    Then user click on View icon of resigned person
    And user validate resigned person details
    
     @TC_195 @TC_196 @TC_Resignation_03 @TC_Resignation @TC_Organization_Management
    Scenario: Verify user can navigate to next page by clicking on next button and user can navigate to previous page by clicking on previous button
    And user login to the application with updated email and password
    When user will click on Login button
    Then user will validate dashboard page
    And user click on Organization Management module
    And user user click on Resignation sub module
    And user select per page value
    Then validate pagination
    
    @TC_199 @TC_199_202 @TC_Resignation_04 @TC_Resignation @TC_Organization_Management
    Scenario: Verify whether the user can view and click 'Resume resignation' icon   on the Resignation list page
    And user login to the application with updated email and password
    When user will click on Login button
    Then user will validate dashboard page
    And user click on Organization Management module
    And user user click on Resignation sub module
    And user validate resigned persons are present
    Then user click on Resume resignation icon of resigned person
    And user validate the resume resignation dialog page
    And user click on Confirm button
    Then user validate person removed from Resigned list
    
    @TC_204 @TC_205 @TC_Resignation_05 @TC_Resignation @TC_Organization_Management
    Scenario: Verify whether the user can click on 'Delete' icon and person should be deleted from the resignation list page 
    And user login to the application with updated email and password
    When user will click on Login button
    Then user will validate dashboard page
    And user click on Organization Management module
    And user user click on Resignation sub module
    And user validate resigned persons are present
    Then user click on Delete icon of resigned person
    And user validate the delete resignation dialog page
    And user click on Confirm button
    Then user validate person removed from Resigned list
    
     @TC_207  @TC_Resignation_06 @TC_Resignation @TC_Organization_Management
    Scenario: verify whether the user can refresh the page by clicking on refresh icon .
    And user login to the application with updated email and password
    When user will click on Login button
    Then user will validate dashboard page
    And user click on Organization Management module
    And user user click on Resignation sub module
    And user validate resigned persons are present
    Then user click on Delete icon of resigned person
    And user validate the delete resignation dialog page
    And user click on Confirm button
    And user refresh the page
    Then user validate person removed from Resigned list
    
    @TC_208  @TC_Resignation_07 @TC_Resignation @TC_Organization_Management
    Scenario: Verify when user is clicking on usage tips, One pop-up window is displaying.
    And user login to the application with updated email and password
    When user will click on Login button
    Then user will validate dashboard page
    And user click on Organization Management module
    And user user click on Resignation sub module
    Then user click on Usage Tips icon
    And validate Usage Tips information
    
    #Device Management
    @TC_209  @TC_DeviceManagement_01 @TC_Device_Management 
    Scenario: Verify whether device page contains below mentioned Components-
		Page label i.e Device
		Search field
		Device name column
		SN column
		Site name column
		Status column
		Action column
		Add button
		Daylight Saving Time button
		Delete Daylight Saving Time button
		Refresh button
		
    And user login to the application with updated email and password
    When user will click on Login button
    Then user will validate dashboard page
    And user click on Device Management Module
    Then validate device page elements
    
    
    @TC_210  @TC_DeviceManagement_02 @TC_Device_Management 
    Scenario: Verify adding the device such as TC2/D3/TC1 is successfull when entered serial no is valid
    And user login to the application with updated email and password
    When user will click on Login button
    Then user will validate dashboard page
    And user click on Device Management Module
    Then user click on Add device icon
    And validate add device page with Steps page and will select the checkbox with confirm the page
    Then user enters registered device serial number in serial number text field after reading user manual
    And user validate Bind device to your organization page and select Bind site 
    And user click on Confirm button
    Then user validate device added successfully
    
    
    @TC_211  @TC_DeviceManagement_03 @TC_Device_Management 
    Scenario: Verify after successfull adding the device ,details like  Device name, Site name, SN Number and status are displayed properly in device list page
    And user login to the application with updated email and password
    When user will click on Login button
    Then user will validate dashboard page
    And user click on Device Management Module
    Then user validate added device details
    
     @TC_212  @TC_DeviceManagement_04 @TC_Device_Management 
    Scenario: Verify  adding the device such as TC2/D3/TC1 is not successfull when entered serial no is Invalid
    And user login to the application with updated email and password
    When user will click on Login button
    Then user will validate dashboard page
    And user click on Device Management Module
    Then user click on Add device icon
    And validate add device page with Steps page and will select the checkbox with confirm the page
    Then user enters unregistered/invalid device serial number in serial number text field after reading user manual
    And user validate Bind device to your organization page and select Bind site for invalid Device Serial no 
    And user click on Confirm button
    Then user validate The device pre-registration information is not matched error message
    
    @TC_214  @TC_DeviceManagement_05 @TC_Device_Management 
    Scenario: Verify user can navigate to the Device details page is successfull by clicking on Details Icon and also below device details are displayed properly 
			Device Alias
			IP Address
			User Qty.
			Face Qty.
			Fingerprint Qty.
			Status
			Bind Organization
			Bind Site
			Firmware Information
			Protocol Type
			Firmware Version
			
    And user login to the application with updated email and password
    When user will click on Login button
    Then user will validate dashboard page
    And user click on Device Management Module
    Then user click on device detail icon
    And user validate the device detail page
    
    @TC_215  @TC_DeviceManagement_06 @TC_Device_Management 
    Scenario: Verify user can update device details such as -Site and Device Alias and getting successfull message.
    And user login to the application with updated email and password
    When user will click on Login button
    Then user will validate dashboard page
    And user click on Device Management Module
    Then user click on device edit icon
    And user validate edit device page and update the device alias name with site
    And user click on Confirm button
    Then validate device details updated successfully
    
     @TC_216  @TC_DeviceManagement_07 @TC_Device_Management 
    Scenario: Verify device is not updating when user is clicking on cancel button, and user is redirecting to the device page.
    And user login to the application with updated email and password
    When user will click on Login button
    Then user will validate dashboard page
    And user click on Device Management Module
    Then user click on device edit icon
    And user validate edit device page and update the device alias name with site
    Then click on Cancel buttton
    
    @TC_217 @TC_218 @TC_DeviceManagement_08 @TC_Device_Management 
    Scenario: Verify device reboot is successfull when user is clicking on confirm button for online device.
    And user login to the application with updated email and password
    When user will click on Login button
    Then user will validate dashboard page
    And user click on Device Management Module
    Then user click on Reboot device option
    
    @TC_219 @TC_DeviceManagement_09 @TC_Device_Management 
    Scenario: Verify user can sync person to device is successfull when clicked on confirm button after person selection in Select Person screen into device.
    And user login to the application with updated email and password
    When user will click on Login button
    Then user will validate dashboard page
    And user click on Device Management Module
    Then user click on Sync device option
    
    @TC_220 @TC_DeviceManagement_10 @TC_Device_Management 
    Scenario: Verify after syncing person to device, all the person list is reflecting in person in this device page
    And user login to the application with updated email and password
    When user will click on Login button
    Then user will validate dashboard page
    And user click on Device Management Module
    Then user click on Person in this device option
    And user validate person list in person in this device page
    
    @TC_221  @TC_DeviceManagement_11 @TC_Device_Management 
    Scenario: Verify unbinding/delete of device is successfull when clicked on confirm button in Delete Confirmation popup
    And user login to the application with updated email and password
    When user will click on Login button
    Then user will validate dashboard page
    And user click on Device Management Module
    Then user click on device Delete icon
    And user click on Confirm button
    Then validate device deleted successfully
    
    @TC_222  @TC_DeviceManagement_12 @TC_Device_Management 
    Scenario: Verify unbinding/delete of device is not successfull when clicked on cancel button in Delete Confirmation popup
    And user login to the application with updated email and password
    When user will click on Login button
    Then user will validate dashboard page
    And user click on Device Management Module
    Then user click on device Delete icon
    Then click on Cancel buttton
    Then validate device page elements
    
    
    @TC_223 @TC_DeviceManagement_13 @TC_Person @TC_Organization_Management
    Scenario: Verify device search is successfull based on valid serial no in device list page
    And user login to the application with updated email and password
    When user will click on Login button
    Then user will validate dashboard page
    And user click on Device Management Module
    And user filter device based on valid device serial num
    Then user validate device filter data
    
    @TC_226 @TC_227 @TC_DeviceManagement_14 @TC_Person @TC_Organization_Management
    Scenario: Verify device search is not successfull based on invalid serial no
    And user login to the application with updated email and password
    When user will click on Login button
    Then user will validate dashboard page
    And user click on Device Management Module
    And user filter device based on invalid device serial num
    And user refresh the page
    Then user validate no rows message
     
    @TC_228 @TC_230 @TC_DeviceManagement_15 @TC_Device_Management 
    Scenario: Verify "day light saving time" configuration to device is successfull by clicking on confirm button based on timezone selection.
    And user login to the application with updated email and password
    When user will click on Login button
    Then user will validate dashboard page
    And user click on Device Management Module
    Then user click on Day light saving Time option by selecting device
    
   @TC_229 @TC_DeviceManagement_16 @TC_Device_Management 
    Scenario: Verify "day light saving time" configuration is not successfull without selecting device from device list
    And user login to the application with updated email and password
    When user will click on Login button
    Then user will validate dashboard page
    And user click on Device Management Module
    Then user click on Day light saving Time option without selecting device
    And user validate Please select device first error message
    
    @TC_231 @TC_DeviceManagement_17 @TC_Device_Management 
    Scenario: Verify delete of "date light saving time" configuration in device is not successfull when clicked on cancel button in confirm pop-up
    And user login to the application with updated email and password
    When user will click on Login button
    Then user will validate dashboard page
    And user click on Device Management Module
    Then user click Cancel button on Day light saving Time option
    	
    @TC_232 @TC_DeviceManagement_18 @TC_Device_Management 
    Scenario: Verify delete of "date light saving time" configuration in device is  successfull 
    And user login to the application with updated email and password
    When user will click on Login button
    Then user will validate dashboard page
    And user click on Device Management Module
    Then user click on Delete Day light saving Time option by selecting device




 @smoke @sanity @TC_489 @View_Attendance
 Scenario:Verify view attendance punch is displayed along with below components when clicked on Uplod Transcations icon
 1.From
 2.To
 3.Confirm
  Given user login to the application
  Given when Admin click on Attendance module
  And Selected View Attendance punch
  Then upload the transcations for the selected date

 @Smoke @sanity @ChatBotTC_01 @TC_61 @ChatBot @70919
 Scenario: Verify whether user can chat with customer service and resolve their issues using the chatbot option.
  Given user login to the application
  When user selects the chatbot and entered the message
  Then user should able to get the response from chat bot

 @Smoke @sanity @ChatBotTC_02 @TC_62 @ChatBot @70919
 Scenario:Verify whether user is able to MInimize the chatbot windoow.
  Given user login to the application
  When user selects the chatbot and entered the message
  Then user should able to get the response from chat bot
  Then user close the chatBot window

 @Smoke @Sanity @ChatBot_03 @TC_63 @ChatBot @70919
 Scenario: Verify whether user can scroll the page top to bottom and bottom to top to read all the connversations
  Given user login to the application
  When user selects the chatbot and entered the message
  Then user should able to get the response from chat bot
  Then User should scroll the chatBot window from bottom to top and from top to bottom

 @smoke @Sanity @chatBot_04 @TC_64 @ChatBot @70919
 Scenario: Verify whether user can delete the chat history
  Given user login to the application
  When user selects the chatbot and entered the message
  Then user should able to get the response from chat bot
  Then User should delete the chatBot successfully

#  @smoke @Sanity @chatBot_05
#      Scenario: Verify whether user is able to apply the options  such as
#      1.Bold
#      2.Italic
#      3.Ordered list item
#      4.Unorder List item
#        Given user login to the application
#        When user selects the chatbot and entered the message
#        Then user should able to get the response from chat bot
#        Then User should delete the conversation by clicking on delete button

 @Smoke @Sanity @organization_management @Organization_TC_01 @TC_138 @70919
 Scenario: Verify whether  user can validate the presence of below components in
 organization profile page
 Edit Icon
 Delete icon
 Organization name with information icon
 Organization code  with information icon
  Given user login to the application
  When user click on organization management submodule
  Then User entered inside organization profile home page


 @Smoke @Sanity @organization_management @Organization_TC_02 @TC_139 @70919
 Scenario: Verify whether user cannot update the name with more than 200 characters
  Given user login to the application
  When user click on organization management submodule
  Then User is trying to update the name field by entering more than 200 characters

 @Smoke @Sanity @organization_management_004 @TC_04 @Organization_TC_003 @TC_140 @70919
 Scenario: Verify whether user can update the organization profile
  Given user login to the application
  When user click on organization management submodule
  Then user Edit the organization profile and saving the details
  Then User validate all the mentioned country list in Edit organization
  Then User upload the organization profile image successfully

 @Smoke @Sanity @organization_management @TC_04 @Organization_TC_003 @TC_141 @70919
 Scenario: Verify whether  user cannot update the profile photo when the size is more than 3 MB
  Given user login to the application
  When user click on organization management submodule
  Then user can update the profile photo which is more than 3MB size

 @Smoke @Sanity @organization_management @TC_04 @Organization_TC_04 @TC_142 @70919
 Scenario: Verify whether user can cancel the update functionality
  Given user login to the application
  When user click on organization management submodule
  Then user Edit the organization profile and saving the details
  Then User validate all the mentioned country list in Edit organization
  Then User click on cancel button and redirecting to organization profile page


 @Smoke @Sanity @organization_management @TC_05 @Organization_TC_05 @TC_143 @70919
 Scenario: Verify whether user cannot delete the organization if  any persons or devices are already exists
  Given user login to the application
  When user click on organization management submodule
  Then User trying to delete the organization permanently by having atleast one employee

 @Smoke @Sanity @organization_management @TC_05 @Organization_TC_06 @TC_144 @70919
 Scenario: Verify whether user can cancel the organization delete functionality
  Given user login to the application with new credentials
  When user click on organization management submodule
  Then User entered inside organization profile home page
  Then User trying to cancel the delete organization operation

 @Smoke @Sanity @organization_management @TC_04 @Organization_TC_07  @TC_145 @70919
 Scenario:Verify whether user can delete the account permanently if no persons and no devices are available
  Given user login to the application with valid credentials
  When user click on organization management submodule
  Then User entered inside organization profile home page
  When user click on organization management submodule
  Then User trying to delete the organization permanently

 @Smoke @Sanity @organization_management @TC_03 @Organization_TC_03 @Negative @70919
 Scenario:Verify whether user is not able to edit the organization profile without passing only organization name it should through some error message
  Given user login to the application
  When user click on organization management submodule
  Then User entered inside organization profile home page
  Then User is trying to edit profile by leaving Mandatory field


          @Smoke @Sanity @organization_management @TC_05 @Organization_TC_05
            Scenario: Verify whether  user is getting warning window before  deleting   the organization clicking on delete icon
            Given  user login to the application
            When user click on organization management submodule
            Then User entered inside organization profile home page
            Then User is trying to delete the organization

 @Organization_management @TC_06 @Organization_TC_006 @Negative @70919
 Scenario: Verify whether  user is  not able to edit the organization profile without selecting any data in the country field dropdown
  Given  user login to the application
  When user click on organization management submodule
#              Then User enters the invalid country name and trying to save the details
  Then User selects the country from the dropdown and save the organization details

 @Organization_management @TC_07 @Organization_TC_007 @Negative @70919
 Scenario: Verify whether user is  able to update the profile photo is less then 3 mb
  Given  user login to the application
  When user click on organization management submodule
  Then User upload the organization profile image successfully

 @Organization_management @TC_08 @Organization_TC_008  @Negative @70919
 Scenario: Verify user is able to see all the mentioned countries in Edit Organization page
  Given  user login to the application
  When user click on organization management submodule
  Then User validate all the mentioned country list in Edit organization


 @smoke @sanity @TC_327  @View_Attendance_01 @Attendance @View_Attendance @70919
 Scenario: Verify whether user can validate the presence of below components
 1.Person Name column
 2.Person ID column
 3.Punch Date column
 4.Attendance record column
 5.Show mended records toggle button
 6.Upload transactions icon
 7.Usage Tips info icon
 8.Refresh icon
 9.Search field
 10.View Attendance Punch Label
 11.Page size dropdown
 12.Forward page navigation icon
 13.Previous page navigation icon
  Given user login to the application
  Given when Admin click on Attendance module
  And Selected View Attendance punch
  Then user should validate the all the components inside View Attendance punch

 @smoke @sanity @TC_328 @View_Attendance_02 @View_Attendance @70919
 Scenario: Verify whether user can view Mended Attendance Punch records by enabling the Mended Attendance Punch icon
  Given user login to the application
  Given when Admin click on Attendance module
  And Selected View Attendance punch
  Then User should view the mend punches by enabling mend attendance

 @smoke @sanity @TC_329 @View_Attendance_03 @Attendance @View_Attendance @70919
 Scenario: Verify whether user can sort the records in ascending or descending record
 by using person name, person Id, Attendance record,Time Zone and Source
  Given user login to the application
  Given when Admin click on Attendance module
  And Selected View Attendance punch
  Then User will perform the sort operation using person name,person id,Attendance record,Time Zone and Source

 @smoke @sanity @TC_330 @View_Attendance_04 @Attendance @View_Attendance @70919
 Scenario: Verify whether user can filter the record by using punch date sort button or
 by using punch date filter operation
  Given user login to the application
  Given when Admin click on Attendance module
  And Selected View Attendance punch
  Then User should filter the records based on punch date

 @smoke @sanity @TC_331 @View_Attendance_05 @Attendance @View_Attendance @70919
 Scenario: Verify whether user can filter the attendance punches based on person id
 or Person name
 by using punch date filter operation
  Given user login to the application
  Given when Admin click on Attendance module
  And Selected View Attendance punch
  Then user filter the record using person name and id fields

 @smoke @sanity @TC_332 @View_Attendance_06 @Attendance @View_Attendance @70919
 Scenario: Verify whether user can glance the information by clicking on Usage Tips
  Given user login to the application
  Given when Admin click on Attendance module
  And Selected View Attendance punch
  Then User should able to glance the the information in the usage Tips

 @smoke @sanity @TC_333 @View_Attendance_07 @Attendance @View_Attendance @70919
 Scenario: Verify whether user can download the Attendance records in XLSX and CSV formats
  Given user login to the application
  Given when Admin click on Attendance module
  And Selected View Attendance punch
  Then user should be able to export the records in CSV and Excel format


 @smoke @sanity @TC_334 @View_Attendance_08 @Attendance @View_Attendance @70919
 Scenario: Verify Whether user can Upload Transactions by selecting the date range( user upload device attendance records? Only upload online devices)
  Given user login to the application
  Given when Admin click on Attendance module
  And Selected View Attendance punch
  Then user upload the transcations from the given input date

 @smoke @sanity @TC_335 @View_Attendance_09 @Attendance @View_Attendance @70919
 Scenario: Verify whether  user can refresh the page and see the records listed properly.
  Given user login to the application
  Given when Admin click on Attendance module
  And Selected View Attendance punch
  Then User will refresh the page and records should listed properly

 @smoke @sanity @TC_336 @View_Attendance_10 @Attendance @View_Attendance @70919
 Scenario: Verify whether user can change the number of records displayed per page by selecting 10, 20, or 50
  Given user login to the application
  Given when Admin click on Attendance module
  And Selected View Attendance punch
  Then user should list the records by selecting Ten twenty and Fifty per page

 @smoke @sanity @TC_337 @View_Attendance_11 @Attendance @View_Attendance @70919
 Scenario: Verify whether the user can navigate to the next and previous pages using the navigation icons
  Given user login to the application
  Given when Admin click on Attendance module
  And Selected View Attendance punch
  Then user should navigate to next and previous page

 @smoke @sanity @TC_338 @Mend_Attendance_01 @Attendance @Mend_Attendance @70919
 Scenario: Verify mend Attendance Punch page is displayed along with below components when user clicked on mend attendance module
 Mend Attendance page-Header
 Search icon, Add icon, Refresh icon
 and below columns
 person Name
 Person ID
 Punch Date
 Attendance record
 TimeZone
 Source
 Action
  Given user login to the application
  Given when Admin click on Attendance module
  When user select the Mend Attendance punch
  Then User should validate the presence of all components in that page

 @smoke @sanity @TC_339 @Mend_Attendance_02 @Attendance @Mend_Attendance @70919
 Scenario: Verify whether user can filter the records through Person ID/ Person Name
  Given user login to the application
  Given when Admin click on Attendance module
  When user select the Mend Attendance punch
  Then user filter the record using person name and id fields

 @smoke @sanity @TC_340 @Mend_Attendance_03 @Attendance @Mend_Attendance @70919
 Scenario: Verify whether error message is getting displayed of not when user is clicking on confirm button without providing any data in -
 1.Select user
 2.Set mend att-punch date
 3.Set mend att-punch Time
  Given user login to the application
  Given when Admin click on Attendance module
  When user select the Mend Attendance punch
  Then user should validate the Add mend attendance page


 @smoke @sanity @TC_341 @Mend_Attendance_04 @Attendance @Mend_Attendance @70919
 Scenario: Verify whether user can search and select employee on Add attendance mend page
  Given user login to the application
  Given when Admin click on Attendance module
  When user select the Mend Attendance punch
  Then User should successfully add person to the mend punch

 @smoke @sanity @TC_342 @Mend_Attendance_05 @Attendance @Mend_Attendance @70919
 Scenario: verify whether user can create Mend punch for single Employee
  Given user login to the application
  Given when Admin click on Attendance module
  When user select the Mend Attendance punch
  Then user should add the mend attendance successfully

 @smoke @sanity @TC_343 @Mend_Attendance_06 @Attendance @Mend_Attendance @70919
 Scenario: Verify whether user can cancel the mend attendance punch
  Given user login to the application
  Given when Admin click on Attendance module
  When user select the Mend Attendance punch
  Then User should able to cancel the add functionality

 @smoke @sanity @TC_344 @Mend_Attendance_07 @Attendance @Mend_Attendance @70919
 Scenario: Verify whether user can refresh the page
  Given user login to the application
  Given when Admin click on Attendance module
  When user select the Mend Attendance punch
  Then User should refresh the Mend attendance page and record should listed properly


 @smoke @sanity @TC_345 @Mend_Attendance_08 @Attendance @Mend_Attendance @70919
 Scenario: Verify whether user can update mend attendance punch
  Given user login to the application
  Given when Admin click on Attendance module
  When user select the Mend Attendance punch
  Then user can update the mend record punch

 @smoke @sanity @TC_346 @Mend_Attendance_09 @Attendance @Mend_Attendance @70919
 Scenario: Verify whether user can cancel the update mend attendance functionality
  Given user login to the application
  Given when Admin click on Attendance module
  When user select the Mend Attendance punch
  Then User can cancel the update functionality

 @smoke @sanity @TC_347 @Mend_Attendance_10 @Attendance @Mend_Attendance @70919
 Scenario: Verify whether user can delete mend attendance punch
  Given user login to the application
  Given when Admin click on Attendance module
  When user select the Mend Attendance punch
  Then user can delete the mend attendance punch

 @smoke @sanity @TC_348 @Mend_Attendance_11 @Attendance @Mend_Attendance @70919
 Scenario:Verify whether user can cancel the delete mend attendance punch
  Given user login to the application
  Given when Admin click on Attendance module
  When user select the Mend Attendance punch
  Then User can cancel the delete operation

 @smoke @sanity @TC_349 @Mend_Attendance_12 @Attendance @Mend_Attendance @70919
 Scenario: verify whether user can sort the records by using
 person name, person ID,Attendance record,Time zone,Source and action
  Given user login to the application
  Given when Admin click on Attendance module
  When user select the Mend Attendance punch
  Then User can sort the record by using Mend record headers

 @smoke @sanity @TC_350 @Mend_Attendance_13 @Attendance @Mend_Attendance @70919
 Scenario: Verify whether user can filter the records by using punch date
  Given user login to the application
  Given when Admin click on Attendance module
  When user select the Mend Attendance punch
  Then User should filter the records based on punch date

 @smoke @sanity @TC_351 @Mend_Attendance_14 @Attendance @Mend_Attendance @70919
 Scenario: Verify whether user can set the pagination as 10,20,50 per page
  Given user login to the application
  Given when Admin click on Attendance module
  When user select the Mend Attendance punch
  Then user should list the records by selecting Ten twenty and Fifty per page

 @smoke @sanity @TC_352 @Mend_Attendance_15 @Attendance @Mend_Attendance @70919
 Scenario: Verify whether user can navigate to forward and backward
  Given user login to the application
  Given when Admin click on Attendance module
  When user select the Mend Attendance punch
  Then user should to next page and the previous page

 @Time_Card_management_TC_01 @TC_353 @smoke @sanity @TimeCard_management @70919
 Scenario: Verify whether user can validate the presence of below components in  Timecard Management page
 Timecard management -header
 From date-calender
 To date-calender
 Usage Tips
 Export, download and refresh icon
 and headers include
 1.Person Name
 2.PersonID
 3.Date
 4.Timesheet
 5.Clock In
 6.Clock out
 7.Clock Time
 8.Total Work Time(h)
 9.Total Break Time(h)
 10.Total Work Time(h)
 11.Total Time(h)
 12.Statistic Rule Mode
  Given user login to the application
  Given when Admin click on Attendance module
  When User selects Time card management submodule
  Then  User should validate all the components in Time card management page

 @Time_Card_management_TC_02 @TC_354 @smoke @sanity @TimeCard_management @70919
 Scenario: Verify user can view all  Timecard Report done by employees in device as well as manual updated punches .
  Given user login to the application
  Given when Admin click on Attendance module
  When User selects Time card management submodule
  Then User should view all the punches done for the current month

 @Time_Card_management_TC_03 @TC_355 @smoke @sanity @TimeCard_management @70919
 Scenario: Verify whether user can view abnormal records by selecting abnormal records only
  Given user login to the application
  Given when Admin click on Attendance module
  When User selects Time card management submodule
  Then User should view the abnormal reports by selecting abnormal records button

 @Time_Card_management_TC_04 @TC_356 @smoke @sanity @TimeCard_management @70919
 Scenario: Verify user can filter the  person id,person name and timesheet.
  Given user login to the application
  Given when Admin click on Attendance module
  When User selects Time card management submodule
  Then User should able to filter the records using person name and timesheet

#    Calender code need to be done TC_05 @TC_372
 @Time_Card_management_TC_05 @TC_357 @smoke @sanity @TimeCard_management @70919
 Scenario: Verify user can filter  the Timecard management records  by using calendar.
  Given user login to the application
  Given when Admin click on Attendance module
  When User selects Time card management submodule
  Then User should filter the records based on the selected date from the calender

 @Time_Card_management_TC_06 @TC_358 @smoke @sanity @TimeCard_management @70919
 Scenario: Verify user can  View Usage Tips  click on usage tips icon in Timecard management page
  Given user login to the application
  Given when Admin click on Attendance module
  When User selects Time card management submodule
  Then User can view the usage tips in Timecard_management

 @Time_Card_management_TC_07 @TC_359 @smoke @sanity @TimeCard_management @70919
 Scenario: Verify user can  Export time card management by selecting from and to date
  Given user login to the application
  Given when Admin click on Attendance module
  When User selects Time card management submodule
  Then User can export the records by selecting from and Todate

 @Time_Card_management_TC_08 @TC_360 @smoke @sanity @TimeCard_management @70919
 Scenario: Verify whether user can enable the automatic report sending
  Given user login to the application
  Given when Admin click on Attendance module
  When User selects Time card management submodule
  Then User can enable and send automatic report sending


 @Time_Card_management_TC_09 @TC_361 @smoke @sanity @TimeCard_management @70919
 Scenario: Verify whether user can export daily, Weekly or monthly wise
  Given user login to the application
  Given when Admin click on Attendance module
  When User selects Time card management submodule
  Then User can export report sending in daily weekly or monthly wise

 @Time_Card_management_TC_10 @TC_362 @smoke @sanity @TimeCard_management @70919
 Scenario: Verify user can export the record by disabling the record with time zone
  Given user login to the application
  Given when Admin click on Attendance module
  When User selects Time card management submodule
  Then User can export the record by disabling timeZone

 @Time_Card_management_TC_11 @TC_363 @smoke @sanity @TimeCard_management @70919
 Scenario: Verify user can able to Download the report by using XlSX or CSV format
  Given user login to the application
  Given when Admin click on Attendance module
  When User selects Time card management submodule
  Then user can download the report by using XLSX or CSV format

 @Time_Card_management_TC_12 @TC_364 @smoke @sanity @TimeCard_management @70919
 Scenario: Verify user can refresh the page and records will listed properly
  Given user login to the application
  Given when Admin click on Attendance module
  When User selects Time card management submodule
  Then user can Refresh the page and records should get listed properly

 @Time_Card_management_TC_13 @TC_365 @smoke @sanity @TimeCard_management @70919
 Scenario: Verify whether user can set the pagination as 10,20,50 per page
  Given user login to the application
  Given when Admin click on Attendance module
  When User selects Time card management submodule
  Then user should list the records by selecting Ten twenty and Fifty per pages

#-------------------------TimesheetCode-----------------------
 @TC_Attendance_Timesheet_280  @Attendance_TimeSheet @Quickstart @Sanity @Smoke @70919
 Scenario: Verify whether Timesheet page contains below elements:
 1.Timesheet Name, Unit,Cycle,Description and Operation columns
 2.Add ,Refresh icon and search field
  Given user login to the application
  Given when Admin click on Attendance module
  When user navigates to Timesheet submodule page
  Then user should validate the timesheet page

 @TC_Attendance_Timesheet_281  @Attendance_TimeSheet @Sanity @Smoke @70919
 Scenario: Verify whether user is able  to add a normal Timesheet by providing all the below details
 1.Number of Repetation
 2.Day,
 3.Check-in start and Check-in,
 4.Check-out and Check-out end,
 5.Workday type
  Given user login to the application
  Given when Admin click on Attendance module
  When user navigates to Timesheet submodule page
  Then user click on add timesheet module
  And the user enters valid data in the Add timesheet
  And the user enter click on confirm button.
  Then user validate the success message

 @TC_Attendance_Timesheet_282  @Attendance_TimeSheet @Sanity @Smoke @70919
 Scenario: Verify whether user is able to add Flexible Timesheet by providing below details:
 1.Number of repetitions,
 2.Day,
 3.Max Work hours,
 4.Workday type
  Given user login to the application
  Given when Admin click on Attendance module
  When user navigates to Timesheet submodule page
  Then user click on add timesheet module
  And the user enters valid data in the Add timesheet and create the flexible timesheet
  And the user enter click on confirm button.
  Then user should validate the timesheet page
  Then user validate the success message

#  @71061 @TC_Attendance_Timesheet_283 @Attendance_TimeSheet  @Quickstart @Sanity @Smoke
#  Scenario: Verify whether user able to view the created timesheet .
#    Given user login to the application
#    Given when Admin click on Attendance module
#    And user click on timesheet module
#    And the user clicks on the View icon for a timesheet
#    Then the user should be able to see the created timesheet details


 @TC_292 @Attendance_TimeSheet @smoke @sanity @Timesheet @70919
 Scenario: Verify whether user able to view the created timesheet
  Given user login to the application
  Given when Admin click on Attendance module
  When user navigates to Timesheet submodule page
  Then User Should view the recently created record

 @TC_293 @Attendance_TimeSheet @smoke @sanity @Timesheet @70919
 Scenario: Verify whether user able to edit the created timesheet
  Given user login to the application
  Given when Admin click on Attendance module
  When user navigates to Timesheet submodule page
  Then User should update the recently created timesheet


 @TC_294 @TC_295  @Attendance_TimeSheet @smoke @sanity @Timesheet @70919
 Scenario: Verify whether user able to delete the created timesheet
  Given user login to the application
  Given when Admin click on Attendance module
  When user navigates to Timesheet submodule page
  Then User should delete the Timesheet Successfully

 @TC_296  @Attendance_TimeSheet @smoke @sanity @Timesheet @70919
 Scenario: Verify whether user is not able to delete the  scheduled timesheet
  Given user login to the application
  Given when Admin click on Attendance module
  When user navigates to Timesheet submodule page
  Then User should cancel the timesheet delete operation


 @TC_297 @TC_298 @Attendance_TimeSheet @smoke @sanity @Timesheet @70919
 Scenario: Verify whether user is able to search the  timesheet from the list
  Given user login to the application
  Given when Admin click on Attendance module
  When user navigates to Timesheet submodule page
  Then User should search by timesheet name

 @TC_299 @Attendance_TimeSheet @smoke @sanity @Timesheet @70919
 Scenario: Verify Normal/Flexible timsheet creation is not successfull without providing the required fields- (Timesheet name)
  Given user login to the application
  Given when Admin click on Attendance module
  When user navigates to Timesheet submodule page
  Then User should not create Timesheet by leaving mandatory field

 @TC_300 @Attendance_TimeSheet @smoke @sanity @Timesheet @70919
 Scenario: Verify Normal timsheet creation is not successful when break-in time is either outside the check-in start and check-out end range or between check in start and check in or check-out and check-out-end
  Given user login to the application
  Given when Admin click on Attendance module
  When user navigates to Timesheet submodule page
  Then User unable to create timesheet if breakTime is Eighter outside the checkIn or Checkout Range


 @TC_301 @TC_302 @TC_303 @Attendance_TimeSheet @smoke @sanity @Timesheet @70919
 Scenario: Verify user is able to navigate to next page by clicking on next button
  Given user login to the application
  Given when Admin click on Attendance module
  When user navigates to Timesheet submodule page
  Then User can navigate to next page by clicking on next page by selecting Ten twenty and fifty


 @TC_304 @Shift_Schedule @Attendance @smoke @Sanity @70919
 Scenario: Verify whether user can validate the presence of below components
 Add icon
 Delete icon
 Refresh icon
 Search field
 Shift schedule Page label
 Sync Person Icon
 Name column
 Person ID column
 Department column
 Timesheet column
 Start Date column
 End Date column
 Action column
 Next Page navigation icon
 Previous page navigation icon
 Page size dropdown
  Given user login to the application
  Given when Admin click on Attendance module
  When User navigates to Shift schedule sub module
  Then User should validate the presence of all components in Shift shedule page


 @TC_305 @Shift_Schedule @Attendance @smoke @Sanity @70919
 Scenario: Verify whether user will get a warning message by leaving any mandatory field
  Given user login to the application
  Given when Admin click on Attendance module
  When User navigates to Shift schedule sub module
  Then User is trying to add a shift schedule by leaving mandatory fields


 @TC_306 @Shift_Schedule @Attendance @smoke @Sanity @70919
 Scenario: Verify user can create shift schedule with valid timesheet and person.
  Given user login to the application
  Given when Admin click on Attendance module
  When User navigates to Shift schedule sub module
  Then user can create shift schedule with valid timesheet and person





    
    
    
    
    
    
    
    
    
    
    