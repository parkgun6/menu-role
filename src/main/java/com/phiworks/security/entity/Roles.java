package com.phiworks.security.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import java.util.HashSet;
import java.util.Set;

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

    @ManyToMany(mappedBy = "roles")
    private final Set<Member> users = new HashSet<>();

    @Override
    public String getAuthority() {
        return "ROLE_"+roleName;
    }
}
