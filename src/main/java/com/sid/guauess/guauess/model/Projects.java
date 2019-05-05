package com.sid.guauess.guauess.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Collection;
import java.util.Date;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Projects extends AbstractModel<Long> {

    private String province;

    private String commune;
    private String consistance;
    private String situation;
    private String petitionnaire;

    private String architecte;

    private String igt_bet;
    private String rf_requisition;

    private String observation;

    private String adresse;
    private int num_titre_foncier;

    private String superficie;

    private String hauteur;
    private String c_e_s;

    private String c_o_s;

    private String vf_technicien;
    private String vl_agentGU;

    private String cat_proj;
    private Date addedDate;

    @OneToMany(mappedBy = "project")
    private Collection<Histories> histories;
}
