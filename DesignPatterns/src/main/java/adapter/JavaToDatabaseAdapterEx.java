package adapter;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class JavaToDatabaseAdapterEx extends JavaApplication implements IDatabase
{
    @Override
    public void insert(Object o) {
        log.info("JavaToDatabaseAdapterEx::insert()");
        saveObject(o);
    }

    @Override
    public void update(Object o) {
        log.info("JavaToDatabaseAdapterEx::update()");
        updateObject(o);
    }

    @Override
    public Object[] select() {
        log.info("JavaToDatabaseAdapterEx::select()");
        return loadObjects();
    }

    @Override
    public void remove() {
        log.info("JavaToDatabaseAdapterEx::remove()");
        removeObject();
    }
}
