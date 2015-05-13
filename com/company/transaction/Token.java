package com.company.transaction;//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : @com.company.vehicle.Vehicle com.company.transaction.Booking
//  @ Author : @Nick Sargsyan, Anna Vardanyan
//
//


import com.company.IdGenerator;

public class Token {
	public static final String TARGET_TYPE_VEHICLE = "targetTypeVehicle";
	public static final String TARGET_TYPE_MAIN_GATE = "targetTypeMainGate";
	public static final String TARGET_TYPE_SECOND_GATE = "targetTypeSecondGate";

	private static final IdGenerator idGenerator = new IdGenerator("TOKEN");

	private String userId;
	private String tokenId;
	private String targetId;
	private String targetType;

	public Token(String userId, String targetId, String targetType) {
		this.userId = userId;
		this.targetId = targetId;
		this.targetType = targetType;
		this.tokenId = idGenerator.generateId();
	}

	public boolean match(String tokenId, String userId, String targetId, String targetType) {
		return this.userId.equals(userId)
				&& this.tokenId.equals(tokenId)
				&& this.targetId.equals(targetId)
				&& this.targetType.equals(targetType);
	}

	public String getTargetId() {
		return targetId;
	}

	public String getTokenId() {
		return tokenId;
	}
}
