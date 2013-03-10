package com.cgweb.endpoint;


import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.cgeweb.utils.CgwebUtils;
import com.cgweb.domain.Address;
import com.cgweb.domain.UserInfo;
import com.cgweb.service.UserService;
import com.cgweb.service.UserServiceImpl;


@Endpoint
public class UserEndpoint {

    private static final String NAMESPACE = "http://www.springwscgweb.org/types";
    

	@Autowired
	private UserService userService;
    
    @Autowired
    public void setUserService(UserServiceImpl userService) {
      this.userService = userService;
    }
    
    public UserEndpoint() {
    	System.out.println("UserEndpoint constructor");
		// TODO Auto-generated constructor stub
	}
    
    @PayloadRoot(localPart = "userRequest",namespace = "http://www.springwscgweb.org/types")
    @ResponsePayload
    public Element getUser(@RequestPayload Element request) throws ParserConfigurationException {
    	System.out.println("hitting userRequest");
    	//TODO Create a service class to hit the dao.
    	//String text = request.getChildNodes().item(0).getNodeValue();
    	
    	String userId = request.getChildNodes().item(0).getTextContent();;//request.getAttributeNodeNS(NAMESPACE, "userId").toString();
    	System.out.println("Request Pay Load: " + request.getChildNodes().item(0).getChildNodes().item(0).getNodeValue());
    	System.out.println("Request Pay Load: " + request.getChildNodes().item(0).getTextContent());
    	//System.out.println("Request Pay Load: " + request.getChildNodes().item(1));
    	//System.out.println("Request Pay Load: " + request.getChildNodes().item(2));
    	//String password = request.getChildNodes().item(1).getTextContent();;//request.getAttributeNodeNS(NAMESPACE, "password").toString();
    	
    	System.out.println("UserEndpoint.getUser() userId:"+userId);
    	//System.out.println("UserEndpoint.processOrder() password:"+password);
    	
    	UserInfo userInfo = userService.getUserInfo(userId);
    	System.out.println("UserEndpoint.getUser() userInfo :"+ userInfo);
    	String firstName = "";
    	Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        Element response = document.createElementNS(NAMESPACE, "userResponse");
            	
    	if(userInfo != null)
    	{
    		System.out.println("UserEndpoint.getUser() userInfo :"+userInfo.getFirstName()
    				+" userInfo.getMiddleName():"+userInfo.getMiddleName()
    				+" userInfo.getLastName():"+userInfo.getLastName()
    				+" userInfo.getPrimaryContactNumber():"+userInfo.getPrimaryContactNumber()
    				+" userInfo.getSecondryContactNumber():"+userInfo.getSecondaryContactNumber()
    				+" userInfo.getContactNumber():"+userInfo.getContactNumber()
    				+" userInfo.getEmailId():"+userInfo.getEmailId()
    				+" userInfo.getGender():"+userInfo.getGender()
    				+" userInfo.getId():"+userInfo.getId()
    				+" userInfo.getContactListId():"+userInfo.getContactListId()
    				);
    		firstName = userInfo.getFirstName();
            response.appendChild(addElementWithValue(document, "firstName", CgwebUtils.nullSafeValue(firstName)));
            response.appendChild(addElementWithValue(document, "middleName", CgwebUtils.nullSafeValue(userInfo.getMiddleName())));
            response.appendChild(addElementWithValue(document, "lastName", CgwebUtils.nullSafeValue(userInfo.getLastName())));
            response.appendChild(addElementWithValue(document, "primaryContactNumber", CgwebUtils.nullSafeValue(userInfo.getPrimaryContactNumber())));
            response.appendChild(addElementWithValue(document, "secondaryContactNumber", CgwebUtils.nullSafeValue(userInfo.getSecondaryContactNumber())));//CgwebUtils.nullSafeValue(userInfo.getSecondryContactNumber())));
            response.appendChild(addElementWithValue(document, "contactNumber", CgwebUtils.nullSafeValue(userInfo.getContactNumber())));
            response.appendChild(addElementWithValue(document, "emailId", CgwebUtils.nullSafeValue(userInfo.getEmailId())));
            response.appendChild(addElementWithValue(document, "gender", CgwebUtils.nullSafeValue(userInfo.getGender())));
            response.appendChild(addElementWithValue(document, "userId", String.valueOf(userInfo.getId())));
            response.appendChild(addElementWithValue(document, "contactListId", CgwebUtils.nullSafeValue(userInfo.getContactListId())));
    	}
    	else
    	{
    		firstName = "User Not Found";
    		response.appendChild(addElementWithValue(document, "first_name", firstName));
            response.appendChild(addElementWithValue(document, "last_name", "2"));
    	}
    	
        return response;
    }
    
    
    @PayloadRoot(localPart = "fetchAllUserDataRequest",namespace = "http://www.springwscgweb.org/types")
    @ResponsePayload
    public Element getAllUsers(@RequestPayload Element request) throws ParserConfigurationException {
    	System.out.println("hitting fetchAllUserDataRequest");
    	//TODO Create a service class to hit the dao.
    	//String text = request.getChildNodes().item(0).getNodeValue();
    	
    	String userId = request.getChildNodes().item(0).getTextContent();;//request.getAttributeNodeNS(NAMESPACE, "userId").toString();
    	System.out.println("Request Pay Load: " + request.getChildNodes().item(0).getChildNodes().item(0).getNodeValue());
    	System.out.println("Request Pay Load: " + request.getChildNodes().item(0).getTextContent());
    	//System.out.println("Request Pay Load: " + request.getChildNodes().item(1));
    	//System.out.println("Request Pay Load: " + request.getChildNodes().item(2));
    	//String password = request.getChildNodes().item(1).getTextContent();;//request.getAttributeNodeNS(NAMESPACE, "password").toString();
    	
    	System.out.println("UserEndpoint.getAllUsers() userId:"+userId);
    	//System.out.println("UserEndpoint.processOrder() password:"+password);
    	
    	List <UserInfo> allUserInfo = userService.getAllUsersInfo();
    	System.out.println("UserEndpoint.getAllUsers() allUsersInfo :"+ allUserInfo);
    	String firstName = "";
    	Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        Element response = document.createElementNS(NAMESPACE, "fetchAllUserDataResponse");
            	
    	if(allUserInfo != null && allUserInfo.size() > 0)
    	{
    		for(int i=0; i<=allUserInfo.size();i++) {
    			response.appendChild(document.createElementNS(NAMESPACE, "user"));
    			System.out.println("UserEndpoint.getAllUsers() allUsersInfo :"+allUserInfo.get(i).getFirstName()
    					+" allUsersInfo.getMiddleName():"+allUserInfo.get(i).getMiddleName()
    					+" allUsersInfo.getLastName():"+allUserInfo.get(i).getLastName()
    					+" allUsersInfo.getPrimaryContactNumber():"+allUserInfo.get(i).getPrimaryContactNumber()
    					+" allUsersInfo.getSecondryContactNumber():"+allUserInfo.get(i).getSecondaryContactNumber()
    					+" allUsersInfo.getContactNumber():"+allUserInfo.get(i).getContactNumber()
    					+" allUsersInfo.getEmailId():"+allUserInfo.get(i).getEmailId()
    					+" allUsersInfo.getGender():"+allUserInfo.get(i).getGender()
    					+" allUsersInfo.getId():"+allUserInfo.get(i).getId()
    					+" allUsersInfo.getContactListId():"+allUserInfo.get(i).getContactListId()
    					);
    			firstName = allUserInfo.get(i).getFirstName();
    			response.appendChild(addElementWithValue(document, "firstName", CgwebUtils.nullSafeValue(firstName)));
    			response.appendChild(addElementWithValue(document, "middleName", CgwebUtils.nullSafeValue(allUserInfo.get(i).getMiddleName())));
    			response.appendChild(addElementWithValue(document, "lastName", CgwebUtils.nullSafeValue(allUserInfo.get(i).getLastName())));
    			response.appendChild(addElementWithValue(document, "primaryContactNumber", CgwebUtils.nullSafeValue(allUserInfo.get(i).getPrimaryContactNumber())));
    			response.appendChild(addElementWithValue(document, "secondaryContactNumber", CgwebUtils.nullSafeValue(allUserInfo.get(i).getSecondaryContactNumber())));//CgwebUtils.nullSafeValue(allUsersInfo.getSecondryContactNumber())));
    			response.appendChild(addElementWithValue(document, "contactNumber", CgwebUtils.nullSafeValue(allUserInfo.get(i).getContactNumber())));
    			response.appendChild(addElementWithValue(document, "emailId", CgwebUtils.nullSafeValue(allUserInfo.get(i).getEmailId())));
    			response.appendChild(addElementWithValue(document, "gender", CgwebUtils.nullSafeValue(allUserInfo.get(i).getGender())));
    			response.appendChild(addElementWithValue(document, "userId", String.valueOf(allUserInfo.get(i).getId())));
    			response.appendChild(addElementWithValue(document, "contactListId", CgwebUtils.nullSafeValue(allUserInfo.get(i).getContactListId())));
    			response.appendChild(addElementWithValue(document, "designation", CgwebUtils.nullSafeValue(allUserInfo.get(i).getContactListId())));
    			response.appendChild(addElementWithValue(document, "addressLine1", CgwebUtils.nullSafeValue(allUserInfo.get(i).getContactListId())));
    			response.appendChild(addElementWithValue(document, "addressLine2", CgwebUtils.nullSafeValue(allUserInfo.get(i).getContactListId())));
    			response.appendChild(addElementWithValue(document, "city", CgwebUtils.nullSafeValue(allUserInfo.get(i).getContactListId())));
    			response.appendChild(addElementWithValue(document, "street", CgwebUtils.nullSafeValue(allUserInfo.get(i).getContactListId())));
    			response.appendChild(addElementWithValue(document, "phone", CgwebUtils.nullSafeValue(allUserInfo.get(i).getContactListId())));
    			response.appendChild(addElementWithValue(document, "fax", CgwebUtils.nullSafeValue(allUserInfo.get(i).getContactListId())));
    			response.appendChild(addElementWithValue(document, "state", CgwebUtils.nullSafeValue(allUserInfo.get(i).getContactListId())));
    			response.appendChild(addElementWithValue(document, "zip", CgwebUtils.nullSafeValue(allUserInfo.get(i).getContactListId())));
    			
    			System.out.println("response:"+response);
    		}
    		System.out.println("response:"+response);
    	}
    	else
    	{
    		firstName = "User Not Found";
    		response.appendChild(addElementWithValue(document, "first_name", firstName));
            response.appendChild(addElementWithValue(document, "last_name", "2"));
    	}
    	System.out.println("response:"+response);
        return response;
    }
    
