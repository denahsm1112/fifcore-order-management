package id.co.fifgroup.fifcore

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import org.openqa.selenium.Keys as Keys
import internal.GlobalVariable
import com.kms.katalon.core.configuration.RunConfiguration

public class approveOrder {

	@Keyword
	def inquiryOrder(String orderNumber) {
		//WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Test Object/38_chkWithHieracy'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Test Object/02_chkWithHierarcy'))
		//WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/08_fldOrderNumber'), orderNumber)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/01_fldOrderNumber'), orderNumber)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/02_btnFind'))
		//WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/09_btnFind'))
		WebUI.scrollToElement(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Test Object/26_btnInProgress'), 2)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Test Object/26_btnInProgress'))
		String loginApproverFirst = WebUI.getText(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Test Object/27_fldLogin'), FailureHandling.OPTIONAL)
		String loginApproverSecond = WebUI.getText(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/20_lblTextApprovalThird'), FailureHandling.OPTIONAL)
		//		String loginApproverThird = WebUI.getText(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/20_lblTextApprovalThird'), FailureHandling.OPTIONAL)
		//		String loginCreditApprovalForth = WebUI.getText(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/22_btnSecondCreditApproval'), FailureHandling.OPTIONAL)
		//Store to Global Scope
		GlobalVariable.LoginApproverFirst = loginApproverFirst
		GlobalVariable.LoginApproverSecond = loginApproverSecond
		//		GlobalVariable.LoginApproveThird = loginApproverThird
		//		GlobalVariable.LoginCreditApprovalForth = loginCreditApprovalForth
		KeywordUtil.logInfo('Login Exception Approval '+GlobalVariable.LoginApproverFirst)
		KeywordUtil.logInfo('Login Exception Approval '+GlobalVariable.LoginApproverSecond)
		KeywordUtil.logInfo('Login Credit Approval '+GlobalVariable.LoginApproveThird)
		KeywordUtil.logInfo('Login Credit Approval '+GlobalVariable.LoginCreditApprovalForth)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Test Object/28_btnCancel'))
	}

	@Keyword
	def approvalFirst(String nomorOrder,String remark) {
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Test Object/29_btnException'))
		boolean noOrderPresent = WebUI.verifyElementPresent(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Test Object/31_btnNomorOrder',[('nomorOrder') : nomorOrder]), 0, FailureHandling.OPTIONAL)
		if(noOrderPresent) {
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Test Object/31_btnNomorOrder', [('nomorOrder') : nomorOrder]))
			WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Test Object/32_fldRemark'), remark)
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Test Object/33_btnApprove'))
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Test Object/34_btnOK'))
			WebUI.delay(5)
			WebUI.closeBrowser()
		}else {
			println('Continue')
			WebUI.closeBrowser()
		}
		//end
	}

	@Keyword
	def approveOrderMPF(String orderNumber) {
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Approve Order Test Object/01_fldOrderNumber'), orderNumber)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Approve Order Test Object/02_btnFind'))
		WebUI.check(findTestObject('Object Repository/FIFCORE Test Object/Approve Order Test Object/03_rbFirstData'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Approve Order Test Object/04_btnDetail'))
		WebUI.delay(3)
	}

	@Keyword
	def approveOrderUFI(String orderNumber, String branch) {
		//		if(RunConfiguration.getExecutionProfile()=='UAT') {
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Performance Test Purpose Test Object/03_btnBranch'))
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Performance Test Purpose Test Object/04_fldBranchID'), branch)
		//		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Performance Test Purpose Test Object/19_fldBranchName'), branch)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/01_btnFind'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Performance Test Purpose Test Object/05_lblFirstResult'))
		//		}
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Approve Order Test Object/01_fldOrderNumber'), orderNumber)
		//		if(RunConfiguration.getExecutionProfile()=='TEST') {

		WebUI.check(findTestObject('Object Repository/FIFCORE Test Object/Approve Order Test Object/26_chkWithHierarchy'), FailureHandling.OPTIONAL)
		//		}
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Approve Order Test Object/02_btnFind'))
		WebUI.check(findTestObject('Object Repository/FIFCORE Test Object/Approve Order Test Object/03_rbFirstData'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Approve Order Test Object/04_btnDetail'))
		WebUI.delay(3)
	}

	@Keyword
	def popUpOk() {
		WebUI.delay(3)
		WebUI.scrollToElement(findTestObject('Object Repository/FIFCORE Test Object/Approve Order Test Object/20_btnOk'), 2, FailureHandling.OPTIONAL)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Approve Order Test Object/20_btnOk'), FailureHandling.OPTIONAL)
	}

	@Keyword
	def saveOkOrder() {
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Approve Order Test Object/06_btnSave'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Approve Order Test Object/07_btnYes'))
		WebUI.sendKeys(null, Keys.chord(Keys.ENTER))
		//WebUI.sendKeys(null, Keys.chord(Keys.TAB))
	}

	@Keyword
	def cancelPopUp() {
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Approve Order Test Object/08_btnCancel'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Approve Order Test Object/07_btnYes'))
		WebUI.check(findTestObject('Object Repository/FIFCORE Test Object/Approve Order Test Object/03_rbFirstData'))
	}

