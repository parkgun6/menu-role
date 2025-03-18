package com.phiworks.menu.mapper;

import com.phiworks.menu.dto.MenuDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MenuRoleMapper {

    int insertMenuRole(MenuDTO menuDTO);

    int updateMenuRole(MenuDTO menuDTO);
}
