package org.eclipse.cargotracker.interfaces.booking.web;

import org.eclipse.cargotracker.interfaces.booking.facade.BookingServiceFacade;
import org.eclipse.cargotracker.interfaces.booking.facade.dto.CargoRoute;
import org.eclipse.cargotracker.interfaces.booking.facade.dto.Location;
import org.eclipse.cargotracker.interfaces.booking.facade.dto.RouteCandidate;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.primefaces.PrimeFaces;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class ChangeArrivalDeadlineDateTest {

    private ChangeArrivalDeadlineDate editor;
    private BookingFacadeFake facade;
    private DialogPrimeFaces primeFaces;

    @Before
    public void setUp() throws Exception {
        editor = new ChangeArrivalDeadlineDate();
        facade = new BookingFacadeFake();
        Field field = editor.getClass().getDeclaredField("bookingServiceFacade");
        field.setAccessible(true);
        field.set(editor, facade);
        primeFaces = new DialogPrimeFaces();
        PrimeFaces.setCurrent(primeFaces);
    }

    @After
    public void tearDown() {
        PrimeFaces.setCurrent(null);
    }

    @Test
    public void testLoadUsesTrackingIdAndDateOnlyDtoValue() {
        editor.setTrackingId("DEF789");
        facade.cargo = cargoWithDate("04/21/2026");

        editor.load();

        assertEquals("DEF789", facade.loadedTrackingId);
        assertSame(facade.cargo, editor.getCargo());
        assertEquals("04/21/2026",
                new SimpleDateFormat("MM/dd/yyyy").format(editor.getArrivalDeadlineDate()));
    }

    @Test
    public void testChangeDeadlineDelegatesSelectedDateAndClosesOnSuccess() {
        editor.setTrackingId("DEF789");
        Date selectedDate = new Date();
        editor.setArrivalDeadlineDate(selectedDate);

        editor.changeArrivalDeadline();

        assertEquals("DEF789", facade.changedTrackingId);
        assertSame(selectedDate, facade.changedDate);
        assertEquals(1, facade.changeCalls);
        assertEquals("DONE", primeFaces.closeResult);
    }

    @Test
    public void testMalformedDtoDateFailsExplicitly() {
        editor.setTrackingId("DEF789");
        facade.cargo = cargoWithDate("not a date");

        try {
            editor.load();
            fail("Malformed deadline must not be silently accepted");
        } catch (IllegalStateException expected) {
            assertTrue(expected.getMessage().contains("DEF789"));
        }
        assertNull(editor.getArrivalDeadlineDate());
    }

    @Test
    public void testInvalidCalendarDateIsRejected() {
        editor.setTrackingId("DEF789");
        facade.cargo = cargoWithDate("02/30/2026");

        try {
            editor.load();
            fail("Invalid calendar date must be rejected");
        } catch (IllegalStateException expected) {
            assertTrue(expected.getMessage().contains("DEF789"));
        }
        assertNull(editor.getArrivalDeadlineDate());
    }

    @Test
    public void testTrailingTextIsRejected() {
        editor.setTrackingId("DEF789");
        facade.cargo = cargoWithDate("04/21/2026garbage");

        try {
            editor.load();
            fail("Date-only DTO must not contain trailing text");
        } catch (IllegalStateException expected) {
            assertTrue(expected.getMessage().contains("DEF789"));
        }
        assertNull(editor.getArrivalDeadlineDate());
    }

    @Test
    public void testNullDateIsRejectedBeforeDelegation() {
        editor.setTrackingId("DEF789");

        try {
            editor.changeArrivalDeadline();
            fail("Null date must be rejected");
        } catch (IllegalArgumentException expected) {
            assertTrue(expected.getMessage().contains("deadline"));
        }
        assertEquals(0, facade.changeCalls);
        assertNull(primeFaces.closeResult);
    }

    @Test
    public void testFacadeFailureDoesNotCloseDialog() {
        editor.setTrackingId("DEF789");
        editor.setArrivalDeadlineDate(new Date());
        facade.failure = new IllegalStateException("Update failed");

        try {
            editor.changeArrivalDeadline();
            fail("Facade failure must be propagated");
        } catch (IllegalStateException expected) {
            assertSame(facade.failure, expected);
        }
        assertNull(primeFaces.closeResult);
    }

    private static CargoRoute cargoWithDate(final String date) {
        return new CargoRoute("DEF789", "USCHI", "FIHEL", new Date(),
                false, false, "", "") {
            @Override
            public String getArrivalDeadlineDate() {
                return date;
            }
        };
    }

    private static class DialogPrimeFaces extends PrimeFaces {
        private Object closeResult;

        @Override
        public Dialog dialog() {
            return new Dialog() {
                @Override
                public void closeDynamic(Object result) {
                    closeResult = result;
                }
            };
        }
    }

    private static class BookingFacadeFake implements BookingServiceFacade {
        private CargoRoute cargo;
        private String loadedTrackingId;
        private String changedTrackingId;
        private Date changedDate;
        private int changeCalls;
        private RuntimeException failure;

        @Override
        public CargoRoute loadCargoForRouting(String trackingId) {
            loadedTrackingId = trackingId;
            return cargo;
        }

        @Override
        public void changeDeadline(String trackingId, Date arrivalDeadline) {
            changeCalls++;
            if (failure != null) {
                throw failure;
            }
            changedTrackingId = trackingId;
            changedDate = arrivalDeadline;
        }

        @Override
        public String bookNewCargo(String origin, String destination, Date arrivalDeadline) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void assignCargoToRoute(String trackingId, RouteCandidate route) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void changeDestination(String trackingId, String destinationUnLocode) {
            throw new UnsupportedOperationException();
        }

        @Override
        public List<RouteCandidate> requestPossibleRoutesForCargo(String trackingId) {
            throw new UnsupportedOperationException();
        }

        @Override
        public List<Location> listShippingLocations() {
            throw new UnsupportedOperationException();
        }

        @Override
        public List<CargoRoute> listAllCargos() {
            throw new UnsupportedOperationException();
        }
    }
}
