package Models;

import Enums.CarStatus;
import Enums.TaxiDriverStatus;
import Exceptions.NotPossibleException;
import Interfaces.telefono;

import java.util.ArrayList;

public class Client extends Person implements telefono {
    private String registerDate;
    private String clientNumberPhone;
    private boolean isActive;

    private String comment;

    private ArrayList<Automobile> taksisti;

    private int nrTaksit;


    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }


    public Client(String name, String surname, String location, int years, int birthYear, int ID, String clientNumberPhone, boolean isActive, String comment) {
        super(name, surname, location, years, birthYear, ID);
        this.clientNumberPhone = clientNumberPhone;
        this.isActive = isActive;
        this.comment = comment;
        taksisti = new ArrayList<>();
    }

    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }

    public String getClientNumberPhone() {
        return clientNumberPhone;
    }

    public void setClientNumberPhone(String clientNumberPhone) {
        this.clientNumberPhone = clientNumberPhone;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public ArrayList<Automobile> getTaksistat(){
        return taksisti;
    }
    @Override
    public void telefonoTaxin(Automobile automobile) throws NotPossibleException {
        if (automobile.getStatus() == CarStatus.BUSY || automobile.getStatus() == CarStatus.SERVICE) {
            throw new NotPossibleException("Taksia qe ju keni thirre eshte e zene per momentin");
        }
        System.out.println();
        System.out.println("Taksisti eshte thirrur me sukses");
        setActive(true);
        nrTaksit++;
    }
}
