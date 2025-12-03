package test.demo.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils; 
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam; 
import org.springframework.web.servlet.ModelAndView;

import jakarta.validation.Valid;
import test.demo.entity.Category;
import test.demo.model.CategoryModel;
import test.demo.services.CategoryService;

@Controller
@RequestMapping("admin/categories")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("add")
    public String add(ModelMap model) {
        CategoryModel cateModel = new CategoryModel();
        cateModel.setIsEdit(false);
        model.addAttribute("category", cateModel);
        return "admin/categories/addOrEdit";
    }

    // --- SỬA HÀM LIST ĐỂ CÓ TÌM KIẾM ---
    @RequestMapping("")
    public String list(ModelMap model, @RequestParam(name = "name", required = false) String name) {
        List<Category> list = null;

        // Nếu có từ khóa tìm kiếm thì gọi hàm FindByName
        if (StringUtils.hasText(name)) {
            list = categoryService.findByCategoryNameContaining(name);
        } else {
            // Nếu không có thì hiển thị tất cả
            list = categoryService.findAll();
        }
        
        model.addAttribute("categories", list);
        return "admin/categories/list";
    }

    @PostMapping("saveOrUpdate")
    public ModelAndView saveOrUpdate(ModelMap model,
            @Valid @ModelAttribute("category") CategoryModel cateModel, BindingResult result) {
        
        if (result.hasErrors()) {
            return new ModelAndView("admin/categories/addOrEdit");
        }

        Category entity = new Category();
        // Copy dữ liệu từ Model sang Entity (Lưu ý: Tên biến phải giống nhau: id, categoryName...)
        BeanUtils.copyProperties(cateModel, entity);

        categoryService.save(entity);

        String message = "";
        if (cateModel.getIsEdit() == true) {
            message = "Category is Edited!!!!!!!!";
        } else {
            message = "Category is saved!!!!!!!!";
        }

        model.addAttribute("message", message);
        return new ModelAndView("forward:/admin/categories", model);
    }

    @GetMapping("edit/{id}")
    public ModelAndView edit(ModelMap model, @PathVariable("id") int id) {
        Optional<Category> optCategory = categoryService.findById(id);
        CategoryModel cateModel = new CategoryModel();

        if (optCategory.isPresent()) {
            Category entity = optCategory.get();
            BeanUtils.copyProperties(entity, cateModel);
            cateModel.setIsEdit(true);
            model.addAttribute("category", cateModel);
            return new ModelAndView("admin/categories/addOrEdit", model);
        }

        model.addAttribute("message", "Category is not existed!!!!");
        return new ModelAndView("forward:/admin/categories", model);
    }

    @GetMapping("delete/{id}")
    public ModelAndView delete(ModelMap model, @PathVariable("id") int id) {
        categoryService.deleteById(id);
        model.addAttribute("message", "Category is deleted!!!!");
        return new ModelAndView("forward:/admin/categories", model);
    }
}