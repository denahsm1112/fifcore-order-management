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
import internal.GlobalVariable

import org.apache.poi.hssf.record.ObjRecord
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.testobject.RequestObject as RequestObject
import com.kms.katalon.core.testobject.ResponseObject as ResponseObject


String host = '10.17.28.91'
String port = '1521'
String sid = 'fifcore'
String username = 'FIFCORE'
String password = 'fifcore'

CustomKeywords.'api.dbConnect.ConnectDB'(host, port, sid, username, password)
String selectQuery = """
		SELECT
        CONT.APPL_NO,
        CONT.CONTRACT_NO,
        CONT.OFFICE_CODE AS BRANCH_SUM_CONTRACT,
        HDR.BRANCH_ID AS BRANCH_APPL_HDR,
        HDR.PLATFORM AS PLATFORM,
        HDR.BUSS_UNIT AS BUSS_UNIT,
        get_cori_grade(CUST.CUST_NO) AS cori_grade
    FROM ACCTMGMT.AR_TRN_SUM_CONTRACTS@fifapps.fif.co.id CONT
    LEFT JOIN AP.AP_BUCKET_CRM_GOODCUST@fifapps.fif.co.id BCKT
        ON CONT.CONTRACT_NO = BCKT.CONTRACT_NO 
        AND BCKT.BUSS_UNIT = 'REFI' 
        AND BCKT.IS_ACTIVE = 'Y'
    INNER JOIN ORDMGMT.OM_TRN_APPL_HDR@fifapps.fif.co.id HDR 
        ON HDR.APPL_NO = CONT.APPL_NO
    INNER JOIN ORDMGMT.OM_TRN_APPL_SC1@fifapps.fif.co.id SC 
        ON SC.APPL_NO = CONT.APPL_NO 
    INNER JOIN ORDMGMT.OM_TRN_APPL_STRUCRDT@fifapps.fif.co.id SCT 
        ON SCT.APPL_NO = CONT.APPL_NO 
    INNER JOIN ORDMGMT.OM_TRN_APPL_OBJECT@fifapps.fif.co.id OBJ 
        ON (OBJ.APPL_NO = CONT.APPL_NO AND OBJ.SEQ_NO = 1) 
    INNER JOIN FIFAPPS.FS_MST_CUST@fifapps.fif.co.id CUST 
        ON CONT.CUST_NO = CUST.CUST_NO 
    INNER JOIN FIFAPPS.FS_MST_CUST_IND@fifapps.fif.co.id IND 
        ON IND.CUST_NO = CUST.CUST_NO 
    LEFT JOIN ACCTMGMT.REM_TRN_PAL_ITEM_FEE@fifapps.fif.co.id REM 
        ON REM.PAL_NO = CONT.CURR_PAL_NO 
    LEFT JOIN INSC.INSC_TRN_CONT@fifapps.fif.co.id INSC 
        ON HDR.APPL_NO = INSC.APPL_NO 
    LEFT JOIN INSC.INSC_TRN_CLAIM@fifapps.fif.co.id CLAIM 
        ON INSC.CERT_NO = CLAIM.CERT_NO
    WHERE CONT.CONTRACT_STATUS = 'AC'
      AND CONT.OFFICE_CODE = '22300'
      AND get_cori_grade(CUST.CUST_NO) = 'MEDIUM'
      AND (
            BCKT.CONTRACT_NO IS NOT NULL 
            OR EXISTS (
                SELECT 1
                FROM ACCTMGMT.AR_TRN_INSTALLMENTS@fifapps.fif.co.id INST
                WHERE INST.CONTRACT_NO = CONT.CONTRACT_NO
                  AND (
                        SELECT COUNT(1)
                        FROM ACCTMGMT.AR_TRN_INSTALLMENTS@fifapps.fif.co.id
                        WHERE CONTRACT_NO = CONT.CONTRACT_NO 
                          AND PAID_DATE IS NULL
                      ) <= (
                        SELECT MAX(INST_NO)
                        FROM ACCTMGMT.AR_TRN_INSTALLMENTS@fifapps.fif.co.id
                        WHERE CONTRACT_NO = CONT.CONTRACT_NO
                      ) / 2
            )
        )
    FETCH FIRST 1 ROWS ONLY
 """

println(selectQuery)
String hasilQuery = CustomKeywords.'api.dbConnect.executeQuery'(selectQuery)
def contractNoStr = hasilQuery.toString()
def numbers = (contractNoStr =~ /\d+/).findAll()
def contractNo = numbers[1]
KeywordUtil.logInfo("Contract No = " + contractNo)
GlobalVariable.contractNo = contractNo
WebUI.delay(1)

RequestObject testObjToken = findTestObject('Object Repository/API/getToken')
ResponseObject testRespToken = WS.sendRequestAndVerify(testObjToken, FailureHandling.STOP_ON_FAILURE)
CustomKeywords.'api.utilitiesToken.getToken'(testRespToken)
RequestObject objReq = findTestObject('Object Repository/API/Check contract',
	[
		('token') : GlobalVariable.JWT_TOKEN,
		('contractNo') : GlobalVariable.contractNo
	])

ResponseObject objResp = WS.sendRequestAndVerify(objReq, FailureHandling.STOP_ON_FAILURE)
KeywordUtil.logInfo(objResp.toString())
KeywordUtil.logInfo("Response Body: " + objResp.getResponseBodyContent())
KeywordUtil.logInfo("Headers: " + objResp.getHeaderFields().toString())
KeywordUtil.logInfo("Redirect To: " + objResp.getHeaderField("Location"))

