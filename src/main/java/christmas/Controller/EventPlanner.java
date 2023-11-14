package christmas.Controller;

import christmas.Domain.ReservedDate;
import christmas.Domain.ReservedMenuGroup.ReservedMenuGroup;
import christmas.Domain.ReservedOrder;
import christmas.View.InputView;
import christmas.View.OutputView;

public class EventPlanner {

    private final InputView inputView;
    private final OutputView outputView;
    private ReservedDate reservedDate;
    private ReservedMenuGroup reservedMenuGroup;
    private ReservedOrder reservedOrder;

    public EventPlanner() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void start() {
        init();
        result();
    }

    private void result() {
        outputView.showPreviewReservedOrderMessage(reservedDate.getDay());
        outputView.showReservedMenu(reservedMenuGroup);
        outputView.showTotalPriceBeforeDiscount(reservedOrder.getTotalPriceBeforeDiscount());
        outputView.showGift(reservedOrder.getGifts());
        outputView.showBenefitRecords(reservedOrder.getBenefitRecord());
        outputView.showTotalBenefitPrice(reservedOrder.getBenefitRecord().getTotalBenefitPrice());
        outputView.showTotalPriceAfterDiscount(reservedOrder.getTotalPriceAfterDiscount());
        outputView.showEventBadge(reservedOrder.getBenefitRecord().getBadge());
    }

    private void init() {
        outputView.welcomeMessage();
        this.reservedDate = reserveDate();
        this.reservedMenuGroup = reservedMenuGroup();
        this.reservedOrder = new ReservedOrder(reservedMenuGroup, reservedDate);
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
