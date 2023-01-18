package com.jaeeunyoo.apiblog.domain.post.entity;

import com.jaeeunyoo.common.constants.PostType;
import com.jaeeunyoo.infrajpa.model.PostEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class Post {

    private Integer postId;
    private Integer memberId;
    private PostType postType;
    private Integer categoryId;
    private String title;
    private String markdownContent;
    private String htmlContent;
    private Boolean published;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

    public static Post of(PostEntity postEntity) {
        Post post = new Post();
        post.postId = postEntity.getPostId();
        post.memberId = postEntity.getMemberId();
        post.postType = postEntity.getPostType();
        post.categoryId = postEntity.getCategoryId();
        post.title = postEntity.getTitle();
        post.markdownContent = postEntity.getMarkdownContent();
        post.htmlContent = postEntity.getHtmlContent();
        post.published = postEntity.getPublished();
        post.createdAt = postEntity.getCreatedAt();
        post.updatedAt = postEntity.getUpdatedAt();
        post.deletedAt = postEntity.getDeletedAt();
        return post;
    }

    public static List<Post> of(Collection<PostEntity> postEntities) {
        return postEntities.stream().map(Post::of).collect(Collectors.toList());
    }
}
