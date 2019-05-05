package com.sid.guauess.guauess.controller;

import com.sid.guauess.guauess.model.Histories;
import com.sid.guauess.guauess.model.Projects;
import com.sid.guauess.guauess.service.ProjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletContext;


@Controller
public class ProjectController {

    private ProjectsService projectService;
    @Autowired
    public void setProjectService(ProjectsService projectService) {
        this.projectService = projectService;
    }

    @RequestMapping(value = "/projects")
    public String index() {
        return "redirect:/projects/1";
    }

    @RequestMapping(value = "/projects/{pageNumber}", method = RequestMethod.GET)
    public String list(@PathVariable Integer pageNumber, Model model) {
        Page<Projects> page = projectService.getList(pageNumber);

        int current = page.getNumber() + 1;
        int begin = Math.max(1, current - 5);
        int end = Math.min(begin + 10, page.getTotalPages());

        model.addAttribute("list", page);
        model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);
        model.addAttribute("currentIndex", current);
        model.addAttribute("project", new Projects());
        model.addAttribute("history", new Histories());

        return "projects/list";

    }

    @RequestMapping("/projects/add")
    public String add(Model model) {

        model.addAttribute("project", new Projects());
        return "projects/form";

    }

    @RequestMapping("/projects/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {

        model.addAttribute("project", projectService.get(id));
        return "projects/form";

    }

    @RequestMapping(value = "/projects/save", method = RequestMethod.POST)
    public String save(Projects project, final RedirectAttributes ra) {

        Projects save = projectService.save(project);
        ra.addFlashAttribute("successFlash", "Le projet est enregistré.");
        return "redirect:/projects";

    }

    @RequestMapping("/projects/delete/{id}")
    public String delete(@PathVariable Long id) {

        projectService.delete(id);
        return "redirect:/projects";

    }


}
