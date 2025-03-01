package ru.job4j.mapstuct.mappers;

import ru.job4j.mapstuct.dto.StudentDto;
import ru.job4j.mapstuct.model.StudentEntity;

public class ManualMapper {
    public StudentDto getDto(StudentEntity studentEntity) {
        StudentDto dto = new StudentDto();
        dto.setId(studentEntity.getId());
        dto.setName(studentEntity.getName());
        dto.setClassName(studentEntity.getClassVal());
        return dto;
    }

    public StudentEntity getEntity(StudentDto dto) {
        StudentEntity entity = new StudentEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setClassVal(dto.getClassName());
        return entity;
    }
}
