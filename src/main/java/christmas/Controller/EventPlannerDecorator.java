package christmas.Controller;

import christmas.Domain.ReservedDate;
import christmas.Domain.ReservedMenuGroup.ReservedMenuGroup;
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

    @Override
    public ReservedMenuGroup reservedMenuGroup() {
        ReservedMenuGroup reservedMenuGroup = null;
        do {
            try {
                reservedMenuGroup = super.reservedMenuGroup();
            } catch (DateException e) {
                System.out.println(e.getMessage());
            }
        } while (reservedMenuGroup == null);
        return reservedMenuGroup;
    }
}
