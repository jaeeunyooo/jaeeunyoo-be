package com.jaeeunyoo.domain.member.entity;

import com.jaeeunyoo.common.constant.MemberType;
import com.jaeeunyoo.infrastructure.model.MemberEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class Member {

    private static final Member EMPTY = new Member();

    private Integer memberId;
    private String email;
    private String name;
    private String nickname;
    private String introduction;
    private MemberType memberType;
    private Long githubUserId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

    @Builder
    public Member(Integer memberId,
                  String email,
                  String name,
                  String nickname,
                  String introduction,
                  MemberType memberType,
                  Long githubUserId,
                  LocalDateTime createdAt,
                  LocalDateTime updatedAt,
                  LocalDateTime deletedAt) {
        this.memberId = memberId;
        this.email = email;
        this.name = name;
        this.nickname = nickname;
        this.introduction = introduction;
        this.memberType = memberType;
        this.githubUserId = githubUserId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
    }

    public static Member of(MemberEntity memberEntity) {
        Member member = new Member();
        member.memberId = memberEntity.getMemberId();
        member.email = memberEntity.getEmail();
        member.nickname = memberEntity.getNickname();
        member.introduction = memberEntity.getIntroduction();
        member.memberType = memberEntity.getMemberType();
        member.githubUserId = memberEntity.getGithubUserId();
        member.createdAt = memberEntity.getCreatedAt();
        member.updatedAt = memberEntity.getUpdatedAt();
        member.deletedAt = memberEntity.getDeletedAt();
        return member;
    }

    public static Member empty() {
        return EMPTY;
    }
}
