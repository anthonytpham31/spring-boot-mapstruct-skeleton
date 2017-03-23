package cooksys.mapper;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import cooksys.dto.CredentialsDto;
import cooksys.entity.Users;
import cooksys.entity.embeddable.Credentials;
import cooksys.mapper.annotations.UsersCredentials;
import cooksys.repository.UsersRepository;

@Component
public class CredentialsMapper {

    private final UsersRepository users;

    public CredentialsMapper(UsersRepository users) {
        this.users = users;
    }

    public CredentialsDto toCredentialsDto(Credentials credentials) {
        if (credentials == null) return null;
        CredentialsDto result = new CredentialsDto();
        result.setUsername(credentials.getName());
        return result;
    }

    private Credentials toCredentials(CredentialsDto dto) {
        if (dto == null) return null;
        Credentials credentials = new Credentials();
        credentials.setName(dto.getUsername());
        credentials.setPass(dto.getPassword());
        return credentials;
    }

    @UsersCredentials
    public Credentials resolveUsersCredentials(CredentialsDto dto) {
        if (dto == null) return null;
        Users user = users.findByUserCredsName(dto.getUsername());
        return users != null ? user.getUserCreds() : toCredentials(dto);
    }

}