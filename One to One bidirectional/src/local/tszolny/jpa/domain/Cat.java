package local.tszolny.jpa.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Cat {
	@Id
	@GeneratedValue
	private long id;
	private String name;
	@OneToOne(mappedBy = "cat")
	private Owner owner;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public long getId() {
		return id;
	}
}
