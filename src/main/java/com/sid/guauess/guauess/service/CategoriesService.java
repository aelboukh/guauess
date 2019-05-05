package com.sid.guauess.guauess.service;

import com.sid.guauess.guauess.model.Categories;
import com.sid.guauess.guauess.repository.CategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


@Service
public class CategoriesService extends AbstractService<Categories, Long> {

    @Autowired
    private CategoriesRepository categoriesRepository;

    @Override
    protected JpaRepository<Categories, Long> getRepository() {
        return categoriesRepository;
    }


}
