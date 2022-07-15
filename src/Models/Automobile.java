package Models;

import Enums.CarStatus;
import Enums.TaxiDriverStatus;
import Exceptions.NotPossibleException;

import java.util.ArrayList;

public class Automobile implements Comparable<Automobile> {
    private String manufacturer;
    private String numberPlate;
    private String color;
    private String typeOfFuel;
    private String typeOfCar;
    private String seatNumbers;
    private int serialNumberInTaxi;
    private TaxiDriver taxiDriver;
    private final int MAX_DRIVERS = 1;
    private int nrTaxiDriver;
    private ArrayList<TaxiDriver> Drivers;

    private CarStatus status;


    public Automobile(String manufacturer, String numberPlate, String color, String typeOfFuel, String typeOfCar, String seatNumbers, int serialNumberInTaxi) {
        this.manufacturer = manufacturer;
        this.numberPlate = numberPlate;
        this.color = color;
        this.typeOfFuel = typeOfFuel;
        this.typeOfCar = typeOfCar;
        this.seatNumbers = seatNumbers;
        this.serialNumberInTaxi = serialNumberInTaxi;
        Drivers = new ArrayList<>(MAX_DRIVERS);
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTypeOfFuel() {
        return typeOfFuel;
    }

    public void setTypeOfFuel(String typeOfFuel) {
        this.typeOfFuel = typeOfFuel;
    }

    public String getTypeOfCar() {
        return typeOfCar;
    }

    public void setTypeOfCar(String typeOfCar) {
        this.typeOfCar = typeOfCar;
    }

    public String getSeatNumbers() {
        return seatNumbers;
    }

    public void setSeatNumbers(String seatNumbers) {
        this.seatNumbers = seatNumbers;
    }

    public int getSerialNumberInTaxi() {
        return serialNumberInTaxi;
    }

    public void setSerialNumberInTaxi(int serialNumberInTaxi) {
        this.serialNumberInTaxi = serialNumberInTaxi;
    }

    public TaxiDriver getTaxiDriver() {
        return taxiDriver;
    }

    public void setTaxiDriver(TaxiDriver taxiDriver) {
        this.taxiDriver = taxiDriver;
    }

    public ArrayList<TaxiDriver> getAllDrivers() {
        return Drivers;
    }

    public void addTaxiDriver(TaxiDriver taxiDriver) throws NotPossibleException {
        if (taxiDriver.getDriverStatus() == TaxiDriverStatus.BUSY || taxiDriver.getDriverStatus() == TaxiDriverStatus.IN_VACATION) {
            throw new NotPossibleException("Shoferi eshte i aranzhuar ne nje tjeter taksi");
        }
        if (nrTaxiDriver > MAX_DRIVERS) {
            throw new NotPossibleException("Makina nuk mund te kete me shume se 1 shofer");
        }
        Drivers.add(taxiDriver);
        taxiDriver.setDriverStatus(TaxiDriverStatus.BUSY);
        nrTaxiDriver++;
    }

    public void removeTaxiDriver(TaxiDriver taxiDriver) {
        Drivers.remove(taxiDriver);
        taxiDriver.setDriverStatus(TaxiDriverStatus.AVAILABLE);
        nrTaxiDriver--;
    }


    public CarStatus getStatus() {
        return status;
    }

    public void setStatus(CarStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Automobile{" +
                "manufacturer='" + manufacturer + '\'' +
                ", numberPlate='" + numberPlate + '\'' +
                ", color='" + color + '\'' +
                ", typeOfFuel='" + typeOfFuel + '\'' +
                ", typeOfCar='" + typeOfCar + '\'' +
                ", seatNumbers='" + seatNumbers + '\'' +
                ", serialNumberInTaxi=" + serialNumberInTaxi +
                '}';
    }

    @Override
    public int compareTo(Automobile o) {
        if (this.getNumberPlate() == o.getNumberPlate()) {
            return this.getColor().compareTo(o.getColor());
        }
        return this.getNumberPlate().compareTo(o.getNumberPlate());
    }
}
