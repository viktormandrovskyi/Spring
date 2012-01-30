package com.victor.spring.dao;

import java.util.List;

import com.victor.spring.entity.Place;


public interface IPlaceDao {

    public void add(Place place);

    public List<Place> getAll(Place place);

    public Place getById(String id);

    public void update(Place place);

    public void delete(Place place);
}
