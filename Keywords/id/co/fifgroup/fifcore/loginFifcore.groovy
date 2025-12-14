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
import java.awt.Robot
import java.awt.event.KeyEvent
import java.util.concurrent.ConcurrentHashMap.KeySetView

import internal.GlobalVariable
import org.openqa.selenium.Keys as Keys

public class loginFifcore {

	@Keyword
	def loginIntoWeb(url, username, password) {

		WebUI.openBrowser(url)
		WebUI.maximizeWindow()
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_0);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_0);
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Login Test Object/02_fldUsername'), username)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Login Test Object/01_fldPassword'), password)
		WebUI.sendKeys(findTestObject('FIFCORE Test Object/Login Test Object/01_fldPassword'), Keys.chord(Keys.ENTER))
	}

	@Keyword
	def logout() {
		WebUI.click(findTestObject('Object Repository/FIFCORE Test Object/Update Scrum Test Object/24_btnLogout'))
	}

	@Keyword
	def login(username, password) {
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Login Test Object/02_fldUsername'), username)
		WebUI.setText(findTestObject('Object Repository/FIFCORE Test Object/Login Test Object/01_fldPassword'), password)
		WebUI.sendKeys(findTestObject('FIFCORE Test Object/Login Test Object/01_fldPassword'), Keys.chord(Keys.ENTER))
	}
}