    //public String insertUserInfo(UserInfo userInfo)
    
    @PayloadRoot(localPart = "userRegisterOrUpdateRequest",namespace = "http://www.springwscgweb.org/types")
    @ResponsePayload
    public Element registerUsers(@RequestPayload Element request) throws ParserConfigurationException {
    	System.out.println("hitting registerUsers");
    	
/*    	String[] userInfoArray = new String[]{"firstName","middleName","lastName","primaryContactNumber","secondaryContactNumber",
    			"contactNumber","emailId","gender","userId","contactListId","designation","addressLine1","addressLine2",
    			"city","street","phone","fax","state","zip"};*/
    	
    
    	String firstName = request.getChildNodes().item(0).getTextContent();
		String middleName = request.getChildNodes().item(1).getTextContent();
		String lastName = request.getChildNodes().item(2).getTextContent();
		String primaryContactNumber = request.getChildNodes().item(3).getTextContent();
		String secondaryContactNumber = request.getChildNodes().item(4).getTextContent();
		String contactNumber = request.getChildNodes().item(5).getTextContent();
		String emailId = request.getChildNodes().item(6).getTextContent();
		String gender = request.getChildNodes().item(7).getTextContent();
		String userId = request.getChildNodes().item(8).getTextContent();
		String contactListId =request.getChildNodes().item(9).getTextContent();
		String designation = request.getChildNodes().item(10).getTextContent();
		String addressLine1 = request.getChildNodes().item(11).getTextContent();
		String addressLine2 = request.getChildNodes().item(12).getTextContent();
		String city = request.getChildNodes().item(13).getTextContent();
		String street = request.getChildNodes().item(14).getTextContent();
		String phone = request.getChildNodes().item(15).getTextContent();
		String fax = request.getChildNodes().item(16).getTextContent();
		String state = request.getChildNodes().item(17).getTextContent();
		String zip = request.getChildNodes().item(18).getTextContent();
		
		Address address = new Address();
		address.setAddressLine1(addressLine1);
		address.setAddressLine2(addressLine2);
		address.setCity(city);
		address.setFax(fax);
		address.setPhone(phone);
		address.setState(state);
		address.setState(state);
		address.setStreet(street);
		address.setZip(zip);
		
		UserInfo userInfo = new UserInfo();
    	userInfo.setFirstName(firstName);
    	userInfo.setMiddleName(middleName);
    	userInfo.setLastName(lastName);
    	userInfo.setPrimaryContactNumber(primaryContactNumber);
    	userInfo.setSecondaryContactNumber(secondaryContactNumber);
    	userInfo.setContactNumber(contactNumber);
    	userInfo.setEmailId(emailId);
    	userInfo.setGender(gender);
    	userInfo.setContactListId(contactListId);
    	userInfo.setDesignation(designation);
    	userInfo.setAddress(address);
    	//userInfo.setId(userId);
    	
    	
    	String result = userService.insertUserInfo(userInfo);
    	System.out.println("UserEndpoint.registerUsers() result :"+ result);

    	Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        Element response = document.createElementNS(NAMESPACE, "userRegisterOrUpdateResponse");
            	
        if(result != null)
    	{
    		System.out.println("UserEndpoint.registerUsers() result :"+result);
    		response.appendChild(addElementWithValue(document, "message", "SUCCESS"));
            response.appendChild(addElementWithValue(document, "firstName", firstName));
    	}
    	else
    	{
    		firstName = "User Not Found";
    		response.appendChild(addElementWithValue(document, "message", "FAILED"));
            response.appendChild(addElementWithValue(document, "firstName", "firstName"));
    	}
    	System.out.println("response:"+response);
        return response;
    }
    
