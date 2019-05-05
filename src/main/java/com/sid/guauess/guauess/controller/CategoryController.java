package com.sid.guauess.guauess.controller;

import com.sid.guauess.guauess.model.Categories;
import com.sid.guauess.guauess.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class CategoryController {

    private CategoriesService categoryService;

    @Autowired
    public void setCategoryService(CategoriesService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping(value = "/categories")
    public String index() {
        return "redirect:/categories/1";
    }

    @RequestMapping(value = "/categories/{pageNumber}", method = RequestMethod.GET)
    public String list(@PathVariable Integer pageNumber, Model model) {
        Page<Categories> page = categoryService.getList(pageNumber);

        int current = page.getNumber() + 1;
        int begin = Math.max(1, current - 5);
        int end = Math.min(begin + 10, page.getTotalPages());

        model.addAttribute("list", page);
        model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);
        model.addAttribute("currentIndex", current);

        return "categories/list";

    }

    @RequestMapping("/categories/add")
    public String add(Model model) {

        model.addAttribute("category", new Categories());
        return "categories/form";

    }

    @RequestMapping("/categories/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {

        model.addAttribute("category", categoryService.get(id));
        return "categories/form";

    }

    @RequestMapping(value = "/categories/save", method = RequestMethod.POST)
    public String save(Categories category, final RedirectAttributes ra) {

        Categories save = categoryService.save(category);
        ra.addFlashAttribute("successFlash", "Cliente foi salvo com sucesso.");
        return "redirect:/categories";

    }

    @RequestMapping("/categories/delete/{id}")
    public String delete(@PathVariable Long id) {

        categoryService.delete(id);
        return "redirect:/categories";

    }


}
