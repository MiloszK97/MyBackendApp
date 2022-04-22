package com.example.demo.Profile;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;


@Repository
public interface ProfileRepository extends JpaRepository<Profile, String> {

    @Query(value = "select profile_nickname FROM Profile WHERE profileID=?1", nativeQuery = true)
    Optional<String> profileNickname(String profileID);

}
