package hello;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface  CityRepository extends CrudRepository<City, Long> {
}