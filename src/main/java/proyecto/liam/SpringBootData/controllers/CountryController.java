package proyecto.liam.SpringBootData.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import proyecto.liam.SpringBootData.entidad.Country;
import proyecto.liam.SpringBootData.repository.CountryRepository;

@RestController
@RequestMapping("/country") // Esto permite poner un prefijo a todas las peticiones
public class CountryController {
	
	    @Autowired
	    private CountryRepository countryRepository;
	    
	    @GetMapping("/add")
	    public String addNewCountry(
	            @RequestParam(value = "name", defaultValue = "País nuevo") 
	            String name) {
	        Country pas = new Country(name);
	        countryRepository.save(pas);
	        return "Saved "+pas.getCountryId();
	    }
		
		@GetMapping("/all")
		public Iterable<Country> viewAll() {
	        return countryRepository.findAll();
	    }
		
		@GetMapping("/get")
		public Optional<Country> getCategory(
				@RequestParam(defaultValue="1") 
				int id) {
				return countryRepository.findById(id);
			
		}

		@GetMapping("/delete")
	    public String deleteCategory(
	            @RequestParam(value = "id", defaultValue = "0") 
	            String id) {
	        try {
	            countryRepository.deleteById(Integer.parseInt(id));
	            return "Borrado "+id;
	        }catch(Exception ex) {
	            return ex.getMessage();
	        }
	    }

}
