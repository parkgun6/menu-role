package com.phiworks.menu.service.impl;

import com.phiworks.menu.dto.MenuDTO;
import com.phiworks.menu.mapper.MenuMapper;
import com.phiworks.menu.mapper.MenuRoleMapper;
import com.phiworks.menu.service.MenuService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class MenuServiceImpl implements MenuService {

    private final MenuMapper menuMapper;

    private final MenuRoleMapper menuRoleMapper;

    @Override
    @Transactional
    public String insertMenuData(MenuDTO menuDTO) {
        try {
            boolean isMenuInserted = menuMapper.insertMenu(menuDTO) == 1;
            boolean isMenuAuthInserted = menuRoleMapper.insertMenuRole(menuDTO) == 1;
            if (!isMenuInserted && !isMenuAuthInserted) throw new RuntimeException("데이터 저장 중 오류 발생");
        } catch (Exception e) {
            log.error("저장 중 오류 발생: {}", e.getMessage(), e);
            throw new RuntimeException("데이터 저장 중 오류 발생", e);
        }
        return "저장을 성공하였습니다.";
    }

    @Cacheable(value = "menuData", key = "#authentication != null ? #authentication.name + '-' + #roles : 'ANONYMOUS'")
    @Override
    public List<MenuDTO> getMenuList(Authentication authentication, List<String> roles) {
        log.info(authentication.getName() + roles.toString());
        log.info("getMenuList.....");

        if (authentication != null && authentication.isAuthenticated()) {
            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

            authorities.forEach(authority -> {
                String role = authority.getAuthority();
                String roleWithoutPrefix = role.replace("ROLE_", "");
                roles.add(roleWithoutPrefix);
            });
        }
        return menuMapper.getMenuList(roles);
    }
}
