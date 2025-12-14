package id.co.fifgroup.fifcore

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import groovy.transform.CompileStatic
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
import com.kms.katalon.core.webui.keyword.internal.WebUIAbstractKeyword
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import org.openqa.selenium.Keys as Keys
import internal.GlobalVariable
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.By
import id.co.fifgroup.fifcore.utilities
import com.kms.katalon.core.configuration.RunConfiguration


public class customerMaintenance {

	/**
	 *  Use for search Order Number In Customer Maintenance
	 * @param orderNumber
	 */
	@CompileStatic
	@Keyword
	public static void inquiryNomorOrder(String orderNumber) {
		//		if(RunConfiguration.getExecutionProfile()=='UAT') {
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Performance Test Purpose Test Object/08_lblCustomerNumber'), orderNumber)
		//		} else {
		//			WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Customer Mintenance/00_inputTxt_orderNumber'), orderNumber)
		//		}
		//		if(customerNumber !=  null) {
		//			WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/41_fldCustomerNumber'), customerNumber)
		//		}
		KeywordUtil.logInfo('ORDER_ID : '+GlobalVariable.teksOrder)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Approve Order Test Object/02_btnFind'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Approve Order Test Object/04_btnDetail'))
	}



	/**
	 *  Use for searcSh Order Number In Customer Maintenance
	 * @param orderNumber
	 */
	@CompileStatic
	@Keyword
	public static void idInfo(String customerName, String title, String nickname, String identityTipe, String identityNumber, String placeOfBirth, String dateOfBirth, String motherName,
			String customerFullName, String gender, String birthPlace, String address, String rt, String rw, String zipCode, String subZipCode, String province, String cityKabupaten,
			String kecamatan, String kelurahanDesa, String religion, String maritalStatus, String occupationOnId, String occupation, String nationality, String customerNumber) {
		String customerFullNameField = WebUI.getAttribute(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/01_fldCustomerName'), "value")
		//WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/01_fldCustomerName'), customerName)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/02_fldTitle'), title)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/03_fldNickname'), nickname)
		//		if (identityTipe == 'KTP'){
		//			WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/05_cbKTP'), Keys.chord(Keys.DOWN))
		//			WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/05_cbKTP'), Keys.chord(Keys.ENTER))
		//		} else if (identityTipe == 'RESI KTP') {
		//			for(int i = 0; i <2; i++) {
		//				WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/05_cbKTP'), Keys.chord(Keys.DOWN))
		//			}
		//			WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/05_cbKTP'), Keys.chord(Keys.ENTER))
		//		}
		//		//WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/07_fldIdentityNumber'), identityNumber)
		//		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/08_fldPlaceBirth'), placeOfBirth)
		//		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/09_fldDateBirth'), dateOfBirth)
		//		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/10_fldMotherName'), motherName)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/11_fldCustomerFullName'), customerFullNameField)
		//		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/12_btnGender'))
		//		if (identityTipe == 'MALE'){
		//			WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/12_btnGender'), Keys.chord(Keys.DOWN))
		//			WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/12_btnGender'), Keys.chord(Keys.ENTER))
		//		} else if (identityTipe == 'FEMALE') {
		//			for(int i = 0; i <2; i++) {
		//				WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/12_btnGender'), Keys.chord(Keys.DOWN))
		//			}
		//			WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/12_btnGender'), Keys.chord(Keys.ENTER))
		//		}

		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/13_fldBirthPlace'), birthPlace)
		WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/12_btnGender'), Keys.chord(Keys.ENTER))
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/14_fldAddress'), address)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/15_fldRT'), rt)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/16_fldRW'), rw)

		//Zip Code
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/17_btnZipCode'))
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/18_fldZipCode'), zipCode)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/05_btnFind'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/19_btnFirstResultZipCode'))

		//Sub Zip Code
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/20_btnSubZipCode'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/05_btnFind'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/32_btnFirstResultSubZipCode'))

		//		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/26_btnReligion'))
		//
		def religionMap = [
			'ISLAM': 2,
			'KRISTEN PROTESTAN': 3,
			'KRISTEN KHATOLIK': 4,
			'HINDU': 5,
			'BUDHA': 6,
			'KEPERCAYAAN': 7,
			'KONG HU CU': 8
		]

		def steps = religionMap[religion]

		if (steps != null) {
			for (def index : (1..steps)) {
				WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/34_cbReligion'), Keys.chord(Keys.DOWN))
			}
			WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/34_cbReligion'), Keys.chord(Keys.ENTER))
		}


		//		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/25_btnNationality'))
		if(nationality == 'WNI') {
			for(int i = 0; i <1; i++ ) {
				WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/26_cbNationality'), Keys.chord(Keys.DOWN))
			}
			WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/26_cbNationality'), Keys.chord(Keys.ENTER))
		}
		//		String isSingle = WebUI.getAttribute(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/37_lblMarital'), 'value')
		//		if(isSingle == 'SINGLE') {
		//			KeywordUtil.logInfo('Marital is Single')

		String isSingle = WebUI.getAttribute(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/37_lblMarital'), 'value')
		if(isSingle == 'SINGLE') {
			KeywordUtil.logInfo('Marital is Single')

		}else {
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/27_btnSpouseName'))
			WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/30_fldCustomerNumberSpouseName'), customerNumber)
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/01_btnFind'))
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/28_btnFirstResultSpouseName'))
		}
	}

	/**
	 *  Use for input in Customer Job Info and Financial Individual
	 * @param orderNumber
	 */
	@CompileStatic
	@Keyword
	public static void individualJob(String occupationType, String companyName, String sectorIndustry, String subSectorIndustry,
			String workSince, String salesIncome, String position, String companyAddress) {
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Customer Job Info dan Financial Individu/01_btnHeader'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/02_btnAddRowPlsChangeIndextoUse'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Customer Job Info dan Financial Individu/02_btnOccupationType'))
		if(occupationType == 'EMPLOYEE') {
			WebUI.click(findTestObject('Object Repository/Test/Page_IndividualJobBusinessInfo/21_cb_OccupationType_EMPLOYEE'))
		}else if(occupationType == 'NON EMPLOYEE') {
			WebUI.click(findTestObject('Object Repository/Test/Page_IndividualJobBusinessInfo/22_cb_OccupationType_NON EMPLOYEE'))
		}else if(occupationType == 'PROFESSIONAL') {
			WebUI.click(findTestObject('Object Repository/Test/Page_IndividualJobBusinessInfo/23_cb_OccupationType_PROFESSIONAL'))
		}
		(WebUI.waitForElementPresent(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Customer Job Info dan Financial Individu/03_fldCompanyName'),5))
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Customer Job Info dan Financial Individu/03_fldCompanyName'), companyName)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Customer Job Info dan Financial Individu/04_btnSectorIndustry'))
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/03_fldWithFormatCodenDesciption'), sectorIndustry)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/01_btnFind'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/04_btnFirstResult'))

		//		(WebUI.waitForElementPresent(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Customer Job Info dan Financial Individu/05_btnSubSectorIndustry'),5))

		//		WebUI.scrollToElement(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Customer Job Info dan Financial Individu/05_btnSubSectorIndustry07'), 0)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Customer Job Info dan Financial Individu/05_btnSubSectorIndustry'))
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/03_fldWithFormatCodenDesciption'), subSectorIndustry)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/01_btnFind'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/04_btnFirstResult'))

		//WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Customer Job Info dan Financial Individu/06_fldLicenseNumber'), licenseNumber)
		WebUI.scrollToElement(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Customer Job Info dan Financial Individu/07_fldWorkSince'), 10)

		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Customer Job Info dan Financial Individu/07_fldWorkSince'), workSince)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Customer Job Info dan Financial Individu/08_fldSalesTurnover'), salesIncome)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Customer Job Info dan Financial Individu/09_fldPositition'), position)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Customer Job Info dan Financial Individu/10_fldCompanyAddress'), companyAddress)
	}


	/**
	 *  Use for input in Customer Job Info and Financial Individual
	 * @param orderNumber
	 */
	@CompileStatic
	@Keyword
	public static void financialIndividual(String borrowerIncome, String spouseIncome, String otherIncome, String expense) {
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Customer Job Info dan Financial Individu/15_btnCcyBorrowerIncome'))
		for(int i = 0; i <2; i++) {
			WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Customer Job Info dan Financial Individu/15_btnCcyBorrowerIncome'), Keys.chord(Keys.DOWN))
		}
		WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Customer Job Info dan Financial Individu/15_btnCcyBorrowerIncome'), Keys.chord(Keys.ENTER))
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Customer Job Info dan Financial Individu/11_fldBorrowerIncome'), borrowerIncome)

		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Customer Job Info dan Financial Individu/16_btnCcySpouseIncome'))
		for(int i = 0; i <2; i++) {
			WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Customer Job Info dan Financial Individu/16_btnCcySpouseIncome'), Keys.chord(Keys.DOWN))
		}
		WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Customer Job Info dan Financial Individu/16_btnCcySpouseIncome'), Keys.chord(Keys.ENTER))
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Customer Job Info dan Financial Individu/12_fldSpouseIncome'), spouseIncome)

		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Customer Job Info dan Financial Individu/17_btnCcyOtherIncome'))
		for(int i = 0; i <2; i++) {
			WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Customer Job Info dan Financial Individu/17_btnCcyOtherIncome'), Keys.chord(Keys.DOWN))
		}
		WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Customer Job Info dan Financial Individu/17_btnCcyOtherIncome'), Keys.chord(Keys.ENTER))
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Customer Job Info dan Financial Individu/13_fldOtherIncome'), otherIncome)

		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Customer Job Info dan Financial Individu/18_btnCcyExpense'))
		for(int i = 0; i <2; i++) {
			WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Customer Job Info dan Financial Individu/18_btnCcyExpense'), Keys.chord(Keys.DOWN))
		}
		WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Customer Job Info dan Financial Individu/18_btnCcyExpense'), Keys.chord(Keys.ENTER))
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Customer Job Info dan Financial Individu/14_fldExpense'), expense)
	}

	/**
	 *  Use for input in Customer Job Info and Financial Individual
	 * @param orderNumber
	 */
	@CompileStatic
	@Keyword
	public static void inputEmergencyInfo(String name, String relationship, String occupationType, String companyName, String companyAddress) {
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Emergency Info/00_btnEmergencyInfo'))
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Emergency Info/01_fldName'), name)

		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Emergency Info/02_btnRelationship'))
		def relationshipMap = [
			'SUAMI': 1,
			'ISTERI': 2,
			'ANAK': 3,
			'AYAH': 4,
			'IBU': 5,
			'KAKAK': 6,
			'ADIK': 7,
			'KAKEK': 8,
			'NENEK': 9,
			'CUCU': 10,
			'SEPUPU': 11,
			'KEPONAKAN': 12,
			'PAMAN': 13,
			'BIBI': 14,
			'BESAN': 15,
			'MERTUA': 16,
			'MENANTU': 17,
			'IPAR': 18,
			'SAHABAT': 19,
			'TETANGGA': 20,
			'PEMIMPIN LOKAL': 21,
			'REKAN KERJA': 22,
			'ATASAN': 23,
			'BAWAHAN': 24,
			'ORANG TUA': 25,
			'SAUDARA': 26,
			'LAIN-LAIN': 27,
		]

		def steps = relationshipMap[relationship]

		if (steps != null) {
			for (def index : (0..steps)) {
				WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Emergency Info/02_btnRelationship'), Keys.chord(Keys.DOWN))
			}
			WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Emergency Info/02_btnRelationship'), Keys.chord(Keys.ENTER))
		}
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/05_cbOccupationType'))
		if(occupationType == 'EMPLOYEE') {
			WebUI.click(findTestObject('Object Repository/Test/Page_IndividualJobBusinessInfo/21_cb_OccupationType_EMPLOYEE'))
		}else if(occupationType == 'NON EMPLOYEE') {
			WebUI.click(findTestObject('Object Repository/Test/Page_IndividualJobBusinessInfo/22_cb_OccupationType_NON EMPLOYEE'))
		}else if(occupationType == 'PROFESSIONAL') {
			WebUI.click(findTestObject('Object Repository/Test/Page_IndividualJobBusinessInfo/23_cb_OccupationType_PROFESSIONAL'))
		}
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Emergency Info/03_fldCompanyName'), companyName)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Emergency Info/04_fldCompanyAddress'), companyAddress)


	}

	/**
	 *  Use for input in Customer Job Info and Financial Individual RO
	 * @param orderNumber
	 */
	@CompileStatic
	@Keyword
	public static void inputEmergencyInfoAddressRO(String addressType, String address, String rt, String rw, String zipCode,
			String addressType1, String addressType2, String addressType3, String addressType4) {
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/13_btnAddEmergencyInfo'))

		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/35_btnAddressType'))
		//var
		def addressTypeMap = [
			'COLLECTION ADDRESS': 1,
			'HOME ADDRESS': 2,
			'MAILING ADDRESS': 3,
			'OFFICE ADDRESS': 4,
			'VERIFICATION ADDRESS': 5
		]
		def steps = addressTypeMap[addressType]

		if (steps != null) {
			for (def index : (1..steps)) {
				WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/35_btnAddressType'), Keys.chord(Keys.DOWN))
			}
			WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/35_btnAddressType'), Keys.chord(Keys.ENTER))
		}
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Emergency Info/05_fldAddress'), address)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Emergency Info/06_fldRT'), rt)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Emergency Info/07_fldRW'), rw)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Emergency Info/08_btnZipCode'))
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/07_fldModalId'), zipCode)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/01_btnFind'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/08_btnFirstResultRow'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Emergency Info/09_btnSubZipCode'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/01_btnFind'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/09_btnFirstResultSubZipCode'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/10_btnOK'))

		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/13_btnAddEmergencyInfo'))
		def steps1 = addressTypeMap[addressType1]
		if (steps1 != null) {
			for (def index : (1..steps1)) {
				WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/35_btnAddressType'), Keys.chord(Keys.DOWN))
			}
			WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/35_btnAddressType'), Keys.chord(Keys.ENTER))
		}
		if (steps != null) {
			for (def index : (0..steps)) {
				WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Emergency Info/10_btnCopyFrom'), Keys.chord(Keys.DOWN))
			}
			WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Emergency Info/10_btnCopyFrom'), Keys.chord(Keys.ENTER))
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Emergency Info/09_btnSubZipCode'))
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/01_btnFind'))
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/09_btnFirstResultSubZipCode'))
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/10_btnOK'))
		}

		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/13_btnAddEmergencyInfo'))
		def steps2 = addressTypeMap[addressType2]
		if (steps2 != null) {
			for (def index : (1..steps2)) {
				WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/35_btnAddressType'), Keys.chord(Keys.DOWN))
			}
			WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/35_btnAddressType'), Keys.chord(Keys.ENTER))
		}
		if (steps1 != null) {
			for (def index : (0..steps1)) {
				WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Emergency Info/10_btnCopyFrom'), Keys.chord(Keys.DOWN))
			}
			WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Emergency Info/10_btnCopyFrom'), Keys.chord(Keys.ENTER))
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Emergency Info/09_btnSubZipCode'))
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/01_btnFind'))
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/09_btnFirstResultSubZipCode'))
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/10_btnOK'))
		}

		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/13_btnAddEmergencyInfo'))
		def steps3 = addressTypeMap[addressType3]
		if (steps3 != null) {
			for (def index : (1..steps3)) {
				WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/35_btnAddressType'), Keys.chord(Keys.DOWN))
			}
			WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/35_btnAddressType'), Keys.chord(Keys.ENTER))
		}
		if (steps2 != null) {
			for (def index : (0..steps2)) {
				WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Emergency Info/10_btnCopyFrom'), Keys.chord(Keys.DOWN))
			}
			WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Emergency Info/10_btnCopyFrom'), Keys.chord(Keys.ENTER))
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Emergency Info/09_btnSubZipCode'))
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/01_btnFind'))
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/09_btnFirstResultSubZipCode'))
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/10_btnOK'))
		}

		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/13_btnAddEmergencyInfo'))
		def steps4 = addressTypeMap[addressType4]
		if (steps4 != null) {
			for (def index : (1..steps4)) {
				WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/35_btnAddressType'), Keys.chord(Keys.DOWN))
			}
			WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/35_btnAddressType'), Keys.chord(Keys.ENTER))
		}
		if (steps3 != null) {
			for (def index : (0..steps3)) {
				WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Emergency Info/10_btnCopyFrom'), Keys.chord(Keys.DOWN))
			}
			WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Emergency Info/10_btnCopyFrom'), Keys.chord(Keys.ENTER))
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Emergency Info/09_btnSubZipCode'))
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/01_btnFind'))
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/09_btnFirstResultSubZipCode'))
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/10_btnOK'))
		}
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Emergency Info/12_btnChecklist1'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Emergency Info/13_btnChecklist2'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Emergency Info/14_btnChecklist3'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Emergency Info/15_btnChecklist4'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Emergency Info/16_btnChecklist5'))

		//		WebDriver driver = DriverFactory.getWebDriver()
		//		WebElement TableTarget = driver.findElement(By.xpath("(//div[@class='z-listbox-body'])[11]//tbody[1]"))
		//		List<WebElement> rows_tableTarget = TableTarget.findElements(By.tagName('tr'))
		//		int rows_countTarget = rows_tableTarget.size()
		//		for ( int x=0; x<rows_countTarget; x++) {
		//				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/10_btnOK'), ['addRow' : x])
		//				WebUI.setText(findTestObject('Object Repository/MBS Parent Child Flag/Page Marketing/58 varTableTarget',['addCol' : i, 'addRow' : x]), addressType4)
		//			}
		//		}

		//		// Lakukan perulangan dari tr 1 hingga 5
		//		for (int trValue = 1; trValue <= 5; trValue++) {
		//		    String xpath = "(//div[@class='z-listbox-body'])[11]//tbody[1]/tr["+trValue.toString()+"]/td[9]//input"
		//			println(xpath)
		//			WebUI.click(findTestObject(xpath))
		//		}
	}

	/**
	 *  Use for input in Customer Job Info and Financial Individual
	 * @param orderNumber
	 */
	@CompileStatic
	@Keyword
	public static void inputEmergencyInfoAddress(String addressType, String address, String rt, String rw, String zipCode,
			String addressType1, String addressType2, String addressType3, String addressType4) {
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/13_btnAddEmergencyInfo'))

		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/35_btnAddressType'))
		//var
		def addressTypeMap = [
			'COLLECTION ADDRESS': 1,
			'HOME ADDRESS': 2,
			'MAILING ADDRESS': 3,
			'OFFICE ADDRESS': 4,
			'VERIFICATION ADDRESS': 5
		]
		def steps = addressTypeMap[addressType]

		if (steps != null) {
			for (def index : (1..steps)) {
				WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/35_btnAddressType'), Keys.chord(Keys.DOWN))
			}
			WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/35_btnAddressType'), Keys.chord(Keys.ENTER))
		}
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Emergency Info/05_fldAddress'), address)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Emergency Info/06_fldRT'), rt)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Emergency Info/07_fldRW'), rw)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Emergency Info/08_btnZipCode'))
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/07_fldModalId'), zipCode)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/01_btnFind'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/08_btnFirstResultRow'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Emergency Info/09_btnSubZipCode'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/01_btnFind'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/09_btnFirstResultSubZipCode'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/10_btnOK'))

		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/13_btnAddEmergencyInfo'))
		def steps1 = addressTypeMap[addressType1]
		if (steps1 != null) {
			for (def index : (1..steps1)) {
				WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/35_btnAddressType'), Keys.chord(Keys.DOWN))
			}
			WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/35_btnAddressType'), Keys.chord(Keys.ENTER))
		}
		if (steps != null) {
			for (def index : (0..steps)) {
				WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Emergency Info/10_btnCopyFrom'), Keys.chord(Keys.DOWN))
			}
			WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Emergency Info/10_btnCopyFrom'), Keys.chord(Keys.ENTER))
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Emergency Info/09_btnSubZipCode'))
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/01_btnFind'))
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/09_btnFirstResultSubZipCode'))
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/10_btnOK'))
		}

		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/13_btnAddEmergencyInfo'))
		def steps2 = addressTypeMap[addressType2]
		if (steps2 != null) {
			for (def index : (1..steps2)) {
				WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/35_btnAddressType'), Keys.chord(Keys.DOWN))
			}
			WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/35_btnAddressType'), Keys.chord(Keys.ENTER))
		}
		if (steps1 != null) {
			for (def index : (0..steps1)) {
				WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Emergency Info/10_btnCopyFrom'), Keys.chord(Keys.DOWN))
			}
			WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Emergency Info/10_btnCopyFrom'), Keys.chord(Keys.ENTER))
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Emergency Info/09_btnSubZipCode'))
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/01_btnFind'))
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/09_btnFirstResultSubZipCode'))
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/10_btnOK'))
		}

		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/13_btnAddEmergencyInfo'))
		def steps3 = addressTypeMap[addressType3]
		if (steps3 != null) {
			for (def index : (1..steps3)) {
				WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/35_btnAddressType'), Keys.chord(Keys.DOWN))
			}
			WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/35_btnAddressType'), Keys.chord(Keys.ENTER))
		}
		if (steps2 != null) {
			for (def index : (0..steps2)) {
				WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Emergency Info/10_btnCopyFrom'), Keys.chord(Keys.DOWN))
			}
			WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Emergency Info/10_btnCopyFrom'), Keys.chord(Keys.ENTER))
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Emergency Info/09_btnSubZipCode'))
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/01_btnFind'))
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/09_btnFirstResultSubZipCode'))
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/10_btnOK'))
		}

		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/13_btnAddEmergencyInfo'))
		def steps4 = addressTypeMap[addressType4]
		if (steps4 != null) {
			for (def index : (1..steps4)) {
				WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/35_btnAddressType'), Keys.chord(Keys.DOWN))
			}
			WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/35_btnAddressType'), Keys.chord(Keys.ENTER))
		}
		if (steps3 != null) {
			for (def index : (0..steps3)) {
				WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Emergency Info/10_btnCopyFrom'), Keys.chord(Keys.DOWN))
			}
			WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Emergency Info/10_btnCopyFrom'), Keys.chord(Keys.ENTER))
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Emergency Info/09_btnSubZipCode'))
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/01_btnFind'))
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/09_btnFirstResultSubZipCode'))
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/10_btnOK'))
		}

		WebUI.scrollToElement(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Emergency Info/12_btnChecklist1'), 10)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Emergency Info/12_btnChecklist1'))
		WebUI.scrollToElement(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Emergency Info/13_btnChecklist2'), 10)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Emergency Info/13_btnChecklist2'))
		WebUI.scrollToElement(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Emergency Info/14_btnChecklist3'), 10)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Emergency Info/14_btnChecklist3'))
		WebUI.scrollToElement(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Emergency Info/15_btnChecklist4'), 10)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Emergency Info/15_btnChecklist4'))
		WebUI.scrollToElement(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Emergency Info/16_btnChecklist5'), 10)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Emergency Info/16_btnChecklist5'))

		//		WebDriver driver = DriverFactory.getWebDriver()
		//		WebElement TableTarget = driver.findElement(By.xpath("(//div[@class='z-listbox-body'])[11]//tbody[1]"))
		//		List<WebElement> rows_tableTarget = TableTarget.findElements(By.tagName('tr'))
		//		int rows_countTarget = rows_tableTarget.size()
		//		for ( int x=0; x<rows_countTarget; x++) {
		//				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/10_btnOK'), ['addRow' : x])
		//				WebUI.setText(findTestObject('Object Repository/MBS Parent Child Flag/Page Marketing/58 varTableTarget',['addCol' : i, 'addRow' : x]), addressType4)
		//			}
		//		}

		//		// Lakukan perulangan dari tr 1 hingga 5
		//		for (int trValue = 1; trValue <= 5; trValue++) {
		//		    String xpath = "(//div[@class='z-listbox-body'])[11]//tbody[1]/tr["+trValue.toString()+"]/td[9]//input"
		//			println(xpath)
		//			WebUI.click(findTestObject(xpath))
		//		}
	}

	/**
	 *  Use for input in Customer Job Info and Financial Individual
	 * @param orderNumber
	 */
	@CompileStatic
	@Keyword
	public static void inputEmergencyInfoContactInfo(String contactType1, String contactType2, String contactType3,
			String email, String phoneNumber1, String phoneNumber2, String specialNotes) {
		int contactInfoMuch = 3
		for(int i = 1; i <= contactInfoMuch; i++) {
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/11_btnAddRowContactInfo'))
		}

		//var
		def contactTypeMap = [
			'EMAIL': 1,
			'FAX': 2,
			'HOUSE': 3,
			'MOBILE': 4,
			'2': 5,
			'OFFICE':6
		]
		def steps = contactTypeMap[contactType1]

		if (steps != null) {
			for (def index : (0..steps)) {
				WebUI.scrollToElement(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Emergency Info/17_btnContactType'), 10)

				WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Emergency Info/17_btnContactType'), Keys.chord(Keys.DOWN))
			}
			WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Emergency Info/17_btnContactType'), Keys.chord(Keys.ENTER))

			WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Emergency Info/18_fldContactInfo1'), email)
			if(RunConfiguration.getExecutionProfile()=='TEST') {
				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Performance Test Purpose Test Object/13_chkPrimaryEmail'))

			}else {
				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Performance Test Purpose Test Object/20_chkPrimaryEmail - UAT'))
			}

		}


		if(contactType2 == 'MOBILE PHONE 1') {
			WebUI.scrollToElement(findTestObject('Object Repository/FIFCORE Test Object/Performance Test Purpose Test Object/10_btnContactType2'), 10)
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Performance Test Purpose Test Object/10_btnContactType2'))
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Performance Test Purpose Test Object/11_btnMobilePhone1'))
			if(WebUI.verifyElementPresent(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Emergency Info/39_vrlPopUPZLabel'), 3, FailureHandling.OPTIONAL)) {
				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Emergency Info/40_btnOkPopUp'), FailureHandling.OPTIONAL)
			}
			WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Emergency Info/33_fldMobilePhone1'), phoneNumber1, FailureHandling.OPTIONAL)
			if(RunConfiguration.getExecutionProfile()=='TEST') {
				if(WebUI.verifyElementNotChecked(findTestObject('Object Repository/FIFCORE Test Object/Performance Test Purpose Test Object/14_chkPrimaryMobilePhone1'), 0, FailureHandling.OPTIONAL)) {
					WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Performance Test Purpose Test Object/14_chkPrimaryMobilePhone1'))
				}
			}else {
				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Performance Test Purpose Test Object/22_chkPrimaryMobilePhone1 - UAT'))
			}
			//						for(int i=0;i<=8;i++) {
			//							//WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Emergency Info/26_btnContactType3'))
			//							WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Emergency Info/25_btnContactType2'), Keys.chord(Keys.DOWN))
			//						}
			//						WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Emergency Info/25_btnContactType2'), Keys.chord(Keys.ENTER))
			//						WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Emergency Info/19_fldContactInfo2'), phoneNumber1)
			//						WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Emergency Info/21_chkSmartphone1'))

		}



		if(contactType3 == 'MOBILE PHONE 2') {
			//WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Emergency Info/26_btnContactType3'))
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Emergency Info/42_chkMobilePhone2'))
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Emergency Info/27_cbMobilePhone2'))
			WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Emergency Info/34_fldMobilePhone2'), phoneNumber2)
			if(RunConfiguration.getExecutionProfile()=='TEST') {
				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Performance Test Purpose Test Object/15_chkPrimaryMobilePhone2'))

			}else {
				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Performance Test Purpose Test Object/21_chkPrimaryMobilePhone2 - UAT'))
			}

			//					def steps2 = contactTypeMap[contactType3]
			//					if (steps2 != null) {
			//						for (def index : (1..steps2)) {
			//							WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Emergency Info/26_btnContactType3'), Keys.chord(Keys.DOWN))
			//						}
			//						WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Emergency Info/26_btnContactType3'), Keys.chord(Keys.ENTER))
			//						WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Emergency Info/22_fldContactInfo3'), phoneNumber2)
			//						WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Emergency Info/23_chkSmartphone2'))
			//						WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Emergency Info/24_chkPrimary2'))
			//					}

			WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Emergency Info/28_fldSpecialNotes'), specialNotes)
		}


	}

	//CompileStatic
	@Keyword
	public static void inputEmergencyINfoContactInfo1(String contactType1, String contactType2, String contactType3, String email,
			String phoneNumber1, String phoneNumber2, String notes) {

		int contactInfoMuch = 3

		for(int i = 1; i <= contactInfoMuch; i++) {
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/11_btnAddRowContactInfo'))
		}

		//var
		def contactTypeMap = [
			'EMAIL': 1,
			'FAX': 2,
			'HOUSE': 3,
			'MOBILE': 4,
			'2': 5,
			'OFFICE':6
		]
		def steps = contactTypeMap[contactType1]

		if (steps != null) {
			for (def index : (0..steps)) {
				WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Emergency Info/17_btnContactType'), Keys.chord(Keys.DOWN))
			}
			WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Emergency Info/17_btnContactType'), Keys.chord(Keys.ENTER))
			WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Emergency Info/18_fldContactInfo1'), email)
			if(RunConfiguration.getExecutionProfile()=='TEST') {
				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Performance Test Purpose Test Object/13_chkPrimaryEmail'))

			}else {
				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Performance Test Purpose Test Object/20_chkPrimaryEmail - UAT'))
			}

		}
		if(contactType2 == 'MOBILE PHONE 1') {
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Performance Test Purpose Test Object/10_btnContactType2'))
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Performance Test Purpose Test Object/11_btnMobilePhone1'))
			//if(WebUI.verifyElementPresent(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Emergency Info/39_vrlPopUPZLabel'), 3, FailureHandling.STOP_ON_FAILURE)) {
			//WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Emergency Info/40_btnOkPopUp'), FailureHandling.STOP_ON_FAILURE)
			//}
			WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Emergency Info/33_fldMobilePhone1'), phoneNumber1, FailureHandling.OPTIONAL)
			if(RunConfiguration.getExecutionProfile()=='TEST') {
				if(WebUI.verifyElementNotChecked(findTestObject('Object Repository/FIFCORE Test Object/Performance Test Purpose Test Object/14_chkPrimaryMobilePhone1'), 0, FailureHandling.OPTIONAL)) {
					WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Performance Test Purpose Test Object/14_chkPrimaryMobilePhone1'))
				}
			}else {
				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Performance Test Purpose Test Object/22_chkPrimaryMobilePhone1 - UAT'))
			}
		}

		//if(contactType2 == 'MOBILE PHONE 2') {
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Emergency Info/26_btnContactType3'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Emergency Info/27_cbMobilePhone2'))
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Emergency Info/34_fldMobilePhone2'), phoneNumber2)
		if(RunConfiguration.getExecutionProfile()=='TEST') {
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Performance Test Purpose Test Object/15_chkPrimaryMobilePhone2'))

		}else {
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Performance Test Purpose Test Object/21_chkPrimaryMobilePhone2 - UAT'))
		}

		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Emergency Info/28_fldSpecialNotes'), notes)

		//}


	}


	//@CompileStatic
	@Keyword
	public static void inputEmergencyInfoContactInfoNMCRO(String contactType1, String contactType2, String contactType3,
			String email, String phoneNumber1, String phoneNumber2, String specialNotes, int howMuchContactInfo) {
		int contactInfoMuch = 3
		for(int i = 1; i <= contactInfoMuch; i++) {
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/11_btnAddRowContactInfo'))
		}

		//var
		def contactTypeMap = [
			'EMAIL': 1,
			'FAX': 2,
			'HOUSE': 3,
			'MOBILE': 4,
			'2': 5,
			'OFFICE':6
		]
		def steps = contactTypeMap[contactType1]

		if (steps != null) {
			for (def index : (0..steps)) {
				WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Emergency Info/17_btnContactType'), Keys.chord(Keys.DOWN))
			}
			WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Emergency Info/17_btnContactType'), Keys.chord(Keys.ENTER))
			WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Emergency Info/18_fldContactInfo1'), email)
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Emergency Info/20_btnChecklist1'))
		}

		if(contactType2 == 'MOBILE PHONE 1') {
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Performance Test Purpose Test Object/10_btnContactType2'))
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Performance Test Purpose Test Object/11_btnMobilePhone1'))
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Performance Test Purpose Test Object/11_btnMobilePhone1'))
			WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Emergency Info/33_fldMobilePhone1'), phoneNumber1)
			if(RunConfiguration.getExecutionProfile()=='TEST') {
				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Performance Test Purpose Test Object/14_chkPrimaryMobilePhone1'))

			}else {
				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Performance Test Purpose Test Object/22_chkPrimaryMobilePhone1 - UAT'))
			}

		}

		if(contactType3 == 'MOBILE PHONE 2') {
			for(int i=0;i<=8;i++) {
				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Emergency Info/26_btnContactType3'))
				//WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Emergency Info/25_btnContactType2'), Keys.chord(Keys.DOWN))
			}
			WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Emergency Info/25_btnContactType2'), Keys.chord(Keys.ENTER))
			WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Emergency Info/19_fldContactInfo2'), phoneNumber1)
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Emergency Info/21_chkSmartphone1'))

		}



		def steps1 = contactTypeMap[contactType2]
		if (steps1 != null) {
			for (def index : (0..steps1)) {
				WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Emergency Info/26_btnContactType3'), Keys.chord(Keys.DOWN))
			}
			WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Emergency Info/26_btnContactType3'), Keys.chord(Keys.ENTER))
			WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Emergency Info/22_fldContactInfo3'), phoneNumber2)
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Emergency Info/23_chkSmartphone2'))
		}

		//		def steps2 = contactTypeMap[contactType3]
		//		if (steps2 != null) {
		//			for (def index : (1..steps2)) {
		//				WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Emergency Info/26_btnContactType3'), Keys.chord(Keys.DOWN))
		//			}
		//			WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Emergency Info/26_btnContactType3'), Keys.chord(Keys.ENTER))
		//			WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Emergency Info/22_fldContactInfo3'), phoneNumber2)
		//			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Emergency Info/23_chkSmartphone2'))
		//			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Emergency Info/24_chkPrimary2'))
		//		}

		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Emergency Info/28_fldSpecialNotes'), specialNotes)
	}
	/**
	 *  Use for input in Other Address and Contact Info
	 * @param orderNumber
	 */
	@CompileStatic
	@Keyword
	public static void inputOtherAddresandContactInfo(String addressType1, String addressType2, String addressType3, String addressType4,
			String addressType5, String addressType6, String addressType7, String addressType8, String email) {
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Other Addresses and Contact Info/01_btnOtherAddressAndContactInfo'))
		//String dataNotFound = WebUI.getText(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Other Addresses and Contact Info/14_lblNoDataFound'))

		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/12_btnAddAtIndex2'))
		def addressTypeMap = [
			'COLLECTION ADDRESS': 1,
			'HOME ADDRESS': 2,
			'MAILING ADDRESS': 3,
			'OFFICE ADDRESS': 4,
			'VERIFICATION ADDRESS': 5
		]

		//Set Address
		def steps = addressTypeMap[addressType1]
		//WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Other Addresses and Contact Info/02_btnAddressType'))
		if (steps != null) {
			for (def index : (1..steps)) {
				WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Other Addresses and Contact Info/02_btnAddressType'), Keys.chord(Keys.DOWN))
			}
			//WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Other Addresses and Contact Info/02_btnAddressType'), Keys.chord(Keys.ENTER))
		}

		//Copy From
		utilities.sendKeysWithAddressType(addressType2)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Other Addresses and Contact Info/15_btnZipCode'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/01_btnFind'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/42_btnFirstDataZipCodeIndexing'))
		//WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Performance Test Purpose Test Object/09_btnFirstDataZipCode'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Other Addresses and Contact Info/03_btnSubZipCode'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/01_btnFind'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/09_btnFirstResultSubZipCode'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Other Addresses and Contact Info/04_chkCollectionAddress'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/10_btnOK'))
		//		public static void sendKeysWithAddressType(String addressType, TestObject testObject) {
		//		def steps1 = addressTypeMap[addressType2]
		//
		//		if (steps1 != null) {
		//			for (def index : (0..steps1)) {
		//				WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Other Addresses and Contact Info/02_btnCopyFrom'), Keys.chord(Keys.DOWN))
		//			}
		//			WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Other Addresses and Contact Info/02_btnCopyFrom'), Keys.chord(Keys.ENTER))
		//		}
		//		}

		//Set Address
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/12_btnAddAtIndex2'))
		def steps2 = addressTypeMap[addressType3]
		//WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Other Addresses and Contact Info/02_btnAddressType'))
		if (steps != null) {
			for (def index : (1..steps2)) {
				WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Other Addresses and Contact Info/02_btnAddressType'), Keys.chord(Keys.DOWN))
			}
			//WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Other Addresses and Contact Info/02_btnAddressType'), Keys.chord(Keys.ENTER))
		}

		utilities.sendKeysWithAddressType(addressType4)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Other Addresses and Contact Info/15_btnZipCode'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/01_btnFind'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/42_btnFirstDataZipCodeIndexing'))
		//WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Performance Test Purpose Test Object/09_btnFirstDataZipCode'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Other Addresses and Contact Info/03_btnSubZipCode'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/01_btnFind'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/09_btnFirstResultSubZipCode'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Other Addresses and Contact Info/05_chkHomeAddress'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/10_btnOK'))

		//Set Address
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/12_btnAddAtIndex2'))
		def steps3 = addressTypeMap[addressType5]
		//WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Other Addresses and Contact Info/02_btnAddressType'))
		if (steps != null) {
			for (def index : (1..steps3)) {
				WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Other Addresses and Contact Info/02_btnAddressType'), Keys.chord(Keys.DOWN))
			}
			//WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Other Addresses and Contact Info/02_btnAddressType'), Keys.chord(Keys.ENTER))
		}

		utilities.sendKeysWithAddressType(addressType6)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Other Addresses and Contact Info/15_btnZipCode'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/01_btnFind'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/42_btnFirstDataZipCodeIndexing'))
		//WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Performance Test Purpose Test Object/09_btnFirstDataZipCode'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Other Addresses and Contact Info/03_btnSubZipCode'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/01_btnFind'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/09_btnFirstResultSubZipCode'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Other Addresses and Contact Info/06_chkMailingAddress'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/10_btnOK'))

		//Set Address
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/12_btnAddAtIndex2'))
		def steps4 = addressTypeMap[addressType7]
		//WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Other Addresses and Contact Info/02_btnAddressType'))
		if (steps != null) {
			for (def index : (1..steps4)) {
				WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Other Addresses and Contact Info/02_btnAddressType'), Keys.chord(Keys.DOWN))
			}
			//WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Other Addresses and Contact Info/02_btnAddressType'), Keys.chord(Keys.ENTER))
		}

		utilities.sendKeysWithAddressType(addressType8)
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Other Addresses and Contact Info/15_btnZipCode'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/01_btnFind'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/42_btnFirstDataZipCodeIndexing'))
		//		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Performance Test Purpose Test Object/09_btnFirstDataZipCode'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Other Addresses and Contact Info/03_btnSubZipCode'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/01_btnFind'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/09_btnFirstResultSubZipCode'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Other Addresses and Contact Info/07_chkOfficeAddress'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/10_btnOK'))

		//Contact info
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Other Addresses and Contact Info/08_btnAddRow'))
		WebUI.scrollToElement(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Other Addresses and Contact Info/09_btnContactType'), 10)
		WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Other Addresses and Contact Info/09_btnContactType'), Keys.chord(Keys.DOWN))
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Other Addresses and Contact Info/10_fldEmail'), email)

		if(RunConfiguration.getExecutionProfile()=='TEST') {
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Other Addresses and Contact Info/17_chkPrimaryEmailUAT'), FailureHandling.STOP_ON_FAILURE)
		}else {
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Other Addresses and Contact Info/11_chkPrimaryEmail'), FailureHandling.STOP_ON_FAILURE)

		}
		//WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Other Addresses and Contact Info/12_chkSmartphoneMobilePhone1'))
		//WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Other Addresses and Contact Info/02_btnAddressType'), Keys.chord(Keys.ENTER))
	}



	@CompileStatic
	@Keyword
	public static void inputOtherAddresandContactInfoNMCRO(String addressType1, String addressType2, String addressType3, String addressType4,
			String addressType5, String addressType6, String addressType7, String addressType8, String email) {
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Other Addresses and Contact Info/01_btnOtherAddressAndContactInfo'))

		boolean isColAddress = WebUI.verifyTextPresent('COLLECTION ADDRESS', false)
		boolean isHomeAddress = WebUI.verifyTextPresent('HOME ADDRESS', false)
		boolean isVerAddress = WebUI.verifyTextPresent('VERIFICATION ADDRESS', false)
		if(isColAddress && isHomeAddress && isVerAddress) {
			KeywordUtil.logInfo("Ini Jalan IF Statement")
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/12_btnAddAtIndex2'))
			def addressTypeMap = [
				'COLLECTION ADDRESS': 1,
				'HOME ADDRESS': 2,
				'MAILING ADDRESS': 3,
				'OFFICE ADDRESS': 4,
				'VERIFICATION ADDRESS': 5
			]

			//Set Address
			def steps = addressTypeMap[addressType1]
			//WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Other Addresses and Contact Info/02_btnAddressType'))
			if (steps != null) {
				for (def index : (1..steps)) {
					WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Other Addresses and Contact Info/02_btnAddressType'), Keys.chord(Keys.DOWN))
				}
				//WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Other Addresses and Contact Info/02_btnAddressType'), Keys.chord(Keys.ENTER))
			}

			//Copy From

			utilities.sendKeysWithAddressType(addressType2)
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Other Addresses and Contact Info/03_btnSubZipCode'))
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/01_btnFind'))
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/09_btnFirstResultSubZipCode'))
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Other Addresses and Contact Info/06_chkMailingAddress'))
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/10_btnOK'))

			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/12_btnAddAtIndex2'))
			def steps2 = addressTypeMap[addressType3]
			//WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Other Addresses and Contact Info/02_btnAddressType'))
			if (steps != null) {
				for (def index : (1..steps2)) {
					WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Other Addresses and Contact Info/02_btnAddressType'), Keys.chord(Keys.DOWN))
				}
				//WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Other Addresses and Contact Info/02_btnAddressType'), Keys.chord(Keys.ENTER))
			}

			utilities.sendKeysWithAddressType(addressType4)
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Other Addresses and Contact Info/03_btnSubZipCode'))
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/01_btnFind'))
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/09_btnFirstResultSubZipCode'))
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Other Addresses and Contact Info/07_chkOfficeAddress'))
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/10_btnOK'))
		} else {
			KeywordUtil.logInfo("Ini Jalan ELSE Statement")
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/12_btnAddAtIndex2'))
			def addressTypeMap = [
				'COLLECTION ADDRESS': 1,
				'HOME ADDRESS': 2,
				'MAILING ADDRESS': 3,
				'OFFICE ADDRESS': 4,
				'VERIFICATION ADDRESS': 5
			]

			//Set Address
			def steps = addressTypeMap[addressType1]
			//WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Other Addresses and Contact Info/02_btnAddressType'))
			if (steps != null) {
				for (def index : (1..steps)) {
					WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Other Addresses and Contact Info/02_btnAddressType'), Keys.chord(Keys.DOWN))
				}
				//WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Other Addresses and Contact Info/02_btnAddressType'), Keys.chord(Keys.ENTER))
			}

			//Copy From

			utilities.sendKeysWithAddressType(addressType2)
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Other Addresses and Contact Info/03_btnSubZipCode'))
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/01_btnFind'))
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/09_btnFirstResultSubZipCode'))
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Other Addresses and Contact Info/05_chkHomeAddress'))
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/10_btnOK'))
			//		public static void sendKeysWithAddressType(String addressType, TestObject testObject) {
			//		def steps1 = addressTypeMap[addressType2]
			//
			//		if (steps1 != null) {
			//			for (def index : (0..steps1)) {
			//				WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Other Addresses and Contact Info/02_btnCopyFrom'), Keys.chord(Keys.DOWN))
			//			}
			//			WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Other Addresses and Contact Info/02_btnCopyFrom'), Keys.chord(Keys.ENTER))
			//		}
			//		}

			//Set Address
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/12_btnAddAtIndex2'))
			def steps2 = addressTypeMap[addressType3]
			//WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Other Addresses and Contact Info/02_btnAddressType'))
			if (steps != null) {
				for (def index : (1..steps2)) {
					WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Other Addresses and Contact Info/02_btnAddressType'), Keys.chord(Keys.DOWN))
				}
				//WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Other Addresses and Contact Info/02_btnAddressType'), Keys.chord(Keys.ENTER))
			}

			utilities.sendKeysWithAddressType(addressType4)
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Other Addresses and Contact Info/03_btnSubZipCode'))
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/01_btnFind'))
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/09_btnFirstResultSubZipCode'))
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Other Addresses and Contact Info/05_chkHomeAddress'))
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/10_btnOK'))

			//Set Address
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/12_btnAddAtIndex2'))
			def steps3 = addressTypeMap[addressType5]
			//WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Other Addresses and Contact Info/02_btnAddressType'))
			if (steps != null) {
				for (def index : (1..steps3)) {
					WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Other Addresses and Contact Info/02_btnAddressType'), Keys.chord(Keys.DOWN))
				}
				//WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Other Addresses and Contact Info/02_btnAddressType'), Keys.chord(Keys.ENTER))
			}

			utilities.sendKeysWithAddressType(addressType6)
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Other Addresses and Contact Info/03_btnSubZipCode'))
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/01_btnFind'))
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/09_btnFirstResultSubZipCode'))
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Other Addresses and Contact Info/06_chkMailingAddress'))
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/10_btnOK'))

			//Set Address
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/12_btnAddAtIndex2'))
			def steps4 = addressTypeMap[addressType7]
			//WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Other Addresses and Contact Info/02_btnAddressType'))
			if (steps != null) {
				for (def index : (1..steps4)) {
					WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Other Addresses and Contact Info/02_btnAddressType'), Keys.chord(Keys.DOWN))
				}
				//WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Other Addresses and Contact Info/02_btnAddressType'), Keys.chord(Keys.ENTER))
			}

			utilities.sendKeysWithAddressType(addressType8)
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Other Addresses and Contact Info/03_btnSubZipCode'))
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/01_btnFind'))
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/09_btnFirstResultSubZipCode'))
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Other Addresses and Contact Info/07_chkOfficeAddress'))
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/10_btnOK'))

			//Contact info
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Other Addresses and Contact Info/08_btnAddRow'))
			WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Other Addresses and Contact Info/09_btnContactType'), Keys.chord(Keys.DOWN))
			WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Other Addresses and Contact Info/10_fldEmail'), email)
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Other Addresses and Contact Info/11_chkPrimaryEmail'))
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Other Addresses and Contact Info/12_chkSmartphoneMobilePhone1'))
			//WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Other Addresses and Contact Info/02_btnAddressType'), Keys.chord(Keys.ENTER))
		}
	}


	/**
	 *  Use for input in Other Address and Contact Info
	 * @param orderNumber
	 */
	@CompileStatic
	@Keyword
	public static void inputSave() {
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/14_btnSave'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/15_btnYes'))
		WebUI.waitForPageLoad(10)
		String customerNumber = WebUI.getText(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Other Addresses and Contact Info/13_lblSuccessSave'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/16_btnOkTanpaSpasi'))
	}

}
