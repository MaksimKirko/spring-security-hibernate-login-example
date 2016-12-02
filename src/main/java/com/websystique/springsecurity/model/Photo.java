package com.websystique.springsecurity.model;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by MadMax on 20.11.2016.
 */

@Entity
@Table(name = "photo")
public class Photo {

    private Long id;
    private byte[] photo;
    private Set<Ticket> tickets;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "photo", unique = true, nullable = false)
    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "violationPhotos")
    public Set<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }

    @Override
    public String toString() {
        return "Photo{" +
                "id=" + id +
                ", photo=" + Arrays.toString(photo) +
                '}';
    }

    public Photo() {

    }
}
