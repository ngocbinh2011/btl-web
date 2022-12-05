package com.ptit.personal.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class UserDto {

    private int id;

    private String username;

    private String passwd;

    private String email;
}
