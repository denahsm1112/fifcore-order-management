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
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

TestData excelData = findTestData('Data Files/Submit CLOP/CLOP Initial Order - UFI')

for (int i = 1; i <= excelData.getRowNumbers(); i++) {

	String username = excelData.getValue('Username', i)
	
   String password = excelData.getValue('Password', i)

    String parentMenu = 'CAP'

    String subMenu = 'Receive Order'

    String thirdMenu = 'Order Tracking'

    String noContract = excelData.getValue('No Contract', i)

    String noAppraisal = excelData.getValue('No Appraisal', i)

    String flagClop = excelData.getValue('Flag Contract', i)

    String companyID = excelData.getValue('Company', i)

    String businessUnit = excelData.getValue('Business Unit', i)

    String branch = excelData.getValue('Branch', i)

    String platform = excelData.getValue('Platform', i)

    String ojk = excelData.getValue('OJK Code', i)

    String credit = excelData.getValue('Credit Objective', i)

    String subcredit = excelData.getValue('Sub Credit', i)

    String sektor = excelData.getValue('Sektor', i)

    String so = excelData.getValue('Source Order', i)

    String visitDate = excelData.getValue('Visit Date', i)

    String vID = excelData.getValue('Verifier ID', i)

    String salesType1 = excelData.getValue('Sales Type 1', i)

    String salesType2 = excelData.getValue('Sales Type 2', i)

    String salesType3 = excelData.getValue('Sales Type 3', i)

    String salesIdInfo1 = excelData.getValue('Sales ID Info 1', i)

    String salesIdInfo2 = excelData.getValue('Sales ID Info 2', i)

    String salesIdInfo3 = excelData.getValue('Sales ID Info 3', i)

    String occupationOnId = excelData.getValue('Occupation On ID', i)

    String occupation = excelData.getValue('Occupation', i)

    String subOccupation = excelData.getValue('Sub Occupation', i)

    String wp = excelData.getValue('Working Period', i)

    String ktp = excelData.getValue('File KTP', i)

    String stnkValidUntil = excelData.getValue('STNK Valid Until', i)

    String amountTransfer = excelData.getValue('Amount  Transfer', i)

    String amountCredit = excelData.getValue('Amount Credit Objective', i)

    String promo = excelData.getValue('Promo', i)

    String installment = excelData.getValue('Installment Amount Per Unit', i)

    String colour = excelData.getValue('Colour', i)

    String kodepos = excelData.getValue('Kode Pos', i)

    String kodepos2 = excelData.getValue('Kode Pos 2', i)
	
	String dealerId = excelData.getValue('Dealer ID', i)

    String contact = '1' //MOBILE PHONE 1

    String contact2 = '2' //MOBILE PHONE 2

    String businessType = 'New Order'

    String calculationMethod = excelData.getValue('Calculation Method', i)

    String officeLine1 = '021651555112'

    String officeLine2 = '021651559031'

    String email = 'hahaCompany@mail.com'

    String rt = '10'

    String rw = '2'

    String address = 'JL EDELWEISS NO 1'
	GlobalVariable.FIND_CONTRACT = 'false'

    //Login Into Web
    CustomKeywords.'id.co.fifgroup.fifcore.loginFifcore.loginIntoWeb'(GlobalVariable.url, username, password)

    //Open Initial Order Form
    CustomKeywords.'id.co.fifgroup.fifcore.utilities.chooseMenuAndSubMenu'(parentMenu, subMenu, thirdMenu)

    //Menu Clop
    CustomKeywords.'id.co.fifgroup.fifcore.submitClop.goToMenuClop'()

    //Order Form
    CustomKeywords.'id.co.fifgroup.fifcore.createOrder.formOrder'(companyID, businessUnit, branch, platform, ojk, credit, 
        subcredit, sektor)

    //CLOP Form
	while(GlobalVariable.FIND_CONTRACT == 'false') {
		CustomKeywords.'id.co.fifgroup.fifcore.submitClop.formClop'(noContract, noAppraisal, flagClop, ojk)
		if(GlobalVariable.FIND_CONTRACT=='false') {
			i++
			noContract = excelData.getValue('No Contract', i)
			noAppraisal = excelData.getValue('No Appraisal', i)
			flagClop = excelData.getValue('Flag Contract', i)
			ojk = excelData.getValue('OJK Code', i)
		}
	}
    

    //General Form
    String CaCoord = ''

    CustomKeywords.'id.co.fifgroup.fifcore.createOrder.general'(so, visitDate, vID, CaCoord)

    //Sales Info
    CustomKeywords.'id.co.fifgroup.fifcore.createOrder.salesInfoUFI'(salesType1, salesIdInfo1, salesType2, salesIdInfo2, 
        salesType3, salesIdInfo3)

    //Upload Dokumen
    CustomKeywords.'id.co.fifgroup.fifcore.submitClop.addDocument'(ktp)

    //AP Cabang
    CustomKeywords.'id.co.fifgroup.fifcore.createOrder.inputApCabang'()

    //promo
    CustomKeywords.'id.co.fifgroup.fifcore.submitClop.promo'(calculationMethod, promo)

    //Update Customer Info
    CustomKeywords.'id.co.fifgroup.fifcore.submitClop.updateCustomerInfo'(occupationOnId, occupation, subOccupation, wp)

    CustomKeywords.'id.co.fifgroup.fifcore.submitClop.detailCustomerCLOP'(dealerId, stnkValidUntil, colour, amountTransfer, amountCredit, 
        installment, officeLine1, officeLine2, email, kodepos, kodepos2, rt, rw, address)

    //Submit Data
    CustomKeywords.'id.co.fifgroup.fifcore.submitClop.submitDataCLOP'(ojk, occupationOnId, occupation, subOccupation)

    WebUI.closeBrowser()


TestData excelData2 = findTestData('Data Files/Submit CLOP/CLOP Struktur Kredit - UFI')

//for (int i = 1; i <= excelData2.getRowNumbers(); i++) {
    //login data
    String username2 = excelData2.getValue('Username', i)

    String password2 = excelData2.getValue('Password', i)

    String parentMenu2 = excelData2.getValue('Parent Menu', i)

    String subMenu2 = 'Receive Order'

    String thirdMenu2 = 'Order Tracking'

    //order number edit
    String branch2 = excelData2.getValue('Branch', i)

    String ddlNavigation1 = excelData2.getValue('DDL Navigation 1', i)

    String ddlNavigation2 = excelData2.getValue('DDL Navigation 2', i)

    //submit struktur edit
    String installment2 = excelData2.getValue('Installment', i)

    String frequencyNumber = excelData2.getValue('Frequency Number', 1)

    String calculatedBy = excelData2.getValue('Calculated By', i)

    String interestRateEffective = excelData2.getValue('Interest Rate - Effective', i)

    String interestRateFlat = excelData2.getValue('Interest Rate - Flat', i)

    String grossAdmin = excelData2.getValue('Gross Admin', i)

    String advanceArrear = excelData2.getValue('Advance Arrear', i)

    String paymentMethod = excelData2.getValue('Payment Method', i)

    String commentInterest = excelData2.getValue('Comment Interest', i)

    //Address
    String provinsi = excelData2.getValue('Provinsi', i)

    String kota = excelData2.getValue('Kota', i)

    String kecamatan = excelData2.getValue('Kecamatan', i)

    String kelurahan = excelData2.getValue('Kelurahan', i)

    String alamat = excelData2.getValue('Alamat', i)

    String rt2 = excelData2.getValue('RT', i)

    String rw2 = excelData2.getValue('RW', i)

    String bpkbNumber = excelData2.getValue('BPKB Number', i)

    String bpkbDate = excelData2.getValue('BPKB Date', i)

    String receiveBank = excelData2.getValue('Receive Bank', i)

    String bankName = excelData2.getValue('Bank Name', i)

    String accountName = excelData2.getValue('Account Name', i)

    String accountNumber = excelData2.getValue('Account Number', i)

    String frequencyMonth = excelData2.getValue('Frequency Month', i)

    String menuAppraisal = 'Credit Section Head Menu'

    String menuCredit = 'Credit Application Processor Regular Menu'

    CustomKeywords.'id.co.fifgroup.fifcore.loginFifcore.loginIntoWeb'(GlobalVariable.url, username2, password2)

    CustomKeywords.'id.co.fifgroup.fifcore.utilities.chooseMenuAndSubMenu'(parentMenu2, subMenu2, thirdMenu2)

    CustomKeywords.'id.co.fifgroup.fifcore.submitStrukturKredit.cekUserAppraisalUFI'(branch2, GlobalVariable.teksOrder, ddlNavigation1)

    CustomKeywords.'id.co.fifgroup.fifcore.loginFifcore.logout'()

    CustomKeywords.'id.co.fifgroup.fifcore.loginFifcore.login'(GlobalVariable.appraisalUFI, password2)

    CustomKeywords.'id.co.fifgroup.fifcore.utilities.chooseMenuAndSubMenuPath'(subMenu2, thirdMenu2)

    CustomKeywords.'id.co.fifgroup.fifcore.submitStrukturKredit.appraisalKreditUFI'(branch2, GlobalVariable.teksOrder, ddlNavigation1)

    CustomKeywords.'id.co.fifgroup.fifcore.loginFifcore.logout'()

    CustomKeywords.'id.co.fifgroup.fifcore.loginFifcore.login'(GlobalVariable.creditStructureUFI, password2)

    CustomKeywords.'id.co.fifgroup.fifcore.utilities.chooseMenuAndSubMenuPath'(subMenu2, thirdMenu2)

    CustomKeywords.'id.co.fifgroup.fifcore.submitStrukturKredit.orderKreditUFIStruktur'(branch2, GlobalVariable.teksOrder, 
        ddlNavigation2)

    CustomKeywords.'id.co.fifgroup.fifcore.submitClop.submitStrukturUFIUpdate'(installment2, frequencyMonth, frequencyNumber, 
        calculatedBy, interestRateEffective, interestRateFlat, grossAdmin, advanceArrear, paymentMethod, receiveBank, bankName, 
        accountName, accountNumber)

    //MS looping
    TestData excelDataMSLooping = findTestData('Data Files/Submit CLOP/CLOP MS')
	int rowMS = 1;

    for (int x = 1; x <= excelDataMSLooping.getRowNumbers(); x++) {
        String schemeCode = excelDataMSLooping.getValue('Scheme Code', x)

        if (schemeCode == '') {
            KeywordUtil.logInfo('Scheme Code Tidak Diisi')
        } else {
            /*WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/12_btnAddMS'))

            WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/13_fldSchemeCode', [('addRow') : x]), 
                schemeCode)
                */
			WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/12_btnAddMS'))
			WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/13_fldSchemeCode', [('addRow') : rowMS]), schemeCode)
			WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/13_fldSchemeCode', [('addRow') : rowMS]), Keys.chord(Keys.TAB))
				if (WebUI.verifyElementPresent(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/20_lblDataTidakDitemukan'),3, FailureHandling.OPTIONAL)) {
					WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/21_btnOKMessageBox'))
					WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/34_chkMS', [('rowMS') : rowMS]))
					WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/35_btnDeleteMS'))
		
				}else {
					rowMS++;
				}
		}
    }
    
    //MP looping
    TestData excelDataMPLooping = findTestData('Data Files/Submit CLOP/CLOP MP')

    for (int y = 1; y <= excelDataMPLooping.getRowNumbers(); y++) {
        String marketingProgram = excelDataMPLooping.getValue('Marketing Program', y)

        if (marketingProgram == '') {
            KeywordUtil.logInfo('Marketing Program Tidak Diisi')
        } else {
            WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Add Scheme Credit Structure Test Object/01_btnAddRowMP'))

            WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Add Scheme Credit Structure Test Object/06_btnAddMP', 
                    [('addRow') : y]))

            WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/04_fldBankName'), 
                marketingProgram)

            WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/05_btnFind'))

            WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Add Scheme Credit Structure Test Object/03_btnDataFirst'))
        }
    }
    
    WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/16_btnTabObjectFinanced'))

    //Object Detail looping
    TestData excelDataOSLooping = findTestData('Data Files/Submit CLOP/CLOP OS')

    for (int z = 1; z <= excelDataOSLooping.getRowNumbers(); z++) {
        String objectScheme = excelDataOSLooping.getValue('Object Scheme', z)

        if (objectScheme == '') {
            KeywordUtil.logInfo('Object Detail Tidak Diisi')
        } else {
            WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Add Scheme Credit Structure Test Object/04_btnAddRowOS'))

            WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Add Scheme Credit Structure Test Object/05_fldOS', 
                    [('addRow') : z]), objectScheme)
        }
    }
    
    CustomKeywords.'id.co.fifgroup.fifcore.submitClop.objectFinanceBpkbAddress'(provinsi, kota, kecamatan, kelurahan, alamat, 
        rt, rw, bpkbNumber, bpkbDate)

    CustomKeywords.'id.co.fifgroup.fifcore.submitClop.submitOrderUFI'(commentInterest)

    CustomKeywords.'id.co.fifgroup.fifcore.loginFifcore.logout'()

    //Approve flag if N
    WebUI.callTestCase(findTestCase('Test Cases/Database Test/Database Query'), [('orderId') : GlobalVariable.teksOrder], 
        FailureHandling.OPTIONAL)
