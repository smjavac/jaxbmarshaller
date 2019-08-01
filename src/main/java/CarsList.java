
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "Cars")
public class CarsList {
    List<Cars> carsList = new ArrayList<Cars>();

    @XmlElement (name = "car")
    public List<Cars> getCarsList()                   { return carsList; }
    public void       setCarsList(List<Cars> carsList) { this.carsList = carsList; }

}
