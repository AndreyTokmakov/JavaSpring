/****************************************************************************
* Copyright 2021 (C) Andrey Tokmakov
* ProxyController.java class
*
* @name    : ProxyController.java
* @author  : Tokmakov Andrey
* @version : 1.0
* @since   : Jan 29, 2021
****************************************************************************/

package experimental_service.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/proxy")
public class ProxyController {
	
	public ProxyController() {
		log.info(this.getClass().getSimpleName() + " created!");
	}
	
    @GetMapping("/test")
    public ResponseEntity<String> handleTestPath() throws ClientProtocolException, IOException {
    	final String externalResponse = getRequest("some_external_web_service");
    	return ResponseEntity.status(200)
    	        .header("Custom-Header", "foo")
    	        .body(externalResponse);
    }
    
    @GetMapping(value = "/ext/{ext_path}")
    public ResponseEntity<String> handleTestPathEx(@PathVariable  String ext_path) throws ClientProtocolException, IOException {
    	final String externalResponse = getRequest(ext_path);
    	return ResponseEntity.status(200)
    	        .header("Custom-Header", "foo")
    	        .body(externalResponse);
    }

    private String getRequest(String path) throws ClientProtocolException, IOException 
    {
    	HttpGet request = new HttpGet("http://127.0.0.1:52525/" + path);
        request.addHeader("custom-key", "some_Value");
        request.addHeader(HttpHeaders.USER_AGENT, "TestJavaClient");
        request.addHeader(HttpHeaders.CONNECTION, "close");
        
        String responseStr = "";
        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(request)) {
        	
        	// Get HttpResponse Status
        	// System.out.println(response.getStatusLine().toString());        // HTTP/1.1 200 OK
        	
        	responseStr = convertResponseToString(response); 
        	
        	/*
        	HttpEntity entity = response.getEntity();
        	if (null != entity) {
        		System.out.println(EntityUtils.toString(entity));
            }
            */
        }
        return responseStr;
    }
    
    private String convertResponseToString(HttpResponse response) {
		try {
			InputStream responseStream = response.getEntity().getContent();
			Scanner scanner = new Scanner(responseStream, StandardCharsets.UTF_8);
			String responseString = scanner.useDelimiter("\\Z").next();
			scanner.close();
			return responseString;
		} 
		catch (final UnsupportedOperationException | IOException exc) {
			exc.printStackTrace();
		}
		return "";
	}
}
