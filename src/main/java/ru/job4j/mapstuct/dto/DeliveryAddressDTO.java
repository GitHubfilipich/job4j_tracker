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
public class DeliveryAddressDTO {
    private String name;
    private int houseNumber;
    private String city;
    private String state;
}
