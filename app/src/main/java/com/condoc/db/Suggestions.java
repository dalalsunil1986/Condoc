package com.condoc.db;

import com.easyliteorm.annotation.Entity;
import com.easyliteorm.annotation.GenerationType;
import com.easyliteorm.annotation.Id;

/**
 * Created by Jo on 3/13/2016.
 */
@Entity
public class Suggestions {
    @Id(strategy = GenerationType.AUTO)
    private int id;
    private String topic;
    private String summary;
    private String suggestedByDocId;
    private String suggestedDocName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getSuggestedByDocId() {
        return suggestedByDocId;
    }

    public void setSuggestedByDocId(String suggestedByDocId) {
        this.suggestedByDocId = suggestedByDocId;
    }

    public String getSuggestedDocName() {
        return suggestedDocName;
    }

    public void setSuggestedDocName(String suggestedDocName) {
        this.suggestedDocName = suggestedDocName;
    }
}
