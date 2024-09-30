package proyecto.liam.SpringBootData.repository;

import org.springframework.data.repository.CrudRepository;

import proyecto.liam.SpringBootData.entidad.Category;

public interface CategoryRepository extends CrudRepository<Category, Integer> {

}
