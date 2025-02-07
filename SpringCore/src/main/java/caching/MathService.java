package caching;

import lombok.extern.log4j.Log4j2;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.util.concurrent.atomic.AtomicInteger;

@Log4j2
@Service
// @CacheConfig(cacheNames = "square")
public class MathService
{
    private final AtomicInteger counter = new AtomicInteger();

    public MathService() {
        log.info("{} created!", this.getClass().getSimpleName());
    }

    @CacheEvict(allEntries = true)
    public AtomicInteger resetCounter() {
        counter.set(0);
        return counter;
    }

    @Cacheable(cacheNames="square", key="#value")
    public int square(int value) {
        System.out.println(value + " * " +  value + " = " + value * value);
        counter.incrementAndGet();
        return value * value;
    }

    public int sumOfSquareOf2() {
        return this.square(2) + this.square(2);
    }
}