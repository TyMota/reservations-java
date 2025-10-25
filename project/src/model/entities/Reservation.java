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

    public String updateDates(Date checkIn, Date checlOut){
        this.checkIn = checkIn;
        this.checlOut = checlOut;

        Date now = new Date();
        if (checkIn.before(now) || checlOut.before(now)) {
            return "Error in reservation: Reservation dates for update must be future.";
        } else if (!checlOut.after(checkIn)){
            return "Error in reservation: Check-out date must be after check-in date.";
        } else {
            this.checkIn = checkIn;
            this.checlOut = checlOut;
            return null;
        }
    }

    @Override
    public String toString() {
        return "Romm: " + roomNumber + ", CheckIn: " + sdf.format(checkIn) + ", CheckOut:  " + sdf.format(checlOut) + ", " + duration() + " nights." ;
    }
}
