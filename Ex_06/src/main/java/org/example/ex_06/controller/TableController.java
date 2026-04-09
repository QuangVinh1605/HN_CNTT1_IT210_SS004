package org.example.ex_06.controller;

import org.example.ex_06.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin/tables")
public class TableController {

    private final TableService service;

    @Autowired
    public TableController(TableService service) {
        this.service = service;
    }
    @GetMapping("/list")
    public String list(@RequestParam(required = false, defaultValue = "0") int cap,
                       ModelMap model) {

        if (cap < 0) {
            model.addAttribute("error", "Sức chứa không được âm!");
            return "tableList";
        }

        model.addAttribute("tables", service.filterByCapacity(cap));
        return "tableList";
    }

    @GetMapping("/view/{id}")
    public ModelAndView view(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView("tableDetail");
        mv.addObject("table", service.getById(id));
        return mv;
    }

    @PostMapping("/update-status")
    public String updateStatus(@RequestParam Long id,
                               @RequestParam String status) {
        service.updateStatus(id, status);
        return "redirect:/admin/tables/list";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id, ModelMap model) {
        String msg = service.delete(id);
        model.addAttribute("message", msg);
        model.addAttribute("tables", service.filterByCapacity(0));
        return "tableList";
    }
}
