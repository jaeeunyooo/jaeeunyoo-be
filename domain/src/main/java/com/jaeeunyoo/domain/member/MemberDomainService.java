package com.jaeeunyoo.domain.member;

import com.jaeeunyoo.infrastructure.model.MemberEntity;
import com.jaeeunyoo.infrastructure.repository.MemberEntityRepository;
import com.jaeeunyoo.domain.member.entity.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
@RequiredArgsConstructor
public class MemberDomainService {

    private final MemberEntityRepository memberEntityRepository;

    public Member getMemberByGithubUserId(Long githubUserId) {
        MemberEntity memberEntity = memberEntityRepository.findByGithubUserId(githubUserId);
        return memberEntity == null ? null : Member.of(memberEntity);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public Member createMember(Member member) {
        MemberEntity memberEntity = MemberEntity.builder()
            .memberId(null)
            .memberType(member.getMemberType())
            .email(member.getEmail())
            .name(member.getName())
            .introduction(member.getIntroduction())
            .githubUserId(member.getGithubUserId())
            .createdAt(member.getCreatedAt())
            .updatedAt(member.getUpdatedAt())
            .deletedAt(member.getDeletedAt())
            .build();
        memberEntity = memberEntityRepository.save(memberEntity);
        return Member.of(memberEntity);
    }

    public Boolean isJoinedUserBy(String email) {
        return memberEntityRepository.existsByEmailUserId(email);
    }
}
