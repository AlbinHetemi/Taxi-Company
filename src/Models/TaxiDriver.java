package Models;

import Enums.TaxiDriverStatus;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Date;

public class TaxiDriver extends Person implements Comparable<TaxiDriver> {
    private String nickName;
    private Boolean driverLicense;

    private LocalDate employeeRegistration;

    private LocalDate employeePermit;

    private TaxiDriverStatus driverStatus;

    public TaxiDriver(String name, String surname, String location, int years, int birthYear, int ID, String nickName, Boolean driverLicense) {
        super(name, surname, location, years, birthYear, ID);
        this.nickName = nickName;
        this.driverLicense = driverLicense;
    }

    public TaxiDriver(String name, String surname, String location, int years, int birthYear, int ID, String nickName, Boolean driverLicense, LocalDate employeeRegistration, LocalDate employeePermit) {
        super(name, surname, location, years, birthYear, ID);
        this.nickName = nickName;
        this.driverLicense = driverLicense;
        this.employeeRegistration = employeeRegistration;
        this.employeePermit = employeePermit;
    }

    public LocalDate getEmployeeRegistration() {
        return employeeRegistration;
    }

    public void setEmployeeRegistration(LocalDate employeeRegistration) {
        this.employeeRegistration = employeeRegistration;
    }

    public LocalDate getEmployeePermit() {
        return employeePermit;
    }

    public void setEmployeePermit(LocalDate employeePermit) {
        this.employeePermit = employeePermit;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Boolean getDriverLicense() {
        return driverLicense;
    }

    public void setDriverLicense(Boolean driverLicense) {
        this.driverLicense = driverLicense;
    }


    public TaxiDriverStatus getDriverStatus() {
        return driverStatus;
    }

    public void setDriverStatus(TaxiDriverStatus driverStatus) {
        this.driverStatus = driverStatus;
    }

    @Override
    public void printoPersonin() {
        super.printoPersonin();
        System.out.printf("%n NickName i Shoferit: %s, Leja e shoferit: %s, Regjistrimi i Punetorit: %s" +
                "Dalja e Punetorit %s", getNickName(), getDriverLicense(), getEmployeeRegistration(), getEmployeePermit());
    }

    @Override
    public int compareTo(TaxiDriver o) {
        if (this.getDriverLicense() == o.getDriverLicense()) {
            return this.getName().compareTo(o.getName());
        }
        return this.getDriverLicense().compareTo(o.getDriverLicense());
    }
}
