package id.co.fifgroup.fifcore
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.configuration.RunConfiguration

import internal.GlobalVariable

public class submitStrukturKredit {

	@Keyword
	def cekUserAppraisalUFI(String branch, String orderNumber, String ddlNavigation1) {
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Test Object/01_fldBranch'), branch)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Test Object/02_chkWithHierarcy'))
		//WebUI.waitForElementPresent(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/01_fldOrderNumber'), 5)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/01_fldOrderNumber'), orderNumber)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/02_btnFind'))
		GlobalVariable.CUSTOMER_NUMBER = WebUI.getText(findTestObject('Object Repository/FIFCORE Test Object/Performance Test Purpose Test Object/07_lblCustomerNumber'))
		WebUI.delay(3)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/03_rbVarOrderNumber', [('orderNumber') : orderNumber]))
		WebUI.delay(3)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/04_btnDdlNavigation'))
		WebUI.delay(3)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/05_cbDdlNavigation', [('ddlNavigation') : ddlNavigation1]))
		WebUI.delay(3)
		WebUI.scrollToElement(findTestObject('Object Repository/FIFCORE Test Object/Performance Test Purpose Test Object/18_btnCurrentProcessAPPRAISAL'), 2, FailureHandling.OPTIONAL)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Performance Test Purpose Test Object/18_btnCurrentProcessAPPRAISAL'))

		String textAppraisalTemporary = WebUI.getText(findTestObject('Object Repository/FIFCORE Test Object/Performance Test Purpose Test Object/01_lblGetTextTemporary'), FailureHandling.OPTIONAL)
		if(textAppraisalTemporary == 'TEMPORARY') {
			if(RunConfiguration.getExecutionProfile()=='TEST') {
				GlobalVariable.HOST_DB = '10.17.28.91'
			} else {
				GlobalVariable.HOST_DB = '10.17.28.212'
			}
			WebUI.callTestCase(findTestCase('Test Cases/Database Test/Update Temporary'), [('userLogin') : GlobalVariable.userLogin, ('orderNumber') : orderNumber], FailureHandling.STOP_ON_FAILURE)
		}

		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Performance Test Purpose Test Object/02_btnCloseDetailProcess'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Performance Test Purpose Test Object/18_btnCurrentProcessAPPRAISAL'))
		String textAppraisal = WebUI.getText(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Test Object/19_lblGetTextAppraisal'), FailureHandling.OPTIONAL)
		String textCreditStructure = WebUI.getText(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Test Object/20_lblGetTextCreditStructure'), FailureHandling.OPTIONAL)
		String textApproval = WebUI.getText(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Test Object/21_lblGetTextApproval'), FailureHandling.OPTIONAL)
		// Mencari indeks dari karakter '-'
		int indexOfDash1 = textAppraisal.indexOf('-');
		int indexOfDash2 = textCreditStructure.indexOf('-');
		int indexOfDash3 = textApproval.indexOf('-');
		// Mengambil substring dari indeks 0 hingga indeks sebelum karakter '-'
		String substring1 = textAppraisal.substring(0, indexOfDash1).trim();
		String substring2 = textCreditStructure.substring(0, indexOfDash2).trim();
		String substring3 = textApproval.substring(0, indexOfDash3).trim();
		// Menampilkan hasil
		GlobalVariable.appraisalUFI = substring1
		GlobalVariable.creditStructureUFI = substring2
		GlobalVariable.approvalUFI = substring3
		KeywordUtil.logInfo('Appraisal UFI: ' + GlobalVariable.appraisalUFI)
		KeywordUtil.logInfo('Credit Structure UFI: ' + GlobalVariable.creditStructureUFI)
		KeywordUtil.logInfo('Approval UFI: ' + GlobalVariable.approvalUFI)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Test Object/11_btnOk'))
	}

	@Keyword
	def cekUserProcessNMC (String branch, String orderNumber, String ddlNavigation1, String process) {
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Test Object/01_fldBranch'), branch)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Test Object/02_chkWithHierarcy'))
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/01_fldOrderNumber'), orderNumber)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/02_btnFind'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/03_rbVarOrderNumber', [('orderNumber') : orderNumber]))
		WebUI.delay(3)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/04_btnDdlNavigation'))
		WebUI.delay(3)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/05_cbDdlNavigation', [('ddlNavigation') : ddlNavigation1]))
		WebUI.scrollToElement(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Test Object/35_btnProcess', [('process') : process]), 0)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Test Object/35_btnProcess', [('process') : process]))

		String textCreditStructure = WebUI.getText(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Test Object/37_lblGetTextPICCreditStructure'), FailureHandling.OPTIONAL)
		String textApproval = WebUI.getText(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Test Object/36_lblGetTextPICApproval'), FailureHandling.OPTIONAL)
		// Mencari indeks dari karakter '-'
		int indexOfDash2 = textCreditStructure.indexOf('-');
		int indexOfDash3 = textApproval.indexOf('-');
		// Mengambil substring dari indeks 0 hingga indeks sebelum karakter '-'
		String substring2 = textCreditStructure.substring(0, indexOfDash2).trim();
		String substring3 = textApproval.substring(0, indexOfDash3).trim();
		// Menampilkan hasil
		GlobalVariable.creditStructureUFI = substring2
		GlobalVariable.approvalUFI = substring3
		KeywordUtil.logInfo('Credit Structure UFI: ' + GlobalVariable.creditStructureUFI)
		KeywordUtil.logInfo('Approval UFI: ' + GlobalVariable.approvalUFI)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Test Object/11_btnOk'))
	}

	@Keyword
	def appraisalKreditUFI(String branch, String orderNumber, String ddlNavigation1) {
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Test Object/01_fldBranch'), branch)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Test Object/02_chkWithHierarcy'))
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/01_fldOrderNumber'), orderNumber)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/02_btnFind'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/03_rbVarOrderNumber', [('orderNumber') : orderNumber]))
		WebUI.delay(3)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/04_btnDdlNavigation'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/05_cbDdlNavigation', [('ddlNavigation') : ddlNavigation1]))
		WebUI.scrollToElement(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Test Object/18_tabelAppraisal'), 0, FailureHandling.OPTIONAL)
		WebUI.delay(3)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/06_btnEdit'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Test Object/14_btnDetail'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Test Object/15_btnView'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Test Object/11_btnOk'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Test Object/16_btnOkAppraisal'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Test Object/22_btnSave'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Test Object/23_btnYes'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Test Object/11_btnOk'))
	}

	@Keyword
	def orderKreditUFI(String branch, String orderNumber, String ddlNavigation2) {
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Test Object/01_fldBranch'), branch)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Test Object/02_chkWithHierarcy'))
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/01_fldOrderNumber'), orderNumber)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/02_btnFind'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/03_rbVarOrderNumber', [('orderNumber') : orderNumber]))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/04_btnDdlNavigation'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/05_cbDdlNavigation', [('ddlNavigation') : ddlNavigation2]))
		WebUI.scrollToElement(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Test Object/18_tabelAppraisal'), 0)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/07_btnCreditStructure'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/06_btnEdit'))
	}

	@Keyword
	def orderKreditUFIStruktur(String branch, String orderNumber, String ddlNavigation2) {
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Test Object/01_fldBranch'), branch)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Test Object/02_chkWithHierarcy'))
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/01_fldOrderNumber'), orderNumber)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/02_btnFind'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/03_rbVarOrderNumber', [('orderNumber') : orderNumber]))
		WebUI.delay(3)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/04_btnDdlNavigation'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/05_cbDdlNavigation', [('ddlNavigation') : ddlNavigation2]))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/06_btnEdit'))
	}

	@Keyword
	def submitKreditNMC(String orderNumber, String ddlNavigation) {
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/01_fldOrderNumber'), orderNumber)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/02_btnFind'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/03_rbVarOrderNumber', [('orderNumber') : orderNumber]))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/04_btnDdlNavigation'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/05_cbDdlNavigation', [('ddlNavigation') : ddlNavigation]))
		//WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/06_btnEdit'))
	}

	@Keyword
	def inputDetailOrder(String installment, String frequencyMonth, String frequencyNumber, String calculatedBy, String interestEffective,
			String interestFlat, String netAdmin, String promoFee, String advanceArrear, String paymentMethod) {
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/01_btnInstallment'), FailureHandling.OPTIONAL)
		WebUI.focus(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/31_vwInstallmentCalcMethodUl'), FailureHandling.OPTIONAL)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/02_cbInstallmentVariable', [('installment') : installment]), FailureHandling.OPTIONAL)
		WebUI.selectOptionByLabel(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/03_cbFrequency'), frequencyMonth, false, FailureHandling.OPTIONAL)
		WebUI.selectOptionByLabel(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/04_cbFrequencyNumber'), frequencyNumber, false, FailureHandling.OPTIONAL)
		WebUI.selectOptionByLabel(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/05_cbCalculatedBy'), calculatedBy, false)
		if(calculatedBy == 'By Effective Rate') {
			WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/06_fldInterestRateEffective'), interestEffective)
		} else{
			WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/14_fldInterestRateFlat'), interestFlat)
		}
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/07_fldNetAdmin'), netAdmin)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/08_fldPromoFee'), promoFee)
		WebUI.selectOptionByLabel(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/09_cbAdvanceArrear'), advanceArrear, false)
		WebUI.selectOptionByLabel(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/10_cbPaymentMethod'), paymentMethod, false)
	}

	@Keyword
	def submitOrder() {
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/12_btnYes'))
	}

	@Keyword
	def submitOrderUFI(String commentInterest) {
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/11_btnSubmit'))
		WebUI.waitForPageLoad(100)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/13_btnYesSaveData'))
		WebUI.waitForPageLoad(100)
		if(WebUI.verifyElementVisible(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Test Object/05_lblInterestTidakSesuai'), FailureHandling.OPTIONAL)) {
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/13_btnYesSaveData'))
			WebUI.waitForPageLoad(100)
			WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Test Object/06_fldCommentInterest'), commentInterest)
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Test Object/07_btnSubmitComment'))
		} else {
			KeywordUtil.logInfo('Tidak Muncul Interest Tidak Sesuai')
		}
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/17_btnOkIndex1'), FailureHandling.OPTIONAL)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Test Object/10_btnOkSucesSubmit'), FailureHandling.OPTIONAL)
		//		WebUI.waitForPageLoad(500)
		WebUI.waitForElementPresent(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Test Object/11_btnOk'), 10, FailureHandling.OPTIONAL)
		//		String text = WebUI.getText(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Test Object/12_lblTextInformation'))
		//		KeywordUtil.logInfo(text)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Test Object/11_btnOk'), FailureHandling.OPTIONAL)
//		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Test Object/11_btnOk'), FailureHandling.OPTIONAL)
//		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Test Object/11_btnOk'), FailureHandling.OPTIONAL)
//		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Test Object/11_btnOk'), FailureHandling.OPTIONAL)
	}

	@Keyword
	def validationNetAdminTidakSesuai() {
		String text = WebUI.getText(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/13_lblValidationNetAdminTidakSesuai'))
		KeywordUtil.logInfo(text)
	}

	@Keyword
	def submitStrukturUFI(String installment, String frequencyMonth, String frequencyNumber, String calculatedBy, String interestFlat, String interestEffective, String grossAdmin, String advanceArrear, String paymentMethod) {
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/01_btnInstallment'), FailureHandling.OPTIONAL)
		WebUI.focus(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/31_vwInstallmentCalcMethodUl'), FailureHandling.OPTIONAL)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/02_cbInstallmentVariable', [('installment') : installment]), FailureHandling.OPTIONAL)
		WebUI.selectOptionByLabel(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/03_cbFrequency'), frequencyMonth, false, FailureHandling.OPTIONAL)
		WebUI.selectOptionByLabel(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/04_cbFrequencyNumber'), frequencyNumber, false, FailureHandling.OPTIONAL)
		WebUI.selectOptionByLabel(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/05_cbCalculatedBy'), calculatedBy, false)
		if(calculatedBy == 'By Effective Rate') {
			WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/06_fldInterestRateEffective'), interestEffective)
		} else{
			WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/14_fldInterestRateFlat'), interestFlat)
		}
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/15_fldGrossAdmin'), grossAdmin)
		WebUI.selectOptionByLabel(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/09_cbAdvanceArrear'), advanceArrear, false)
		WebUI.selectOptionByLabel(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/29_cbPaymentMethod'), paymentMethod, false)
	}

	@Keyword
	def submitStrukturUFIUpdate(String installment, String frequencyMonth, String frequencyNumber, String calculatedBy, String interestFlat,
			String interestEffective, String grossAdmin, String advanceArrear, String paymentMethod, String receiveBank, String bankName, String accountName, String accountNumber) {
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/01_btnInstallment'), FailureHandling.OPTIONAL)
		WebUI.focus(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/31_vwInstallmentCalcMethodUl'), FailureHandling.OPTIONAL)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/02_cbInstallmentVariable', [('installment') : installment]), FailureHandling.OPTIONAL)
		WebUI.selectOptionByLabel(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/03_cbFrequency'), frequencyMonth, false, FailureHandling.OPTIONAL)
		WebUI.selectOptionByLabel(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/04_cbFrequencyNumber'), frequencyNumber, false, FailureHandling.OPTIONAL)
		WebUI.selectOptionByLabel(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/05_cbCalculatedBy'), calculatedBy, false)
		if(calculatedBy == 'By Effective Rate') {
			WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/06_fldInterestRateEffective'), interestEffective)
		} else{
			KeywordUtil.logInfo('Tidak muncul alert Yes')
		}
		WebUI.delay(3)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/15_fldGrossAdmin'), grossAdmin)
		WebUI.selectOptionByLabel(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/09_cbAdvanceArrear'), advanceArrear, false)
		WebUI.delay(7)
		WebUI.selectOptionByLabel(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/29_cbPaymentMethod'), paymentMethod, false)
		if(paymentMethod == 'TRANSFER/ ATM') {
			WebUI.waitForPageLoad(10)
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/10_fldReceiveBank'))
			WebUI.delay(2)
			WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/10_fldReceiveBank'), Keys.chord(Keys.DOWN))
			WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/10_fldReceiveBank'), Keys.chord(Keys.ENTER))
			//WebUI.scrollToElement(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/01_btnReceiveBank'), 2)
			//WebUI.focus(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/02_cbReceiveBank'))
			//WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/02_cbReceiveBank', [('receiveBank') : receiveBank]))
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/03_btnBankName'))
			WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/04_fldBankName'), bankName)
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/05_btnFind'))
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/06_btnFirstRow'))
			(WebUI.waitForElementPresent(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/07_fldAccountName'),5))
			WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/07_fldAccountName'), accountName)
			WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/08_fldAccountNumber'), accountNumber)
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/09_btnCheckBankAccount'))
			WebUI.waitForPageLoad(10)
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Test Object/11_btnOk'))
			WebUI.waitForPageLoad(10)
		} else {
			KeywordUtil.logInfo('Payment Method = Tunai')
		}
	}

	@Keyword
	def submitStrukturNMC(String installment, String frequencyMonth, String frequencyNumber, String calculatedBy, String interestRate,
			String netAdmin, String promoFee, String advanceArrear, String paymentMethod, String receiveBank, String bankName, String accountName, String accountNumber) {
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/01_btnInstallment'), FailureHandling.OPTIONAL)
		WebUI.focus(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/31_vwInstallmentCalcMethodUl'), FailureHandling.OPTIONAL)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/32_cbCalculationMethod', [('installment') : installment]), FailureHandling.OPTIONAL)
		WebUI.selectOptionByLabel(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/03_cbFrequency'), frequencyMonth, false, FailureHandling.OPTIONAL)
		WebUI.selectOptionByLabel(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/04_cbFrequencyNumber'), frequencyNumber, false, FailureHandling.OPTIONAL)
		WebUI.selectOptionByLabel(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/05_cbCalculatedBy'), calculatedBy, false)
		if(calculatedBy == 'By Effective Rate') {
			WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/06_fldInterestRateEffective'), interestRate)
		} else if(calculatedBy == 'By Flat Rate'){
			WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/14_fldInterestRateFlat'), interestRate)
		}else{
			KeywordUtil.logInfo('Tidak muncul alert Yes')
		}
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/07_fldNetAdmin'), netAdmin)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/08_fldPromoFee'), promoFee)
		WebUI.selectOptionByLabel(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/09_cbAdvanceArrear'), advanceArrear, false)
		WebUI.selectOptionByLabel(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/10_cbPaymentMethod'), paymentMethod, false)
		if(paymentMethod == 'TRANSFER/ ATM') {
			WebUI.waitForPageLoad(10)
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/10_fldReceiveBank'))
			WebUI.delay(2)
			WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/10_fldReceiveBank'), Keys.chord(Keys.DOWN))
			WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/10_fldReceiveBank'), Keys.chord(Keys.ENTER))
			//WebUI.scrollToElement(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/01_btnReceiveBank'), 2)
			//WebUI.focus(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/02_cbReceiveBank'))
			//WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/02_cbReceiveBank', [('receiveBank') : receiveBank]))
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/03_btnBankName'))
			WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/04_fldBankName'), bankName)
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/05_btnFind'))
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/06_btnFirstRow'))
			WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/07_fldAccountName'), accountName)
			WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/08_fldAccountNumber'), accountNumber)
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/09_btnCheckBankAccount'))
			WebUI.waitForPageLoad(10)
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Test Object/11_btnOk'))
			WebUI.waitForPageLoad(10)
		} else {
			KeywordUtil.logInfo('Payment Method = Tunai')
		}
	}

	@Keyword
	def objectFinanceBpkbAddress(String province, String city, String kecamatan, String kelurahan, String address,
			String rt, String rw, String bpkbNumber, String bpkbDate) {
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/16_btnTabObjectFinanced'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/26_btnProvince'))
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/21_fldZipCode'), province)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/22_btnFind'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/23_lblFindResultZipCode', [('keyword') : province]))
		//city
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/27_btnCity'))
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/21_fldZipCode'), city)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/22_btnFind'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/23_lblFindResultZipCode', [('keyword') : city]))
		//kecamatan
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/24_btnKecamatan'))
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/21_fldZipCode'), kecamatan)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/22_btnFind'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/23_lblFindResultZipCode', [('keyword') : kecamatan]))
		//kelurahan
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/25_btnKelurahan'))
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/21_fldZipCode'), kelurahan)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/22_btnFind'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/23_lblFindResultZipCode', [('keyword') : kelurahan]))
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/17_fldAddress'), address)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/18_fldRT'), rt)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/19_fldRW'), rw)
		//zipcode
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/20_btnZipCode'))
		//WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/21_fldZipCode'), zipcode)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/22_btnFind'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/30_fldSearchResultZipAndSubZip'))
		//subZipcode
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/28_btnSubZipcode'))
		//WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/21_fldZipCode'), subZipcode)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/22_btnFind'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/31_searchResult_subZipCode'))
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Test Object/08_fldBpkbNumber'), bpkbNumber)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Test Object/09_fldBpkbDate'), bpkbDate)
	}
}
