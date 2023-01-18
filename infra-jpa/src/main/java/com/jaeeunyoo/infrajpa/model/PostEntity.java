package com.jaeeunyoo.infrajpa.model;

import com.jaeeunyoo.common.constants.PostType;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "post")
public class PostEntity {

    @Builder
    public PostEntity(Integer postId,
                      Integer memberId,
                      PostType postType,
                      Integer categoryId,
                      String title,
                      String markdownContent,
                      String htmlContent,
                      Boolean published,
                      LocalDateTime createdAt,
                      LocalDateTime updatedAt,
                      LocalDateTime deletedAt) {
        this.postId = postId;
        this.memberId = memberId;
        this.postType = postType;
        this.categoryId = categoryId;
        this.title = title;
        this.markdownContent = markdownContent;
        this.htmlContent = htmlContent;
        this.published = published;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
    }

    @Id
    @Column(name = "post_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postId;

    @Column(name = "member_id", nullable = false)
    private Integer memberId;

    @Column(name = "post_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private PostType postType;

    @Column(name = "category_id", nullable = false)
    private Integer categoryId;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "markdown_content", nullable = false)
    private String markdownContent;

    @Column(name = "html_content", nullable = false)
    private String htmlContent;

    @Column(name = "published", nullable = false)
    private Boolean published;

    @Column(name = "createdAt", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updatedAt")
    private LocalDateTime updatedAt;

    @Column(name = "deletedAt")
    private LocalDateTime deletedAt;
}