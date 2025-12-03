package test.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // Khi người dùng vào trang chủ (localhost:9090)
    @GetMapping("/")
    public String home() {
        // Tự động chuyển hướng sang trang admin/categories
        return "redirect:/admin/categories";
    }
}