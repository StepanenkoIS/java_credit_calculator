import ru.credit.console.service.Listener;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public class Main {
  public static void main(String[] args) throws JAXBException, IOException, InterruptedException {

    new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          Listener.listener();
        } catch (InterruptedException e) {
          e.printStackTrace();
        } catch (JAXBException e) {
          e.printStackTrace();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }).start();

    new Thread(new Runnable() {
      @Override
      public void run() {
        Listener.connect();
      }
    }).start();
  }
}
