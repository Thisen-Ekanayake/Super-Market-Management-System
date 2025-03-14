package com.thisenekanayake.supermarket_management_system;

import jakarta.persistence.*;

@Entity
@Table(name = "customers")
public class CustomerEntity {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fullName")
    private String fullName;

    @Column(name = "address")
    private String address;

    @Column(name = "mobile_no")
    private Long mobile_no;

    @Column(name = "email")
    private String email;

    @Column(name = "nic")
    private long nic;

    public CustomerEntity() {
    }

    public CustomerEntity(Long id, String fullName, String address, Long mobile_no, String email, long nic) {
        this.id = id;
        this.fullName = fullName;
        this.address = address;
        this.mobile_no = mobile_no;
        this.email = email;
        this.nic = nic;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getfullName() {
        return fullName;
    }

    public void setfullName(String username) {
        this.fullName = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getMobile_no() {
        return mobile_no;
    }

    public void setMobile_no(Long mobile_no) {
        this.mobile_no = mobile_no;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getNic() {
        return nic;
    }

    public void setNic(long nic) {
        this.nic = nic;
    }
}