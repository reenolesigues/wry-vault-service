package org.wry.vault.dto;

import org.wry.vault.entities.Credential;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class CredentialResponse{

	private String message;
	
	private Credential credential;
	
	public CredentialResponse(String message) {
		this.message = message;
	}
	
	public CredentialResponse(Credential credential) {
		this.credential = credential;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Credential getCredential() {
		return credential;
	}

	public void setCredential(Credential credential) {
		this.credential = credential;
	}

	public static CredentialResponse generateResponse(Credential cred) {
		if(cred == null) {
			return new CredentialResponse("No credential processed");
		}
		return new CredentialResponse(cred);
	}
	
	public static CredentialResponse custom(String message) {
		return new CredentialResponse(message);
	}
}
