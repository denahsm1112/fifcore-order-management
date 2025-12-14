package id.co.fifgroup.fifcore

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import java.awt.Robot
import java.awt.event.KeyEvent
import java.util.concurrent.ConcurrentHashMap.KeySetView
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import org.openqa.selenium.Keys as Keys
import java.awt.Toolkit
import java.awt.datatransfer.StringSelection
import internal.GlobalVariable

public class utilities {
	@Keyword
	def static uploadFile (TestObject to, String filePath) {
		WebUI.click(to)
		StringSelection ss = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		Robot robot = new Robot();

		robot.delay(2000); //Millisecond 1 second delay only if needed
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.delay(2000); //Millisecond 1 second delay only if needed
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	@Keyword
	def chooseMenuAndSubMenu(String parentMenu, String subMenu, String thirdMenu) {
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/BM Dashboard Test Object/03_btnParentMenuVariable', [('parentMenu') : parentMenu]))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/BM Dashboard Test Object/04_btnSubMenuVariable', [('subMenu') : subMenu]))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/BM Dashboard Test Object/05_btnThirdMenuVariable', [('thirdMenu') : thirdMenu]))
	}

	@Keyword
	def chooseMenuAndSubMenuPath(String subMenu, String thirdMenu) {
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Test Object/25_btnMenuPertama'))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/BM Dashboard Test Object/04_btnSubMenuVariable', [('subMenu') : subMenu]))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/BM Dashboard Test Object/05_btnThirdMenuVariable', [('thirdMenu') : thirdMenu]))
	}

	@Keyword
	def chooseMenuAndSubMenuPO(String parentMenu, String subMenu) {
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/BM Dashboard Test Object/03_btnParentMenuVariable', [('parentMenu') : parentMenu]))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/BM Dashboard Test Object/04_btnSubMenuVariable', [('subMenu') : subMenu]))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/10_purchase order/04_btnMenuPO'))
	}

	@Keyword
	def chooseMenuAndSubMenuInvoice(String parentMenu, String subMenu) {
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/BM Dashboard Test Object/03_btnParentMenuVariable', [('parentMenu') : parentMenu]))
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/BM Dashboard Test Object/04_btnSubMenuVariable', [('subMenu') : subMenu]))
		//		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Legal Entity Test Object/10_purchase order/04_btnMenuPO'))
	}

	@Keyword
	def openBrowser(String urlBrowser) {
		WebUI.openBrowser(urlBrowser)
	}

	@Keyword
	def closeBrowser() {
		WebUI.closeBrowser()
	}

	@Keyword
	def logoutFromWeb() {
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Login Test Object/03_btnLogout'))
	}

	@Keyword
	def takeScreenCapture(String savingFolder, String fullname) {
		WebUI.waitForPageLoad(10)
		def date = new Date().format('hhmmss')
		WebUI.takeFullPageScreenshot(RunConfiguration.getProjectDir() + "/Screenshot/${savingFolder}"  +fullname+' - screenshoot- '+date+'.jpg', FailureHandling.STOP_ON_FAILURE)
	}

	@Keyword
	public static void sendKeysWithAddressType(String addressType) {

		def addressTypeMap = [
			'COLLECTION ADDRESS': 1,
			'HOME ADDRESS': 2,
			'MAILING ADDRESS': 3,
			'OFFICE ADDRESS': 4,
			'VERIFICATION ADDRESS': 5
		]

		def steps1 = addressTypeMap[addressType]

		if (steps1 != null) {
			for (def index : (0..steps1)) {
				WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Other Addresses and Contact Info/02_btnCopyFrom'), Keys.chord(Keys.DOWN))
			}
			WebUI.sendKeys(findTestObject('Object Repository/FIFCORE Test Object/Customer Maintenance Test Object/Other Addresses and Contact Info/02_btnCopyFrom'), Keys.chord(Keys.ENTER))
		}
	}
}
