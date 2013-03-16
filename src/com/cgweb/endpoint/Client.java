package com.cgweb.endpoint;

import java.io.StringReader;

import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.springframework.ws.client.core.WebServiceTemplate;

import com.cgeweb.utils.CgwebUtils;

public class Client {

//sample request XML
    private static String MESSAGE =
        "<loginRequest" +
        " xmlns=" +
        "\"http://www.springwscgweb.org/types\"><userId>Flowers</userId><password>700</password></loginRequest>";
    
    private static String USERINFOMESSAGE =
            "<userRequest" +
            " xmlns=" +
            "\"http://www.springwscgweb.org/types\"><userId>1</userId></userRequest>";
    
    private static String CHANGEPASSWORDMESSAGE =
            "<changePasswordRequest" +
            " xmlns=" +
            "\"http://www.springwscgweb.org/types\"><userId>1</userId><newPassword>XYZ</newPassword></changePasswordRequest>";
    
    private static String ALLUSERSMESSAGE =
            "<fetchAllUserDataRequest" +
            " xmlns=" +
            "\"http://www.springwscgweb.org/types\"><firstName>1</firstName></fetchAllUserDataRequest>";
    
    private static String REGISTERUSERMESSAGE =
            "<userRegisterOrUpdateRequest" +
            " xmlns=" +
            "\"http://www.springwscgweb.org/types\">" +
            "<firstName>1</firstName>" +
			"<middleName>1</middleName>" +
			"<lastName>1</lastName>" +
			"<primaryContactNumber>1</primaryContactNumber>" +
			"<secondaryContactNumber>1</secondaryContactNumber>" +
			"<contactNumber>1</contactNumber>" +
			"<emailId>1</emailId>" +
			"<gender>1</gender>" +
			"<userId>3</userId>" +
			"<contactListId>999</contactListId>" +
			"<designation>1</designation>" +
			"<addressLine1>1</addressLine1>" +
			"<addressLine2>1</addressLine2>" +
			"<city>1</city>" +
			"<street>1</street>" +
			"<phone>1</phone>" +
			"<fax>1</fax>" +
			"<state>1</state>" +
			"<zip>1</zip>" +
            "</userRegisterOrUpdateRequest>";
    
    private static String REGISTERCOMPANYMESSAGE =
            "<companyRegisterOrUpdateRequest" +
            " xmlns=" +
            "\"http://www.springwscgweb.org/types\">" +
            "<companyName>1</companyName>" +
			"<establishmentYear>1</establishmentYear>" +
			"<websiteAdd>1</websiteAdd>" +
			"<companyDescription>1</companyDescription>" +
			"<contactNumber>1</contactNumber>" +
			"<emailId>1</emailId>" +
			"<companyId>hcl</companyId>" +
			"<addressLine1>1</addressLine1>" +
			"<addressLine2>1</addressLine2>" +
			"<city>1</city>" +
			"<street>1</street>" +
			"<phone>177777</phone>" +
			"<fax>9990</fax>" +
			"<state>1</state>" +
			"<zip>1</zip>" +
            "</companyRegisterOrUpdateRequest>";

    public static void main(String[] args){
        StreamSource source = new StreamSource(new StringReader(ALLUSERSMESSAGE));
        StreamResult result = new StreamResult(System.out);
        System.out.println("source"+source+"\nAfter source and result	"+result);
//WebServiceTemplate provides the functionality for sending and receiving webservice messages. 
        WebServiceTemplate webServiceTemplate = new WebServiceTemplate();
        webServiceTemplate.sendSourceAndReceiveToResult("http://localhost:8080/cgweb/cgwebservices",
                source, result);

    }
}


