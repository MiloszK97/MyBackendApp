package com.example.demo.Profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProfileService {

    private final ProfileRepository profileRepository;

    @Autowired
    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public List<Profile> getProfile(){
        return profileRepository.findAll();
    }

    public Optional<Profile> getProfileById(String profileID){
        return profileRepository.findById(profileID);
    }

    public void addNewProfile(Profile profile) {
        profileRepository.save(profile);
    }

    public void deleteProfile(String profileID) {
        boolean exists = profileRepository.existsById(profileID);
        if (!exists){
            throw new IllegalStateException("Profile with id " + profileID + " does not exists");
        }
        profileRepository.deleteById(profileID);
    }

    @Transactional
    public void updateProfile(String profileID,
                              String profileNickname,
                              Integer profileAge,
                              Integer profileHeight,
                              Double profileWeight,
                              Integer profileTotCal,
                              Double profileTotProt,
                              Double profileTotFat,
                              Double profileTotCarbs) {

        Profile profile = profileRepository.findById(profileID).orElseThrow(() -> new IllegalStateException(
                "Profile with id " + profileID + " does not exists"
        ));

        if (profileNickname != null && profileNickname.length() > 0 && !Objects.equals(profile.getProfileNickname(), profileNickname)){
            profile.setProfileNickname(profileNickname);
        }

        if (profileAge != null  && !Objects.equals(profile.getProfileAge(), profileAge)){
            profile.setProfileAge(profileAge);
        }

        if (profileHeight != null  && !Objects.equals(profile.getProfileHeight(), profileHeight)){
            profile.setProfileHeight(profileHeight);
        }

        if (profileWeight != null  && !Objects.equals(profile.getProfileWeight(), profileWeight)){
            profile.setProfileWeight(profileWeight);
        }

        if (profileTotCal != null  && !Objects.equals(profile.getProfileTotCal(), profileTotCal)){
            profile.setProfileTotCal(profileTotCal);
        }

        if (profileTotProt != null  && !Objects.equals(profile.getProfileTotProt(), profileTotProt)){
            profile.setProfileTotProt(profileTotProt);
        }

        if (profileTotFat != null  && !Objects.equals(profile.getProfileTotFat(), profileTotFat)){
            profile.setProfileTotFat(profileTotFat);
        }

        if (profileTotCarbs != null  && !Objects.equals(profile.getProfileTotCarbs(), profileTotCarbs)){
            profile.setProfileTotCarbs(profileTotCarbs);
        }

    }

    public Optional<String> getProfileNickById(String profileID) {
        return profileRepository.profileNickname(profileID);
    }
}
