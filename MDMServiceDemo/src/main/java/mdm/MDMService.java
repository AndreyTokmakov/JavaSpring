package mdm;


import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class MDMService {

    private int counter = 0;

    public MDMService() {
        log.info("* * * * " + this.getClass().getName() + " created! * * * * ");
    }

    public int getCounter()
    {
        counter++;
        return counter;
    }
}
