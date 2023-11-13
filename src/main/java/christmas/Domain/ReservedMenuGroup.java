package christmas.Domain;

import java.util.EnumMap;
import java.util.List;

public class ReservedMenuGroup {

    private final EnumMap<Menu, Integer> menuGroup;
    private final String COMMA = ",";
    private final String HYPHEN = "-";
    private final int menu = 0;
    private final int count = 1;

    public ReservedMenuGroup(String menuInput) {
        this.menuGroup = new EnumMap<>(Menu.class);
    }

    private void reserveMenu(String menus) {
        List<String> dividedMenus = divideMenusByComma(menus);
        for (String menuWithCount : dividedMenus) {
            List<String> dividedMenuAndCount = divideMenuWithCountByHyphen(menuWithCount);
            menuGroup.put(
                    Menu.valueOf(dividedMenuAndCount.get(menu)),
                    Integer.parseInt(dividedMenuAndCount.get(count))
            );
        }
    }

    private List<String> divideMenusByComma(String menuInput) {
        return List.of(menuInput.split(COMMA));
    }

    private List<String> divideMenuWithCountByHyphen(String menuAndCount) {
        return List.of(menuAndCount.split(HYPHEN));
    }
}
