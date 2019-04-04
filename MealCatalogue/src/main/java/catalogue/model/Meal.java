package catalogue.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="MEAL")
public class Meal {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private long id;
	
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="PROTEIN")
	private Protein protein;
	
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="VEGETABLE")
	private Vegetable vegetable;
	
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="SIDE")
	private Side side;
	
	public Meal() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Meal(Protein protein, Vegetable vegetable, Side side) {
		super();
		this.protein = protein;
		this.vegetable = vegetable;
		this.side = side;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Protein getProtein() {
		return protein;
	}

	public void setProtein(Protein protein) {
		this.protein = protein;
	}

	public Vegetable getVegetable() {
		return vegetable;
	}

	public void setVegetable(Vegetable vegetable) {
		this.vegetable = vegetable;
	}

	public Side getSide() {
		return side;
	}

	public void setSide(Side side) {
		this.side = side;
	}

	@Override
	public String toString() {
		return "Meal [id=" + id + ", protein=" + protein + ", vegetable=" + vegetable + ", side=" + side + "]";
	}

}
