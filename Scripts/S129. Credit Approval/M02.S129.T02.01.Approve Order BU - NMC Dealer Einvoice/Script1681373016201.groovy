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

TestData excelData = findTestData('Data Files/Approve UFI')

String subMenu = 'Credit Approval'
String thirdMenu = 'Branch Approval'

for(int i = 1; i <= excelData.getRowNumbers(); i++) {
	
	String username = excelData.getValue('Username' , i)
	String password = excelData.getValue('Password' , i)
	String parentMenu = excelData.getValue('ParentMenu' , i)
	String orderNumber = excelData.getValue('Order Number' , i)
	String branch = excelData.getValue('Branch', i)
	//Approval
	String statusApproval = excelData.getValue('Status Approval' , i)
	String reason  = excelData.getValue('Reason' , i)
	String isContractSigned = excelData.getValue('Is Contract Signed' , i)
	String comment = excelData.getValue('Comment' , i)
	String commentPo = excelData.getValue('Comment PO Pending' , i)
	
	CustomKeywords.'id.co.fifgroup.fifcore.loginFifcore.loginIntoWeb'(GlobalVariable.url, username, password)
	
	CustomKeywords.'id.co.fifgroup.fifcore.utilities.chooseMenuAndSubMenu'(parentMenu, subMenu, thirdMenu)
	
	CustomKeywords.'id.co.fifgroup.fifcore.approveOrder.approveOrderUFI'(orderNumber, branch)
	
	String savingFolder1 = 'Credit Approval/'
	
	CustomKeywords.'id.co.fifgroup.fifcore.utilities.takeScreenCapture'(savingFolder1, orderNumber)
	
	CustomKeywords.'id.co.fifgroup.fifcore.approveOrder.popUpOk'()
	
	CustomKeywords.'id.co.fifgroup.fifcore.approveOrder.approvalDecison'(statusApproval, reason, isContractSigned, comment)
	
	if(statusApproval=='Approve') {
	CustomKeywords.'id.co.fifgroup.fifcore.approveOrder.submitPoPending'(commentPo)
	}else {
		KeywordUtil.logInfo("Status Approval = ${statusApproval}")
	}
	
	String savingFolder3 = 'PO Pending Detail/'
	CustomKeywords.'id.co.fifgroup.fifcore.utilities.takeScreenCapture'(savingFolder3, orderNumber)
	
	String savingFolder4 = 'Approval Detail/'
	CustomKeywords.'id.co.fifgroup.fifcore.utilities.takeScreenCapture'(savingFolder4, orderNumber)
	
	WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Approve Order Test Object/19_btnSubmit'))
	WebUI.delay(3)
	
//	//Is Doc Complete?
//	boolean isPass = WebUI.verifyElementText(findTestObject('Object Repository/FIFCORE Test Object/Approve Order Test Object/27_dlgAfterSubmit'), 'Document checklist belum lengkap')
//	
//	if(isPass) {
//		KeywordUtil.markError("Order ${orderNumber} mempunyai error validasi, silahkan cek kembali")
//	} else {
//		KeywordUtil.logInfo('PASSED')
//	}
	
	WebUI.sendKeys(null, Keys.chord(Keys.ENTER), FailureHandling.OPTIONAL)
	
	String savingFolder5 = 'PO Number Generate/'
	CustomKeywords.'id.co.fifgroup.fifcore.utilities.takeScreenCapture'(savingFolder5, orderNumber)
	
	String poNumber = WebUI.getText(findTestObject('Object Repository/FIFCORE Test Object/Approve Order Test Object/25_lblPOGenerate'), FailureHandling.OPTIONAL)
	
	//poNumber.replaceAll("[^0-9.]", "")
	KeywordUtil.logInfo('PO Number '+poNumber)
	
	WebUI.sendKeys(null, Keys.chord(Keys.ENTER), FailureHandling.OPTIONAL)
	
	WebUI.delay(3)
	
	CustomKeywords.'id.co.fifgroup.fifcore.utilities.logoutFromWeb'()
	
	
	}
	
	CustomKeywords.'id.co.fifgroup.fifcore.utilities.closeBrowser'()