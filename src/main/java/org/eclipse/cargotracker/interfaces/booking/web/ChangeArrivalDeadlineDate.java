package org.eclipse.cargotracker.interfaces.booking.web;

import org.eclipse.cargotracker.interfaces.booking.facade.BookingServiceFacade;
import org.eclipse.cargotracker.interfaces.booking.facade.dto.CargoRoute;
import org.primefaces.PrimeFaces;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

@Named
@ViewScoped
public class ChangeArrivalDeadlineDate implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final String DATE_PATTERN = "MM/dd/yyyy";

    private String trackingId;
    private CargoRoute cargo;
    private Date arrivalDeadlineDate;

    @Inject
    private BookingServiceFacade bookingServiceFacade;

    public String getTrackingId() {
        return trackingId;
    }

    public void setTrackingId(String trackingId) {
        this.trackingId = trackingId;
    }

    public CargoRoute getCargo() {
        return cargo;
    }

    public Date getArrivalDeadlineDate() {
        return arrivalDeadlineDate;
    }

    public void setArrivalDeadlineDate(Date arrivalDeadlineDate) {
        this.arrivalDeadlineDate = arrivalDeadlineDate;
    }

    public void load() {
        cargo = bookingServiceFacade.loadCargoForRouting(trackingId);
        arrivalDeadlineDate = null;
        String date = cargo.getArrivalDeadlineDate();
        SimpleDateFormat format = new SimpleDateFormat(DATE_PATTERN);
        format.setLenient(false);
        ParsePosition position = new ParsePosition(0);
        Date parsed = date == null ? null : format.parse(date, position);
        if (parsed == null || position.getIndex() != date.length()) {
            throw new IllegalStateException("Invalid arrival deadline date '" + date
                    + "' for cargo " + trackingId + " (expected " + DATE_PATTERN + ")");
        }
        arrivalDeadlineDate = parsed;
    }

    public void changeArrivalDeadline() {
        if (arrivalDeadlineDate == null) {
            throw new IllegalArgumentException("Arrival deadline date is required");
        }
        bookingServiceFacade.changeDeadline(trackingId, arrivalDeadlineDate);
        PrimeFaces.current().dialog().closeDynamic("DONE");
    }
}
