package com.pajak.taxation.assessment;

import com.pajak.taxation.models.Entity;
import com.pajak.taxation.services.AssessmentService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class IndividualAssessmentTests {

    @Test
    public void individalIncomeTaxForSingle() {
        Entity taxPayer = new Entity();
        taxPayer.setMonthlySalary(new BigDecimal(25000000));
        taxPayer.setMaritalStatus(Entity.MaritalStatus.SINGLE);
        IndividualAssessment individualAssessment = new IndividualAssessment(taxPayer, taxRates());
        assertThat(individualAssessment.totalPayable()).isEqualTo(new BigDecimal(31900000).setScale(2));
    }

    private List<TaxRate> taxRates() {
        List rates = new ArrayList<TaxRate>();
        rates.add(new TaxRate(BigDecimal.ZERO, new BigDecimal(50000000), new BigDecimal(0.05)));
        rates.add(new TaxRate(new BigDecimal(50000000), new BigDecimal(250000000),new BigDecimal(0.15)));
        rates.add(new TaxRate(new BigDecimal(250000000), new BigDecimal(500000000),new BigDecimal(0.25)));
        rates.add(new TaxRate(new BigDecimal(500000000), new BigDecimal(0.30)));
        return rates;
    }

    @Test
    public void individalIncomeTaxForMarried() {
        Entity taxPayer = new Entity();
        taxPayer.setMonthlySalary(new BigDecimal(6500000));
        taxPayer.setMaritalStatus(Entity.MaritalStatus.MARRIED);
        taxPayer.setDependent(1);
        IndividualAssessment individualAssessment = new IndividualAssessment(taxPayer, taxRates());
        assertThat(individualAssessment.totalPayable()).isEqualTo(new BigDecimal(750000).setScale(2));
    }
}
