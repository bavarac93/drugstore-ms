package com.example.dms.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class RoleResponse {
    private Long id;
    private String name;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getRoleCreatedAt() {
        return createdAt;
    }

    public void setRoleCreatedAt(LocalDateTime roleCreatedAt) {
        this.createdAt = roleCreatedAt;
    }
}
