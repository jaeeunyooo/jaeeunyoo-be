package com.jaeeunyoo.infrastructure.repository.querydsl;

import com.jaeeunyoo.infrastructure.model.MemberEntity;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import static com.jaeeunyoo.infrastructure.model.QMemberEntity.memberEntity;

@Repository
@RequiredArgsConstructor
public class MemberEntityCustomRepositoryImpl implements MemberEntityCustomRepository {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public MemberEntity findByGithubUserId(Long githubUserId) {
        return jpaQueryFactory.select(memberEntity)
            .from(memberEntity)
            .where(memberEntity.githubUserId.eq(githubUserId),
                   memberEntity.deletedAt.isNull())
            .fetchOne();
    }

    @Override
    public Boolean existsByEmailUserId(String email) {
        return jpaQueryFactory.select(memberEntity)
            .from(memberEntity)
            .where(memberEntity.email.eq(email))
            .fetchFirst() != null;
    }
}
