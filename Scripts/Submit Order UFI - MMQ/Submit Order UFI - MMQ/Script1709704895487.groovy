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
import java.util.Random as Random
import com.github.javafaker.Faker
import java.text.SimpleDateFormat as SimpleDateFormat

TestData excelData = findTestData('Data Files/Submit UFI - MMQ/Submit New Initial Order - UFI - MMQ')

for (int i = 1; i <= excelData.getRowNumbers(); i++) {
    'Start Process'
    WS.comment('Start Process ke- ' + i)

    Faker faker = new Faker()

    String randomFullNames = "${faker.lorem().word()} ${faker.space().moon()} ${faker.name().lastName()}"

    println('Fake Name: ' + randomFullNames)

    def randomFullName = randomFullNames.replaceAll('[^\\p{L}\\s]', '')

    randomFullName = randomFullName.replaceAll('\\d', '')

    println(randomFullName)

    GlobalVariable.RandomFullName = randomFullName
	
	String randomMotherNames = "$faker.dog().name() $faker.cat().name() $faker.ancient().titan()"
	
	def randomMotherName = randomMotherNames.replaceAll('[^\\p{L}\\s]', '')
	
	println(randomMotherName)
	
	GlobalVariable.RandomMotherName = randomMotherName
	

    String username = excelData.getValue('Username', i)
	GlobalVariable.userLogin = username
    String password = excelData.getValue('Password', i)

    String parentMenu = 'CAP'

    String subMenu = 'Receive Order'

    String companyID = excelData.getValue('Company', i)

    String businessUnit = excelData.getValue('Business Unit', i)

    String branch = excelData.getValue('Branch', i)

    String platform = excelData.getValue('Platform', i)

    String subPlatform = excelData.getValue('Sub Platform', i)

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

    String rt = excelData.getValue('RT', i)

    String rw = excelData.getValue('RW', i)

    String kodePos = excelData.getValue('Kode Pos', i)

    String kodePos2 = excelData.getValue('Kode Pos 2', i)

    String contactInfo = excelData.getValue('Contact Info', i)

    String contactInfo2 = excelData.getValue('Contact Info 2', i)

    String email = excelData.getValue('Email', i)

    String waktuFasilitas = excelData.getValue('Waktu Fasilitas', i)

    String installmentType = excelData.getValue('Installment Type', i)

    String objGroup = excelData.getValue('Object Group', i)

    String dealerID = excelData.getValue('Sales ID', i)

    String objCode = excelData.getValue('Object Code', i)

    String colour = excelData.getValue('Colour', i)

    String noChassis = excelData.getValue('No Chassis', i)

    String noEngine = excelData.getValue('No Engine', i)

    String km = excelData.getValue('KM', i)

    String year = excelData.getValue('Year', i)

    String stnkUntil = excelData.getValue('STNK Until', i)

    String tobeTransfer = excelData.getValue('To Be Transfer', i)

    String amountCredit = excelData.getValue('Amount Credit', i)

    String installment = excelData.getValue('Installment', i)

    String so = excelData.getValue('Source Order', i)

    String visitDate = excelData.getValue('Visit Date', i)

    String caCoord = excelData.getValue('CA Coord', i)

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

    def bpkbNo = 'R99108' + RandomStringUtils.randomNumeric(5)

    //Login Into Web
    CustomKeywords.'id.co.fifgroup.fifcore.loginFifcore.loginIntoWeb'(GlobalVariable.url, username, password)

    //Access menu
    CustomKeywords.'id.co.fifgroup.fifcore.utilities.chooseMenuAndSubMenuInvoice'(parentMenu, subMenu)

    //Open Initial Order Form
    CustomKeywords.'id.co.fifgroup.fifcore.createOrder.newOrderReceiveOrder'(businessType)

    //Order Form Syariah
    CustomKeywords.'id.co.fifgroup.fifcore.createOrder.formOrderMMQ'(companyID, businessUnit, branch, platform, subPlatform, 
        ojk, credit, subcredit, sektor)

    //Initial Info
    CustomKeywords.'id.co.fifgroup.fifcore.createOrder.initialInfoMMQ'(nik, randomFullName, title, placeBirth, tglLahir, 
        namIbuRandom, gender, randomFullName, marital, occupationonId, occupation, wp, education, wpm, ojk, subOccupation)

    CustomKeywords.'id.co.fifgroup.fifcore.createOrder.formVerificationAddress'(address, rt, rw, kodePos, kodePos2, occupation)

    //Contact Info
    CustomKeywords.'id.co.fifgroup.fifcore.createOrder.contactInfoMMQ'(contact, contactInfo, contact2, contactInfo2, contact3, 
        email)

    //Object Info
    CustomKeywords.'id.co.fifgroup.fifcore.createOrder.objectInfoMMQ'(waktuFasilitas, objGroup, dealerID, objCode, colour, 
        noChassis, noEngine, km, year, stnkUntil, tobeTransfer, amountCredit, installment)

    //General Form
    CustomKeywords.'id.co.fifgroup.fifcore.createOrder.general'(so, visitDate, vID, caCoord)

    //Sales Info
    CustomKeywords.'id.co.fifgroup.fifcore.createOrder.salesInfoUFI'(salesType1, salesIdInfo1, salesType2, salesIdInfo2, 
        salesType3, salesIdInfo3)

    //Upload Dokumen
    CustomKeywords.'id.co.fifgroup.fifcore.createOrder.addDocument'(ktp, kk, ktpPasangan)

    //promo
    CustomKeywords.'id.co.fifgroup.fifcore.createOrder.promoMMQ'(installmentType)

    //AP Cabang
    CustomKeywords.'id.co.fifgroup.fifcore.createOrder.inputApCabang'()

    //Submit Data
    CustomKeywords.'id.co.fifgroup.fifcore.createOrder.submitDataMMQ'(ojk, occupationonId, occupation, subOccupation)

    //}
    //
    WebUI.closeBrowser()
	
	WebUI.callTestCase(findTestCase('Test Cases/Database Test/Document Checklist Query'), [('orderNumber') : GlobalVariable.teksOrder], FailureHandling.STOP_ON_FAILURE)
	

    TestData excelData2 = findTestData('Data Files/Submit UFI - MMQ/Submit Struktur Kredit UFI - MMQ')

    //for (int j = 1; j <= excelData2.getRowNumbers(); j++) {
    //login data
    String username2 = excelData2.getValue('Username', i)

    String password2 = excelData2.getValue('Password', i)

    String parentMenu2 = excelData2.getValue('Parent Menu', i)

    String subMenu2 = 'Receive Order'

    String thirdMenu = 'Order Tracking'

    //order number edit
    String branch2 = excelData2.getValue('Branch', i)

    String ddlNavigation1 = excelData2.getValue('DDL Navigation 1', i)

    String ddlNavigation2 = excelData2.getValue('DDL Navigation 2', i)

    //submit struktur edit
    String installment2 = excelData2.getValue('Installment', i)

    String frequecnyMonth = excelData2.getValue('Frequency Month', i)

    String frequencyNumber = excelData2.getValue('Frequency Number', i)

    String calculatedBy = excelData2.getValue('Calculated By', i)

    String interestRateEffective = excelData2.getValue('Equivalent Return Akhir', i)

    String interestRateFlat = excelData2.getValue('Flat Return', i)

    String grossAdmin = excelData2.getValue('Nett Admin', i)

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

    //Update
    String receiveBank = excelData2.getValue('Receive Bank', i)

    String bankName = excelData2.getValue('Bank Name', i)

    String accountName = excelData2.getValue('Account Name', i)

    String accountNumber = excelData2.getValue('Account Number', i)

    //CekUserAppraisal
    CustomKeywords.'id.co.fifgroup.fifcore.loginFifcore.loginIntoWeb'(GlobalVariable.url, username2, password2)

    CustomKeywords.'id.co.fifgroup.fifcore.utilities.chooseMenuAndSubMenu'(parentMenu2, subMenu2, thirdMenu)

    	CustomKeywords.'id.co.fifgroup.fifcore.submitStrukturKredit.cekUserAppraisalUFI'(branch, GlobalVariable.teksOrder, ddlNavigation1)
    	CustomKeywords.'id.co.fifgroup.fifcore.loginFifcore.logout'()
    ////	Appraisal
    	CustomKeywords.'id.co.fifgroup.fifcore.loginFifcore.login'(GlobalVariable.appraisalUFI, password2)
    	CustomKeywords.'id.co.fifgroup.fifcore.utilities.chooseMenuAndSubMenuPath'(subMenu2, thirdMenu)
    CustomKeywords.'id.co.fifgroup.fifcore.submitStrukturKredit.appraisalKreditUFI'(branch2, GlobalVariable.teksOrder, ddlNavigation1)

    	CustomKeywords.'id.co.fifgroup.fifcore.loginFifcore.logout'()
    	//Struktur Kredit Order
    	CustomKeywords.'id.co.fifgroup.fifcore.loginFifcore.login'(GlobalVariable.creditStructureUFI, password2)
    	CustomKeywords.'id.co.fifgroup.fifcore.utilities.chooseMenuAndSubMenuPath'(subMenu2, thirdMenu)
    CustomKeywords.'id.co.fifgroup.fifcore.submitStrukturKredit.orderKreditUFIStruktur'(branch, GlobalVariable.teksOrder, 
        ddlNavigation2)

    CustomKeywords.'id.co.fifgroup.fifcore.submitStrukturKredit.submitStrukturUFIUpdate'(installment2, frequecnyMonth, frequencyNumber, 
        calculatedBy, interestRateEffective, interestRateFlat, grossAdmin, advanceArrear, paymentMethod, receiveBank, bankName, 
        accountName, accountNumber)

    //MS looping
    TestData excelDataMSLooping = findTestData('Data Files/Submit UFI - MMQ/MS - UFI')
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
    TestData excelDataMPLooping = findTestData('Data Files/Submit UFI - MMQ/MP - UFI')

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
    TestData excelDataOSLooping = findTestData('Data Files/Submit UFI - MMQ/OS - UFI')

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
        alamat, rt2, rw2, bpkbNo, bpkbDate)

    CustomKeywords.'id.co.fifgroup.fifcore.submitStrukturKredit.submitOrderUFI'(commentInterest)

    CustomKeywords.'id.co.fifgroup.fifcore.loginFifcore.logout'()

    //Approve flag if N
    WebUI.callTestCase(findTestCase('Test Cases/Database Test/Database Query'), [('orderId') : GlobalVariable.teksOrder], 
        FailureHandling.STOP_ON_FAILURE)

    //}
    TestData excelData3 = findTestData('Data Files/Submit UFI - MMQ/Approve Order UFI - MMQ')

    //for(int k = 1; k <= excelData3.getRowNumbers(); k++) {
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

    String subMenuFirst = 'Receive Order'

    String thirdMenuFirst = 'Order Tracking'

    String subMenu3 = 'Credit Approval'

    String thirdMenu3 = 'Branch Approval'

    String branch3 = excelData3.getValue('Branch', i)

    CustomKeywords.'id.co.fifgroup.fifcore.loginFifcore.loginIntoWeb'(GlobalVariable.url, username3, password3)

    CustomKeywords.'id.co.fifgroup.fifcore.utilities.chooseMenuAndSubMenu'(parentMenu3, subMenuFirst, thirdMenuFirst)

    CustomKeywords.'id.co.fifgroup.fifcore.approveOrder.inquiryOrder'(GlobalVariable.teksOrder)

    WebUI.closeBrowser()

    CustomKeywords.'id.co.fifgroup.fifcore.loginFifcore.loginIntoWeb'(GlobalVariable.url, GlobalVariable.LoginApproverFirst, 
        password)

    CustomKeywords.'id.co.fifgroup.fifcore.approveOrder.approvalFirst'(GlobalVariable.teksOrder, remark)

    //Login Into Web
    CustomKeywords.'id.co.fifgroup.fifcore.loginFifcore.loginIntoWeb'(GlobalVariable.url, GlobalVariable.LoginApproverSecond, 
        password3)

    CustomKeywords.'id.co.fifgroup.fifcore.utilities.chooseMenuAndSubMenu'(parentMenu3, subMenu3, thirdMenu3)

    //find Order
    CustomKeywords.'id.co.fifgroup.fifcore.approveOrder.approveOrderUFI'(GlobalVariable.teksOrder, branch3)

    CustomKeywords.'id.co.fifgroup.fifcore.approveOrder.popUpOk'()

    //Approval
    CustomKeywords.'id.co.fifgroup.fifcore.approveOrder.approvalDecison'(statusApproval, reason, isContractSigned, comment)

    CustomKeywords.'id.co.fifgroup.fifcore.approveOrder.submitPoPending'(commentPo)

    WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Approve Order Test Object/19_btnSubmit'))

    WebUI.delay(3)

    //	CustomKeywords.'id.co.fifgroup.fifcore.utilities.logoutFromWeb'()
    WebUI.closeBrowser()

    //}
    //Set test Data 
    String dataCustomerMaintenance = 'Data Files/Submit UFI - MMQ/Customer Maintenance MMQ'

    GlobalVariable.testDataCustomerMaintenance = dataCustomerMaintenance

    WebUI.callTestCase(findTestCase('Test Cases/Submit Order UFI/Customer Maintenance'), null)

    'End Process'
    WS.comment('End Process ke- ' + i)
}



