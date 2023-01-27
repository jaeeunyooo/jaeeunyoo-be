package com.jaeeunyoo.domain.blog;

import com.jaeeunyoo.domain.blog.entity.Post;
import com.jaeeunyoo.infrastructure.model.PostEntity;
import com.jaeeunyoo.infrastructure.repository.PostEntityRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class BlogDomainService {

    private final PostEntityRepository postEntityRepository;

    public Page<Post> getPostPage(Integer blogId, Pageable pageable) {
        Page<PostEntity> postEntityPage = postEntityRepository.findAllByPageable(blogId, pageable);
        return new PageImpl<>(Post.of(postEntityPage.getContent()),
                              pageable,
                              postEntityPage.getTotalElements());
    }
}
