package sprint_clound_config_service;

import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

@Log4j2
@Getter
@Service
@RefreshScope
public class TestService
{
    @Value("${test.value}")
    private String value;

    public TestService() {
        log.info("{} created. Value = {}", getClass().getSimpleName(), value);
    }

    public String getValueWithDelay()
    {
        System.out.println("PublicController::test1() | Value = " + value);
        return value;
    }
}