//}

TestData excelData3 = findTestData('Data Files/Submit CLOP/CLOP Approve Order - UFI')

//for (int k = 1; k <= excelData3.getRowNumbers(); k++) {
    String username3 = excelData3.getValue('Username', i)

    String password3 = excelData3.getValue('Password', i)

    String parentMenu3 = excelData3.getValue('ParentMenu', i)

    String remark = excelData3.getValue('Remark', i)

    //Approval
    String statusApproval = excelData3.getValue('Status Approval', i)

    String reason = excelData3.getValue('Reason', i)

    String isContractSigned = excelData3.getValue('Is Contract Signed', i)

    String comment = excelData3.getValue('Comment', i)

    String commentPo = excelData3.getValue('Comment PO Pending', i)

    String subMenuFirst3 = 'Receive Order'

    String thirdMenuFirst3 = 'Order Tracking'

    String subMenu3 = 'Credit Approval'

    String thirdMenu3 = 'Branch Approval'

	CustomKeywords.'id.co.fifgroup.fifcore.loginFifcore.loginIntoWeb'(GlobalVariable.url, username3, password3)
  
    CustomKeywords.'id.co.fifgroup.fifcore.utilities.chooseMenuAndSubMenu'(parentMenu3, subMenuFirst3, thirdMenuFirst3)

    CustomKeywords.'id.co.fifgroup.fifcore.approveOrder.inquiryOrder'(GlobalVariable.teksOrder)

    WebUI.closeBrowser()
	
	if(GlobalVariable.LoginApproverFirst != null) {

		CustomKeywords.'id.co.fifgroup.fifcore.loginFifcore.loginIntoWeb'(GlobalVariable.url, GlobalVariable.LoginApproverFirst,
			password)
		CustomKeywords.'id.co.fifgroup.fifcore.submitClop.approvalFirst'(GlobalVariable.teksOrder, remark)
	}
	
	//Login into webs
    CustomKeywords.'id.co.fifgroup.fifcore.loginFifcore.loginIntoWeb'(GlobalVariable.url, GlobalVariable.LoginApproverSecond, password)
	CustomKeywords.'id.co.fifgroup.fifcore.utilities.chooseMenuAndSubMenu'(parentMenu3, subMenu3, thirdMenu3)
	
    //new is upper
	CustomKeywords.'id.co.fifgroup.fifcore.approveOrder.approveOrderUFI'(GlobalVariable.teksOrder, branch)
	CustomKeywords.'id.co.fifgroup.fifcore.approveOrder.popUpOk'() 
	CustomKeywords.'id.co.fifgroup.fifcore.approveOrder.approvalDecison'(statusApproval, reason, isContractSigned, comment)
	CustomKeywords.'id.co.fifgroup.fifcore.approveOrder.submitPoPending'(commentPo)
	WebUI.callTestCase(findTestCase('Test Cases/Database Test/Document Checklist Query'), [('orderNumber') : GlobalVariable.teksOrder], FailureHandling.STOP_ON_FAILURE)
	WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Approve Order Test Object/19_btnSubmit'))
	WebUI.delay(3)
	
	CustomKeywords.'id.co.fifgroup.fifcore.utilities.logoutFromWeb'()
	WebUI.closeBrowser()
 
}
	
	
	
	
	