	@Keyword
	def approvalDecison(String statusApproval, String reason, String isContractSigned, String comment) {
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Approve Order Test Object/09_btnApprovalDecision'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Approve Order Test Object/10_rbApproveDecision', [('statusApproval') : statusApproval]))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Approve Order Test Object/11_btnReason'))
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Approve Order Test Object/12_taReasonDescription'), reason)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Approve Order Test Object/15_btnFind'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Approve Order Test Object/13_btnReasonDescription'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Approve Order Test Object/14_btnSubReason'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Approve Order Test Object/15_btnFind'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Approve Order Test Object/13_btnReasonDescription'))
		if(isContractSigned == 'Ceklis') {
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Approve Order Test Object/16_btnIsContractSigned'))
		} else {
			KeywordUtil.logInfo('Is Conctract Signed Not Ceklis')
		}
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Approve Order Test Object/17_taComment'), comment)
		if(statusApproval=='Approve') {
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Approve Order Test Object/18_btnPOPendingReason'))
		} else {
			KeywordUtil.logInfo("Status Approval = ${statusApproval}")
		}

		//WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Approve Order Test Object/19_btnSubmit'))
	}

	@Keyword
	def getNoPO() {

		String po = WebUI.getText(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/30_lblGetNoPO')).replaceAll('[^0-9.]', '')
		GlobalVariable.noPO = po
		KeywordUtil.logInfo(po)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/17_btnOkIndex1'), FailureHandling.OPTIONAL)
	}
	@Keyword
	def submitPoPending(String commentPoPending) {
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Approve Order Test Object/23_btnDetailPOPending'))
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Approve Order Test Object/21_taCommentPOpending'), commentPoPending)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Performance Test Purpose Test Object/06_btnOKPO'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Approve Order Test Object/24_btnOkPOPending'))
	}

	@Keyword
	def approvalThird(String nomorOrder, String statusApproval, String reason, String comment) {
		if(RunConfiguration.getExecutionProfile()=='TEST') {
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/09_approval/04_chkHierarchy'))
		}

		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/09_approval/05_fldOrderNumber'), nomorOrder)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/09_approval/06_btnFind'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/09_approval/01_btnDetail', [('nomorOrder') : nomorOrder]))
		WebUI.delay(3)
		WebUI.scrollToElement(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Test Object/11_btnOk'), 2, FailureHandling.OPTIONAL)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Test Object/11_btnOk'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/09_approval/02_btnApprovalDecision'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Approve Order Test Object/10_rbApproveDecision', [('statusApproval') : statusApproval]))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Approve Order Test Object/11_btnReason'))
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Approve Order Test Object/12_taReasonDescription'), reason)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Approve Order Test Object/15_btnFind'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Approve Order Test Object/13_btnReasonDescription'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Approve Order Test Object/14_btnSubReason'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Approve Order Test Object/15_btnFind'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Approve Order Test Object/13_btnReasonDescription'))
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Approve Order Test Object/17_taComment'), comment)
		if(statusApproval=='Approve') {
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Approve Order Test Object/18_btnPOPendingReason'))
		} else {
			KeywordUtil.logInfo("Status Approval = ${statusApproval}")
		}
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Approve Order Test Object/23_btnDetailPOPending'))
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Approve Order Test Object/21_taCommentPOpending'), comment)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Approve Order Test Object/22_btnOkPOPending'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Approve Order Test Object/24_btnOkPOPending'))
		WebUI.waitForPageLoad(20)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/09_approval/12_chkContractSigned'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Approve Order Test Object/19_btnSubmit'))
		WebUI.waitForPageLoad(60)
		String teksPO = WebUI.getText(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/09_approval/13_lblGgetTextNoPo'))

		def pattern = /(?<=PO Number: )\d+PO\d+/
		def matcher = (teksPO =~ pattern)

		if (matcher.find()) {
			def nomorPO = matcher.group(0)
			println nomorPO
			GlobalVariable.teksPO = nomorPO
			KeywordUtil.logInfo('Nomor PO : ' + GlobalVariable.teksPO)
		} else {
			println "Nomor PO tidak ditemukan dalam teks."
		}

		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/11_btnOkInformation'))
		WebUI.delay(2)
		WebUI.closeBrowser()
	}
}
