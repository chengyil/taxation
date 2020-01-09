package com.pajak.taxation.assessment.relief;

import java.math.BigDecimal;

public interface IRelief {
    public boolean fullfilled();
    public BigDecimal reliefAmount();
}
