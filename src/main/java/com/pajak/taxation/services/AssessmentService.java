package com.pajak.taxation.services;

import com.pajak.taxation.assessment.Individual;
import com.pajak.taxation.assessment.TaxRate;
import com.pajak.taxation.models.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AssessmentService {
    public BigDecimal perform(Entity entity){
        return new Individual(entity).totalPayable();
    }
}
