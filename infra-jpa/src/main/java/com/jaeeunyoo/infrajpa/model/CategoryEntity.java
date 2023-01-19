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
@Table(name = "category")
public class CategoryEntity {

    public CategoryEntity(Integer categoryId,
                          Integer parentCategoryId,
                          String label,
                          Integer blogId,
                          LocalDateTime createdAt,
                          LocalDateTime updatedAt,
                          LocalDateTime deletedAt) {
        this.categoryId = categoryId;
        this.parentCategoryId = parentCategoryId;
        this.label = label;
        this.blogId = blogId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
    }

    @Id
    @Column(name = "category_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;

    @Column(name = "parent_category_id")
    private Integer parentCategoryId;

    @Column(name = "label")
    private String label;

    @Column(name = "blog_id")
    private Integer blogId;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;
}