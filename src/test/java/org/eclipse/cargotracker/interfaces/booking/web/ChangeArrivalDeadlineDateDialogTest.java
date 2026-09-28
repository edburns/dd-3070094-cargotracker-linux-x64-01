package org.eclipse.cargotracker.interfaces.booking.web;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.primefaces.PrimeFaces;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class ChangeArrivalDeadlineDateDialogTest {

    private ChangeArrivalDeadlineDateDialog dialog;
    private DialogPrimeFaces primeFaces;

    @Before
    public void setUp() {
        dialog = new ChangeArrivalDeadlineDateDialog();
        primeFaces = new DialogPrimeFaces();
        PrimeFaces.setCurrent(primeFaces);
    }

    @After
    public void tearDown() {
        PrimeFaces.setCurrent(null);
    }

    @Test
    public void testShowDialogOpensExpectedViewWithOptionsAndTrackingId() {
        dialog.showDialog("DEF789");

        assertEquals("/admin/dialogs/changeArrivalDeadlineDate.xhtml", primeFaces.openedOutcome);

        assertEquals(Boolean.TRUE, primeFaces.openedOptions.get("modal"));
        assertEquals(Boolean.TRUE, primeFaces.openedOptions.get("draggable"));
        assertEquals(Boolean.FALSE, primeFaces.openedOptions.get("resizable"));
        assertEquals(410, primeFaces.openedOptions.get("contentWidth"));
        assertEquals(280, primeFaces.openedOptions.get("contentHeight"));

        List<String> trackingIds = primeFaces.openedParams.get("trackingId");
        assertNotNull(trackingIds);
        assertEquals(1, trackingIds.size());
        assertEquals("DEF789", trackingIds.get(0));
    }

    @Test
    public void testCancelClosesDialogWithEmptyString() {
        dialog.cancel();

        assertEquals("", primeFaces.closeResult);
    }

    private static class DialogPrimeFaces extends PrimeFaces {
        private String openedOutcome;
        private Map<String, Object> openedOptions;
        private Map<String, List<String>> openedParams;
        private Object closeResult;

        @Override
        public Dialog dialog() {
            return new Dialog() {
                @Override
                public void openDynamic(String outcome, Map<String, Object> options, Map<String, List<String>> params) {
                    openedOutcome = outcome;
                    openedOptions = options;
                    openedParams = params;
                }

                @Override
                public void closeDynamic(Object result) {
                    closeResult = result;
                }
            };
        }
    }
}
