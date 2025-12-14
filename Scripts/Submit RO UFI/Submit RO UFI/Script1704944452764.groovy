import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import id.co.fifgroup.fifcore.utilities as utilities
import java.awt.Robot as Robot
import java.awt.event.KeyEvent as KeyEvent
import java.util.concurrent.ConcurrentHashMap.KeySetView as KeySetView
import com.kms.katalon.core.annotation.Keyword as Keyword
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
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

TestData excelData = findTestData('Data Files/Submit RO/RO Submit UFI')

for (int i = 1; i <= excelData.getRowNumbers(); i++) {
    String username = excelData.getValue('Username', 1)
    String password = excelData.getValue('Password', 1)
    String companyID = excelData.getValue('Company', 1)
    String businessUnit = excelData.getValue('Business Unit', 1)
    String branch = excelData.getValue('Branch', 1)
    String platform = excelData.getValue('Platform', 1)
    String ojk = excelData.getValue('OJK Code', 1)
    String credit = excelData.getValue('Credit Objective', 1)
    String subcredit = excelData.getValue('Sub Credit', 1)
    String sektor = excelData.getValue('Sektor', 1)

    String nik = excelData.getValue('NIK' , 1)
    String custName = excelData.getValue('Cust Name', 1)
    String fullName = excelData.getValue('Full Name', 1)
    String title = excelData.getValue('Title', 1)
    String placeBirth = excelData.getValue('Tempat Lahir', 1)
    String tglLahir = excelData.getValue('Tgl Lahir', 1)
    String namaIbu = excelData.getValue('Nama Ibu', 1)
    String gender = excelData.getValue('Gender', 1)
    String marital = excelData.getValue('Marital', 1)
	String occupationonId = excelData.getValue('Occupation on ID', 1)
    String occupation = excelData.getValue('Occupation', 1)
	String subOccupation = excelData.getValue('Sub Occupation', 1)
    String wp = excelData.getValue('Work Period', 1)
    String education = excelData.getValue('Education', 1)
    String address = excelData.getValue('Address', 1)
    String rt = excelData.getValue('RT', 1)
    String rw = excelData.getValue('RW', 1)
    String kodePos = excelData.getValue('Kode Pos', 1)
    String kodePos2 = excelData.getValue('Kode Pos 2', 1)
    String contactInfo = excelData.getValue('Contact Info', 1)
    String contactInfo2 = excelData.getValue('Contact Info 2', 1)
    String tenor = excelData.getValue('Tenor', 1)
    String objGroup = excelData.getValue('Object Group', 1)
    String dealerID = excelData.getValue('Sales ID', 1)
    String objCode = excelData.getValue('Object Code', 1)
    String colour = excelData.getValue('Colour', 1)
    String noChassis = excelData.getValue('No Chassis', 1)
    String noEngine = excelData.getValue('No Engine', 1)
    String km = excelData.getValue('KM', 1)
    String year = excelData.getValue('Year', 1)
    String stnkUntil = excelData.getValue('STNK Until', 1)
    String tobeTransfer = excelData.getValue('To Be Transfer', 1)
    String amountCredit = excelData.getValue('Amount Credit', 1)
    String installment = excelData.getValue('Installment', 1)
    String so = excelData.getValue('Source Order', 1)
    String visitDate = excelData.getValue('Visit Date', 1)
    String vID = excelData.getValue('Verifier ID', 1)
    String salesType1 = excelData.getValue('Sales Type 1', 1)
    String salesType2 = excelData.getValue('Sales Type 2', 1)
    String salesType3 = excelData.getValue('Sales Type 3', 1)
    String salesIdInfo1 = excelData.getValue('Sales ID Info 1', 1)
    String salesIdInfo2 = excelData.getValue('Sales ID Info 2', 1)
    String salesIdInfo3 = excelData.getValue('Sales ID Info 3', 1)
    String ktp = excelData.getValue('File KTP', 1)
	String promo = excelData.getValue('Promo', 1)
	String calculationMethod = excelData.getValue('Calculation Method', 1)
    String wpm = '6'
    String businessType = 'New Order'
    

    //Login Into Web
    CustomKeywords.'id.co.fifgroup.fifcore.loginFifcore.loginIntoWeb'(GlobalVariable.url, username, password)
    //Open Initial Order Form
    CustomKeywords.'id.co.fifgroup.fifcore.createOrder.newOrder'(businessType)
    //Order Form
    CustomKeywords.'id.co.fifgroup.fifcore.createOrder.formOrder'(companyID, businessUnit, branch, platform, ojk, credit, 
        subcredit, sektor)
    //Initial Info
    CustomKeywords.'id.co.fifgroup.fifcore.repeatOrder.initialInfo'(nik, custName, title, placeBirth, tglLahir, namaIbu, 
        gender, fullName, marital, occupationonId, occupation, wp, education, wpm, ojk, subOccupation)
    CustomKeywords.'id.co.fifgroup.fifcore.repeatOrder.formVerificationAddress'(address, rt, rw, kodePos, kodePos2)
    //Contact Info
    CustomKeywords.'id.co.fifgroup.fifcore.repeatOrder.contactInfo'(contactInfo, contactInfo2)
    //Object Info
    CustomKeywords.'id.co.fifgroup.fifcore.createOrder.objectInfoAutoInvoice'(tenor, objGroup, dealerID, objCode, colour, 
        noChassis, noEngine, km, year, stnkUntil, tobeTransfer, amountCredit, installment)
    //General Form
    CustomKeywords.'id.co.fifgroup.fifcore.createOrder.general'(so, visitDate, vID)
    //Sales Info
    CustomKeywords.'id.co.fifgroup.fifcore.createOrder.salesInfoUFI'(salesType1, salesIdInfo1, salesType2, salesIdInfo2, 
        salesType3, salesIdInfo3)
    //Upload Dokumen
    CustomKeywords.'id.co.fifgroup.fifcore.submitClop.addDocument'(ktp)
    //promo
    CustomKeywords.'id.co.fifgroup.fifcore.createOrder.promo'(calculationMethod, promo)
    //AP Cabang
    CustomKeywords.'id.co.fifgroup.fifcore.createOrder.inputApCabang'()
    //Submit Data
    CustomKeywords.'id.co.fifgroup.fifcore.repeatOrder.submitData'(occupationonId, ojk)
}

