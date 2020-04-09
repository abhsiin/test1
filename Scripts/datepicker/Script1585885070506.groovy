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
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable

WebUI.openBrowser('')

WebUI.navigateToUrl('https://www.goindigo.in/')

WebUI.maximizeWindow()

WebUI.click(findTestObject('Datapicker/dateoption'))

def va = date

def mon = WebUI.getText(findTestObject('Datapicker/getMonth'))

println(mon)

def monval = findTestData('New Test Data').getValue(1, 1)

if (mon.contains(monval)) {
    println('doesnt match')
} else {
    WebUI.click(findTestObject('Datapicker/nexttriangle'))
}

mon = WebUI.getText(findTestObject('Datapicker/getMonth'))

if (mon.contains(monval)) {
    WebUI.click(findTestObject('Datapicker/pickdate', [('dat') : findTestData('New Test Data').getValue(2, 1), ('mcode') : findTestData(
                    'New Test Data').getValue(3, 1)]))
} else {
    println('not matched')
}

WebUI.click(findTestObject('Datapicker/pickdate', [('dat') : date, ('mcode') : monthcode]))

