package com.sylviadang.safetravels.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.sylviadang.safetravels.models.Expense;
import com.sylviadang.safetravels.services.ExpenseService;

import jakarta.validation.Valid;

@Controller
public class HomeController {
	@Autowired
	ExpenseService expenseService;
	
//	private final BurgerService burgerServ;
//	public HomeController(BurgerService burgerServ) {
//		this.burgerServ = burgerServ;
//	}
	
	@GetMapping("/")
	public String dashboard(@ModelAttribute("expense") Expense expense, Model model) {
		List<Expense> expenses = expenseService.allExpenses();
		model.addAttribute("expenses", expenses);
		return "index.jsp";
	}
	
	@PostMapping("/addExpense")
	public String home(@Valid @ModelAttribute("expense") Expense expense, BindingResult result, Model model) {
		if(result.hasErrors()) {
			System.out.println(result.getFieldErrors());
			List<Expense> expenses = expenseService.allExpenses();
			model.addAttribute("expenses", expenses);
			return "index.jsp";
		}
		expenseService.addExpense(expense);
		return "redirect:/";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, @ModelAttribute("expense") Expense expense, Model model) {
		model.addAttribute("expense", expenseService.findExpense(id));
		return "edit.jsp";
	}
	
	@PutMapping("edit/{id}")
	public String updateExpense(@Valid @ModelAttribute("expense") Expense expense, BindingResult result, @PathVariable("id") Long id, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("expense", expense);
			return "index.jsp";
		}
		expenseService.updateExpense(expense);
		return "redirect:/";
	}
	
	@DeleteMapping("/expense/{id}")
	public String deleteExpense(@PathVariable("id") Long id) {
		expenseService.delete(id);
		return "redirect:/";
	}
	
}
