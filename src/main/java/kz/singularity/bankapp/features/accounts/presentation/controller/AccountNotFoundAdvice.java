package kz.singularity.bankapp.features.accounts.presentation.controller;

import kz.singularity.bankapp.features.accounts.domain.errors.AccountNotFound;
import kz.singularity.bankapp.features.students.domain.errors.StudentNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class AccountNotFoundAdvice {
    @ResponseBody //сигнализирует, что нужно вернуть результат функции.
    @ExceptionHandler(AccountNotFound.class) //настраивает рекомендацию так, чтобы она реагировала только в случае возникновения исключения StudentNotFound.
    @ResponseStatus(HttpStatus.NOT_FOUND)  //устанавливает HTTP статус для ответа, то есть HTTP 404.
    String accountNotFound(AccountNotFound ex) {
        return ex.getMessage();
    }
}
