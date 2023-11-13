package christmas.Domain;

import static christmas.Utility.Utility.convertStringToInt;
import static java.util.Collections.*;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class ReservedMenuGroup {

    private final EnumMap<Menu, Integer> menuGroup;
    private final String COMMA = ",";
    private final String HYPHEN = "-";
    private final int menu = 0;
    private final int count = 1;

    public ReservedMenuGroup(String menuInput) {
        this.menuGroup = new EnumMap<>(Menu.class);
        reserveMenu(menuInput);
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

    private List<String> divideMenusByComma(String menuInput) {
        return List.of(menuInput.split(COMMA));
    }

    private List<String> divideMenuWithCountByHyphen(String menuAndCount) {
        return List.of(menuAndCount.split(HYPHEN));
    }



    public Map<Menu, Integer> getMenuGroup() {
        return unmodifiableMap(menuGroup);
    }
}
