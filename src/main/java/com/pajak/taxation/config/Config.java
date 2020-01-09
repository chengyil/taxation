package com.pajak.taxation.config;

import com.pajak.taxation.assessment.TaxRate;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties
public class Config {
    private List<TaxRate> taxrate;

    public List<TaxRate> getTaxrate() {
        return taxrate;
    }

    public void setTaxrate(List<TaxRate> taxrate) {
        this.taxrate = taxrate;
    }
}
