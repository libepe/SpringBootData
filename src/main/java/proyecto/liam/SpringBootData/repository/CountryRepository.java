package proyecto.liam.SpringBootData.repository;

import org.springframework.data.repository.CrudRepository;

import proyecto.liam.SpringBootData.entidad.Country;

public interface CountryRepository extends CrudRepository<Country, Integer> {

}
