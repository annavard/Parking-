package com.company.humanResources.crew;//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : @com.company.vehicle.Vehicle com.company.transaction.Booking
//  @ Author : @Nick Sargsyan, Anna Vardanyan
//
//


public class SupportCrewMember extends CrewMember {
	private String parkingId;

	public SupportCrewMember(String memberName, String memberPhone, String memberEmail, String memberId, String parkingId) {
		super(memberName, memberPhone, memberEmail, memberId);

		this.parkingId = parkingId;
	}

	@Override
	public void notify(String message) {
		System.out.print("SUPPORT NOTIFIED " + message);
	}


	public String getParkingId() {
		return parkingId;
	}
}