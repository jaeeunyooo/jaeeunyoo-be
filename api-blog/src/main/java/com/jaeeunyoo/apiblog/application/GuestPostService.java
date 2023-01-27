package com.jaeeunyoo.apiblog.application;

import com.jaeeunyoo.domain.blog.BlogDomainService;
import com.jaeeunyoo.domain.blog.entity.Post;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class GuestPostService {

    private final BlogDomainService blogDomainService;

    public Page<Post> getGuestPostPage(Integer blogId, Pageable pageable) {
        return blogDomainService.getPostPage(blogId, pageable);
    }
}
