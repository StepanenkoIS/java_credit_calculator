package ru.credit.calculator;

import ru.credit.calculator.service.ParsingXML;
import ru.credit.calculator.application.Calculator;
import ru.credit.calculator.model.Credits;
import ru.credit.calculator.model.InitialParameters;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;


public class Main {
  public static void main(String[] args) throws JAXBException, FileNotFoundException {

    String pathParam = "src\\main\\resources\\parameters\\parameter.xml";
    InitialParameters parameter = ParsingXML.unmarshalXML(pathParam);

    String pathResult = "src\\main\\resources\\result\\credits.xml";
    ParsingXML.marshalXML(new Credits().setCredits(Calculator.calculateSchedule(parameter)), pathResult);

  }



}
