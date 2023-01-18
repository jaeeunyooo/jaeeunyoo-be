package com.jaeeunyoo.apiblog.presentation;

import com.jaeeunyoo.apiblog.application.GuestPostService;
import com.jaeeunyoo.apiblog.domain.post.entity.Post;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/posts")
public class PostController {

    private final GuestPostService guestPostService;

    @GetMapping
    public Page<Post> getPostsByPageable(@RequestParam(name = "memberId") Integer memberId,
                                         @PageableDefault(page = 0, size = 10) Pageable pageable) {
        return guestPostService.getGuestPostPage(memberId, pageable);
    }
}