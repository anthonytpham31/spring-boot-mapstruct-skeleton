package cooksys.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import cooksys.dto.UsersCreationDto;
import cooksys.dto.UsersDto;
import cooksys.entity.Users;

@Mapper(componentModel = "spring", uses = {CredentialsMapper.class})
public interface UsersCreationMapper {
	
	@Mappings({
        @Mapping(source = "userProfile.first", target = "firstName"),
        @Mapping(source = "userProfile.last", target = "lastName"),
        @Mapping(source = "userProfile.mail", target = "email"),
        @Mapping(source = "userProfile.phone", target = "phoneNumber"),
        @Mapping(source = "userCreds.name", target = "username"),
        @Mapping(source = "userCreds.pass", target = "password")
	})
	UsersCreationDto toUsersCreationDto(Users users);
	
	@Mappings({
        @Mapping(source = "firstName", target = "userProfile.first"),
        @Mapping(source = "lastName", target = "userProfile.last"),
        @Mapping(source = "email", target = "userProfile.mail"),
        @Mapping(source = "phoneNumber", target = "userProfile.phone"),
        @Mapping(source = "username", target = "userCreds.name"),
        @Mapping(source = "password", target = "userCreds.pass")
	})
	Users toUsers(UsersCreationDto usersDto);
}
