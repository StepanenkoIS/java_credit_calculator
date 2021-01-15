package ru.credit.calculator;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.Parameterized;
import ru.credit.calculator.application.Calculator;
import ru.credit.calculator.data.DataParameters;
import ru.credit.calculator.model.Credit;
import ru.credit.calculator.model.InitialParameters;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(value = Parameterized.class)
public class CalculatorTest {

  private InitialParameters prm;

  public CalculatorTest(DataParameters prm) {
    this.prm = prm.getPrm();
  }

  @Parameterized.Parameters
  public static List<DataParameters> data() {
    return DataParameters.getParameters();
  }

  @Test()
  public void testCalculatorNull() {
    List<Credit> credits = Calculator.calculateSchedule(prm);
    assertNotNull(credits);
  }

  @Test()
  public void testCalculatorEmpty() {
    List<Credit> credits = Calculator.calculateSchedule(prm);
    assertFalse(credits.isEmpty());
  }

  @Test()
  public void testCalculatorSize() {
    List<Credit> credits = Calculator.calculateSchedule(prm);
    assertEquals(prm.getNumberOfPeriods(), new BigDecimal(credits.size()));
  }

  @Test()
  public void testCalculatorLastDate() {
    List<Credit> credits = Calculator.calculateSchedule(prm);
    assertEquals(prm.getDate().plusMonths(credits.size()), YearMonth.parse(credits.get(credits.size() - 1).getDate()));
  }

  @Test()
  public void testCalculatorDate() {
    List<Credit> credits = Calculator.calculateSchedule(prm);
    credits.forEach(credit -> assertEquals(prm.getDate().plusMonths(credit.getIndex()), YearMonth.parse(credit.getDate())));
  }

  @Test()
  public void testCalculatorLoanSum() {
    List<Credit> credits = Calculator.calculateSchedule(prm);
    assertEquals(prm.getLoanSum(), calculationLoanSum(credits));
  }

  private BigDecimal calculationLoanSum(List<Credit> credits) {
    BigDecimal decimal = new BigDecimal("0.00").setScale(2, BigDecimal.ROUND_HALF_UP);
    for (Credit credit : credits) {
      decimal = decimal.add(credit.getRepayment());
    }
    return decimal;
  }
}
