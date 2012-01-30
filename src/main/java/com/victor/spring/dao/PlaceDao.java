package com.victor.spring.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.victor.spring.entity.Place;

public final class PlaceDao implements IPlaceDao {
   
    private SessionFactory sessionFactory;
    
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }  

    public void add(Place place) {
        sessionFactory.getCurrentSession().save(place);
    }

    @SuppressWarnings("unchecked")
    public List<Place> getAll(Place place) {
        return sessionFactory.getCurrentSession().createCriteria(Place.class).list();
    }

    public Place getById(String id) {
        return (Place) sessionFactory.getCurrentSession().get(Place.class, id);
    }

    public void update(Place place) {
        sessionFactory.getCurrentSession().update(place);
    }

    public void delete(Place place) {
        sessionFactory.getCurrentSession().delete(place);
    }
}
