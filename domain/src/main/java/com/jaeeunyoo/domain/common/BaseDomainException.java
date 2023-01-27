package com.jaeeunyoo.domain.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BaseDomainException extends RuntimeException {

    private final String errorMessage;
}
