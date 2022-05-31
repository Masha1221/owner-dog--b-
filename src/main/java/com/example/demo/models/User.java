package com.example.demo.models;

import javax.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;
import java.util.List;

@Entity
@Accessors(chain = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Integer age;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Note> notes;
}