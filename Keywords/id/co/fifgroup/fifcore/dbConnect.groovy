package id.co.fifgroup.fifcore

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.Statement
import java.sql.PreparedStatement
import java.sql.Driver
import oracle.jdbc.driver.OracleDriver
import java.sql.*
import oracle.jdbc.*
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

public class dbConnect {

	private static OracleConnection connection = null;

	@Keyword
	def ConnectDB(String host, String port, String sid, String username, String password) {
		String conn = "jdbc:oracle:thin:@" + host + ":" + port + ":" + sid
		if (connection != null && !connection.isClosed()) {
			connection.close()
		}
		connection = DriverManager.getConnection(conn, username, password)
		return connection
	}

	@Keyword
	def execute(String queryString) {
		Statement stm = connection.createStatement()
		ResultSet rs = stm.executeQuery(queryString)
		return rs
	}

	@Keyword
	def executeQuery(String queryString) {
		Statement stm = connection.createStatement()
		ResultSet resultSet = stm.executeQuery(queryString)
		ResultSetMetaData metadata = resultSet.getMetaData()
		int columnCount = metadata.getColumnCount()
		List<List<String>> rowList = new LinkedList<List<String>>()
		while (resultSet.next()) {
			List<String> row = new LinkedList<>()
			for(int i = 1; i <=columnCount; i++) {
				Object value = resultSet.getObject(i)
				row.add(value)
			}
			rowList.add(row)
		}
		for(List<String> row: rowList) {
			for(String data: row) {
				System.out.print(data + " ")
			}
			System.out.println()
		}
		return rowList
	}
}
