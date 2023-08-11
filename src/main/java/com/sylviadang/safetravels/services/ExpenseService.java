package com.sylviadang.safetravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sylviadang.safetravels.models.Expense;
import com.sylviadang.safetravels.repositories.ExpenseRepository;

@Service
public class ExpenseService {
	private final ExpenseRepository expenseRepository;
	
	public ExpenseService(ExpenseRepository expenseRepository) {
		this.expenseRepository = expenseRepository;
	}
	
	//returns all the burgers
	public List<Expense> allExpenses() {
		return expenseRepository.findAll();
	}
	
	//create a burger
	public Expense addExpense(Expense expense) {
		return expenseRepository.save(expense);
	}
	
	public Expense findExpense(Long id) {
			Optional<Expense> optionalExpense = expenseRepository.findById(id);
			if (optionalExpense.isPresent()) {
				return optionalExpense.get();
		}
		return null;
	}
	public Expense updateExpense(Expense expense) {
		return expenseRepository.save(expense);
	}
	
	public String delete(Long id) {
		expenseRepository.deleteById(id);
		return id + " has been deleted";
	}
}
