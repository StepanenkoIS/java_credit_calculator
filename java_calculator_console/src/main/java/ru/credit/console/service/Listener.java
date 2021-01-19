package ru.credit.console.service;

import ru.credit.calculator.application.Calculator;
import ru.credit.calculator.model.Credits;
import ru.credit.calculator.model.InitialParameters;
import ru.credit.calculator.service.ParsingXML;

import javax.xml.bind.JAXBException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Listener {

  private static List<FileList> original = new ArrayList<>();

  public static List<FileList> getFilesParam() {
    List<FileList> fileLists = new ArrayList<>();
    String pathParam = "src\\main\\resources\\parameters\\";
    File[] files = new File(pathParam).listFiles(new FilenameFilter() {
      @Override
      public boolean accept(File dir, String name) {
        return name.endsWith(".xml");
      }
    });

    if (files != null) {
      for (File file:files) {
        FileList fileList = new FileList(file);
        fileLists.add(fileList);
      }
      return fileLists;
    } else {
      return null;
    }
  }

  public static void createFileCredit(File param) throws JAXBException, IOException {
    InitialParameters parameter = ParsingXML.unmarshalXML(param.getPath());
    String path = String.format("src\\main\\resources\\result\\credit-%s", param.getName());
    File pathResult = new File(path);
    if (pathResult.createNewFile()) {
      ParsingXML.marshalXML(new Credits().setCredits(Calculator.calculateSchedule(parameter)), pathResult.getCanonicalPath());
    } else {
      ParsingXML.marshalXML(new Credits().setCredits(Calculator.calculateSchedule(parameter)), pathResult.getCanonicalPath());
    }

  }

  public static void listener() throws InterruptedException, JAXBException, IOException {

    do {
      List<FileList> listen = checkFiles();
      if (listen == null || listen.isEmpty()) {
        Thread.sleep(100);
      } else {
        for (FileList file : listen) {
          Listener.createFileCredit(file.getFile());
        }
      }
    } while (true);

  }

  public static List<FileList> checkFiles() {
    List<FileList> files = getFilesParam();

    if (files == null) {
      return null;
    }

    if (original == null || original.isEmpty()) {
      original.addAll(files);
      return files;
    }

    List<FileList> listen = new ArrayList<>();
    for (FileList fileList:files) {
      if (!original.contains(fileList)){
        listen.add(fileList);
      }
    }
    original.addAll(listen);
    return listen;
  }

  public static void connect() {

    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
      String line;
      boolean flag = true;
      System.out.println("Для выхода введите 'exit'");

      while (flag) {
        try {
          if ("exit".equals((reader.readLine()))) {
            System.exit(0);
          }
        } catch (NumberFormatException ex) {
          System.out.println("Введенное значение неверно. Повторите ввод. \n");
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}



