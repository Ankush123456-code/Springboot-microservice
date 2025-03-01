package com.ankushkunwar.demo.DAO;

import com.ankushkunwar.demo.Models.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}
