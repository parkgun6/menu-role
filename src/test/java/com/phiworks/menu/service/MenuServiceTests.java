package com.phiworks.menu.service;

import com.phiworks.menu.dto.MenuDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
@Log4j2
public class MenuServiceTests {

    @Autowired
    MenuService service;

    @Test
    public void insertMenuData() {
        MenuDTO menuDTO = MenuDTO.builder()
                .menuName("공지사항")
                //.authId(2L)
                .url("/info/notice")
                .parentId(1L)
                .build();
        service.insertMenuData(menuDTO);
    }

    @Test
    public void getMenuData() {
//        log.info(service.getMenuList(Arrays.asList("MANAGER")));
    }
}
