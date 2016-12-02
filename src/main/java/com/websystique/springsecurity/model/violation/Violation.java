package com.websystique.springsecurity.model.violation;


import com.websystique.springsecurity.model.Ticket;
import com.websystique.springsecurity.model.action.Action;

import javax.persistence.*;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by Pavel on 12.10.2016.
 */

@Entity
@Table(name = "violation", uniqueConstraints = {
        @UniqueConstraint(columnNames = "type")})
public class Violation {

    private Long id;
    private ViolationEnum type;
    private String description;
    private double fee;
    private Set<Action> actions;
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

    @Column(name = "type", unique = true, nullable = false, length = 128)
    public ViolationEnum getType() {
        return this.type;
    }

    public void setType(ViolationEnum type) {
        this.type = type;
    }

    @Column(name = "description", nullable = false, length = 512)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "fee", nullable = false)
    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "violation_2_action", joinColumns = {
            @JoinColumn(name = "violation_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "action_id",
                    nullable = false, updatable = false)})
    public Set<Action> getActions() {
        return actions;
    }

    public void setActions(Set<Action> actions) {
        this.actions = actions;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "violation")
    public Set<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }

    @Override
    public String toString() {
        return "Violation{" +
                "id=" + id +
                ", type=" + type +
                ", description='" + description + '\'' +
                ", fee=" + fee +
                '}';
    }

    public Violation() {

    }
}
