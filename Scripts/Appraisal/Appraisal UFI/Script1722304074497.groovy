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
import java.nio.file.Path as Path
import java.nio.file.Paths as Paths
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration

TestData excelData2 = findTestData('Data Files/Submit UFI/Submit Struktur Kredit - UFI')
TestData excelData = findTestData('Data Files/Submit UFI/Submit New Initial Order - UFI')

for (int i = 1; i <= excelData2.getRowNumbers(); i++) {
	'Start Process'
	WS.comment('Start Process ke- ' +i)
	//login data
	String username2 = excelData2.getValue('Username', i)
	String password2 = excelData2.getValue('Password', i)
	
	String parentMenu1 = excelData2.getValue('Parent Menu', i)
	String subMenu1 = 'Receive Order'
	String thirdMenu1 = 'Order Tracking'
	//order number edit
	String branch2 = excelData2.getValue('Branch', 1)
	String ddlNavigation1 = excelData2.getValue('DDL Navigation 1', i)
	String ddlNavigation2 = excelData2.getValue('DDL Navigation 2', i)
	
	String noOrder = excelData.getValue('OrderID', i)
	GlobalVariable.userLogin = excelData.getValue('Username', i)
	
	CustomKeywords.'id.co.fifgroup.fifcore.loginFifcore.loginIntoWeb'(GlobalVariable.url,username2, password2)
	CustomKeywords.'id.co.fifgroup.fifcore.utilities.chooseMenuAndSubMenu'(parentMenu1, subMenu1, thirdMenu1)
	CustomKeywords.'id.co.fifgroup.fifcore.submitStrukturKredit.cekUserAppraisalUFI'(branch2, noOrder, ddlNavigation1)
	CustomKeywords.'id.co.fifgroup.fifcore.loginFifcore.logout'()
	CustomKeywords.'id.co.fifgroup.fifcore.loginFifcore.login'(GlobalVariable.appraisalUFI, password2)
	CustomKeywords.'id.co.fifgroup.fifcore.utilities.chooseMenuAndSubMenuPath'(subMenu1, thirdMenu1)
	CustomKeywords.'id.co.fifgroup.fifcore.submitStrukturKredit.appraisalKreditUFI'(branch2, noOrder, ddlNavigation1)
	CustomKeywords.'id.co.fifgroup.fifcore.loginFifcore.logout'()
	
	String filePath = RunConfiguration.getProjectDir() + '/Data Files/Submit UFI'
	Path projectPath = Paths.get(filePath)
	Path dataFilesPath = projectPath.resolve('Test Data UFI.xlsx')   // you do not need / and \ here
	File dataFilesDir = dataFilesPath.toFile()
		
	//Create an object of FileInputStream class to read excel file
	FileInputStream inputStream = new FileInputStream(dataFilesDir);
	
	// Create a new workbook and sheet - Struktur Kredit
	Workbook workbook = new XSSFWorkbook(inputStream)
	Sheet sheet = workbook.getSheet("Submit Struktur Kredit - UFI")
	Sheet sheet2 = workbook.getSheet("Approve Order BU - UFI")
	
	// Get a row and put some cells in it
	Row row = sheet.getRow(i)
	Cell cell1 = row.createCell(2)
	cell1.setCellValue(GlobalVariable.creditStructureUFI)
	
	Row row2 = sheet2.getRow(i)
	Cell cell2 = row2.createCell(0)
	cell2.setCellValue(GlobalVariable.approvalUFI)
	
	// Create a file output stream
	FileOutputStream fileOut = new FileOutputStream(dataFilesDir)
	
	// Write the workbook to the output stream
	workbook.write(fileOut)
	
	// Close the file output stream
	fileOut.close()
	
	// Close the workbook
	workbook.close()
	WebUI.closeBrowser()
	
}

	
	
