package resource.services;

import org.springframework.stereotype.Component;

@Component(value="mock")
public class MockService implements IService
{
    @Override
    public String getInfo() {
        return this.getClass().getSimpleName();
    }
}
