package com.atoz_develop.mystudyolle.account;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.transaction.annotation.Transactional;

@Mapper
@Transactional
public interface AccountMapper {

    boolean existsByEmail(String email);
    boolean existsByNickName(String nickName);
}
