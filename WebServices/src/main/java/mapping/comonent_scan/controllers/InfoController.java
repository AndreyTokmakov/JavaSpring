/****************************************************************************
* Copyright 2021 (C) Andrey Tokmakov
* InfoController.java class
*
* @name    : InfoController.java
* @author  : Tokmakov Andrey
* @version : 1.0
* @since   : Jan 16, 2021
****************************************************************************/

package mapping.comonent_scan.controllers;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
public class InfoController {
	
	public InfoController() {
		log.info(this.getClass().getSimpleName() + " created!");
	}
	
    @GetMapping("/info")
    public String handleInfo() {
    	log.info("handleMessagesByID() called. Id: ");
    	return "<body bgcolor='gray'>Info page</body>";
        // CALL: http://localhost:8080/info
    }
	
    @GetMapping("/info/ids")
    public String handleInfoByID(@RequestParam(value = "id") final int id) {
    	log.info("handleInfoByID() called. Id: " + id);
    	return "<body bgcolor='gray'>Info {" + id + "}</body>";
        // CALL: http://localhost:8080/info/ids?id=123
    }
    
    @GetMapping("/info/dates")
    public String handleDates(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
					          @RequestParam("start") LocalDate start,
					          @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
					          @RequestParam("end") LocalDate end) {
    	log.info("handleDates(): [" +  start + " - " + end + "]");
    	return "<body bgcolor='gray'>Info [" +  start + " - " + end + "]</body>";
        // CALL: http://localhost:8080/info/dates?start=2000-10-31&end=2000-10-31
    }
 
    @GetMapping("/custom_error_503")
    public ResponseEntity<String> customHeader() {
    	/*
    	HttpHeaders headers = new HttpHeaders();
    	headers.add("Custom-Header", "foo");
    	
        return new ResponseEntity<String>("Some paylaod", HttpStatus.OK);
        */
    	
    	return ResponseEntity.status(503)
    	        .header("Custom-Header", "foo")
    	        .body("Custom header set");
    }
    
    
}
