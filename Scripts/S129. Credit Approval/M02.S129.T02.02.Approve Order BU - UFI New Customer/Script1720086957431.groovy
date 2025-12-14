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
import com.kms.katalon.core.util.KeywordUtil

TestData excelData = findTestData('Data Files/Submit UFI/Approve Order BU - UFI')

String subMenuFirst = 'Receive Order'
String thirdMenuFirst = 'Order Tracking'

String subMenu = 'Credit Approval'
String thirdMenu = 'Branch Approval'

for(int i = 1; i <= excelData.getRowNumbers(); i++) {
	
	String username = excelData.getValue('Username' , i)
	String password = excelData.getValue('Password' , i)
	String parentMenu = excelData.getValue('ParentMenu' , i)
	String remark = excelData.getValue('Remark' , i)
	//Approval
	String statusApproval = excelData.getValue('Status Approval' , i)
	String reason  = excelData.getValue('Reason' , i)
	String isContractSigned = excelData.getValue('Is Contract Signed' , i)
	String comment = excelData.getValue('Comment' , i)
	String commentPo = excelData.getValue('Comment PO Pending' , i)
	
	//Login into web
	CustomKeywords.'id.co.fifgroup.fifcore.loginFifcore.loginIntoWeb'(GlobalVariable.url, username, password)
	
	CustomKeywords.'id.co.fifgroup.fifcore.utilities.chooseMenuAndSubMenu'(parentMenu, subMenuFirst, thirdMenuFirst)
	
	CustomKeywords.'id.co.fifgroup.fifcore.approveOrder.inquiryOrder'(GlobalVariable.teksOrder)
	
	CustomKeywords.'id.co.fifgroup.fifcore.utilities.logoutFromWeb'()
	
	CustomKeywords.'id.co.fifgroup.fifcore.loginFifcore.login'(GlobalVariable.LoginApproverFirst, password)
	
	CustomKeywords.'id.co.fifgroup.fifcore.approveOrder.approvalFirst'(GlobalVariable.teksOrder, remark)
	
	String savingFolder1 = 'Credit Approval/'
	CustomKeywords.'id.co.fifgroup.fifcore.utilities.takeScreenCapture'(savingFolder1, GlobalVariable.teksOrder)
	WebUI.closeBrowser()
	
	CustomKeywords.'id.co.fifgroup.fifcore.loginFifcore.login'(GlobalVariable.LoginApproverSecond, password)
	
	//new is upper
	CustomKeywords.'id.co.fifgroup.fifcore.approveOrder.approveOrderUFI'(GlobalVariable.teksOrder)
	
	String savingFolder2 = 'Credit Approval/'
	CustomKeywords.'id.co.fifgroup.fifcore.utilities.takeScreenCapture'(savingFolder1, GlobalVariable.teksOrder)
	
	CustomKeywords.'id.co.fifgroup.fifcore.approveOrder.popUpOk'()
	
	CustomKeywords.'id.co.fifgroup.fifcore.approveOrder.approvalDecison'(statusApproval, reason, isContractSigned, comment)
	
	CustomKeywords.'id.co.fifgroup.fifcore.approveOrder.submitPoPending'(commentPo)
	
	String savingFolder3 = 'PO Pending Detail/'
	CustomKeywords.'id.co.fifgroup.fifcore.utilities.takeScreenCapture'(savingFolder3, GlobalVariable.teksOrder)
	
	String savingFolder4 = 'Approval Detail/'
	CustomKeywords.'id.co.fifgroup.fifcore.utilities.takeScreenCapture'(savingFolder4, GlobalVariable.teksOrder)
	
	WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Approve Order Test Object/19_btnSubmit'))
	WebUI.delay(3)
	
	//Is Doc Complete?
	boolean isPass = WebUI.verifyElementText(findTestObject('Object Repository/FIFCORE Test Object/Approve Order Test Object/27_dlgAfterSubmit'), 'Document checklist belum lengkap')
	//String isDocCehkComplete = WebUI.getText(findTestObject('Object Repository/FIFCORE Test Object/Approve Order Test Object/27_dlgAfterSubmit'))
	
	if(isPass) {
		KeywordUtil.markError("Order ${GlobalVariable.teksOrder} mempunyai error validasi, silahkan cek kembali")
	} else {
		KeywordUtil.logInfo('PASSED')
	}
	
	String savingFolder5 = 'PO Number Generate/'
	CustomKeywords.'id.co.fifgroup.fifcore.utilities.takeScreenCapture'(savingFolder5, GlobalVariable.teksOrder)
	
	String poNumber = WebUI.getText(findTestObject('Object Repository/FIFCORE Test Object/Approve Order Test Object/25_lblPOGenerate')).replaceAll("[^0-9.]", "")
	
	KeywordUtil.logInfo('PO Number '+poNumber)
	
	WebUI.sendKeys(null, Keys.chord(Keys.ENTER))
	
	WebUI.delay(3)
	
	//CustomKeywords.'id.co.fifgroup.fifcore.utilities.logoutFromWeb'()
	
	

	}
	
	//CustomKeywords.'id.co.fifgroup.fifcore.utilities.closeBrowser'()