package hu.webuni.cloud.service;

import hu.webuni.cloud.call.api.MessageApi;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WebinarService {

    private final MessageApi api;

    public WebinarService(MessageApi api) {
        this.api = api;
    }

    public int calculate(int leftNumber, int rightNumber) {
        return leftNumber + rightNumber;
    }

    public void createNewMessage(String message) {
        api.newMessageArrived(message);
    }

    public List<String> retrieveRecentMessages() {
        return api.getRecentMessages();
    }
}
