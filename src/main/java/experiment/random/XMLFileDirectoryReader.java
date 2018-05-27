package experiment.random;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created 5/21/2017 20:16
 *
 * @author Deepankar Sharma
 */
public class XMLFileDirectoryReader {

  public List<Document> getListOfXMLDocumentsFromDirectory(String pathToXMLDirectory) {
    List<Document> docList = new ArrayList<>();
    try{
      DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
      DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
      Stream<Path> files = Files.walk(Paths.get(pathToXMLDirectory));
      files.filter(file -> Files.isRegularFile(file)).forEach(file ->  {
        try {
          System.out.println(file.getFileName());
          docList.add(documentBuilder.parse(file.toFile()));
        } catch (IOException e) {
          System.out.println("IOE while reading the file" + e);
        } catch (SAXException e) {
          System.out.println("SAXE while parsing document" + file.getFileName() + "\n " + e);
        }
      });
    } catch (IOException e) {
      System.out.println("Exception occured while opening the directory");
    } catch (ParserConfigurationException e) {
      e.printStackTrace();
    }
    return docList;
  }

  public static void main(String[] args) {
    XMLFileDirectoryReader reader = new XMLFileDirectoryReader();
    List<Document> docList = reader.getListOfXMLDocumentsFromDirectory("D:\\xmlDir\\");
    docList.forEach(doc -> System.out.println(doc.getTextContent()));
  }

}
