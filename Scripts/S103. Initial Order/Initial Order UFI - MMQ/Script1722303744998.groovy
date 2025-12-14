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
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import internal.GlobalVariable as GlobalVariable
import java.nio.file.Path as Path
import java.nio.file.Paths as Paths
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import org.openqa.selenium.Keys as Keys
import org.apache.commons.lang.RandomStringUtils as RandomStringUtils
import java.util.Random
import com.github.javafaker.Faker
import java.text.SimpleDateFormat
import org.apache.poi.ss.usermodel.*
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import java.io.FileOutputStream
import java.io.File

TestData excelData = findTestData('Data Files/Submit UFI - MMQ/Submit New Initial Order - UFI - MMQ')

for (int i = 1; i <= excelData.getRowNumbers(); i++) {
	
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
	

    String username = excelData.getValue('Username', i)
	GlobalVariable.userLogin = username
    String password = excelData.getValue('Password', i)

    String parentMenu = 'CAP'

    String subMenu = 'Receive Order'

    String companyID = excelData.getValue('Company', i)

    String businessUnit = excelData.getValue('Business Unit', i)

    String branch = excelData.getValue('Branch', i)

    String platform = excelData.getValue('Platform', i)

    String subPlatform = excelData.getValue('Sub Platform', i)

    String ojk = excelData.getValue('OJK Code', i)

    String credit = excelData.getValue('Credit Objective', i)

    String subcredit = excelData.getValue('Sub Credit', i)

    String sektor = excelData.getValue('Sektor', i)

    //String nik = excelData.getValue('NIK' , 1)
    String custName = excelData.getValue('Cust Name', i)

    String fullName = excelData.getValue('Full Name', i)

    String title = excelData.getValue('Title', i)

    String placeBirth = excelData.getValue('Tempat Lahir', i)

    String tglLahir = excelData.getValue('Tgl Lahir', i)

    String namaIbu = excelData.getValue('Nama Ibu', i)

    String gender = excelData.getValue('Gender', i)

    String marital = excelData.getValue('Marital', i)

    String occupationonId = excelData.getValue('Occupation on ID', i)

    String occupation = excelData.getValue('Occupation', i)

    String subOccupation = excelData.getValue('Sub Occupation', i)

    String wp = excelData.getValue('Work Period Year', i)

    String education = excelData.getValue('Education', i)

    String address = excelData.getValue('Address', i)

    String rt = excelData.getValue('RT', i)

    String rw = excelData.getValue('RW', i)

    String kodePos = excelData.getValue('Kode Pos', i)

    String kodePos2 = excelData.getValue('Kode Pos 2', i)

    String contactInfo = excelData.getValue('Contact Info', i)

    String contactInfo2 = excelData.getValue('Contact Info 2', i)

    String email = excelData.getValue('Email', i)

    String waktuFasilitas = excelData.getValue('Waktu Fasilitas', i)

    String installmentType = excelData.getValue('Installment Type', i)

    String objGroup = excelData.getValue('Object Group', i)

    String dealerID = excelData.getValue('Sales ID', i)

    String objCode = excelData.getValue('Object Code', i)

    String colour = excelData.getValue('Colour', i)

    String noChassis = excelData.getValue('No Chassis', i)

    String noEngine = excelData.getValue('No Engine', i)

    String km = excelData.getValue('KM', i)

    String year = excelData.getValue('Year', i)

    String stnkUntil = excelData.getValue('STNK Until', i)

    String tobeTransfer = excelData.getValue('To Be Transfer', i)

    String amountCredit = excelData.getValue('Amount Credit', i)

    String installment = excelData.getValue('Installment', i)

    String so = excelData.getValue('Source Order', i)

    String visitDate = excelData.getValue('Visit Date', i)

    String caCoord = excelData.getValue('CA Coord', i)

    String vID = excelData.getValue('Verifier ID', i)

    String salesType1 = excelData.getValue('Sales Type 1', i)

    String salesType2 = excelData.getValue('Sales Type 2', i)

    String salesType3 = excelData.getValue('Sales Type 3', i)

    String salesIdInfo1 = excelData.getValue('Sales ID Info 1', i)

    String salesIdInfo2 = excelData.getValue('Sales ID Info 2', i)

    String salesIdInfo3 = excelData.getValue('Sales ID Info 3', i)

    String ktp = excelData.getValue('File KTP', i)

    String kk = excelData.getValue('Slip Gaji Pasangan', i)

    String ktpPasangan = excelData.getValue('No Mesin', i)

    String promo = excelData.getValue('Promo', i)

    String contact = '1' //MOBILE PHONE 1

    String contact2 = '2' //MOBILE PHONE 2

    String contact3 = 'EMAIL' //EMAIL

    String wpm = excelData.getValue('Work Period Month', i)

    String businessType = 'New Order'

    String namIbuRandom = 'Ibu ' + randomFullName

    //
    def nik = '32030125' + RandomStringUtils.randomNumeric(8)

    println('NIK: ' + nik)

    def bpkbNo = 'R99108' + RandomStringUtils.randomNumeric(5)

    //Login Into Web
    CustomKeywords.'id.co.fifgroup.fifcore.loginFifcore.loginIntoWeb'(GlobalVariable.url, username, password)

    //Access menu
    CustomKeywords.'id.co.fifgroup.fifcore.utilities.chooseMenuAndSubMenuInvoice'(parentMenu, subMenu)

    //Open Initial Order Form
    CustomKeywords.'id.co.fifgroup.fifcore.createOrder.newOrderReceiveOrder'(businessType)

    //Order Form Syariah
    CustomKeywords.'id.co.fifgroup.fifcore.createOrder.formOrderMMQ'(companyID, businessUnit, branch, platform, subPlatform, 
        ojk, credit, subcredit, sektor)

    //Initial Info
    CustomKeywords.'id.co.fifgroup.fifcore.createOrder.initialInfoMMQ'(nik, randomFullName, title, placeBirth, tglLahir, 
        namIbuRandom, gender, randomFullName, marital, occupationonId, occupation, wp, education, wpm, ojk, subOccupation)

    CustomKeywords.'id.co.fifgroup.fifcore.createOrder.formVerificationAddress'(address, rt, rw, kodePos, kodePos2, occupation)

    //Contact Info
    CustomKeywords.'id.co.fifgroup.fifcore.createOrder.contactInfoMMQ'(contact, contactInfo, contact2, contactInfo2, contact3, 
        email)

    //Object Info
    CustomKeywords.'id.co.fifgroup.fifcore.createOrder.objectInfoMMQ'(waktuFasilitas, objGroup, dealerID, objCode, colour, 
        noChassis, noEngine, km, year, stnkUntil, tobeTransfer, amountCredit, installment)

    //General Form
    CustomKeywords.'id.co.fifgroup.fifcore.createOrder.general'(so, visitDate, vID, caCoord)

    //Sales Info
    CustomKeywords.'id.co.fifgroup.fifcore.createOrder.salesInfoUFI'(salesType1, salesIdInfo1, salesType2, salesIdInfo2, 
        salesType3, salesIdInfo3)

    //Upload Dokumen
    CustomKeywords.'id.co.fifgroup.fifcore.createOrder.addDocument'(ktp, kk, ktpPasangan)

    //promo
    CustomKeywords.'id.co.fifgroup.fifcore.createOrder.promoMMQ'(installmentType)

    //AP Cabang
    CustomKeywords.'id.co.fifgroup.fifcore.createOrder.inputApCabang'()

    //Submit Data
    CustomKeywords.'id.co.fifgroup.fifcore.createOrder.submitDataMMQ'(ojk, occupationonId, occupation, subOccupation)

    //}
	
	WebUI.callTestCase(findTestCase('Test Cases/Database Test/Document Checklist Query'), [('orderNumber') : GlobalVariable.teksOrder], FailureHandling.STOP_ON_FAILURE)
	
	String filePath = RunConfiguration.getProjectDir() + '/Data Files/Submit UFI - MMQ'
	Path projectPath = Paths.get(filePath)
	Path dataFilesPath = projectPath.resolve('Test Data UFI MMQ.xlsx')   // you do not need / and \ here
	File dataFilesDir = dataFilesPath.toFile()
	
	//Create an object of FileInputStream class to read excel file
	FileInputStream inputStream = new FileInputStream(dataFilesDir);
	
	// Create a new workbook and sheet
	Workbook workbook = new XSSFWorkbook(inputStream)
	Sheet sheet = workbook.getSheet("Submit New Order UFI - MMQ")
	
	// Create a row and put some cells in it
	Row row = sheet.getRow(i)
	Cell cell1 = row.createCell(2)
	Cell cell2 = row.createCell(3)
	cell1.setCellValue(GlobalVariable.teksOrder)
	cell2.setCellValue(GlobalVariable.customerNo)
	
	// Create a file output stream
	FileOutputStream fileOut = new FileOutputStream(dataFilesDir)
	
	// Write the workbook to the output stream
	workbook.write(fileOut)
	
	// Close the file output stream
	fileOut.close()
	
	//Close the workbook
	workbook.close()
	WebUI.closeBrowser()
}

