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

TestData excelData = findTestData('Data Files/Submit UFI - MMQ/Submit New Initial Order - UFI - MMQ')
TestData excelData2 = findTestData('Data Files/Submit UFI - MMQ/Customer Maintenance MMQ')

for(int i = 1; i <= excelData2.getRowNumbers(); i++) {
	
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
	
	String parentMenu = 'CAP'
	String subMenu = 'Customer'
	String thirdMenu = 'Customer Maintenance'
	String noOrder = excelData.getValue('OrderID', i)
	String custNumber = excelData.getValue('CustomerNo', i)
	
	String username = excelData2.getValue('Username', 1)
	String password = excelData2.getValue('Password', 1)
	String customerName = excelData2.getValue('Customer Name', 1)
	String title = excelData2.getValue('Title', i)
	String nickname = excelData2.getValue('Nickname', i)
	String identityType = excelData2.getValue('Identity Type', i)
	String identityNumber = excelData2.getValue('Identity Number', i)
	String placeOfBirth = excelData2.getValue('Place Of Birth', i)
	String dateOfBirth = excelData2.getValue('Date Of Birth', 1)
	String motherName = excelData2.getValue('Mother Name', 1)
	String customerFullName = excelData2.getValue('Customer Full Name', 1)
	
	String gender = excelData2.getValue('Gender', 1)
	String birthPlace = excelData2.getValue('Birth Place', 1)
	String address = excelData2.getValue('Address', 1)
	String rt = excelData2.getValue('RT', 1)
	String rw = excelData2.getValue('RW', 1)
	String zipCode = excelData2.getValue('Zip Code', 1)
	String subZipCode = excelData2.getValue('Sub Zip Code', 1)
	String province = excelData2.getValue('Province', 1)
	String city = excelData2.getValue('City', 1)
	String kecamatan = excelData2.getValue('Kecamatan', 1)
	String kelurahan = excelData2.getValue('Kelurahan', 1)
	String religion = excelData2.getValue('Religion', 1)
	String maritalStatus = excelData2.getValue('Marital Status', 1)
	String occupationOnId = excelData2.getValue('Occupation On ID', 1)
	String occupation = excelData2.getValue('Occupation', 1)
	String nationality = excelData2.getValue('Nationality', 1)
	String customerNumber = excelData2.getValue('Customer Number', 1)
	
	//Customer Job info and financial individu
	String occupationType = excelData2.getValue('Occupation Type', 1)
	String companyName = excelData2.getValue('Company / Business Name', 1)
	String sectorIndustry = excelData2.getValue('Sector Industry', 1)
	String subSectorIndustry = excelData2.getValue('Sub Sector Industry', 1)
	String workSince = excelData2.getValue('Work / Establish Since', 1)
	String salesIncome = excelData2.getValue('Sales Turnover / Income', 1)
	String position = excelData2.getValue('Position', 1)
	String borrowerIncome = excelData2.getValue('Borrower Income', 1)
	String spouseIncome = excelData2.getValue('Spouse Income', 1)
	String otherIncome = excelData2.getValue('Other Income', 1)
	String expense = excelData2.getValue('Expense', 1)
	String emergencyName = excelData2.getValue('Name', 1)
	String relationship = excelData2.getValue('Relationship', 1)
	String occupationTypeEmergency = excelData2.getValue('Occupation Type Emergency', 1)
	String companyNameEmergency = excelData2.getValue('Company Name Emergency', 1)
	String companyAddress = excelData2.getValue('Company Address', 1)
	String addressType = excelData2.getValue('Address Type', 1)
	String addressType1 = excelData2.getValue('Address Type 2', 1)
	String addressType2 = excelData2.getValue('Address Type 3', 1)
	String addressType3 = excelData2.getValue('Address Type 4', 1)
	String addressType4 = excelData2.getValue('Address Type 5', 1)
	String contactType1 = excelData2.getValue('Contact Type 1', 1)
	String contactType2 = excelData2.getValue('Contact Type 2', 1)
	String contactType3 = excelData2.getValue('Contact Type 3', 1)
	String email = excelData2.getValue('Email', 1)
	String phoneNumber1 = excelData2.getValue('Mobile Phone 1', 1)
	String phoneNumber2 = excelData2.getValue('Mobile Phone 2', 1)
	String specialNotes = excelData2.getValue('Special Notes', 1)
	
	//Login Into Web
	CustomKeywords.'id.co.fifgroup.fifcore.loginFifcore.loginIntoWeb'(GlobalVariable.url, username, password)
	CustomKeywords.'id.co.fifgroup.fifcore.utilities.chooseMenuAndSubMenu'(parentMenu, subMenu, thirdMenu)
	if(RunConfiguration.getExecutionProfile()=='TEST') {
		CustomKeywords.'id.co.fifgroup.fifcore.customerMaintenance.inquiryNomorOrder'(noOrder)
	}else {
		
		CustomKeywords.'id.co.fifgroup.fifcore.customerMaintenance.inquiryNomorOrder'(custNumber)
	}
	
	CustomKeywords.'id.co.fifgroup.fifcore.customerMaintenance.idInfo'(GlobalVariable.RandomFullName, title, nickname, identityType, identityNumber, placeOfBirth, dateOfBirth, motherName,
		GlobalVariable.RandomFullName, gender, birthPlace, address, rt, rw, zipCode, subZipCode, province, city, kecamatan, kelurahan, religion, maritalStatus, occupationOnId,
		occupation, nationality, customerNumber)
	CustomKeywords.'id.co.fifgroup.fifcore.customerMaintenance.individualJob'(occupationType, companyName, sectorIndustry, subSectorIndustry, workSince, salesIncome, position, address)
	CustomKeywords.'id.co.fifgroup.fifcore.customerMaintenance.financialIndividual'(borrowerIncome, spouseIncome, otherIncome, expense)
	CustomKeywords.'id.co.fifgroup.fifcore.customerMaintenance.inputEmergencyInfo'(emergencyName, relationship, occupationTypeEmergency, companyNameEmergency,companyAddress)
	CustomKeywords.'id.co.fifgroup.fifcore.customerMaintenance.inputEmergencyInfoAddress'(addressType, address, rt, rw, zipCode, addressType1, addressType2, addressType3, addressType4)
	//CustomKeywords.'id.co.fifgroup.fifcore.customerMaintenance.inputEmergencyInfoContactInfo'(contactType1, contactType2, contactType3, email, phoneNumber1, phoneNumber2, specialNotes)
	CustomKeywords.'id.co.fifgroup.fifcore.customerMaintenance.inputEmergencyINfoContactInfo1'(contactType1, contactType2, contactType3, email, phoneNumber1, phoneNumber2, specialNotes)
	CustomKeywords.'id.co.fifgroup.fifcore.customerMaintenance.inputOtherAddresandContactInfo'(addressType, addressType4, addressType1, addressType4, addressType2, addressType4, addressType3, addressType4, email)
	CustomKeywords.'id.co.fifgroup.fifcore.customerMaintenance.inputSave'()
	CustomKeywords.'id.co.fifgroup.fifcore.loginFifcore.logout'()
	WebUI.closeBrowser()
	
	
}

