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
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.kms.katalon.core.configuration.RunConfiguration
import internal.GlobalVariable
import java.nio.file.Path
import java.nio.file.Paths
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import org.antlr.runtime.debug.Profiler.ProfileStats
import org.openqa.selenium.Keys as Keys
import java.util.Calendar

public class createOrder {
	@Keyword
	def newOrder(String businessType) {
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/BM Dashboard Test Object/09_btnBMMenu'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/BM Dashboard Test Object/10_btnReceiveOrder'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/BM Dashboard Test Object/08_btnOrderTracking'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/BM Dashboard Test Object/07_btnNewIndividual'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/BM Dashboard Test Object/01_btnNewOrder', [('businessType') : businessType]))
	}

	@Keyword
	def newOrderReceiveOrder(String businessType) {
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/BM Dashboard Test Object/08_btnOrderTracking'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/BM Dashboard Test Object/07_btnNewIndividual'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/BM Dashboard Test Object/01_btnNewOrder', [('businessType') : businessType]))
	}

	@Keyword
	def formOrder(String companyID, String businessUnit, String branch, String platform, String ojk, String credit, String subcredit, String sektor) {
		WebUI.setText(findTestObject('FIFCORE Test Object/Initial Order Test Object/01_Order/1_companyID/01_cbCompanyId'), companyID)
		WebUI.sendKeys(findTestObject('FIFCORE Test Object/Initial Order Test Object/01_Order/1_companyID/01_cbCompanyId'), Keys.chord(Keys.TAB))
		WebUI.click(findTestObject('FIFCORE Test Object/Initial Order Test Object/01_Order/2_businessUnit/02_cbBusinessUnit'))
		WebUI.acceptAlert(FailureHandling.OPTIONAL)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/16_fldOccupation'), businessUnit)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/21_btnFind'))
		WebUI.waitForPageLoad(2)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/01_Order/2_businessUnit/01_cbBUCode', [('businessUnit') : businessUnit]))
		WebUI.delay(1)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/02_fldBranch'), branch)
		WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/02_fldBranch'), Keys.chord(Keys.TAB))
		WebUI.delay(3)
		WebUI.click(findTestObject('FIFCORE Test Object/Initial Order Test Object/01_Order/3_Platform/01_cbPlatform'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/03_cbVarPlatform', [('platform') : platform]))
		if (platform == 'SYARIAH'){
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/04_cbIfSyariah'))
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/05_cbMurabahah'))
		} else {
			KeywordUtil.logInfo('Platform = KONVENSIONAL')
		}
		WebUI.delay(1)
		WebUI.waitForPageLoad(2)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/08_fldOjk'))
		WebUI.delay(1)
		WebUI.acceptAlert(FailureHandling.OPTIONAL)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/16_fldOccupation'), ojk)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/21_btnFind'))
		WebUI.waitForPageLoad(2)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/01_Order/2_businessUnit/01_cbBUCode', [('businessUnit') : ojk]))
		WebUI.waitForPageLoad(2)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/06_fldCreditObject'))
		WebUI.delay(1)
		WebUI.acceptAlert(FailureHandling.OPTIONAL)
		WebUI.delay(1)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/16_fldOccupation'), credit)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/20_closeErrorBoxContent'), FailureHandling.OPTIONAL)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/21_btnFind'))
		WebUI.delay(1)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/01_Order/2_businessUnit/01_cbBUCode', [('businessUnit') : credit]))
		WebUI.delay(1)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/07_fldSubCreditObject'))
		WebUI.delay(1)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/16_fldOccupation'), subcredit)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/21_btnFind'))
		//WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/01_Order/2_businessUnit/01_cbBUCode', [('businessUnit') : subcredit]))
		//WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/09_fldSectorEconomy'))
		WebUI.delay(1)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/16_fldOccupation'), sektor)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/21_btnFind'))
		WebUI.waitForPageLoad(2)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/10_btnDataFirst'))
		WebUI.delay(1)
		WebUI.waitForPageLoad(2)
	}

	@Keyword
	def formOrderMMQ(String companyID, String businessUnit, String branch, String platform, String subPlatform, String ojk, String credit, String subcredit, String sektor) {
		WebUI.setText(findTestObject('FIFCORE Test Object/Initial Order Test Object/01_Order/1_companyID/01_cbCompanyId'), companyID)
		WebUI.sendKeys(findTestObject('FIFCORE Test Object/Initial Order Test Object/01_Order/1_companyID/01_cbCompanyId'), Keys.chord(Keys.TAB))
		WebUI.click(findTestObject('FIFCORE Test Object/Initial Order Test Object/01_Order/2_businessUnit/02_cbBusinessUnit'))
		WebUI.acceptAlert(FailureHandling.OPTIONAL)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/16_fldOccupation'), businessUnit)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/21_btnFind'))
		WebUI.waitForPageLoad(2)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/01_Order/2_businessUnit/01_cbBUCode', [('businessUnit') : businessUnit]))
		WebUI.delay(1)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/02_fldBranch'), branch)
		WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/02_fldBranch'), Keys.chord(Keys.TAB))
		WebUI.click(findTestObject('FIFCORE Test Object/Initial Order Test Object/01_Order/3_Platform/01_cbPlatform'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/03_cbVarPlatform', [('platform') : platform]))
		if (platform == 'SYARIAH'){
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/04_cbIfSyariah'))
			//			if(subPlatform == 'MUSYARAKAH MUTANAQISHAH') {
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/29_cbMusyarakahMutanaqishah',[('subPlatform') : subPlatform]))
			//			}else if (subPlatform == 'AL BAI WA AL ISTIJAR'){
			//				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/28_cbAlBaiWaAlIstijar'))
			//			}
		} else {
			KeywordUtil.logInfo('Platform = KONVENSIONAL')
		}
		WebUI.delay(1)
		WebUI.waitForPageLoad(2)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/08_fldOjk'))
		WebUI.delay(1)
		WebUI.acceptAlert(FailureHandling.OPTIONAL)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/16_fldOccupation'), ojk)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/21_btnFind'))
		WebUI.waitForPageLoad(2)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/01_Order/2_businessUnit/01_cbBUCode', [('businessUnit') : ojk]))
		WebUI.waitForPageLoad(2)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/06_fldCreditObject'))
		WebUI.delay(1)
		WebUI.acceptAlert(FailureHandling.OPTIONAL)
		WebUI.delay(1)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/16_fldOccupation'), credit)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/21_btnFind'))
		WebUI.waitForPageLoad(2)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/01_Order/2_businessUnit/01_cbBUCode', [('businessUnit') : credit]))
		WebUI.waitForPageLoad(2)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/07_fldSubCreditObject'))
		WebUI.delay(1)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/16_fldOccupation'), subcredit)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/21_btnFind'))
		WebUI.waitForPageLoad(2)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/01_Order/2_businessUnit/01_cbBUCode', [('businessUnit') : subcredit]))
		WebUI.waitForPageLoad(2)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/09_fldSec7torEconomy'))
		WebUI.delay(1)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/16_fldOccupation'), sektor)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/21_btnFind'))
		WebUI.waitForPageLoad(2)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/10_btnDataFirst'))
		WebUI.delay(1)
		WebUI.waitForPageLoad(2)
	}

	@Keyword
	def initialInfo(String nik, String custName, String title, String placeBirth, String tglLahir, String namaIbu, String gender, String fullname, String marital,
			String occupationonId ,String occupation, String wp, String education, String wpm, String ojk, String subOccupation) {
		WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/02_custInfo/01_idType/01_cbIdType'), Keys.chord(Keys.DOWN, Keys.ENTER))
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/02_custInfo/02_NIK/01_fldNIK'), nik)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/02_custInfo/03_customerName/01_fldCustName'), custName)
		WebUI.setText(findTestObject('FIFCORE Test Object/Initial Order Test Object/02_custInfo/03_customerName/02_fldCustTitle'), title)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/02_custInfo/04_birthInfo/02_fldPlaceOfBirth'), placeBirth)
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
		//WebUI.verifyElementPresent(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/02_custInfo/07_checkCustomer/03_chkPopUp'), 10)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/02_custInfo/07_checkCustomer/01_btnOK'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/02_custInfo/08_checkDuplicate/02_chkDuplicate'))
		WebUI.verifyElementPresent(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/02_custInfo/08_checkDuplicate/03_chkPopUp'), 5, FailureHandling.OPTIONAL)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/02_custInfo/08_checkDuplicate/01_btnOK'))
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/02_custInfo/09_custFullName/01_fldCustFullName'), fullname)
		if(marital == 'DIVORCED') {
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/02_custInfo/10_maritalStatus/02_cbMaritalStatus'))
			WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/02_custInfo/10_maritalStatus/02_cbMaritalStatus'), Keys.chord(Keys.DOWN, Keys.ENTER))
		} else if(marital == 'MARRIED') {
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/02_custInfo/10_maritalStatus/02_cbMaritalStatus'))
			WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/02_custInfo/10_maritalStatus/02_cbMaritalStatus'), Keys.chord(Keys.DOWN, Keys.DOWN, Keys.ENTER))
		} else if(marital == 'SINGLE') {
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/02_custInfo/10_maritalStatus/02_cbMaritalStatus'))
			WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/02_custInfo/10_maritalStatus/02_cbMaritalStatus'), Keys.chord(Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.ENTER))
		} else if(marital == 'OTHERS') {
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/02_custInfo/10_maritalStatus/02_cbMaritalStatus'))
			WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/02_custInfo/10_maritalStatus/02_cbMaritalStatus'), Keys.chord(Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.ENTER))
		}

		//Checkpoint
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
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/12_btnOccoOnI'))
		//WebUI.waitForPageLoad(3)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/04_fldBankName'), occupationonId)
		//WebUI.waitForPageLoad(3)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/21_btnFind'))
		//WebUI.waitForPageLoad(2)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/10_btnDataFirst'))
		//WebUI.waitForPageLoad(10)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/02_custInfo/13_workingPeriod/01_fldWorkingPeriodY'), wp)
		//		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/21_btnFind'))
		//		WebUI.waitForPageLoad(2)
		//		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/10_btnDataFirst'))
		//		WebUI.waitForPageLoad(2)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/02_custInfo/14_educationInfo/02_cbEducationInfo'))
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/16_fldOccupation'), education)
		//WebUI.delay(1)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/21_btnFind'))
		//WebUI.waitForPageLoad(2)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/01_Order/2_businessUnit/01_cbBUCode', [('businessUnit') : education]))
		//WebUI.waitForPageLoad(2)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/12_cbmonthPeriodeWork'))
		WebUI.waitForPageLoad(10)
		WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/12_cbmonthPeriodeWork'), Keys.chord(Keys.DOWN))
		WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/12_cbmonthPeriodeWork'), Keys.chord(Keys.DOWN))
		WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/12_cbmonthPeriodeWork'), Keys.chord(Keys.DOWN))
		WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/12_cbmonthPeriodeWork'), Keys.chord(Keys.ENTER))
		//WebUI.waitForPageLoad(2)
		//		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/20_cbOccupation'))
		//		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/16_fldOccupation'), occupation)
		//		WebUI.delay(1)
		//		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/21_btnFind'))
		//		WebUI.delay(2)
		//		WebUI.waitForPageLoad(2)
		//		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/10_btnDataFirst'))
		//		WebUI.delay(2)
		//WebUI.waitForPageLoad(10)
		//Occupation on ID
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/12_btnOccoOnI'))
		//WebUI.waitForPageLoad(3)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/04_fldBankName'), occupationonId)
		//WebUI.waitForPageLoad(3)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/21_btnFind'))
		//WebUI.waitForPageLoad(2)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/10_btnDataFirst'))
		//WebUI.waitForPageLoad(10)
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
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/12_btnOccoOnI'))
		//WebUI.waitForPageLoad(3)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/04_fldBankName'), occupationonId)
		//WebUI.waitForPageLoad(3)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/21_btnFind'))
		//WebUI.waitForPageLoad(2)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/10_btnDataFirst'))
		//WebUI.waitForPageLoad(10)
	}

	@Keyword
	def initialInfoMMQ(String nik, String custName, String title, String placeBirth, String tglLahir, String namaIbu, String gender, String fullname, String marital,
			String occupationonId ,String occupation, String wp, String education, String wpm, String ojk, String subOccupation) {
		WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/02_custInfo/01_idType/01_cbIdType'), Keys.chord(Keys.DOWN, Keys.ENTER))
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/02_custInfo/02_NIK/01_fldNIK'), nik)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/02_custInfo/03_customerName/01_fldCustName'), custName)
		WebUI.setText(findTestObject('FIFCORE Test Object/Initial Order Test Object/02_custInfo/03_customerName/02_fldCustTitle'), title)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/02_custInfo/04_birthInfo/02_fldPlaceOfBirth'), placeBirth)
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
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/02_custInfo/08_checkDuplicate/02_chkDuplicate'))
		WebUI.verifyElementPresent(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/02_custInfo/08_checkDuplicate/03_chkPopUp'), 5, FailureHandling.OPTIONAL)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/02_custInfo/08_checkDuplicate/01_btnOK'))
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/02_custInfo/09_custFullName/01_fldCustFullName'), fullname)
		if(marital == 'DIVORCED') {
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/02_custInfo/10_maritalStatus/02_cbMaritalStatus'))
			WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/02_custInfo/10_maritalStatus/02_cbMaritalStatus'), Keys.chord(Keys.DOWN, Keys.ENTER))
		} else if(marital == 'MARRIED') {
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/02_custInfo/10_maritalStatus/02_cbMaritalStatus'))
			WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/02_custInfo/10_maritalStatus/02_cbMaritalStatus'), Keys.chord(Keys.DOWN, Keys.DOWN, Keys.ENTER))
		} else if(marital == 'SINGLE') {
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/02_custInfo/10_maritalStatus/02_cbMaritalStatus'))
			WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/02_custInfo/10_maritalStatus/02_cbMaritalStatus'), Keys.chord(Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.ENTER))
		} else if(marital == 'OTHERS') {
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/02_custInfo/10_maritalStatus/02_cbMaritalStatus'))
			WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/02_custInfo/10_maritalStatus/02_cbMaritalStatus'), Keys.chord(Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.ENTER))
		}

		//Checkpoint
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
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/12_btnOccoOnI'))
		//WebUI.waitForPageLoad(3)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/04_fldBankName'), occupationonId)
		//WebUI.waitForPageLoad(3)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/21_btnFind'))
		//WebUI.waitForPageLoad(2)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/10_btnDataFirst'))
		//WebUI.waitForPageLoad(10)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/02_custInfo/13_workingPeriod/01_fldWorkingPeriodY'), wp)
		//		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/21_btnFind'))
		//		WebUI.waitForPageLoad(2)
		//		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/10_btnDataFirst'))
		//		WebUI.waitForPageLoad(2)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/02_custInfo/14_educationInfo/02_cbEducationInfo'))
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/16_fldOccupation'), education)
		//WebUI.delay(1)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/21_btnFind'))
		//WebUI.waitForPageLoad(2)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/01_Order/2_businessUnit/01_cbBUCode', [('businessUnit') : education]))
		//WebUI.waitForPageLoad(2)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/12_cbmonthPeriodeWork'))
		WebUI.waitForPageLoad(10)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/02_custInfo/13_workingPeriod/03_fldWorkingMonth', [('wpm') : wpm]))

	}

	@Keyword
	def initialInfoNMCRO(String nik, String custName, String title, String placeBirth, String tglLahir, String namaIbu, String gender, String fullname, String marital,
			String occupationonId ,String occupation, String wp, String education, String wpm, String ojk, String subOccupation, String customerNo) {
		WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/02_custInfo/01_idType/01_cbIdType'), Keys.chord(Keys.DOWN, Keys.ENTER))
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/02_custInfo/02_NIK/01_fldNIK'), nik)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/02_custInfo/03_customerName/01_fldCustName'), custName)
		WebUI.setText(findTestObject('FIFCORE Test Object/Initial Order Test Object/02_custInfo/03_customerName/02_fldCustTitle'), title)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/02_custInfo/04_birthInfo/02_fldPlaceOfBirth'), placeBirth)
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
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/34_btnYesHapusZipCode'),FailureHandling.OPTIONAL)
		if(WebUI.verifyElementClickable(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/02_custInfo/08_checkDuplicate/02_chkDuplicate'),FailureHandling.OPTIONAL)) {
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/02_custInfo/08_checkDuplicate/02_chkDuplicate'))
			WebUI.verifyElementPresent(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/02_custInfo/08_checkDuplicate/03_chkPopUp'), 5, FailureHandling.OPTIONAL)
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/16_cbRowPilihCheckDuplicate',[('customerNo') : customerNo]))
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/34_btnYesHapusZipCode'),FailureHandling.OPTIONAL)

		}
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/35_btnUpdateCustomerData'))
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/02_custInfo/09_custFullName/01_fldCustFullName'), fullname)
		//		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/02_custInfo/10_maritalStatus/02_cbMaritalStatus'))
		//		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/02_custInfo/10_maritalStatus/01_cbMarital', [('marital') : marital]))
		//		if(marital == 'DIVORCED') {
		//			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/02_custInfo/10_maritalStatus/02_cbMaritalStatus'))
		//			WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/02_custInfo/10_maritalStatus/02_cbMaritalStatus'), Keys.chord(Keys.DOWN, Keys.ENTER))
		//		} else if(marital == 'MARRIED') {
		//			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/02_custInfo/10_maritalStatus/02_cbMaritalStatus'))
		//			WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/02_custInfo/10_maritalStatus/02_cbMaritalStatus'), Keys.chord(Keys.DOWN, Keys.DOWN, Keys.ENTER))
		//		} else if(marital == 'SINGLE') {
		//			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/02_custInfo/10_maritalStatus/02_cbMaritalStatus'))
		//			WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/02_custInfo/10_maritalStatus/02_cbMaritalStatus'), Keys.chord(Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.ENTER))
		//		} else if(marital == 'OTHERS') {
		//			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/02_custInfo/10_maritalStatus/02_cbMaritalStatus'))
		//			WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/02_custInfo/10_maritalStatus/02_cbMaritalStatus'), Keys.chord(Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.ENTER))
		//		}

		//Checkpoint
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
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/12_btnOccoOnI'))
		//WebUI.waitForPageLoad(3)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/04_fldBankName'), occupationonId)
		//WebUI.waitForPageLoad(3)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/21_btnFind'))
		//WebUI.waitForPageLoad(2)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/10_btnDataFirst'))
		//WebUI.waitForPageLoad(10)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/02_custInfo/13_workingPeriod/01_fldWorkingPeriodY'), wp)
		//		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/21_btnFind'))
		//		WebUI.waitForPageLoad(2)
		//		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/10_btnDataFirst'))
		//		WebUI.waitForPageLoad(2)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/02_custInfo/14_educationInfo/02_cbEducationInfo'))
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/16_fldOccupation'), education)
		//WebUI.delay(1)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/21_btnFind'))
		//WebUI.waitForPageLoad(2)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/01_Order/2_businessUnit/01_cbBUCode', [('businessUnit') : education]))
		//WebUI.waitForPageLoad(2)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/12_cbmonthPeriodeWork'))
		WebUI.waitForPageLoad(10)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/02_custInfo/13_workingPeriod/03_fldWorkingMonth', [('wpm') : wpm]))

		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/24_btnOKMailbox'),FailureHandling.OPTIONAL)


	}
	@Keyword
	def formVerificationAddressRO(String address, String rt, String rw, String kodePos, String kodePos2, String occupation) {

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
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/01_Order/2_businessUnit/03_cbZipCode', [('businessUnit') : kodePos2]))
		WebUI.waitForPageLoad(2)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/03_addrVerification/1_addressDetail/09_cbSubZipCode'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/10_btnFind'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/03_addrVerification/1_addressDetail/05_btnDataFirstSubZipCode'))
		//		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/03_addrVerification/1_addressDetail/10_fldSubZipCodeCode', [('subkodepos') : kodePos2]))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/24_btnOKMailbox'),FailureHandling.OPTIONAL)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/03_addrVerification/1_addressDetail/07_cbHouseStatus'))
		WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/03_addrVerification/1_addressDetail/08_cbHouseStatus2'), Keys.chord(Keys.DOWN, Keys.ENTER))
		while(WebUI.verifyElementPresent(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/24_btnOKMailbox'),5,FailureHandling.OPTIONAL)) {
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/24_btnOKMailbox'),FailureHandling.OPTIONAL)
			WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/03_addrVerification/1_addressDetail/02_fldAddress'), address)
		}

	}
	@Keyword
	def formVerificationAddress(String address, String rt, String rw, String kodePos, String kodePos2, String occupation) {

		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/03_addrVerification/1_addressDetail/02_fldAddress'), address)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/03_addrVerification/1_addressDetail/03_fldRT'), rt)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/03_addrVerification/1_addressDetail/04_fldRW'), rw)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/03_addrVerification/1_addressDetail/11_cbZipCode'))
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/16_fldOccupation'), kodePos)
		WebUI.delay(1)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/21_btnFind'))
		WebUI.waitForPageLoad(2)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/19_lblFirstData'))
		//WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/01_Order/2_businessUnit/03_cbZipCode', [('businessUnit') : kodePos2]))
		WebUI.waitForPageLoad(2)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/03_addrVerification/1_addressDetail/09_cbSubZipCode'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/10_btnFind'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/03_addrVerification/1_addressDetail/05_btnDataFirstSubZipCode'))
		//		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/03_addrVerification/1_addressDetail/10_fldSubZipCodeCode', [('subkodepos') : kodePos2]))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/03_addrVerification/1_addressDetail/07_cbHouseStatus'))
		WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/03_addrVerification/1_addressDetail/08_cbHouseStatus2'), Keys.chord(Keys.DOWN, Keys.ENTER))
		//		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/20_cbOccupation'))
		//		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/16_fldOccupation'), occupation)
		//		WebUI.delay(1)
		//		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/21_btnFind'))
		//		WebUI.delay(2)
		//		WebUI.waitForPageLoad(2)
		//		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/10_btnDataFirst'))
		//		WebUI.delay(2)
	}

	@Keyword
	def formVerificationAddress2(String address, String rt, String rw, String kodePos, String kodePos2, String occupation) {
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/03_addrVerification/1_addressDetail/02_fldAddress'), address)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/03_addrVerification/1_addressDetail/03_fldRT'), rt)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/03_addrVerification/1_addressDetail/04_fldRW'), rw)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/03_addrVerification/1_addressDetail/11_cbZipCode'))
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/16_fldOccupation'), kodePos)
		WebUI.delay(1)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/21_btnFind'))
		WebUI.waitForPageLoad(2)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/01_Order/2_businessUnit/03_cbZipCode', [('businessUnit') : kodePos2]))
		WebUI.waitForPageLoad(2)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/03_addrVerification/1_addressDetail/09_cbSubZipCode'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/10_btnFind'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/03_addrVerification/1_addressDetail/06_btnDataFirstSubZipCode2'))
		//		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/03_addrVerification/1_addressDetail/10_fldSubZipCodeCode', [('subkodepos') : kodePos2]))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/03_addrVerification/1_addressDetail/07_cbHouseStatus'))
		WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/03_addrVerification/1_addressDetail/08_cbHouseStatus2'), Keys.chord(Keys.DOWN, Keys.ENTER))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/20_cbOccupation'))
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/16_fldOccupation'), occupation)
		WebUI.delay(1)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/21_btnFind'))
		WebUI.delay(2)
		WebUI.waitForPageLoad(2)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/10_btnDataFirst'))
		WebUI.delay(2)
	}


	@Keyword
	def contactInfo(String contact, String contactInfo, String contact2, String contactInfo2) {
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/03_addrVerification/2_contactInfo/01_btnAddContactInfo'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/03_addrVerification/2_contactInfo/15_cbContactType'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/17_cbOptionContact', [('contact') : contact]))
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/03_addrVerification/2_contactInfo/13_fldMobilePhone1'), contactInfo)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/03_addrVerification/2_contactInfo/03_chkChecklist'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/03_addrVerification/2_contactInfo/01_btnAddContactInfo'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/03_addrVerification/2_contactInfo/16_cbContactType2'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/17_cbOptionContact', [('contact') : contact2]))
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/03_addrVerification/2_contactInfo/14_fldMobilePhone2'), contactInfo2)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/03_addrVerification/2_contactInfo/04_chkChecklist2'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/03_addrVerification/2_contactInfo/06_chkPrimary'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/03_addrVerification/2_contactInfo/05_chkPrimaryFirstPhone'))
	}

	@Keyword
	def contactInfoMMQ(String contact, String contactInfo, String contact2, String contactInfo2, String contact3, String email) {
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/03_addrVerification/2_contactInfo/01_btnAddContactInfo'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/03_addrVerification/2_contactInfo/15_cbContactType'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/17_cbOptionContact', [('contact') : contact]))
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/03_addrVerification/2_contactInfo/13_fldMobilePhone1'), contactInfo)
		if(WebUI.verifyElementNotChecked(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/03_addrVerification/2_contactInfo/03_chkChecklist'), 3,  FailureHandling.OPTIONAL)) {
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/03_addrVerification/2_contactInfo/03_chkChecklist'))
		}
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/03_addrVerification/2_contactInfo/01_btnAddContactInfo'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/03_addrVerification/2_contactInfo/16_cbContactType2'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/17_cbOptionContact', [('contact') : contact2]))
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/03_addrVerification/2_contactInfo/14_fldMobilePhone2'), contactInfo2)
		if(WebUI.verifyElementNotChecked(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/03_addrVerification/2_contactInfo/08_chkPrimary2'), 3,  FailureHandling.OPTIONAL)) {
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/03_addrVerification/2_contactInfo/08_chkPrimary2'))
		}
		if(WebUI.verifyElementNotChecked(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/03_addrVerification/2_contactInfo/11_chkSmartphone2'), 3,  FailureHandling.OPTIONAL)) {
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/03_addrVerification/2_contactInfo/11_chkSmartphone2'))
		}
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/03_addrVerification/2_contactInfo/01_btnAddContactInfo'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/03_addrVerification/2_contactInfo/17_cbContactType3'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/17_cbOptionContact', [('contact') : contact3]))
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/03_addrVerification/2_contactInfo/12_fldEmail'), email)
		if(WebUI.verifyElementNotChecked(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/03_addrVerification/2_contactInfo/09_chkPrimary3'), 3,  FailureHandling.OPTIONAL)) {
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/03_addrVerification/2_contactInfo/09_chkPrimary3'))
		}

	}

	@Keyword
	def objectInfo(String tenor, String objGroup, String dealerID, String objCode, String colour, String price, String dp, String installment) {
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/1_tenor/02_fldTenorM'), tenor)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/1_tenor/01_btnAddProduct'))
		WebUI.setText(findTestObject('FIFCORE Test Object/Initial Order Test Object/04_objectFinance/1_tenor/0_objFinance/07_fldObjGroup'), objGroup)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/1_tenor/0_objFinance/03_fldDealer'), dealerID)
		WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/1_tenor/0_objFinance/11_cbNewUsed'), Keys.chord(Keys.DOWN, Keys.ENTER))
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/1_tenor/0_objFinance/06_fldObjCode'), objCode)
		WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/1_tenor/0_objFinance/12_cbUnitAvailbility'), Keys.chord(Keys.DOWN, Keys.ENTER))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/1_tenor/0_objFinance/09_cbColour'))
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/16_fldOccupation'), colour)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/21_btnFind'))
		WebUI.waitForPageLoad(2)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/10_btnDataFirst'))
		WebUI.waitForPageLoad(2)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/1_tenor/0_objFinance/08_fldUnitPrice'), price)
		WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/1_tenor/0_objFinance/08_fldUnitPrice'), Keys.chord(Keys.TAB))
		WebUI.waitForPageLoad(2)
		WebUI.scrollToElement(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/1_tenor/0_objFinance/04_fldGrossDpDealer'), 2)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/1_tenor/0_objFinance/04_fldGrossDpDealer'), dp)
		WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/1_tenor/0_objFinance/04_fldGrossDpDealer'), Keys.chord(Keys.TAB))
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/1_tenor/0_objFinance/05_fldInstallmentAmt'), installment)
		WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/1_tenor/0_objFinance/05_fldInstallmentAmt'), Keys.chord(Keys.TAB))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/1_tenor/0_objFinance/01_chkBpkbSameCust'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/1_tenor/0_objFinance/02_btnOK'))
	}

	@Keyword
	def objectInfoMMQ(String waktuFasilitas, String objGroup, String dealerID, String objCode, String colour, String noChassis, String noEngine, String km, String year, String stnkUntil,
			String tobeTransfer, String amountCredit, String installment) {
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/2_Syariah/15_fldWaktuFasilitas'), waktuFasilitas)

		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/1_tenor/01_btnAddProduct'))
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
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/1_tenor/1_autoInvoice/02_fldChassisNumber'), noChassis)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/1_tenor/1_autoInvoice/03_fldEngineNumber'), noEngine)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/1_tenor/1_autoInvoice/04_fldKM'), km)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/1_tenor/1_autoInvoice/05_fldYear'), year)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/1_tenor/1_autoInvoice/06_fldSTNK'), stnkUntil)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/1_tenor/1_autoInvoice/07_btnCheckAppraisal'))
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/1_tenor/1_autoInvoice/08_fldToBeTransfer'), tobeTransfer)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/1_tenor/1_autoInvoice/09_fldAmountCredit'), amountCredit)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/1_tenor/1_autoInvoice/10_fldInstallmentPerUnit'), installment)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/1_tenor/1_autoInvoice/11_chkBpkbSameAsKTP'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/1_tenor/0_objFinance/02_btnOK'))
	}

	@Keyword
	def objectInfoMPF(String tenor, String objGroup, String dealerID, String objCode, String price, String dp, String installment) {
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/1_tenor/02_fldTenorM'), tenor)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/1_tenor/01_btnAddProduct'))
		WebUI.setText(findTestObject('FIFCORE Test Object/Initial Order Test Object/04_objectFinance/1_tenor/0_objFinance/07_fldObjGroup'), objGroup)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/1_tenor/0_objFinance/03_fldDealer'), dealerID)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/1_tenor/0_objFinance/06_fldObjCode'), objCode)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/MPF/01_fldPrice'), price)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/MPF/02_fldGDP'), dp)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/MPF/03_fldInstallment'), installment)
		WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/1_tenor/0_objFinance/12_cbUnitAvailbility'), Keys.chord(Keys.DOWN, Keys.ENTER))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/1_tenor/0_objFinance/02_btnOK'))
	}

	@Keyword
	def objectInfoNMC(String tenor, String objGroup, String dealerID, String objCode, String colour, String price, String dpDealer, String dpFIF, String installment) {
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/1_tenor/02_fldTenorM'), tenor)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/1_tenor/01_btnAddProduct'))
		WebUI.setText(findTestObject('FIFCORE Test Object/Initial Order Test Object/04_objectFinance/1_tenor/0_objFinance/07_fldObjGroup'), objGroup)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/1_tenor/0_objFinance/03_fldDealer'), dealerID)
		WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/1_tenor/0_objFinance/11_cbNewUsed'), Keys.chord(Keys.DOWN, Keys.ENTER))
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/1_tenor/0_objFinance/06_fldObjCode'), objCode)
		WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/1_tenor/0_objFinance/12_cbUnitAvailbility'), Keys.chord(Keys.DOWN, Keys.ENTER))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/1_tenor/0_objFinance/09_cbColour'))
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/16_fldOccupation'), colour)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/21_btnFind'))
		WebUI.waitForPageLoad(2)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/10_btnDataFirst'))
		WebUI.waitForPageLoad(2)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/1_tenor/0_objFinance/08_fldUnitPrice'), price)
		WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/1_tenor/0_objFinance/08_fldUnitPrice'), Keys.chord(Keys.TAB))
		WebUI.waitForPageLoad(2)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/3_NMC/03_fldGrossDPDealer'), dpDealer)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/3_NMC/04_fldGrossDPFIF'), dpFIF)
		//		WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/1_tenor/0_objFinance/04_fldGrossDpDealer'), Keys.chord(Keys.TAB))
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/1_tenor/0_objFinance/05_fldInstallmentAmt'), installment)
		//		WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/1_tenor/0_objFinance/05_fldInstallmentAmt'), Keys.chord(Keys.TAB))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/1_tenor/0_objFinance/01_chkBpkbSameCust'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/1_tenor/0_objFinance/02_btnOK'))
	}
	@Keyword
	def objectInfoAutoInvoice(String tenor, String objGroup, String dealerID, String objCode, String colour, String noChassis, String noEngine, String km, String year, String stnkUntil,
			String tobeTransfer, String amountCredit, String installment) {
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/1_tenor/02_fldTenorM'), tenor)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/1_tenor/01_btnAddProduct'))
		WebUI.setText(findTestObject('FIFCORE Test Object/Initial Order Test Object/04_objectFinance/1_tenor/0_objFinance/07_fldObjGroup'), objGroup)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/1_tenor/0_objFinance/03_fldDealer'), dealerID)
		WebUI.delay(3)
		WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/1_tenor/0_objFinance/11_cbNewUsed'), Keys.chord(Keys.DOWN, Keys.ENTER))
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/1_tenor/0_objFinance/06_fldObjCode'), objCode)
		WebUI.delay(3)
		WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/1_tenor/0_objFinance/12_cbUnitAvailbility'), Keys.chord(Keys.DOWN, Keys.ENTER))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/1_tenor/1_autoInvoice/01_btnColor'))
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/16_fldOccupation'), colour)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/21_btnFind'))
		WebUI.waitForPageLoad(2)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/10_btnDataFirst'))
		WebUI.waitForPageLoad(2)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/1_tenor/1_autoInvoice/02_fldChassisNumber'), noChassis)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/1_tenor/1_autoInvoice/03_fldEngineNumber'), noEngine)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/1_tenor/1_autoInvoice/04_fldKM'), km)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/1_tenor/1_autoInvoice/05_fldYear'), year)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/1_tenor/1_autoInvoice/06_fldSTNK'), stnkUntil)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/1_tenor/1_autoInvoice/07_btnCheckAppraisal'))
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/1_tenor/1_autoInvoice/08_fldToBeTransfer'), tobeTransfer)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/1_tenor/1_autoInvoice/09_fldAmountCredit'), amountCredit)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/1_tenor/1_autoInvoice/10_fldInstallmentPerUnit'), installment)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/1_tenor/1_autoInvoice/11_chkBpkbSameAsKTP'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/1_tenor/0_objFinance/02_btnOK'))
	}

	@Keyword
	def general(String so, String visitDate, String vID, String caCoord) {
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/05_generalInfo/01_sourceOrder/01_fldSourceOrderId'), so)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/18_fldVisitDate'), visitDate)

		Calendar calendar = Calendar.getInstance()
		calendar.add(Calendar.HOUR_OF_DAY, 1)
		int hour = calendar.get(Calendar.HOUR_OF_DAY)

		for (int i = 0; i < (hour == 0 ? 8 : hour); i++) {
			println "Clicking... " + (i + 1) + " time(s)"
			(WebUI.waitForElementPresent(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/05_generalInfo/02_visitDate/01_btnArrowUp'),5))
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/05_generalInfo/02_visitDate/01_btnArrowUp'))
		}


		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/MPF/04_fldCACoord'), caCoord, FailureHandling.OPTIONAL)
		WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/MPF/04_fldCACoord'), Keys.chord(Keys.TAB),FailureHandling.OPTIONAL)

		//		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/05_generalInfo/05_caCoordinator/03_fldSearchCACoord'), FailureHandling.OPTIONAL)
		//		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/05_generalInfo/05_caCoordinator/04_fldNPO'), caCoord, FailureHandling.OPTIONAL)
		//		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/05_generalInfo/05_caCoordinator/01_btnFindCACoord'), FailureHandling.OPTIONAL)
		//		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/05_generalInfo/10_btnDataFirst'), FailureHandling.OPTIONAL)
		//WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/05_generalInfo/02_visitDate/05_fldPromiseToVisit'), Keys.chord(Keys.CONTROL, "a"))
		//WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/05_generalInfo/02_visitDate/02_fldTimeVisit'), '1700')
		//WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/05_generalInfo/02_visitDate/06_fldPromiseToVisitInvalid'), '1800')
		//		WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/19_fldTime'), Keys.chord(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE))
		//		WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/19_fldTime'), Keys.chord(Keys.NUMPAD1, Keys.NUMPAD5, Keys.NUMPAD0, Keys.NUMPAD0))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/23_chkCeklisPreFlag'))
		WebUI.scrollToElement(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/05_generalInfo/06_cbSendVia'), 2)
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/05_generalInfo/06_cbSendVia'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/05_generalInfo/07_cbSendVia', [('sendVia') : 'JASA']))
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/22_fldVerifier'), vID)
		WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/22_fldVerifier'), Keys.chord(Keys.TAB))
		WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/24_cbJasaPengiriman'), Keys.chord(Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.ENTER))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/05_generalInfo/08_btnVerifierId'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/05_generalInfo/09_btnFindInfoVerifierID'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/05_generalInfo/10_btnDataFirst'))

	}

	@Keyword
	def generalMPF(String so, String visitDate, String vID, String caCoord) {
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/05_generalInfo/01_sourceOrder/01_fldSourceOrderId'), so)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/18_fldVisitDate'), visitDate)
		WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/19_fldTime'), Keys.chord(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE))
		WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/19_fldTime'), Keys.chord(Keys.NUMPAD0, Keys.NUMPAD9, Keys.NUMPAD0, Keys.NUMPAD0))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/23_chkCeklisPreFlag'))
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/22_fldVerifier'), vID)
		WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/22_fldVerifier'), Keys.chord(Keys.TAB))
		WebUI.delay(2)
		//		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/MPF/04_fldCACoord'), caCoord)
		//		WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/MPF/04_fldCACoord'), Keys.chord(Keys.TAB))
		WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/24_cbJasaPengiriman'), Keys.chord(Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.ENTER))
	}

	@Keyword
	def salesInfo(String salesType, String salesID) {
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/06_salesInfo/01_AddRow'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/06_salesInfo/06_cbSalesType'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/25_cbVarSalesType', [('salesType') : salesType]))
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/06_salesInfo/02_fldAoID1'), salesID)
		WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/06_salesInfo/02_fldAoID1'), Keys.chord(Keys.TAB))
	}

	@Keyword
	def salesInfoUFI(String salesType1, String salesIdInfo1, String salesType2, String salesIdInfo2, String salesType3, String salesIdInfo3) {
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/06_salesInfo/01_AddRow'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/06_salesInfo/06_cbSalesType'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/25_cbVarSalesType', [('salesType') : salesType1]))
		WebUI.delay(2)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/06_salesInfo/02_fldAoID1'), salesIdInfo1)
		WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/06_salesInfo/02_fldAoID1'), Keys.chord(Keys.TAB))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/06_salesInfo/01_AddRow'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/06_salesInfo/07_cbSalesType2'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/25_cbVarSalesType', [('salesType') : salesType2]))
		WebUI.delay(2)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/06_salesInfo/03_fldAoID2'), salesIdInfo2)
		WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/06_salesInfo/03_fldAoID2'), Keys.chord(Keys.TAB))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/06_salesInfo/01_AddRow'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/06_salesInfo/08_cbSalesType3'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/25_cbVarSalesType', [('salesType') : salesType3]))
		WebUI.delay(3)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/06_salesInfo/04_fldAoID3'), salesIdInfo3)
		WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/06_salesInfo/04_fldAoID3'), Keys.chord(Keys.TAB))
	}

	@Keyword
	def salesInfoMPF(String salesType1, String salesIdInfo1, String salesType2, String salesIdInfo2) {
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/06_salesInfo/01_AddRow'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/06_salesInfo/06_cbSalesType'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/25_cbVarSalesType', [('salesType') : salesType1]))
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/06_salesInfo/02_fldAoID1'), salesIdInfo1)
		WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/06_salesInfo/02_fldAoID1'), Keys.chord(Keys.TAB))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/06_salesInfo/01_AddRow'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/06_salesInfo/07_cbSalesType2'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/25_cbVarSalesType', [('salesType') : salesType2]))
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/06_salesInfo/03_fldAoID2'), salesIdInfo2)
		WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/06_salesInfo/03_fldAoID2'), Keys.chord(Keys.TAB))
	}

	@Keyword
	def salesInfoNMC(String salesType1, String salesIdInfo1, String salesType2, String salesIdInfo2)
	{
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/06_salesInfo/01_AddRow'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/06_salesInfo/06_cbSalesType'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/25_cbVarSalesType', [('salesType') : salesType1]))
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/06_salesInfo/02_fldAoID1'), salesIdInfo1)
		WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/06_salesInfo/02_fldAoID1'), Keys.chord(Keys.TAB))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/06_salesInfo/01_AddRow'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/06_salesInfo/07_cbSalesType2'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/25_cbVarSalesType', [('salesType') : salesType2]))
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/06_salesInfo/03_fldAoID2'), salesIdInfo2)
		WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/06_salesInfo/03_fldAoID2'), Keys.chord(Keys.TAB))
	}
	@Keyword
	def addDocument(String ktp, String kk, String ktpPasangan) {
		//		def projectDir = RunConfiguration.getProjectDir()
		//		Path projectPath = Paths.get(projectDir)
		//		Path imageFile1 = projectPath.resolve('Data Files').resolve(ktp)
		//		Path imageFile2 = projectPath.resolve('Data Files').resolve(kk)
		//		Path imageFile3 = projectPath.resolve('Data Files').resolve(ktpPasangan)
		//		String jpgFile = imageFile1
		//		String jpgFile2 = imageFile2
		//		String jpgFile3 = imageFile3

		// Define the file path relative to the project directory
		String filePath = '/Data Files/ktp testing.jpeg'

		// Concatenate the file path with the project directory
		String jpgFile = RunConfiguration.getProjectDir() + filePath

		WebUI.delay(3)
		WebUI.waitForPageLoad(10)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/07_documentChecklist/04_btnDocChecklist'))
		WebUI.delay(3)
		WebUI.waitForPageLoad(10)
		WebUI.click(findTestObject('FIFCORE Test Object/Initial Order Test Object/07_documentChecklist/06_chkDocNameKTP'))
		WebUI.waitForPageLoad(10)
		WebUI.delay(3)
		WebUI.click(findTestObject('FIFCORE Test Object/Initial Order Test Object/07_documentChecklist/09_fldUploadDocKTP'))
		WebUI.delay(3)

		WebUI.waitForPageLoad(10)
		WebUI.uploadFile(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/18_fldUploadDoc'), jpgFile)
		//utilities.uploadFile(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/26_btnVarBtnBrowse'), jpgFile)
		WebUI.delay(2)
		WebUI.waitForPageLoad(10)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/07_documentChecklist/01_btnOk'))
		//		WebUI.waitForPageLoad(10)
		//		WebUI.click(findTestObject('FIFCORE Test Object/Initial Order Test Object/07_documentChecklist/05_chkDocNameKK'))
		//		WebUI.waitForPageLoad(10)
		//		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/07_documentChecklist/08_fldUploadDocKK'))
		//		WebUI.waitForPageLoad(10)
		//		WebUI.uploadFile(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/18_fldUploadDoc'), jpgFile)
		//		//		utilities.uploadFile(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/26_btnVarBtnBrowse'), jpgFile2)
		//		//		WebUI.delay(2)
		//		WebUI.waitForPageLoad(10)
		//		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/07_documentChecklist/01_btnOk'))
		//		WebUI.waitForPageLoad(10)
		//		WebUI.click(findTestObject('FIFCORE Test Object/Initial Order Test Object/07_documentChecklist/07_chkDocNameKTPIstri'))
		//		WebUI.waitForPageLoad(10)
		//		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/07_documentChecklist/10_fldUploadDocKTPIstri'))
		//		WebUI.waitForPageLoad(10)
		//		WebUI.uploadFile(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/18_fldUploadDoc'), jpgFile)
		//		//		utilities.uploadFile(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/26_btnVarBtnBrowse'), jpgFile3)
		//		//		WebUI.delay(2)
		//		WebUI.waitForPageLoad(10)
		//		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/07_documentChecklist/01_btnOk'))
		//		WebUI.waitForPageLoad(10)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/07_documentChecklist/02_btnOkUpload'))
		WebUI.waitForPageLoad(10)
	}
	@Keyword
	def addDocumentNMCRO(String ktp, String kk, String ktpPasangan) {
		//		def projectDir = RunConfiguration.getProjectDir()
		//		Path projectPath = Paths.get(projectDir)
		//		Path imageFile1 = projectPath.resolve('Data Files').resolve(ktp)
		//		Path imageFile2 = projectPath.resolve('Data Files').resolve(kk)
		//		Path imageFile3 = projectPath.resolve('Data Files').resolve(ktpPasangan)
		//		String jpgFile = imageFile1
		//		String jpgFile2 = imageFile2
		//		String jpgFile3 = imageFile3

		// Define the file path relative to the project directory
		String filePath = '/Data Files/ktp testing.jpeg'

		// Concatenate the file path with the project directory
		String jpgFile = RunConfiguration.getProjectDir() + filePath

		WebUI.waitForPageLoad(10)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/07_documentChecklist/04_btnDocChecklist'))
		WebUI.waitForPageLoad(10)
		WebUI.click(findTestObject('FIFCORE Test Object/Initial Order Test Object/07_documentChecklist/06_chkDocNameKTP'))
		WebUI.waitForPageLoad(10)
		WebUI.click(findTestObject('FIFCORE Test Object/Initial Order Test Object/07_documentChecklist/09_fldUploadDocKTP'))
		WebUI.waitForPageLoad(10)
		WebUI.uploadFile(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/18_fldUploadDoc'), jpgFile)
		//utilities.uploadFile(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/26_btnVarBtnBrowse'), jpgFile)
		WebUI.delay(2)
		WebUI.waitForPageLoad(10)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/07_documentChecklist/01_btnOk'))
		WebUI.waitForPageLoad(10)
		WebUI.click(findTestObject('FIFCORE Test Object/Initial Order Test Object/07_documentChecklist/05_chkDocNameKK'))
		WebUI.waitForPageLoad(10)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/07_documentChecklist/08_fldUploadDocKK'))
		WebUI.waitForPageLoad(10)
		WebUI.uploadFile(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/18_fldUploadDoc'), jpgFile)
		//		utilities.uploadFile(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/26_btnVarBtnBrowse'), jpgFile2)
		//		WebUI.delay(2)
		WebUI.waitForPageLoad(10)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/07_documentChecklist/01_btnOk'))
		WebUI.waitForPageLoad(10)
		WebUI.click(findTestObject('FIFCORE Test Object/Initial Order Test Object/07_documentChecklist/07_chkDocNameKTPIstri'))
		WebUI.waitForPageLoad(10)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/07_documentChecklist/10_fldUploadDocKTPIstri'))
		WebUI.waitForPageLoad(10)
		WebUI.uploadFile(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/18_fldUploadDoc'), jpgFile)
		//		utilities.uploadFile(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/26_btnVarBtnBrowse'), jpgFile3)
		//		WebUI.delay(2)
		WebUI.waitForPageLoad(10)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/07_documentChecklist/01_btnOk'))
		WebUI.waitForPageLoad(10)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/07_documentChecklist/02_btnOkUpload'))
		WebUI.waitForPageLoad(10)
	}
	@Keyword
	def promo(String calculationMethod , String promo) {
		WebUI.delay(1)
		WebUI.focus(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/1_tenor/1_autoInvoice/13_cbCalculationMethod'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/1_tenor/1_autoInvoice/13_cbCalculationMethod'))
		if(calculationMethod == 'DECLINE') {
			WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/1_tenor/1_autoInvoice/13_cbCalculationMethod'), Keys.chord(Keys.DOWN, Keys.ENTER))
		} else if(calculationMethod == 'ANNUITY') {
			WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/1_tenor/1_autoInvoice/13_cbCalculationMethod'), Keys.chord(Keys.DOWN, Keys.DOWN, Keys.ENTER))
		} else if(calculationMethod == 'NEW DECLINE (IRREGULAR CASHFLOW)') {
			WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/1_tenor/1_autoInvoice/13_cbCalculationMethod'), Keys.chord(Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.ENTER))
		} else if(calculationMethod == 'BASED ON CUSTOMER CASHFLOW') {
			WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/1_tenor/1_autoInvoice/13_cbCalculationMethod'), Keys.chord(Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.ENTER))
		} else if(calculationMethod == 'BALLOON') {
			WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/1_tenor/1_autoInvoice/13_cbCalculationMethod'), Keys.chord(Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.ENTER))
		} else if(calculationMethod == 'FIXED PRINCIPAL') {
			WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/1_tenor/1_autoInvoice/13_cbCalculationMethod'), Keys.chord(Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.ENTER))
		} else if(calculationMethod == 'STEP UP (BASED ON O/S PRINCIPAL)') {
			WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/1_tenor/1_autoInvoice/13_cbCalculationMethod'), Keys.chord(Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.ENTER))
		} else if(calculationMethod == 'STEP DOWN (BASED ON O/S PRINCIPAL)') {
			WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/1_tenor/1_autoInvoice/13_cbCalculationMethod'), Keys.chord(Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.ENTER))
		} else if(calculationMethod == 'CUSTOM BALLOON') {
			WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/1_tenor/1_autoInvoice/13_cbCalculationMethod'), Keys.chord(Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.ENTER))
		} else if(calculationMethod == 'SEASONAL') {
			WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/1_tenor/1_autoInvoice/13_cbCalculationMethod'), Keys.chord(Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.ENTER))
		}
		//		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/1_tenor/1_autoInvoice/16_cbVarCalculationMethod', [('calculationMethod') : calculationMethod]))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/1_tenor/1_autoInvoice/14_cbFrequency'))
		WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/1_tenor/1_autoInvoice/14_cbFrequency'), Keys.chord(Keys.DOWN, Keys.ENTER))
		//		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/1_tenor/1_autoInvoice/18_btnVarFrequency'))
		WebUI.delay(3)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/1_tenor/1_autoInvoice/15_cbFrequencySecond'))
		WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/1_tenor/1_autoInvoice/15_cbFrequencySecond'), Keys.chord(Keys.DOWN, Keys.ENTER))
		//		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/1_tenor/1_autoInvoice/17_btnFirstData'))
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
	def promoMPF(String calculationMethod) {
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/1_tenor/1_autoInvoice/13_cbCalculationMethod'))
		WebUI.waitForPageLoad(10)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/1_tenor/1_autoInvoice/16_cbVarCalculationMethod', [('calculationMethod') : calculationMethod]))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/1_tenor/1_autoInvoice/14_cbFrequency'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/1_tenor/1_autoInvoice/18_btnVarFrequency'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/1_tenor/1_autoInvoice/15_cbFrequencySecond'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/1_tenor/1_autoInvoice/17_btnFirstData'))
	}

	@Keyword
	def promoMMQ(String installmentType) {

		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/2_Syariah/13_fldInstallmentType'))

		switch (installmentType) {
			case 'ANNUITY':
					WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/2_Syariah/13_fldInstallmentType'), Keys.chord(Keys.DOWN, Keys.ENTER));break;
			//					WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/2_Syariah/cb_InstallmentType_ANNUITY')); break;
			case 'NEW DECLINE (IRREGULAR CASHFLOW)' :
					WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/2_Syariah/08_cbInstallmentTypeNEW DECLINE (IRREGULAR CASHFLOW)')); break;
			case 'BASED ON CUSTOMER CASHFLOW' :
					WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/2_Syariah/05_cbInstallmentTypeBASED ON CUSTOMER CASHFLOW')); break;
			case 'BALLOON':
					WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/2_Syariah/04_cbInstallmentTypeBALLOON')); break;
			case 'FIXED PRINCIPAL' :
					WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/2_Syariah/07_cbInstallmentTypeFIXED PRINCIPAL')); break;
			case 'STEP UP (BASED ON O/S PRINCIPAL)' :
					WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/2_Syariah/11_cbInstallmentTypeSTEP UP (BASED ON OS PRINCIPAL)')); break;
			case 'STEP DOWN (BASED ON O/S PRINCIPAL)':
					WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/2_Syariah/10_cbInstallmentTypeSTEP DOWN (BASED ON OS PRINCIPAL)')); break;
			case 'CUSTOM BALLOON' :
					WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/2_Syariah/06_cbInstallmentTypeCUSTOM BALLOON')); break;
			case 'SEASONAL' :
					WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/2_Syariah/09_cbInstallmentTypeSEASONAL')); break;
		}
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/2_Syariah/12_fldFrequency'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/2_Syariah/01_cbFrequencyMonthly'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/2_Syariah/14_fldNumberFrequency'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/04_objectFinance/2_Syariah/02_cbFrequencyNumberRow2'))

	}
	@Keyword
	def inputApCabang() {
		//		if(RunConfiguration.getExecutionProfile()=='UAT') {
		//			KeywordUtil.logInfo('Input AP Cabang skipped because its optional')
		//		} else {
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/08_apCabang/01_btnAddRow'),FailureHandling.OPTIONAL)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/08_apCabang/02_btnApCabang'),FailureHandling.OPTIONAL)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/05_generalInfo/09_btnFindInfoVerifierID'),FailureHandling.OPTIONAL)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/08_apCabang/03_btnDataFirstApCabang'),FailureHandling.OPTIONAL)
		//		}
	}

	@Keyword
	def submitData() {
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/12_btnSubmit'))
		WebUI.waitForPageLoad(60)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/13_btnYesSaveData'))
		WebUI.waitForPageLoad(60)
		if(WebUI.verifyElementVisible(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/09_Update/01_dlgRejectTreatment'), FailureHandling.OPTIONAL)) {
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/11_btnOkInformation'))
		} else {
			KeywordUtil.logInfo('Tidak Muncul Reject Treatment')
		}
		WebUI.waitForPageLoad(60)
		String teksOrder = WebUI.getText(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/27_lblGetTextOrder')).replaceAll("[^0-9]", "")
		GlobalVariable.teksOrder = teksOrder
		KeywordUtil.logInfo('Nomor Order : ' + GlobalVariable.teksOrder)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/11_btnOkInformation'))
		WebUI.waitForPageLoad(60)
	}
	@Keyword
	def submitDataMMQ ( String ojk, String occupationonId, String occupation, String subOccupation) {
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
		WebUI.waitForPageLoad(60)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/11_btnOkInformation'), FailureHandling.OPTIONAL)
		//		String teksOrder = WebUI.getText(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/27_lblGetTextOrder',)).replaceAll("[^0-9]", "")
		String teksOrder =  WebUI.getAttribute(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/19_getTextOrderID'),"value")
		GlobalVariable.teksOrder = teksOrder
		KeywordUtil.logInfo('Nomor Order : ' +GlobalVariable.teksOrder)
		//WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/11_btnOkInformation'), FailureHandling.OPTIONAL)

		//		WebUI.waitForPageLoad(60)
		//		WebUI.takeScreenshot()
		//		if(WebUI.getText(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/27_lblGetTextOrder')).contains('Instant Approval')) {
		//			GlobalVariable.instantApproval = 'true'
		//		}
		//		if(RunConfiguration.getExecutionProfile()=='UAT') {
		//			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/11_btnOkInformation'),FailureHandling.OPTIONAL)
		//			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/11_btnOkInformation'),FailureHandling.OPTIONAL)
		//			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/11_btnOkInformation'),FailureHandling.OPTIONAL)
		//			WebUI.takeScreenshot()
		//		}
		//		WebUI.waitForPageLoad(60)
		//		String teksOrder = WebUI.getText(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/27_lblGetTextOrder')).replaceAll("[^0-9.]", "")
		//		GlobalVariable.teksOrder = teksOrder
		//		KeywordUtil.logInfo('Nomor Order : ' + GlobalVariable.teksOrder)
		//		KeywordUtil.logInfo('Customer Number : ' + GlobalVariable.customerNo)
		//		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/11_btnOkInformation'))
		GlobalVariable.customerNo = WebUI.getAttribute(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/02_custInfo/15_customerNo/01_lblCustomerNo'),"value")
		KeywordUtil.logInfo(GlobalVariable.customerNo)
		WebUI.delay(5)
		WebUI.waitForPageLoad(60)
	}
	@Keyword
	def submitDataNMCRO(String ojk, String occupationonId, String occupation, String subOccupation, String address) {
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
		while(WebUI.verifyElementPresent(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/14_dlgMsgAddressKosong'),5,FailureHandling.OPTIONAL)) {
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/24_btnOKMailbox'),FailureHandling.OPTIONAL)
			WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/03_addrVerification/1_addressDetail/02_fldAddress'), address)
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/12_btnSubmit'))
		}
		WebUI.takeScreenshot()
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/13_btnYesSaveData'))
		WebUI.waitForPageLoad(60)
		if(WebUI.verifyElementVisible(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/09_Update/01_dlgRejectTreatment'), FailureHandling.OPTIONAL)) {
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/11_btnOkInformation'))
		} else {
			KeywordUtil.logInfo('Tidak Muncul Reject Treatment')

		}
		WebUI.takeScreenshot()
		WebUI.waitForPageLoad(60)
		String teksOrder = WebUI.getText(findTestObject('Object Repository/FIFCORE Test Object/New Order Test Object/27_lblGetTextOrder')).replaceAll("[^0-9]", "")
		GlobalVariable.teksOrder = teksOrder
		KeywordUtil.logInfo('Nomor Order : ' + GlobalVariable.teksOrder)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Initial Order Test Object/11_btnOkInformation'))
		WebUI.waitForPageLoad(60)
	}
}
