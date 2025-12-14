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
import java.nio.file.Path as Path
import com.kms.katalon.core.util.KeywordUtil
import java.nio.file.Paths as Paths
import org.openqa.selenium.Keys as Keys
import org.apache.commons.lang.RandomStringUtils as RandomStringUtils
import java.text.SimpleDateFormat;
import java.util.Date;
import com.github.javafaker.Faker

TestData excelData = findTestData('Data Files/Submit Order NMC/Create New Order NMC')

for (int i = 1; i <= excelData.getRowNumbers(); i++) {
	
	'Start Process'
	WS.comment('Start Process ke- ' +i)
	Faker faker = new Faker()
	//faker.hacker().
	
	String randomFullNames = "${faker.name().firstName()} ${faker.space().moon()} ${faker.name().lastName()}"
	println("Fake Name: " + randomFullNames)
	
	def randomFullName = randomFullNames.replaceAll(/[^\p{L}\p{N}\s]/, '')
	randomFullName = randomFullName.replaceAll(/\d/, '')
	println(randomFullName)
	
	GlobalVariable.RandomFullName = randomFullName
	
	String randomMotherNames = "${faker.dog().name()} ${faker.cat().name()} ${faker.ancient().titan()}"
	def randomMotherName = randomMotherNames.replaceAll(/[^\p{L}\s]/, '')
	println(randomMotherName)
	
	GlobalVariable.RandomMotherName = randomMotherName
	
	// Random Birthday
	String tglLahirRandom = faker.date().birthday(25, 30)
	println(tglLahirRandom)
	// Parse the original date string
	Date parsedDate = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy").parse(tglLahirRandom)
	// Format the parsed date to "dd/MM/yyyy"
	String randomBirthday = new SimpleDateFormat("dd/MM/yyyy").format(parsedDate)
	println(randomBirthday)
	
    String username1 = excelData.getValue('Username', i)
    String password1 = excelData.getValue('Password', i)
    String parentMenu1 = 'CAC2'
    String subMenu1 = 'Receive Order'
    String companyID = excelData.getValue('Company', i)
    String businessUnit = excelData.getValue('Business Unit', i)
    String branch1 = excelData.getValue('Branch', i)
    String platform = excelData.getValue('Platform', i)
    String ojk = excelData.getValue('OJK Code', i)
    String credit = excelData.getValue('Credit Objective', i)
    String subcredit = excelData.getValue('Sub Credit', i)
    String sektor = excelData.getValue('Sektor', i)

    //String nik = excelData.getValue('NIK' , 1)
    String custName = excelData.getValue('Cust Name', i)
    String fullName = excelData.getValue('Full Name', i)
    String title = excelData.getValue('Title', i)
    String placeBirth = excelData.getValue('Tempat Lahir', i)
    String tglLahir = excelData.getValue('Tgl Lahir', i)
    String namaIbu = excelData.getValue('Nama Ibu', i)
    String gender = excelData.getValue('Gender', i)
    String marital = excelData.getValue('Marital', i)
    String occupationonId = excelData.getValue('Occupation on ID', i)
    String occupation = excelData.getValue('Occupation', i)
    String subOccupation = excelData.getValue('Sub Occupation', i)
    String wp = excelData.getValue('Work Period Year', i)
    String education = excelData.getValue('Education', i)
    String address = excelData.getValue('Address', i)
    String rt1 = excelData.getValue('RT', i)
    String rw1 = excelData.getValue('RW', i)
    String kodePos = excelData.getValue('Kode Pos', i)
    String kodePos2 = excelData.getValue('Kode Pos 2', i)
    String contactInfo = excelData.getValue('Contact Info', i)
    String contactInfo2 = excelData.getValue('Contact Info 2', i)
    String email = excelData.getValue('Email', i)

    String tenor = excelData.getValue('Tenor', i)
    String installmentType = excelData.getValue('Installment Type', i)
    String objGroup = excelData.getValue('Object Group', i)
    String dealerID = excelData.getValue('Dealer ID', i)
    String objCode = excelData.getValue('Object Code', i)
    String colour = excelData.getValue('Colour', i)
    String price = excelData.getValue('Price Per Unit', i)
    String dpDealer = excelData.getValue('DP Dealer', i)
    String dpFIF = excelData.getValue('DP FIF', i)
    String installment1 = excelData.getValue('Installment', i)
	String caCoord = excelData.getValue('Ca Cord', i)
	
    String so = excelData.getValue('Source Order', i)
    String visitDate = excelData.getValue('Visit Date', i)
    String vID = excelData.getValue('Verifier ID', i)
    String salesType1 = excelData.getValue('Sales Type 1', i)
    String salesType2 = excelData.getValue('Sales Type 2', i)
    String salesType3 = excelData.getValue('Sales Type 3', i)
    String salesIdInfo1 = excelData.getValue('Sales ID Info 1', i)
    String salesIdInfo2 = excelData.getValue('Sales ID Info 2', i)
    String salesIdInfo3 = excelData.getValue('Sales ID Info 3', i)
    String ktp = excelData.getValue('File KTP', i)
    String kk = excelData.getValue('Slip Gaji Pasangan', i)
    String ktpPasangan = excelData.getValue('No Mesin', i)
    String promo = excelData.getValue('Promo', i)
    String contact = '1' //MOBILE PHONE 1
    String contact2 = '2' //MOBILE PHONE 2
    String contact3 = 'EMAIL' //EMAIL
    String wpm = excelData.getValue('Work Period Month', i)
    String businessType = 'New Order'
	String namIbuRandom = 'Ibu ' + randomFullName

    //
	def nik = '32030125' + RandomStringUtils.randomNumeric(8)
    println('NIK: ' + nik)

    //Login Into We
    CustomKeywords.'id.co.fifgroup.fifcore.loginFifcore.loginIntoWeb'(GlobalVariable.url, username1, password1)
    //Access menu
    CustomKeywords.'id.co.fifgroup.fifcore.utilities.chooseMenuAndSubMenuInvoice'(parentMenu1, subMenu1)

    //Open Initial Order Form
    CustomKeywords.'id.co.fifgroup.fifcore.createOrder.newOrderReceiveOrder'(businessType)

    //Order Form Syariah
    CustomKeywords.'id.co.fifgroup.fifcore.createOrder.formOrder'(companyID, businessUnit, branch1, platform, ojk, credit, 
        subcredit, sektor)

    //Initial Info
    CustomKeywords.'id.co.fifgroup.fifcore.createOrder.initialInfoMMQ'(nik, randomFullName, title, placeBirth, tglLahir, namIbuRandom, 
        gender, randomFullName, marital, occupationonId, occupation, wp, education, wpm, ojk, subOccupation)

    CustomKeywords.'id.co.fifgroup.fifcore.createOrder.formVerificationAddress'(address, rt1, rw1, kodePos, kodePos2, occupation)
	
    //Contact Info
	CustomKeywords.'id.co.fifgroup.fifcore.createOrder.contactInfoMMQ'(contact, contactInfo, contact2, contactInfo2, contact3, email)
   
    //Object Info
    CustomKeywords.'id.co.fifgroup.fifcore.createOrder.objectInfoNMC'(tenor, objGroup, dealerID, objCode, colour, price, 
        dpDealer, dpFIF, installment1)

    //General Form
    CustomKeywords.'id.co.fifgroup.fifcore.createOrder.general'(so, visitDate, vID, caCoord)

    //Sales Info
   CustomKeywords.'id.co.fifgroup.fifcore.createOrder.salesInfoNMC'(salesType1, salesIdInfo1, salesType2, salesIdInfo2)
    //Upload Dokumen
    CustomKeywords.'id.co.fifgroup.fifcore.createOrder.addDocument'(ktp, kk, ktpPasangan)

    //promo
    //CustomKeywords.'id.co.fifgroup.fifcore.createOrder.promo'(installmentType, promo)
    //AP Cabang
    CustomKeywords.'id.co.fifgroup.fifcore.createOrder.inputApCabang'()
    //Submit Data
    CustomKeywords.'id.co.fifgroup.fifcore.createOrder.submitDataMMQ'(ojk, occupationonId, occupation, subOccupation)
//}

//
WebUI.closeBrowser()

//WebUI.callTestCase(findTestCase('Test Cases/Database Test/Document Checklist Query'), [('orderNumber') : GlobalVariable.teksOrder], FailureHandling.STOP_ON_FAILURE)

//WebUI.callTestCase(findTestCase('Test Cases/Database Test/Document Checklist Query'), null)

TestData excelData2 = findTestData('Data Files/Submit Order NMC/Submit Struktur Kredit NMC')

//for (int j = 1; j <= excelData2.getRowNumbers(); j++) {
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
    String process = 'CREDIT_STRUCTURE'
	
    //submit struktur edit
    String installment2 = excelData2.getValue('Installment', i)
    String frequecnyMonth = excelData2.getValue('Frequency Month', i)
    String frequencyNumber = excelData2.getValue('Frequency Number', i)
    String calculatedBy = excelData2.getValue('Calculated By', i)
    String interestRate = excelData2.getValue('Interest Rate', i)
    String promoFee = excelData2.getValue('Promo Fee', i)
    String netAdmin = excelData2.getValue('Nett Admin', i)
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
    String menuAppraisal = 'Credit Section Head Menu'
    String menuCredit = 'Credit Application Processor Regular Menu'
//	String usernameSK = excelData.getValue('Username', i)

    //Update
    String receiveBank = excelData2.getValue('Receive Bank', i)
    String bankName = excelData2.getValue('Bank Name', i)
    String accountName = excelData2.getValue('Account Name', i)
    String accountNumber = excelData2.getValue('Account Number', i)
	
    //CekUserDetailProcess
    CustomKeywords.'id.co.fifgroup.fifcore.loginFifcore.loginIntoWeb'(GlobalVariable.url, username2, password2)
	CustomKeywords.'id.co.fifgroup.fifcore.utilities.chooseMenuAndSubMenu'(parentMenu2, subMenu2, thirdMenu2)
	CustomKeywords.'id.co.fifgroup.fifcore.submitStrukturKredit.cekUserProcessNMC'(branch2, GlobalVariable.teksOrder, ddlNavigation1, process)
	CustomKeywords.'id.co.fifgroup.fifcore.loginFifcore.logout'()
	
	CustomKeywords.'id.co.fifgroup.fifcore.loginFifcore.login'(GlobalVariable.approvalUFI, password2)
	CustomKeywords.'id.co.fifgroup.fifcore.utilities.chooseMenuAndSubMenuPath'(subMenu2, thirdMenu2)
    CustomKeywords.'id.co.fifgroup.fifcore.submitStrukturKredit.orderKreditUFIStruktur'(branch2, GlobalVariable.teksOrder, 
        ddlNavigation2)
	CustomKeywords.'id.co.fifgroup.fifcore.loginFifcore.logout'()
	
	CustomKeywords.'id.co.fifgroup.fifcore.loginFifcore.login'(GlobalVariable.creditStructureUFI, password2)
	CustomKeywords.'id.co.fifgroup.fifcore.utilities.chooseMenuAndSubMenuPath'(subMenu2, thirdMenu2)
	CustomKeywords.'id.co.fifgroup.fifcore.submitStrukturKredit.orderKreditUFIStruktur'(branch2, GlobalVariable.teksOrder,
		ddlNavigation2)
    CustomKeywords.'id.co.fifgroup.fifcore.submitStrukturKredit.submitStrukturNMC'(installment2, frequecnyMonth, frequencyNumber, 
        calculatedBy, interestRate, netAdmin, promoFee, advanceArrear, paymentMethod, receiveBank, bankName, accountName, 
        accountNumber) 

    //MS looping
    TestData excelDataMSLooping = findTestData('Data Files/Submit Order NMC/MS')
	int rowMS = 1;
	
	for (int x = 1; x <= excelDataMSLooping.getRowNumbers(); x++) {
		String schemeCode = excelDataMSLooping.getValue('Scheme Code', x)
		
		if (schemeCode == '') {
			KeywordUtil.logInfo('Scheme Code Tidak Diisi')
			} else {
		
				WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/12_btnAddMS'))
				WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/13_fldSchemeCode', [('addRow') : rowMS]), schemeCode)
				WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/CLOP Test Object/13_fldSchemeCode', [('addRow') : rowMS]), Keys.chord(Keys.TAB))
				if (WebUI.verifyElementPresent(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/20_lblDataTidakDitemukan'),3, FailureHandling.OPTIONAL)) {
					WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Reusable Element Test Object/21_btnOKMessageBox'))
					WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/34_chkMS', [('rowMS') : rowMS]))
					WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/35_btnDeleteMS'))
//		WS.comment('Data tidak ditemukan' )
				}else {
//		WS.comment('row : ' + rowMS)
					rowMS++;
				}
			}
		}
		
    //MP looping
    TestData excelDataMPLooping = findTestData('Data Files/Submit Order NMC/MP')

    for (int y = 1; y <= excelDataMPLooping.getRowNumbers(); y++) {
        String marketingProgram = excelDataMPLooping.getValue('Marketing Program', y)

        if (marketingProgram == '') {
            KeywordUtil.logInfo('Marketing Program Tidak Diisi')
        } else {
            WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Add Scheme Credit Structure Test Object/01_btnAddRowMP'))
            WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Add Scheme Credit Structure Test Object/06_btnAddMP', [('addRow') : y]))
            WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/04_fldBankName'), marketingProgram)
            WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Customer Maintenance Test Object/05_btnFind'))
            WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Add Scheme Credit Structure Test Object/03_btnDataFirst'))
        }
    }
    
    WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Submit Struktur Kredit Test Object/Detail Order/16_btnTabObjectFinanced'))

    //Object Detail looping
    TestData excelDataOSLooping = findTestData('Data Files/Submit Order NMC/OS')

    for (int z = 1; z <= excelDataOSLooping.getRowNumbers(); z++) {
        String objectScheme = excelDataOSLooping.getValue('Object Scheme', z)

        if (objectScheme == '') {
            KeywordUtil.logInfo('Object Detail Tidak Diisi')
        } else {
            WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Add Scheme Credit Structure Test Object/04_btnAddRowOS'))

            WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Add Scheme Credit Structure Test Object/05_fldOS', [('addRow') : z]), objectScheme)
        }
    }
    
    CustomKeywords.'id.co.fifgroup.fifcore.submitStrukturKredit.objectFinanceBpkbAddress'(provinsi, kota, kecamatan, kelurahan, 
        alamat, rt2, rw2, bpkbNumber, bpkbDate)
    CustomKeywords.'id.co.fifgroup.fifcore.submitStrukturKredit.submitOrderUFI'(commentInterest)
    CustomKeywords.'id.co.fifgroup.fifcore.loginFifcore.logout'()

    //Approve flag if N
    WebUI.callTestCase(findTestCase('Test Cases/Database Test/Database Query'), [('orderId') : GlobalVariable.teksOrder], FailureHandling.STOP_ON_FAILURE)
//}

TestData excelData3 = findTestData('Data Files/Submit Order NMC/Approve Order NMC')

//for (int k = 1; k <= excelData3.getRowNumbers(); k++) {
    String username3 = excelData3.getValue('Username', i)
    String password3 = excelData3.getValue('Password', i)
    String parentMenu3 = excelData3.getValue('ParentMenu', i)
    String remark = excelData3.getValue('Remark', i)
	SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
	SimpleDateFormat formatterDD = new SimpleDateFormat("dd");
	Date date = new Date();
	
    //Approval
	String dealerID2 = excelData.getValue('Dealer ID', i)
	String dateFrom = formatter.format(date)
	String dateTo = formatter.format(date)
    String statusApproval = excelData3.getValue('Status Approval', i)
    String reason = excelData3.getValue('Reason', i)
    String isContractSigned = excelData3.getValue('Is Contract Signed', i)
    String comment = excelData3.getValue('Comment', i)
    String commentPo = excelData3.getValue('Comment PO Pending', i)
    String subMenuFirst = 'Receive Order'
    String thirdMenuFirst = 'Order Tracking'
    String subMenu3 = 'Credit Approval'
    String thirdMenu3 = 'Branch Approval'
	String menuPO = 'Purchase Order'
	String forthMenu = 'Invoice and BAST'
	String menuReceiveBAST = 'Receive Invoice and BAST'
	String menuCAP = 'CAP'
	String entryInvoice = 'Entry Invoice and BAST'

    //Login Into Web
	if(GlobalVariable.instantApproval != 'true') {
    CustomKeywords.'id.co.fifgroup.fifcore.loginFifcore.loginIntoWeb'(GlobalVariable.url, username3, 
        password3)
    CustomKeywords.'id.co.fifgroup.fifcore.utilities.chooseMenuAndSubMenu'(parentMenu3, subMenu3, thirdMenu3)
	CustomKeywords.'id.co.fifgroup.fifcore.legalEntity.approvalThird'(GlobalVariable.teksOrder, statusApproval, reason, comment)
	
    //find Order
//    CustomKeywords.'id.co.fifgroup.fifcore.approveOrder.approveOrderUFI'(GlobalVariable.teksOrder)
//    CustomKeywords.'id.co.fifgroup.fifcore.approveOrder.popUpOk'()

    //Approval
//    CustomKeywords.'id.co.fifgroup.fifcore.approveOrder.approvalDecison'(statusApproval, reason, isContractSigned, comment)
//    CustomKeywords.'id.co.fifgroup.fifcore.approveOrder.submitPoPending'(commentPo)
//    WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Approve Order Test Object/19_btnSubmit'))
//	CustomKeywords.'id.co.fifgroup.fifcore.approveOrder.popUpOk'()
    WebUI.delay(3)
    WebUI.closeBrowser()
	}
	
//	// Purchase Order (PO)
//	CustomKeywords.'id.co.fifgroup.fifcore.loginFifcore.loginIntoWeb'(GlobalVariable.url, username, password)
//	CustomKeywords.'id.co.fifgroup.fifcore.utilities.chooseMenuAndSubMenuPO'(parentMenu, menuPO)
//	CustomKeywords.'id.co.fifgroup.fifcore.legalEntity.purchaseOrderNMC'(GlobalVariable.teksPO, dateFrom, dateTo)
//	CustomKeywords.'id.co.fifgroup.fifcore.utilities.chooseMenuAndSubMenuInvoice'(forthMenu, menuReceiveBAST)
//	CustomKeywords.'id.co.fifgroup.fifcore.legalEntity.receiveInvoice'(GlobalVariable.teksPO, dealerID2)
//	
//	// Entry Invoice
//	
//	TestData excelData4 = findTestData('Data Files/Submit Order NMC/Entry Invoice NMC')
//	
//	//for(int m = 1; m <= excelData4.getRowNumbers(); m++) {
//	
//		String dealerID3 = excelData.getValue('Dealer ID', i)
//		String bastNo = excelData4.getValue('BAST Number' , i)
//		String bastDate = formatterDD.format(date)
//		String invoiceDealerNo = excelData4.getValue('Invoice Dealer Number' , i)
//		String invoiceDealerDate = formatterDD.format(date)
//		String noka = excelData4.getValue('NOKA' , i)
//		String nosin = excelData4.getValue('NOSIN' , i)
//		String noPlat = excelData4.getValue('NO Plat' , i)
//		String noFaktur = excelData4.getValue('No Faktur' , i)
//		String dateFaktur = excelData4.getValue('Date Faktur' , i)
//	
//		CustomKeywords.'id.co.fifgroup.fifcore.legalEntity.entryInvoiceNMC'(dealerID3, GlobalVariable.teksPO, bastNo, bastDate,
//			invoiceDealerNo, invoiceDealerDate, noka, nosin, noPlat, noFaktur, dateFaktur)
//	//}
//		WebUI.closeBrowser()
//}

//Set test Data
String dataCustomerMaintenance = 'Data Files/Submit Order NMC/Customer Maintenance NMC'
GlobalVariable.testDataCustomerMaintenance = dataCustomerMaintenance
//Customer Maintenance
WebUI.callTestCase(findTestCase('Test Cases/Submit Order UFI/Customer Maintenance'), null)
WebUI.closeBrowser()

'End Process'
WS.comment('End Process ke- '+i)

}

//TestData excelData4 = findTestData('Data Files/Submit Order NMC/Generate AR NMC')
//
//for(int l = 1; l <= excelData4.getRowNumbers(); l++) {
//
//	String username = excelData4.getValue('Username' , l)
//	String password = excelData4.getValue('Password' , l)
//	String companyID = excelData4.getValue('Company' , l)
//	String businessUnit = excelData4.getValue('Business Unit' , l)
//	String branch = excelData4.getValue('Branch' , l)
//	String invoiceDateFrom = formatter.format(date)
//	String invoiceDateTo = formatter.format(date)
//	String parentMenu = 'CAP'
//	String subMenu = 'Contract Activation'
//	String thirdMenu = 'Generate AR'
//
//	//Login Into Web
//	CustomKeywords.'id.co.fifgroup.fifcore.loginFifcore.loginIntoWeb'(GlobalVariable.url, username, password)
//	CustomKeywords.'id.co.fifgroup.fifcore.utilities.chooseMenuAndSubMenu'(parentMenu, subMenu, thirdMenu)
//	//Generate AR
//	CustomKeywords.'id.co.fifgroup.fifcore.generateAR.formGenerateAR'(companyID, businessUnit, branch,
//		invoiceDateFrom, invoiceDateTo, GlobalVariable.teksOrder)
////	WebUI.delay(60)
////	CustomKeywords.'id.co.fifgroup.fifcore.utilities.logoutFromWeb'()
////	WebUI.closeBrowser()
//}

