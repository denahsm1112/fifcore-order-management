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
import java.util.Random

String dataCustomerMaintenance = 'Data Files/Submit Order NMC/RO - Konvensional/Customer Maintenance NMC RO'
TestData excelData = findTestData(dataCustomerMaintenance)
	
	String parentMenu = 'CAP'
	String subMenu = 'Customer'
	String thirdMenu = 'Customer Maintenance'
	//String orderNumber = '10124003019'
	String customerNumberOrder = excelData.getValue('Customer Number Order', 1)
	String username = excelData.getValue('Username', 1)
	String password = excelData.getValue('Password', 1)
	String customerName = excelData.getValue('Customer Name', 1)
	String title = excelData.getValue('Title', 1)
	String nickname = excelData.getValue('Nickname', 1)
	String identityType = excelData.getValue('Identity Type', 1)
	String identityNumber = excelData.getValue('Identity Number', 1)
	String placeOfBirth = excelData.getValue('Place Of Birth', 1)
	String dateOfBirth = excelData.getValue('Date Of Birth', 1)
	String motherName = excelData.getValue('Mother Name', 1)
	String customerFullName = excelData.getValue('Customer Full Name', 1)
	
	String gender = excelData.getValue('Gender', 1)
	String birthPlace = excelData.getValue('Birth Place', 1)
	String address = excelData.getValue('Address', 1)
	String rt = excelData.getValue('RT', 1)
	String rw = excelData.getValue('RW', 1)
	String zipCode = excelData.getValue('Zip Code', 1)
	String subZipCode = excelData.getValue('Sub Zip Code', 1)
	String province = excelData.getValue('Province', 1)
	String city = excelData.getValue('City', 1)
	String kecamatan = excelData.getValue('Kecamatan', 1)
	String kelurahan = excelData.getValue('Kelurahan', 1)
	String religion = excelData.getValue('Religion', 1)
	String maritalStatus = excelData.getValue('Marital Status', 1)
	String occupationOnId = excelData.getValue('Occupation On ID', 1)
	String occupation = excelData.getValue('Occupation', 1)
	String nationality = excelData.getValue('Nationality', 1)
	String customerNumber = excelData.getValue('Customer Number', 1)
	
	//Customer Job info and financial individu
	String occupationType = excelData.getValue('Occupation Type', 1)
	String companyName = excelData.getValue('Company / Business Name', 1)
	String sectorIndustry = excelData.getValue('Sector Industry', 1)
	String subSectorIndustry = excelData.getValue('Sub Sector Industry', 1)
	String workSince = excelData.getValue('Work / Establish Since', 1)
	String salesIncome = excelData.getValue('Sales Turnover / Income', 1)
	String position = excelData.getValue('Position', 1)
	String borrowerIncome = excelData.getValue('Borrower Income', 1)
	String spouseIncome = excelData.getValue('Spouse Income', 1)
	String otherIncome = excelData.getValue('Other Income', 1)
	String expense = excelData.getValue('Expense', 1)
	String emergencyName = excelData.getValue('Name', 1)
	String relationship = excelData.getValue('Relationship', 1)
	String occupationTypeEmergency = excelData.getValue('Occupation Type Emergency', 1)
	String companyNameEmergency = excelData.getValue('Company Name Emergency', 1)
	String companyAddress = excelData.getValue('Company Address', 1)
	String addressType = excelData.getValue('Address Type', 1)
	String addressType1 = excelData.getValue('Address Type 2', 1)
	String addressType2 = excelData.getValue('Address Type 3', 1)
	String addressType3 = excelData.getValue('Address Type 4', 1)
	String addressType4 = excelData.getValue('Address Type 5', 1)
	String contactType1 = excelData.getValue('Contact Type 1', 1)
	String contactType2 = excelData.getValue('Contact Type 2', 1)
	String contactType3 = excelData.getValue('Contact Type 3', 1)
	String email = excelData.getValue('Email', 1)
	String phoneNumber1 = excelData.getValue('Mobile Phone 1', 1)
	String phoneNumber2 = excelData.getValue('Mobile Phone 2', 1)
	String specialNotes = excelData.getValue('Special Notes', 1)
	int howMuchContactInfo = 2
	
	//Login Into Web
	CustomKeywords.'id.co.fifgroup.fifcore.loginFifcore.loginIntoWeb'(GlobalVariable.url, username, password)
	CustomKeywords.'id.co.fifgroup.fifcore.utilities.chooseMenuAndSubMenu'(parentMenu, subMenu, thirdMenu)
	CustomKeywords.'id.co.fifgroup.fifcore.customerMaintenance.inquiryNomorOrder'(GlobalVariable.teksOrder)
	CustomKeywords.'id.co.fifgroup.fifcore.customerMaintenance.idInfo'(GlobalVariable.RandomFullName, title, nickname, identityType, identityNumber, placeOfBirth, dateOfBirth, motherName, 
		GlobalVariable.RandomFullName, gender, birthPlace, address, rt, rw, zipCode, subZipCode, province, city, kecamatan, kelurahan, religion, maritalStatus, occupationOnId, 
		occupation, nationality, customerNumber)
	CustomKeywords.'id.co.fifgroup.fifcore.customerMaintenance.individualJob'(occupationType, companyName, sectorIndustry, subSectorIndustry, workSince, salesIncome, position, address)
	CustomKeywords.'id.co.fifgroup.fifcore.customerMaintenance.financialIndividual'(borrowerIncome, spouseIncome, otherIncome, expense)
	CustomKeywords.'id.co.fifgroup.fifcore.customerMaintenance.inputEmergencyInfo'(emergencyName, relationship, occupationTypeEmergency, companyNameEmergency,companyAddress)
	CustomKeywords.'id.co.fifgroup.fifcore.customerMaintenance.inputEmergencyInfoAddressRO'(addressType, address, rt, rw, zipCode, addressType1, addressType2, addressType3, addressType4)
	CustomKeywords.'id.co.fifgroup.fifcore.customerMaintenance.inputEmergencyInfoContactInfoNMCRO'(contactType1, contactType2, contactType3, email, phoneNumber1, phoneNumber2, specialNotes, howMuchContactInfo)
	CustomKeywords.'id.co.fifgroup.fifcore.customerMaintenance.inputOtherAddresandContactInfo'(addressType, addressType2, addressType1, addressType2, addressType2, addressType2, addressType3, addressType2, email)
	CustomKeywords.'id.co.fifgroup.fifcore.customerMaintenance.inputSave'()


