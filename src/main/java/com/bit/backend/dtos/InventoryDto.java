package com.bit.backend.dtos;

import java.time.LocalDate;

public class InventoryDto {

    private long id;
    private String productName;
    private String productCategory;
    private String supplier;
    private int productQty;
    private double purchasePrice;
    private double sellingPrice;
    private LocalDate expiryDate;
    private String productStatus;

    public InventoryDto() {
    }

    public InventoryDto(long id, String productName, String productCategory, String supplier, int productQty, double purchasePrice, double sellingPrice, LocalDate expiryDate, String productStatus) {
        this.id = id;
        this.productName = productName;
        this.productCategory = productCategory;
        this.supplier = supplier;
        this.productQty = productQty;
        this.purchasePrice = purchasePrice;
        this.sellingPrice = sellingPrice;
        this.expiryDate = expiryDate;
        this.productStatus = productStatus;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public int getProductQty() {
        return productQty;
    }

    public void setProductQty(int productQty) {
        this.productQty = productQty;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus;
    }
}
