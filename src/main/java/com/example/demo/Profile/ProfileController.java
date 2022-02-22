package com.example.demo.Profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/profile")
public class ProfileController {

    private final ProfileService profileService;

    @Autowired
    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping
    public List<Profile> getProfile(){
        return profileService.getProfile();
    }

    @GetMapping(path = "{profileID}")
    public Optional<Profile>getProfileById(@PathVariable("profileID") String profileID){
        return profileService.getProfileById(profileID);
    }

    @PostMapping
    public void addNewProfile(@RequestBody Profile profile){
        profileService.addNewProfile(profile);
    }

    @DeleteMapping(path = "{profileID}")
    public void deleteProfile(@PathVariable("profileID") String profileID){
        profileService.deleteProfile(profileID);
    }

    @PutMapping(path = "{profileID}")
    public void updateProfile(
            @PathVariable("profileID") String profileID,
            @RequestParam(required = false) String profileNickname,
            @RequestParam(required = false) Integer profileAge,
            @RequestParam(required = false) Integer profileHeight,
            @RequestParam(required = false) Double profileWeight,
            @RequestParam(required = false) Integer profileTotCal){
        profileService.updateProfile(profileID, profileNickname, profileAge, profileHeight, profileWeight, profileTotCal);
    }
    
}
