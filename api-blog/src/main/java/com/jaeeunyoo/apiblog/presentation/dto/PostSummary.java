package com.jaeeunyoo.apiblog.presentation.dto;

import com.jaeeunyoo.domain.blog.entity.Post;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostSummary {

    private Integer postId;
    private String title;
    private Boolean pinned;
    private LocalDateTime createdAt;
    private String categoryInfo;
    private String shortDescription;

    public static PostSummary of(Post post) {
        PostSummary postSummary = new PostSummary();
        postSummary.postId = post.getPostId();
        postSummary.title = post.getTitle();
        postSummary.pinned = true;
        postSummary.createdAt = post.getCreatedAt();
        postSummary.categoryInfo = "카테고리 > 카테고리";
        postSummary.shortDescription = post.getHtmlContent();
        return postSummary;
    }
}