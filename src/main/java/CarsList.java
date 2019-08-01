import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.*;



@XmlType(propOrder = {"carsList"})
@XmlSeeAlso(ArrayList.class)
@XmlRootElement(name = "List")
public class CarsList {

    private List<Cars> carsList = new ArrayList<>();

    public CarsList() {
    }

    @XmlElement(name = "Cars")
    public List<Cars> getCarsList() {
        return carsList;
    }

    public void setCarsList(List<Cars> carsList) {
        this.carsList = carsList;
    }
}
