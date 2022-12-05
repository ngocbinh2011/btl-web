package com.ptit.personal.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "orders")
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
}
