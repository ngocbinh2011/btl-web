
package com.ptit.personal.entity;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;


@Entity
@Table(name = "books")
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "category")
    private String category;

    @Column(name = "release_date")
    private Date releaseDate;

    @Column(name = "n_o_p")
    private int nOP;

    @Column(name = "cover")
    private String cover;
    
    @Column(name = "description")
    private String description;

    @Transient
    public String getCoverImg() {
        if (cover == null) return null;
        return "/coverImg/" + cover;
    }
}
