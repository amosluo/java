package com.amos.bean;

import java.util.Date;

public class Pay {
    private Integer id;
    private Double payAmount;
    private Date payTime;
    private String payBy;

    public Pay() {
    }

    public Pay(Integer id, Double payAmount, Date payTime, String payBy) {
        this.id = id;
        this.payAmount = payAmount;
        this.payTime = payTime;
        this.payBy = payBy;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getPayAmount() {
        return payAmount;
    }

    public void setPayamount(Double payAmount) {
        this.payAmount = payAmount;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPaytime(Date payTime) {
        this.payTime = payTime;
    }

    public String getPayBy() {
        return payBy;
    }

    public void setPayBy(String payBy) {
        this.payBy = payBy;
    }

    @Override
    public String toString() {
        return "pay{" +
                "id=" + id +
                ", payAmount=" + payAmount +
                ", payTime=" + payTime +
                ", payBy='" + payBy + '\'' +
                '}';
    }
}
