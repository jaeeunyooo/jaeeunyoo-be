package com.jaeeunyoo.common.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;

@Getter
@RequiredArgsConstructor
public class CommonApiResponse<T> {

    private final T data;
    private final Boolean successful;
    private final String errorMessage;

    public static <T> CommonApiResponse<T> success(T data) {
        return new CommonApiResponse<> (data, true, StringUtils.EMPTY);
    }

    public static <T> CommonApiResponse<T> error(String errorMessage) {
        return new CommonApiResponse<>(null, false, errorMessage);
    }
}
