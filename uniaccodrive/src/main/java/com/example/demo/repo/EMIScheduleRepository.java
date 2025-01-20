package com.example.demo.repo;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.EMISchedule;
import com.example.demo.entity.RepaymentPlan;
public interface EMIScheduleRepository extends JpaRepository<EMISchedule, Long>{

	List<EMISchedule> findByRepaymentPlanAndIsPaidFalseOrderByDueDateAsc(RepaymentPlan repaymentPlan);

}
