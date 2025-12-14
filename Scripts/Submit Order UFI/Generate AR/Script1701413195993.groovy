import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import id.co.fifgroup.fifcore.utilities
import java.awt.Robot
import java.awt.event.KeyEvent
import java.util.concurrent.ConcurrentHashMap.KeySetView
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.kms.katalon.core.configuration.RunConfiguration
import internal.GlobalVariable
import java.nio.file.Path
import java.nio.file.Paths
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import org.openqa.selenium.Keys as Keys

TestData excelData = findTestData('Data Files/Generate AR')

for(int i = 1; i <= excelData.getRowNumbers(); i++) {
	
	String username = excelData.getValue('Username' , i)
	String password = excelData.getValue('Password' , i)
	String companyID = excelData.getValue('Company' , i)
	String businessUnit = excelData.getValue('Business Unit' , i)
	String branch = excelData.getValue('Branch' , i)
	String invoiceDateFrom = excelData.getValue('Invoice Date From' , i)
	String invoiceDateTo = excelData.getValue('Invoice Date To' , i)
	String teksOrder = excelData.getValue('Order Number' , i)
	String parentMenu = 'CAP'
	String subMenu = 'Contract Activation'
	String thirdMenu = 'Generate AR'
	
	
	
	//Login Into Web
	CustomKeywords.'id.co.fifgroup.fifcore.loginFifcore.loginIntoWeb'(GlobalVariable.url, username, password)
	CustomKeywords.'id.co.fifgroup.fifcore.utilities.chooseMenuAndSubMenu'(parentMenu, subMenu, thirdMenu)
	CustomKeywords.'id.co.fifgroup.fifcore.generateAR.formGenerateAR'(companyID, businessUnit, branch, 
		invoiceDateFrom, invoiceDateTo, teksOrder)
}