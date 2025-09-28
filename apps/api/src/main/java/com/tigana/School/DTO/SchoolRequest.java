package com.tigana.School.DTO;


import com.tigana.Enums.CityEnums;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SchoolRequest {

    @NotBlank
    private String publicId;

    @NotBlank
    private String name;
    
    @NotNull
    private CityEnums city;

    @NotBlank
    private String address;

}
