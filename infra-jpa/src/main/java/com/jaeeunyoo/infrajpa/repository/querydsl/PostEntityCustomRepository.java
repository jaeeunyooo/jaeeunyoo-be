package com.jaeeunyoo.infrajpa.repository.querydsl;

import com.jaeeunyoo.infrajpa.model.PostEntity;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

public interface PostEntityCustomRepository {

    PageImpl<PostEntity> getAllByPageable(Integer memberId, Pageable pageable);
}
