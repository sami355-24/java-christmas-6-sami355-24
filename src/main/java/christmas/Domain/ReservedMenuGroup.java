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


}
