package christmas.Domain;

import static christmas.Message.Excepton.ExceptionPrompt.INVALID_MENU;

public enum Menu {
    MUSHROOM_SOUP("애피타이저" ,"양송이스프", 6_000),
    TAPAS("애피타이저", "타파스", 5_500),
    CAESAR_SALAD("애피타이저", "시저샐러드", 8_000),

    T_BONE_STEAK("메인", "티본스테이크", 55_000),
    BARBECUE_RIB("메인", "바베큐립", 54_000),
    SEA_FOOD_PASTA("메인", "해산물파스타", 35_000),
    CHRISTMAS_PASTA("메인", "크리스마스파스타", 25_000),

    CHOCO_CAKE("디저트", "초코케이크", 15_000),
    ICE_CREAM("디저트", "아이스크림", 5_000),

    ZERO_COKE("음료", "제로콜라", 3_000),
    RED_WINE("음료", "레드와인", 60_000),
    CHAMPAGNE("음료", "샴페인", 25_000);

    private final String category;
    private final String name;
    private final int price;

    Menu(String category, String name, int price) {
        this.category = category;
        this.name = name;
        this.price = price;
    }

    public static Menu findMenuByName(String name) {
        for (Menu menu : Menu.values()) {
            if (menu.name.equals(name)) {
                return menu;
            }
        }
        throw new IllegalArgumentException(INVALID_MENU.getPrompt());
    }

    public static boolean isDessert(Menu menu) {
        return menu.category.equals("디저트");
    }

    public static boolean isMainDish(Menu menu) {
        return menu.category.equals("메인");
    }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
