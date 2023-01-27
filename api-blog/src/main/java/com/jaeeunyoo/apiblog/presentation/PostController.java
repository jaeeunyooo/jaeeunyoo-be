package com.jaeeunyoo.apiblog.presentation;

import com.jaeeunyoo.apiblog.application.GuestPostService;
import com.jaeeunyoo.apiblog.presentation.dto.PostSummary;
import com.jaeeunyoo.common.dto.CommonApiResponse;
import com.jaeeunyoo.domain.blog.entity.Post;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/blogs")
public class PostController {

    private final GuestPostService guestPostService;

    @GetMapping("/{blogId}/posts")
    public CommonApiResponse<Page<PostSummary>> getPostsByPageable(@PathVariable(name = "blogId") Integer blogId,
                                                                   @PageableDefault(page = 0, size = 10) Pageable pageable,
                                                                   Integer currentMemberId) {
        log.info("currentMemberId : {}", currentMemberId);
        Page<Post> postPage = guestPostService.getGuestPostPage(blogId, pageable);
        return CommonApiResponse.success(new PageImpl<>(postPage.getContent()
                                                            .stream()
                                                            .map(PostSummary::of)
                                                            .collect(Collectors.toList()),
                                                        postPage.getPageable(),
                                                        postPage.getTotalElements()));
    }
}