package com.example.demo.repo;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.RepaymentPlan;
public interface RepaymentPlanRepository extends JpaRepository<RepaymentPlan, Long> {

}
