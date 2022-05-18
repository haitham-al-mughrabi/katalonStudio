<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>Gain course sections</name>
   <tag></tag>
   <elementGuidId>0fef7ccf-7e5d-4c17-8d5d-59d640fc712e</elementGuidId>
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
      <webElementGuid>0ce3a6a9-2b8a-457f-bfa0-376d05df143d</webElementGuid>
   </httpHeaderProperties>
   <katalonVersion>8.3.0</katalonVersion>
   <maxResponseSize>-1</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>GET</restRequestMethod>
   <restUrl>${apiIdentifier}courses/${courseID}/sections/</restUrl>
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
      <id>b1c09582-af2d-4947-9f4c-c3bd2a754e5a</id>
      <masked>false</masked>
      <name>teacherAccessToken</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.courseID</defaultValue>
      <description></description>
      <id>b0cf78ff-8318-496c-9ca8-ccd0e5d5f7c2</id>
      <masked>false</masked>
      <name>courseID</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.apiIdentifier</defaultValue>
      <description></description>
      <id>0a15ba0e-c9e7-47f5-99ed-f026082a7fad</id>
      <masked>false</masked>
      <name>apiIdentifier</name>
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
