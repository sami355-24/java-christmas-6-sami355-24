package christmas;

import christmas.Controller.EventPlannerDecorator;

public class Application {
    public static void main(String[] args) {
        EventPlannerDecorator eventPlanner = new EventPlannerDecorator();
        eventPlanner.start();
    }
}
