package hello;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface  RegionRepository extends CrudRepository<Region, Long> {
    List<Region> findByCountry(Country country);
}