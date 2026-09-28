package org.eclipse.cargotracker.interfaces.booking.facade.internal;

import org.eclipse.cargotracker.application.BookingService;
import org.eclipse.cargotracker.domain.model.cargo.Cargo;
import org.eclipse.cargotracker.domain.model.cargo.CargoRepository;
import org.eclipse.cargotracker.domain.model.cargo.Itinerary;
import org.eclipse.cargotracker.domain.model.cargo.TrackingId;
import org.eclipse.cargotracker.domain.model.location.UnLocode;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;

/**
 * Verifies that the facade only adapts types at the layer boundary when
 * changing a cargo arrival deadline.
 */
public class DefaultBookingServiceFacadeTest {

    private DefaultBookingServiceFacade facade;
    private BookingServiceSpy bookingService;

    @Before
    public void setUp() throws Exception {
        facade = new DefaultBookingServiceFacade();
        bookingService = new BookingServiceSpy();
        setField(facade, "bookingService", bookingService);
        setField(facade, "cargoRepository", new FailingCargoRepository());
    }

    @Test
    public void testChangeDeadlineDelegatesToBookingService() {
        Date deadline = new Date();

        facade.changeDeadline("ABC123", deadline);

        assertEquals(1, bookingService.changeDeadlineCalls);
        assertEquals(new TrackingId("ABC123"), bookingService.trackingId);
        assertSame(deadline, bookingService.deadline);
    }

    private static void setField(Object target, String name, Object value)
            throws Exception {
        Field field = target.getClass().getDeclaredField(name);
        field.setAccessible(true);
        field.set(target, value);
    }

    private static class BookingServiceSpy implements BookingService {

        private int changeDeadlineCalls = 0;
        private TrackingId trackingId;
        private Date deadline;

        @Override
        public TrackingId bookNewCargo(UnLocode origin, UnLocode destination,
                                       Date arrivalDeadline) {
            throw new UnsupportedOperationException();
        }

        @Override
        public List<Itinerary> requestPossibleRoutesForCargo(
                TrackingId trackingId) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void assignCargoToRoute(Itinerary itinerary,
                                       TrackingId trackingId) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void changeDestination(TrackingId trackingId, UnLocode unLocode) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void changeDeadline(TrackingId trackingId, Date deadline) {
            this.changeDeadlineCalls++;
            this.trackingId = trackingId;
            this.deadline = deadline;
        }
    }

    private static class FailingCargoRepository implements CargoRepository {

        @Override
        public Cargo find(TrackingId trackingId) {
            throw new UnsupportedOperationException(
                    "The facade must not load cargo.");
        }

        @Override
        public List<Cargo> findAll() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void store(Cargo cargo) {
            throw new UnsupportedOperationException(
                    "The facade must not store cargo.");
        }

        @Override
        public TrackingId nextTrackingId() {
            throw new UnsupportedOperationException();
        }

        @Override
        public List<TrackingId> getAllTrackingIds() {
            throw new UnsupportedOperationException();
        }
    }
}
