package com.kodgemisi.usermanagement;

/**
 * Represents a phone number, never stores a null value. If constructed with a null value stores an empty string.
 */
public class Phone implements CharSequence {

	private final String phoneNumber;


	public Phone(String phoneNumber) {

			validate(phoneNumber);
			this.phoneNumber=phoneNumber;

	}

	public void validate(String phoneNum){

		if(phoneNum==null || phoneNum.equals("")){
			throw new IllegalArgumentException(" it  shouldnt null or empty");
		}
		if(phoneNum.charAt(0)!='+' && phoneNum.length()<5){

			throw new IllegalArgumentException("telefon numarası uygun değil");
		}else{
			if(phoneNum.subSequence(0,3)!="+90" && phoneNum.length()!=13)
			{
				throw new IllegalArgumentException("uzunluk en az 13 karakter olmalı ya da başı +90 olmamalı");
			}
		}



	}

	public String number() {


		return phoneNumber;

	}

	@Override
	public int length() {
		return phoneNumber.length();
	}

	@Override
	public char charAt(int index) {

		return phoneNumber.charAt(index);
	}

	@Override
	public CharSequence subSequence(int start, int end) {

		return phoneNumber.subSequence(start, end);
	}

	@Override
	public String toString() {
		return phoneNumber;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Phone phone = (Phone) o;

		return phoneNumber.equals(phone.phoneNumber);
	}

	@Override
	public int hashCode() {
		return phoneNumber.hashCode();
	}
}
