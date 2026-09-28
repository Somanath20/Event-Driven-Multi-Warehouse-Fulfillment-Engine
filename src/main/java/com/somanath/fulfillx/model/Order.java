package com.somanath.fulfillx.model;
import jakarta.persistence.*; import java.time.Instant;
@Entity @Table(name="orders") public class Order{
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) Long id;
 @Column(nullable=false,unique=true) String orderNumber;
 @Enumerated(EnumType.STRING) Status status; @Column(nullable=false) String sku; int quantity; String warehouseCode; Instant updatedAt;
 protected Order(){} public Order(String no,String sku,int qty){orderNumber=no;this.sku=sku;quantity=qty;status=Status.PLACED;updatedAt=Instant.now();}
 public enum Status{PLACED,ALLOCATED,PICKED,PACKED,SHIPPED,DELIVERED,CANCELLED}
 public String getOrderNumber(){return orderNumber;} public Status getStatus(){return status;} public String getSku(){return sku;} public int getQuantity(){return quantity;} public String getWarehouseCode(){return warehouseCode;}
 public void allocate(String w){warehouseCode=w;transition(Status.ALLOCATED);} public void transition(Status next){status=next;updatedAt=Instant.now();}
}
