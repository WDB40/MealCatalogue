package catalogue.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import catalogue.model.Meal;
import catalogue.model.Protein;
import catalogue.model.Side;
import catalogue.model.Vegetable;
import catalogue.repository.MealRepository;
import catalogue.repository.ProteinRepository;
import catalogue.repository.SideRepository;
import catalogue.repository.VegetableRepository;

@Controller
public class WebController {

	@Autowired
	MealRepository mealRepo;
	
	@Autowired
	ProteinRepository proteinRepo;
	
	@Autowired
	SideRepository sideRepo;
	
	@Autowired
	VegetableRepository vegetableRepo;
	
	@GetMapping("/insertProtein")
	public String insertProteinForm(Model model) {
		Protein protein = new Protein();
		model.addAttribute("newProtein", protein);
		return "insertProtein";
	}
	
	@PostMapping("/insertProtein")
	public String insertProtein(@ModelAttribute Protein protein, Model model) {
		proteinRepo.save(protein);
		
		model.addAttribute("proteins", proteinRepo.findAll());
		model.addAttribute("vegetables", vegetableRepo.findAll());
		model.addAttribute("sides", sideRepo.findAll());
		model.addAttribute("allMeals", mealRepo.findAll());
		
		return "viewAll";
	}
	
	@GetMapping("/deleteProtein/{id}")
	public String deleteProtein(@PathVariable("id") long id, Model model) {
		Protein protein = proteinRepo
							.findById(id)
							.orElseThrow(() -> new IllegalArgumentException("Invalid User Id: " + id));
		
		proteinRepo.delete(protein);
		
		model.addAttribute("proteins", proteinRepo.findAll());
		model.addAttribute("vegetables", vegetableRepo.findAll());
		model.addAttribute("sides", sideRepo.findAll());

		
		return "viewAll";
	}
	
	@GetMapping("/editProtein/{id}")
	public String updateProteinForm(@PathVariable("id") long id, Model model) {
		Protein protein = proteinRepo
				.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid User Id: " + id));
		
		model.addAttribute("protein", protein);
		return "updateProtein";
	}
	
	@PostMapping("updateProtein/{id}")
	public String updateUser(@PathVariable("id") long id, @Valid Protein protein, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			protein.setId(id);
			return "update";
		}
		
		proteinRepo.save(protein);
		
		model.addAttribute("proteins", proteinRepo.findAll());
		model.addAttribute("vegetables", vegetableRepo.findAll());
		model.addAttribute("sides", sideRepo.findAll());
		
		return "viewAll";
		
	}
	
	@GetMapping("/insertVegetable")
	public String insertVegetableForm(Model model) {
		Vegetable vegetable = new Vegetable();
		model.addAttribute("newVegetable", vegetable);
		return "insertVegetable";
	}
	
	@PostMapping("/insertVegetable")
	public String insertVegetable(@ModelAttribute Vegetable vegetable, Model model) {
		vegetableRepo.save(vegetable);
		
		model.addAttribute("proteins", proteinRepo.findAll());
		model.addAttribute("vegetables", vegetableRepo.findAll());
		model.addAttribute("sides", sideRepo.findAll());
		model.addAttribute("allMeals", mealRepo.findAll());
		
		return "viewAll";
	}
	
	@GetMapping("/deleteVegetable/{id}")
	public String deleteVegetable(@PathVariable("id") long id, Model model) {
		Vegetable vegetable = vegetableRepo
							.findById(id)
							.orElseThrow(() -> new IllegalArgumentException("Invalid User Id: " + id));
		
		vegetableRepo.delete(vegetable);
		
		model.addAttribute("proteins", proteinRepo.findAll());
		model.addAttribute("vegetables", vegetableRepo.findAll());
		model.addAttribute("sides", sideRepo.findAll());
		model.addAttribute("allMeals", mealRepo.findAll());
		
		return "viewAll";
	}
	
	@GetMapping("/insertSide")
	public String insertSideForm(Model model) {
		Side side = new Side();
		model.addAttribute("newSide", side);
		return "insertSide";
	}
	
	@PostMapping("/insertSide")
	public String insertSide(@ModelAttribute Side side, Model model) {
		sideRepo.save(side);
		
		model.addAttribute("proteins", proteinRepo.findAll());
		model.addAttribute("vegetables", vegetableRepo.findAll());
		model.addAttribute("sides", sideRepo.findAll());
		model.addAttribute("allMeals", mealRepo.findAll());
		
		return "viewAll";
	}
	
	@GetMapping("/deleteSide/{id}")
	public String deleteSide(@PathVariable("id") long id, Model model) {
		Side side = sideRepo
							.findById(id)
							.orElseThrow(() -> new IllegalArgumentException("Invalid User Id: " + id));
		
		sideRepo.delete(side);
		
		model.addAttribute("proteins", proteinRepo.findAll());
		model.addAttribute("vegetables", vegetableRepo.findAll());
		model.addAttribute("sides", sideRepo.findAll());
		model.addAttribute("allMeals", mealRepo.findAll());
		
		return "viewAll";
	}
	
	@GetMapping("/viewAll")
	public String viewAllParts(Model model) {
		model.addAttribute("proteins", proteinRepo.findAll());
		model.addAttribute("vegetables", vegetableRepo.findAll());
		model.addAttribute("sides", sideRepo.findAll());
		model.addAttribute("allMeals", mealRepo.findAll());
		
		return "viewAll";
	}
	
	@GetMapping("/insertMeal")
	public String insertMealForm(Model model) {
		
		Protein protein = new Protein();
		Vegetable vegetable = new Vegetable();
		Side side = new Side();
		
		Meal meal = new Meal();
		
		model.addAttribute("newMeal", meal);
		
		model.addAttribute("protein", protein);
		model.addAttribute("vegetable", vegetable);
		model.addAttribute("side", side);
		
		model.addAttribute("proteins", proteinRepo.findAll());
		model.addAttribute("vegetables", vegetableRepo.findAll());
		model.addAttribute("sides", sideRepo.findAll());
		model.addAttribute("meals", mealRepo.findAll());
		
		return "insertMeal";	
	}
	
	@PostMapping("/insertMeal")
	public String insertMeal(@ModelAttribute Meal meal, Model model) {
		
		
		/*
		Protein protein = proteinRepo
				.findById(proteinId)
				.orElseThrow(() -> new IllegalArgumentException("Invalid User Id: " + proteinId));
		
		Vegetable vegetable = vegetableRepo
				.findById(vegetableId)
				.orElseThrow(() -> new IllegalArgumentException("Invalid User Id: " + vegetableId));
		
		Side side = sideRepo
				.findById(sideId)
				.orElseThrow(() -> new IllegalArgumentException("Invalid User Id: " + sideId));
		
		
		Meal meal = new Meal(protein, vegetable, side);
		*/
		
		mealRepo.save(meal);
		
		model.addAttribute("proteins", proteinRepo.findAll());
		model.addAttribute("vegetables", vegetableRepo.findAll());
		model.addAttribute("sides", sideRepo.findAll());
		model.addAttribute("meals", mealRepo.findAll());
		
		return "viewAll";
		
	}
}
