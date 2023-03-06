package com.springthree.controller;

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

import com.springthree.entity.Building;
import com.springthree.service.BuildingService;

@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
public class BuildingControllerTest {
	@Mock
	private BuildingService service;

	@InjectMocks
	private BuildingController controller;
	
	private List<Building> prepareBuildingRecords(){
		List<Building> buildingList = new ArrayList<Building>();
		Building building1 = new Building(345345L, "Epd1r",63,true);
		Building building2 = new Building(345344L, "HSOYi",16,false);
		buildingList.add(building1);
		buildingList.add(building2);
		return buildingList;
	}
	
	@Test
	public void testFetchAllPass() {
		Mockito
        .when(controller.fetchAll()).thenReturn(prepareBuildingRecords());
		List<Building> buildingList = prepareBuildingRecords();
		List<Building> buildingListFromController =  controller.fetchAll();
		for(int i=0; i<buildingList.size();i++) {
			Assertions.assertEquals(buildingList.get(i).getId(), buildingListFromController.get(i).getId());
            Assertions.assertEquals(buildingList.get(i).getName(), buildingListFromController.get(i).getName());
            Assertions.assertEquals(buildingList.get(i).getFloor(), buildingListFromController.get(i).getFloor());
            Assertions.assertEquals(buildingList.get(i).getSold(), buildingListFromController.get(i).getSold());
		}
		
	}

	@Test
	public void testFetchAllFailure() {
		Mockito
        .when(controller.fetchAll()).thenReturn(prepareBuildingRecords());
		List<Building> buildingList = null; //Intentionally made null to fail the test.
		List<Building> buildingListFromController =  controller.fetchAll();
		Assertions.assertNotEquals(buildingList, buildingListFromController);
	}
	
	
	 @Test public void fetchByIdPass() { 
		 Mockito
	        .when(controller.fetchById(345344L))
            .thenReturn(prepareBuildingRecords().get(0));

        Building buildingById = prepareBuildingRecords().get(0);
        Building buildingByIdFromController = controller.fetchById(345344L);
        
        Assertions.assertEquals(buildingById.getId(), buildingByIdFromController.getId());
        Assertions.assertEquals(buildingById.getName(), buildingByIdFromController.getName());
        Assertions.assertEquals(buildingById.getFloor(), buildingByIdFromController.getFloor());
        Assertions.assertEquals(buildingById.getSold(), buildingByIdFromController.getSold());
		 
	 }

	 @Test public void fetchByIdFailure() { 
		Mockito
	        .when(controller.fetchById(345344L))
            .thenReturn(prepareBuildingRecords().get(0));

        Building buildingById = prepareBuildingRecords().get(1);
        Building buildingByIdFromController = controller.fetchById(345344L);
        
        Assertions.assertNotEquals(buildingById.getId(), buildingByIdFromController.getId());
        Assertions.assertNotEquals(buildingById.getName(), buildingByIdFromController.getName());
        Assertions.assertNotEquals(buildingById.getFloor(), buildingByIdFromController.getFloor());
        Assertions.assertNotEquals(buildingById.getSold(), buildingByIdFromController.getSold());
		 
	 }
	 
	 @Test
	 public void deletePass() { 
		 controller.delete(345345L);
		 Assertions.assertTrue(true); // This line will be executed only if there is no error in calling the controller for delete as there is no return value.
	 }

	@Test
	public void createPass() {
		Building buildingToBeCreated 			= prepareBuildingRecords().get(0);
		Building buildingReturned = prepareBuildingRecords().get(0);
		buildingReturned.setId(345348L); //Changed the ID.
		
		Mockito
			.when(controller.create(buildingToBeCreated))
            .thenReturn(buildingReturned);
		
		Building buildingFromController  = controller.create(buildingToBeCreated);
		Assertions.assertNotEquals(buildingToBeCreated.getId(), buildingFromController.getId()); //Since Id of created one is mocked as changed from within serviceid, it cannot be equal.
        Assertions.assertEquals(buildingToBeCreated.getName(), buildingFromController.getName());
        Assertions.assertEquals(buildingToBeCreated.getFloor(), buildingFromController.getFloor());
        Assertions.assertEquals(buildingToBeCreated.getSold(), buildingFromController.getSold());
	}
	
	@Test
	public void createFailure() {
		Building buildingToBeCreated = prepareBuildingRecords().get(0);
		Building buildingReturned = null; // Intentionally left to null to fail the case. 
				
		Mockito
			.when(controller.create(buildingToBeCreated))
            .thenReturn(buildingReturned);
		
		Building buildingFromController  = controller.create(buildingToBeCreated);
		Assertions.assertNull(buildingFromController);
	}
}
