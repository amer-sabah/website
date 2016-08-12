package com.ribbonmix.website.controller;

import com.ribbonmix.core.entity.CityEntity;
import com.ribbonmix.core.service.GeneralService;
import com.ribbonmix.website.resource.View;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Amer on 7/29/2016.
 */
@Controller
public class HomeController {

    @Autowired
    private GeneralService generalService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String viewHome(Model model) {

        CityEntity city = generalService.getCityByShortName("amman");

        System.out.println(">>>");
        model.addAttribute("test", city);

        return View.HOME;
    }
}
