package com.springmsholi.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
//import org.mockito.junit.jupiter.MockitoExtension;

import com.springmsholi.controller.HoliController;
import com.springmsholi.entity.Holi;
import com.springmsholi.service.HoliService;

@RunWith(MockitoJUnitRunner.class)
//@ExtendWith(MockitoExtension.class)
public class HoliControllerTest {
	@Mock
	private HoliService service;

	@InjectMocks
	private HoliController controller;
	
	private List<Holi> prepareHoliRecords(){
		List<Holi> holi = new ArrayList<Holi>();
		Holi holi1 = new Holi(1L, "vTHA6",50);
		Holi holi2 = new Holi(2L, "UG9GL",72);
		holi.add(holi1);
		holi.add(holi2);
		return holi;
	}
	
	@Test
	public void testFetchAllPass() {
		Mockito
        .when(controller.fetchAll()).thenReturn(prepareHoliRecords());
		List<Holi> holi = prepareHoliRecords();
		List<Holi> holiFromController =  controller.fetchAll();
		for(int i=0; i<holi.size();i++) {
			Assertions.assertEquals(holi.get(i).getId(), holiFromController.get(i).getId());
            Assertions.assertEquals(holi.get(i).getName(), holiFromController.get(i).getName());
            Assertions.assertEquals(holi.get(i).getColor(), holiFromController.get(i).getColor());
		}
		
	}

	@Test
	public void testFetchAllFailure() {
		Mockito
        .when(controller.fetchAll()).thenReturn(prepareHoliRecords());
		List<Holi> holi = null; //Intentionally made null to fail the test.
		List<Holi> holiFromController =  controller.fetchAll();
		Assertions.assertNotEquals(holi, holiFromController);
	}
	
	
	 @Test public void fetchByIdPass() { 
		 Mockito
	        .when(controller.fetchById(1L)).thenReturn(prepareHoliRecords().get(0));
			Holi holiById = prepareHoliRecords().get(0);
			Holi holiByIdFromController = controller.fetchById(1L);
			
			Assertions.assertEquals(holiById.getId(), holiByIdFromController.getId());
			
		     
			Assertions.assertEquals(holiById.getName(), holiByIdFromController.getName());
			Assertions.assertEquals(holiById.getColor(), holiByIdFromController.getColor());
	 }

	 @Test public void fetchByIdFailure() { 
		 Mockito
	        .when(controller.fetchById(1L)).thenReturn(prepareHoliRecords().get(0));
			Holi holiById = prepareHoliRecords().get(1);
			Holi holiByIdFromController = controller.fetchById(1L);
			
			Assertions.assertNotEquals(holiById.getId(), holiByIdFromController.getId());
			

        Assertions.assertNotEquals(holiById.getName(), holiByIdFromController.getName());
        Assertions.assertNotEquals(holiById.getColor(), holiByIdFromController.getColor());
	 }
	 
	 @Test
	 public void deletePass() { 
		 controller.delete(1L);
		 Assertions.assertTrue(true); // This line will be executed only if there is no error in calling the controller for delete as there is no return value.
	 }

	@Test
	public void createPass() {
		Holi holiToBeCreated = prepareHoliRecords().get(0);
		Holi holiReturned = prepareHoliRecords().get(0);
		holiReturned.setId(7L); //Changed the ID.
		
		Mockito
			.when(controller.create(holiToBeCreated)).thenReturn(holiReturned);
		
		Holi holiFromController  = controller.create(holiToBeCreated);
		Assertions.assertNotEquals(holiToBeCreated.getId(), holiFromController.getId()); //Since Id of created one is mocked as changed from within serviceid, it cannot be equal. 
		
        Assertions.assertEquals(holiToBeCreated.getName(), holiFromController.getName());
        Assertions.assertEquals(holiToBeCreated.getColor(), holiFromController.getColor());
	}
	
	@Test
	public void createFailure() {
		Holi holiToBeCreated = prepareHoliRecords().get(0);
		Holi holiReturned = null; // Intentionally left to null to fail the case. 
				
		Mockito
			.when(controller.create(holiToBeCreated)).thenReturn(holiReturned);
		
			Holi holiFromController  = controller.create(holiToBeCreated);
		Assertions.assertNull(holiFromController);
	}
	
	/*
	 * @Test public void update() { ResponseEntity<Object> responseObject = null;
	 * 
	 * Mockito.when(controller.update(holiToBeUpdated,
	 * "")).thenReturn(responseObject); }
	 */	
}