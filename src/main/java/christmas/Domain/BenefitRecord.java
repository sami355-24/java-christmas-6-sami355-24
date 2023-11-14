package christmas.Domain;

import christmas.Domain.ReservedMenuGroup.ReservedMenuGroup;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BenefitRecord {

    Map<String, Integer> benefits;

    BenefitRecord(ReservedMenuGroup menuGroup, ReservedDate date) {
        this.benefits = new HashMap<>();
    }

    public void addBenefit(String benefitName, int benefitAmount) {
        benefits.put(benefitName, benefitAmount);
    }

    public Map<String, Integer> getBenefits() {
        return Collections.unmodifiableMap(benefits);
    }

    public List<Integer> getBenefitAmounts() {
        return benefits.values().stream().toList();
    }
}
