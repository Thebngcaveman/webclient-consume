package com.thecaveman.cowboyMuseum.cowboyMuseum;

import com.thecaveman.cowboyMuseum.cowboyMuseum.model.Cowboy;
import com.thecaveman.cowboyMuseum.cowboyMuseum.repository.CowboyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/v1/cowboyMuseum")
public class CowboyMuseumApplication {
	@Autowired
	private CowboyRepository cowboyRepository;

	@PostMapping("/cowboyWelc")
	public String cowboyShow(@RequestBody Cowboy cowboyRequest){
		Cowboy response = cowboyRepository.save(cowboyRequest);
		return "Howdy "+response.getName()+".We all know "+response.getFamous()+" is the reason why you are famous."
				+response.getGun()+" is your weapon."+"You also have"+response.getMoney()+".We wish you a good luck";
	}

	@GetMapping("/getAllCowboys")
	public List<Cowboy> getAllCowboy(){
		return cowboyRepository.findAll();
	}

	@GetMapping("/findById/{id}")
	public Cowboy findById(@PathVariable(value = "id")Long id){
		return cowboyRepository.findById(id).get();
	}

	@DeleteMapping("/deleteById/{id}")
	public String deleteCowboy(@PathVariable(value = "id")Long id){
		cowboyRepository.deleteById(id);
		return "Cowbow is deleted with id:"+id;
	}

	@PutMapping("/updateCowboy/{id}")
	public Cowboy updateCowboy(@RequestBody Cowboy updateCowboy, @PathVariable(value = "id") Long id){
		Cowboy dbResponse = cowboyRepository.findById(id).get();
		dbResponse.setName(updateCowboy.getName());
		dbResponse.setFamous(updateCowboy.getFamous());
		dbResponse.setGun(updateCowboy.getGun());
		dbResponse.setMoney(updateCowboy.getMoney());
		cowboyRepository.saveAndFlush(dbResponse);
		return dbResponse;
	}

	public static void main(String[] args) {
		SpringApplication.run(CowboyMuseumApplication.class, args);
	}

}
