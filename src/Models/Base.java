package Models;

import Enums.CarStatus;
import Enums.TaxiDriverStatus;
import Exceptions.NotPossibleException;

public class Base {

    private String lokacioniIBazes;
    private String emriBazes;
    private Service services;
    private TaxiDriver driver;
    private Automobile automobile;


    public Base(String lokacioniIBazes, String emriBazes) {
        this.lokacioniIBazes = lokacioniIBazes;
        this.emriBazes = emriBazes;
    }

    // kjo metode shikon se a eshte makina ne servis apo mund ti jepet shoferit
    public void arrangeDriver(Automobile automobile, TaxiDriver taxiDriver) throws NotPossibleException {
        if (automobile.getStatus() == CarStatus.SERVICE || automobile.getStatus() == CarStatus.BUSY) {
            throw new NotPossibleException("Nuk mundet te aranzhohet sepse makina eshte ne servis ");
        }
        if (taxiDriver.getDriverStatus() == TaxiDriverStatus.BUSY || taxiDriver.getDriverStatus() == TaxiDriverStatus.IN_VACATION) {
            throw new NotPossibleException("Nuk mund te aranzhohet taksisti sepse eshte duke vozitur " +
                    "nje tjeter");
        }
        automobile.addTaxiDriver(taxiDriver);
        automobile.setStatus(CarStatus.BUSY);
        System.out.printf("Taksisti me emer %s u arranzhua ne taksin me tablen %s %n", taxiDriver.getName() +"  "+ taxiDriver.getSurname(), automobile.getNumberPlate());
    }

    public void sendAutomobileinService(Automobile automobile, Service servisi) throws NotPossibleException {
        servisi.addCarsInService(automobile);
        automobile.setStatus(CarStatus.SERVICE);
        System.out.println("Makina eshte derguat me sukses ne servis");
    }

    public Service getCarsInServices() {
        return services;
    }

    public void setCarsInServices(Service services) {
        this.services = services;
    }

    public void getAutomobilefromService(Automobile automobile, Service service) throws NotPossibleException {
        if (service.getAllAutomobilesinService() == null) {
            throw new NotPossibleException("Asnje makine nuk gjendet ne servis");
        }
        service.removeCarsfromService(automobile);
        automobile.setStatus(CarStatus.AVAILABLE);
        System.out.println("Makina eshte marr me sukses nga servisi");
    }
}
