package de.helpnoweatlater.backend.payment;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.paypal.orders.Order;
import com.paypal.orders.Payer;
import com.paypal.orders.PurchaseUnit;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@JsonIgnoreProperties
public class Payment {

    @Id
    private String id;

    private String orderId;

    private String createTime;
    private String updateTime;

    private String status;

    // Payer Information
    private Payer payer;


    private PurchaseUnit purchaseUnit;

    // can either be "tip" or "voucher"
    private String type;


    public static Payment fromOrder(Order order){
        PurchaseUnit purchaseUnit = order.purchaseUnits().get(0);
        return new Payment(order.id(),
                order.createTime(),
                order.updateTime(),
                order.status(),
                order.payer(),
                purchaseUnit,
                purchaseUnit.customId()
                );
    }

    private Payment(String orderId, String createTime, String updateTime, String status, Payer payer, PurchaseUnit purchaseUnit, String type) {
        this.orderId = orderId;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.status = status;
        this.payer = payer;
        this.purchaseUnit = purchaseUnit;
        this.type = type;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public String getStatus() {
        return status;
    }

    public Payer getPayer() {
        return payer;
    }

    public PurchaseUnit getPurchaseUnit() {
        return purchaseUnit;
    }

    public String getType() {
        return type;
    }
}
