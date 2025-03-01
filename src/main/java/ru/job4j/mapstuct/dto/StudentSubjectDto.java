package ru.job4j.mapstuct.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StudentSubjectDto {
    private int id;
    private String name;
    private String className;
    private String subject;
}
