package christmas.Domain.ReservedMenuGroup;

import static christmas.Common.Utility.convertStringToInt;
import static christmas.Domain.ReservedMenuGroup.ReservedMenuGroup.count;
import static christmas.Domain.ReservedMenuGroup.ReservedMenuGroup.divideMenuWithCountByHyphen;
import static christmas.Domain.ReservedMenuGroup.ReservedMenuGroup.divideMenusByComma;
import static christmas.Domain.ReservedMenuGroup.ReservedMenuGroup.menu;
import static christmas.Message.Excepton.ExceptionPrompt.INVALID_MENU;

import christmas.Domain.Menu;
import christmas.Exception.MenuException;
import java.util.List;
import java.util.regex.Pattern;

public class ReservedMenuGroupValidator {

    private static final int MAX_MENU_COUNT = 20;
    private static final int MIN_MENU_COUNT = 1;

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

    static void hasValidMenuName(String menuInput) {
        List<String> dividedMenus = divideMenusByComma(menuInput);
        for (String menuWithCount : dividedMenus) {
            List<String> dividedMenuAndCount = divideMenuWithCountByHyphen(menuWithCount);
            Menu.findMenuByName(dividedMenuAndCount.get(menu));
        }
    }

    static void hasValidMenuCount(String menuInput) {
        List<String> dividedMenus = divideMenusByComma(menuInput);
        int totalMenuCount = 0;

        for (String menuWithCount : dividedMenus) {
            List<String> dividedMenuAndCount = divideMenuWithCountByHyphen(menuWithCount);
            String menuCountString = dividedMenuAndCount.get(count);
            totalMenuCount += convertStringToInt(menuCountString);
        }

        if (totalMenuCount < MIN_MENU_COUNT || totalMenuCount > MAX_MENU_COUNT)
            throw new MenuException(INVALID_MENU.getPrompt(), new IllegalArgumentException());
    }

    static void isValidFormat(String menuInput) {
        String pattern = "^(.+)-(\\d+)$";
        Pattern r = Pattern.compile(pattern, Pattern.MULTILINE);

        List<String> dividedMenus = divideMenusByComma(menuInput);
        for (String menuWithCount : dividedMenus) {
            if (!r.matcher(menuWithCount).find()) {
                throw new MenuException(INVALID_MENU.getPrompt(), new IllegalArgumentException());
            }
        }
    }
}
