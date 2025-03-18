package com.phiworks.menu.controller;

import com.phiworks.menu.service.MenuService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
@RequestMapping("/")
@RequiredArgsConstructor
public class MenuController {

    private final MenuService menuService;

    @GetMapping("/")
    public String mainPage(Model model) {
        log.info("mainPage...");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        log.info(authentication.toString());
        /*List<MenuDTO> menuList = menuService.getMenuList();
        model.addAttribute("menuList", menuList);*/
        return "main";
    }

    @GetMapping("/login")
    public void loginPage() {
    }
}
