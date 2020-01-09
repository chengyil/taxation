package com.pajak.taxation.models;

import java.math.BigDecimal;

public class Entity {
    public enum MaritalStatus {
        SINGLE("Single"),
        MARRIED("Married");

        private String displayValue;

        MaritalStatus(String displayValue) {
            this.displayValue = displayValue;
        }

        public String getDisplayValue() {
            return displayValue;
        }
    }
    private BigDecimal monthlySalary;
    private MaritalStatus maritalStatus;
    private Integer dependent;

    public BigDecimal getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(BigDecimal monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public Integer getDependent() {
        return dependent;
    }

    public void setDependent(Integer dependent) {
        this.dependent = dependent;
    }
}
