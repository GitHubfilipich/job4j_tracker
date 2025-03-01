package ru.job4j.mapstuct;

import org.mapstruct.factory.Mappers;
import ru.job4j.mapstuct.dto.DeliveryAddressDTO;
import ru.job4j.mapstuct.dto.StudentDto;
import ru.job4j.mapstuct.mappers.DeliveryAddressMapper;
import ru.job4j.mapstuct.mappers.StudentMapper;
import ru.job4j.mapstuct.mappers.StudentSubjectMapper;
import ru.job4j.mapstuct.model.AddressEntity;
import ru.job4j.mapstuct.model.StudentEntity;
import ru.job4j.mapstuct.model.StudentSubject;
import ru.job4j.mapstuct.model.SubjectEntity;

public class Main {
    public static void main(String[] args) {
        StudentMapper studentMapper = Mappers.getMapper(StudentMapper.class);
        StudentEntity sEntity = new StudentEntity(0, "entity", "junior");
        StudentDto sDto = new StudentDto(11, "dto", "middle");
        StudentDto fromEntity = studentMapper.getModelFromEntity(sEntity);
        System.out.println("fromEntity = " + fromEntity);
        StudentEntity fromDto = studentMapper.getEntityFromDto(sDto);
        System.out.println("fromDto = " + fromDto);

        System.out.println(studentMapper.getModelFromEntityCustom(sEntity));

        DeliveryAddressMapper deliveryAddressMapper = Mappers.getMapper(DeliveryAddressMapper.class);
        StudentEntity sEntity2 = new StudentEntity(0, "entity", "junior");
        AddressEntity address = new AddressEntity(100, "cityGood", "stateNew");
        DeliveryAddressDTO deliveryAddressDTO = deliveryAddressMapper.getDeliveryAddress(sEntity2, address);
        System.out.println("deliveryAddressDTO = " + deliveryAddressDTO);

        SubjectEntity subjectEntity = new SubjectEntity("subject1");
        StudentSubject studentSubject = new StudentSubject(1, "name1", "class1", subjectEntity);
        StudentSubjectMapper studentSubjectMapper = Mappers.getMapper(StudentSubjectMapper.class);
        System.out.println("StudentSubjectDto = " + studentSubjectMapper.getModelFromEntity(studentSubject));
    }
}
