package com.example.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity(name = "dogs")
@Accessors(chain = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "dogs")
public class DogEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int dogId;

    @Column(name = "name")
    private String dogName;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "owner_ID", referencedColumnName = "id")
    private OwnerEntity ownerEntity;
}

