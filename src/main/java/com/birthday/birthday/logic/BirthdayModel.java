package com.birthday.birthday.logic;


import com.fasterxml.jackson.annotation.JsonFormat;
import javax.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

@Data
public class BirthdayModel extends RepresentationModel {
    @NotBlank
    private String birthDayName;
    @NotBlank
    @JsonFormat(pattern = "dd-MM")
    private String birthDate;
    private String userName;
}
