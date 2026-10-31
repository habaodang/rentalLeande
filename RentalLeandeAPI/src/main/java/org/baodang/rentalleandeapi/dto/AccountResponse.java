package org.baodang.rentalleandeapi.dto;

public record AccountResponse(
        Long id,
        String email,
        String status
) {
}