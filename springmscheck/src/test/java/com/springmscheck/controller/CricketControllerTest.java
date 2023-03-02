package com.springmscheck.controller;

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

import com.springmscheck.controller.CricketController;
import com.springmscheck.entity.Cricket;
import com.springmscheck.service.CricketService;

@RunWith(MockitoJUnitRunner.class)
//@ExtendWith(MockitoExtension.class)
public class CricketControllerTest {
	@Mock
	private CricketService service;

	@InjectMocks
	private CricketController controller;
	
	private List<Cricket> prepareCricketRecords(){
		List<Cricket> cricket = new ArrayList<Cricket>();
		Cricket cricket1 = new Cricket(1L, "ZrXn5","H4qu9");
		Cricket cricket2 = new Cricket(2L, "Xp2cf","IsTkj");
		cricket.add(cricket1);
		cricket.add(cricket2);
		return cricket;
	}
	
	@Test
	public void testFetchAllPass() {
		Mockito
        .when(controller.fetchAll()).thenReturn(prepareCricketRecords());
		List<Cricket> cricket = prepareCricketRecords();
		List<Cricket> cricketFromController =  controller.fetchAll();
		for(int i=0; i<cricket.size();i++) {
			Assertions.assertEquals(cricket.get(i).getId(), cricketFromController.get(i).getId());
            Assertions.assertEquals(cricket.get(i).getBat(), cricketFromController.get(i).getBat());
            Assertions.assertEquals(cricket.get(i).getBall(), cricketFromController.get(i).getBall());
		}
		
	}

	@Test
	public void testFetchAllFailure() {
		Mockito
        .when(controller.fetchAll()).thenReturn(prepareCricketRecords());
		List<Cricket> cricket = null; //Intentionally made null to fail the test.
		List<Cricket> cricketFromController =  controller.fetchAll();
		Assertions.assertNotEquals(cricket, cricketFromController);
	}
	
	
	 @Test public void fetchByIdPass() { 
		 Mockito
	        .when(controller.fetchById(1L)).thenReturn(prepareCricketRecords().get(0));
			Cricket cricketById = prepareCricketRecords().get(0);
			Cricket cricketByIdFromController = controller.fetchById(1L);
			
			Assertions.assertEquals(cricketById.getId(), cricketByIdFromController.getId());
			
		     
			Assertions.assertEquals(cricketById.getBat(), cricketByIdFromController.getBat());
			Assertions.assertEquals(cricketById.getBall(), cricketByIdFromController.getBall());
	 }

	 @Test public void fetchByIdFailure() { 
		 Mockito
	        .when(controller.fetchById(1L)).thenReturn(prepareCricketRecords().get(0));
			Cricket cricketById = prepareCricketRecords().get(1);
			Cricket cricketByIdFromController = controller.fetchById(1L);
			
			Assertions.assertNotEquals(cricketById.getId(), cricketByIdFromController.getId());
			

        Assertions.assertNotEquals(cricketById.getBat(), cricketByIdFromController.getBat());
        Assertions.assertNotEquals(cricketById.getBall(), cricketByIdFromController.getBall());
	 }
	 
	 @Test
	 public void deletePass() { 
		 controller.delete(1L);
		 Assertions.assertTrue(true); // This line will be executed only if there is no error in calling the controller for delete as there is no return value.
	 }

	@Test
	public void createPass() {
		Cricket cricketToBeCreated = prepareCricketRecords().get(0);
		Cricket cricketReturned = prepareCricketRecords().get(0);
		cricketReturned.setId(7L); //Changed the ID.
		
		Mockito
			.when(controller.create(cricketToBeCreated)).thenReturn(cricketReturned);
		
		Cricket cricketFromController  = controller.create(cricketToBeCreated);
		Assertions.assertNotEquals(cricketToBeCreated.getId(), cricketFromController.getId()); //Since Id of created one is mocked as changed from within serviceid, it cannot be equal. 
		
        Assertions.assertEquals(cricketToBeCreated.getBat(), cricketFromController.getBat());
        Assertions.assertEquals(cricketToBeCreated.getBall(), cricketFromController.getBall());
	}
	
	@Test
	public void createFailure() {
		Cricket cricketToBeCreated = prepareCricketRecords().get(0);
		Cricket cricketReturned = null; // Intentionally left to null to fail the case. 
				
		Mockito
			.when(controller.create(cricketToBeCreated)).thenReturn(cricketReturned);
		
			Cricket cricketFromController  = controller.create(cricketToBeCreated);
		Assertions.assertNull(cricketFromController);
	}
	
	/*
	 * @Test public void update() { ResponseEntity<Object> responseObject = null;
	 * 
	 * Mockito.when(controller.update(cricketToBeUpdated,
	 * "")).thenReturn(responseObject); }
	 */	
}