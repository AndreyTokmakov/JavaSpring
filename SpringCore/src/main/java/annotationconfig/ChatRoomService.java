package annotationconfig;

import org.springframework.stereotype.Component;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Component
public class ChatRoomService {
	
	private static final Logger logger = LogManager.getLogger(ChatRoomService.class);
	  
	public ChatRoomService() {
		logger.info(this.getClass().getName() + " created");
	}

    public void start() {
        System.out.println("Starting chat room");
    }
}