//    CustomKeywords.'id.co.fifgroup.fifcore.loginFifcore.loginIntoWeb'(GlobalVariable.url, GlobalVariable.LoginApproverFirst, 
//        password)
//
//    CustomKeywords.'id.co.fifgroup.fifcore.submitClop.approvalFirst'(GlobalVariable.teksOrder, remark)
//
//    //Credit Approval
//    CustomKeywords.'id.co.fifgroup.fifcore.loginFifcore.loginIntoWeb'(GlobalVariable.url, GlobalVariable.LoginApproveThird, 
//        password)
//
//    CustomKeywords.'id.co.fifgroup.fifcore.submitClop.approvalFirst'(GlobalVariable.teksOrder, remark)
//
//    //Credit Approval 2
//    CustomKeywords.'id.co.fifgroup.fifcore.loginFifcore.loginIntoWeb'(GlobalVariable.url, GlobalVariable.LoginCreditApprovalForth, 
//        password)
//
//    CustomKeywords.'id.co.fifgroup.fifcore.submitClop.approvalFirst'(GlobalVariable.teksOrder, remark)
//
//    //Login Into Web
//    CustomKeywords.'id.co.fifgroup.fifcore.loginFifcore.loginIntoWeb'(GlobalVariable.url, username, password)
//
//    CustomKeywords.'id.co.fifgroup.fifcore.utilities.chooseMenuAndSubMenu'(parentMenu3, subMenu3, thirdMenu3)
//
//    //new is upper
//    CustomKeywords.'id.co.fifgroup.fifcore.approveOrder.approveOrderUFI'(GlobalVariable.teksOrder, branch)
//
//    CustomKeywords.'id.co.fifgroup.fifcore.approveOrder.popUpOk'()
//
//    CustomKeywords.'id.co.fifgroup.fifcore.approveOrder.approvalDecison'(statusApproval, reason, isContractSigned, comment)
//
//    CustomKeywords.'id.co.fifgroup.fifcore.approveOrder.submitPoPending'(commentPo)
//
//    WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Approve Order Test Object/i9_btnSubmit'))
//
//    WebUI.delay(3)
//
//    CustomKeywords.'id.co.fifgroup.fifcore.utilities.logoutFromWeb'()
//
//    WebUI.closeBrowser()
//}

