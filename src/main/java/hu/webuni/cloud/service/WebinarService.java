package hu.webuni.cloud.service;

import hu.webuni.cloud.call.api.MessageApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WebinarService {

    private static final Logger log = LoggerFactory.getLogger(WebinarService.class);

    private final MessageApi api;

    public WebinarService(MessageApi api) {
        this.api = api;
    }

    public int calculate(int leftNumber, int rightNumber) {
        log.info("Calculating: {} + {}", leftNumber, rightNumber);
        return leftNumber + rightNumber;
    }

    public void createNewMessage(String message) {
        log.info("Creating new message on API: {}", message);
        api.newMessageArrived(message);
    }

    public List<String> retrieveRecentMessages() {
        log.info("Retrieving recent messages from API");
        return api.getRecentMessages();
    }
}
