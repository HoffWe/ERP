package sda.pl.zdjavapol96.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sda.pl.zdjavapol96.model.UserApp;

import javax.validation.constraints.NotNull;
import java.util.Optional;

@Repository
public interface UserAppRepository extends JpaRepository<UserApp, Long> {
    Optional<UserApp> findByUsername(String userName);
}