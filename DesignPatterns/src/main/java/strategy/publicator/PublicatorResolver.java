package strategy.publicator;

import org.springframework.stereotype.Service;
import strategy.model.PublicatorType;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


@Service
public class PublicatorResolver {

    private final Map<PublicatorType, IPublicator> strategyMap = new HashMap<>();

    public PublicatorResolver(Set<IPublicator> publicators) {
        publicators.forEach(publicator -> strategyMap.put(publicator.getType(), publicator));
    }

    public IPublicator getPublicator(PublicatorType type) {
        return strategyMap.get(type);
    }
}
