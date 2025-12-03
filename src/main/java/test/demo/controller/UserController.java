package test.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import test.demo.entity.User;
import test.demo.services.UserService;
import java.util.Optional;

@Controller
@RequestMapping("admin/users")
public class UserController {

    @Autowired UserService userService;

    @RequestMapping("")
    public String list(ModelMap model) {
        model.addAttribute("users", userService.findAll());
        return "admin/users/list";
    }

    @GetMapping("add")
    public String add(ModelMap model) {
        model.addAttribute("user", new User());
        model.addAttribute("isEdit", false); // Cờ để biết là đang thêm mới
        return "admin/users/addOrEdit";
    }
    
    @PostMapping("saveOrUpdate")
    public String saveOrUpdate(ModelMap model, @ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/admin/users";
    }

    @GetMapping("edit/{username}")
    public String edit(ModelMap model, @PathVariable("username") String username) {
        Optional<User> opt = userService.findById(username);
        if (opt.isPresent()) {
            model.addAttribute("user", opt.get());
            model.addAttribute("isEdit", true); // Cờ đang sửa
            return "admin/users/addOrEdit";
        }
        return "redirect:/admin/users";
    }

    @GetMapping("delete/{username}")
    public String delete(@PathVariable("username") String username) {
        userService.deleteById(username);
        return "redirect:/admin/users";
    }
}