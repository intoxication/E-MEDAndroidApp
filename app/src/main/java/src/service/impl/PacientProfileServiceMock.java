package src.service.impl;

import src.domain.PatientProfileDto;
import src.domain.ProfileDto;
import src.service.interfaces.IPatientProfileService;
import src.service.interfaces.IProfileService;

public class PacientProfileServiceMock implements IPatientProfileService {
    @Override
    public PatientProfileDto getProfile(String userKey) {
        return new PatientProfileDto("Ioan", "Grozea", "ionut.popescu@gmail.com", "+407401231234", "", "12345678");
    }

    @Override
    public void updateProfile(String userKey, ProfileDto dto) {

    }

    @Override
    public void createProfile(String userKey, ProfileDto dto) {

    }

}