    @PayloadRoot(localPart = "changePasswordRequest",namespace = "http://www.springwscgweb.org/types")
    @ResponsePayload
    public Element changePassword(@RequestPayload Element request) throws ParserConfigurationException {
    	System.out.println("hitting changePasswordRequest");
    	
    	String userId = request.getChildNodes().item(0).getTextContent();
    	String newPassword = request.getChildNodes().item(1).getTextContent();
    	System.out.println("UserEndpoint.changePassword() userId:"+userId);
    	System.out.println("UserEndpoint.changePassword() newPassword:"+newPassword);
    	
    	String userName = userService.changePassword(userId, newPassword);
    	System.out.println("UserEndpoint.changePassword() userInfo :"+ userName);
    	String message = "";
    	
    	Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        Element response = document.createElementNS(NAMESPACE, "changePasswordResponse");
            	
    	if(userName != null)
    	{
            response.appendChild(addElementWithValue(document, "message", CgwebUtils.nullSafeValue(message)));
            response.appendChild(addElementWithValue(document, "firstName", CgwebUtils.nullSafeValue(userName)));
    	}
    	else
    	{
    		message = "User Not Found";
    		response.appendChild(addElementWithValue(document, "message", message));
    	}
        return response;
    }
    
    private Element addElementWithValue(Document document, String element, String value){
        System.out.println("addElementWithValue");
    	Element child = document.createElementNS(NAMESPACE, element);
        child.appendChild(document.createTextNode(value));
        return child;
    }
}

