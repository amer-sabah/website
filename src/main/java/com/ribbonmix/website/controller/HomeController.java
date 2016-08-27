package com.ribbonmix.website.controller;

import com.ribbonmix.core.entity.general.NeighborhoodEntity;
import com.ribbonmix.core.service.AccountService;
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

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String viewHome(Model model) {

        NeighborhoodEntity neighborhood = generalService.getNeighborhoodByShortName("jubaiha");

        System.out.println(">>>");
        model.addAttribute("test1", neighborhood.getShortName());

        System.out.println(">>>");
        model.addAttribute("test2", neighborhood.getCity().getShortName());

        System.out.println(">>>");
        model.addAttribute("test3", neighborhood.getCity().getCountry().getIso3());

        System.out.println(">>>");
        model.addAttribute("test4", generalService.getCurrencyByShortName("jod"));

        System.out.println(">>>");
        model.addAttribute("test5", accountService.getPersonById(1));

        System.out.println(">>>");
        model.addAttribute("test5", accountService.getUserAccounts(1));

        System.out.println(">>>");
        model.addAttribute("test6", accountService.getPersonByEmail("amer.sabah1987@gmail.com"));

        System.out.println(">>>");
        model.addAttribute("test7", accountService.getPersonPhones(1));

        System.out.println(">>>");
        model.addAttribute("test8", accountService.getPersonAddresses(1));

        System.out.println(">>>");
        model.addAttribute("test9", accountService.getPersonEmails(1));

        System.out.println(">>>");
        model.addAttribute("test10", accountService.getUserProfileById(1).getPerson());

        System.out.println(">>>");
        model.addAttribute("test11", accountService.getRibbonMixAccountByUserProfileId(1).getUserProfile().getPerson());

        return View.HOME;
    }
}
