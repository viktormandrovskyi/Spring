package com.victor.spring;

import java.util.List;

import javax.annotation.Resource;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.victor.spring.entity.Place;
import com.victor.spring.services.IPlaceService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/applicationContext.xml" })
@TransactionConfiguration(defaultRollback=false)
public class CinemaTest extends TestCase {

    @Resource
    private IPlaceService placeService;
     
    @Test
    @Transactional
    public void testCreateData() {
        Place place = new Place();
        place.setNumber(1);
        place.setOwner("Test");
        place.setPurchased(true);
        place.setReserved(false);
        placeService.addPlace(place);
        Assert.assertEquals(1, placeService.getAllPlaces(new Place()).size());
    }
    @Test
    @Transactional
    public void testRetrieveData() {
        List<Place> cinemaList = placeService.getAllPlaces(new Place());
        Assert.assertEquals(1, cinemaList.size());
        Place placeExpected = cinemaList.get(0);
        Place placeResult = placeService.getPlaceById(placeExpected.getId());
        Assert.assertEquals(placeExpected.getNumber(), placeResult.getNumber());
    }
    @Test
    @Transactional
    public void testUpdateData() {
        List<Place> placeList = placeService.getAllPlaces(new Place());
        Assert.assertEquals(1, placeList.size());
        Place placeExpected = placeList.get(0);
        placeExpected.setOwner("Owner");
        placeService.updatePlace(placeExpected);
        Place placeResult = placeService.getPlaceById(placeExpected.getId());
        Assert.assertEquals(placeExpected.getOwner(), placeResult.getOwner());

    }
    @Test
    @Transactional
    public void testDeleteData() {
        List<Place> placeList = placeService.getAllPlaces(new Place());
        Assert.assertEquals(1, placeList.size());
        Place placeExpected = placeList.get(0);
        placeService.deletePlace(placeExpected);
        Place placeResult = placeService.getPlaceById(placeExpected.getId());
        Assert.assertEquals(placeResult, null);
    }
}
