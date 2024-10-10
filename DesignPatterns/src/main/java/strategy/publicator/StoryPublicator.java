package strategy.publicator;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import strategy.model.PublicatorType;

@Log4j2
@Service
public class StoryPublicator implements IPublicator {

    @Override
    public void publish() {
        log.info("{}Publishing a STORY", this.getClass().getSimpleName());
    }

    @Override
    public PublicatorType getType() {
        return PublicatorType.STORY;
    }
}
