import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.io.File;
import java.util.List;


public class JaxbWorker {

    public static void main(String[] args) {
        // определяем название файла, куда будем сохранять
        String fileName = "cars.xml";

        //создаем объект Cars с какими-то данными
        List<Cars> carsList = new ArrayList<>();
        Cars car1 = new Cars("Mercedes-Benz", "2011", "sedan", "V8", "automatic");
        Cars car2 = new Cars("BMW", "2015", "sedan", "V6", "automatic");
        Cars car3 = new Cars("Porsche", "2017", "sedan", "V6", "automatic");
        Cars car4 = new Cars("Audi", "2010", "sedan", "V6", "automatic");
        Cars car5 = new Cars("Ford", "2018", "sedan", "1.6", "manual");
        Cars car6 = new Cars("Lada", "2019", "sedan", "1.6", "manual");
        Cars car7 = new Cars("BMW", "2017", "sedan", "V12", "automatic");
        Cars car8 = new Cars("Toyota", "2019", "sedan", "V6", "automatic");
        Cars car9 = new Cars("Land Rover", "2011", "crossover", "V6", "automatic");
        Cars car10 = new Cars("Kia", "2019", "sedan", "1.6", "manual");

        CarsList carsList1 = new CarsList();

        carsAdd(carsList1.getCarsList(), car1, car2, car3, car4, car5);
        carsAdd(carsList1.getCarsList(), car6, car7, car8, car9, car10);

        // сохраняем объект в XML файл
        convertObjectToXml(carsList1, fileName);
    }

    private static void carsAdd(List<Cars> carsList, Cars car1, Cars car2, Cars car3, Cars car4, Cars car5) {
        carsList.add(car1);
        carsList.add(car2);
        carsList.add(car3);
        carsList.add(car4);
        carsList.add(car5);
    }

    // сохраняем объект в XML файл

    private static void convertObjectToXml(CarsList car, String filePath) {
        try {
            JAXBContext context = JAXBContext.newInstance(CarsList.class);
            Marshaller marshaller = context.createMarshaller();
            // устанавливаем флаг для читабельного вывода XML в JAXB
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            // маршаллинг объекта в файл
            marshaller.marshal(car, new File(filePath));
        } catch (JAXBException e) {
            e.getMessage();
        }
    }

}
