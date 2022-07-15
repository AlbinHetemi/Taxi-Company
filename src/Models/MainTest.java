package Models;

import Exceptions.NotPossibleException;

import java.time.LocalDate;

public class MainTest {
    public static void main(String[] args) throws NotPossibleException {
        //ketu do shtohen nga baza ku nepermjet bazes i jepet direksioni ku nje taksi mund te kete vetem
        // nje shofer dhe nje shofer mundet te kete vetem nje taksi, te gjitha keto jane te validuara ne menyre
        // qe mos te kete perzjerje
        Automobile automobili1 = new Automobile("Mercedes", "01-442-rks", "Green", "Diesel", "Sedan", "5",
                12);
        TaxiDriver taxiDriver = new TaxiDriver("Albin", "Hetemi", "Podujeve", 25, 2000, 11, "Bindi", true, LocalDate.now(), LocalDate.of(2000, 12, 12));
        Base baza1 = new Base("Podujeve","Baza1");
        Automobile automobile2 = new Automobile("Bmw", "01-442-rks", "Green", "Diesel", "Sedan", "5",
                12);
        TaxiDriver driverDyshi = new TaxiDriver("Albin", "Hetemi", "Podujeve", 25, 2000, 11, "Bindi", true, LocalDate.now(), LocalDate.of(2000, 12, 12));
        Service servisi1 = new Service("Podujeve", "Baki Automobile");
        baza1.arrangeDriver(automobile2,taxiDriver);
        // shembujt jane te komentuar per shkak qe mos te throwin exception
        // shembujt kur nje shofer nuk mund te kete dy taksi
//        baza1.arrangeDriver(automobili1,taxiDriver);
         // shembulli kur taksia nuk mund te kete dy shofer
//        baza1.arrangeDriver(automobile2,driverDyshi);
        // gjithashtu shoferi nuk mund ta marre taksin perderisa ajo eshte ne servis
        // as klienti nuk mund ta therras taksin e cila eshte e rezervuar apoo e cila eshte ne servis
        // dhe shume e shume validime te tjera
        taxiDriver.printoPersonin();
        System.out.println(automobili1.getStatus());
        Client client = new Client("Albin","Hetemi","Podujeve",20,2000,11,"044-1655-22",true,"Nuk ka");
        client.telefonoTaxin(automobili1);
        Client client2 = new Client("Albin","Hetemi","Podujeve",20,2000,11,"044-1655-22",true,"Nuk ka");
        // shih te gjitha automobilet ne servis
        servisi1.showAllAutomobilesinService();
        Automobile automobile3 = new Automobile("Bmw", "01-442-rks", "Green", "Diesel", "Sedan", "5",
                12);
        // automobili 3 ne servis
        baza1.sendAutomobileinService(automobile3,servisi1);
        System.out.println("Te gjitha automobilet ne servis");
        servisi1.showAllAutomobilesinService();
    }
}
