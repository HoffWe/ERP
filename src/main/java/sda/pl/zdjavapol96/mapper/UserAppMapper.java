package sda.pl.zdjavapol96.mapper;

import sda.pl.zdjavapol96.dto.UserAppDto;
import sda.pl.zdjavapol96.model.UserApp;

public class UserAppMapper {
     static public UserAppDto mapToDto(UserApp userApp){
         return UserAppDto.builder()
                 .firstName(userApp.getFirstName())
                 .lastName(userApp.getLastName())
                 .username(userApp.getUsername())
                 .build();
     }
}
