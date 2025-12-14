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

String host = GlobalVariable.HOST_DB
String port = '1521'
String sid = 'fifcore'
String username = 'FIFCORE'
String password = 'fifcore'

CustomKeywords.'id.co.fifgroup.fifcore.dbConnect.ConnectDB'(host, port, sid, username, password)

String selectQueryAppraisal = "UPDATE OM_TRN_ORDER_PIC P SET P.PIC = '"+userLogin+"', p.status='OPEN' where p.orderid = '"+orderNumber+"'and p.ORDERPROCESSTYPE ='APPRAISAL'"
println(selectQueryAppraisal)
CustomKeywords.'id.co.fifgroup.fifcore.dbConnect.execute'(selectQueryAppraisal)
WebUI.delay(1)

String executeQueryCredit = "UPDATE OM_TRN_ORDER_PIC P SET P.PIC = '"+userLogin+"', p.status='WAITING' where p.orderid = '"+orderNumber+"'and p.ORDERPROCESSTYPE ='CREDIT_STRUCTURE'"
println(executeQueryCredit)
CustomKeywords.'id.co.fifgroup.fifcore.dbConnect.execute'(executeQueryCredit)
WebUI.delay(1)

//String executeQueryApproval = "UPDATE OM_TRN_ORDER_PIC P SET P.PIC = '"+userLogin+"', p.status='WAITING' where p.orderid = '"+orderNumber+"'and p.ORDERPROCESSTYPE ='APPROVAL'"
//println(executeQueryApproval)
//CustomKeywords.'id.co.fifgroup.fifcore.dbConnect.execute'(executeQueryApproval)
//WebUI.delay(1)

String executeQueryCommit = "COMMIT"
println(executeQueryCommit)
CustomKeywords.'id.co.fifgroup.fifcore.dbConnect.execute'(executeQueryCommit)
WebUI.delay(1)
//println(selectQuery)
////List<List> rowList = CustomKeywords.'id.co.fifgroup.fifcore.dbConnect.executeQuery'(selectQuery)
//String rowListSubStr = rowList.toString()
//println(rowListSubStr)
