package com.somanath.fulfillx.model;
import jakarta.persistence.*;
@Entity @Table(name="warehouses") public class Warehouse{
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) Long id;
 @Column(nullable=false,unique=true) String code; String city; double latitude,longitude; int capacity; int load;
 protected Warehouse(){} public Warehouse(String code,String city,double lat,double lon,int capacity,int load){this.code=code;this.city=city;this.latitude=lat;this.longitude=lon;this.capacity=capacity;this.load=load;}
 public String getCode(){return code;} public String getCity(){return city;} public double getLatitude(){return latitude;} public double getLongitude(){return longitude;} public int getCapacity(){return capacity;} public int getLoad(){return load;} public boolean canHandle(int q){return load+q<=capacity;} public void addLoad(int q){load+=q;}
}
