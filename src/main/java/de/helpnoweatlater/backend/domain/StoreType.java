package de.helpnoweatlater.backend.domain;

public enum StoreType {
    COFFEE_STORE("COFFEE_STORE"),
    RESTAURANT("RESTAURANT"),
    SHOP("SHOP");


    private final String value;

    StoreType(String value){
        this.value = value;
    }

    public String value() {
        return value;
    }
}
