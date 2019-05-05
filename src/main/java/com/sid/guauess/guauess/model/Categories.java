package com.sid.guauess.guauess.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Collection;
@Entity
@Getter
@Setter
public class Categories extends AbstractModel<Long> {
    private String intitule;

}
