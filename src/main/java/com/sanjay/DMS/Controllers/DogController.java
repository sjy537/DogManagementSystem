package com.sanjay.DMS.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sanjay.DMS.Models.Dog;
import com.sanjay.DMS.Models.Trainer;
import com.sanjay.DMS.repository.DogRepository;
import com.sanjay.DMS.repository.TrainerRepository;
/**
* @author Sanjay Kumar Pilli
*
*/

@Controller
public class DogController {

	ModelAndView mv = new ModelAndView();
	
	@Autowired
	DogRepository dogRepo;
	@Autowired
	TrainerRepository trainerRepo;

//	@RequestMapping("dogHome")
//	public String home() {
//		return "home";
//	}
	
	@RequestMapping("dogHome")
	public ModelAndView home() {
		mv.setViewName("home");
		return mv;
	}
	
	@RequestMapping("add")
	public ModelAndView add() {
		mv.setViewName("addNewDog.html");
		 Iterable<Trainer> trainerList = trainerRepo.findAll();
			mv.addObject("trainers", trainerList);
		return mv;
	}
	
	@RequestMapping("addNewDog")
	public ModelAndView addNewDog(Dog dog, @org.springframework.web.bind.annotation.RequestParam("trainerId") int id) {
		Trainer trainer =  trainerRepo.findById(id).orElse(new Trainer());
		dog.setTrainer(trainer);
		dogRepo.save(dog);
		mv.setViewName("home");
		return mv;
	}
	
	@RequestMapping("addTrainer")
	public ModelAndView addTrainer() {
		mv.setViewName("addNewTrainer");
		return mv;
		
	}
	
	@RequestMapping("trainerAdded")
	public ModelAndView addNewTrainer(Trainer trainer) {
		trainerRepo.save(trainer);
		mv.setViewName("home");
		return mv;
		
	}
	
	@RequestMapping("viewModifyDelete")
	public ModelAndView viewDogs() {
		mv.setViewName("viewDogs");
		Iterable<Dog> dogList = dogRepo.findAll();
		mv.addObject("dogs", dogList);
		return mv;
	}
	
	@RequestMapping("editDog")
	public ModelAndView editDog(Dog dog) {
		dogRepo.save(dog);
		mv.setViewName("editDog");
		return mv;
	}
	
	@RequestMapping("deleteDog")
	public ModelAndView deleteDog(Dog dog) {
		//based in id
		//		Optional<Dog> dogFound = dogRepo.findById(dog.getId());
		//		if(dogFound.isPresent()) {
		//			dogRepo.delete(dog);
		//		}
		//		return home();


		// based on the name
		//	List<Dog> dogsFound = dogRepo.findByName(dog.getName());
		//	for(Dog c : dogsFound) {
		//		dogRepo.delete(c);
		//		
		//	}
		//	return home();
		
		Dog c = dogRepo.findById(dog.getId()).orElse(new Dog());
		dogRepo.delete(c);
		return home();
	}
	@RequestMapping("search")
	public ModelAndView searchById(int id) {
		Dog dogFound = dogRepo.findById(id).orElse(new Dog());
		mv.addObject(dogFound);
		mv.setViewName("searchResults");
		return mv;
	}
	
	
}
