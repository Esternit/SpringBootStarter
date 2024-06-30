package dev.esternit.runnerz.user;

import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface MyUserRepository extends ListCrudRepository<MyUser, UUID> {

    Optional<MyUser> findByUsername(String username);
}
