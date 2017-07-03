package sample.ViewModels;

import java.util.UUID;

/**
 * Created by Fabrice on 19.06.2017.
 */
public class Reservation {

    UUID ReservationsID;
    UUID _personID;
    UUID _reservationsSitzplatzID;

    public Reservation(String id,String person,String reservationsSitzplatz){
        ReservationsID = UUID.fromString(id);
        _personID = UUID.fromString(person);
        _reservationsSitzplatzID = UUID.fromString(reservationsSitzplatz);
    }
}
