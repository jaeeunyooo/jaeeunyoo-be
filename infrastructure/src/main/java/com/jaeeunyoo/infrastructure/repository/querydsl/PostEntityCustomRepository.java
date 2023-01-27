package com.jaeeunyoo.infrastructure.repository.querydsl;

import com.jaeeunyoo.infrastructure.model.PostEntity;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

public interface PostEntityCustomRepository {

    PageImpl<PostEntity> findAllByPageable(Integer memberId, Pageable pageable);
}
