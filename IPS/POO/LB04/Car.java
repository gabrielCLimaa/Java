
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class Car {
    private String license;
    private LocalDate registerDate = LocalDate.now();
    private String brand;
    private String model;

    public Car() {
    }

    public Car(String license,LocalDate registerDate , String brand, String model) {
        this.registerDate = registerDate;
        this.license = license;
        this.brand = brand;
        this.model = model;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {

        StringBuilder str = new StringBuilder();
        str.append("License: " + this.getLicense());
        str.append("\tRegister Date: " + this.registerDate);
        str.append("\tBrand: " + this.getBrand());
        str.append("\tModel: " + this.getModel());

        return str.toString();

    }

    @Override
    public int hashCode() {

        return license.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Car other = (Car) obj;
        if (!Objects.equals(this.license, other.license)) {
            return false;
        }
        return true;
    }
}
