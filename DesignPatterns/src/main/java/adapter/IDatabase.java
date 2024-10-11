package adapter;

import org.springframework.stereotype.Service;

@Service
public interface IDatabase
{
    void insert(Object o);

    void update(Object o);

    Object[] select();

    void remove();
}
