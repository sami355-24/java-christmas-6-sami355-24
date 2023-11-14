package christmas.View;

import static christmas.Message.EventPlannerPrompt.ASK_RESERVATION_DATE;
import static christmas.Message.EventPlannerPrompt.ASK_RESERVATION_MENU;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String inputDay(){
        System.out.println(ASK_RESERVATION_DATE.getPrompt());
        return Console.readLine();
    }

    public String inputMenu(){
        System.out.println(ASK_RESERVATION_MENU.getPrompt());
        return Console.readLine();
    }
}
