package proyecto.liam.SpringBootData.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import proyecto.liam.SpringBootData.entidad.Category;
import proyecto.liam.SpringBootData.repository.CategoryRepository;

@RestController
public class CategoryController {
	
	// Lo que hace es crear e inyectar un objeto de tipo
    // CRUD con la entidad 'Category'
    // Este objeto nos servirá como un DAO, nos permite crear, modificar
    // obtener y borrar cualquier elemento de la web
    // el objeto repository nos permite usar findall, findbyid, deletebyid, save...
    @Autowired
    private CategoryRepository categoryRepository;
    
    @GetMapping("/add")
    public String addNewCategory(
            @RequestParam(value = "name", defaultValue = "Nueva categoría") 
            String name) {
        Category cat = new Category(name);
        categoryRepository.save(cat);
        return "Saved "+cat.getCategoryId();
    }
	
	@GetMapping("/all")
	public Iterable<Category> viewAll() {
        return categoryRepository.findAll();
    }
	
	@GetMapping("/get")
	public Optional<Category> getCategory(
			@RequestParam(defaultValue="1") 
			int id) {
        return categoryRepository.findById(id);
	}

	@GetMapping("/delete")
    public String deleteCategory(
            @RequestParam(value = "id", defaultValue = "0") 
            String id) {
        try {
            categoryRepository.deleteById(Integer.parseInt(id));
            return "Borrado "+id;
        }catch(Exception ex) {
            return ex.getMessage();
        }
    }
	

}
