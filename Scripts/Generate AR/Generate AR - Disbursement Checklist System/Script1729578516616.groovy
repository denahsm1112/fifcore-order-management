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


//Read Data
TestData excelData = findTestData('Data Files/Generate AR - Disbursement Checklist System')

for(int i = 1; i <= excelData.getRowNumbers(); i++) {
	
		Faker faker = new Faker()
	
		String randomFullNames = "${faker.lorem().word()} ${faker.space().moon()} ${faker.name().lastName()}"
	
		println('Fake Name: ' + randomFullNames)
	
		def randomFullName = randomFullNames.replaceAll('[^\\p{L}\\s]', '')
	
		randomFullName = randomFullName.replaceAll('\\d', '')
	
		println(randomFullName)
	
		GlobalVariable.RandomFullName = randomFullName
		
	
	String username = excelData.getValue('Username', i)
	String password = excelData.getValue('Password', i)
	String company = excelData.getValue('Company', i)
	String businessUnit = excelData.getValue('Business Unit', i)
	String branch = excelData.getValue('Branch', i)
	String invoiceDateFrom = excelData.getValue('Invoice Date From' , i)
	String invoiceDateTo = excelData.getValue('Invoice Date To' , i)
	String region = excelData.getValue('region', i)
	String teksOrder = excelData.getValue('Order Number' , i)
	String commentRevise = excelData.getValue('Comment Revise', i)
	String commentCAP = excelData.getValue('Comment CAP', i)
	String mobilePhone = excelData.getValue('Mobile Phone', i)
	String receiverName = excelData.getValue('Receiver Name', i)
	String parentMenu = 'CAP'
	String subMenu = 'Contract Activation'
	String thirdMenu = 'Generate AR'
	String menuDisbursement = 'Disbursement Checklist System'
	
	def randomPhoneNumber = '087812' + RandomStringUtils.randomNumeric(6)
	println('Phone Number: ' +randomPhoneNumber)
	
	//Login Into Web
	CustomKeywords.'id.co.fifgroup.fifcore.loginFifcore.loginIntoWeb'(GlobalVariable.url, username, password)
	//Navigate to Menu Contract Activation
	CustomKeywords.'id.co.fifgroup.fifcore.utilities.chooseMenuAndSubMenu'(parentMenu, subMenu, thirdMenu)
	//Find Generate Ar
	CustomKeywords.'id.co.fifgroup.fifcore.generateAR.formFindGenerateAr'(company, businessUnit, branch, invoiceDateFrom, invoiceDateTo, region)
	//Process Generate Ar Disbursement Checklist System
	CustomKeywords.'id.co.fifgroup.fifcore.generateAR.formDisbursementChecklistSystem'(menuDisbursement, teksOrder, randomPhoneNumber, randomFullName)
	//Submit Data
	CustomKeywords.'id.co.fifgroup.fifcore.generateAR.submitDataFormDisbursementChecklistSystem'(commentRevise, commentCAP, teksOrder, menuDisbursement)
	
	//WebUI.closeBrowser()
	
	//CustomKeywords.'id.co.fifgroup.fifcore.loginFifcore.logout'()
	

	
}