package com.pajak.taxation;

import com.pajak.taxation.assessment.TaxRate;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
@ConfigurationPropertiesBinding
public class TaxRateConversation implements Converter<String, List<TaxRate>> {
    @Override
    public List<TaxRate> convert(String from) {
        List<TaxRate> taxRates = new ArrayList<TaxRate>();
        for(String taxDatas : from.split(":")) {
            String[] taxData = taxDatas.split(",");
            if(taxData.length == 3) {
                taxRates.add( new TaxRate( new BigDecimal(taxData[1]), new BigDecimal(taxData[2]), new BigDecimal(taxData[0])));
            } else {
                taxRates.add( new TaxRate( new BigDecimal(taxData[1]), new BigDecimal(taxData[0])));
            }
        }
        return taxRates;
    }
}
