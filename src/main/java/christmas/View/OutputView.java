package christmas.View;

import static christmas.Message.EventPlannerPrompt.PREVIEW_EVENT_BENEFITS;
import static christmas.Message.EventPlannerPrompt.WELL_COME;

public class OutputView {

    public OutputView() {
    }

    public void welcomeMessage(){
        System.out.println(WELL_COME.getPrompt());
    }

    public void showPreviewReservedOrderMessage(int day){
        System.out.println(String.format(PREVIEW_EVENT_BENEFITS.getPrompt(), day));
    }
}
