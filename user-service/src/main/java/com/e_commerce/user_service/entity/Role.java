package com.e_commerce.user_service.entity;

import com.microservice.shared_library.model.BaseEntityAudit;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
public class Role extends BaseEntityAudit {
    @Column(nullable = false, unique = true)
    private String authority;

    @ManyToMany(mappedBy = "authorities")
    List<User> users = new ArrayList<>();

    @Override
    public String toString() {
        return "Role [authority=" + authority + ", users=" + users + "]" + super.toString();
    }
}
