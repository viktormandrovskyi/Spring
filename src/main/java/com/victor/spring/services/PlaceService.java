package com.victor.spring.services;

import java.util.List;

import com.victor.spring.dao.IPlaceDao;
import com.victor.spring.entity.Place;

public class PlaceService implements IPlaceService {

    private IPlaceDao dao;
 
    public void setDao(IPlaceDao dao) {
        this.dao = dao;
    }
    
    public IPlaceDao getDao() {
        return dao;
    }

    public void addPlace(Place place) {
        dao.add(place);
    }

    public List<Place> getAllPlaces(Place place) {
        return dao.getAll(place);
    }

    public Place getPlaceById(String id) {
        return dao.getById(id);
    }

    public void updatePlace(Place place) {
        dao.update(place);
    }

    public void deletePlace(Place place) {
        dao.delete(place);
    }
}
