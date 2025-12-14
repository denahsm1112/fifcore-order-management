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



TestData excelData = findTestData('Data Files/New Order 3 Parties')

for(int i = 1; i <= excelData.getRowNumbers(); i++) {
	'Start Process'
	WS.comment('Start Process ke- ' +i)
	
	Faker faker = new Faker()
	String randomFullNames = "${faker.lorem().word()} ${faker.space().moon()} ${faker.name().lastName()}"
	
	println('Fake Name: ' + randomFullNames)
	def randomFullName = randomFullNames.replaceAll('[^\\p{L}\\s]', '')
	randomFullName = randomFullName.replaceAll('\\d', '')
	
	println(randomFullName)
	GlobalVariable.RandomFullName = randomFullName
	
	String randomMotherNames = "$faker.dog().name() $faker.cat().name() $faker.ancient().titan()"
	def randomMotherName = randomMotherNames.replaceAll('[^\\p{L}\\s]', '')
	println(randomMotherName)
	GlobalVariable.RandomMotherName = randomMotherName

	String username = excelData.getValue('Username' , i)
	String password = excelData.getValue('Password' , i)
	String companyID = excelData.getValue('Company' , i)
	String businessUnit = excelData.getValue('Business Unit' , i)
	String branch = excelData.getValue('Branch' , i)
	String platform = excelData.getValue('Platform' , i)
	String ojk = excelData.getValue('OJK Code' , i)
	String credit = excelData.getValue('Credit Objective' , i)
	String subcredit = excelData.getValue('Sub Credit' , i)
	String sektor = excelData.getValue('Sektor' , i)
	//String nik = excelData.getValue('NIK' , i)
	String custName = excelData.getValue('Cust Name' , i)
	//String fullName = excelData.getValue('Full Name' , i)
	String title = excelData.getValue('Title' , i)
	String placeBirth = excelData.getValue('Tempat Lahir' , i)
	String tglLahir = excelData.getValue('Tgl Lahir' , i)
	//String namaIbu = excelData.getValue('Nama Ibu' , i)
	String gender = excelData.getValue('Gender' , i)
	String marital = excelData.getValue('Marital' , i)
	String occupationonId = excelData.getValue('Occupation Id', i)
	String occupation = excelData.getValue('Occupation' , i)
	String subOccupation = excelData.getValue('Sub Occupation', i)
	String wp = excelData.getValue('Work Period' , i)
	String education = excelData.getValue('Education' , i)
	String address = excelData.getValue('Address' , i)
	String rt = excelData.getValue('RT' , i)
	String rw = excelData.getValue('RW' , i)
	String kodePos = excelData.getValue('Kode Pos' , i)
	String kodePos2 = excelData.getValue('Kode Pos 2' , i)
	String contactInfo = excelData.getValue('Contact Info' , i)
	String contactInfo2 = excelData.getValue('Contact Info 2' , i)
	String tenor = excelData.getValue('Tenor' , i)
	String objGroup = excelData.getValue('Object Group' , i)
	String dealerID = excelData.getValue('Dealer ID' , i)
	String objCode = excelData.getValue('Object Code' , i)
	String colour = excelData.getValue('Colour' , i)
	String price = excelData.getValue('Price' , i)
	String dp = excelData.getValue('DP' , i)
	String installment = excelData.getValue('Installment' , i)
	String so = excelData.getValue('Source Order' , i)
	String visitDate = excelData.getValue('Visit Date' , i)
	String vID = excelData.getValue('Verifier ID' , i)
	String caCoord = excelData.getValue('Ca Coord', i)
	String salesType = excelData.getValue('Sales Type', i)
	String salesID = excelData.getValue('Sales ID', i)
	String ktp = excelData.getValue('File KTP', i)
	String kk = excelData.getValue('File KK', i)
	String ktpPasangan = excelData.getValue('File KTP Pasangan', i)
	
	String namaIbuRandom = 'Ibu' + randomFullName
	
	String contact = '1' //MOBILE PHONE 1
	String contact2 = '2' //MOBILE PHONE 2
	String wpm = '6'
	String businessType = 'New Order'
	
	//Generate KTP Id random
	def nik = '43130125' + RandomStringUtils.randomNumeric(8)
	println('NIK: ' + nik)
	def bpkbNo = 'R99108' + RandomStringUtils.randomNumeric(5)
	
	//Login Into Web
	CustomKeywords.'id.co.fifgroup.fifcore.loginFifcore.loginIntoWeb'(GlobalVariable.url, username, password)
	//Open Initial Order Form
	CustomKeywords.'id.co.fifgroup.fifcore.createOrder.newOrder'(businessType)

	//Order Form
	CustomKeywords.'id.co.fifgroup.fifcore.createOrder.formOrder'(companyID, businessUnit, branch, platform, ojk, credit, subcredit, sektor)
	String savingFolder1 = 'Order Form - Add New Order 3 Parties/'
	CustomKeywords.'id.co.fifgroup.fifcore.utilities.takeScreenCapture'(savingFolder1, businessType)
	
	//Initial Info
	CustomKeywords.'id.co.fifgroup.fifcore.createOrder.initialInfo'(nik, randomFullName, title, placeBirth, tglLahir, namaIbuRandom, gender, randomFullName, marital,
		occupationonId ,occupation, wp, education, wpm, ojk, subOccupation)
	String savingFolder2 = 'Initial Info - Add New Order 3 Parties/'
	CustomKeywords.'id.co.fifgroup.fifcore.utilities.takeScreenCapture'(savingFolder2, businessType)
	
	CustomKeywords.'id.co.fifgroup.fifcore.createOrder.formVerificationAddress'(address, rt, rw, kodePos, kodePos2, occupation)
	String savingFolder3 = 'Verification Address - Add New Order 3 Parties/'
	CustomKeywords.'id.co.fifgroup.fifcore.utilities.takeScreenCapture'(savingFolder3, businessType)
	
	//Contact Info
	CustomKeywords.'id.co.fifgroup.fifcore.createOrder.contactInfo'(contact, contactInfo, contact2, contactInfo2)
	String savingFolder4 = 'Contact Info - Add New Order 3 Parties/'
	CustomKeywords.'id.co.fifgroup.fifcore.utilities.takeScreenCapture'(savingFolder4, businessType)
	
	//Object Info
	CustomKeywords.'id.co.fifgroup.fifcore.createOrder.objectInfo'(tenor, objGroup, dealerID, objCode, colour, price, dp, installment)
	String savingFolder5 = 'Object Info - Add New Order 3 Parties/'
	CustomKeywords.'id.co.fifgroup.fifcore.utilities.takeScreenCapture'(savingFolder4, businessType)
	
	//General Form
	CustomKeywords.'id.co.fifgroup.fifcore.createOrder.general'(so, visitDate, vID, caCoord)
	String savingFolder6 = 'General Form - Add New Order 3 Parties/'
	CustomKeywords.'id.co.fifgroup.fifcore.utilities.takeScreenCapture'(savingFolder5, businessType)
	
	//Sales Info
	CustomKeywords.'id.co.fifgroup.fifcore.createOrder.salesInfo'(salesType, salesID)
	
	//Upload Dokumen
	CustomKeywords.'id.co.fifgroup.fifcore.createOrder.addDocument'(ktp, kk, ktpPasangan)
	
	//AP Cabang
	CustomKeywords.'id.co.fifgroup.fifcore.createOrder.inputApCabang'()
	
	//Submit Data
	CustomKeywords.'id.co.fifgroup.fifcore.createOrder.submitData'()
}

WebUI.closeBrowser()

