package com.cgweb.endpoint;


import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.cgweb.domain.UserInfo;
import com.cgweb.service.LoginService;
import com.cgweb.service.LoginServiceImpl;


@Endpoint
public class LoginEndpoint {

    private static final String NAMESPACE = "http://www.springwscgweb.org/types";
    

	@Autowired
	private LoginService loginService;
    
    @Autowired
    public void setLoginService(LoginServiceImpl loginService) {
      this.loginService = loginService;
    }
    
    public LoginEndpoint() {
    	System.out.println("Myconstructor");
		// TODO Auto-generated constructor stub
	}
    
    @PayloadRoot(localPart = "loginRequest",namespace = "http://www.springwscgweb.org/types")
    @ResponsePayload
    public Element processOrder(@RequestPayload Element request) throws ParserConfigurationException {
    	System.out.println("hitting");
    	//TODO Create a service class to hit the dao.
    	//String text = request.getChildNodes().item(0).getNodeValue();
    	
    	String userName = request.getChildNodes().item(0).getTextContent();;//request.getAttributeNodeNS(NAMESPACE, "userId").toString();
    	System.out.println("Request Pay Load: " + request.getChildNodes().item(0).getChildNodes().item(0).getNodeValue());
    	System.out.println("Request Pay Load: " + request.getChildNodes().item(0).getTextContent());
    	//System.out.println("Request Pay Load: " + request.getChildNodes().item(1));
    	//System.out.println("Request Pay Load: " + request.getChildNodes().item(2));
    	String password = request.getChildNodes().item(1).getTextContent();;//request.getAttributeNodeNS(NAMESPACE, "password").toString();
    	
    	System.out.println("LoginEndpoint.processOrder() userName:"+userName);
    	System.out.println("LoginEndpoint.processOrder() password:"+password);
    	
    	UserInfo userInfo = loginService.getUserInfo(userName, password);
    	System.out.println("LoginEndpoint.processOrder() userInfo :"+ userInfo);
    	String firstName = "";
    	if(userInfo != null)
    	{
    		System.out.println("LoginEndpoint.processOrder() userInfo :"+userInfo.getFirstName());
    		firstName = userInfo.getFirstName();
    	}
    	else
    	{
    		firstName = "User Not Found";
    	}
    	
        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        Element response = document.createElementNS(NAMESPACE, "loginResponse");
        response.appendChild(addElementWithValue(document, "userName", firstName));
        response.appendChild(addElementWithValue(document, "entity", "2"));
        return response;
    }
    
    private Element addElementWithValue(Document document, String element, String value){
        System.out.println("addElementWithValue");
    	Element child = document.createElementNS(NAMESPACE, element);
        child.appendChild(document.createTextNode(value));
        return child;
    }
}

