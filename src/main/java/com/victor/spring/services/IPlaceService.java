package com.victor.spring.services;

import java.util.List;

import com.victor.spring.entity.Place;

public interface IPlaceService {
    public void addPlace(Place place);

    public List<Place> getAllPlaces(Place place);

    public Place getPlaceById(String id);

    public void updatePlace(Place place);

    public void deletePlace(Place place);
}
