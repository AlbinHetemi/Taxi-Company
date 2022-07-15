package Models;

import Enums.CarStatus;
import Exceptions.NotPossibleException;

import java.util.ArrayList;

public class Service {
    private String locationOfService;
    private int capacity = 10;
    private ArrayList<Automobile> automobiles;
    private String operator;

    private int nrAutomobile;

    public Service(String locationOfService, String operator) {
        this.locationOfService = locationOfService;
        this.operator = operator;
        automobiles = new ArrayList<>(capacity);
    }

    public void addCarsInService(Automobile automobile) throws NotPossibleException {
        if (nrAutomobile >= capacity) {
            throw new NotPossibleException("Servisi eshte i limituar ne 10 makina, ju lutem merrni nje makine" +
                    "nga servisi ose prisni");
        }
        automobiles.add(automobile);
        automobile.setStatus(CarStatus.SERVICE);
        nrAutomobile++;
    }

    public ArrayList<Automobile> getAllAutomobilesinService() {
        return automobiles;
    }

    public Automobile findAutomobileInService(Automobile automobile) throws NotPossibleException {
        for (Automobile automobile1 : getAllAutomobilesinService()) {
            if (automobile1.equals(automobile)) ;
            return automobile1;
        }
        throw new NotPossibleException("Makina nuk eshte ne servis");
    }

    public void removeCarsfromService(Automobile automobile) throws NotPossibleException {
        if (automobiles.isEmpty()) {
            throw new NotPossibleException("Nuk keni asnje makine ne servis");
        }
        automobiles.remove(automobile);
        nrAutomobile--;
    }

    public void showAllAutomobilesinService(){
        int counter = 1;
        for (Automobile automobile: getAllAutomobilesinService()){
            System.out.printf("Automobili i %d %n",counter);
            System.out.println(automobile);
            counter++;
            System.out.println();
        }
    }


    @Override
    public String toString() {
        return "Service{" +
                "locationOfService='" + locationOfService + '\'' +
                '}';
    }
}
