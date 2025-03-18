package com.phiworks.menu.mapper;

import com.phiworks.menu.dto.MenuDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Log4j2
public class MenuRoleMapperTests {

    @Autowired
    MenuRoleMapper mapper;

    @Test
    public void insertMenurole() {
        MenuDTO menuDTO = MenuDTO.builder()
                .menuId(1L)
                .roleId(2L)
                .build();
        mapper.insertMenuRole(menuDTO);
    }

    @Test
    public void updateMenurole() {
        MenuDTO menuDTO = MenuDTO.builder()
                .menuId(1L)
                .roleId(3L)
                .build();
        mapper.updateMenuRole(menuDTO);
    }
}
