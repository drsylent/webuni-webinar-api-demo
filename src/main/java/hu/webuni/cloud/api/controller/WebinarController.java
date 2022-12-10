package hu.webuni.cloud.api.controller;

import hu.webuni.cloud.api.dto.WebinarRequest;
import hu.webuni.cloud.api.dto.WebinarResponse;
import hu.webuni.cloud.service.WebinarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/webinar")
public class WebinarController {

    private static final Logger log = LoggerFactory.getLogger(WebinarController.class);

    private final WebinarService service;

    public WebinarController(WebinarService service) {
        this.service = service;
    }

    @PostMapping(value = "/message",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public WebinarResponse webinar(@RequestBody WebinarRequest request) {
        log.info("Request arrived on /webinar endpoint with message: {}, leftNumber: {}, rightNumber: {}",
                request.message(), request.leftNumber(), request.rightNumber());
        int result = service.calculate(request.leftNumber(), request.rightNumber());
        service.createNewMessage(request.message());
        List<String> recentMessages = service.retrieveRecentMessages();
        log.info("Sending back response on /webinar endpoint with data: number of recentMessages {}, result: {}",
                recentMessages.size(), result);
        return new WebinarResponse(recentMessages, result);
    }
}
