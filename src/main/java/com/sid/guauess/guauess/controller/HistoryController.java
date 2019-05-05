package com.sid.guauess.guauess.controller;

import com.sid.guauess.guauess.model.Histories;
import com.sid.guauess.guauess.service.HistoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HistoryController {

    private HistoriesService historyService;

    @Autowired
    public void setProjectService(HistoriesService historyService) {
        this.historyService = historyService;
    }

    @ModelAttribute(value = "history")
    public Histories Histories()
    {
        return new Histories();
    }
    @RequestMapping(value = "/histories")
    public String index() {
        return "redirect:/histories/1";
    }

    @RequestMapping(value = "/histories/{pageNumber}", method = RequestMethod.GET)
    public String list(@PathVariable Integer pageNumber, Model model) {
        Page<Histories> page = historyService.getList(pageNumber);

        int current = page.getNumber() + 1;
        int begin = Math.max(1, current - 5);
        int end = Math.min(begin + 10, page.getTotalPages());

        model.addAttribute("list", page);
        model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);
        model.addAttribute("currentIndex", current);

        return "histories/list";

    }

    @RequestMapping("/histories/add")
    public String add(Model model) {

        model.addAttribute("history", new Histories());
        return "histories/form";

    }

    @RequestMapping("/histories/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {

        model.addAttribute("history", historyService.get(id));
        return "histories/form";

    }

    @RequestMapping(value = "/histories/save", method = RequestMethod.POST)
    public String save(Histories history, final RedirectAttributes ra) {

        Histories save = historyService.save(history);
        ra.addFlashAttribute("successFlash", "l'historique est enregistrée.");
        return "redirect:/histories";

    }

    @RequestMapping("/histories/delete/{id}")
    public String delete(@PathVariable Long id) {

        historyService.delete(id);
        return "redirect:/histories";

    }
    @PostMapping("/save")
    public String save(Histories h ){
        historyService.save(h);
        return"redirect/projects";
    }

}
