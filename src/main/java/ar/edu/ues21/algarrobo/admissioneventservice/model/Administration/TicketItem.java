package ar.edu.ues21.algarrobo.admissioneventservice.model.Administration;

import io.swagger.annotations.ApiModelProperty;

public class TicketItem {
    @ApiModelProperty(name = "id", example = "6045557")
    private Long id;

    @ApiModelProperty(name = "type", example = "T")
    private String type;

    @ApiModelProperty(name = "name", example = "V200001458739")
    private String name;

    @ApiModelProperty(name = "detail", example = "Aranceles WM-Abogacía-ED")
    private String detail;

    @ApiModelProperty(name = "totalAmount", example = "12831.21")
    private Long totalAmount;

    @ApiModelProperty(name = "date", example = "Aranceles WM-Abogacía-ED")
    private String date;

    @ApiModelProperty(name = "customer", example = "31319355")
    private String customer;

    @ApiModelProperty(name = "quantity", example = "1")
    private Long quantity;

    @ApiModelProperty(name = "transactionId", example = "091823098")
    private String transactionId;

    @ApiModelProperty(name = "status", example = "Pagada")
    private String status;

    @ApiModelProperty(name = "gatewayId", example = "21")
    private String gatewayId;

    @ApiModelProperty(name = "idRelation", example = "null")
    private String idRelation;

    @ApiModelProperty(name = "idDecidir", example = "null")
    private String idDecidir;

    @ApiModelProperty(name = "idHsbc", example = "null")
    private String idHsbc;

    @ApiModelProperty(name = "idGire", example = "null")
    private String idGire;

    @ApiModelProperty(name = "unitPrice", example = "12831.1")
    private Long unitPrice;

    @ApiModelProperty(name = "studenshipPercentage", example = "0")
    private Long studenshipPercentage;

    @ApiModelProperty(name = "discountPercentage", example = "0")
    private Long discountPercentage;

    @ApiModelProperty(name = "surchargeAmount", example = "-12392.3")
    private Long surchargeAmount;

    @ApiModelProperty(name = "surchargeInstallment", example = "null")
    private String surchargeInstallment;

    @ApiModelProperty(name = "surchargeCreditCard", example = "0")
    private Long surchargeCreditCard;

    @ApiModelProperty(name = "updated", example = "2020-06-29T22:52:37.767+0000")
    private String updated;

    @ApiModelProperty(name = "usrPortal", example = "SUPERUSUARIO")
    private String usrPortal;

    @ApiModelProperty(name = "balance", example = "-14999.2")
    private Long balance;

    @ApiModelProperty(name = "currencyPrice", example = "null")
    private String currencyPrice;

    @ApiModelProperty(name = "idPaypal", example = "null")
    private String idPaypal;

    @ApiModelProperty(name = "idMercadoPago", example = "102983019282")
    private String idMercadoPago;

    @ApiModelProperty(name = "productId", example = "null")
    private String productId;

    @ApiModelProperty(name = "subModalityId", example = "2")
    private Long subModalityId;

    @ApiModelProperty(name = "studyClassId", example = "1")
    private Long studyClassId;

    @ApiModelProperty(name = "careerId", example = "2")
    private Long careerId;

    @ApiModelProperty(name = "paymentDate", example = "2020-06-29T22:52:37.767+0000")
    private String paymentDate;

    @ApiModelProperty(name = "studentRecordId", example = "123457")
    private String studentRecordId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Long getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Long totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getGatewayId() {
        return gatewayId;
    }

    public void setGatewayId(String gatewayId) {
        this.gatewayId = gatewayId;
    }

    public String getIdRelation() {
        return idRelation;
    }

    public void setIdRelation(String idRelation) {
        this.idRelation = idRelation;
    }

    public String getIdDecidir() {
        return idDecidir;
    }

    public void setIdDecidir(String idDecidir) {
        this.idDecidir = idDecidir;
    }

    public String getIdHsbc() {
        return idHsbc;
    }

    public void setIdHsbc(String idHsbc) {
        this.idHsbc = idHsbc;
    }

    public String getIdGire() {
        return idGire;
    }

    public void setIdGire(String idGire) {
        this.idGire = idGire;
    }

    public Long getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Long unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Long getStudenshipPercentage() {
        return studenshipPercentage;
    }

    public void setStudenshipPercentage(Long studenshipPercentage) {
        this.studenshipPercentage = studenshipPercentage;
    }

    public Long getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(Long discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public Long getSurchargeAmount() {
        return surchargeAmount;
    }

    public void setSurchargeAmount(Long surchargeAmount) {
        this.surchargeAmount = surchargeAmount;
    }

    public String getSurchargeInstallment() {
        return surchargeInstallment;
    }

    public void setSurchargeInstallment(String surchargeInstallment) {
        this.surchargeInstallment = surchargeInstallment;
    }

    public Long getSurchargeCreditCard() {
        return surchargeCreditCard;
    }

    public void setSurchargeCreditCard(Long surchargeCreditCard) {
        this.surchargeCreditCard = surchargeCreditCard;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public String getUsrPortal() {
        return usrPortal;
    }

    public void setUsrPortal(String usrPortal) {
        this.usrPortal = usrPortal;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public String getCurrencyPrice() {
        return currencyPrice;
    }

    public void setCurrencyPrice(String currencyPrice) {
        this.currencyPrice = currencyPrice;
    }

    public String getIdPaypal() {
        return idPaypal;
    }

    public void setIdPaypal(String idPaypal) {
        this.idPaypal = idPaypal;
    }

    public String getIdMercadoPago() {
        return idMercadoPago;
    }

    public void setIdMercadoPago(String idMercadoPago) {
        this.idMercadoPago = idMercadoPago;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Long getSubModalityId() {
        return subModalityId;
    }

    public void setSubModalityId(Long subModalityId) {
        this.subModalityId = subModalityId;
    }

    public Long getStudyClassId() {
        return studyClassId;
    }

    public void setStudyClassId(Long studyClassId) {
        this.studyClassId = studyClassId;
    }

    public Long getCareerId() {
        return careerId;
    }

    public void setCareerId(Long careerId) {
        this.careerId = careerId;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getStudentRecordId() {
        return studentRecordId;
    }

    public void setStudentRecordId(String studentRecordId) {
        this.studentRecordId = studentRecordId;
    }
}
