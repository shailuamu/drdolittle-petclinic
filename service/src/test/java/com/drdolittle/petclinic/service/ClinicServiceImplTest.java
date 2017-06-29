package com.drdolittle.petclinic.service;

import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.drdolittle.petclinic.petclinic.model.Owner;
import com.drdolittle.petclinic.petclinic.repository.OwnerRepository;
import com.drdolittle.petclinic.petclinic.repository.PetRepository;
import com.drdolittle.petclinic.petclinic.repository.PetTypeRepository;
import com.drdolittle.petclinic.petclinic.repository.SpecialtyRepository;
import com.drdolittle.petclinic.petclinic.repository.VetRepository;
import com.drdolittle.petclinic.petclinic.repository.VisitRepository;
import com.drdolittle.petclinic.petclinic.service.ClinicService;
import com.drdolittle.petclinic.petclinic.service.ClinicServiceImpl;

public class ClinicServiceImplTest {

	private PetRepository petRepository;
	private VetRepository vetRepository;
	private OwnerRepository ownerRepository;
	private VisitRepository visitRepository;
	private SpecialtyRepository specialtyRepository;
	private PetTypeRepository petTypeRepository;

	private ClinicService clinicService;

	@Before
	public void setUp() {
		petRepository = Mockito.mock(PetRepository.class);
		vetRepository = Mockito.mock(VetRepository.class);
		ownerRepository = Mockito.mock(OwnerRepository.class);
		visitRepository = Mockito.mock(VisitRepository.class);
		specialtyRepository = Mockito.mock(SpecialtyRepository.class);
		petTypeRepository = Mockito.mock(PetTypeRepository.class);
		clinicService = new ClinicServiceImpl(petRepository, vetRepository,
				ownerRepository, visitRepository, specialtyRepository,
				petTypeRepository);
	}

	@Test
	public void testHello() {
		Owner expectedOwner = new Owner();
		expectedOwner.setId(9);
		expectedOwner.setAddress("Test");
		expectedOwner.setCity("Pune");
		expectedOwner.setFirstName("Test 1");
		expectedOwner.setLastName("Test 2");
    	expectedOwner.setTelephone("123");
    	
    	when(ownerRepository.findById(9)).thenReturn(expectedOwner);
    	
    	Owner ownerResult = clinicService.findOwnerById(9);
    	assertTrue(null != ownerResult);
    	assertEquals(expectedOwner.getFirstName(), ownerResult.getFirstName());
	}

}