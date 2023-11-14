package christmas.Domain.ReservedMenuGroup;

import static christmas.Common.Utility.convertStringToInt;
import static christmas.Common.Validator.validateBlankInput;
import static christmas.Common.Validator.validateEmptyInput;
import static christmas.Domain.ReservedMenuGroup.ReservedMenuGroupValidator.hasValidMenuCount;
import static christmas.Domain.ReservedMenuGroup.ReservedMenuGroupValidator.hasValidMenuName;
import static christmas.Domain.ReservedMenuGroup.ReservedMenuGroupValidator.idDuplicateMenu;
import static christmas.Domain.ReservedMenuGroup.ReservedMenuGroupValidator.isValidFormat;
import static java.util.Collections.*;

import christmas.Domain.Menu;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class ReservedMenuGroup {

    static final String COMMA = ",";
    static final String HYPHEN = "-";
    static final int menu = 0;
    static final int count = 1;

    private final EnumMap<Menu, Integer> menuGroup;

    public ReservedMenuGroup(String menuInput) {
        this.menuGroup = new EnumMap<>(Menu.class);
        validate(menuInput);
        reserveMenu(menuInput);
    }

    private void validate(String menuInput) {
        validateBlankInput(menuInput);
        validateEmptyInput(menuInput);
        ReservedMenuGroupValidator.hasOnlyBeverages(menuInput);
        hasValidMenuName(menuInput);
        hasValidMenuCount(menuInput);
        isValidFormat(menuInput);
        idDuplicateMenu(menuInput);
    }

    private void reserveMenu(String menus) {
        List<String> dividedMenus = divideMenusByComma(menus);
        for (String menuWithCount : dividedMenus) {
            List<String> dividedMenuAndCount = divideMenuWithCountByHyphen(menuWithCount);

            menuGroup.put(
                    Menu.findMenuByName(dividedMenuAndCount.get(menu)),
                    convertStringToInt(dividedMenuAndCount.get(count))
            );
        }
    }

    static List<String> divideMenusByComma(String menuInput) {
        return List.of(menuInput.split(COMMA));
    }

    static List<String> divideMenuWithCountByHyphen(String menuAndCount) {
        return List.of(menuAndCount.split(HYPHEN));
    }

    public int countDessert(){
        return menuGroup.keySet().stream()
                .filter(Menu::isDessert)
                .mapToInt(menuGroup::get)
                .sum();
    }

    public int countMainDish(){
        return menuGroup.keySet().stream()
                .filter(Menu::isMainDish)
                .mapToInt(menuGroup::get)
                .sum();
    }

    public Map<Menu, Integer> getMenuGroup() {
        return unmodifiableMap(menuGroup);
    }
}
