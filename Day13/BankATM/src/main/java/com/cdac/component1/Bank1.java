package com.cdac.component1;


public interface Bank1 {
	public void withdraw(int atmId, int accNo, double amount);

	public boolean isAccPresent(int accNo);	//checking if (this) account is present in the bank or not in respective bank
}
