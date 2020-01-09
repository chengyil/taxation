package com.pajak.taxation.assessment;

import com.pajak.taxation.models.Entity;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class IndividualAssessmentTests {

    @Test
    public void individalIncomeTaxForSingle() {
        Entity taxPayer = new Entity();
        taxPayer.setMonthlySalary(new BigDecimal(25000000));
        taxPayer.setMaritalStatus(Entity.MaritalStatus.SINGLE);
        IndividualAssessment individualAssessment = new IndividualAssessment(taxPayer);
        assertThat(individualAssessment.totalPayable()).isEqualTo(new BigDecimal(31900000).setScale(2));
    }

    @Test
    public void individalIncomeTaxForMarried() {
        Entity taxPayer = new Entity();
        taxPayer.setMonthlySalary(new BigDecimal(6500000));
        taxPayer.setMaritalStatus(Entity.MaritalStatus.MARRIED);
        taxPayer.setDependent(1);
        IndividualAssessment individualAssessment = new IndividualAssessment(taxPayer);
        assertThat(individualAssessment.totalPayable()).isEqualTo(new BigDecimal(750000).setScale(2));
    }
}
