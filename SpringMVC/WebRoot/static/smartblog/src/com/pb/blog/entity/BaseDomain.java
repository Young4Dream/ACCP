package com.pb.blog.entity;

import java.io.Serializable;

public abstract class BaseDomain implements Serializable {
    protected String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    
}
