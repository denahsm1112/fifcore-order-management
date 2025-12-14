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
import java.text.SimpleDateFormat as SimpleDateFormat
import java.util.Date as Date
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import org.apache.commons.lang.RandomStringUtils as RandomStringUtils
import java.util.Random
import com.github.javafaker.Faker
import java.text.SimpleDateFormat
import org.apache.poi.ss.usermodel.*
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import java.io.FileOutputStream
import java.io.FileInputStream;
import java.io.File
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

//TestData excelData = findTestData('Data Files/Submit UFI/Customer Maintenance - UFI')
//TestData excelData2 = findTestData('Data Files/Submit UFI/Submit New Initial Order - UFI')
//
//for (int i = 1; i <= excelData.getRowNumbers(); i++) {
//	'Start Process'
//	WS.comment('Start Process ke- ' +i)
//	String parentMenu = 'CAP'
//	String subMenu = 'Customer'
//	String thirdMenu = 'Customer Maintenance'
//	String orderNumber = '10123002918'
//	String username = excelData.getValue('Username', i)
//	String password = excelData.getValue('Password', i)
//	String customerName = excelData.getValue('Customer Name', i)
//	String title = excelData.getValue('Title', i)
//	String nickname = excelData.getValue('Nickname', i)
//	String identityType = excelData.getValue('Identity Type', i)
//	String identityNumber = excelData.getValue('Identity Number', i)
//	String placeOfBirth = excelData.getValue('Place Of Birth', i)
//	String dateOfBirth = excelData.getValue('Date Of Birth', i)
//	String motherName = excelData.getValue('Mother Name', i)
//	String customerFullName = excelData.getValue('Customer Full Name', i)
//	
//	String gender = excelData.getValue('Gender', i)
//	String birthPlace = excelData.getValue('Birth Place', i)
//	String address = excelData.getValue('Address', i)
//	String rt = excelData.getValue('RT', i)
//	String rw = excelData.getValue('RW', i)
//	String zipCode = excelData.getValue('Zip Code', i)
//	String subZipCode = excelData.getValue('Sub Zip Code', i)
//	String province = excelData.getValue('Province', i)
//	String city = excelData.getValue('City', i)
//	String kecamatan = excelData.getValue('Kecamatan', i)
//	String kelurahan = excelData.getValue('Kelurahan', i)
//	String religion = excelData.getValue('Religion', i)
//	String maritalStatus = excelData.getValue('Marital Status', i)
//	String occupationOnId = excelData.getValue('Occupation On ID', i)
//	String occupation = excelData.getValue('Occupation', i)
//	String nationality = excelData.getValue('Nationality', i)
//	String customerNumber = excelData.getValue('Customer Number', i)
//	
//	//Customer Job info and financial individu
//	String occupationType = excelData.getValue('Occupation Type', i)
//	String companyName = excelData.getValue('Company / Business Name', i)
//	String sectorIndustry = excelData.getValue('Sector Industry', i)
//	String subSectorIndustry = excelData.getValue('Sub Sector Industry', i)
//	String workSince = excelData.getValue('Work / Establish Since', i)
//	String salesIncome = excelData.getValue('Sales Turnover / Income', i)
//	String position = excelData.getValue('Position', i)
//	String borrowerIncome = excelData.getValue('Borrower Income', i)
//	String spouseIncome = excelData.getValue('Spouse Income', i)
//	String otherIncome = excelData.getValue('Other Income', i)
//	String expense = excelData.getValue('Expense', i)
//	String emergencyName = excelData.getValue('Name', i)
//	String relationship = excelData.getValue('Relationship', i)
//	String occupationTypeEmergency = excelData.getValue('Occupation Type Emergency', i)
//	String companyNameEmergency = excelData.getValue('Company Name Emergency', i)
//	String companyAddress = excelData.getValue('Company Address', i)
//	String addressType = excelData.getValue('Address Type', i)
//	String addressType1 = excelData.getValue('Address Type 2', i)
//	String addressType2 = excelData.getValue('Address Type 3', i)
//	String addressType3 = excelData.getValue('Address Type 4', i)
//	String addressType4 = excelData.getValue('Address Type 5', i)
//	String contactType1 = excelData.getValue('Contact Type 1', i)
//	String contactType2 = excelData.getValue('Contact Type 2', i)
//	String contactType3 = excelData.getValue('Contact Type 3', i)
//	String email = excelData.getValue('Email', i)
//	String phoneNumber1 = excelData.getValue('Mobile Phone 1', i)
//	String phoneNumber2 = excelData.getValue('Mobile Phone 2', i)
//	String specialNotes = excelData.getValue('Special Notes', i)
//	
//	String noOrder = excelData2.getValue('OrderID', i)
//	String noCustomer = excelData2.getValue('CustomerNo', i)
//	
//	//Login Into Web
//	CustomKeywords.'id.co.fifgroup.fifcore.loginFifcore.loginIntoWeb'(GlobalVariable.url, username, password)
//	CustomKeywords.'id.co.fifgroup.fifcore.utilities.chooseMenuAndSubMenu'(parentMenu, subMenu, thirdMenu)
//	if(RunConfiguration.getExecutionProfile()=='TEST') {
//		CustomKeywords.'id.co.fifgroup.fifcore.customerMaintenance.inquiryNomorOrder'(noOrder)
//	}else {
//		
//		CustomKeywords.'id.co.fifgroup.fifcore.customerMaintenance.inquiryNomorOrder'(noCustomer)
//	}
//	
//	CustomKeywords.'id.co.fifgroup.fifcore.customerMaintenance.idInfo'(GlobalVariable.RandomFullName, title, nickname, identityType, identityNumber, placeOfBirth, dateOfBirth, motherName,
//		GlobalVariable.RandomFullName, gender, birthPlace, address, rt, rw, zipCode, subZipCode, province, city, kecamatan, kelurahan, religion, maritalStatus, occupationOnId,
//		occupation, nationality, customerNumber)
//	CustomKeywords.'id.co.fifgroup.fifcore.customerMaintenance.individualJob'(occupationType, companyName, sectorIndustry, subSectorIndustry, workSince, salesIncome, position, address)
//	CustomKeywords.'id.co.fifgroup.fifcore.customerMaintenance.financialIndividual'(borrowerIncome, spouseIncome, otherIncome, expense)
//	CustomKeywords.'id.co.fifgroup.fifcore.customerMaintenance.inputEmergencyInfo'(emergencyName, relationship, occupationTypeEmergency, companyNameEmergency,companyAddress)
//	CustomKeywords.'id.co.fifgroup.fifcore.customerMaintenance.inputEmergencyInfoAddress'(addressType, address, rt, rw, zipCode, addressType1, addressType2, addressType3, addressType4)
//	CustomKeywords.'id.co.fifgroup.fifcore.customerMaintenance.inputEmergencyInfoContactInfo'(contactType1, contactType2, contactType3, email, phoneNumber1, phoneNumber2, specialNotes)
//	CustomKeywords.'id.co.fifgroup.fifcore.customerMaintenance.inputOtherAddresandContactInfo'(addressType, addressType4, addressType1, addressType4, addressType2, addressType4, addressType3, addressType4, email)
//	CustomKeywords.'id.co.fifgroup.fifcore.customerMaintenance.inputSave'()
//}
GlobalVariable.customerNo = '101250014948'
String dataCustomerMaintenance = 'Data Files/Submit UFI/Customer Maintenance - UFI'
GlobalVariable.testDataCustomerMaintenance = dataCustomerMaintenance
WebUI.callTestCase(findTestCase('Test Cases/Submit Order UFI/Customer Maintenance'), null)
	