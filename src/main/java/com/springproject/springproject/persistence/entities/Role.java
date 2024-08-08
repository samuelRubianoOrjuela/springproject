package com.springproject.springproject.persistence.entities;


import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long roles_id;

    @Column(name = "name", unique = true)
    private String name;

    @JsonIgnoreProperties({"roles","handler", "hibernateLazyInitalizer"})
    @ManyToMany(mappedBy = "roles")
    private List<User> users;


    public Role(String name) {
        this.name = name;
    }

    public Role() {
        this.users = new ArrayList<>();
    }

    public Long getRoles_id() {
        return roles_id;
    }

    public void setRoles_id(Long roles_id) {
        this.roles_id = roles_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((roles_id == null) ? 0 : roles_id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Role other = (Role) obj;
        if (roles_id == null) {
            if (other.roles_id != null)
                return false;
        } else if (!roles_id.equals(other.roles_id))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }
    

}
