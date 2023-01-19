package com.jaeeunyoo.apiblog.domain.post;

import com.jaeeunyoo.apiblog.domain.post.entity.Post;
import com.jaeeunyoo.infrajpa.model.PostEntity;
import com.jaeeunyoo.infrajpa.repository.PostEntityRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class PostDomainService {

    private final PostEntityRepository postEntityRepository;

    public Page<Post> getPostPage(Integer blogId, Pageable pageable) {
        Page<PostEntity> postEntityPage = postEntityRepository.getAllByPageable(blogId, pageable);
        return new PageImpl<>(Post.of(postEntityPage.getContent()),
                              pageable,
                              postEntityPage.getTotalElements());
    }
}
