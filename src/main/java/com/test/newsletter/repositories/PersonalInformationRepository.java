package com.test.newsletter.repositories;

import com.test.newsletter.domain.PersonalInformation;
import org.springframework.data.repository.CrudRepository;

public interface PersonalInformationRepository extends CrudRepository<PersonalInformation,Long> {
}
