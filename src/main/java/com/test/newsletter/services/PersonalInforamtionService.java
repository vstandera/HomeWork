package com.test.newsletter.services;

import com.test.newsletter.converters.PersonalInformationDataToPersonalInformation;
import com.test.newsletter.converters.PersonalInfromationToPersonalInformationData;
import com.test.newsletter.data.PersonalInformationData;
import com.test.newsletter.domain.PersonalInformation;
import com.test.newsletter.repositories.PersonalInformationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PersonalInforamtionService {

    PersonalInformationRepository personalInformationRepository;
    PersonalInfromationToPersonalInformationData personalInfromationToPersonalInformationData;
    PersonalInformationDataToPersonalInformation personalInformationDataToPersonalInformation;

    public PersonalInforamtionService(PersonalInformationRepository personalInformationRepository, PersonalInfromationToPersonalInformationData personalInfromationToPersonalInformationData, PersonalInformationDataToPersonalInformation personalInformationDataToPersonalInformation) {
        this.personalInformationRepository = personalInformationRepository;
        this.personalInfromationToPersonalInformationData = personalInfromationToPersonalInformationData;
        this.personalInformationDataToPersonalInformation = personalInformationDataToPersonalInformation;
    }

    public List<PersonalInformationData> getAllPersonalInformations(){
        return StreamSupport.stream( personalInformationRepository.findAll().spliterator(), false)
                .map(personalInfromationToPersonalInformationData::convert).collect(Collectors.toList());
    }

    public PersonalInformation savePersonalInformation(PersonalInformation personalInformation){
        return personalInformationRepository.save(personalInformation);
    }
}
