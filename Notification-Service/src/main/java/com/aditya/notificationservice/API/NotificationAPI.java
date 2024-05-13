package com.aditya.notificationservice.API;

import com.aditya.notificationservice.dto.VisitTrackerDTO;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeoutException;

@RestController
@Slf4j
@RequestMapping("/notify")
public class NotificationAPI {


    @PostMapping("/tracking")
    @CircuitBreaker(name = "notification", fallbackMethod = "fallbackMethod")
    @TimeLimiter(name = "notification")
//    @Retry(name = "notification")
    public CompletableFuture<String> getTrackingRecord(@RequestBody VisitTrackerDTO  visitTrackerDTO) {

        return CompletableFuture.supplyAsync(() -> {
            log.info(visitTrackerDTO.toString());
            try {
                Thread.sleep(10000);
                // int a  = 0/0; // Uncomment this line to simulate an exception
            } catch (InterruptedException e) {
                log.error("InterruptedException occurred: {}", e.getMessage());
                throw new RuntimeException(e);
            } catch (Exception e) {
                log.error("Exception occurred: {}", e.getMessage());
                throw new RuntimeException(e);
            }
            return "Received the Object.";
        });
    }

    public CompletableFuture<String> fallbackMethod(VisitTrackerDTO visitTrackerDTO, Exception ex){
        return CompletableFuture.supplyAsync(() -> {
            if (ex instanceof TimeoutException )
                return "There is some issue with the service taking longer time";
            return "Oops something went wrong with the backend service";
        });

    }
}
