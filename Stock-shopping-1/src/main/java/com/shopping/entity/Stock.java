package com.shopping.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;



@Entity
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long pId;
    @NotNull(message = "Quantity must be is mandatory")
    private int sQuantity;
    @NotNull
    private String sLocation;
    @NotNull
    private String sSupplier;
	public Stock(Long pId, int sQuantity, String sLocation, String sSupplier) {
		super();
		this.pId = pId;
		this.sQuantity = sQuantity;
		this.sLocation = sLocation;
		this.sSupplier = sSupplier;
	}
	public Stock() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getpId() {
		return pId;
	}
	public void setpId(Long pId) {
		this.pId = pId;
	}
	public int getsQuantity() {
		return sQuantity;
	}
	public void setsQuantity(int sQuantity) {
		this.sQuantity = sQuantity;
	}
	public String getsLocation() {
		return sLocation;
	}
	public void setsLocation(String sLocation) {
		this.sLocation = sLocation;
	}
	public String getsSupplier() {
		return sSupplier;
	}
	public void setsSupplier(String sSupplier) {
		this.sSupplier = sSupplier;
	}
	@Override
	public String toString() {
		return "Stock [pId=" + pId + ", sQuantity=" + sQuantity + ", sLocation=" + sLocation + ", sSupplier="
				+ sSupplier + "]";
	}

    
}
