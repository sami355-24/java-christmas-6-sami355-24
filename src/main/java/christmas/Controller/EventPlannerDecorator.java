package christmas.Controller;

import christmas.Domain.ReservedDate;
import christmas.Exception.DateException;

public class EventPlannerDecorator extends EventPlanner {


    public EventPlannerDecorator(EventPlanner eventPlanner) {
        super();
    }

    @Override
    public ReservedDate reserveDate() {
        ReservedDate reservedDate = null;
        do {
            try {
                reservedDate = super.reserveDate();
            } catch (DateException e) {
                System.out.println(e.getMessage());
            }
        } while (reservedDate == null);
        return reservedDate;
    }
}
