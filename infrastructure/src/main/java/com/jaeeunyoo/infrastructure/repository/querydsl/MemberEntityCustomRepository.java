package com.jaeeunyoo.infrastructure.repository.querydsl;

import com.jaeeunyoo.infrastructure.model.MemberEntity;

public interface MemberEntityCustomRepository {

    MemberEntity findByGithubUserId(Long githubUserId);

    Boolean existsByEmailUserId(String email);
}
