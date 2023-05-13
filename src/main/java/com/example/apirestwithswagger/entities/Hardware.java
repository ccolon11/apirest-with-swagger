package com.example.apirestwithswagger.entities;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;


@Entity
@Table(name = "hardwares")
@ApiModel("Entity hardware products to represent a didactic element composed of tools and products, for " +
        "the construction and maintenance of buildings")
public class Hardware {

   // attributes
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @ApiModelProperty("Autoincremental dummy key type Long")
   private Long id;
   private String product;
   private String model;
   @ApiModelProperty("Price in dollars, with two decimal places using point (.) as separator")
   private Double price;
   private Boolean online;
   private Integer number;

   // constructors
   public Hardware() {  }

   public Hardware(Long id, String product, String model, Double price, Boolean online, Integer number) {
      this.id=id;
      this.product=product;
      this.model=model;
      this.price=price;
      this.online=online;
      this.number=number;
   }
   // getters and setters
   public Long getId() {return id;}

   public void setId(Long id) {this.id = id;}

   public String getProduct() {return product;}

   public void setProduct(String product) {this.product = product;}

   public String getModel() {return model;}

   public void setModel(String model) {this.model = model;}

   public Double getPrice() {return price;}

   public void setPrice(Double price) {this.price = price;}

   public Boolean getOnline() {return online;}

   public void setOnline(Boolean online) {this.online = online;}

   public void setNumber(Integer number) {this.number = number;}

   public Integer getNumber() {return number;}

   //methods
   public double getHardwareNumber() {
      double quantity = getNumber() ;
      return quantity;
   }
}
