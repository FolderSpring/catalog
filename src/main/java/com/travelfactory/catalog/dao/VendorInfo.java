package com.travelfactory.catalog.dao;

import org.springframework.data.annotation.Id;

public class VendorInfo {

    @Id
    public transient String _id;
    public String id;
    public String name;
    public String roomNumber;
    public transient String vendor;
    public transient String date;

    public VendorInfo() {
    }

    public VendorInfo(String id, String name, String roomNumber, String vendor, String date) {
        this.id = id;
        this.name = name;
        this.roomNumber = roomNumber;
        this.vendor = vendor;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", roomNumber='" + roomNumber + '\'' +
                ", vendor='" + vendor + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

}
