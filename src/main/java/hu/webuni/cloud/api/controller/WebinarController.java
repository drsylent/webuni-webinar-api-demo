package hu.webuni.cloud.api.controller;

import hu.webuni.cloud.api.dto.WebinarRequest;
import hu.webuni.cloud.api.dto.WebinarResponse;
import hu.webuni.cloud.service.WebinarService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/webinar")
public class WebinarController {

    private final WebinarService service;

    public WebinarController(WebinarService service) {
        this.service = service;
    }

    @PostMapping(value = "/message",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public WebinarResponse webinar(@RequestBody WebinarRequest request) {
        int result = service.calculate(request.leftNumber(), request.rightNumber());
        service.createNewMessage(request.message());
        List<String> recentMessages = service.retrieveRecentMessages();
        return new WebinarResponse(recentMessages, result);
    }
}
