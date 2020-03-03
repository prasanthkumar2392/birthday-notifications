package com.birthday.birthday.logic;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
@Table(catalog = "birthday_records")
public class BirthdayEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "birthday_name")
    private String birthDayName;
    @Column(name = "birth_date")
    private String birthDate;
    @Column(name = "user_name")
    private String userName;

}
