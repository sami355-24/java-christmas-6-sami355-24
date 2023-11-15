package christmas.Controller;

import static christmas.Message.Excepton.ExceptionPrompt.INVALID_DATE;
import static christmas.Message.Excepton.ExceptionPrompt.INVALID_MENU;

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
                System.out.println(INVALID_DATE.getPrompt());
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
                System.out.println(INVALID_MENU.getPrompt());
            }
        } while (reservedMenuGroup == null);
        return reservedMenuGroup;
    }
}
