package christmas.Domain.ReservedMenuGroup;

import static christmas.Domain.ReservedMenuGroup.ReservedMenuGroup.divideMenuWithCountByHyphen;
import static christmas.Domain.ReservedMenuGroup.ReservedMenuGroup.divideMenusByComma;
import static christmas.Domain.ReservedMenuGroup.ReservedMenuGroup.menu;
import static christmas.Message.Excepton.ExceptionPrompt.INVALID_MENU;

import christmas.Domain.Menu;
import christmas.Exception.MenuException;
import java.util.List;

public class ReservedMenuGroupValidator {

    private ReservedMenuGroupValidator() {
    }

    static void hasOnlyBeverages(String menuInput) {
        List<String> dividedMenus = divideMenusByComma(menuInput);
        for (String menuWithCount : dividedMenus) {
            List<String> dividedMenuAndCount = divideMenuWithCountByHyphen(menuWithCount);
            if (Menu.isBeverage(Menu.findMenuByName(dividedMenuAndCount.get(menu)))) {
                throw new MenuException(INVALID_MENU.getPrompt(), new IllegalArgumentException());
            }
        }
    }
}
