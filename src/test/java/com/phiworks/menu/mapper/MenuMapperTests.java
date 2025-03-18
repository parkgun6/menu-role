package com.phiworks.menu.mapper;

import com.phiworks.menu.dto.MenuDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
@Log4j2
public class MenuMapperTests {

    @Autowired
    MenuMapper mapper;

    @Test
    public void insertMenu() {
        MenuDTO menuDTO = MenuDTO.builder()
                .menuName("안내")
                .url("/intro")
                .parentId(null)
                .build();
        mapper.insertMenu(menuDTO);
    }

    @Test
    public void getMenuList() {
        List<MenuDTO> menuList = mapper.getMenuList(Arrays.asList("MANAGER","USER","ADMIN"));
        log.info(menuList.toString());
    }

    @Test
    public void getMenuWithAuth() {
        MenuDTO menu = mapper.getMenuWithAuth(1L);
        log.info(menu);
    }

    @Test
    public void updateMenu() {
        MenuDTO menuDTO = MenuDTO.builder()
                .menuId(1L)
                .menuName("안내페이지")
                .url("/intro")
                .build();
        mapper.updateMenu(menuDTO);
    }
}
