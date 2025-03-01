package ru.job4j.mapstuct.model;

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
public class StudentSubject {
    private int id;
    private String name;
    private String classVal;
    private SubjectEntity subject;
}