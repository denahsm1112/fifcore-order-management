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
import java.text.SimpleDateFormat;
import java.util.Date;

import com.github.javafaker.Faker;

Faker faker = new Faker();

TestData excelData = findTestData('Data Files/Submit Order NMC/Create New Order NMC')

String coba = faker.name().firstName();
System.out.println(coba);
GlobalVariable.teksOrder = '10124001393';
GlobalVariable.teksPO = '1010024PO00002491';
TestData excelData3 = findTestData('Data Files/Submit Order NMC/Approve Order NMC')

for (int k = 1; k <= excelData3.getRowNumbers(); k++) {
	String username = excelData3.getValue('Username', k)
	String password = excelData3.getValue('Password', k)
	String parentMenu = excelData3.getValue('ParentMenu', k)
	String remark = excelData3.getValue('Remark', k)
	SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
	SimpleDateFormat formatterDD = new SimpleDateFormat("dd");
	Date date = new Date();
	
	//Approval
	String dealerID2 = excelData.getValue('Dealer ID', 1)
	String dateFrom = formatter.format(date)
	String dateTo = formatter.format(date)
	String statusApproval = excelData3.getValue('Status Approval', k)
	String reason = excelData3.getValue('Reason', k)
	String isContractSigned = excelData3.getValue('Is Contract Signed', k)
	String comment = excelData3.getValue('Comment', k)
	String commentPo = excelData3.getValue('Comment PO Pending', k)
	String subMenuFirst = 'Receive Order'
	String thirdMenuFirst = 'Order Tracking'
	String subMenu = 'Credit Approval'
	String thirdMenu = 'Branch Approval'
	String menuPO = 'Purchase Order'
	String forthMenu = 'Invoice and BAST'
	String menuReceiveBAST = 'Receive Invoice and BAST'
	String menuCAP = 'CAP'
	String entryInvoice = 'Entry Invoice and BAST'

//    CustomKeywords.'id.co.fifgroup.fifcore.loginFifcore.loginIntoWeb'(GlobalVariable.url, username, password)
//    CustomKeywords.'id.co.fifgroup.fifcore.utilities.chooseMenuAndSubMenu'(parentMenu, subMenuFirst, thirdMenuFirst)
//    CustomKeywords.'id.co.fifgroup.fifcore.approveOrder.inquiryOrder'(GlobalVariable.teksOrder)
//    WebUI.closeBrowser()

//	//Login Into Web
//	CustomKeywords.'id.co.fifgroup.fifcore.loginFifcore.loginIntoWeb'(GlobalVariable.url, username,
//		password)
//	CustomKeywords.'id.co.fifgroup.fifcore.utilities.chooseMenuAndSubMenu'(parentMenu, subMenu, thirdMenu)
//
//	//find Order
//	CustomKeywords.'id.co.fifgroup.fifcore.approveOrder.approveOrderUFI'(GlobalVariable.teksOrder)
//	CustomKeywords.'id.co.fifgroup.fifcore.approveOrder.popUpOk'()
//
//	//Approval
//	CustomKeywords.'id.co.fifgroup.fifcore.approveOrder.approvalDecison'(statusApproval, reason, isContractSigned, comment)
//	CustomKeywords.'id.co.fifgroup.fifcore.approveOrder.submitPoPending'(commentPo)
//	WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Approve Order Test Object/19_btnSubmit'))
//	CustomKeywords.'id.co.fifgroup.fifcore.approveOrder.popUpOk'()
//	WebUI.delay(3)
//	CustomKeywords.'id.co.fifgroup.fifcore.utilities.logoutFromWeb'()
//	WebUI.closeBrowser()
	
	// Purchase Order (PO)
	CustomKeywords.'id.co.fifgroup.fifcore.loginFifcore.loginIntoWeb'(GlobalVariable.url, username, password)
	CustomKeywords.'id.co.fifgroup.fifcore.utilities.chooseMenuAndSubMenuPO'(parentMenu, menuPO)
//	CustomKeywords.'id.co.fifgroup.fifcore.legalEntity.purchaseOrderNMC'(GlobalVariable.teksPO, dateFrom, dateTo)
	CustomKeywords.'id.co.fifgroup.fifcore.utilities.chooseMenuAndSubMenuInvoice'(forthMenu, menuReceiveBAST)
//	CustomKeywords.'id.co.fifgroup.fifcore.legalEntity.receiveInvoice'(GlobalVariable.teksPO, dealerID2)
	
	// Entry Invoice
	
	TestData excelData4 = findTestData('Data Files/Submit Order NMC/Entry Invoice NMC')
	
	for(int m = 1; m <= excelData4.getRowNumbers(); m++) {
	
		String dealerID = excelData4.getValue('Dealer ID' , 1)
		String bastNo = excelData4.getValue('BAST Number' , 1)
		String bastDate = formatterDD.format(date)
		String invoiceDealerNo = excelData4.getValue('Invoice Dealer Number' , 1)
		String invoiceDealerDate = formatterDD.format(date)
		String noka = excelData4.getValue('NOKA' , 1)
		String nosin = excelData4.getValue('NOSIN' , 1)
		String noPlat = excelData4.getValue('NO Plat' , 1)
		String noFaktur = excelData4.getValue('No Faktur' , 1)
		String dateFaktur = excelData4.getValue('Date Faktur' , 1)
	
		CustomKeywords.'id.co.fifgroup.fifcore.legalEntity.entryInvoiceNMC'(dealerID, GlobalVariable.teksPO, bastNo, bastDate,
			invoiceDealerNo, invoiceDealerDate, noka, nosin, noPlat, noFaktur, dateFaktur)
	}
		WebUI.closeBrowser()
}

TestData excelData4 = findTestData('Data Files/Submit Order NMC/Generate AR NMC')

for(int l = 1; l <= excelData4.getRowNumbers(); l++) {

	String username = excelData4.getValue('Username' , l)
	String password = excelData4.getValue('Password' , l)
	String companyID = excelData4.getValue('Company' , l)
	String businessUnit = excelData4.getValue('Business Unit' , l)
	String branch = excelData4.getValue('Branch' , l)
	String invoiceDateFrom = excelData4.getValue('Invoice Date From' , l)
	String invoiceDateTo = excelData4.getValue('Invoice Date To' , l)
	String parentMenu = 'CAP'
	String subMenu = 'Contract Activation'
	String thirdMenu = 'Generate AR'

	//Login Into Web
	CustomKeywords.'id.co.fifgroup.fifcore.loginFifcore.loginIntoWeb'(GlobalVariable.url, username, password)
	CustomKeywords.'id.co.fifgroup.fifcore.utilities.chooseMenuAndSubMenu'(parentMenu, subMenu, thirdMenu)
	//Generate AR
	CustomKeywords.'id.co.fifgroup.fifcore.generateAR.formGenerateAR'(companyID, businessUnit, branch,
		invoiceDateFrom, invoiceDateTo, GlobalVariable.teksOrder)
//	WebUI.delay(60)
//	CustomKeywords.'id.co.fifgroup.fifcore.utilities.logoutFromWeb'()
//	WebUI.closeBrowser()
}


