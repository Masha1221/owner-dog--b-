package com.example.demo.models;

import com.example.demo.models.User;
import javax.persistence.*;


@Entity
@Table(name = "notes")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "note")
    private String note;

    @ManyToOne
    @JoinColumn(name="user_ID")
    private User user;

    public Note() {
    }

    public String getNote() {
        return note;
    }

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
