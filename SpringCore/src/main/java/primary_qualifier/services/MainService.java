package primary_qualifier.services;

import lombok.extern.log4j.Log4j2;
import primary_qualifier.IService;

@Log4j2
public class MainService implements IService
{
    public MainService() {
        log.info("{} created!", this.getClass().getSimpleName());
    }

    @Override
    public String invoke() {
        return "Main-Result";
    }
}