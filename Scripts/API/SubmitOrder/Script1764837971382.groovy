import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.github.kklisura.cdt.protocol.types.fetch.ResponseBody
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

import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.testobject.RequestObject as RequestObject
import com.kms.katalon.core.testobject.ResponseObject as ResponseObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import java.sql.ResultSet
import java.sql.ResultSetMetaData


TestData excelData = findTestData('Data Files/API/TestData-SubmitOrder')

for (int i = 1; i <= excelData.getRowNumbers(); i++) {
	'Start Process'
	WS.comment('Start Process ke- ' +i)
	String officeCode = excelData.getValue('OfficeCode', i)
	String serviceOfficeCode = excelData.getValue('ServiceOfficeCode', i)
	String createdBy = excelData.getValue('Createdby', i)
	String custID = excelData.getValue('CustID', i)
	String custName = excelData.getValue('CustName', i)
	String custNIKName = excelData.getValue('CustNIKName', i)
	String birthDate = excelData.getValue('BirthDate', i)
	String birthPlace = excelData.getValue('BirthPlace', i)
	String sex = excelData.getValue('Sex', i)
	String mothersName = excelData.getValue('MothersName', i)
	String objectCode = excelData.getValue('ObjectCode', i)
	String objectGroup = excelData.getValue('ObjectGroup', i)
	String objectPrice = excelData.getValue('ObjectPrice', i)
//	String noRangka = excelData.getValue('NoRangka', i)
//	String noMesin = excelData.getValue('NoMesin', i)
	String bpkbSameName = excelData.getValue('BPKBSameName', i)
	String amountToBeTransfer = excelData.getValue('AmountToBeTransfer', i)
	String amountCreditObjective = excelData.getValue('AmountCreditObjective', i)
//	String tenor = excelData.getValue('Tenor', i)
	String top = excelData.getValue('Top', i)
//	String periode = excelData.getValue('PeriodeType', i)
	String monthInst = excelData.getValue('MonthInst', i)
	String flagTransfer = excelData.getValue('FlagTransfer', i)
	String flagCloseOpen = excelData.getValue('FlagCloseOpen', i)
	String sourceInputOri = excelData.getValue('SourceInputOri', i)
	String flagClp = excelData.getValue('FlagClp', i)
	String matchingFlagClp = excelData.getValue('MatchingFlagClp', i)

String orderNo = '777' + org.apache.commons.lang.RandomStringUtils.randomNumeric(7)
println(orderNo)

RequestObject testObject = findTestObject('Object Repository/API/getToken')
ResponseObject objectResp = WS.sendRequestAndVerify(testObject, FailureHandling.STOP_ON_FAILURE)
CustomKeywords.'api.utilitiesToken.getToken'(objectResp)
RequestObject response = findTestObject('Object Repository/API/ORDER SUBMIT - New',
[
		('token') : GlobalVariable.JWT_TOKEN,
		('orderNo') :  orderNo,
		('preOrderNo') : orderNo,
		('officeCode') :  officeCode,
		('serviceOfficeCode') : serviceOfficeCode,
		('createdBy') : createdBy,
		('custId') : custID,
		('custName') : custName,
		('custNikName') : custNIKName,
		('birthDate') : birthDate,
		('birthPlace') : birthPlace,
		('sex') : sex,
		('mothersName') : mothersName,
		('objectCode') : objectCode,
		('objectGroup') : objectGroup,
		('objectPrice') : objectPrice,
		('noRangka') :  noRangka,
		('noMesin') : noMesin,
		('bpkbSameName') : bpkbSameName,
		('amountToBeTransfer') : amountToBeTransfer,
		('amountCreditObjective') : amountCreditObjective,
		('tenor') : tenor,
		('top') : top,
		('periode') : periode,
		('monthInst') : monthInst,
		('flagTransfer') : flagTransfer,
		('flagCloseOpen') : "Y",
		('sourceInputOri') : sourceInputOri,
		('flagClp') : flagClp,
		('matchingFlagClp') : matchingFlagClp,
		('angsuranBerjalan') : angBerjalan,
		('branchID') : branchID,
		('contractActDate') : contractActDate,
		('sisaPokokHutang') : ssPokokHutang,
		('interestType') : interestType,
		('tenor') : tenor,
		('sisaTenor') : sisaTenor,
		('reffOrderNo') : reffOrderNo,
		('totalHutang') : totalHutang,
		('kontrakAktif') : kontrakAktif,
		('timeSpanDate') : timeSpanDate,
		('platform') : platform,
		('bussUnit') : bussUnit,
		('angsuranKe') : angsuranKe
		
		]) 

ResponseObject orderResp = WS.sendRequestAndVerify(response, FailureHandling.STOP_ON_FAILURE)

//Verify DB
String host = '10.17.28.91'
String port = '1521'
String sid = 'fifcore'
String username = 'FIFCORE'
String password = 'fifcore'

CustomKeywords.'api.dbConnect.ConnectDB'(host, port, sid, username, password)
String selectQuery = "SELECT ORDERID FROM OM_TRN_ORDER oto WHERE ORDERID = '"+orderNo+"'"
KeywordUtil.logInfo(selectQuery)
String hasilQuery = CustomKeywords.'api.dbConnect.executeQuery'(selectQuery)
WebUI.delay(1)

def hasilString = hasilQuery.toString()     
def match = hasilString =~ /\d+/

if (match) {
	String cleanValue = match[0]
	KeywordUtil.logInfo("Order No ada di Database")
	assert cleanValue == orderNo.toString() :
			"OrderNo tidak match. DB: ${cleanValue}, Expected: ${orderNo}"
} else {
	assert false : "OrderNo tidak ada dalam Database"
}
}