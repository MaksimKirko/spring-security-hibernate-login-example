package com.websystique.springsecurity.model;


import com.websystique.springsecurity.model.violation.Violation;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by Pavel on 25.09.2016.
 */
@Entity
@Table(name = "ticket")
public class Ticket {

    private Long id;
    private TicketEnum type;
    private Set<Photo> violationPhotos;
    private Violation violation;
    private String licensePlate;
    private String address;
    private String location;
    private Date date;
    private String comment;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "type", unique = false, nullable = false, length = 128)
    public TicketEnum getType() {
        return type;
    }

    public void setType(TicketEnum type) {
        this.type = type;
    }

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "ticket_2_photo", joinColumns = {
            @JoinColumn(name = "ticket_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "photo_id",
                    nullable = false, updatable = false)})
    public Set<Photo> getViolationPhotos() {
        return violationPhotos;
    }

    public void setViolationPhotos(Set<Photo> violationPhotos) {
        this.violationPhotos = violationPhotos;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "violation_id", nullable = false, updatable = false)
    public Violation getViolation() {
        return violation;
    }

    public void setViolation(Violation violation) {
        this.violation = violation;
    }

    @Column(name = "license_plate", length = 128)
    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    @Column(name = "address", length = 256)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column(name = "location", length = 128)
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Column(name = "date")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Column(name = "comment", length = 512)
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", violation=" + violation +
                ", licensePlate='" + licensePlate + '\'' +
                ", address='" + address + '\'' +
                ", location='" + location + '\'' +
                ", date=" + date +
                ", comment='" + comment + '\'' +
                '}';
    }

    public Ticket() {

    }

}
