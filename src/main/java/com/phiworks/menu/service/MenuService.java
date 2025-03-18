package com.phiworks.menu.service;

import com.phiworks.menu.dto.MenuDTO;
import org.springframework.security.core.Authentication;

import java.util.List;

public interface MenuService {

    String insertMenuData(MenuDTO menuDTO);

    List<MenuDTO> getMenuList(Authentication authentication, List<String> roles);
}
