package hello;


import javax.persistence.*;

@Entity
public class City {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    String name;

    @ManyToOne(fetch = FetchType.EAGER)
    Region region;


    public City() {}


    public City(String name, Region region) {
        this.name = name;
        this.region = region;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
