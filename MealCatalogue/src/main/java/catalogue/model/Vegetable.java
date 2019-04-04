package catalogue.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Vegetable")
public class Vegetable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private long id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="PREPARATION")
	private String preparation;
	
	public Vegetable() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Vegetable(String name, String preparation) {
		super();
		this.name = name;
		this.preparation = preparation;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPreparation() {
		return preparation;
	}

	public void setPreparation(String preparation) {
		this.preparation = preparation;
	}

	@Override
	public String toString() {
		return "Vegetable [id=" + id + ", name=" + name + ", preparation=" + preparation + "]";
	}
	
}
