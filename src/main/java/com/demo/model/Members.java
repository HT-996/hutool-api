package com.demo.model;

import lombok.Data;

import javax.persistence.*;

/**
 * @author HuTing
 * @date 2020-09-04 17:14
 */
@Data
@Entity
@Table(name = "members")
public class Members {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
}
