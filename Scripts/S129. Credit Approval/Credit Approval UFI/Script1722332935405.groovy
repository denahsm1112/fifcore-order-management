import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import org.apache.commons.lang.RandomStringUtils as RandomStringUtils
import java.util.Random
import com.github.javafaker.Faker
import java.text.SimpleDateFormat
import org.apache.poi.ss.usermodel.*
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import java.io.FileOutputStream
import java.io.File
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

//Call Test Data Excel
TestData excelData2 = findTestData('Data Files/Submit UFI/Approve Order BU - UFI')
TestData excelData = findTestData('Data Files/Submit UFI/Submit New Initial Order - UFI')

for(int i = 1; i <= excelData2.getRowNumbers(); i++) {
	'Start Process'
	WS.comment('Start Process ke- ' +i)
	
	String username2 = excelData2.getValue('Username' , i)
	String password2 = excelData2.getValue('Password' , i)
	String parentMenu1 = excelData2.getValue('ParentMenu' , i)
	String remark = excelData2.getValue('Remark' , i)
	//Approval
	String statusApproval = excelData2.getValue('Status Approval' , i)
	String reason  = excelData2.getValue('Reason' , i)
	String isContractSigned = excelData2.getValue('Is Contract Signed' , i)
	String comment = excelData2.getValue('Comment' , i)
	String commentPo = excelData2.getValue('Comment PO Pending' , i)
	String subMenuFirst = 'Receive Order'
	String thirdMenuFirst = 'Order Tracking'
	String subMenu1 = 'Credit Approval'
	String thirdMenu1 = 'Branch Approval'
	
	//noOrderId
	String noOrder = excelData.getValue('OrderID', i)
	String branch2 = excelData.getValue('Branch', i)
	
	CustomKeywords.'id.co.fifgroup.fifcore.loginFifcore.loginIntoWeb'(GlobalVariable.url, username2, password2)
	CustomKeywords.'id.co.fifgroup.fifcore.utilities.chooseMenuAndSubMenu'(parentMenu1, subMenuFirst, thirdMenuFirst)
	CustomKeywords.'id.co.fifgroup.fifcore.approveOrder.inquiryOrder'(noOrder)
	
	WebUI.closeBrowser()
	if(GlobalVariable.LoginApproverFirst != null) {
		CustomKeywords.'id.co.fifgroup.fifcore.loginFifcore.loginIntoWeb'(GlobalVariable.url, GlobalVariable.LoginApproverFirst, password2)
		CustomKeywords.'id.co.fifgroup.fifcore.approveOrder.approvalFirst'(noOrder, remark)
	}
	
	//Login Into Web
	CustomKeywords.'id.co.fifgroup.fifcore.loginFifcore.loginIntoWeb'(GlobalVariable.url, GlobalVariable.LoginApproverSecond, password2)
	CustomKeywords.'id.co.fifgroup.fifcore.utilities.chooseMenuAndSubMenu'(parentMenu1, subMenu1, thirdMenu1)
	//new is upper
	CustomKeywords.'id.co.fifgroup.fifcore.approveOrder.approveOrderUFI'(noOrder, branch2)
	CustomKeywords.'id.co.fifgroup.fifcore.approveOrder.popUpOk'()
	CustomKeywords.'id.co.fifgroup.fifcore.approveOrder.approvalDecison'(statusApproval, reason, isContractSigned, comment)
	CustomKeywords.'id.co.fifgroup.fifcore.approveOrder.submitPoPending'(commentPo)
	
	//WebUI.callTestCase(findTestCase('Test Cases/Database Test/Document Checklist Query'), [('orderNumber') : noOrder], FailureHandling.STOP_ON_FAILURE)
	WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Approve Order Test Object/19_btnSubmit'))
	WebUI.delay(3)

	//CustomKeywords.'id.co.fifgroup.fifcore.utilities.logoutFromWeb'()
	//WebUI.closeBrowser()

	
	'End Process'
	WS.comment('End Process ke- '+i)
}
