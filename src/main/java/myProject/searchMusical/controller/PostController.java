package myProject.searchMusical.controller;

import lombok.RequiredArgsConstructor;
import myProject.searchMusical.entity.Post;
import myProject.searchMusical.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PostController {
    public final PostService postService;
    @GetMapping("/")
    public String list(Model model) {
        // 학교 사이트에 뮤지컬 정보 땡겨오기
        postService.load();

        List<Post> contents = postService.findAll();
        model.addAttribute("contents", contents);

        return "musicalList";
    }

    // thymeleaf 테스트 코드
//    @GetMapping("/hello")
//    public String hello(Model model) {
//        model.addAttribute("data", "서버에서 보내준 값입니다.");
//        return "hello";
//    }
}
