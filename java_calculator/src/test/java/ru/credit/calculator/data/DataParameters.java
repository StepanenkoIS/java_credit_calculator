package ru.credit.calculator.data;

import ru.credit.calculator.model.InitialParameters;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

public class DataParameters {
  private InitialParameters prm;
  private String path;

  private DataParameters(InitialParameters prm, String path) {
    this.prm = prm;
    this.path = path;
  }

  public InitialParameters getPrm() {
    return prm;
  }

  public String getPath() {
    return path;
  }

  public static List<DataParameters> getParameters() {
    List<DataParameters> parameters = new ArrayList<>();

    parameters.add(new DataParameters(new InitialParameters()
        .setModelCredit("differentiated")
        .setLoanSum(new BigDecimal("1000000"))
        .setNumberOfPeriods(new BigDecimal("12"))
        .setInterestRate(new BigDecimal("12"))
        .setDate(YearMonth.of(2019, 3)), "src\\test\\resources\\parameters\\prm0.xml"));

    parameters.add(new DataParameters(new InitialParameters()
        .setModelCredit("differentiated")
        .setLoanSum(new BigDecimal("900000"))
        .setNumberOfPeriods(new BigDecimal("120"))
        .setInterestRate(new BigDecimal("15.70"))
        .setDate(YearMonth.of(2011, 5)), "src\\test\\resources\\parameters\\prm1.xml"));

    parameters.add(new DataParameters(new InitialParameters()
        .setModelCredit("differentiated")
        .setLoanSum(new BigDecimal("5879514342"))
        .setNumberOfPeriods(new BigDecimal("250"))
        .setInterestRate(new BigDecimal("20"))
        .setDate(YearMonth.of(2011, 2)), "src\\test\\resources\\parameters\\prm2.xml"));


    parameters.add(new DataParameters(new InitialParameters()
        .setModelCredit("authentic")
        .setLoanSum(new BigDecimal("313446645"))
        .setNumberOfPeriods(new BigDecimal("111"))
        .setInterestRate(new BigDecimal("20.5"))
        .setDate(YearMonth.of(2011, 12)), "src\\test\\resources\\parameters\\prm3.xml"));

    parameters.add(new DataParameters(new InitialParameters()
        .setModelCredit("authentic")
        .setLoanSum(new BigDecimal("1000"))
        .setNumberOfPeriods(new BigDecimal("170"))
        .setInterestRate(new BigDecimal("12"))
        .setDate(YearMonth.of(2000, 1)), "src\\test\\resources\\parameters\\prm4.xml"));


    return parameters;
  }
}
