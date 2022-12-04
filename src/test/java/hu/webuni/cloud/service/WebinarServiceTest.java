package hu.webuni.cloud.service;

import hu.webuni.cloud.call.api.MessageApi;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WebinarServiceTest {

    private static final MessageApi api = Mockito.mock(MessageApi.class);
    private static final WebinarService service = new WebinarService(api);

    @Test
    void calculate() {
        int result = service.calculate(1, 1);

        MatcherAssert.assertThat(result, Matchers.is(2));
    }

    @Test
    void createNewMessage() {
        String message = "message";

        service.createNewMessage(message);

        Mockito.verify(api, Mockito.atLeastOnce()).newMessageArrived(message);
    }

    @Test
    void retrieveRecentMessages() {
        String message = "message";
        Mockito.when(api.getRecentMessages()).thenReturn(Collections.singletonList(message));

        List<String> result = service.retrieveRecentMessages();

        MatcherAssert.assertThat(result, Matchers.contains(message));
    }
}