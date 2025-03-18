package com.phiworks.menu.mapper;

import com.phiworks.menu.dto.MenuDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuMapper {

    int insertMenu(MenuDTO menuDTO);

    List<MenuDTO> getMenuList(List<String> roles);

    MenuDTO getMenuWithAuth(Long menuId);

    int updateMenu(MenuDTO menuDTO);
}
