<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>Gain user courses</name>
   <tag></tag>
   <elementGuidId>b081be58-3e39-47f8-8fe2-027b33f90cce</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent></httpBodyContent>
   <httpBodyType></httpBodyType>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Authorization</name>
      <type>Main</type>
      <value>Bearer ${teacherAccessToken}</value>
      <webElementGuid>696d88bd-e43a-4e18-9ed8-6ecf5e74e65c</webElementGuid>
   </httpHeaderProperties>
   <katalonVersion>8.3.0</katalonVersion>
   <maxResponseSize>-1</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>GET</restRequestMethod>
   <restUrl>${apiIdentifier}users/12345/courses/</restUrl>
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
      <id>cdbe574f-3e43-4a76-86ed-3b9c59f5b415</id>
      <masked>false</masked>
      <name>apiIdentifier</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.teacherID</defaultValue>
      <description></description>
      <id>b8f5022b-6915-42e4-9899-275d14a3c670</id>
      <masked>false</masked>
      <name>teacherID</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.teacherAccessToken</defaultValue>
      <description></description>
      <id>a668cde5-df02-49c3-990c-d6f908168e55</id>
      <masked>false</masked>
      <name>teacherAccessToken</name>
   </variables>
   <verificationScript>import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager

import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable

RequestObject request = WSResponseManager.getInstance().getCurrentRequest()

ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>
