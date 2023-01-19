package com.jaeeunyoo.apiblog.application;

import com.jaeeunyoo.apiblog.domain.post.PostDomainService;
import com.jaeeunyoo.apiblog.domain.post.entity.Post;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class GuestPostService {

    private final PostDomainService postDomainService;

    public Page<Post> getGuestPostPage(Integer blogId, Pageable pageable) {
        return postDomainService.getPostPage(blogId, pageable);
    }
}
