package edu.fscj.cen3024c.financialclarity.controller;

import edu.fscj.cen3024c.financialclarity.entity.RepaymentPlan;
import edu.fscj.cen3024c.financialclarity.service.RepaymentPlanService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/repaymentPlan ")
public class
RepaymentPlanController {
    @Autowired
    private RepaymentPlanService repaymentPlanService;

    @CrossOrigin(origins = {"http://example.com", "http://localhost"})
    @GetMapping("/{planId}")
    public ResponseEntity<RepaymentPlan> getRepaymentByPlanId(@PathVariable Integer planId) {
        RepaymentPlan repaymentPlan = repaymentPlanService.findByPlanId(planId);
        return ResponseEntity.ok(repaymentPlan);
    }
}
