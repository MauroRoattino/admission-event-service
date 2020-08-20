package ar.edu.ues21.algarrobo.admissioneventservice.model.Administration;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class TicketContent {

    @ApiModelProperty(name = "id", example = "1000902")
    private Long id;

    @ApiModelProperty(name = "transactionId", example = "8382828")
    private String transactionId;

    @ApiModelProperty(name = "gateway", example = "23")
    private String gateway;

    @ApiModelProperty(name = "totalAmount", example = "18923.64")
    private double totalAmount;

    @ApiModelProperty(name = "companyDocNumber", example = "null")
    private String companyDocNumber;

    @ApiModelProperty(name = "billingEmail", example = "null")
    private String billingEmail;

    @ApiModelProperty(name = "username", example = "YPELLERITE")
    private String username;

    @ApiModelProperty(name = "operator", example = "SUPERUSUARIO")
    private String operator;

    private List<TicketItem> items;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getGateway() {
        return gateway;
    }

    public void setGateway(String gateway) {
        this.gateway = gateway;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getCompanyDocNumber() {
        return companyDocNumber;
    }

    public void setCompanyDocNumber(String companyDocNumber) {
        this.companyDocNumber = companyDocNumber;
    }

    public String getBillingEmail() {
        return billingEmail;
    }

    public void setBillingEmail(String billingEmail) {
        this.billingEmail = billingEmail;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public List<TicketItem> getItems() {
        return items;
    }

    public void setItems(List<TicketItem> items) {
        this.items = items;
    }
}
