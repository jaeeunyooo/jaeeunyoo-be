package com.jaeeunyoo.domain.blog.entity;

import com.jaeeunyoo.infrastructure.model.PostEntity;
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
    private Integer blogId;
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
        post.blogId = postEntity.getBlogId();
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
