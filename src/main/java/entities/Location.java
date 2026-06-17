package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "locations")
public class Location {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    private String citta;


    public Location(){}

    public Location(String name, String citta){
        this.name=name;
        this.citta=citta;
    }

    public long getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getCitta(){
        return citta;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name){
        this.name=name;
    }

    public void setCitta(String citta){
        this.citta=citta;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", citta='" + citta + '\'' +
                '}';
    }


}
