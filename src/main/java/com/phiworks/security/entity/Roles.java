package com.phiworks.security.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name="role")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Roles implements GrantedAuthority {

    @Id
    private Long roleId;

    private String roleName;

    @Override
    public String getAuthority() {
        return "ROLE_"+roleName;
    }
}
