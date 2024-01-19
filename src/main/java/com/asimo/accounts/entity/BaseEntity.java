package com.asimo.accounts.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@MappedSuperclass //superclass to all the entities where this can be added
public class BaseEntity {

    @Column(updatable = false) //cannot be updated once populated
    private LocalDateTime createdAt;

    @Column(updatable = false)
    private String createdBy;

    @Column(insertable = false) //cannot be added when creating
    private LocalDateTime updatedAt;

    @Column(insertable = false)
    private String updatedBy;

}
