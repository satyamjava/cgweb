package com.cgweb.endpoint;

import java.io.StringReader;

import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.springframework.ws.client.core.WebServiceTemplate;

public class Client {



//sample request XML
    private static String MESSAGE =
        "<loginRequest" +
        " xmlns=" +
        "\"http://www.springwscgweb.org/types\"><userId>Flowers</userId><password>700</password></loginRequest>";

    public static void main(String[] args){
        StreamSource source = new StreamSource(new StringReader(MESSAGE));
        StreamResult result = new StreamResult(System.out);
        System.out.println("source"+source+"\nAfter source and result	"+result);
//WebServiceTemplate provides the functionality for sending and receiving webservice messages. 
        WebServiceTemplate webServiceTemplate = new WebServiceTemplate();
        webServiceTemplate.sendSourceAndReceiveToResult("http://localhost:8080/cgweb/cgwebservices",
                source, result);

    }
}


