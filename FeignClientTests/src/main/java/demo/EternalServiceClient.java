package demo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "test-service",
             url = "https://some-test-server.com/api")
public interface EternalServiceClient
{
    @GetMapping(value = "/posts/{postId}", produces = "application/json")
    public String getInfo(@PathVariable("postId") Long postId);
}