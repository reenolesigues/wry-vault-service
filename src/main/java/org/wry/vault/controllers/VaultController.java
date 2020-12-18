package org.wry.vault.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.wry.vault.dto.CredentialRequest;
import org.wry.vault.dto.CredentialResponse;
import org.wry.vault.services.CredentialService;

@RestController
public class VaultController {

	@Autowired
	private CredentialService credentialService;
	
	@PostMapping(path = "/vault", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CredentialResponse> createCredential(@RequestBody(required = true) CredentialRequest credentialRequest) {
		return credentialService.create(credentialRequest.toCredential());
	}
	
	@GetMapping(path = "/vault/{id}")
	public ResponseEntity<CredentialResponse> readCredential(@PathVariable(name = "id", required = true) Integer id) {
		return credentialService.read(id);
	}
	
	@PatchMapping(path = "/vault/{id}")
	public ResponseEntity<CredentialResponse> updateCredential(@PathVariable(name = "id", required = true) Integer id, @RequestBody(required = true) CredentialRequest credentialRequest) {
		return credentialService.update(id, credentialRequest);
	}
	
	@DeleteMapping(path = "/vault/{id}")
	public ResponseEntity<CredentialResponse> deleteCredential(@PathVariable(name = "id", required = true) Integer id) {
		return credentialService.delete(id);
	}
}
