package com.pajak.taxation.assessment.relief;

import com.pajak.taxation.models.Entity;

import java.math.BigDecimal;

public class MaritalStatusRelief implements IRelief{
    private Entity entity;

    public MaritalStatusRelief(Entity entity) {
        this.entity = entity;
    }

    @Override
    public boolean fullfilled() {
        return entity.getMaritalStatus() == Entity.MaritalStatus.SINGLE ||
                entity.getMaritalStatus() == Entity.MaritalStatus.MARRIED;
    }

    @Override
    public BigDecimal reliefAmount() {
        BigDecimal martialStatusRelief;
        if(entity.getMaritalStatus() == Entity.MaritalStatus.SINGLE)
        {
            martialStatusRelief = new BigDecimal(54000000);
        } else {
            switch (entity.getDependent()) {
                case 0:
                    martialStatusRelief = new BigDecimal(58500000);
                    break;
                case 1:
                    martialStatusRelief = new BigDecimal(63000000);
                    break;
                case 2:
                    martialStatusRelief = new BigDecimal(67500000);
                    break;
                default:
                    martialStatusRelief = new BigDecimal(72000000);
                    break;

            }

        }
        return martialStatusRelief;
    }
}
