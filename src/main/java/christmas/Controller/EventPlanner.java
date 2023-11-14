package christmas.Controller;

import christmas.Domain.Calculator;
import christmas.Domain.ReservedDate;
import christmas.Domain.ReservedMenuGroup.ReservedMenuGroup;
import christmas.Domain.ReservedOrder;
import christmas.View.InputView;
import christmas.View.OutputView;

public class EventPlanner {

    private final InputView inputView;
    private final OutputView outputView;
    private final Calculator calculator;
    private ReservedDate reservedDate;
    private ReservedMenuGroup reservedMenuGroup;
    private ReservedOrder reservedOrder;

    public EventPlanner() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.calculator = new Calculator();
    }

    public void start(){
        init();
    }

    private void init() {
        outputView.welcomeMessage();
        reserveDate();
        reservedMenuGroup();
        this.reservedOrder = new ReservedOrder(reservedMenuGroup, reservedDate);
    }

    public void reserveDate(){
        String inputDay = inputView.inputDay();
        this.reservedDate = new ReservedDate(inputDay);
    }

    public void reservedMenuGroup(){
        String inputMenu = inputView.inputMenu();
        this.reservedMenuGroup = new ReservedMenuGroup(inputMenu);
    }
}
