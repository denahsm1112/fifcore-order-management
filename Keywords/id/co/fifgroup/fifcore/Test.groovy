package id.co.fifgroup.fifcore

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class Test {

	@Keyword
	def addIndividualJobBusinessInfo(String occupationType, String companyName, String sectorIndustry,
			String subSectorIndustry, String establishSince, String income, String position, String companyAddress){
		WebUI.click(findTestObject('Object Repository/Test/Page_IndividualJobBusinessInfo/01_tab_CustomerJobInfodanFinancialIndividual'))
		WebUI.click(findTestObject('Object Repository/Test/Page_IndividualJobBusinessInfo/02_btn_AddRow'))
		WebUI.click(findTestObject('Object Repository/Test/Page_IndividualJobBusinessInfo/04_cb_OccupationType'))
		if(occupationType == 'EMPLOYEE') {
			WebUI.click(findTestObject('Object Repository/Test/Page_IndividualJobBusinessInfo/21_cb_OccupationType_EMPLOYEE'))
		}else if(occupationType == 'NON EMPLOYEE') {
			WebUI.click(findTestObject('Object Repository/Test/Page_IndividualJobBusinessInfo/22_cb_OccupationType_NON EMPLOYEE'))
		}else if(occupationType == 'PROFESSIONAL') {
			WebUI.click(findTestObject('Object Repository/Test/Page_IndividualJobBusinessInfo/23_cb_OccupationType_PROFESSIONAL'))
		}
		WebUI.setText(findTestObject('Object Repository/Test/Page_IndividualJobBusinessInfo/05_fld_CompanyBusinessName'), companyName)
		WebUI.click(findTestObject('Object Repository/Test/Page_IndividualJobBusinessInfo/06_fld_SectorIndustry'))
		WebUI.setText(findTestObject('Object Repository/Test/Page_IndividualJobBusinessInfo/08_fld_DescriptionSectorIndustry'), sectorIndustry)
		WebUI.click(findTestObject('Object Repository/Test/Page_IndividualJobBusinessInfo/09_btn_FindSectorIndustry'))
		WebUI.click(findTestObject('Object Repository/Test/Page_IndividualJobBusinessInfo/10_btn_SectorIndustryRow1'))
		WebUI.click(findTestObject('Object Repository/Test/Page_IndividualJobBusinessInfo/11_fld_SubSectorIndustry'))
		WebUI.setText(findTestObject('Object Repository/Test/Page_IndividualJobBusinessInfo/13_fld_DescriptionSubSectorIndustry'), subSectorIndustry)
		WebUI.click(findTestObject('Object Repository/Test/Page_IndividualJobBusinessInfo/14_btn_FindSubSectorIndustry'))
		WebUI.click(findTestObject('Object Repository/Test/Page_IndividualJobBusinessInfo/15_btn_SubSectorIndustryRow1'))
		//		WebUI.setText(findTestObject('Object Repository/Test/Page_IndividualJobBusinessInfo/16_fld_LicenseNumber'), licenseNumber)
		WebUI.setText(findTestObject('Object Repository/Test/Page_IndividualJobBusinessInfo/17_fld_WorkEstablishSince'), establishSince)
		WebUI.setText(findTestObject('Object Repository/Test/Page_IndividualJobBusinessInfo/18_fld_SalesTurnoverIncome'), income)
		WebUI.setText(findTestObject('Object Repository/Test/Page_IndividualJobBusinessInfo/19_fld_Position'), position)
		WebUI.setText(findTestObject('Object Repository/Test/Page_IndividualJobBusinessInfo/20_fld_CompanyAddress'), companyAddress)
	}
}
