package com.springpostnight.controller;

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
import org.mockito.junit.jupiter.MockitoExtension;

import com.springpostnight.entity.Fort;
import com.springpostnight.service.FortService;

@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
public class FortControllerTest {
	@Mock
	private FortService service;

	@InjectMocks
	private FortController controller;
	
	private List<Fort> prepareFortRecords(){
		List<Fort> fortList = new ArrayList<Fort>();
		Fort fort1 = new Fort(345345L, "yrKyI","zO1tL");
		Fort fort2 = new Fort(345344L, "M6YU4","foEoA");
		fortList.add(fort1);
		fortList.add(fort2);
		return fortList;
	}
	
	@Test
	public void testFetchAllPass() {
		Mockito
        .when(controller.fetchAll()).thenReturn(prepareFortRecords());
		List<Fort> fortList = prepareFortRecords();
		List<Fort> fortListFromController =  controller.fetchAll();
		for(int i=0; i<fortList.size();i++) {
			Assertions.assertEquals(fortList.get(i).getId(), fortListFromController.get(i).getId());
            Assertions.assertEquals(fortList.get(i).getName(), fortListFromController.get(i).getName());
            Assertions.assertEquals(fortList.get(i).getPlace(), fortListFromController.get(i).getPlace());
		}
		
	}

	@Test
	public void testFetchAllFailure() {
		Mockito
        .when(controller.fetchAll()).thenReturn(prepareFortRecords());
		List<Fort> fortList = null; //Intentionally made null to fail the test.
		List<Fort> fortListFromController =  controller.fetchAll();
		Assertions.assertNotEquals(fortList, fortListFromController);
	}
	
	
	 @Test public void fetchByIdPass() { 
		 Mockito
	        .when(controller.fetchById(345344L))
            .thenReturn(prepareFortRecords().get(0));

        Fort fortById = prepareFortRecords().get(0);
        Fort fortByIdFromController = controller.fetchById(345344L);
        
        Assertions.assertEquals(fortById.getId(), fortByIdFromController.getId());
        Assertions.assertEquals(fortById.getName(), fortByIdFromController.getName());
        Assertions.assertEquals(fortById.getPlace(), fortByIdFromController.getPlace());
		 
	 }

	 @Test public void fetchByIdFailure() { 
		Mockito
	        .when(controller.fetchById(345344L))
            .thenReturn(prepareFortRecords().get(0));

        Fort fortById = prepareFortRecords().get(1);
        Fort fortByIdFromController = controller.fetchById(345344L);
        
        Assertions.assertNotEquals(fortById.getId(), fortByIdFromController.getId());
        Assertions.assertNotEquals(fortById.getName(), fortByIdFromController.getName());
        Assertions.assertNotEquals(fortById.getPlace(), fortByIdFromController.getPlace());
		 
	 }
	 
	 @Test
	 public void deletePass() { 
		 controller.delete(345345L);
		 Assertions.assertTrue(true); // This line will be executed only if there is no error in calling the controller for delete as there is no return value.
	 }

	@Test
	public void createPass() {
		Fort fortToBeCreated 			= prepareFortRecords().get(0);
		Fort fortReturned = prepareFortRecords().get(0);
		fortReturned.setId(345348L); //Changed the ID.
		
		Mockito
			.when(controller.create(fortToBeCreated))
            .thenReturn(fortReturned);
		
		Fort fortFromController  = controller.create(fortToBeCreated);
		Assertions.assertNotEquals(fortToBeCreated.getId(), fortFromController.getId()); //Since Id of created one is mocked as changed from within serviceid, it cannot be equal.
        Assertions.assertEquals(fortToBeCreated.getName(), fortFromController.getName());
        Assertions.assertEquals(fortToBeCreated.getPlace(), fortFromController.getPlace());
	}
	
	@Test
	public void createFailure() {
		Fort fortToBeCreated = prepareFortRecords().get(0);
		Fort fortReturned = null; // Intentionally left to null to fail the case. 
				
		Mockito
			.when(controller.create(fortToBeCreated))
            .thenReturn(fortReturned);
		
		Fort fortFromController  = controller.create(fortToBeCreated);
		Assertions.assertNull(fortFromController);
	}
}
