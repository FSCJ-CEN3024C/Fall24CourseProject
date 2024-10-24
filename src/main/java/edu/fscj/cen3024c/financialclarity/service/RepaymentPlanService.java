package edu.fscj.cen3024c.financialclarity.service;

import edu.fscj.cen3024c.financialclarity.dto.RepaymentPlanDTO;
import edu.fscj.cen3024c.financialclarity.entity.RepaymentPlan;

import edu.fscj.cen3024c.financialclarity.repository.RepaymentPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class RepaymentPlanService {
    @Autowired
    private RepaymentPlanRepository repaymentPlanRepository;

    public RepaymentPlan findByPlanId(String planName) {return repaymentPlanRepository.findByPlanName(planName);}
    public List<RepaymentPlan> findAll(){return repaymentPlanRepository.findAll();}
    public RepaymentPlan findByPlanName(String planName){return repaymentPlanRepository.findByPlanName(planName);}

    @Transactional
    public void deleteByPlanName(String planName){repaymentPlanRepository.deleteByPlanName(planName);}

    public RepaymentPlan save(RepaymentPlan plan){return repaymentPlanRepository.save(plan);}

    public RepaymentPlanDTO save(RepaymentPlanDTO planDTO){
        RepaymentPlan plan = new RepaymentPlan();
        plan.setPlanName(planDTO.getName());
        plan.setPlanId(planDTO.getPlanId());
        plan.setTimeLine(planDTO.getTimeLine());
        RepaymentPlan savedPlan = repaymentPlanRepository.save(plan);
        return convertToDTO(savedPlan);
    }

    private RepaymentPlanDTO convertToDTO(RepaymentPlan plan){
        return new RepaymentPlanDTO(plan.getPlanId(), plan.getUserId(), plan.getTotalExpense(), plan.getPayment(), plan.getTimeLine(), plan.getCategory(), plan.getPlanName());
    }


}