//TestData excelData4 = findTestData('Data Files/Submit CLOP/CLOP Generate AR')
//
////for (int l = 1; l <= excelData4.getRowNumbers(); l++) {
//    String username4 = excelData4.getValue('Username', i)
//
//    String password4 = excelData4.getValue('Password', i)
//
//    String companyID4 = excelData4.getValue('Company', i)
//
//    String businessUnit4 = excelData4.getValue('Business Unit', i)
//
//    String branch4 = excelData4.getValue('Branch', i)
//
//    String invoiceDateFrom = excelData4.getValue('Invoice Date From', i)
//
//    String invoiceDateTo = excelData4.getValue('Invoice Date To', i)
//
//    String parentMenu4 = 'CAP'
//
//    String subMenu4 = 'Contract Activation'
//
//    String thirdMenu4 = 'Generate AR'
//
//    //Login Into Web
//    CustomKeywords.'id.co.fifgroup.fifcore.loginFifcore.loginIntoWeb'(GlobalVariable.url, username4, password4)
//
//    CustomKeywords.'id.co.fifgroup.fifcore.utilities.chooseMenuAndSubMenu'(parentMenu4, subMenu4, thirdMenu4)
//
//    CustomKeywords.'id.co.fifgroup.fifcore.generateAR.formGenerateAR'(companyID4, businessUnit4, branch4, invoiceDateFrom, 
//        invoiceDateTo, GlobalVariable.teksOrder)




