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
		else{
			//+9012
			if(phoneNum.charAt(0)=='+' && phoneNum.length()>=5){

				if(phoneNum.subSequence(0,3).equals("+90") && phoneNum.length()!=13)
				{

						throw new IllegalArgumentException(" should be exactly 13-char long when it starts with `+90`");

				}



			}else{
				if(!phoneNum.equals("112") && !phoneNum.equals("911")){
					throw new IllegalArgumentException("it is not appropriate");
				}

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
