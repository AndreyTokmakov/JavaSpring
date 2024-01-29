/****************************************************************************
* Copyright 2021 (C) Andrey Tokmakov
* MessagesContoller.java class
*
* @name    : MessagesContoller.java
* @author  : Tokmakov Andrey
* @version : 1.0
* @since   : Jan 16, 2021
****************************************************************************/

/**
 * 
 */
package mapping.comonent_scan.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
public class MessagesContoller {
	
	public MessagesContoller() {
		log.info(this.getClass().getSimpleName() + " created!");
	}
	
    @GetMapping("/messages")
    public String handleMessages() {
    	log.info("handleMessagesByID() called. Id: ");
    	return "<body bgcolor='gray'>Messages page</body>";
        // CALL: http://localhost:8080/messages
    }
	
    @GetMapping("/messages/ids")
    public String handleMessagesByID(@RequestParam(value = "id") final int id) {
    	log.info("handleMessagesByID() called. Id: " + id);
    	return "<body bgcolor='gray'>Message {" + id + "}</body>";
        // CALL: http://localhost:8080/messages/ids?id=123
    }
}
