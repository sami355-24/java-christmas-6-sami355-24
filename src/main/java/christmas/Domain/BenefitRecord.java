package christmas.Domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BenefitRecord {

    Map<String, Integer> benefitRecord;

    BenefitRecord() {
        this.benefitRecord = new HashMap<>();
    }

    public void addBenefit(String benefitName, int benefitAmount) {
        benefitRecord.put(benefitName, benefitAmount);
    }

    public Map<String, Integer> getBenefitRecord() {
        return Collections.unmodifiableMap(benefitRecord);
    }

    public List<Integer> getBenefitAmounts() {
        return benefitRecord.values().stream().toList();
    }
}
