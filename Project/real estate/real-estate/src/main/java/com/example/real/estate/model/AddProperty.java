package com.example.real.estate.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Add_property")
public class AddProperty {
    
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String title;
        
        private String Description;
        private String size;
        private String price;
        private String address;
        private String profilepic;
     
        
        public Long getId( ) {
            return id;
        }
        public void setId(Long id) {
            this.id = id;
        }
        public String getTitle(){
            return title;
        }
        public void setTitle(String title){
            this.title = title;
        }
        
        public String getDescription(){
            return Description;
        }
        public void setDescription(String Description){
            this.Description = Description;
        }
        public String getSize(){
            return size;
        }
        public void setSize(String size){
            this.size = size;
        }
        public String getPrice(){
            return price;
        }
        public void setPrice(String price){
            this.price = price;
        }
        public String getAddress(){
            return address;
        }
        public void setAddress(String address){
            this.address = address;
        }
        public String getProfilepic(){
            return profilepic;
        }
        public void setProfilepic(String profilepic){
            this.profilepic = profilepic;
        }
        
     
    
    
        }