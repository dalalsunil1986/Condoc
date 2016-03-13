package com.condoc.db;

import com.easyliteorm.annotation.Entity;
import com.easyliteorm.annotation.GenerationType;
import com.easyliteorm.annotation.Id;

import java.util.Date;

/**
 * Created by Jo on 3/13/2016.
 */
@Entity
public class Conference {
    @Id(strategy = GenerationType.AUTO)
    private int id;
    private String topic;
    private String summary;
    private Date date;
    private String location;

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
