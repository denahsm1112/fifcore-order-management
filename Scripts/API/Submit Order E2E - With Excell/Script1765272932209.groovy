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
import groovy.json.JsonSlurper as JsonSlurper
import org.apache.poi.hssf.record.ObjRecord as ObjRecord
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.testobject.RequestObject as RequestObject
import com.kms.katalon.core.testobject.ResponseObject as ResponseObject

TestData excelData = findTestData('Data Files/API/TestData-CekContract')

for (int i = 1; i <= excelData.getRowNumbers(); i++) {
    'Start Process'
    WS.comment('Start Process ke- ' + i)

    String contractNo = excelData.getValue('CONTRACT_NO', i)
	KeywordUtil.logInfo("Kontrak no : " + contractNo)
    RequestObject testObjToken = findTestObject('Object Repository/API/getToken')
    ResponseObject testRespToken = WS.sendRequestAndVerify(testObjToken, FailureHandling.STOP_ON_FAILURE)
    CustomKeywords.'api.utilitiesToken.getToken'(testRespToken)
    RequestObject objReq = findTestObject('Object Repository/API/Check contract', [('token') : GlobalVariable.JWT_TOKEN, ('contractNo') : contractNo])
    ResponseObject objResp = WS.sendRequestAndVerify(objReq, FailureHandling.STOP_ON_FAILURE)
    KeywordUtil.logInfo(objResp.toString())
    KeywordUtil.logInfo('Response Body: ' + objResp.getResponseBodyContent())
    int statusCode = objResp.getStatusCode()

    if (statusCode != 200) {
        KeywordUtil.logInfo((('Error: Status code ' + statusCode) + ' for contractNo: ') + contractNo)
        continue
    }
    
    String message = WS.getElementPropertyValue(objResp, 'message')

    if ((message == null) || message.trim().isEmpty()) {
        KeywordUtil.logInfo('Message tidak ada atau kosong.')
    } else {
        KeywordUtil.logInfo('Message: ' + message)

        if (message == '[Kontrak tidak sesuai dengan setup Parameter Check Contract]') {
            KeywordUtil.logInfo('Kontrak tidak sesuai')

            continue
        } else {
            String branchID = WS.getElementPropertyValue(objResp, 'data.branchId')
            String angsBerjalan = WS.getElementPropertyValue(objResp, 'data.angsuranBerjalan')
 //           String contActDate = WS.getElementPropertyValue(objResp, 'data.contractActiveDate')
            String ssPokokHutang = WS.getElementPropertyValue(objResp, 'data.sisaPokokHutang')
            String interestType = WS.getElementPropertyValue(objResp, 'data.interestType')
            String tenor = WS.getElementPropertyValue(objResp, 'data.tenor')
            String sisaTenor = WS.getElementPropertyValue(objResp, 'data.sisaTenor')
            String noka = WS.getElementPropertyValue(objResp, 'data.noka')
            String nosin = WS.getElementPropertyValue(objResp, 'data.nosin')
            String applNo = WS.getElementPropertyValue(objResp, 'data.applNo')
            String totalHutang = WS.getElementPropertyValue(objResp, 'data.totalHutang')
            String periode = WS.getElementPropertyValue(objResp, 'data.periode')
            String kontAktif = WS.getElementPropertyValue(objResp, 'data.kontrakAktif')
            String timeDate = WS.getElementPropertyValue(objResp, 'data.timeSpanDate')  
//            String platform = WS.getElementPropertyValue(objResp, 'data.platform')
//            String bussUnit = WS.getElementPropertyValue(objResp, 'data.bussUnit')
            String angsKe = WS.getElementPropertyValue(objResp, 'data.angsuranKe')
			
			WebUI.callTestCase(findTestCase('API/SubmitOrder'),
				[
					('noRangka') : noka, 
					('noMesin') : nosin, 
					('angBerjalan') : angsBerjalan, 
					('branchID') : branchID, 
					('contractActDate') : "2025-09-03 17:00:00", 
					('ssPokokHutang') : ssPokokHutang, 
					('interestType') : interestType, 
					('tenor') : tenor, 
					('sisaTenor') : sisaTenor, 
					('reffOrderNo') : applNo, 
					('totalHutang') :totalHutang, 
					('periode') : periode, 
					('kontrakAktif') : kontAktif, 
					('timeSpanDate') : timeDate, 
					('platform') : 'K', 
					('bussUnit') : "REFI", 
					('angsuranKe') : angsKe
					], FailureHandling.STOP_ON_FAILURE)	
        }
    }
}


