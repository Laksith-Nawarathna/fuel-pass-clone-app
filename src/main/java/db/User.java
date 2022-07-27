package db;

import java.io.Serializable;

public class User implements Serializable {
    private String nic;
    private String firstName;
    private String lastName;
    private String adrress;

    public User() {
    }

    public User(String nic, String firstName, String lastName, String adrress) {
        this.nic = nic;
        this.firstName = firstName;
        this.lastName = lastName;
        this.adrress = adrress;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAdrress() {
        return adrress;
    }

    public void setAdrress(String adrress) {
        this.adrress = adrress;
    }
}
