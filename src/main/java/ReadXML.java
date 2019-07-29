import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.filter.ElementFilter;
import org.jdom2.input.SAXBuilder;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class ReadXML {

    public static void main(String[] args) {
        readXMLDocument();
    }

    private static void readXMLDocument() {
        SAXBuilder parser = new SAXBuilder();
        Document xmlDoc;
        try {
            xmlDoc = parser.build(new File("Cars.xml"));
            System.out.println("Cars:");

            // Получаем список всех элементов car, которые
            // содержит корневой элемент
            List elements = xmlDoc.getRootElement()
                    .getContent(new ElementFilter("car"));

            // Для каждого элемента car получаем вложенные элементы
            Iterator iterator = elements.iterator();
            while (iterator.hasNext()) {
                Element car = (Element) iterator.next();
                String name = car.getChildText("name");
                String year = car.getChildText("year");
                String body = car.getChildText("body");
                String engine = car.getChildText("engine");
                String transmission = car.getChildText("transmission");

                System.out.println(name + ": " + year + " " + body + " " + engine + " " + transmission);
            }
        } catch (JDOMException | IOException e) {
            e.getMessage();
        }
    }
}
