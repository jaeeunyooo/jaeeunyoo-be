package com.jaeeunyoo.infrajpa.model;

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

@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "tag")
public class TagEntity {

    @Builder
    public TagEntity(Integer tagId,
                     String label) {
        this.tagId = tagId;
        this.label = label;
    }

    @Id
    @Column(name = "tag_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tagId;

    @Column(name = "label", nullable = false)
    private String label;
}