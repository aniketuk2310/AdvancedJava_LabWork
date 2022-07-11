package com.cdac.component;

import java.util.List;

public interface CarPartsInventory {
	
	public void addnewPart(CarPart carPart);
	//to add new part
	
	public List<CarPart> getAvailableParts();
	//available parts list..
	
}
