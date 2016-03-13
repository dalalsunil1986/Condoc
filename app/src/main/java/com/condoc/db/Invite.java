package com.condoc.db;

import com.easyliteorm.annotation.Entity;
import com.easyliteorm.annotation.GenerationType;
import com.easyliteorm.annotation.Id;

/**
 * Created by Jo on 3/13/2016.
 */
@Entity
public class Invite {
    @Id(strategy = GenerationType.AUTO)
    private int id;
    private int doctorId;
    private int conferenceId;
    private int senderAdminId;
    private Boolean accepted;

    public Boolean getAccepted() {
        return accepted;
    }

    public void setAccepted(Boolean accepted) {
        this.accepted = accepted;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public int getConferenceId() {
        return conferenceId;
    }

    public void setConferenceId(int conferenceId) {
        this.conferenceId = conferenceId;
    }

    public int getSenderAdminId() {
        return senderAdminId;
    }

    public void setSenderAdminId(int senderAdminId) {
        this.senderAdminId = senderAdminId;
    }
}
