package com.InstiCab.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TripRequest {
    @Id
    private int tripRequestId;

    @ManyToOne
    private User user;

    @ManyToOne
    private Driver driver;

    @ManyToOne
    private Trip trip;

}
