package com.jaeeunyoo.infrastructure.model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
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
                      Integer blogId,
                      Integer categoryId,
                      String title,
                      String markdownContent,
                      String htmlContent,
                      Boolean published,
                      LocalDateTime createdAt,
                      LocalDateTime updatedAt,
                      LocalDateTime deletedAt) {
        this.postId = postId;
        this.blogId = blogId;
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

    @Column(name = "blog_id", nullable = false)
    private Integer blogId;

    @Column(name = "category_id")
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