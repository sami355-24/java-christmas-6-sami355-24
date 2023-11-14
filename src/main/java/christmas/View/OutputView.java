package christmas.View;

import static christmas.Message.EventPlannerPrompt.GIFT_TITLE;
import static christmas.Message.EventPlannerPrompt.PREVIEW_EVENT_BENEFITS;
import static christmas.Message.EventPlannerPrompt.RESERVED_MENU;
import static christmas.Message.EventPlannerPrompt.RESERVED_MENU_TITLE;
import static christmas.Message.EventPlannerPrompt.TOTAL_PRICE;
import static christmas.Message.EventPlannerPrompt.TOTAL_PRICE_BEFORE_DISCOUNT_TITLE;
import static christmas.Message.EventPlannerPrompt.WELL_COME;

import christmas.Domain.Menu;
import christmas.Domain.ReservedMenuGroup.ReservedMenuGroup;
import java.util.Map;
import java.util.Map.Entry;

public class OutputView {

    public OutputView() {
    }

    public void welcomeMessage(){
        System.out.println(WELL_COME.getPrompt());
    }

    public void showPreviewReservedOrderMessage(int day){
        System.out.println(String.format(PREVIEW_EVENT_BENEFITS.getPrompt(), day));
    }

    public void showReservedMenu(ReservedMenuGroup menuGroup){
        System.out.println(RESERVED_MENU_TITLE.getPrompt());

        for (Entry<Menu, Integer> menu : menuGroup.getMenuGroup().entrySet()) {
            String menuName = menu.getKey().getName();
            Integer menuCount = menu.getValue();
            System.out.println(String.format(RESERVED_MENU.getPrompt(), menuName, menuCount));
        }
    }

    public void showTotalPriceBeforeDiscount(int totalPrice){
        System.out.println(TOTAL_PRICE_BEFORE_DISCOUNT_TITLE.getPrompt());
        System.out.println(String.format(TOTAL_PRICE.getPrompt(), totalPrice));
    }

    public void showGift(Map<String, Integer> gift){
        System.out.println(GIFT_TITLE.getPrompt());
        for (Entry<String, Integer> item : gift.entrySet()) {
            String menuName = item.getKey();
            Integer menuCount = item.getValue();
            System.out.println(String.format(RESERVED_MENU.getPrompt(), menuName, menuCount));
        }
    }
}
