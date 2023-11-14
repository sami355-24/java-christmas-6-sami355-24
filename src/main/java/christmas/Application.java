package christmas;

import christmas.Controller.EventPlanner;
import christmas.Controller.EventPlannerDecorator;

public class Application {
    public static void main(String[] args) {
        EventPlanner eventPlanner = new EventPlannerDecorator();
        eventPlanner.start();
    }
}
