package com.jaeeunyoo.infrajpa.repository.querydsl;

import com.jaeeunyoo.infrajpa.model.PostEntity;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.jaeeunyoo.infrajpa.model.QPostEntity.postEntity;

@Repository
@RequiredArgsConstructor
public class PostEntityCustomRepositoryImpl implements PostEntityCustomRepository {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public PageImpl<PostEntity> getAllByPageable(Integer blogId, Pageable pageable) {
        long count = jpaQueryFactory.select(postEntity.postId)
            .from(postEntity)
            .where(postEntity.deletedAt.isNull(),
                   postEntity.published.eq(true),
                   postEntity.blogId.eq(blogId))
            .fetch()
            .size();

        List<PostEntity> postEntities = jpaQueryFactory.select(postEntity)
            .from(postEntity)
            .where(postEntity.deletedAt.isNull(),
                   postEntity.published.eq(true),
                   postEntity.blogId.eq(blogId))
            .offset(pageable.getOffset())
            .limit(pageable.getPageSize())
            .fetch();

        return new PageImpl<>(postEntities, pageable, count);
    }
}
