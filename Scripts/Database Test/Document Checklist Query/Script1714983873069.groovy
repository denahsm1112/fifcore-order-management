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

String host = '10.17.28.212'
String port = '1521'
String sid = 'fifcore'
String username = 'FIFCORE'
String password = 'fifcore'

CustomKeywords.'id.co.fifgroup.fifcore.dbConnect.ConnectDB'(host, port, sid, username, password)



String selectQuery = "UPDATE OM_TRN_DOC_CHECKLIST_DTL SET Isreceive = '1', RECEIVEDATE = '05-JUL-19 12.00.00.000000000 AM' WHERE ID IN (SELECT DCD.ID FROM OM_TRN_DOC_CHECKLIST_DTL DCD JOIN OM_TRN_DOC_CHECKLIST DC ON Dcd.Supporteddocumentchecklistid = Dc.Id JOIN OM_TRN_ORDER ORD ON Ord.ID = Dc.Orderid WHERE Ord.Orderid = '"+orderNumber+"')"
println(selectQuery)
CustomKeywords.'id.co.fifgroup.fifcore.dbConnect.execute'(selectQuery)
WebUI.delay(3)
String commitQuery = "COMMIT"
CustomKeywords.'id.co.fifgroup.fifcore.dbConnect.execute'(commitQuery)
WebUI.delay(3)
//println(selectQuery)
////List<List> rowList = CustomKeywords.'id.co.fifgroup.fifcore.dbConnect.executeQuery'(selectQuery)
//String rowListSubStr = rowList.toString()
//println(rowListSubStr)
