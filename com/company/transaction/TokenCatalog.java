package com.company.transaction;//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : @com.company.vehicle.Vehicle com.company.transaction.Booking
//  @ Author : @Nick Sargsyan, Anna Vardanyan
//
//


import java.util.ArrayList;
import java.util.List;

public class TokenCatalog {
	private List<Token> tokens;

	public TokenCatalog() {
		this.tokens = new ArrayList<>();
	}

	public void addToken(String userId, String targetId, String targetType) {
		Token token = new Token(userId, targetId, targetType);
		tokens.add(token);
	}
	
	public void findAndRemove(String tokenId, String userId, String targetId, String targetType) {
		for (Token token : tokens) {
			if (token.match(tokenId, userId, targetId, targetType)) {
				tokens.remove(token);
				return;
			}
		}
	}
}
