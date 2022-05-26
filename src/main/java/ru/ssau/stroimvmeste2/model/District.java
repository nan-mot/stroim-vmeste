package ru.ssau.stroimvmeste2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;

@Entity
@Table
@Data
public class District {

    private final Integer id;


    private final String districtName;


    private final String districtDescription;

//    private List<User> districtUsers = new ArrayList<>();
//
//    private List<Project> districtProjects = new ArrayList<>();

}