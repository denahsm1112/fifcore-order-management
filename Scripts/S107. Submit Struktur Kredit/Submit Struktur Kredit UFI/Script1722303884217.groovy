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
import org.apache.commons.lang.RandomStringUtils as RandomStringUtils
import java.util.Random
import com.github.javafaker.Faker
import java.text.SimpleDateFormat
import org.apache.poi.ss.usermodel.*
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import java.io.FileOutputStream
import java.io.File
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

TestData excelData2 = findTestData('Data Files/Submit UFI/Submit Struktur Kredit - UFI')
TestData excelData = findTestData('Data Files/Submit UFI/Submit New Initial Order - UFI')

for (int i = 1; i <= excelData2.getRowNumbers(); i++) {
	'Start Process'
	WS.comment('Start Process ke- ' +i)
	
	//login data
	String username2 = excelData2.getValue('UsernameStrukturKredit', i)
	String password2 = excelData2.getValue('Password', i)
	String parentMenu1 = excelData2.getValue('Parent Menu', i)
	String subMenu1 = 'Receive Order'
	String thirdMenu1 = 'Order Tracking'
	//order number edit
	String branch2 = excelData2.getValue('Branch', 1)
	String ddlNavigation1 = excelData2.getValue('DDL Navigation 1', i)
	String ddlNavigation2 = excelData2.getValue('DDL Navigation 2', i)
	//submit struktur edit
	String installment2 = excelData2.getValue('Installment', i)
	String frequecnyMonth = excelData2.getValue('Frequency Month', i)
	String frequencyNumber = excelData2.getValue('Frequency Number', i)
	String calculatedBy = excelData2.getValue('Calculated By', i)
	String interestRateEffective = excelData2.getValue('Interest Rate - Effective', i)
	String interestRateFlat = excelData2.getValue('Interest Rate - Flat', i)
	String grossAdmin = excelData2.getValue('Gross Admin', i)
	String advanceArrear = excelData2.getValue('Advance Arrear', i)
	String paymentMethod = excelData2.getValue('Payment Method', i)
	String commentInterest = excelData2.getValue('Comment Interest', i)

	//Address
	String provinsi = excelData2.getValue('Provinsi', i)
	String kota = excelData2.getValue('Kota', i)
	String kecamatan = excelData2.getValue('Kecamatan', i)
	String kelurahan = excelData2.getValue('Kelurahan', i)
	String alamat = excelData2.getValue('Alamat', i)
	String rt2 = excelData2.getValue('RT', i)
	String rw2 = excelData2.getValue('RW', i)
	String bpkbNumber = excelData2.getValue('BPKB Number', i)
	String bpkbDate = excelData2.getValue('BPKB Date', i)
	String menuAppraisal = 'Credit Section Head Menu'
	String menuCredit = 'Credit Application Processor Regular Menu'
	def bpkbNo = 'R99' + RandomStringUtils.randomNumeric(8)

	//Update
	String receiveBank = excelData2.getValue('Receive Bank', i)
	String bankName = excelData2.getValue('Bank Name', i)
	String accountName = excelData2.getValue('Account Name', i)
	String accountNumber = excelData2.getValue('Account Number', i)
	String noOrder = excelData.getValue('OrderID', i)
	
	CustomKeywords.'id.co.fifgroup.fifcore.loginFifcore.loginIntoWeb'(GlobalVariable.url, username2, password2)
	CustomKeywords.'id.co.fifgroup.fifcore.utilities.chooseMenuAndSubMenuPath'(subMenu1, thirdMenu1)
	CustomKeywords.'id.co.fifgroup.fifcore.submitStrukturKredit.orderKreditUFIStruktur'(branch2, noOrder,
		ddlNavigation2)
	CustomKeywords.'id.co.fifgroup.fifcore.submitStrukturKredit.submitStrukturUFIUpdate'(installment2, frequecnyMonth, frequencyNumber,
		calculatedBy, interestRateEffective, interestRateFlat, grossAdmin, advanceArrear, paymentMethod, receiveBank,
		bankName, accountName, accountNumber)
	
	  //MS looping
	TestData excelDataMSLooping = findTestData('Data Files/Submit UFI/MS - UFI')
	int rowMS = 1;
	
	for (int x = 1; x <= excelDataMSLooping.getRowNumbers(); x++) {
	String schemeCode = excelDataMSLooping.getValue('Scheme Code', x)
			
	if (schemeCode == '') {
				KeywordUtil.logInfo('Scheme Code Tidak Diisi')
	} else {
			
	WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/12_btnAddMS'))
	WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/13_fldSchemeCode', [('addRow') : rowMS]), schemeCode)
	WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/13_fldSchemeCode', [('addRow') : rowMS]), Keys.chord(Keys.TAB))
		if (WebUI.verifyElementPresent(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/20_lblDataTidakDitemukan'),3, FailureHandling.OPTIONAL)) {
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/21_btnOKMessageBox'))
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/34_chkMS', [('rowMS') : rowMS]))
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/35_btnDeleteMS'))
//		WS.comment('Data tidak ditemukan' )
		}else {
//		WS.comment('row : ' + rowMS)
			rowMS++;
		}
	}
			
	}
	
	//MP looping
	TestData excelDataMPLooping = findTestData('Data Files/Submit UFI/MP - UFI')
	for (int y = 1; y <= excelDataMPLooping.getRowNumbers(); y++) {
		String marketingProgram = excelDataMPLooping.getValue('Marketing Program' , y)
		if(marketingProgram=='') {
			KeywordUtil.logInfo('Marketing Program Tidak Diisi')
		} else {
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Add Scheme Credit Structure Test Object/01_btnAddRowMP'))
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Add Scheme Credit Structure Test Object/06_btnAddMP',['addRow' : y]))
			WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/04_fldBankName'), marketingProgram)
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/05_btnFind'))
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Add Scheme Credit Structure Test Object/03_btnDataFirst'))
		}
	}

	WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/16_btnTabObjectFinanced'))
	
	//Object Detail looping
	TestData excelDataOSLooping = findTestData('Data Files/Submit UFI/OS - UFI')
	for (int z = 1; z <= excelDataOSLooping.getRowNumbers(); z++) {
		String objectScheme = excelDataOSLooping.getValue('Object Scheme' , z)
		if(objectScheme=='') {
			KeywordUtil.logInfo('Object Detail Tidak Diisi')
		} else {
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Add Scheme Credit Structure Test Object/04_btnAddRowOS'))
			WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Add Scheme Credit Structure Test Object/05_fldOS',['addRow' : z]), objectScheme)
		}
	}

	CustomKeywords.'id.co.fifgroup.fifcore.submitStrukturKredit.objectFinanceBpkbAddress'(provinsi, kota, kecamatan, kelurahan,
		alamat, rt2, rw2, bpkbNo, bpkbDate)
	CustomKeywords.'id.co.fifgroup.fifcore.submitStrukturKredit.submitOrderUFI'(commentInterest)
	CustomKeywords.'id.co.fifgroup.fifcore.loginFifcore.logout'()
	
	//Approve flag if N
	WebUI.callTestCase(findTestCase('Test Cases/Database Test/Database Query'), [('orderId') : noOrder],
		FailureHandling.STOP_ON_FAILURE)
}

	
	