package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Unit {
	
	private StringProperty unitName;
	private IntegerProperty speed;
	private IntegerProperty melee;
	private IntegerProperty ranged;
	private IntegerProperty defense;
	private IntegerProperty attack;
	private IntegerProperty toughness;
	private IntegerProperty cost;
	//private IntegerProperty xp;
	//private StringProperty special;
	//private StringProperty injuries;
	//private StringProperty equipment;
	//private StringProperty skills;
	
	public Unit(String unitName, int speed, int melee, int ranged, int defense, int attack, int toughness, int cost){
		
		this.unitName = new SimpleStringProperty(unitName);
		this.speed = new SimpleIntegerProperty(speed);
		this.melee = new SimpleIntegerProperty(melee);
		this.ranged = new SimpleIntegerProperty(ranged);
		this.defense = new SimpleIntegerProperty(defense);
		this.attack = new SimpleIntegerProperty(attack);
		this.toughness = new SimpleIntegerProperty(toughness);
		this.cost = new SimpleIntegerProperty(cost);
	}
	
	  public StringProperty unitNameProperty() {
		    if (unitName == null) unitName = new SimpleStringProperty(this, "unitName");
		    return unitName;
	  }
	
	public String getUnitName(){
		
		return unitName.get();
	}

	public void setUnitName(String unitName){
		
		this.unitName.set(unitName);
	}

//	public StringProperty unitNameProperty(){
//		
//		return unitName;
//	}

	public int getSpeed(){
		
		return speed.get(); 
	}

	public void setSpeed(int speed){
		
		this.speed.set(speed);
	}

	public IntegerProperty speedProperty(){
		
		return speed;
	}

	public int getMelee(){
		
		return melee.get(); 
	}

	public void setMelee(int melee){
		
		this.melee.set(melee);
	}

	public IntegerProperty meleeProperty(){
		
		return melee;
	}

	public int getRanged(){
		
		return ranged.get(); 
	}

	public void setRanged(int ranged){
		
		this.ranged.set(ranged);
	}

	  public IntegerProperty rangedProperty() {
		    if (ranged == null) ranged = new SimpleIntegerProperty(this, "ranged");
		    return ranged;
	  }
	

	public int getDefense(){
		
		return defense.get(); 
	}

	public void setDefense(int defense){
		
		this.defense.set(defense);
	}

	public IntegerProperty defenseProperty(){
		
		return defense;
	}

	public int getAttack(){
		
		return attack.get(); 
	}

	public void setAttack(int attack){
		
		this.attack.set(attack);
	}

	public IntegerProperty attackProperty(){
		
		return attack;
	}

	public int getToughness(){
		
		return toughness.get(); 
	}

	public void setToughness(int toughness){
		
		this.toughness.set(toughness);
	}

	public IntegerProperty toughnessProperty(){
		
		return toughness;
	}

	public int getCost(){
		
		return cost.get(); 
	}

	public void setCost(int cost){
		
		this.cost.set(cost);
	}

	public IntegerProperty costProperty(){
		
		return cost;
	}
	
	
}