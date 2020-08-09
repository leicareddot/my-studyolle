package com.atoz_develop.mystudyolle.account;

import com.atoz_develop.mystudyolle.domain.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class AccountController {

    private final AccountSignUpValidator accountSignUpValidator;

    // accountSignUpDto를 받을 때 바인더 설정
    // 설정값("accountSignUpDto")은 타입과 매핑됨(변수명X)
    @InitBinder("accountSignUpDto")
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(accountSignUpValidator);
    }

    @PostMapping("/sign-up")
    public ResponseEntity signUp(@Valid @RequestBody AccountSignUpDto accountSignUpDto,
                                 Errors errors) {

        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }

        Account account = Account.builder()
                .email(accountSignUpDto.getEmail())
                .nickName(accountSignUpDto.getNickName())
                .password(accountSignUpDto.getPassword())
                .build();

        return ResponseEntity.ok(account);
    }
}
