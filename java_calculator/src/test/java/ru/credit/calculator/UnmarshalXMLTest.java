package ru.credit.calculator;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.Parameterized;
import ru.credit.calculator.data.DataParameters;
import ru.credit.calculator.service.ParsingXML;

import javax.xml.bind.JAXBException;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(value = Parameterized.class)
public class UnmarshalXMLTest {

  private DataParameters prm;

  public UnmarshalXMLTest(DataParameters prm) {
    this.prm = prm;
  }

  @Parameterized.Parameters
  public static List<DataParameters> data() {
    return DataParameters.getParameters();
  }

  @Test()
  public void testUnmarshalXML() throws JAXBException {
    Assert.assertEquals(prm.getPrm(), ParsingXML.unmarshalXML(prm.getPath()));
  }

}
