package org.baodang.rentalleandeapi.dto;

public record LoginRequest(
        String email,
        String password
) {
}
