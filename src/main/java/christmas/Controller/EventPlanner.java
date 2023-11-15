package christmas.Controller;

import camp.nextstep.edu.missionutils.Console;
import christmas.Domain.ReservedDate;
import christmas.Domain.ReservedMenuGroup.ReservedMenuGroup;
import christmas.Domain.ReservedOrder;
import christmas.View.InputView;
import christmas.View.OutputView;

public class EventPlanner {

    private final InputView inputView;
    private final OutputView outputView;
    private ReservedOrder reservedOrder;

    public EventPlanner() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void makeReservation() {
        outputView.welcomeMessage();
        initFromUserInput();
        outputView.showPreviewReservedOrderMessage(reservedOrder.getReservedDate());
        printReservedOrder();
    }

    private void printReservedOrder() {
        outputView.showReservedMenu(reservedOrder.getReservedMenuGroup());
        outputView.showTotalPriceBeforeDiscount(reservedOrder.getTotalPriceBeforeDiscount());
        outputView.showGift(reservedOrder.getGifts());
        outputView.showAppliedEventGroup(reservedOrder.getAppliedEvent());
        outputView.showTotalAppliedEventAmount(reservedOrder.getAppliedEvent().findTotalEventAmount());
        outputView.showTotalPriceAfterDiscount(reservedOrder.getTotalPriceAfterDiscount());
        outputView.showEventBadge(reservedOrder.getAppliedEvent().getBadge());
    }

    private void initFromUserInput() {
        ReservedMenuGroup reservedMenuGroup;
        ReservedDate reservedDate;
        reservedDate = reserveDate();
        reservedMenuGroup = reservedMenuGroup();
        this.reservedOrder = new ReservedOrder(reservedMenuGroup, reservedDate);
        Console.close();
    }

    public ReservedDate reserveDate() {
        String inputDay = inputView.inputDay();
        return new ReservedDate(inputDay);
    }

    public ReservedMenuGroup reservedMenuGroup() {
        String inputMenu = inputView.inputMenu();
        return new ReservedMenuGroup(inputMenu);
    }
}
