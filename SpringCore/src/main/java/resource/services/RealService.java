package resource.services;

import org.springframework.stereotype.Component;

@Component(value="real")
public class RealService implements IService
{
    @Override
    public String getInfo() {
        return this.getClass().getSimpleName();
    }
}
