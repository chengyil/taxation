package com.pajak.taxation.assessment;

import com.pajak.taxation.assessment.relief.IndividualRelief;
import com.pajak.taxation.models.Entity;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class IndividualAssessment {
    private Entity entity;
    private List<TaxRate> taxRates;

    public IndividualAssessment(Entity entity, List<TaxRate> taxRates) {
        this.entity = entity;
        this.taxRates = taxRates;
    }

    public BigDecimal assessableIncome() {
        return entity.getMonthlySalary().multiply(new BigDecimal(12)).subtract(calculateRelief());
    }

    public BigDecimal calculateRelief() {
        return IndividualRelief.reliefAmount(entity);
    }

    public BigDecimal totalPayable() {
        BigDecimal income = assessableIncome();
        BigDecimal payable = BigDecimal.ZERO, currentAssessable;
        for(TaxRate rate : this.taxRates) {
            if(income.compareTo(rate.getMin()) > 0)  {
                if(rate.getMax() == null || income.compareTo(rate.getMax()) < 0) {
                    currentAssessable = income.subtract(rate.getMin());
                } else {
                    currentAssessable = rate.getMax().subtract(rate.getMin());
                }
                payable = currentAssessable.multiply(rate.getRate()).add(payable);
            }
        }
        return payable.setScale(2, RoundingMode.HALF_UP);
    }
}
