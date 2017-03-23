package cooksys.mapper;

import org.mapstruct.Mapper;

import cooksys.dto.UsersDto;
import cooksys.entity.Users;

@Mapper(componentModel = "spring", uses = {ReferenceMapper.class})
public interface UsersMapper {
	
	UsersDto toUsersDto(Users users);
	
	Users toUsers(UsersDto usersDto);
}
