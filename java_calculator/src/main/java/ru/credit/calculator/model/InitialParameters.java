package ru.credit.calculator.model;

import ru.credit.calculator.service.model.YearMonthAdaptor;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.math.BigDecimal;
import java.time.YearMonth;


@XmlRootElement(name = "InitialParameters")
@XmlType(propOrder = {"modelCredit", "loanSum", "numberOfPeriods", "interestRate", "date"})
@XmlAccessorType(XmlAccessType.FIELD)
public class InitialParameters {

  private String modelCredit;
  private BigDecimal loanSum; //первоначальная сумма кредита
  private BigDecimal numberOfPeriods; //количество пеиодов (месяцев)
  private BigDecimal interestRate; //годовая процентная ставка

  @XmlJavaTypeAdapter(YearMonthAdaptor.class)
  private YearMonth date;

  public String getModelCredit() {
    return modelCredit;
  }

  public void setModelCredit(String modelCredit) {
    this.modelCredit = modelCredit;
  }

  public BigDecimal getLoanSum() {
    return loanSum;
  }

  public void setLoanSum(BigDecimal loanSum) {
    this.loanSum = loanSum;
  }

  public BigDecimal getNumberOfPeriods() {
    return numberOfPeriods;
  }

  public void setNumberOfPeriods(BigDecimal numberOfPeriods) {
    this.numberOfPeriods = numberOfPeriods;
  }

  public BigDecimal getInterestRate() {
    return interestRate;
  }

  public void setInterestRate(BigDecimal interestRate) {
    this.interestRate = interestRate;
  }

  public YearMonth getDate() {
    return date;
  }

  public void setDate(YearMonth date) {
    this.date = date;
  }


  @Override
  public String toString() {
    return "InitialParameters{" +
        "modelCredit='" + modelCredit + '\'' +
        ", loanSum=" + loanSum +
        ", numberOfPeriods=" + numberOfPeriods +
        ", interestRate=" + interestRate +
        ", date=" + date +
        '}';
  }
}
