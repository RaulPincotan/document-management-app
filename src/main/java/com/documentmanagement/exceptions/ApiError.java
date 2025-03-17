package com.documentmanagement.exceptions;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record ApiError(String message, LocalDateTime time, int errorCode) {
}
