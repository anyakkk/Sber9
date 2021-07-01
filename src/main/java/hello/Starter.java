package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan
@EnableAutoConfiguration
public class Starter {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Starter.class);
        CityRepository cityRepository = context.getBean(CityRepository.class);
        RegionRepository regionRepository = context.getBean(RegionRepository.class);
        CountryRepository countryRepository = context.getBean(CountryRepository.class);


        Country country1 = new Country("Россия");
        countryRepository.save(country1);

        Region region1 = new Region("Вологодская область", country1);
        regionRepository.save(region1);

        City city1 = new City("Вологда", region1);
        cityRepository.save(city1);

        City city3 = new City("Белозерск", region1);
        cityRepository.save(city3);

        Country country2 = new Country("Норвегия");
        countryRepository.save(country2);

        Region region2 = new Region("Восточная Норвегия", country2);
        regionRepository.save(region2);

        City city2 = new City("Осло", region2);
        cityRepository.save(city2);

        Country country3 = new Country("Австралия");
        countryRepository.save(country3);

        Region region3 = new Region("штат Виктория", country3);
        regionRepository.save(region3);

        City city4 = new City("Мельбурн", region3);
        cityRepository.save(city4);

        Iterable<Country> cou = countryRepository.findAll();
        Iterable<Region> reg = regionRepository.findAll();
        Iterable<City> cit = cityRepository.findAll();

        for (Country country : cou) {
            System.out.println(country.getName());
            for (Region region : regionRepository.findByCountry(country)) {
                System.out.println(" " + region.getName());
                for (City city : cityRepository.findByRegion(region)) {
                    System.out.println("  " + city.getName());
                }
            }
        }

        context.close();

    }
}
