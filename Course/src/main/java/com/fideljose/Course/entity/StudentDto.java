package com.fideljose.Course.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class StudentDto {

    private Long id;

    private String name;

    private String address;

    private String email;

    private String password;

}
