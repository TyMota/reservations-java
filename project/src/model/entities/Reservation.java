package model.entities;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
    private Integer roomNumber;
    private Date checkIn;
    private Date checlOut;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");


    public Reservation(){}

    public Reservation(Integer roomNumber, Date checkIn, Date checlOut) {
        this.checkIn = checkIn;
        this.checlOut = checlOut;
        this.roomNumber = roomNumber;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheclOut() {
        return checlOut;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public long duration(){
        long diff = checlOut.getTime() - checkIn.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    public void updateDates(Date checkIn, Date checlOut){
        this.checkIn = checkIn;
        this.checlOut = checlOut;
    }

    @Override
    public String toString() {
        return "Romm: " + roomNumber + ", CheckIn: " + sdf.format(checkIn) + ", CheckOut:  " + sdf.format(checlOut) + ", " + duration() + " nights." ;
    }
}
