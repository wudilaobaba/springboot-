package com.whj.springbootcode.dto;

import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class PeosonDTO {
    @NonNull
    private String name;


    private Integer age;
}
