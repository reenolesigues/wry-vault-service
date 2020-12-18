package org.wry.vault.dto;

import java.time.LocalDateTime;

import org.wry.vault.entities.Credential;

public class CredentialRequest extends Credential{

	public Credential toCredential() {
		Credential c = new Credential();
		c.setTag(this.getTag());
		c.setWeblink(this.getWeblink());
		c.setUsername(this.getUsername());
		c.setPassword(this.getPassword());
		c.setFavorite(this.isFavorite());
		c.setDateInserted(LocalDateTime.now());
		c.setDateModified(LocalDateTime.now());
		return c;
	}
}
