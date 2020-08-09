package com.atoz_develop.mystudyolle.account;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor
public class AccountSignUpValidator implements Validator {

    // @RequiredArgsConstructor로 생성자를 통한 주입이 되므로 @Autowired 안붙여도 됨
    private final AccountMapper accountMapper;

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.isAssignableFrom(AccountSignUpDto.class);
    }

    @Override
    public void validate(Object o, Errors errors) {

        AccountSignUpDto accountSignUpDto = (AccountSignUpDto) o;
        if (accountMapper.existsByEmail(accountSignUpDto.getEmail())) {
            errors.rejectValue("email",
                    "invalid.email",
                    new Object[]{accountSignUpDto.getEmail()},
                    "이미 사용중인 이메일입니다.");
        }

        if (accountMapper.existsByNickName(accountSignUpDto.getNickName())) {
            errors.rejectValue("nickName",
                    "invalid.nick-name",
                    new Object[]{accountSignUpDto.getNickName()},
                    "이미 사용중인 닉네임입니다.");
        }
    }
}
