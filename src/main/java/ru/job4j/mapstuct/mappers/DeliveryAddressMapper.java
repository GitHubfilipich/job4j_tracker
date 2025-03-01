package ru.job4j.mapstuct.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.job4j.mapstuct.model.AddressEntity;
import ru.job4j.mapstuct.dto.DeliveryAddressDTO;
import ru.job4j.mapstuct.model.StudentEntity;

@Mapper
public interface DeliveryAddressMapper {
    @Mapping(source = "student.name", target = "name")
    @Mapping(source = "address.houseNo", target = "houseNumber")
    DeliveryAddressDTO getDeliveryAddress(StudentEntity student, AddressEntity address);
}
