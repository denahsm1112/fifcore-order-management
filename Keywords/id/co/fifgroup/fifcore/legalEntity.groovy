package id.co.fifgroup.fifcore

import org.openqa.selenium.WebElement
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import id.co.fifgroup.fifcore.utilities
import java.awt.Robot
import java.awt.event.KeyEvent
import java.util.concurrent.ConcurrentHashMap.KeySetView
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
import com.kms.katalon.core.configuration.RunConfiguration
import internal.GlobalVariable
import java.nio.file.Path
import java.nio.file.Paths
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.webui.driver.DriverFactory

public class legalEntity {
	@Keyword
	def newOrder() {
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/01_menu/01_btnMenuCAP'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/BM Dashboard Test Object/10_btnReceiveOrder'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/BM Dashboard Test Object/08_btnOrderTracking'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/01_menu/02_btnNewLegalEntity'))
	}

	@Keyword
	def formOrder(String companyID, String businessUnit, String branch, String platform, String ojk, String credit, String subcredit, String sektor) {
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/02_order/01_fldCompany'), companyID)
		WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/02_order/01_fldCompany'), Keys.chord(Keys.TAB))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/02_order/02_btnBusinessUnit'))
		WebUI.acceptAlert(FailureHandling.OPTIONAL)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/16_fldOccupation'), businessUnit)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/21_btnFind'))
		WebUI.waitForPageLoad(2)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/01_Order/2_businessUnit/01_cbBUCode', [('businessUnit') : businessUnit]))
		WebUI.delay(1)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/02_order/03_fldBranch'), branch)
		WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/02_order/03_fldBranch'), Keys.chord(Keys.TAB))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/02_order/04_btnPlatform'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/03_cbVarPlatform', [('platform') : platform]))
		if (platform == 'SYARIAH'){
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/04_cbIfSyariah'))
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/05_cbMurabahah'))
		} else {
			KeywordUtil.logInfo('Platform = KONVENSIONAL')
		}
		WebUI.scrollToElement(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/03_customer info/05_fldKelurahan'), 0)
		WebUI.waitForPageLoad(2)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/02_order/05_btnOJK'))
		WebUI.acceptAlert(FailureHandling.OPTIONAL)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/16_fldOccupation'), ojk)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/21_btnFind'))
		WebUI.waitForPageLoad(2)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/01_Order/2_businessUnit/01_cbBUCode', [('businessUnit') : ojk]))
		WebUI.waitForPageLoad(2)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/02_order/06_btnCreditObjective'))
		WebUI.acceptAlert(FailureHandling.OPTIONAL)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/16_fldOccupation'), credit)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/21_btnFind'))
		WebUI.waitForPageLoad(2)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/01_Order/2_businessUnit/01_cbBUCode', [('businessUnit') : credit]))
		WebUI.waitForPageLoad(2)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/02_order/07_btnSubCreditObjective'))
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/16_fldOccupation'), subcredit)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/21_btnFind'))
		WebUI.waitForPageLoad(2)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/01_Order/2_businessUnit/01_cbBUCode', [('businessUnit') : subcredit]))
		WebUI.waitForPageLoad(2)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/02_order/08_btnSectorEconomy'))
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/16_fldOccupation'), sektor)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/21_btnFind'))
		WebUI.waitForPageLoad(2)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/10_btnDataFirst'))
		WebUI.waitForPageLoad(2)
	}

	@Keyword
	def customerInfo(String custNumber) {
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/03_customer info/01_btnCustomerNo'))
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/03_customer info/02_fldCustomerNo'), custNumber)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/03_customer info/03_btnFind'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/01_Order/2_businessUnit/01_cbBUCode', [('businessUnit') : custNumber]))
	}

	@Keyword
	def contactInfo() {
		if(WebUI.verifyElementPresent(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/03_customer info/04_chkMobilePhone1'), 0, FailureHandling.OPTIONAL)) {
			if(WebUI.verifyElementChecked(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/03_customer info/04_chkMobilePhone1'), 0, FailureHandling.OPTIONAL)) {
				KeywordUtil.logInfo('Nomor Pertama Sudah Checklist')
			} else {
				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/03_customer info/04_chkMobilePhone1'))
			}
		} else {
			KeywordUtil.logInfo('Nomor Pertama Tidak Ada')
		}
	}

	@Keyword
	def objectInfoAutoInvoice(String tenor, String objGroup, String dealerID, String objCode, String colour,
			String pricePerUnit, String dpDealer, String dpFif, String installment) {
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/1_tenor/02_fldTenorM'), tenor)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/04_object info/01_btnAddRow'))
		WebUI.setText(findTestObject('FIFCORE Test Object/Initial Order Test Object/04_objectFinance/1_tenor/0_objFinance/07_fldObjGroup'), objGroup)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/1_tenor/0_objFinance/03_fldDealer'), dealerID)
		WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/1_tenor/0_objFinance/11_cbNewUsed'), Keys.chord(Keys.DOWN, Keys.ENTER))
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/1_tenor/0_objFinance/06_fldObjCode'), objCode)
		WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/1_tenor/0_objFinance/12_cbUnitAvailbility'), Keys.chord(Keys.DOWN, Keys.ENTER))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/1_tenor/1_autoInvoice/01_btnColor'))
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/16_fldOccupation'), colour)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/21_btnFind'))
		WebUI.waitForPageLoad(2)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/10_btnDataFirst'))
		WebUI.waitForPageLoad(2)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/04_object info/02_fldPricePerUnit'), pricePerUnit)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/04_object info/03_fldGrossDpDealer'), dpDealer)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/04_object info/04_fldGrossDpFif'), dpFif)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/04_object info/05_fldInstallmentAmount'), installment)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/1_tenor/1_autoInvoice/11_chkBpkbSameAsKTP'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/1_tenor/0_objFinance/02_btnOK'))
	}

	@Keyword
	def general(String so, String visitDate, String vID) {
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/05_general/01_fldSourceOrder'), so)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/05_general/02_fldPromiseVisitDate'), visitDate)
		WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/05_general/03_fldTimeVisit'), Keys.chord(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE))
		WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/05_general/03_fldTimeVisit'), Keys.chord(Keys.NUMPAD1, Keys.NUMPAD5, Keys.NUMPAD0, Keys.NUMPAD0))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/05_general/04_chkPreFlag'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/05_general/05_btnSendVia'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/05_generalInfo/07_cbSendVia', [('sendVia') : 'KASIR']))
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/05_general/06_txtVerifierId'), vID)
		WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/05_general/06_txtVerifierId'), Keys.chord(Keys.TAB))
	}

	@Keyword
	def salesInfoNMC(String salesType1, String salesIdInfo1, String salesType2, String salesIdInfo2, String salesType3, String salesIdInfo3) {
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/06_sales info/01_btnAddRow'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/06_sales info/02_btnSalesType1'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/25_cbVarSalesType', [('salesType') : salesType1]))
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/06_sales info/05_fldSalesInfo1'), salesIdInfo1)
		WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/06_sales info/05_fldSalesInfo1'), Keys.chord(Keys.TAB))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/06_sales info/01_btnAddRow'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/06_sales info/03_btnSalesType2'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/25_cbVarSalesType', [('salesType') : salesType2]))
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/06_sales info/06_fldSalesInfo2'), salesIdInfo2)
		WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/06_sales info/06_fldSalesInfo2'), Keys.chord(Keys.TAB))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/06_sales info/01_btnAddRow'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/06_sales info/04_btnSalesType3'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/25_cbVarSalesType', [('salesType') : salesType3]))
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/06_sales info/07_fldSalesInfo3'), salesIdInfo3)
		WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/06_sales info/07_fldSalesInfo3'), Keys.chord(Keys.TAB))
	}

	@Keyword
	def addDocument(String siup, String npwp, String fidusia, String transaksiUsaha, String npwpPengurus) {
		def projectDir = RunConfiguration.getProjectDir()
		Path projectPath = Paths.get(projectDir)
		Path imageFile1 = projectPath.resolve('Data Files').resolve(siup)
		Path imageFile2 = projectPath.resolve('Data Files').resolve(npwp)
		Path imageFile3 = projectPath.resolve('Data Files').resolve(fidusia)
		Path imageFile4 = projectPath.resolve('Data Files').resolve(transaksiUsaha)
		Path imageFile5 = projectPath.resolve('Data Files').resolve(npwpPengurus)
		String jpgFile1 = imageFile1
		String jpgFile2 = imageFile2
		String jpgFile3 = imageFile3
		String jpgFile4 = imageFile4
		String jpgFile5 = imageFile5

		WebUI.waitForPageLoad(10)
		WebUI.delay(1)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/07_document checklist/01_btnDocChecklist'))
		WebUI.waitForPageLoad(10)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/07_document checklist/02_chkReceiveFlag'))
		WebUI.waitForPageLoad(10)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/07_document checklist/03_btnUpload'))
		WebUI.waitForPageLoad(10)
		utilities.uploadFile(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/07_document checklist/04_btnBrowse'), jpgFile1)
		WebUI.waitForPageLoad(10)
		WebUI.delay(1)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/07_document checklist/05_btnOk'))
		WebUI.waitForPageLoad(10)

		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/07_document checklist/07_chkReceiveFlagNpwp'))
		WebUI.waitForPageLoad(10)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/07_document checklist/08_btnUpload2'))
		WebUI.waitForPageLoad(10)
		utilities.uploadFile(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/07_document checklist/04_btnBrowse'), jpgFile2)
		WebUI.waitForPageLoad(10)
		WebUI.delay(1)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/07_document checklist/05_btnOk'))
		WebUI.waitForPageLoad(10)

		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/07_document checklist/09_chkFidusia'))
		WebUI.waitForPageLoad(10)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/07_document checklist/10_btnUpload3'))
		WebUI.waitForPageLoad(10)
		utilities.uploadFile(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/07_document checklist/04_btnBrowse'), jpgFile3)
		WebUI.waitForPageLoad(10)
		WebUI.delay(1)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/07_document checklist/05_btnOk'))
		WebUI.waitForPageLoad(10)

		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/07_document checklist/11_chkBuktiTransaksiUsaha'))
		WebUI.waitForPageLoad(10)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/07_document checklist/12_btnUpload4'))
		WebUI.waitForPageLoad(10)
		utilities.uploadFile(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/07_document checklist/04_btnBrowse'), jpgFile4)
		WebUI.waitForPageLoad(10)
		WebUI.delay(1)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/07_document checklist/05_btnOk'))
		WebUI.waitForPageLoad(10)

		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/07_document checklist/13_chkNpwpPengurus'))
		WebUI.waitForPageLoad(10)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/07_document checklist/14_btnUpload5'))
		WebUI.waitForPageLoad(10)
		utilities.uploadFile(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/07_document checklist/04_btnBrowse'), jpgFile5)
		WebUI.waitForPageLoad(10)
		WebUI.delay(1)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/07_document checklist/05_btnOk'))
		WebUI.waitForPageLoad(10)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/07_document checklist/06_btnOkSecond'))
		WebUI.waitForPageLoad(10)
	}

	@Keyword
	def submitData(String ojk) {
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/12_btnSubmit'))

		TestObject linkObject = findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/21_lblOccupatioOnId_Status')
		List<WebElement> elements = WebUI.findWebElements(linkObject, 2)
		println(elements)
		def counter = 0
		def isYesAfterSubmit = WebUI.verifyElementPresent(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/13_btnYesSaveData'), 0, FailureHandling.OPTIONAL)
		while(counter < elements.size()) {
			if(isYesAfterSubmit ==  false) {
				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/08_fldOjk'))
				WebUI.acceptAlert(FailureHandling.OPTIONAL)
				WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/16_fldOccupation'), ojk)
				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/21_btnFind'))
				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/10_btnDataFirst'))

				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/12_btnSubmit'))
				break
			} else {
				println("Kondisi tidak terpenuhi, lanjutkan looping")
			}
			counter++
		}
		WebUI.waitForPageLoad(60)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/13_btnYesSaveData'))
		WebUI.waitForPageLoad(60)
		if(WebUI.verifyElementVisible(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/18_dlgBlacklist'), FailureHandling.OPTIONAL)) {
			WebUI.waitForPageLoad(60)
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/11_btnOkInformation'))
		} else {
			KeywordUtil.logInfo('Tidak Muncul Blacklist')
		}
		WebUI.waitForPageLoad(60)
		if(WebUI.verifyElementVisible(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/09_Update/01_dlgRejectTreatment'), FailureHandling.OPTIONAL)) {
			WebUI.waitForPageLoad(60)
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/11_btnOkInformation'))
		} else {
			KeywordUtil.logInfo('Tidak Muncul Reject Treatment')
		}
		WebUI.waitForPageLoad(60)
		if(WebUI.verifyElementVisible(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/16_dlgCustMemilikiOrder'), FailureHandling.OPTIONAL)) {
			WebUI.waitForPageLoad(60)
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/13_btnYesSaveData'))
		} else {
			KeywordUtil.logInfo('Tidak Muncul Button Yes')
		}
		WebUI.waitForPageLoad(60)
		if(WebUI.verifyElementVisible(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/09_Update/01_dlgRejectTreatment'), FailureHandling.OPTIONAL)) {
			WebUI.waitForPageLoad(60)
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/11_btnOkInformation'))
		} else {
			KeywordUtil.logInfo('Tidak Muncul Reject Treatment')
		}
		WebUI.waitForPageLoad(60)
		String teksOrder = WebUI.getText(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/27_lblGetTextOrder')).replaceAll("[^0-9.]", "")
		GlobalVariable.teksOrder = teksOrder
		KeywordUtil.logInfo('Nomor Order : ' + GlobalVariable.teksOrder)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/11_btnOkInformation'))
		WebUI.delay(3)
	}

	@Keyword
	def cekUserStructureNMC(String branch, String orderNumber, String ddlNavigation1) {
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Test Object/01_fldBranch'), branch)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Test Object/02_chkWithHierarcy'))
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/01_fldOrderNumber'), orderNumber)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/02_btnFind'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/03_rbVarOrderNumber', [('orderNumber') : orderNumber]))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/04_btnDdlNavigation'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/05_cbDdlNavigation', [('ddlNavigation') : ddlNavigation1]))
		WebUI.scrollToElement(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/08_credit structure/01_tabelStructureCredit'), 0)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/08_credit structure/01_tabelStructureCredit'))

		String textCreditStructure = WebUI.getText(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Test Object/19_lblGetTextAppraisal'), FailureHandling.OPTIONAL)
		String textApproval = WebUI.getText(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Test Object/20_lblGetTextCreditStructure'), FailureHandling.OPTIONAL)
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
	def structureKreditNMC(String branch, String orderNumber, String ddlNavigation1) {
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Test Object/01_fldBranch'), branch)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Test Object/02_chkWithHierarcy'))
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/01_fldOrderNumber'), orderNumber)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/02_btnFind'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/03_rbVarOrderNumber', [('orderNumber') : orderNumber]))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/04_btnDdlNavigation'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/05_cbDdlNavigation', [('ddlNavigation') : ddlNavigation1]))
		WebUI.scrollToElement(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Test Object/18_tabelAppraisal'), 0)
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
	def submitStrukturUFIUpdate(String installment, String frequencyMonth, String frequencyNumber, String calculatedBy, String interestFlat,
			String interestEffective, String netAdmin, String promoFee, String advanceArrear, String paymentMethod, String receiveBank,
			String bankName, String accountName, String accountNumber) {
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
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/08_credit structure/03_fldNetAdmin'), netAdmin)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/08_credit structure/04_fldPromoFee'), promoFee)
		WebUI.selectOptionByLabel(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/09_cbAdvanceArrear'), advanceArrear, false)
		WebUI.selectOptionByLabel(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/08_credit structure/02_cbPaymentMethod'), paymentMethod, false)
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
			String rt, String rw, String bpkbNumber, String bpkbDate, String stnkNumber, String stnkDate) {
		//		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/16_btnTabObjectFinanced'))
		//		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/26_btnProvince'))
		//		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/21_fldZipCode'), province)
		//		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/22_btnFind'))
		//		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/23_lblFindResultZipCode', [('keyword') : province]))
		//		//city
		//		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/27_btnCity'))
		//		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/21_fldZipCode'), city)
		//		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/22_btnFind'))
		//		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/23_lblFindResultZipCode', [('keyword') : city]))
		//		//kecamatan
		//		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/24_btnKecamatan'))
		//		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/21_fldZipCode'), kecamatan)
		//		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/22_btnFind'))
		//		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/23_lblFindResultZipCode', [('keyword') : kecamatan]))
		//		//kelurahan
		//		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/25_btnKelurahan'))
		//		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/21_fldZipCode'), kelurahan)
		//		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/22_btnFind'))
		//		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/23_lblFindResultZipCode', [('keyword') : kelurahan]))
		//		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/17_fldAddress'), address)
		//		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/18_fldRT'), rt)
		//		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/19_fldRW'), rw)
		//		//zipcode
		//		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/20_btnZipCode'))
		//		//WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/21_fldZipCode'), zipcode)
		//		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/22_btnFind'))
		//		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/30_fldSearchResultZipAndSubZip'))
		//		//subZipcode
		//		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/28_btnSubZipcode'))
		//		//WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/21_fldZipCode'), subZipcode)
		//		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/22_btnFind'))
		//		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/31_searchResult_subZipCode'))
		WebUI.selectOptionByLabel(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/08_credit structure/07_cbIdentityType'), 'KTP', false, FailureHandling.OPTIONAL)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/08_credit structure/08_fldIdentityNumber'), '31789054534523')
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/08_credit structure/09_fldOccupation'), 'WIRASWASTA')
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Test Object/08_fldBpkbNumber'), bpkbNumber)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Test Object/09_fldBpkbDate'), bpkbDate)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/08_credit structure/05_fldStnkNumber'), stnkNumber)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/08_credit structure/06_fldStnkValidUntil'), stnkDate)
	}

	@Keyword
	def submitOrderNMC(String commentInterest) {
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
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Test Object/10_btnOkSucesSubmit'))
		WebUI.waitForPageLoad(500)
		//		String text = WebUI.getText(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Test Object/12_lblTextInformation'))
		//		KeywordUtil.logInfo(text)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Test Object/11_btnOk'))
	}

	@Keyword
	def approvalThird(String nomorOrder, String statusApproval, String reason, String comment) {
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/09_approval/04_chkHierarchy'))
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

	@Keyword
	def inquiryOrderNMC(String orderNumber) {
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Test Object/02_chkWithHierarcy'))
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/01_fldOrderNumber'), orderNumber)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/02_btnFind'))
		WebUI.scrollToElement(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Test Object/26_btnInProgress'), 2)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Test Object/26_btnInProgress'))
		String loginApproverFirst = WebUI.getText(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/09_approval/07_lblGetTextApproval1'), FailureHandling.OPTIONAL)
		String loginApproverSecond = WebUI.getText(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/09_approval/08_lblGetTextApproval2'), FailureHandling.OPTIONAL)
		String loginApproverThird = WebUI.getText(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/09_approval/09_lblGetTextApproval3'), FailureHandling.OPTIONAL)
		String loginApprovalForth = WebUI.getText(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/09_approval/10_lblGetTextApproval4'), FailureHandling.OPTIONAL)
		//Store to Global Scope
		GlobalVariable.LoginApproverFirst = loginApproverFirst
		GlobalVariable.LoginApproverSecond = loginApproverSecond
		GlobalVariable.LoginApproveThird = loginApproverThird
		GlobalVariable.LoginApproveForth = loginApprovalForth
		KeywordUtil.logInfo('Login Approval 1 '+GlobalVariable.LoginApproverFirst)
		KeywordUtil.logInfo('Login Approval 2 '+GlobalVariable.LoginApproverSecond)
		KeywordUtil.logInfo('Login Approval 3 '+GlobalVariable.LoginApproveThird)
		KeywordUtil.logInfo('Login Approval 4 '+GlobalVariable.LoginApproveForth)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Test Object/28_btnCancel'))
	}

	@Keyword
	def inquiryOrderInProgressNMC(String orderNumber) {
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Test Object/02_chkWithHierarcy'))
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/01_fldOrderNumber'), orderNumber)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/02_btnFind'))
		WebUI.scrollToElement(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Test Object/26_btnInProgress'), 2)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Test Object/26_btnInProgress'))
		String loginApproverFirst = WebUI.getText(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/09_approval/11_lblGetTextCreditApproval'), FailureHandling.OPTIONAL)
		//Store to Global Scope
		GlobalVariable.LoginApproverFirst = loginApproverFirst
		KeywordUtil.logInfo('Login Approver In Progress '+GlobalVariable.LoginApproverFirst)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Test Object/28_btnCancel'))
		WebUI.acceptAlert(FailureHandling.OPTIONAL)
	}

	@Keyword
	def purchaseOrderNMC(String noPO, String dateForm, String dateTo) {
		WebUI.acceptAlert(FailureHandling.OPTIONAL)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/10_purchase order/01_fldNoPO'), noPO)
		WebUI.acceptAlert(FailureHandling.OPTIONAL)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/10_purchase order/02_chkHierarchy'))
		WebUI.acceptAlert(FailureHandling.OPTIONAL)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/10_purchase order/10_fldPODateFrom'), dateForm)
		WebUI.acceptAlert(FailureHandling.OPTIONAL)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/10_purchase order/11_fldPODateTo'), dateTo)
		WebUI.acceptAlert(FailureHandling.OPTIONAL)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/10_purchase order/03_btnFind'))
		WebUI.acceptAlert(FailureHandling.OPTIONAL)
		WebUI.delay(3)
		WebUI.acceptAlert(FailureHandling.OPTIONAL)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/10_purchase order/05_btnDetailPO', [('noPO') : noPO]))
		WebUI.acceptAlert(FailureHandling.OPTIONAL)
		WebUI.scrollToElement(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/10_purchase order/06_btnCancel'), 0)
		WebUI.acceptAlert(FailureHandling.OPTIONAL)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/10_purchase order/06_btnCancel'))
		WebUI.acceptAlert(FailureHandling.OPTIONAL)
		WebUI.delay(1)
		WebUI.acceptAlert(FailureHandling.OPTIONAL)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/10_purchase order/07_chkNoPO', [('noPO') : noPO]))
		WebUI.acceptAlert(FailureHandling.OPTIONAL)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/10_purchase order/08_chkPrintComplete'))
		WebUI.acceptAlert(FailureHandling.OPTIONAL)
		WebUI.scrollToElement(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/10_purchase order/09_btnSendPO'), 0)
		WebUI.acceptAlert(FailureHandling.OPTIONAL)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/10_purchase order/09_btnSendPO'))
		WebUI.acceptAlert(FailureHandling.OPTIONAL)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Test Object/11_btnOk'))
		WebUI.acceptAlert(FailureHandling.OPTIONAL)
	}

	@Keyword
	def receiveInvoice(String noPO, String dealerID) {
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/11_invoice/01_btnNew'))
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/11_invoice/02_fldNoPO'), noPO)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/11_invoice/03_chkHierarchy'))
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/11_invoice/05_fldDealerId'), dealerID)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/11_invoice/04_btnFind'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/11_invoice/06_chkNoPO', [('noPO') : noPO]))
		WebUI.scrollToElement(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Test Object/22_btnSave'), 0)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Test Object/22_btnSave'))
		WebUI.waitForPageLoad(60)
		String teksReceipt = WebUI.getText(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/11_invoice/07_lblGetTextNoReceipt')).replaceAll("[^0-9]", "")
		GlobalVariable.teksReceipt = teksReceipt
		KeywordUtil.logInfo('Nomor Receipt : ' + GlobalVariable.teksReceipt)
		WebUI.delay(3)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/11_btnOkInformation'))
	}

	@Keyword
	def receiveRecept(String dealerID, String noRecept) {
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/12_recept/04_chkHierarchy'))
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/12_recept/05_fldDealer'), dealerID)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/12_recept/01_btnFind'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/12_recept/02_chkRecept', [('noRecept') : noRecept]))
	}

	@Keyword
	def entryInvoice(String dealerID, String noPO, String bastNo, String bastDate, String invoiceDealerNo,
			String invoiceDealerDate, String noka, String nosin, String noPlat, String noFaktur, String dateFaktur) {
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/12_recept/10_btnMenuReceive'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/12_recept/26_chkHierachy'))
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/12_recept/07_fldDealer'), dealerID)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/12_recept/09_fldNoPO'), noPO)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/12_recept/08_btnFind'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/12_recept/02_chkRecept', [('noRecept') : noPO]))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/12_recept/11_btnDetailPO', [('noRecept') : noPO]))
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/12_recept/12_fldBastNumber'), bastNo)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/12_recept/13_fldBastDate'), bastDate)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/12_recept/14_fldInvoiceDealerNo'), invoiceDealerNo)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/12_recept/13_fldBastDate'), invoiceDealerDate)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/12_recept/16_btnDetail'))
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/12_recept/17_fldChassisNo'), noka)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/12_recept/18_fldEngineNo'), nosin)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/12_recept/19_fldPlatNo'), noPlat)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/12_recept/20_fldNoFaktur'), noFaktur)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/12_recept/21_fldFakturDate'), dateFaktur)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/12_recept/22_btnOk'))
		WebUI.scrollToElement(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/12_recept/23_btnConfirm'), 0)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/12_recept/23_btnConfirm'))
		WebUI.waitForPageLoad(60)
		String teksInvoice = WebUI.getText(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/12_recept/24_lblGetTextInvoice'))

		def pattern = /(?<=PO Number: )\d+I\d+/
		def matcher = (teksInvoice =~ pattern)

		if (matcher.find()) {
			def nomorInvoice = matcher.group(0)
			println nomorInvoice
			GlobalVariable.teksInvoice = nomorInvoice
			KeywordUtil.logInfo('Nomor Invoice : ' + GlobalVariable.teksInvoice)
		} else {
			println "Nomor Invoice tidak ditemukan dalam teks."
		}
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/12_recept/25_btnOk'))
	}

	@Keyword
	def entryInvoiceNMC(String dealerID, String noPO, String bastNo, String bastDate, String invoiceDealerNo,
			String invoiceDealerDate, String noka, String nosin, String noPlat, String noFaktur, String dateFaktur) {
		WebUI.acceptAlert(FailureHandling.OPTIONAL)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/12_recept/10_btnMenuReceive'))
		WebUI.acceptAlert(FailureHandling.OPTIONAL)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/12_recept/27_chkWithHierarchy'))
		WebUI.acceptAlert(FailureHandling.OPTIONAL)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/12_recept/28_fldDealer'), dealerID)
		WebUI.acceptAlert(FailureHandling.OPTIONAL)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/12_recept/29_fldPONumber'), noPO)
		WebUI.acceptAlert(FailureHandling.OPTIONAL)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/12_recept/30_btnFind'))
		WebUI.acceptAlert(FailureHandling.OPTIONAL)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/12_recept/02_chkRecept', [('noRecept') : noPO]))
		WebUI.acceptAlert(FailureHandling.OPTIONAL)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/12_recept/11_btnDetailPO', [('noRecept') : noPO]))
		WebUI.acceptAlert(FailureHandling.OPTIONAL)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/12_recept/12_fldBastNumber'), bastNo)
		WebUI.acceptAlert(FailureHandling.OPTIONAL)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/12_recept/32_fldBASTDate'))
		WebUI.acceptAlert(FailureHandling.OPTIONAL)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/12_recept/31_btnBASTDate',[('bastDate') : bastDate]))
		WebUI.acceptAlert(FailureHandling.OPTIONAL)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/12_recept/14_fldInvoiceDealerNo'), invoiceDealerNo)
		WebUI.acceptAlert(FailureHandling.OPTIONAL)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/12_recept/33_btnInvoiceDate'))
		WebUI.acceptAlert(FailureHandling.OPTIONAL)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/12_recept/34_fldInvoiceDate',[('invoiceDate') : invoiceDealerDate]))
		WebUI.acceptAlert(FailureHandling.OPTIONAL)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/12_recept/16_btnDetail'))
		WebUI.acceptAlert(FailureHandling.OPTIONAL)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/12_recept/17_fldChassisNo'), noka)
		WebUI.acceptAlert(FailureHandling.OPTIONAL)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/12_recept/18_fldEngineNo'), nosin)
		WebUI.acceptAlert(FailureHandling.OPTIONAL)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/12_recept/19_fldPlatNo'), noPlat)
		WebUI.acceptAlert(FailureHandling.OPTIONAL)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/12_recept/20_fldNoFaktur'), noFaktur)
		WebUI.acceptAlert(FailureHandling.OPTIONAL)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/12_recept/21_fldFakturDate'), dateFaktur)
		WebUI.acceptAlert(FailureHandling.OPTIONAL)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/12_recept/22_btnOk'))
		WebUI.acceptAlert(FailureHandling.OPTIONAL)
		WebUI.scrollToElement(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/12_recept/23_btnConfirm'), 0)
		WebUI.acceptAlert(FailureHandling.OPTIONAL)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/12_recept/23_btnConfirm'))
		WebUI.waitForPageLoad(60)
		String teksInvoice = WebUI.getText(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/12_recept/24_lblGetTextInvoice'))

		def pattern = /(?<=PO Number: )\d+I\d+/
		def matcher = (teksInvoice =~ pattern)

		if (matcher.find()) {
			def nomorInvoice = matcher.group(0)
			println nomorInvoice
			GlobalVariable.teksInvoice = nomorInvoice
			KeywordUtil.logInfo('Nomor Invoice : ' + GlobalVariable.teksInvoice)
		} else {
			println "Nomor Invoice tidak ditemukan dalam teks."
		}
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/12_recept/25_btnOk'))
		WebUI.acceptAlert(FailureHandling.OPTIONAL)
	}
	@Keyword
	def generateAR(String companyID, String businessUnit, String invoiceFrom, String invoiceTo, String nomorOrder) {
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/13_generate AR/01_fldCompany'))
		WebUI.acceptAlert(FailureHandling.OPTIONAL)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/16_fldOccupation'), companyID)
		WebUI.acceptAlert(FailureHandling.OPTIONAL)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/21_btnFind'))
		WebUI.acceptAlert(FailureHandling.OPTIONAL)
		WebUI.waitForPageLoad(2)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/01_Order/2_businessUnit/01_cbBUCode', [('businessUnit') : companyID]))
		WebUI.acceptAlert(FailureHandling.OPTIONAL)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/13_generate AR/02_fldBU'))
		WebUI.acceptAlert(FailureHandling.OPTIONAL)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/16_fldOccupation'), businessUnit)
		WebUI.acceptAlert(FailureHandling.OPTIONAL)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/21_btnFind'))
		WebUI.acceptAlert(FailureHandling.OPTIONAL)
		WebUI.waitForPageLoad(2)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/01_Order/2_businessUnit/01_cbBUCode', [('businessUnit') : businessUnit]))
		WebUI.acceptAlert(FailureHandling.OPTIONAL)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/13_generate AR/03_chkHierarchy'))
		WebUI.acceptAlert(FailureHandling.OPTIONAL)
		WebUI.delay(1)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/13_generate AR/04_fldInvoiceFrom'), invoiceFrom)
		WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/13_generate AR/04_fldInvoiceFrom'), Keys.chord(Keys.TAB))
		WebUI.acceptAlert(FailureHandling.OPTIONAL)
		WebUI.delay(1)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/13_generate AR/05_fldInvoiceTo'), invoiceTo)
		WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/13_generate AR/05_fldInvoiceTo'), Keys.chord(Keys.TAB))

		WebUI.acceptAlert(FailureHandling.OPTIONAL)
		WebUI.delay(2)
		WebUI.focus(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/13_generate AR/06_btnFind'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/13_generate AR/06_btnFind'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/13_generate AR/08_btnDetailGenAR', [('nomorOrder') : nomorOrder]))
		WebUI.scrollToElement(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/13_generate AR/09_btnGenAR'), 0)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/13_generate AR/09_btnGenAR'))
	}

	@Keyword
	def submitStructureCreditNMC(String commentInterest) {
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
		WebUI.delay(1)
		WebUI.waitForPageLoad(10)
		if(WebUI.verifyElementVisible(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/08_credit structure/10_btnOk1'), FailureHandling.OPTIONAL)) {
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/08_credit structure/10_btnOk1'))
		} else {
			KeywordUtil.logInfo('Tidak Muncul Button OK')
		}
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Test Object/10_btnOkSucesSubmit'))
		WebUI.waitForPageLoad(500)
		//		String text = WebUI.getText(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Test Object/12_lblTextInformation'))
		//		KeywordUtil.logInfo(text)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Test Object/11_btnOk'))
	}
}
