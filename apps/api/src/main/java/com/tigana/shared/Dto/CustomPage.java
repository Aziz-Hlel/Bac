package com.tigana.shared.Dto;

import java.util.List;

import org.springframework.data.domain.Page;

public record CustomPage<T>(List<T> content, CustomPageable pageable) {

    public static <T> CustomPage<T> from(Page<T> page) {
        return new CustomPage<>(
                page.getContent(),
                new CustomPageable(
                        page.getNumber(),
                        page.getSize(),
                        page.getTotalElements(),
                        page.getTotalPages()));
    }

}
