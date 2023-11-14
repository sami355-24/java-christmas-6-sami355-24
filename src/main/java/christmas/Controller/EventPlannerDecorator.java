package christmas.Controller;

import christmas.Domain.ReservedDate;
import christmas.Domain.ReservedMenuGroup.ReservedMenuGroup;
import christmas.Exception.CommonValidateException;
import christmas.Exception.DateException;
import christmas.Exception.MenuException;

public class EventPlannerDecorator extends EventPlanner {


    public EventPlannerDecorator() {
        super();
    }

    @Override
    public ReservedDate reserveDate() {
        ReservedDate reservedDate = null;
        do {
            try {
                reservedDate = super.reserveDate();
            } catch (DateException | CommonValidateException e) {
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
            } catch (MenuException | CommonValidateException e) {
                System.out.println(e.getMessage());
            }
        } while (reservedMenuGroup == null);
        return reservedMenuGroup;
    }
}
