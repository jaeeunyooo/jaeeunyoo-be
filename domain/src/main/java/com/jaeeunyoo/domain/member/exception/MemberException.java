package com.jaeeunyoo.domain.member.exception;
import com.jaeeunyoo.domain.common.BaseDomainException;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class MemberException extends BaseDomainException {

    private final HttpStatus httpStatus;
    public MemberException(HttpStatus httpStatus, String errorMessage) {
        super(errorMessage);
        this.httpStatus = httpStatus;
    }
}
