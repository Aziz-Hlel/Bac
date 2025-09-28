package com.tigana.School.DTO;

import com.tigana.Enums.CityEnums;

public record SchoolResponse(
        String publicId,
        String name,
        CityEnums city,
        String address) {

}
