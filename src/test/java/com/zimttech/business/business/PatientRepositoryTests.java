package com.zimttech.business.business;

import com.zimttech.business.business.model.Patient;
import com.zimttech.business.business.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@RequiredArgsConstructor
public class PatientRepositoryTests {

    @Autowired
    private PatientRepository underTest;

    @AfterEach
    void tearDown(){
        underTest.deleteAll();
    }

    @Test
    void itShouldCheckIfPatientExistsByID() {
        //given
        String nationalID = "00-000000A00";
        Patient patient = Patient
                .builder()
                .firstName("Demo")
                .lastName("Demo")
                .address("Demo")
                .age(34)
                .nationalID(nationalID)
                .build();
        underTest.save(patient);
        //when
        boolean expected = underTest.selectExistsNationalId(nationalID);
        //then
        assertThat(expected).isTrue();
    }



}
