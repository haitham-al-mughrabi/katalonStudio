<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>Gain access token</name>
   <tag></tag>
   <elementGuidId>c593aab0-ebe9-4c8e-9607-335020ee9787</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n  \&quot;email\&quot;:\&quot;${teacherEmail}\&quot;,\n  \&quot;password\&quot;:\&quot;${teacherPassword}\&quot;\n}&quot;,
  &quot;contentType&quot;: &quot;application/json&quot;,
  &quot;charset&quot;: &quot;UTF-8&quot;
}</httpBodyContent>
   <httpBodyType>text</httpBodyType>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Content-Type</name>
      <type>Main</type>
      <value>application/json</value>
      <webElementGuid>f234bf03-1df9-4fb5-ae0c-dc856ae718c9</webElementGuid>
   </httpHeaderProperties>
   <katalonVersion>8.3.0</katalonVersion>
   <maxResponseSize>-1</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>${apiIdentifier}auth/token/obtain/</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>-1</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <variables>
      <defaultValue>GlobalVariable.apiIdentifier</defaultValue>
      <description></description>
      <id>4d938bd7-b8d1-4ab2-b50d-93e84877cff7</id>
      <masked>false</masked>
      <name>apiIdentifier</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.teacherEmail</defaultValue>
      <description></description>
      <id>1b3c0a7a-bdb7-459d-8790-a16cb1ffc5a3</id>
      <masked>false</masked>
      <name>teacherEmail</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.teacherPassword</defaultValue>
      <description></description>
      <id>358f7885-f1ab-4fdf-90d9-e18aedccbc33</id>
      <masked>false</masked>
      <name>teacherPassword</name>
   </variables>
   <verificationScript>import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager

import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable

RequestObject request = WSResponseManager.getInstance().getCurrentRequest()

ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()
</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>
