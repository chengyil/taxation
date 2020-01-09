package com.pajak.taxation.services;

import com.pajak.taxation.assessment.IndividualAssessment;
import com.pajak.taxation.models.Entity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AssessmentService {
    public BigDecimal perform(Entity entity){
        return new IndividualAssessment(entity).totalPayable();
    }
}
