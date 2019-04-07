package com.worxfr.pojo;

import java.util.Date;

public class Impower {
    private Long id;

    private Long fromId;

    private Long toId;

    private Date impowerTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFromId() {
        return fromId;
    }

    public void setFromId(Long fromId) {
        this.fromId = fromId;
    }

    public Long getToId() {
        return toId;
    }

    public void setToId(Long toId) {
        this.toId = toId;
    }

    public Date getImpowerTime() {
        return impowerTime;
    }

    public void setImpowerTime(Date impowerTime) {
        this.impowerTime = impowerTime;
    }
}