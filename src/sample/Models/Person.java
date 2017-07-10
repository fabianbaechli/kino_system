package sample.Models;

import java.util.UUID;

/**
 * Created by Fabrice on 19.06.2017.
 */
public class Person {

    private UUID id;
    public String name;
    public String vorname;
    public String email;
    public String telefonnummer;

    public Person( String name, String vorname, String email, String telefonnummer) {
        id = UUID.randomUUID();
        this.name = name;
        this.vorname = vorname;
        this.email = email;
        this.telefonnummer = telefonnummer;
    }

    public Person( String id, String name, String vorname, String email, String telefonnummer) {
        this.id = UUID.fromString(id);
        this.name = name;
        this.vorname = vorname;
        this.email = email;
        this.telefonnummer = telefonnummer;
    }

    public UUID getID() {
        return id;
    }
    @Override
    public String toString(){
        return name +" "+vorname;
    }
}
