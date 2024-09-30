package proyecto.liam.SpringBootData.entidad;


 
import jakarta.persistence.*;


@Entity
@Table(name = "country")

public class Country {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "country_id")
	    private Short countryId;

	    @Column(name = "country", nullable = false)
	    private String country;

	    @Column(name = "last_update", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	    private java.util.Date lastUpdate = new java.util.Date();

	    // Constructors, getters, and setters

	    public Country() {
	    }

	    public Country(String country) {
	        this.country = country;
	    }

	    public Short getCountryId() {
	        return countryId;
	    }

	    public void setCountryId(Short countryId) {
	        this.countryId = countryId;
	    }

	    public String getCountry() {
	        return country;
	    }

	    public void setCountry(String country) {
	        this.country = country;
	    }

	    public java.util.Date getLastUpdate() {
	        return lastUpdate;
	    }

	    public void setLastUpdate(java.util.Date lastUpdate) {
	        this.lastUpdate = lastUpdate;
	    }

	    @Override
	    public String toString() {
	        return "Country [countryId=" + countryId + ", country=" + country + "]";
	    }

}
