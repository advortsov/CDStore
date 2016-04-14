package com.dvortsov.cdstore.controller;

import com.dvortsov.cdstore.service.interfaces.CDService;
import com.dvortsov.cdstore.service.objects.Catalog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * @author Alexander Dvortsov
 * @version 1.0
 * @since 12.04.2016
 */

@Controller
@RequestMapping("/")
public class CDController {

    @Autowired
    private CDService cdService;

    @RequestMapping(method = RequestMethod.GET)
    public String allCDs(Model model, Integer offset, Integer maxResults) {
        model.addAttribute("cds", cdService.list(offset, maxResults));
        model.addAttribute("count", cdService.count());
        model.addAttribute("offset", offset);
        return "list.jsp";
    }

    @RequestMapping("allCDs")
    public
    @ResponseBody
    Catalog getAllCDs(HttpServletResponse response) {
        response.setContentType("text/xml");
        response.setHeader("Content-Disposition", "attachment; filename=allCDs.xml");
        return new Catalog(cdService.getAll());
    }
}