WebUI.closeBrowser()

TestData excelData2 = findTestData('Data Files/Submit RO/RO Struktur Kredit - UFI')

for (int j = 1; j <= excelData2.getRowNumbers(); j++) {
    //login data
    String username = excelData2.getValue('Username', 1)
    String password = excelData2.getValue('Password', 1)
    String parentMenu = excelData2.getValue('Parent Menu', 1)
    String subMenu = 'Receive Order'
    String thirdMenu = 'Order Tracking'
    //order number edit
    String branch = excelData2.getValue('Branch', 1)
    String ddlNavigation1 = excelData2.getValue('DDL Navigation 1', 1)
    String ddlNavigation2 = excelData2.getValue('DDL Navigation 2', 1)
    //submit struktur edit
    String installment = excelData2.getValue('Installment', 1)
    String frequecnyMonth = excelData2.getValue('Frequency Month', 1)
    String frequencyNumber = excelData2.getValue('Frequency Number', 1)
    String calculatedBy = excelData2.getValue('Calculated By', 1)
    String interestRateEffective = excelData2.getValue('Interest Rate - Effective', 1)
    String interestRateFlat = excelData2.getValue('Interest Rate - Flat', 1)
    String grossAdmin = excelData2.getValue('Gross Admin', 1)
    String advanceArrear = excelData2.getValue('Advance Arrear', 1)
    String paymentMethod = excelData2.getValue('Payment Method', 1)
    String commentInterest = excelData2.getValue('Comment Interest', 1)

    //Address
    String provinsi = excelData2.getValue('Provinsi', 1)
    String kota = excelData2.getValue('Kota', 1)
    String kecamatan = excelData2.getValue('Kecamatan', 1)
    String kelurahan = excelData2.getValue('Kelurahan', 1)
    String alamat = excelData2.getValue('Alamat', 1)
    String rt = excelData2.getValue('RT', 1)
    String rw = excelData2.getValue('RW', 1)
    String bpkbNumber = excelData2.getValue('BPKB Number', 1)
    String bpkbDate = excelData2.getValue('BPKB Date', 1)
    String menuAppraisal = 'Credit Section Head Menu'
    String menuCredit = 'Credit Application Processor Regular Menu'

    //Uppdate
    String receiveBank = excelData2.getValue('Receive Bank', 1)
    String bankName = excelData2.getValue('Bank Name', 1)
    String accountName = excelData2.getValue('Account Name', 1)
    String accountNumber = excelData2.getValue('Account Number', 1)
	
    CustomKeywords.'id.co.fifgroup.fifcore.loginFifcore.loginIntoWeb'(GlobalVariable.url,username, password)
    CustomKeywords.'id.co.fifgroup.fifcore.utilities.chooseMenuAndSubMenu'(parentMenu, subMenu, thirdMenu)
    CustomKeywords.'id.co.fifgroup.fifcore.submitStrukturKredit.cekUserAppraisalUFI'(branch, GlobalVariable.teksOrder, ddlNavigation1)
    CustomKeywords.'id.co.fifgroup.fifcore.loginFifcore.logout'()
    CustomKeywords.'id.co.fifgroup.fifcore.loginFifcore.login'(GlobalVariable.appraisalUFI, password)
    CustomKeywords.'id.co.fifgroup.fifcore.utilities.chooseMenuAndSubMenuPath'(subMenu, thirdMenu)
    CustomKeywords.'id.co.fifgroup.fifcore.submitStrukturKredit.appraisalKreditUFI'(branch, GlobalVariable.teksOrder, ddlNavigation1)
    CustomKeywords.'id.co.fifgroup.fifcore.loginFifcore.logout'()
    CustomKeywords.'id.co.fifgroup.fifcore.loginFifcore.login'(GlobalVariable.creditStructureUFI, password)
    CustomKeywords.'id.co.fifgroup.fifcore.utilities.chooseMenuAndSubMenuPath'(subMenu, thirdMenu)
    CustomKeywords.'id.co.fifgroup.fifcore.submitStrukturKredit.orderKreditUFIStruktur'(branch, GlobalVariable.teksOrder, 
        ddlNavigation2)
    CustomKeywords.'id.co.fifgroup.fifcore.submitStrukturKredit.submitStrukturUFIUpdate'(installment, frequecnyMonth, frequencyNumber, 
        calculatedBy, interestRateEffective, interestRateFlat, grossAdmin, advanceArrear, paymentMethod, receiveBank, 
        bankName, accountName, accountNumber)
	
	//MS looping
	TestData excelDataMSLooping = findTestData('Data Files/Submit RO/RO MS - UFI')
	for (int x = 1; x <= excelDataMSLooping.getRowNumbers(); x++) {
		String schemeCode = excelDataMSLooping.getValue('Scheme Code' , x)
		if(schemeCode=='') {
			KeywordUtil.logInfo('Scheme Code Tidak Diisi')
		} else {
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/12_btnAddMS'))
			WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/13_fldSchemeCode',['addRow' : x]), schemeCode)
		}
	}
	
	//MP looping
	TestData excelDataMPLooping = findTestData('Data Files/Submit RO/RO MP - UFI')
	for (int y = 1; y <= excelDataMPLooping.getRowNumbers(); y++) {
		String marketingProgram = excelDataMPLooping.getValue('Marketing Program' , y)
		if(marketingProgram=='') {
			KeywordUtil.logInfo('Marketing Program Tidak Diisi')
		} else {
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Add Scheme Credit Structure Test Object/01_btnAddRowMP'))
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Add Scheme Credit Structure Test Object/06_btnAddMP',['addRow' : y]))
			WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/04_fldBankName'), marketingProgram)
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/05_btnFind'))
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Add Scheme Credit Structure Test Object/03_btnDataFirst'))
		}
	}

    WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/16_btnTabObjectFinanced'))
	
	//Object Detail looping
	TestData excelDataOSLooping = findTestData('Data Files/Submit RO/RO OS - UFI')
	for (int z = 1; z <= excelDataOSLooping.getRowNumbers(); z++) {
		String objectScheme = excelDataOSLooping.getValue('Object Scheme' , z)
		if(objectScheme=='') {
			KeywordUtil.logInfo('Object Detail Tidak Diisi')
		} else {
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Add Scheme Credit Structure Test Object/04_btnAddRowOS'))
			WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Add Scheme Credit Structure Test Object/05_fldOS',['addRow' : z]), objectScheme)
		}
	}

    CustomKeywords.'id.co.fifgroup.fifcore.submitStrukturKredit.objectFinanceBpkbAddress'(provinsi, kota, kecamatan, kelurahan, 
        alamat, rt, rw, bpkbNumber, bpkbDate)
    CustomKeywords.'id.co.fifgroup.fifcore.submitStrukturKredit.submitOrderUFI'(commentInterest)
    CustomKeywords.'id.co.fifgroup.fifcore.loginFifcore.logout'()

    //Approve flag if N
    WebUI.callTestCase(findTestCase('Test Cases/Database Test/Database Query'), [('orderId') : GlobalVariable.teksOrder], FailureHandling.STOP_ON_FAILURE)
}

