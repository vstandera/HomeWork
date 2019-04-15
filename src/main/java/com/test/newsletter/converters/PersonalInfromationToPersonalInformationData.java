package com.test.newsletter.converters;

import com.test.newsletter.data.PersonalInformationData;
import com.test.newsletter.domain.PersonalInformation;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PersonalInfromationToPersonalInformationData implements Converter<PersonalInformation, PersonalInformationData> {

    @Override
    public PersonalInformationData convert(PersonalInformation personalInformation) {
        return PersonalInformationData.builder().email(personalInformation.getEmail())
                .firstName(personalInformation.getFirstName())
                .lastName(personalInformation.getLastName()).build();
    }
}
