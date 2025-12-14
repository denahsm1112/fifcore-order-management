import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import id.co.fifgroup.fifcore.utilities as utilities
import java.awt.Robot as Robot
import java.awt.event.KeyEvent as KeyEvent
import java.util.concurrent.ConcurrentHashMap.KeySetView as KeySetView
import com.kms.katalon.core.annotation.Keyword as Keyword
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import internal.GlobalVariable as GlobalVariable
import java.nio.file.Path as Path
import java.nio.file.Paths as Paths
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import org.openqa.selenium.Keys as Keys
import org.apache.commons.lang.RandomStringUtils as RandomStringUtils
import java.util.Random as Random
import com.github.javafaker.Faker
import java.text.SimpleDateFormat as SimpleDateFormat


TestData excelData = findTestData('Data Files/Submit Struktur Kredit BU MPF')

for(int i = 1; i <= excelData.getRowNumbers(); i++) {
	
	//login data
	String username = excelData.getValue('Username' , i)
	String password = excelData.getValue('Password' , i)
	String parentMenu = excelData.getValue('Parent Menu' , i)
	String subMenu = 'Receive Order'
	String thirdMenu = 'Order Tracking'
	
	//order number edit
	String orderNumber = excelData.getValue('Order Number' , i)
	String ddlNavigation = excelData.getValue('DDL Navigation' , i)
	
	//submit struktur edit
	String installment = excelData.getValue('Installment' , i)
	String frequecnyMonth = excelData.getValue('Frequency Month' , i)
	String frequencyNumber = excelData.getValue('Frequency Number' , i)
	String calculatedBy = excelData.getValue('Calculated By' , i)
	String interestRateEffective = excelData.getValue('Interest Rate - Effective' , i)
	String interestRateFlat = excelData.getValue('Interest Rate - Flat' , i)
	String netAdmin = excelData.getValue('Net Admin' , i)
	String promoFee = excelData.getValue('Promo Fee' , i)
	String advanceArrear = excelData.getValue('Advance Arrear' , i)
	String paymentMethod = excelData.getValue('Payment Method' , i)
	
	//Address
	String provinsi = excelData.getValue('Provinsi' , i)
	String kota = excelData.getValue('Kota' , i)
	String kecamatan = excelData.getValue('Kecamatan' , i)
	String kelurahan = excelData.getValue('Kelurahan' , i)
	String alamat = excelData.getValue('Alamat' , i)
	String rt = excelData.getValue('RT' , i)
	String rw = excelData.getValue('RW' , i)
	
	//BPKB
	String bpkbNumber = excelData.getValue('No Bpkb', i)
	String bpkbDate = excelData.getValue('Tanggal Bpkb', i)
	
	//Generate KTP Id random
	def nik = '43130125' + RandomStringUtils.randomNumeric(8)
	println('NIK: ' + nik)
	def bpkbNo = 'R99108' + RandomStringUtils.randomNumeric(5)
	
	//Login into web
	CustomKeywords.'id.co.fifgroup.fifcore.loginFifcore.loginIntoWeb'(GlobalVariable.url, username, password)
	
	CustomKeywords.'id.co.fifgroup.fifcore.utilities.chooseMenuAndSubMenu'(parentMenu, subMenu, thirdMenu)
	
	CustomKeywords.'id.co.fifgroup.fifcore.submitStrukturKredit.submitKreditNMC'(orderNumber, ddlNavigation)
	String savingFolder1 = 'Order Inquiry - Submit Struktur Kredit/'
	CustomKeywords.'id.co.fifgroup.fifcore.utilities.takeScreenCapture'(savingFolder1, orderNumber)
	
	WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/06_btnEdit'))
	
	CustomKeywords.'id.co.fifgroup.fifcore.submitStrukturKredit.inputDetailOrder'(installment, frequencyNumber, frequencyNumber, calculatedBy, interestRateFlat, interestRateEffective, netAdmin, promoFee, advanceArrear, paymentMethod)
	String savingFolder2 = 'Detail Order - Submit Struktur Kredit/'
	CustomKeywords.'id.co.fifgroup.fifcore.utilities.takeScreenCapture'(savingFolder2, orderNumber)
	
	WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/16_btnTabObjectFinanced'))
	
	CustomKeywords.'id.co.fifgroup.fifcore.submitStrukturKredit.objectFinanceBpkbAddress'(provinsi, kota, kecamatan, kelurahan, alamat, rt, rw, bpkbNo, bpkbDate)
	String savingFolder3 = 'BPKB Address - Submit Struktur Kredit/'
	CustomKeywords.'id.co.fifgroup.fifcore.utilities.takeScreenCapture'(savingFolder3, orderNumber)
	
	WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/11_btnSubmit'))
	String savingFolder4 = 'BPKB Address - Submit Struktur Kredit/'
	CustomKeywords.'id.co.fifgroup.fifcore.utilities.takeScreenCapture'(savingFolder4, orderNumber)
	
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