TestData excelData3 = findTestData('Data Files/Submit RO/RO Approve - UFI')

for(int k = 1; k <= excelData3.getRowNumbers(); k++) {
	
	String username = excelData3.getValue('Username' , 1)
	String password = excelData3.getValue('Password' , 1)
	String parentMenu = excelData3.getValue('ParentMenu' , 1)
	String remark = excelData3.getValue('Remark' , 1)
	//Approval
	String statusApproval = excelData3.getValue('Status Approval' , 1)
	String reason  = excelData3.getValue('Reason' , 1)
	String isContractSigned = excelData3.getValue('Is Contract Signed' , 1)
	String comment = excelData3.getValue('Comment' , 1)
	String commentPo = excelData3.getValue('Comment PO Pending' , 1)
	String subMenuFirst = 'Receive Order'
	String thirdMenuFirst = 'Order Tracking'
	String subMenu = 'Credit Approval'
	String thirdMenu = 'Branch Approval'
	
	CustomKeywords.'id.co.fifgroup.fifcore.loginFifcore.loginIntoWeb'(GlobalVariable.url, username, password)
	CustomKeywords.'id.co.fifgroup.fifcore.utilities.chooseMenuAndSubMenu'(parentMenu, subMenuFirst, thirdMenuFirst)
	CustomKeywords.'id.co.fifgroup.fifcore.approveOrder.inquiryOrder'(GlobalVariable.teksOrder)
	WebUI.closeBrowser()
	CustomKeywords.'id.co.fifgroup.fifcore.loginFifcore.loginIntoWeb'(GlobalVariable.url, GlobalVariable.LoginApproverFirst, password)
	CustomKeywords.'id.co.fifgroup.fifcore.repeatOrder.approvalFirst'(GlobalVariable.teksOrder, remark)
	
	
	//Login Into Web
	CustomKeywords.'id.co.fifgroup.fifcore.loginFifcore.loginIntoWeb'(GlobalVariable.url, GlobalVariable.LoginApproverFirst, password)
	CustomKeywords.'id.co.fifgroup.fifcore.utilities.chooseMenuAndSubMenu'(parentMenu, subMenu, thirdMenu)
	//new is upper
	CustomKeywords.'id.co.fifgroup.fifcore.approveOrder.approveOrderUFI'(GlobalVariable.teksOrder)
	CustomKeywords.'id.co.fifgroup.fifcore.approveOrder.popUpOk'()
	CustomKeywords.'id.co.fifgroup.fifcore.approveOrder.approvalDecison'(statusApproval, reason, isContractSigned, comment)
	CustomKeywords.'id.co.fifgroup.fifcore.approveOrder.submitPoPending'(commentPo)
	WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Approve Order Test Object/19_btnSubmit'))
	WebUI.delay(3)
	CustomKeywords.'id.co.fifgroup.fifcore.utilities.logoutFromWeb'()
}