package com.example.demo.entities;

import javax.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;
import java.util.List;

@Entity
@Accessors(chain = true)
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Integer age;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<NoteEntity> notes;
}