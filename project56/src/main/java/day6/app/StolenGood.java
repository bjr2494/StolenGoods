package day6.app;

import java.util.List;

import javax.validation.constraints.NotEmpty;

public class StolenGood {
	
	private String owner;
	private String nameOfGood;
	private String victim;
	private String descriptionOfEvent;
	private List<String> goodComments;

	public StolenGood() {}

	public StolenGood(String owner, String nameOfGood, String victim, String descriptionOfEvent) {
		this.owner = owner;
		this.nameOfGood = nameOfGood;
		this.victim = victim;
		this.descriptionOfEvent = descriptionOfEvent;
	}
	
	public StolenGood(String owner, String nameOfGood, String victim, String descriptionOfEvent, List<String> goodComments) {
		this.owner = owner;
		this.nameOfGood = nameOfGood;
		this.victim = victim;
		this.descriptionOfEvent = descriptionOfEvent;
		this.goodComments = goodComments;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	@NotEmpty
	public String getNameOfGood() {
		return nameOfGood;
	}

	public void setNameOfGood(String nameOfGood) {
		this.nameOfGood = nameOfGood;
	}

	@NotEmpty
	public String getVictim() {
		return victim;
	}

	public void setVictim(String victim) {
		this.victim = victim;
	}

	@NotEmpty
	public String getDescriptionOfEvent() {
		return descriptionOfEvent;
	}

	public void setDescriptionOfEvent(String descriptionOfEvent) {
		this.descriptionOfEvent = descriptionOfEvent;
	}

	public List<String> getGoodComments() {
		return goodComments;
	}

	public void setGoodComments(List<String> goodComments) {
		this.goodComments = goodComments;
	}

	@Override
	public String toString() {
		return "StolenGood [owner=" + owner + ", nameOfGood=" + nameOfGood + ", victim=" + victim
				+ ", descriptionOfEvent=" + descriptionOfEvent + ", goodComments=" + goodComments + "]";
	}
}
