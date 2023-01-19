package com.jaeeunyoo.infrajpa.model;

import lombok.AccessLevel;
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
@Table(name = "blog")
public class BlogEntity {

    @Id
    @Column(name = "blog_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer blogId;

    @Column(name = "member_id", nullable = false)
    private Integer memberId;

    @Column(name = "path", nullable = false, unique = true)
    private String path;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "instagram_link")
    private String instagramLink;

    @Column(name = "facebook_link")
    private String facebookLink;

    @Column(name = "twitter_link")
    private String twitterLink;

    @Column(name = "github_link")
    private String githubLink;

    @Column(name = "dockerhub_link")
    private String dockerhubLink;

    @Column(name = "markdown_about", nullable = false)
    private String markdownAbout;

    @Column(name = "html_about", nullable = false)
    private String htmlAbout;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;
}