package com.jaeeunyoo.infrajpa.repository.querydsl;

import com.jaeeunyoo.common.constants.PostType;
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
    public PageImpl<PostEntity> getAllByPageable(Integer memberId, Pageable pageable) {
        long count = jpaQueryFactory.select(postEntity.postId)
            .from(postEntity)
            .where(postEntity.deletedAt.isNull(),
                   postEntity.published.eq(true),
                   postEntity.postType.eq(PostType.BLOG_CONTENT),
                   postEntity.memberId.eq(memberId))
            .fetch()
            .size();

        List<PostEntity> postEntities = jpaQueryFactory.select(postEntity)
            .from(postEntity)
            .where(postEntity.deletedAt.isNull(),
                   postEntity.published.eq(true),
                   postEntity.postType.eq(PostType.BLOG_CONTENT),
                   postEntity.memberId.eq(memberId))
            .offset(pageable.getOffset())
            .limit(pageable.getPageSize())
            .fetch();

        return new PageImpl<>(postEntities, pageable, count);
    }
}
