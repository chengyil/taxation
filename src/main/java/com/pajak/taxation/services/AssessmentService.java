package com.pajak.taxation.services;

import com.pajak.taxation.assessment.IndividualAssessment;
import com.pajak.taxation.config.Config;
import com.pajak.taxation.assessment.TaxRate;
import com.pajak.taxation.assessment.relief.IndividualRelief;
import com.pajak.taxation.models.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
public class AssessmentService {
    @Autowired
    private Config config;

    private Entity entity;

    public BigDecimal perform(Entity entity){
        this.entity = entity;
        return new IndividualAssessment(entity, taxRates()).totalPayable();
    }

    private List<TaxRate> taxRates() {
        return config.getTaxrate();
    }
}
