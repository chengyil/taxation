package com.pajak.taxation.assessment.relief;

import com.pajak.taxation.models.Entity;

import java.math.BigDecimal;

public class IndividualRelief {
    public static BigDecimal reliefAmount(Entity entity)  {
        BigDecimal totalRelief = BigDecimal.ZERO;
        IRelief martialStatusRelief = new MaritalStatusRelief(entity);
        if(martialStatusRelief.fullfilled()) {
            totalRelief = totalRelief.add(martialStatusRelief.reliefAmount());
        }
        return totalRelief;
    }
}
