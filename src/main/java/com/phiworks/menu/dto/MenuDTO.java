package com.phiworks.menu.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MenuDTO {

    private Long menuId;

    private Long roleId;

    private String menuName;

    private String roleName;

    private String url;

    private Long parentId;

    private int depth;
}
