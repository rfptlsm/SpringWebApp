package com.springwebapp.webapp.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // Класс является сущностью
@Table(name = "products") // Объекты класса хранятся в БД и табл называется products
@NoArgsConstructor // Вместо дефолтного конструктора (lombok)
@Data // Вместо get/set (lombok)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Запрашиваем из БД / БД при записи сгенерирует id и вернет
    @Column(name = "id") // id расположен в столбце с названием id
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private float price;
    
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
