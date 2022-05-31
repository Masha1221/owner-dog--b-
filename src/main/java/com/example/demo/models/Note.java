package com.example.demo.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity(name = "notes")
@Accessors(chain = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "notes")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "note")
    private String note;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="user_ID",referencedColumnName = "id")
    private User user;

}