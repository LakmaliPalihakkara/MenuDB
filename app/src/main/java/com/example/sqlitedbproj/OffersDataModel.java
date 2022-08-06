package com.example.sqlitedbproj;

public class OffersDataModel {

    private String promo_code;
    private String offer;
    private String expiry_date;

    public OffersDataModel() {
        // empty constructor required for firebase.
    }

    // constructor for our object class.
    public OffersDataModel(String promo_code, String offer, String expiry_date) {
        this.promo_code = promo_code;
        this.offer = offer;
        this.expiry_date = expiry_date;

    }

    public String getPromo_code() {
        return promo_code;
    }

    public void setPromo_code(String promo_code) {
        this.promo_code = promo_code;
    }

    public String getOffer() {
        return offer;
    }

    public void setOffer(String offer) {
        this.offer = offer;
    }

    public String getExpiry_date() {
        return expiry_date;
    }

    public void setExpiry_date(String expiry_date) {
        this.expiry_date = expiry_date;
    }

    // getter and setter methods

}
