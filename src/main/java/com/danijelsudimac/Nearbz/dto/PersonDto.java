package com.danijelsudimac.Nearbz.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class PersonDto {
    @NotNull
    private Long id;
    private Long longitude;
    private Long latitude;
    private String imagePath;
}
