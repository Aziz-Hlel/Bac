package com.tigana.shared.Dto;

public record CustomPageable(
        int number,
        int size,
        long totalElements,
        int totalPages) {
}
