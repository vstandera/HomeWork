package com.test.newsletter.converters;

import com.test.newsletter.data.PersonalInformationData;
import com.test.newsletter.domain.PersonalInformation;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PersonalInformationDataToPersonalInformation implements Converter<PersonalInformationData, PersonalInformation> {
    @Override
    public PersonalInformation convert(PersonalInformationData personalInformationData) {
        return PersonalInformation.builder().email(personalInformationData.getEmail())
                .firstName(personalInformationData.getFirstName())
                .lastName(personalInformationData.getLastName()).build();
    }
}
