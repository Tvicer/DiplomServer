package com.diplom.diplom.dataBase.Dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {
    private Long id;

    private String email;

    private String fio;

    private String role;
}
