package kz.singularity.bankapp.features.accounts.presentation.controller;

import kz.singularity.bankapp.features.accounts.domain.errors.AccountNotFound;
import kz.singularity.bankapp.features.accounts.domain.errors.WithdrawNotAllowed;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class WithdrawNotAllowedAdvice {
    @ResponseBody //сигнализирует, что нужно вернуть результат функции.
    @ExceptionHandler(WithdrawNotAllowed.class) //настраивает рекомендацию так, чтобы она реагировала только в случае возникновения исключения StudentNotFound.
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)  //устанавливает HTTP статус для ответа, то есть HTTP 404.
    String withdrawNotAllowed(WithdrawNotAllowed ex) {
        return ex.getMessage();
    }
}
