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
import com.kms.katalon.core.webui.keyword.internal.WebUIAbstractKeyword
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.kms.katalon.core.configuration.RunConfiguration
import internal.GlobalVariable
import java.nio.file.Path
import java.nio.file.Paths
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.webui.driver.DriverFactory

public class submitClop {
	@Keyword
	def goToMenuClop() {
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/BM Dashboard Test Object/07_btnNewIndividual'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/01_btnClop'))
	}

	@Keyword
	def formClop(String noContract, String noAppraisal, String flagClop, String ojk) {
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/02_btnCheckContract'))
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/03_fldLastContractNumber'), noContract)
		WebUI.delay(1)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/04_btnCheckContractForm'))
		if(WebUI.verifyElementPresent(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/21_dlgContractNotFound'), 1,FailureHandling.OPTIONAL) ||
		WebUI.verifyElementPresent(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/24_dlgContractNonCLOP'), 1,FailureHandling.OPTIONAL) ) {
			GlobalVariable.FIND_CONTRACT = 'false'
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/22_btnOKMessageBox'))
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/23_btnCancelContract'))
		}else {
			GlobalVariable.FIND_CONTRACT = 'true'
			WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/05_txtAppraisalNumber'), noAppraisal)
			WebUI.delay(1)
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/06_btnCheckAppraisalForm'))
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Test Object/11_btnOk'))

			if(WebUI.verifyElementPresent(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/19_dlg_HapusZipCodeSubZipCode'),3, FailureHandling.OPTIONAL)) {
				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/20_btnYesHapusZipcode'))
			}
			WebUI.delay(1)
			if(WebUI.verifyElementClickable(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/07_cbFlag'), FailureHandling.OPTIONAL)) {
				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/07_cbFlag'))
				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/08_cbFlagClop', [('flagClop') : flagClop]))
			} else {
				KeywordUtil.logInfo('Flag CLOP tidak clickable')
			}

			//WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/25_cbTransferPolis'), Keys.chord(Keys.DOWN, Keys.ENTER, ))
			WebUI.waitForPageLoad(2)
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/08_fldOjk'))
			WebUI.delay(1)
			WebUI.acceptAlert(FailureHandling.OPTIONAL)
			WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/16_fldOccupation'), ojk)
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/21_btnFind'))
			WebUI.waitForPageLoad(2)

			//		boolean noOrderPresent = WebUI.verifyElementPresent(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/13_dlgAlertPopUpHarusDiisi'), 1, FailureHandling.OPTIONAL)
			//		if(noOrderPresent) {
			//			WebUI.waitForPageLoad(2)
			//			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/08_fldOjk'))
			//			WebUI.delay(1)
			//			WebUI.acceptAlert(FailureHandling.OPTIONAL)
			//			WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/16_fldOccupation'), ojk)
			//			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/21_btnFind'))
			//			WebUI.waitForPageLoad(2)
			//		}else {
			//			println('Continue')
			//		}

			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/01_Order/2_businessUnit/01_cbBUCode', [('businessUnit') : ojk]))
			WebUI.waitForPageLoad(2)
		}
	}

	@Keyword
	def updateCustomerInfo(String occupationOnId, String occupation, String subOccupation, String wp) {
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/Update Customer Data Test Object/01_btnUpdate'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/Update Customer Data Test Object/02_fldOccupationId'))
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/04_fldBankName'), occupationOnId)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/21_btnFind'))
		WebUI.waitForPageLoad(2)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/10_btnDataFirst'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/02_custInfo/12_Occupation/01_cbOccupation'))
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/04_fldBankName'), occupation)
		//WebUI.delay(1)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/21_btnFind'))
		//WebUI.waitForPageLoad(2)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/10_btnDataFirst'))
		//WebUI.waitForPageLoad(10)
		if(occupation == 'WIRASWASTA' || occupation == 'TIDAK TETAP' || occupation == 'LIMBAH' || occupation == 'PENGOBATAN ALTERNATIF') {
			KeywordUtil.logInfo('Occupation = '+ occupation)
		} else {
			//WebUI.delay(1)
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/11_btnSubOccupation'))
			//WebUI.delay(1)
			WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/04_fldBankName'), subOccupation)
			//WebUI.delay(1)
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/21_btnFind'))
			//WebUI.delay(1)
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/10_btnDataFirst'))
			//WebUI.waitForPageLoad(10)
		}
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/02_custInfo/13_workingPeriod/01_fldWorkingPeriodY'), wp)
		WebUI.delay(1)
		WebUI.acceptAlert(FailureHandling.OPTIONAL)
		WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/02_custInfo/13_workingPeriod/01_fldWorkingPeriodY'), Keys.chord(Keys.TAB))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/12_cbmonthPeriodeWork'))
		WebUI.waitForPageLoad(10)
		WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/12_cbmonthPeriodeWork'), Keys.chord(Keys.DOWN))
		WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/12_cbmonthPeriodeWork'), Keys.chord(Keys.DOWN))
		WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/12_cbmonthPeriodeWork'), Keys.chord(Keys.DOWN))
		WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/12_cbmonthPeriodeWork'), Keys.chord(Keys.ENTER))

		//		WebUI.focus(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/13_cbVarMonthPeriodeWork', [('wpm') : wpm]))
		//		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/13_cbVarMonthPeriodeWork', [('wpm') : wpm]))
		//		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/12_cbmonthPeriodeWork'))
		//		WebUI.delay(1)
		//		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/Update Customer Data Test Object/12_fldVarMonthPeriode', [('wpm') : wpm]))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/Update Customer Data Test Object/02_fldOccupationId'))
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/04_fldBankName'), occupationOnId)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/21_btnFind'))
		WebUI.waitForPageLoad(2)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/10_btnDataFirst'))
	}

	@Keyword
	def detailCustomer(String stnkValidUntil, String colour, String amountTransfer, String amountCredit, String installment,
			String officeLine1,	String officeLine2, String officeLine3, String occupationOnId) {
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/Update Customer Data Test Object/04_btnDetail'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/06_btnCheckAppraisalForm'))
		if(WebUI.verifyElementChecked(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/Update Customer Data Test Object/05_cbBPKBAsSameKTP'), 2, FailureHandling.OPTIONAL)) {
			KeywordUtil.logInfo('BPBK sudah terceklis')
		} else {
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/Update Customer Data Test Object/05_cbBPKBAsSameKTP'))
		}
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/Update Customer Data Test Object/06_fldUnitAvailable'))
		WebUI.delay(1)
		WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/Update Customer Data Test Object/06_fldUnitAvailable'), Keys.chord(Keys.DOWN))
		WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/Update Customer Data Test Object/06_fldUnitAvailable'), Keys.chord(Keys.ENTER))
		WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/Update Customer Data Test Object/08_fldSTNKValidUntil'), stnkValidUntil)
		//		if(WebUI.verifyElementVisible(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/17_fldColour'), FailureHandling.OPTIONAL)) {
		//			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/17_fldColour'))
		//			WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/04_fldBankName'), colour)
		//			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/21_btnFind'))
		//			WebUI.waitForPageLoad(2)
		//			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/10_btnDataFirst'))
		//		} else {
		//			KeywordUtil.logInfo('Tidak Muncul Colour')
		//		}
		WebUI.clearText(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/Update Customer Data Test Object/09_fldTransfer'))
		WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/Update Customer Data Test Object/09_fldTransfer'), amountTransfer)
		WebUI.clearText(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/Update Customer Data Test Object/10_fldAmountCredit'))
		WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/Update Customer Data Test Object/10_fldAmountCredit'), amountCredit)
		WebUI.clearText(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/Update Customer Data Test Object/21_fldInstallment'))
		WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/Update Customer Data Test Object/21_fldInstallment'), installment)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Test Object/11_btnOk'))

		if(WebUI.verifyElementChecked(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/Update Customer Data Test Object/13_chkPrimaryFirst'), 2, FailureHandling.OPTIONAL)) {
			KeywordUtil.logInfo('Nomor Pertama Sudah Checklist')
		} else {
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/Update Customer Data Test Object/13_chkPrimaryFirst'))
		}
		if(WebUI.verifyElementChecked(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/03_addrVerification/2_contactInfo/06_chkPrimary'), 2, FailureHandling.OPTIONAL)) {
			KeywordUtil.logInfo('Nomor Kedua Sudah Checklist')
		} else {
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/03_addrVerification/2_contactInfo/06_chkPrimary'))
		}
		if(WebUI.verifyElementPresent(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/Update Customer Data Test Object/15_lblOfficeFixedLine'), 2, FailureHandling.OPTIONAL)) {
			WebUI.clearText(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/Update Customer Data Test Object/16_fldOfficeLine1'))
			WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/Update Customer Data Test Object/16_fldOfficeLine1'), officeLine1)
			WebUI.clearText(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/Update Customer Data Test Object/17_fldOfficeLine2'))
			WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/Update Customer Data Test Object/17_fldOfficeLine2'), officeLine2)
			WebUI.clearText(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/Update Customer Data Test Object/18_fldOfficeLine3'))
			WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/Update Customer Data Test Object/18_fldOfficeLine3'), officeLine3)
			if(WebUI.verifyElementChecked(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/Update Customer Data Test Object/19_chkPrimaryThird'), 2, FailureHandling.OPTIONAL)) {
				KeywordUtil.logInfo('Nomor Ketiga Sudah Checklist')
			} else {
				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/Update Customer Data Test Object/19_chkPrimaryThird'))
			}
		} else {
			KeywordUtil.logInfo('Nomor Kedua Sudah Checklist')
		}
		WebUI.waitForPageLoad(50)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/Update Customer Data Test Object/02_fldOccupationId'))
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/04_fldBankName'), occupationOnId)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/21_btnFind'))
		WebUI.waitForPageLoad(2)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/10_btnDataFirst'))
	}

	@Keyword
	def detailCustomerCLOP(String dealerId, String stnkValidUntil, String colour, String amountTransfer, String amountCredit, String installment,
			String officeLine1,	String officeLine2, String email, String kodePos, String kodePos2, String rt, String rw, String address) {
		//Set Object Info
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/Update Customer Data Test Object/04_btnDetail'))
		WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/1_tenor/0_objFinance/03_fldDealer'), Keys.chord(Keys.CONTROL, 'a'))
		WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/1_tenor/0_objFinance/03_fldDealer'), Keys.chord(Keys.DELETE))

		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/1_tenor/0_objFinance/03_fldDealer'), dealerId)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/06_btnCheckAppraisalForm'))
		if(WebUI.verifyElementChecked(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/Update Customer Data Test Object/05_cbBPKBAsSameKTP'), 2, FailureHandling.OPTIONAL)) {
			KeywordUtil.logInfo('BPKB sudah terceklis')
		} else {
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/Update Customer Data Test Object/05_cbBPKBAsSameKTP'))
		}
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/Update Customer Data Test Object/06_fldUnitAvailable'))
		WebUI.delay(1)
		WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/Update Customer Data Test Object/06_fldUnitAvailable'), Keys.chord(Keys.DOWN))
		WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/Update Customer Data Test Object/06_fldUnitAvailable'), Keys.chord(Keys.ENTER))
		WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/Update Customer Data Test Object/08_fldSTNKValidUntil'), stnkValidUntil)
		if(WebUI.verifyElementClickable(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/1_tenor/1_autoInvoice/01_btnColor'), FailureHandling.OPTIONAL)) {
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/1_tenor/1_autoInvoice/01_btnColor'))
			WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/16_fldOccupation'), colour)
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/21_btnFind'))
			WebUI.waitForPageLoad(2)
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/10_btnDataFirst'))
			WebUI.waitForPageLoad(2)
		}

		WebUI.clearText(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/Update Customer Data Test Object/09_fldTransfer'))
		WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/Update Customer Data Test Object/09_fldTransfer'), amountTransfer)
		WebUI.clearText(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/Update Customer Data Test Object/10_fldAmountCredit'))
		WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/Update Customer Data Test Object/10_fldAmountCredit'), amountCredit)
		WebUI.clearText(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/Update Customer Data Test Object/21_fldInstallment'))
		WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/Update Customer Data Test Object/21_fldInstallment'), installment)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Test Object/11_btnOk'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/22_btnOKMessageBox'), FailureHandling.OPTIONAL)
		//Set Address
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/03_addrVerification/1_addressDetail/02_fldAddress'), address)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/24_btnOKMailbox'),FailureHandling.OPTIONAL)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/03_addrVerification/1_addressDetail/03_fldRT'), rt)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/24_btnOKMailbox'),FailureHandling.OPTIONAL)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/03_addrVerification/1_addressDetail/04_fldRW'), rw)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/24_btnOKMailbox'),FailureHandling.OPTIONAL)

		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/03_addrVerification/1_addressDetail/11_cbZipCode'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/24_btnOKMailbox'),FailureHandling.OPTIONAL)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/16_fldOccupation'), kodePos)
		WebUI.delay(1)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/21_btnFind'))
		WebUI.waitForPageLoad(2)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/19_lblFirstData'))
		//			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/01_Order/2_businessUnit/03_cbZipCode', [('businessUnit') : kodePos2]))
		WebUI.waitForPageLoad(2)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/03_addrVerification/1_addressDetail/09_cbSubZipCode'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/10_btnFind'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/03_addrVerification/1_addressDetail/05_btnDataFirstSubZipCode'))
		//		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/03_addrVerification/1_addressDetail/10_fldSubZipCodeCode', [('subkodepos') : kodePos2]))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/24_btnOKMailbox'),FailureHandling.OPTIONAL)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/03_addrVerification/1_addressDetail/07_cbHouseStatus'))
		WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/03_addrVerification/1_addressDetail/08_cbHouseStatus2'), Keys.chord(Keys.DOWN, Keys.ENTER))
		while(WebUI.verifyElementAttributeValue(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/03_addrVerification/1_addressDetail/02_fldAddress'),'value','',3,FailureHandling.OPTIONAL)) {
			//				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/24_btnOKMailbox'),FailureHandling.OPTIONAL)
			WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/03_addrVerification/1_addressDetail/02_fldAddress'), address)
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/24_btnOKMailbox'),FailureHandling.OPTIONAL)
		}
		//Set Contact Info
		//Set MOBILEPHONE1
		if(WebUI.verifyElementPresent(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/Update Customer Data Test Object/26_fldValueMOBILEPHONE1'), 1, FailureHandling.OPTIONAL)) {
			WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/Update Customer Data Test Object/26_fldValueMOBILEPHONE1'), officeLine1)
			WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/Update Customer Data Test Object/26_fldValueMOBILEPHONE1'),  Keys.chord(Keys.TAB))

			if(WebUI.verifyElementNotChecked(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/Update Customer Data Test Object/25_chkPrimaryMOBILEPHONE1'), 3,  FailureHandling.OPTIONAL)) {
				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/Update Customer Data Test Object/25_chkPrimaryMOBILEPHONE1'))
			}
		}
		//Set MOBILEPHONE2
		if(WebUI.verifyElementPresent(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/Update Customer Data Test Object/27_fldValueMOBILEPHONE2'), 1, FailureHandling.OPTIONAL)) {
			WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/Update Customer Data Test Object/27_fldValueMOBILEPHONE2'), officeLine2)
			WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/Update Customer Data Test Object/27_fldValueMOBILEPHONE2'), Keys.chord(Keys.TAB))
			if(WebUI.verifyElementNotChecked(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/Update Customer Data Test Object/24_chkPrimaryMOBILEPHONE2'), 3,  FailureHandling.OPTIONAL)) {
				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/Update Customer Data Test Object/24_chkPrimaryMOBILEPHONE2'))
			}
		}
		//Set EMAIL
		if(WebUI.verifyElementPresent(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/Update Customer Data Test Object/29_fldEMAIL'), 1, FailureHandling.OPTIONAL)) {
			WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/Update Customer Data Test Object/29_fldEMAIL'), email)
			WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/Update Customer Data Test Object/29_fldEMAIL'), Keys.chord(Keys.TAB))

		}
		//Set FAX
		if(WebUI.verifyElementPresent(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/Update Customer Data Test Object/30_fldFAX'), 1, FailureHandling.OPTIONAL)) {
			WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/Update Customer Data Test Object/30_fldFAX'), '021')
			WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/Update Customer Data Test Object/30_fldFAX'), Keys.chord(Keys.TAB))
			WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/Update Customer Data Test Object/36_fldFAX2'), '1122334')
			WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/Update Customer Data Test Object/36_fldFAX2'), Keys.chord(Keys.TAB))

		}
		//Set HOUSE FIXED LINE
		if(WebUI.verifyElementPresent(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/Update Customer Data Test Object/28_fldHOUSEFIXEDLINE'), 1, FailureHandling.OPTIONAL)) {
			WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/Update Customer Data Test Object/28_fldHOUSEFIXEDLINE'), '021')
			WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/Update Customer Data Test Object/28_fldHOUSEFIXEDLINE'), Keys.chord(Keys.TAB))
			WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/Update Customer Data Test Object/37_fldHOUSEFIXEDLINE2'), '1122334')
			WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/Update Customer Data Test Object/37_fldHOUSEFIXEDLINE2'), Keys.chord(Keys.TAB))

		}
		//Set OFFICE FIXED LINE
		if(WebUI.verifyElementPresent(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/Update Customer Data Test Object/31_fldOFFICEFIXEDLINE'), 1, FailureHandling.OPTIONAL)) {
			WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/Update Customer Data Test Object/31_fldOFFICEFIXEDLINE'), '021')
			WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/Update Customer Data Test Object/31_fldOFFICEFIXEDLINE'), Keys.chord(Keys.TAB))
			WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/Update Customer Data Test Object/38_fldOFFICEFIXEDLINE2'), '11223')
			WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/Update Customer Data Test Object/38_fldOFFICEFIXEDLINE2'), Keys.chord(Keys.TAB))
			WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/Update Customer Data Test Object/39_fldOFFICEFIXEDLINE3'), '5170')
			WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/Update Customer Data Test Object/39_fldOFFICEFIXEDLINE3'), Keys.chord(Keys.TAB))

		}
	}

	@Keyword
	def promo(String calculationMethod , String promo) {
		if(calculationMethod == 'DECLINE') {
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/14_fldInstallmentCalcMethod'))
			WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/14_fldInstallmentCalcMethod'), Keys.chord(Keys.DOWN, Keys.ENTER))
		} else if(calculationMethod == 'ANNUITY') {
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/14_fldInstallmentCalcMethod'))
			WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/14_fldInstallmentCalcMethod'), Keys.chord(Keys.DOWN, Keys.DOWN, Keys.ENTER))
		} else if(calculationMethod == 'NEW DECLINE (IRREGULAR CASHFLOW)') {
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/14_fldInstallmentCalcMethod'))
			WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/14_fldInstallmentCalcMethod'), Keys.chord(Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.ENTER))
		} else if(calculationMethod == 'BASED ON CUSTOMER CASHFLOW') {
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/14_fldInstallmentCalcMethod'))
			WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/14_fldInstallmentCalcMethod'), Keys.chord(Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.ENTER))
		} else if(calculationMethod == 'BALLOON') {
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/14_fldInstallmentCalcMethod'))
			WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/14_fldInstallmentCalcMethod'), Keys.chord(Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.ENTER))
		} else if(calculationMethod == 'FIXED PRINCIPAL') {
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/14_fldInstallmentCalcMethod'))
			WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/14_fldInstallmentCalcMethod'), Keys.chord(Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.ENTER))
		} else if(calculationMethod == 'STEP UP (BASED ON O/S PRINCIPAL)') {
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/14_fldInstallmentCalcMethod'))
			WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/14_fldInstallmentCalcMethod'), Keys.chord(Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.ENTER))
		} else if(calculationMethod == 'STEP DOWN (BASED ON O/S PRINCIPAL)') {
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/14_fldInstallmentCalcMethod'))
			WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/14_fldInstallmentCalcMethod'), Keys.chord(Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.ENTER))
		} else if(calculationMethod == 'CUSTOM BALLOON') {
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/14_fldInstallmentCalcMethod'))
			WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/14_fldInstallmentCalcMethod'), Keys.chord(Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.ENTER))
		} else if(calculationMethod == 'SEASONAL') {
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/14_fldInstallmentCalcMethod'))
			WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/14_fldInstallmentCalcMethod'), Keys.chord(Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.ENTER))
		}
		//		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/1_tenor/1_autoInvoice/16_cbVarCalculationMethod', [('calculationMethod') : calculationMethod]))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/15_cbFrequency'))
		WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/15_cbFrequency'), Keys.chord(Keys.ARROW_UP))
		WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/15_cbFrequency'), Keys.chord(Keys.ENTER))
		//WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/16_cbFirstSelectFrequency'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/17_btnSecondFreq'))
		//WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/18_cbSecondFreq'))
		WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/17_btnSecondFreq'), Keys.chord(Keys.ARROW_UP))
		WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/17_btnSecondFreq'), Keys.chord(Keys.ENTER))
		if(promo == 'Yes') {
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/1_tenor/1_autoInvoice/12_chkCheckedPromo'))
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/1_tenor/1_autoInvoice/19_btnPromo'))
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/21_btnFind'))
			WebUI.waitForPageLoad(2)
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/10_btnDataFirst'))
		} else {
			KeywordUtil.logInfo('Tidak memilih promo')
		}
	}

	@Keyword
	def submitData(String occupationOnId) {
		WebUI.waitForPageLoad(50)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/Update Customer Data Test Object/02_fldOccupationId'))
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/04_fldBankName'), occupationOnId)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/21_btnFind'))
		WebUI.waitForPageLoad(2)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/10_btnDataFirst'))
		WebUI.waitForPageLoad(60)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/12_btnSubmit'))

		TestObject linkObject = findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/21_lblOccupatioOnId_Status')
		List<WebElement> elements = WebUI.findWebElements(linkObject, 10)
		println(elements)
		def counter = 0
		def isYesAfterSubmit = WebUI.verifyElementPresent(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/13_btnYesSaveData'), 2, FailureHandling.OPTIONAL)
		while(counter < elements.size()) {
			if(isYesAfterSubmit ==  false)
			{
				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/Update Customer Data Test Object/02_fldOccupationId'))
				WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/04_fldBankName'), occupationOnId)
				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/21_btnFind'))
				WebUI.waitForPageLoad(2)
				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/10_btnDataFirst'))
				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/12_btnSubmit'))
				break
			} else {
				println("Kondisi tidak terpenuhi, lanjutkan looping")
			}
			counter++

		}

		//		def someCondition() {
		//			// Implementasikan kondisi sesuai kebutuhan
		//			// Misalnya, kembalikan true jika kondisi terpenuhi, false jika tidak
		//			return counter == 2
		//		}

		//		for (int i = 0;  i < elements.size(); ++i) {
		//
		//		}

		WebUI.waitForPageLoad(60)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/13_btnYesSaveData'))
		WebUI.waitForPageLoad(60)
		if(WebUI.verifyElementVisible(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/18_dlgBlacklist'), FailureHandling.OPTIONAL)) {
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/11_btnOkInformation'))
		} else {
			KeywordUtil.logInfo('Tidak Muncul Blacklist')
		}
		WebUI.waitForPageLoad(60)
		if(WebUI.verifyElementVisible(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/16_dlgCustMemilikiOrder'), FailureHandling.OPTIONAL)) {
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/13_btnYesSaveData'))
		} else {
			KeywordUtil.logInfo('Tidak Muncul Button Yes')
		}
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/11_btnOkInformation'))
		WebUI.waitForPageLoad(60)
		if(WebUI.verifyElementVisible(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/27_lblGetTextOrder'), FailureHandling.OPTIONAL)) {
			String teksOrder = WebUI.getText(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/27_lblGetTextOrder')).replaceAll("[^0-9.]", "")
			GlobalVariable.teksOrder = teksOrder
			KeywordUtil.logInfo('Nomor Order : ' + GlobalVariable.teksOrder)
		} else {
			KeywordUtil.logInfo('No Order Gagal Didapatkan')
		}
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/11_btnOkInformation'))
		WebUI.delay(3)
	}

	@Keyword
	def submitDataCLOP ( String ojk, String occupationonId, String occupation, String subOccupation) {
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/12_btnSubmit'))
		WebUI.waitForPageLoad(60)
		while(WebUI.verifyElementPresent(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/15_dlgMsgValidasi'), 1, FailureHandling.OPTIONAL)) {
			//input ojk
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/08_fldOjk'))
			WebUI.delay(1)
			WebUI.acceptAlert(FailureHandling.OPTIONAL)
			WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/16_fldOccupation'), ojk)
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/21_btnFind'))
			WebUI.waitForPageLoad(2)
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/01_Order/2_businessUnit/01_cbBUCode', [('businessUnit') : ojk]))
			WebUI.waitForPageLoad(2)
			//Occupation
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/02_custInfo/12_Occupation/01_cbOccupation'))
			WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/04_fldBankName'), occupation)

			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/21_btnFind'))
			//WebUI.waitForPageLoad(2)
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/10_btnDataFirst'))
			//Sub Occupation
			if(occupation == 'WIRASWASTA' || occupation == 'TIDAK TETAP' || occupation == 'LIMBAH' || occupation == 'PENGOBATAN ALTERNATIF') {
				KeywordUtil.logInfo('Occupation = '+ occupation)
			} else {
				//WebUI.delay(1)
				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/11_btnSubOccupation'))
				//WebUI.delay(1)
				WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/04_fldBankName'), subOccupation)
				//WebUI.delay(1)
				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/21_btnFind'))
				//WebUI.delay(1)
				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/10_btnDataFirst'))
				//WebUI.waitForPageLoad(10)
			}

			//input Occupation ID
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/12_btnOccoOnI'))
			WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/04_fldBankName'), occupationonId)
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/21_btnFind'))
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/10_btnDataFirst'))

			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/12_btnSubmit'))
			//			WebUI.waitForPageLoad(60)
		}
		WebUI.takeScreenshot()
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/13_btnYesSaveData'))
		WebUI.waitForPageLoad(60)
		String failedRepo = 'Failed upload document to Repository'
		String rejectRecom = 'get Reject treatment recommendation'
		if(WebUI.verifyElementVisible(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/09_Update/01_dlgRejectTreatment', [('message') : failedRepo] ), FailureHandling.OPTIONAL)) {
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/11_btnOkInformation'))

		}

		if(WebUI.verifyElementVisible(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/09_Update/01_dlgRejectTreatment', [('message') : rejectRecom] ), FailureHandling.OPTIONAL)) {
			String orderStatusText = WebUI.getText(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/17_dlgTextAfterBtnYesSaveData'), FailureHandling.OPTIONAL)
			// Definisikan pola ekspresi reguler untuk mencocokkan Order id dan Customer number
			def orderIdPattern = /Order id (\d+)/
			def customerNumberPattern = /Customer number (\d+)/
			// Cari kecocokan pola dalam pesan
			def orderIdMatcher = (orderStatusText =~ orderIdPattern)
			def customerNumberMatcher = (orderStatusText =~ customerNumberPattern)
			// Jika ada kecocokan, ambil Order id dan Customer number
			def orderId = orderIdMatcher.find() ? orderIdMatcher.group(1) : "Tidak ditemukan"
			def customerNumber = customerNumberMatcher.find() ? customerNumberMatcher.group(1) : "Tidak ditemukan"
			GlobalVariable.ORDER_ID = orderId
			GlobalVariable.CUSTOMER_NUMBER = customerNumber
			KeywordUtil.logInfo("Order ID: "+GlobalVariable.ORDER_ID)
			KeywordUtil.logInfo("Customer Number: "+GlobalVariable.CUSTOMER_NUMBER)

			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/11_btnOkInformation'))
		} else {
			KeywordUtil.logInfo('Tidak Muncul Reject Treatment')
			//				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/11_btnOkInformation'))
		}

		//		WebUI.waitForPageLoad(60)
		//		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/11_btnOkInformation'), FailureHandling.OPTIONAL)
		String teksOrder = WebUI.getText(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/18_dlgSuccessInitialOrder',)).replaceAll("[^0-9]", "")
		GlobalVariable.teksOrder = teksOrder
		KeywordUtil.logInfo('Nomor Order : ' + GlobalVariable.teksOrder)
		WebUI.waitForPageLoad(60)

	}
	@Keyword
	def addDocument(String ktp) {
		// Define the file path relative to the project directory
		String filePath = '/Data Files/ktp testing.jpeg'

		// Concatenate the file path with the project directory
		String jpgFile = RunConfiguration.getProjectDir() + filePath

		WebUI.waitForPageLoad(10)
		WebUI.delay(1)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/07_documentChecklist/04_btnDocChecklist'))
		WebUI.waitForPageLoad(10)
		WebUI.click(findTestObject('FIFCORE Test Object/Initial Order Test Object/07_documentChecklist/06_chkDocNameKTP'))
		WebUI.waitForPageLoad(10)
		WebUI.click(findTestObject('FIFCORE Test Object/Initial Order Test Object/07_documentChecklist/09_fldUploadDocKTP'))
		WebUI.waitForPageLoad(10)
		WebUI.uploadFile(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/18_fldUploadDoc'), jpgFile)
		//		utilities.uploadFile(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/26_btnVarBtnBrowse'), jpgFile)
		WebUI.delay(2)
		WebUI.waitForPageLoad(10)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/07_documentChecklist/01_btnOk'))
		WebUI.waitForPageLoad(10)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/07_documentChecklist/02_btnOkUpload'))
		WebUI.waitForPageLoad(10)
	}

	@Keyword
	def submitStrukturUFIUpdate(String installment, String frequencyMonth, String frequencyNumber, String calculatedBy, String interestFlat,
			String interestEffective, String grossAdmin, String advanceArrear, String paymentMethod, String receiveBank, String bankName,
			String accountName, String accountNumber) {
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
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/15_fldGrossAdmin'), grossAdmin)
		WebUI.selectOptionByLabel(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/09_cbAdvanceArrear'), advanceArrear, false)
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
	def submitMS(String schemeCode) {
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/12_btnAddMS'))
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/13_fldSchemeCode',['addRow' : x]), schemeCode)
	}

	@Keyword
	def submitOrderUFI(String commentInterest) {
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/11_btnSubmit'))
		WebUI.waitForPageLoad(100)
		if(WebUI.verifyElementVisible(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Test Object/11_btnOk'), FailureHandling.OPTIONAL)) {
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Test Object/11_btnOk'))
			WebUI.waitForPageLoad(100)
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/11_btnSubmit'))
		} else {
			KeywordUtil.logInfo('Tidak Muncul Button OK')
		}
		WebUI.waitForPageLoad(100)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/13_btnYesSaveData'))
		WebUI.waitForPageLoad(100)
		boolean interestTidakSesuai = WebUI.verifyElementPresent(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Test Object/05_lblInterestTidakSesuai'), 0, FailureHandling.OPTIONAL)
		boolean dpTidakSesuai = WebUI.verifyElementPresent(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/14_dlgDPTidakSesuai'), 0, FailureHandling.OPTIONAL)
		if(interestTidakSesuai || dpTidakSesuai) {
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/13_btnYesSaveData'))
			WebUI.waitForPageLoad(100)
			WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Test Object/06_fldCommentInterest'), commentInterest)
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Test Object/07_btnSubmitComment'))
		} else {
			KeywordUtil.logInfo('Tidak Muncul Popup Tidak Sesuai')
		}
		if(interestTidakSesuai || dpTidakSesuai) {
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/13_btnYesSaveData'))
			WebUI.waitForPageLoad(100)
			WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Test Object/06_fldCommentInterest'), commentInterest)
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Test Object/07_btnSubmitComment'))
		} else {
			KeywordUtil.logInfo('Tidak Muncul Popup Tidak Sesuai')
		}
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Test Object/10_btnOkSucesSubmit'))
		WebUI.waitForPageLoad(500)
		//		String text = WebUI.getText(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Test Object/12_lblTextInformation'))
		//		KeywordUtil.logInfo(text)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Test Object/11_btnOk'))
	}

	@Keyword
	def approvalFirst(String nomorOrder,String remark) {
		boolean btnCredit = WebUI.verifyElementPresent(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/Approve Test Object/01_btnCredit'), 0, FailureHandling.OPTIONAL)
		if(btnCredit) {
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/Approve Test Object/01_btnCredit'))
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/23_btnOkSourceNotNUll'), FailureHandling.OPTIONAL)
		}else {
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/15_btnException'))
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/23_btnOkSourceNotNUll'), FailureHandling.OPTIONAL)
		}


		boolean noOrderPresent = WebUI.verifyElementPresent(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Test Object/31_btnNomorOrder',[('nomorOrder') : nomorOrder]), 0, FailureHandling.OPTIONAL)
		if(noOrderPresent) {
			TestObject linkObject = findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Test Object/31_btnNomorOrder',[('nomorOrder') : nomorOrder])
			List<WebElement> elements = WebUI.findWebElements(linkObject, 10)
			for (int i = 0;  i < elements.size(); ++i) {
				KeywordUtil.logInfo(elements.get(i).toString())
				KeywordUtil.logInfo(elements.toString())
				println('total element: '+elements)
				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Test Object/31_btnNomorOrder', [('nomorOrder') : nomorOrder]))
				WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Test Object/32_fldRemark'), remark)
				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Test Object/33_btnApprove'))
				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Test Object/34_btnOK'))
				WebUI.delay(2)
				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/19_btnCancel'), FailureHandling.OPTIONAL)
			}
			WebUI.closeBrowser()
		}else {
			println('Continue')
			WebUI.closeBrowser()
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
