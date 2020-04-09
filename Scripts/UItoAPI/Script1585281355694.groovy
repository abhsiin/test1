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

def response = WS.sendRequest(findTestObject('getrest'))

def slurper = new groovy.json.JsonSlurper()

def result = slurper.parseText(response.getResponseBodyContent())

def res = result.data[2].email

println(res)

WebUI.openBrowser('')

WebUI.navigateToUrl('www.google.com')

WebUI.click(findTestObject('search/Page_Google/input_Sign in_q'))

WebUI.setText(findTestObject('search/Page_Google/input_Sign in_q'), res)

WebUI.click(findTestObject('search/Page_Google/img__hplogo'))

WebUI.click(findTestObject('search/Page_Google/input_Remove_btnK'))

WebUI.verifyTextPresent('About', false, FailureHandling.STOP_ON_FAILURE)

def getvalue = WebUI.getText(findTestObject('search/Page_Google/recordsvalue'))

println(getvalue)

WS.sendRequest(findTestObject('PostRest', [('name') : getvalue]))

Boolean coderange = WS.verifyResponseStatusCodeInRange(response, 200, 300)

println(coderange)

Boolean coderange1 = WS.verifyResponseStatusCodeInRange(response, 400, 500, FailureHandling.CONTINUE_ON_FAILURE)

println(coderange1)

WS.sendRequest(findTestObject('SOAP/Divide', [('firstval') : 10]))

