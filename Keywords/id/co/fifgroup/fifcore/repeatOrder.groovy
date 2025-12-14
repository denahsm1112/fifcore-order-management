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

public class repeatOrder {
	@Keyword
	def initialInfo(String nik, String custName, String title, String placeBirth, String tglLahir, String namaIbu, String gender, String fullname, String marital,
			String occupationonId ,String occupation, String wp, String education, String wpm, String ojk, String subOccupation) {
		WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/02_custInfo/01_idType/01_cbIdType'), Keys.chord(Keys.DOWN, Keys.ENTER))
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/02_custInfo/02_NIK/01_fldNIK'), nik)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/02_custInfo/03_customerName/01_fldCustName'), custName)
		WebUI.setText(findTestObject('FIFCORE Test Object/Initial Order Test Object/02_custInfo/03_customerName/02_fldCustTitle'), title)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/02_custInfo/04_birthInfo/02_fldPlaceOfBirth'), placeBirth)
		WebUI.waitForPageLoad(20)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/02_custInfo/04_birthInfo/01_fldDOB'), tglLahir)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/02_custInfo/05_motherName/01_fldMotherName'), namaIbu)
		if (gender == 'MALE'){
			KeywordUtil.logInfo('Gender = MALE')
			WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/02_custInfo/06_gender/01_cbGender'), Keys.chord(Keys.DOWN, Keys.ENTER))
		} else {
			KeywordUtil.logInfo('Gender = FEMALE')
			WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/02_custInfo/06_gender/01_cbGender'), Keys.chord(Keys.DOWN, Keys.DOWN, Keys.ENTER))
		}
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/02_custInfo/07_checkCustomer/02_chkCustomerInfo'))
		WebUI.verifyElementPresent(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/02_custInfo/07_checkCustomer/03_chkPopUp'), 10)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/02_custInfo/07_checkCustomer/01_btnOK'))
		if(WebUI.verifyElementVisible(findTestObject('Object Repository/FIFCORE Test Object/Repeat Order Test Object/Initial Order/09_dlgZipcode'), FailureHandling.OPTIONAL)) {
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/13_btnYesSaveData'))
		} else {
			KeywordUtil.logInfo('Tidak Muncul Popup Zipcode')
		}
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/Update Customer Data Test Object/01_btnUpdate'))
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/02_custInfo/09_custFullName/01_fldCustFullName'), fullname)
		if(gender == 'DIVORCED') {
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/02_custInfo/10_maritalStatus/02_cbMaritalStatus'))
			WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/02_custInfo/10_maritalStatus/02_cbMaritalStatus'), Keys.chord(Keys.DOWN, Keys.ENTER))
		} else if(gender == 'MARRIED') {
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/02_custInfo/10_maritalStatus/02_cbMaritalStatus'))
			WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/02_custInfo/10_maritalStatus/02_cbMaritalStatus'), Keys.chord(Keys.DOWN, Keys.DOWN, Keys.ENTER))
		} else if(gender == 'SINGLE') {
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/02_custInfo/10_maritalStatus/02_cbMaritalStatus'))
			WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/02_custInfo/10_maritalStatus/02_cbMaritalStatus'), Keys.chord(Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.ENTER))
		} else if(gender == 'OTHERS') {
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/02_custInfo/10_maritalStatus/02_cbMaritalStatus'))
			WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/02_custInfo/10_maritalStatus/02_cbMaritalStatus'), Keys.chord(Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.ENTER))
		}

		//Checkpoint
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/02_custInfo/12_Occupation/01_cbOccupation'))
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/04_fldBankName'), occupation)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/21_btnFind'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/10_btnDataFirst'))
		if(occupation == 'WIRASWASTA' || occupation == 'TIDAK TETAP' || occupation == 'LIMBAH' || occupation == 'PENGOBATAN ALTERNATIF') {
			KeywordUtil.logInfo('Occupation = '+ occupation)
		} else {
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/11_btnSubOccupation'))
			WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/04_fldBankName'), subOccupation)
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/21_btnFind'))
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/10_btnDataFirst'))
		}
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/12_btnOccoOnI'))
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/04_fldBankName'), occupationonId)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/21_btnFind'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/10_btnDataFirst'))
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/02_custInfo/13_workingPeriod/01_fldWorkingPeriodY'), wp)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/02_custInfo/14_educationInfo/02_cbEducationInfo'))
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/16_fldOccupation'), education)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/21_btnFind'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/01_Order/2_businessUnit/01_cbBUCode', [('businessUnit') : education]))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/12_cbmonthPeriodeWork'))
		WebUI.waitForPageLoad(10)
		WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/12_cbmonthPeriodeWork'), Keys.chord(Keys.DOWN))
		WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/12_cbmonthPeriodeWork'), Keys.chord(Keys.DOWN))
		WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/12_cbmonthPeriodeWork'), Keys.chord(Keys.DOWN))
		WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/12_cbmonthPeriodeWork'), Keys.chord(Keys.ENTER))
	}

	@Keyword
	def formVerificationAddress(String address, String rt, String rw, String kodePos, String kodePos2) {
		WebUI.waitForPageLoad(2)
		WebUI.clearText(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/03_addrVerification/1_addressDetail/02_fldAddress'))
		if(WebUI.verifyElementVisible(findTestObject('Object Repository/FIFCORE Test Object/Repeat Order Test Object/Initial Order/01_dlgPopupAlamat'), FailureHandling.OPTIONAL)) {
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/11_btnOkInformation'))
		} else {
			KeywordUtil.logInfo('Tidak Muncul Popup Alamat')
		}
		WebUI.acceptAlert(FailureHandling.OPTIONAL)
		WebUI.waitForPageLoad(2)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/03_addrVerification/1_addressDetail/02_fldAddress'), address)
		WebUI.waitForPageLoad(2)
		WebUI.clearText(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/03_addrVerification/1_addressDetail/03_fldRT'))
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/03_addrVerification/1_addressDetail/03_fldRT'), rt)
		WebUI.clearText(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/03_addrVerification/1_addressDetail/04_fldRW'))
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/03_addrVerification/1_addressDetail/04_fldRW'), rw)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/03_addrVerification/1_addressDetail/11_cbZipCode'))
		WebUI.clearText(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/16_fldOccupation'))
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/16_fldOccupation'), kodePos)
		WebUI.delay(1)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/21_btnFind'))
		WebUI.waitForPageLoad(2)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/01_Order/2_businessUnit/03_cbZipCode', [('businessUnit') : kodePos2]))
		WebUI.waitForPageLoad(2)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/03_addrVerification/1_addressDetail/09_cbSubZipCode'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/10_btnFind'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/03_addrVerification/1_addressDetail/05_btnDataFirstSubZipCode'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/03_addrVerification/1_addressDetail/07_cbHouseStatus'))
		WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/03_addrVerification/1_addressDetail/08_cbHouseStatus2'), Keys.chord(Keys.DOWN, Keys.ENTER))
	}

	@Keyword
	def contactInfo(String contactInfo, String contactInfo2) {
		if(WebUI.verifyElementPresent(findTestObject('Object Repository/FIFCORE Test Object/Repeat Order Test Object/Initial Order/02_fldMobilePhone1'), 0, FailureHandling.OPTIONAL)) {
			WebUI.clearText(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/03_addrVerification/2_contactInfo/13_fldMobilePhone1'))
			WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/03_addrVerification/2_contactInfo/13_fldMobilePhone1'), contactInfo)
			WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/03_addrVerification/2_contactInfo/13_fldMobilePhone1'), Keys.chord(Keys.TAB))
			WebUI.acceptAlert(FailureHandling.OPTIONAL)
		} else {
			KeywordUtil.logInfo('Mobile Phone 1 Tidak Ada')
		}
		if(WebUI.verifyElementPresent(findTestObject('Object Repository/FIFCORE Test Object/Repeat Order Test Object/Initial Order/03_fldMobilePhone2'), 0, FailureHandling.OPTIONAL)) {
			WebUI.clearText(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/03_addrVerification/2_contactInfo/14_fldMobilePhone2'))
			WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/03_addrVerification/2_contactInfo/14_fldMobilePhone2'), contactInfo2)
			WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/03_addrVerification/2_contactInfo/14_fldMobilePhone2'), Keys.chord(Keys.TAB))
			WebUI.acceptAlert(FailureHandling.OPTIONAL)
		} else {
			KeywordUtil.logInfo('Mobile Phone 2 Tidak Ada')
		}
		if(WebUI.verifyElementPresent(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/Update Customer Data Test Object/15_lblOfficeFixedLine'), 0, FailureHandling.OPTIONAL)) {
			WebUI.clearText(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/Update Customer Data Test Object/16_fldOfficeLine1'))
			WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/Update Customer Data Test Object/16_fldOfficeLine1'), '0216515551')
			WebUI.clearText(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/Update Customer Data Test Object/17_fldOfficeLine2'))
			WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/Update Customer Data Test Object/17_fldOfficeLine2'), '0216515590')
			WebUI.clearText(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/Update Customer Data Test Object/18_fldOfficeLine3'))
			WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/Update Customer Data Test Object/18_fldOfficeLine3'), '0216515385')
		} else {
			KeywordUtil.logInfo('Office Fixed Line Tidak Ada')
		}
		if(WebUI.verifyElementPresent(findTestObject('Object Repository/FIFCORE Test Object/Repeat Order Test Object/Initial Order/04_fldHouseFixedLine'), 0, FailureHandling.OPTIONAL)) {
			WebUI.clearText(findTestObject('Object Repository/FIFCORE Test Object/Repeat Order Test Object/Initial Order/05_fldHouseFixedLine1'))
			WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Repeat Order Test Object/Initial Order/05_fldHouseFixedLine1'), '021')
			WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Repeat Order Test Object/Initial Order/05_fldHouseFixedLine1'), Keys.chord(Keys.TAB))
			WebUI.clearText(findTestObject('Object Repository/FIFCORE Test Object/Repeat Order Test Object/Initial Order/06_fldHouseFixedLine2'))
			WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Repeat Order Test Object/Initial Order/06_fldHouseFixedLine2'), '201928331')
			WebUI.acceptAlert(FailureHandling.OPTIONAL)
		} else {
			KeywordUtil.logInfo('House Fixed Line Tidak Ada')
		}

		if(WebUI.verifyElementPresent(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/Update Customer Data Test Object/13_chkPrimaryFirst'), 0, FailureHandling.OPTIONAL)) {
			if(WebUI.verifyElementChecked(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/Update Customer Data Test Object/13_chkPrimaryFirst'), 0, FailureHandling.OPTIONAL)) {
				KeywordUtil.logInfo('Nomor Pertama Sudah Checklist')
			} else {
				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/Update Customer Data Test Object/13_chkPrimaryFirst'))
			}
		} else {
			KeywordUtil.logInfo('Nomor Pertama Tidak Ada')
		}
		if(WebUI.verifyElementPresent(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/03_addrVerification/2_contactInfo/06_chkPrimary'), 0, FailureHandling.OPTIONAL)) {
			if(WebUI.verifyElementChecked(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/03_addrVerification/2_contactInfo/06_chkPrimary'), 0, FailureHandling.OPTIONAL)) {
				KeywordUtil.logInfo('Nomor Kedua Sudah Checklist')
			} else {
				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/03_addrVerification/2_contactInfo/06_chkPrimary'))
			}
		} else {
			KeywordUtil.logInfo('Nomor Kedua Tidak Ada')
		}
		if(WebUI.verifyElementPresent(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/Update Customer Data Test Object/19_chkPrimaryThird'), 0, FailureHandling.OPTIONAL)) {
			if(WebUI.verifyElementChecked(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/Update Customer Data Test Object/19_chkPrimaryThird'), 0, FailureHandling.OPTIONAL)) {
				KeywordUtil.logInfo('Nomor Ketiga Sudah Checklist')
			} else {
				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/Update Customer Data Test Object/19_chkPrimaryThird'))
			}
		} else {
			KeywordUtil.logInfo('Nomor Ketiga Tidak Ada')
		}
		if(WebUI.verifyElementPresent(findTestObject('Object Repository/FIFCORE Test Object/Repeat Order Test Object/Initial Order/07_chkChecklistPrimaryForth'), 0, FailureHandling.OPTIONAL)) {
			if(WebUI.verifyElementChecked(findTestObject('Object Repository/FIFCORE Test Object/Repeat Order Test Object/Initial Order/07_chkChecklistPrimaryForth'), 0, FailureHandling.OPTIONAL)) {
				KeywordUtil.logInfo('Nomor Keempat Sudah Checklist')
			} else {
				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Repeat Order Test Object/Initial Order/08_chkPrimaryForth'))
			}
		} else {
			KeywordUtil.logInfo('Nomor Keempat Tidak Ada')
		}
	}

	@Keyword
	def submitData(String occupationOnId, String ojk) {
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/12_btnSubmit'))

		TestObject linkObject = findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/21_lblOccupatioOnId_Status')
		List<WebElement> elements = WebUI.findWebElements(linkObject, 2)
		println(elements)
		def counter = 0
		def isYesAfterSubmit = WebUI.verifyElementPresent(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/13_btnYesSaveData'), 0, FailureHandling.OPTIONAL)
		while(counter < elements.size()) {
			if(isYesAfterSubmit ==  false)
			{
				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/Update Customer Data Test Object/02_fldOccupationId'))
				WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/04_fldBankName'), occupationOnId)
				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/21_btnFind'))
				WebUI.waitForPageLoad(2)
				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/10_btnDataFirst'))

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
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Test Object/31_btnNomorOrder', [('nomorOrder') : nomorOrder]))
			WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Test Object/32_fldRemark'), remark)
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Test Object/33_btnApprove'))
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Test Object/34_btnOK'))
			WebUI.delay(2)
			WebUI.closeBrowser()
		}else {
			println('Continue')
			WebUI.closeBrowser()
		}
		//end
	}
}
