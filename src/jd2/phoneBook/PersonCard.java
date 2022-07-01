package jd2.phoneBook;

public class PersonCard {

    public String firstname;
    public String lastname;
    public String email;
    public int phoneNumber;
    PersonCard next;

    public PersonCard(String firstname, String lastname, String email, int phoneNumber) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public PersonCard() {
    }

    @Override
    public String toString() {
        return "PersonCard{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
