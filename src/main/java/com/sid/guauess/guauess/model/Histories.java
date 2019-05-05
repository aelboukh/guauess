package com.sid.guauess.guauess.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Histories extends AbstractModel<Long> {

    private Date date_arr;
    private int num_arr;
    private Date date_ex_comm;
    private int num_comm;
    private Date date_env;
    private int num_env;
    private Date addedDate;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="project_id",referencedColumnName = ("id") )
    private Projects project;

}
