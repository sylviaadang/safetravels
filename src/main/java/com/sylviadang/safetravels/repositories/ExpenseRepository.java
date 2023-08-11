package com.sylviadang.safetravels.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sylviadang.safetravels.models.Expense;

	public interface ExpenseRepository extends CrudRepository<Expense, Long> {
		List<Expense> findAll();
	}
