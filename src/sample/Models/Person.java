package sample.Models;

/**
 * Created by Fabrice on 19.06.2017.
 */
public class Person {

    private String id;
    private String name;
    private String vorname;
    private String email;
    private String telefonnummer;

    public Person(String id, String name, String vorname, String email, String telefonnummer) {
        this.id = id;
        this.name = name;
        this.vorname = vorname;
        this.email = email;
        this.telefonnummer = telefonnummer;
    }
}
