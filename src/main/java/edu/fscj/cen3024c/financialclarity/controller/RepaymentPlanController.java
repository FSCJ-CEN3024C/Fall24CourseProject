package edu.fscj.cen3024c.financialclarity.controller;

import edu.fscj.cen3024c.financialclarity.entity.RepaymentPlan;
import edu.fscj.cen3024c.financialclarity.service.RepaymentPlanService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/savings")
public class RepaymentPlanController {
    @Autowired
    private RepaymentPlanService repaymentPlanService;

    @GetMapping("/{savingsId}")
    public ResponseEntity<RepaymentPlan> getRepaymentByRepaymentId(@PathVariable Integer repaymentId) {
        RepaymentPlan repaymentPlan = repaymentPlanService.findByRepaymentId(repaymentId);
        return ResponseEntity.ok(repaymentPlan);
    }
}
