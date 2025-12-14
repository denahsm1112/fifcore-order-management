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

TestData excelData = findTestData('Data Files/Submit Struktur Kredit BU UFI')

for(int i = 1; i <= excelData.getRowNumbers(); i++) {
	
	//login data
	String username = excelData.getValue('Username' , i)
	String password = excelData.getValue('Password' , i)
	String parentMenu = excelData.getValue('Parent Menu' , i)
	String subMenu = 'Receive Order'
	String thirdMenu = 'Order Tracking'
	
	//order number edit
	String branch = excelData.getValue('Branch' , i)
	String orderNumber = excelData.getValue('Order Number' , i)
	String ddlNavigation1 = excelData.getValue('DDL Navigation 1' , i)
	String ddlNavigation2 = excelData.getValue('DDL Navigation 2' , i)
	
	//submit struktur edit
	String installment = excelData.getValue('Installment' , i)
	String frequecnyMonth = excelData.getValue('Frequency Month' , i)
	String frequencyNumber = excelData.getValue('Frequency Number' , i)
	String calculatedBy = excelData.getValue('Calculated By' , i)
	String interestRateEffective = excelData.getValue('Interest Rate - Effective' , i)
	String interestRateFlat = excelData.getValue('Interest Rate - Flat' , i)
	String grossAdmin = excelData.getValue('Gross Admin' , i)
	String advanceArrear = excelData.getValue('Advance Arrear' , i)
	String paymentMethod = excelData.getValue('Payment Method' , i)
	String schemeCode = excelData.getValue('Scheme Code' , i)
	String commentInterest = excelData.getValue('Comment Interest' , i)
	
	//Address
	String provinsi = excelData.getValue('Provinsi' , i)
	String kota = excelData.getValue('Kota' , i)
	String kecamatan = excelData.getValue('Kecamatan' , i)
	String kelurahan = excelData.getValue('Kelurahan' , i)
	String alamat = excelData.getValue('Alamat' , i)
	String rt = excelData.getValue('RT' , i)
	String rw = excelData.getValue('RW' , i)
	String bpkbNumber = excelData.getValue('BPKB Number' , i)
	String bpkbDate = excelData.getValue('BPKB Date' , i)
	String menuAppraisal = 'Credit Section Head Menu'
	String menuCredit = 'Credit Application Processor Regular Menu'
	
	//Login Into Web
	CustomKeywords.'id.co.fifgroup.fifcore.loginFifcore.loginIntoWeb'(GlobalVariable.url, username, password)
	
	CustomKeywords.'id.co.fifgroup.fifcore.utilities.chooseMenuAndSubMenu'(parentMenu, subMenu, thirdMenu)
	CustomKeywords.'id.co.fifgroup.fifcore.submitStrukturKredit.cekUserAppraisalUFI'(branch, orderNumber, ddlNavigation1)
	CustomKeywords.'id.co.fifgroup.fifcore.loginFifcore.logout'()
	CustomKeywords.'id.co.fifgroup.fifcore.loginFifcore.login'(GlobalVariable.appraisalUFI, password)
	CustomKeywords.'id.co.fifgroup.fifcore.utilities.chooseMenuAndSubMenuPath'(subMenu, thirdMenu)
	CustomKeywords.'id.co.fifgroup.fifcore.submitStrukturKredit.appraisalKreditUFI'(branch, orderNumber, ddlNavigation1)
	CustomKeywords.'id.co.fifgroup.fifcore.loginFifcore.logout'()
	CustomKeywords.'id.co.fifgroup.fifcore.loginFifcore.login'(GlobalVariable.creditStructureUFI, password)
	CustomKeywords.'id.co.fifgroup.fifcore.utilities.chooseMenuAndSubMenuPath'(subMenu, thirdMenu)
	
	CustomKeywords.'id.co.fifgroup.fifcore.submitStrukturKredit.orderKreditUFIStruktur'(branch, orderNumber, ddlNavigation2)
	CustomKeywords.'id.co.fifgroup.fifcore.submitStrukturKredit.submitStrukturUFIUpdate'(installment, frequecnyMonth, 
		frequencyNumber, calculatedBy, interestRateEffective, interestRateFlat, grossAdmin, advanceArrear, paymentMethod, schemeCode)
	
	String savingFolder2 = 'Detail Order - Submit Struktur Kredit/'
	CustomKeywords.'id.co.fifgroup.fifcore.utilities.takeScreenCapture'(savingFolder2, orderNumber)
	
	WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/16_btnTabObjectFinanced'))
	
	CustomKeywords.'id.co.fifgroup.fifcore.submitStrukturKredit.objectFinanceBpkbAddress'(provinsi, kota, kecamatan,
		kelurahan, alamat, rt, rw, bpkbNumber, bpkbDate)
	String savingFolder3 = 'BPKB Address - Submit Struktur Kredit/'
	CustomKeywords.'id.co.fifgroup.fifcore.utilities.takeScreenCapture'(savingFolder3, orderNumber)
	
	CustomKeywords.'id.co.fifgroup.fifcore.submitStrukturKredit.submitOrderUFI'(commentInterest)
	String savingFolder4 = 'BPKB Address - Submit Struktur Kredit/'
	CustomKeywords.'id.co.fifgroup.fifcore.utilities.takeScreenCapture'(savingFolder4, orderNumber)
	
	CustomKeywords.'id.co.fifgroup.fifcore.loginFifcore.logout'()
	
	//Enable this with command Select all code below after that "CTRL +/"
//	CustomKeywords.'id.co.fifgroup.fifcore.submitStrukturKredit.submitOrder'()
//	
//	String savingFolder5 = 'After Submit Pop Up - Submit Struktur Kredit/'
//	CustomKeywords.'id.co.fifgroup.fifcore.utilities.takeScreenCapture'(savingFolder5, orderNumber)
//	WebUI.sendKeys(null, Keys.chord(Keys.ENTER), FailureHandling.OPTIONAL)
//	
//	String savingFolder6 = 'After Submit Pop Up 2 - Submit Struktur Kredit/'
//	CustomKeywords.'id.co.fifgroup.fifcore.utilities.takeScreenCapture'(savingFolder6, orderNumber)
//	WebUI.sendKeys(null, Keys.chord(Keys.ENTER), FailureHandling.OPTIONAL)
}