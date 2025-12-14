package id.co.fifgroup.fifcore

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
import com.kms.katalon.core.webui.keyword.internal.WebUIAbstractKeyword
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.sun.net.httpserver.Authenticator.Failure
import com.kms.katalon.core.configuration.RunConfiguration
import internal.GlobalVariable
import java.nio.file.Path
import java.nio.file.Paths
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import org.openqa.selenium.Keys as Keys

public class generateAR {
	@Keyword
	def formGenerateAR(String companyID, String businessUnit, String branch, String invoiceDateFrom, String invoiceDateTo, String teksOrder) {
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/01_btnCompany'))
		// Main loop
		while (true) {
			try {
				// Accept alert if present within 5 seconds
				WebUI.acceptAlert(5)
				println("Alert accepted.")
			} catch (Exception e) {
				println("No alert present.")
				break // Exit the loop if no alert is present
			}
		}
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/16_fldOccupation'), companyID)
		// Main loop
		while (true) {
			try {
				// Accept alert if present within 5 seconds
				WebUI.acceptAlert(5)
				println("Alert accepted.")
			} catch (Exception e) {
				println("No alert present.")
				break // Exit the loop if no alert is present
			}
		}
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/21_btnFind'))
		// Main loop
		while (true) {
			try {
				// Accept alert if present within 5 seconds
				WebUI.acceptAlert(5)
				println("Alert accepted.")
			} catch (Exception e) {
				println("No alert present.")
				break // Exit the loop if no alert is present
			}
		}
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/01_Order/2_businessUnit/01_cbBUCode', [('businessUnit') : companyID]))
		// Main loop
		while (true) {
			try {
				// Accept alert if present within 5 seconds
				WebUI.acceptAlert(5)
				println("Alert accepted.")
			} catch (Exception e) {
				println("No alert present.")
				break // Exit the loop if no alert is present
			}
		}

		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/02_btnBusinessId'))
		// Main loop
		while (true) {
			try {
				// Accept alert if present within 5 seconds
				WebUI.acceptAlert(5)
				println("Alert accepted.")
			} catch (Exception e) {
				println("No alert present.")
				break // Exit the loop if no alert is present
			}
		}
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/16_fldOccupation'), businessUnit)
		// Main loop
		while (true) {
			try {
				// Accept alert if present within 5 seconds
				WebUI.acceptAlert(5)
				println("Alert accepted.")
			} catch (Exception e) {
				println("No alert present.")
				break // Exit the loop if no alert is present
			}
		}
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/21_btnFind'))
		while (true) {
			try {
				// Accept alert if present within 5 seconds
				WebUI.acceptAlert(5)
				println("Alert accepted.")
			} catch (Exception e) {
				println("No alert present.")
				break // Exit the loop if no alert is present
			}
		}
		WebUI.waitForPageLoad(2)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/01_Order/2_businessUnit/01_cbBUCode', [('businessUnit') : businessUnit]))
		//		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/03_btnBranch'))
		//		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/05_txtBranch'), branch)
		//		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/06_btnFind'))
		//		WebUI.waitForPageLoad(2)
		//		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/01_Order/2_businessUnit/01_cbBUCode', [('businessUnit') : branch]))
		while (true) {
			try {
				// Accept alert if present within 5 seconds
				WebUI.acceptAlert(5)
				println("Alert accepted.")
			} catch (Exception e) {
				println("No alert present.")
				break // Exit the loop if no alert is present
			}
		}
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/04_chkWithHierarchy'))
		WebUI.acceptAlert(FailureHandling.OPTIONAL)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/07_fldInvoiceDateFrom'), invoiceDateFrom)
		WebUI.acceptAlert(FailureHandling.OPTIONAL)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/08_fldInvoiceDateTo'), invoiceDateTo)
		WebUI.acceptAlert(FailureHandling.OPTIONAL)
		WebUI.waitForPageLoad(10)
		WebUI.delay(2)
		WebUI.focus(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/09_btnFind'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/09_btnFind'))
		WebUI.acceptAlert(FailureHandling.OPTIONAL)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/11_chkNoOrder',[('teksOrder') : teksOrder]))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/12_chkChecklistAll'))
		WebUI.acceptAlert(FailureHandling.OPTIONAL)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/10_btnGenerateAR'))
		WebUI.acceptAlert(FailureHandling.OPTIONAL)
		WebUI.waitForPageLoad(50)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Test Object/11_btnOk'))
		WebUI.acceptAlert(FailureHandling.OPTIONAL)
	}

	@Keyword
	def formFindGenerateAr(String companyID, String businessUnit, String branch, String invoiceDateFrom, String invoiceDateTo, String region) {
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/01_btnCompany'))
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/16_fldOccupation'), companyID)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/21_btnFind'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/01_Order/2_businessUnit/01_cbBUCode', [('businessUnit') : companyID]))
		WebUI.delay(10)
		// Main loop
		while (true) {
			try {
				// Accept alert if present within 5 seconds
				WebUI.acceptAlert(5)
				println("Alert accepted.")
			} catch (Exception e) {
				println("No alert present.")
				break // Exit the loop if no alert is present
			}
		}
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/02_btnBusinessId'))
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/16_fldOccupation'), businessUnit)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/21_btnFind'))
		WebUI.waitForPageLoad(2)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/01_Order/2_businessUnit/01_cbBUCode', [('businessUnit') : businessUnit]))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/03_btnBranch'))
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/05_txtBranch'), branch)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/06_btnFind'))
		WebUI.waitForPageLoad(2)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/13_brUCode', [('branch'): branch]))
		if(RunConfiguration.getExecutionProfile()=='TEST') {
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/04_chkWithHierarchy'), FailureHandling.OPTIONAL)
			WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/07_fldInvoiceDateFrom'), invoiceDateFrom)
			WebUI.acceptAlert(FailureHandling.OPTIONAL)
			WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/08_fldInvoiceDateTo'), invoiceDateTo)
			WebUI.acceptAlert(FailureHandling.OPTIONAL)
		} else {
			WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/UAT/01_fldInvoiceDateFrom'), invoiceDateFrom, FailureHandling.OPTIONAL)
			WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/UAT/02_fldInvioceDateTo'), invoiceDateTo, FailureHandling.OPTIONAL)
		}
		WebUI.waitForPageLoad(10)
		WebUI.delay(2)
		if(region == 'REGULER') {
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/14_drpRegion'))
			WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Generate AR	 Test Object/14_drpRegion'), Keys.chord(Keys.DOWN, Keys.ENTER))
		} else if(region == 'CENTRALIZED') {
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/14_drpRegion'))
			WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/14_drpRegion'), Keys.chord(Keys.DOWN, Keys.DOWN,  Keys.ENTER))
		} else {
			KeywordUtil.logInfo('Region = NON_CENTRALIZED')
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/14_drpRegion'))
			WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/14_drpRegion'), Keys.chord(Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.ENTER))
		}
		WebUI.focus(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/09_btnFind'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/09_btnFind'))
		WebUI.acceptAlert(FailureHandling.OPTIONAL)
	}

	@Keyword
	def formDisbursementChecklistSystem(String tabMenu, String teksOrder, String mobilePhone, String receiverName) {
		//Cek orderNumber
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/05_chkNoOrderUncheck',[('teksOrder'): teksOrder]))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/15_btnDetail',[('teksOrder'): teksOrder]))

		WebUI.waitForPageLoad(60)
		//Click Disbursement Checklist System
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/17_spanByTxtDynamic',[('text'): tabMenu]))

		//Check Question Category
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/06_inpQuestionCategory'), FailureHandling.OPTIONAL)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/07_btnFind'), FailureHandling.OPTIONAL)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/08_btnDCS01'), FailureHandling.OPTIONAL)
		//Click Populate
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/09_btnPopulate'), FailureHandling.OPTIONAL)
		WebUI.scrollToElement(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/18_txtDisbursement'), 0)

		// Mendapatkan objek gambar
		TestObject image = findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/31_imgList')

		// Menentukan jumlah iterasi
		int numberIterasiQuestion = 1

		for (int i = 0; i < numberIterasiQuestion; i++) {
			println("Iterasi Cek Gambar ke-" + (i + 1))

			// View KTP
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/01_btnViewIdCustomer'))
			if (WebUI.verifyElementPresent(image, 5, FailureHandling.OPTIONAL)) {
				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/02_btnOk'), FailureHandling.OPTIONAL)
				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/30_chkKtpValid'))
			} else {
				String getErrTxtIdCust = WebUI.getText(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/16_msgErrText'))
				KeywordUtil.logInfo('View KTP :' + getErrTxtIdCust)
				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/04_btnOkFail'))
			}

			// View KTP or SIM Pasangan
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/03_btnViewKTPSimPasangan'))
			if (WebUI.verifyElementPresent(image, 5, FailureHandling.OPTIONAL)) {
				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/02_btnOk'), FailureHandling.OPTIONAL)
				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/32_chkKTPSIMPasangan'))
			} else {
				String getErrTxtKK = WebUI.getText(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/16_msgErrText'))
				KeywordUtil.logInfo('View KK :' + getErrTxtKK)
				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/04_btnOkFail'))
			}

			// View KK
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/10_btnViewKK'), FailureHandling.STOP_ON_FAILURE)
			if (WebUI.verifyElementPresent(image, 5, FailureHandling.OPTIONAL)) {
				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/02_btnOk'), FailureHandling.OPTIONAL)
				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/33_chkKKValid'))
			} else {
				String getErrTxtSIM = WebUI.getText(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/16_msgErrText'))
				KeywordUtil.logInfo('View KTP / SIM Pasangan :' + getErrTxtSIM)
				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/04_btnOkFail'))
			}

			// NPWP
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/11_btnViewNPWP'))
			if (WebUI.verifyElementPresent(image, 5, FailureHandling.OPTIONAL)) {
				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/02_btnOk'), FailureHandling.OPTIONAL)
				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/34_chkNpwpValid'))
			} else {
				String getErrTxtNPWP = WebUI.getText(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/16_msgErrText'))
				KeywordUtil.logInfo('View NPWP: ' + getErrTxtNPWP)
				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/04_btnOkFail'))
			}

			// Foto Selfie
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/12_btnViewFotoSelfie'))
			if (WebUI.verifyElementPresent(image, 5, FailureHandling.OPTIONAL)) {
				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/02_btnOk'), FailureHandling.OPTIONAL)
				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/36_chkFotoSelfie')) // Sesuaikan path jika salah
			} else {
				String getErrTxtSlipGaji = WebUI.getText(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/16_msgErrText'))
				KeywordUtil.logInfo('View SLIP GAJI: ' + getErrTxtSlipGaji)
				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/04_btnOkFail'))
			}

			//Foto Slip Gaji
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/13_btnViewSlipGaji'))
			if (WebUI.verifyElementPresent(image, 5, FailureHandling.OPTIONAL)) {
				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/02_btnOk'), FailureHandling.OPTIONAL)
				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/37_chkFotoSlipGaji'))
			} else {
				String getErrTxtFotoSelfie = WebUI.getText(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/16_msgErrText'))
				KeywordUtil.logInfo('View Foto Selfie: ' +getErrTxtFotoSelfie)
				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/04_btnOkFail'))
			}
		}

		'Checking kendaraan new customer'
		//Mendapatkan objek gambar
		TestObject image1 = findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/31_imgList')

		// Menentukan jumlah iterasi
		int numberIterasiQuestion1 = 1

		for (int i = 0; i < numberIterasiQuestion1; i++) {
			println("Iterasi Cek Gambar ke-" + (i + 1))

			//STNK
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/15_btnViewSTNK'), FailureHandling.OPTIONAL)
			if (WebUI.verifyElementPresent(image1, 5, FailureHandling.OPTIONAL)) {
				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/02_btnOk'), FailureHandling.OPTIONAL)
				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/40_chkSTNK'))
			} else {
				String getErrTxtSTNK = WebUI.getText(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/16_msgErrText'), FailureHandling.OPTIONAL)
				KeywordUtil.logInfo('View STNK : ' +getErrTxtSTNK)
				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/04_btnOkFail'), FailureHandling.OPTIONAL)
			}

			WebUI.scrollToElement(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/17_btnViewBPKB'), 0, FailureHandling.OPTIONAL)
			//BPKB
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/17_btnViewBPKB'), FailureHandling.OPTIONAL)
			if (WebUI.verifyElementPresent(image1, 5, FailureHandling.OPTIONAL)) {
				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/02_btnOk'), FailureHandling.OPTIONAL)
				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/41_chkBPKB'))
			} else {
				String getErrTxtBPKB = WebUI.getText(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/16_msgErrText'), FailureHandling.OPTIONAL)
				KeywordUtil.logInfo(getErrTxtBPKB)
				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/04_btnOkFail'), FailureHandling.OPTIONAL)
			}

			//BPKP Halaman Belakang
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/18_btnViewBPKB2'), FailureHandling.OPTIONAL)
			if(WebUI.verifyElementPresent(image1, 5, FailureHandling.OPTIONAL)) {
				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/02_btnOk'))
				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/42_chkBPKB2'))
			} else {
				String getErrTxtBPKBHalamanBelakang = WebUI.getText(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/16_msgErrText'), FailureHandling.OPTIONAL)
				KeywordUtil.logInfo('View BPKP Halaman Belakang : ' +getErrTxtBPKBHalamanBelakang)
				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/04_btnOkFail'), FailureHandling.OPTIONAL)
			}

			//No Rangka
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/19_btnViewNoRangka'), FailureHandling.OPTIONAL)
			if(WebUI.verifyElementPresent(image1, 5, FailureHandling.OPTIONAL)) {
				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/02_btnOk'))
				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/43_chkNoRangka'))
			} else {
				String getErrTxtNoRangka = WebUI.getText(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/16_msgErrText'))
				KeywordUtil.logInfo('View No Rangka: ' +getErrTxtNoRangka)
				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/04_btnOkFail'), FailureHandling.OPTIONAL)
			}

			//No Mesin
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/20_btnViewNoMesin'),FailureHandling.OPTIONAL)
			if(WebUI.verifyElementPresent(image1, 5, FailureHandling.OPTIONAL)) {
				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/02_btnOk'))
				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/44_chkNoMesin'))
			} else {
				String getErrTxtNoMesin = WebUI.getText(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/16_msgErrText'), FailureHandling.OPTIONAL)
				KeywordUtil.logInfo('View No Mesin: ' +getErrTxtNoMesin)
				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/04_btnOkFail'), FailureHandling.OPTIONAL)
			}

			//Validasi No Customer
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/21_btnViewValidateCust'), FailureHandling.OPTIONAL)
			if(WebUI.verifyElementPresent(image1, 5, FailureHandling.OPTIONAL)) {
				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/02_btnOk'))
				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/45_chkValidasi'))
			} else {
				String getErrTxtValNoCust = WebUI.getText(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/16_msgErrText'))
				KeywordUtil.logInfo('View No Validasi Customer: ' +getErrTxtValNoCust)
				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/04_btnOkFail'), FailureHandling.OPTIONAL)
			}

		}

		'Contract Document'
		//PPK
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/Contract Document/01_btnViewPPK'), FailureHandling.OPTIONAL)
		if(WebUI.verifyElementVisible(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/02_btnOk'), FailureHandling.OPTIONAL)) {
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/02_btnOk'))
		} else {
			String getErrTxtPPK = WebUI.getText(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/16_msgErrText'), )
			KeywordUtil.logInfo('View PPK: ' +getErrTxtPPK)
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/04_btnOkFail'), )
		}

		//SKPJF
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/Contract Document/02_btnViewSKPJF'), FailureHandling.OPTIONAL)
		if(WebUI.verifyElementVisible(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/02_btnOk'), FailureHandling.OPTIONAL)) {
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/02_btnOk'))
		} else {
			String getErrTxtSKPJF = WebUI.getText(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/16_msgErrText'))
			KeywordUtil.logInfo('View SKPJF: ' +getErrTxtSKPJF)
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/04_btnOkFail'))
		}

		//SPSI
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/Contract Document/03_btnViewSPSI'), FailureHandling.OPTIONAL)
		if(WebUI.verifyElementVisible(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/02_btnOk'), FailureHandling.OPTIONAL)) {
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/02_btnOk'))
		} else {
			String getErrTxtSPSI = WebUI.getText(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/16_msgErrText'))
			KeywordUtil.logInfo('View SPSI: ' +getErrTxtSPSI)
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/04_btnOkFail'))
		}

		WebUI.scrollToElement(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/Contract Document/03_btnViewSPSI'), 0, FailureHandling.OPTIONAL)

		'DOCUMENT OPTIONAL'

		//Mendapatkan objek gambar
		TestObject image2 = findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/31_imgList')

		// Menentukan jumlah iterasi
		int numberIterasiQuestion2 = 1

		for (int i = 0; i < numberIterasiQuestion2; i++) {
			println("Iterasi Cek Gambar ke-" + (i + 1))

			//Kwitansi Jual Beli
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/22_btnViewKJB'))
			if(WebUI.verifyElementPresent(image2, 5, FailureHandling.OPTIONAL)) {
				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/02_btnOk'))
				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/46_chkKJBValid'))
			} else {
				String getErrTxtKJB = WebUI.getText(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/16_msgErrText'), FailureHandling.OPTIONAL)
				KeywordUtil.logInfo('View Kwitansi Jual Beli: ' +getErrTxtKJB)
				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/04_btnOkFail'), FailureHandling.OPTIONAL)
			}

			//Surat Pernyataan Konsumen
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/23_btnViewSPK'))
			if(WebUI.verifyElementPresent(image2, 5, FailureHandling.OPTIONAL)) {
				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/02_btnOk'))
				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/46_chkSPKValid'))
			} else {
				String getErrTxtSPK = WebUI.getText(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/16_msgErrText'), FailureHandling.OPTIONAL)
				KeywordUtil.logInfo('View Pernyataan Konsumen: ' +getErrTxtSPK)
				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/04_btnOkFail'), FailureHandling.OPTIONAL)
			}

			//Surat Pernyataan Transfer
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/24_btnViewSPT'))
			if(WebUI.verifyElementPresent(image2, 5, FailureHandling.OPTIONAL)) {
				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/02_btnOk'))
				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/47_chkSPTValid'))
			} else {
				String getErrTxtSPT = WebUI.getText(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/16_msgErrText'), FailureHandling.OPTIONAL)
				KeywordUtil.logInfo('View Pernyataan Transfer: ' +getErrTxtSPT)
				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/04_btnOkFail'), FailureHandling.OPTIONAL)
			}

			//Kwitansi Bukti Penggunaan Dana
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/48_btnViewKBPD'))
			if(WebUI.verifyElementPresent(image2, 5, FailureHandling.OPTIONAL)) {
				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/02_btnOk'))
				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/49_chkKBPD'))
			} else {
				String getErrTxtKBPD = WebUI.getText(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/16_msgErrText'), FailureHandling.OPTIONAL)
				KeywordUtil.logInfo('View Kwitansi Bukti Penggunaan Dana: ' +getErrTxtKBPD)
				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/04_btnOkFail'), FailureHandling.OPTIONAL)
			}

		}
		'KONFIRMASI PENGAJUAN PEMOHON'
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/Konfirmasi Pengajuan Pemohon/01_inpReachMobPhone'), mobilePhone)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/Konfirmasi Pengajuan Pemohon/02_inpReceiverName'), receiverName)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/Konfirmasi Pengajuan Pemohon/03_chkPhoneValid'))

		// Daftar pertanyaan beserta objek valid/invalid checkbox-nya
		if(RunConfiguration.getExecutionProfile()=='TEST') {
			//Pertanyaan ke 1
			if(WebUI.verifyElementPresent(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/List Pertanyaan/05_Qs01'), 5)) {
				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/List Pertanyaan/01_chkQs1Valid'))
			} else {
				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/List Pertanyaan/02_chkQs1Invalid'), FailureHandling.OPTIONAL)
			}

			//Pertanyaan ke 2
			if(WebUI.verifyElementPresent(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/List Pertanyaan/06_Qs02'), 5)) {
				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/List Pertanyaan/03_chkQs2Valid'))
			} else {
				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/List Pertanyaan/04_chkQs2Invalid'), FailureHandling.OPTIONAL)
			}

			//Pertanyaan ke 3
			if(WebUI.verifyElementPresent(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/List Pertanyaan/07_Qs03'), 5)) {
				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/List Pertanyaan/11_chkQs03Valid'))
			} else {
				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/List Pertanyaan/12_chkQs03Invalid'), FailureHandling.OPTIONAL)
			}

			//Pertanyaan ke 4
			if(WebUI.verifyElementPresent(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/List Pertanyaan/08_Qs04'), 5)) {
				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/List Pertanyaan/13_chkQs04Valid'))
			} else {
				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/List Pertanyaan/14_chkQs04Invalid'), FailureHandling.OPTIONAL)
			}

			//Pertanyaan ke 5
			if(WebUI.verifyElementPresent(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/List Pertanyaan/09_Qs05'), 5)) {
				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/List Pertanyaan/15_chkQs05Valid'))
			} else {
				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/List Pertanyaan/16_chkQs05Invalid'), FailureHandling.OPTIONAL)
			}

			//Pertanyaan ke 6
			if(WebUI.verifyElementPresent(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/List Pertanyaan/10_Qs06'), 5)) {
				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/List Pertanyaan/17_chkQs06Valid'))
			} else {
				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/List Pertanyaan/18_chkQs06Invalid'), FailureHandling.OPTIONAL)
			}
		} else {
			//Pertanyaan ke 1
			if(WebUI.verifyElementPresent(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/List Pertanyaan/05_Qs01'), 5)) {
				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/UAT/List Pertanyaan/01_chkQs01Valid'))
			} else {
				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/UAT/List Pertanyaan/02_chkQs01Invalid'), FailureHandling.OPTIONAL)
			}

			//Pertanyaan ke 2
			if(WebUI.verifyElementPresent(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/List Pertanyaan/06_Qs02'), 5)) {
				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/UAT/List Pertanyaan/03_chkQs02Valid'))
			} else {
				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/UAT/List Pertanyaan/04_chkQs02Invalid'), FailureHandling.OPTIONAL)
			}

			//Pertanyaan ke 3
			if(WebUI.verifyElementPresent(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/List Pertanyaan/07_Qs03'), 5)) {
				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/UAT/List Pertanyaan/05_chkQs03Valid'))
			} else {
				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/UAT/List Pertanyaan/06_chkQs03Invalid'), FailureHandling.OPTIONAL)
			}

			//Pertanyaan ke 4
			if(WebUI.verifyElementPresent(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/List Pertanyaan/08_Qs04'), 5)) {
				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/UAT/List Pertanyaan/07_chkQs04Valid'))
			} else {
				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/UAT/List Pertanyaan/08_chkQs04Invalid'), FailureHandling.OPTIONAL)
			}

			//Pertanyaan ke 5
			if(WebUI.verifyElementPresent(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/List Pertanyaan/09_Qs05'), 5)) {
				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/UAT/List Pertanyaan/09_chkQs05Valid'))
			} else {
				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/UAT/List Pertanyaan/10_chkQs05Invalid'), FailureHandling.OPTIONAL)
			}

			//Pertanyaan ke 6
			if(WebUI.verifyElementPresent(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/List Pertanyaan/10_Qs06'), 5)) {
				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/UAT/List Pertanyaan/11_chkQs06Valid'))
			} else {
				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/UAT/List Pertanyaan/12_chkQs06Invalid'), FailureHandling.OPTIONAL)
			}

		}


	}
	@Keyword
	def submitDataFormDisbursementChecklistSystem(String commentRevise, String commentCAP, String teksOrder, String tabMenu) {
		WebUI.scrollToElement(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/22_btnViewKJB'), 0)
		//Comment CAP
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/25_txtCommentCAP'), commentCAP)
		//Save
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/28_btnSave'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/29_btnYes'))
		if(WebUI.verifyElementPresent(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/16_msgErrText'), 4)) {
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/27_btnOkFailAlert'))
		}
		//Cek orderNumber
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/05_chkNoOrderUncheck',[('teksOrder'): teksOrder]))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/15_btnDetail',[('teksOrder'): teksOrder]))
		//Click Disbursement Checklist System
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/17_spanByTxtDynamic',[('text'): tabMenu]))

		WebUI.scrollToElement(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/22_btnViewKJB'), 0)

		//Submit
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/26_btnSubmit'), FailureHandling.OPTIONAL)
		WebUI.waitForPageLoad(30)
		if(WebUI.verifyElementVisible(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/16_msgErrText'), FailureHandling.OPTIONAL)) {
			String getErrTxtMandatoryField = WebUI.getText(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/16_msgErrText'))
			KeywordUtil.logInfo(getErrTxtMandatoryField)
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/UAT/03_btnYesSubmit'))
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/Disbursement Checklist Customer/27_btnOkFailAlert'), FailureHandling.OPTIONAL)
		}

	}


	@Keyword
	def formGenerateARSingle(String companyID, String businessUnit, String branch, String invoiceDateFrom, String invoiceDateTo, String teksOrder) {
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/01_btnCompany'))
		WebUI.acceptAlert(FailureHandling.OPTIONAL)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/16_fldOccupation'), companyID)
		WebUI.acceptAlert(FailureHandling.OPTIONAL)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/21_btnFind'))
		WebUI.acceptAlert(FailureHandling.OPTIONAL)
		WebUI.waitForPageLoad(2)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/01_Order/2_businessUnit/01_cbBUCode', [('businessUnit') : companyID]))
		WebUI.acceptAlert(FailureHandling.OPTIONAL)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/02_btnBusinessId'))
		WebUI.acceptAlert(FailureHandling.OPTIONAL)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/16_fldOccupation'), businessUnit)
		WebUI.acceptAlert(FailureHandling.OPTIONAL)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/21_btnFind'))
		WebUI.acceptAlert(FailureHandling.OPTIONAL)
		WebUI.waitForPageLoad(2)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/01_Order/2_businessUnit/01_cbBUCode', [('businessUnit') : businessUnit]))
		WebUI.acceptAlert(FailureHandling.OPTIONAL)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/04_chkWithHierarchy'))
		WebUI.acceptAlert(FailureHandling.OPTIONAL)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/07_fldInvoiceDateFrom'), invoiceDateFrom)
		WebUI.acceptAlert(FailureHandling.OPTIONAL)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/08_fldInvoiceDateTo'), invoiceDateTo)
		WebUI.acceptAlert(FailureHandling.OPTIONAL)
		WebUI.delay(2)
		WebUI.focus(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/09_btnFind'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/09_btnFind'))
		WebUI.acceptAlert(FailureHandling.OPTIONAL)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/11_chkNoOrder',[('teksOrder') : teksOrder]))
		WebUI.acceptAlert(FailureHandling.OPTIONAL)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Generate AR Test Object/10_btnGenerateAR'))
		WebUI.waitForPageLoad(50)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Test Object/11_btnOk'))
		WebUI.acceptAlert(FailureHandling.OPTIONAL)
	}
}
