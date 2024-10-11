package adapter;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class JavaApplication
{
    public void saveObject(Object o)
    {
        log.info("Saving java object...");
    }

    public void updateObject(Object o)
    {
        log.info("Updating java object...");
    }

    public Object[] loadObjects()
    {
        log.info("Loading java objects...");
        return new Object[0];
    }

    public void removeObject()
    {
        log.info("Removing java object...");
    }
}
