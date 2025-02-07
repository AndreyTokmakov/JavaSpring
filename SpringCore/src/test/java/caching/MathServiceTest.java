package caching;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import profiles.Application;

import javax.annotation.Resource;
import java.util.concurrent.atomic.AtomicInteger;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(classes = Application.class)
public class MathServiceTest
{
    @Resource
    private MathService mathService;

    @Test
    void givenCacheableMethod_whenInvokingByInternalCall_thenCacheIsNotTriggered() {
        AtomicInteger counter = mathService.resetCounter();

        assertThat(mathService.sumOfSquareOf2()).isEqualTo(8);
        assertThat(counter.get()).isEqualTo(2);
    }
}