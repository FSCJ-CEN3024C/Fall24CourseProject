package edu.fscj.cen3024c.financialclarity.service;

import edu.fscj.cen3024c.financialclarity.entity.RepaymentPlan;

import edu.fscj.cen3024c.financialclarity.repository.RepaymentPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RepaymentPlanService {
    @Autowired
    private RepaymentPlanRepository repaymentPlanRepository;

    public RepaymentPlan findByRepaymentId(Integer repaymentId) {return repaymentPlanRepository.findByRepaymentId(repaymentId);}
}
