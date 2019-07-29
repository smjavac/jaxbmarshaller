
import javax.xml.bind.annotation.*;
// определяем корневой элемент
@XmlRootElement(name = "Cars")

// определяем последовательность тегов в XML
@XmlType(propOrder = {"name", "year", "body", "engine", "transmission"})

public class Cars {
    private String name;
    private String year;
    private String body;
    private String engine;
    private String transmission;

    public Cars() {
    }

    public Cars(String name, String year, String body,
                String engine, String transmission) {
        this.year = year;
        this.name = name;
        this.body = body;
        this.engine = engine;
        this.transmission = transmission;
    }
    @XmlElement
    public String getName() {
        return name;
    }
    @XmlElement
    public String getYear() {
        return year;
    }
    @XmlElement
    public String getBody() {
        return body;
    }
    @XmlElement
    public String getEngine() {
        return engine;
    }
    @XmlElement
    public String getTransmission() {
        return transmission;
    }

    @Override
    public String toString() {
        return "Cars{" +
                "name='" + name + '\'' +
                ", year='" + year + '\'' +
                ", body='" + body + '\'' +
                ", engine='" + engine + '\'' +
                ", transmission='" + transmission + '\'' +
                '}';
    }
}
