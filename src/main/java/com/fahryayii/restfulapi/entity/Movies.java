package com.fahryayii.restfulapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "mst_movies")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Movies {
    @Id
    @Column(name = "id_movies")
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private Float rating;
    private String image;
    private Date created_at;
    private Date updated_at;
}
