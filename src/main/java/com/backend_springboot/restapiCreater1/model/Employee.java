package com.backend_springboot.restapiCreater1.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Employees")
public class Employee {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;

@Column(name = "first_name",nullable = false)
    private String firstName;

@Column(name = "last_name")
    private  String lastName;
  @Column(name = "email")
  private String email;

}
