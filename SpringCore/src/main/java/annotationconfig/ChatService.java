package annotationconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Component
public class ChatService {

    private final HistoryService historyService;

    private final ChatRoomService chatRoomService;
    
	private static final Logger logger = LogManager.getLogger(ChatService.class);
	  

    @Autowired
    public ChatService(HistoryService historyService, ChatRoomService chatRoomService) {
        this.historyService = historyService;
        this.chatRoomService = chatRoomService;
        logger.info(this.getClass().getName() + " created");
    }

    public void chat() {
        chatRoomService.start();
        historyService.store();
    }
}
