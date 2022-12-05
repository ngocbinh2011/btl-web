package com.ptit.personal.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

public class BookDto {
    private Integer id;
    private String title;
    private String author;
    private String category;
    private Date releaseDate;
    private int nOP;
    private String cover;
    private String description;
}
