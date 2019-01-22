/**
 * Muzix Application domain class
 */
package com.stackroute.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Muzix {

    //Variables
    @Id
    private int trackId;
    private String trackName;
    private String comment;

    //Parameterized Constructor
    public Muzix(int trackId, String trackName, String comment) {
        this.trackId = trackId;
        this.trackName = trackName;
        this.comment = comment;
    }

    //Empty Constructor
    public Muzix() {
    }

    //Getters and Setters
    public int getTrackId() {
        return trackId;
    }

    public void setTrackId(int trackId) {
        this.trackId = trackId;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    //Overriding the toString method
    @Override
    public String toString() {
        return "Muzix{" +
                "trackId=" + trackId +
                ", trackName='" + trackName + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
