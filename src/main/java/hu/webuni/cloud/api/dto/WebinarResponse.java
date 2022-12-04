package hu.webuni.cloud.api.dto;

import java.util.List;

public record WebinarResponse(List<String> messages, int result) {
}
