<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>Gain section information</name>
   <tag></tag>
   <elementGuidId>fa12d118-753d-4bf0-8608-08e49cf57bda</elementGuidId>
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
      <webElementGuid>2cc83398-b224-46e8-9b2e-508219fb4bb3</webElementGuid>
   </httpHeaderProperties>
   <katalonVersion>8.3.0</katalonVersion>
   <maxResponseSize>-1</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>GET</restRequestMethod>
   <restUrl>${apiIdentifier}sections/${sectionID}/</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>-1</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <variables>
      <defaultValue>GlobalVariable.teacherAccessToken</defaultValue>
      <description></description>
      <id>d6a452be-1031-42b6-80ba-207f2c39f0e9</id>
      <masked>false</masked>
      <name>teacherAccessToken</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.apiIdentifier</defaultValue>
      <description></description>
      <id>b60d8ff4-d914-467e-b417-ce5ac6965c3c</id>
      <masked>false</masked>
      <name>apiIdentifier</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.sectionID</defaultValue>
      <description></description>
      <id>4653b09f-bb28-4f20-9be6-a3dccbb527b8</id>
      <masked>false</masked>
      <name>sectionID</name>
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
