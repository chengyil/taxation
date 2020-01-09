package com.pajak.taxation.assessment;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;

public class TaxRate {
    private BigDecimal min;
    private BigDecimal max;
    private BigDecimal rate;

    public TaxRate(BigDecimal min, BigDecimal max, BigDecimal rate) {
        this.min = min;
        this.max = max;
        this.rate = rate;
    }

    public TaxRate(BigDecimal min, BigDecimal rate) {
        this.min = min;
        this.rate = rate;
    }

    public BigDecimal getMin() {
        return min;
    }

    public void setMin(BigDecimal min) {
        this.min = min;
    }

    public BigDecimal getMax() {
        return max;
    }

    public void setMax(BigDecimal max) {
        this.max = max;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }
}
