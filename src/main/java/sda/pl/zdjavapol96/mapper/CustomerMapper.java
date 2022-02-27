package sda.pl.zdjavapol96.mapper;

import sda.pl.zdjavapol96.dto.CustomerDto;
import sda.pl.zdjavapol96.model.Customer;

public class CustomerMapper {
    public static CustomerDto mapToDto(Customer customer){
        return CustomerDto.builder()
                .name(customer.getName())
                .country(customer.getCountry())
                .address(customer.getAddress())
                .phoneNumber(customer.getPhoneNumber())
                .eMail(customer.getEMail())
                .taxId(customer.getTaxId())
                .build();
    }
}
