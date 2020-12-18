package org.wry.vault.services;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.wry.vault.dto.CredentialRequest;
import org.wry.vault.dto.CredentialResponse;
import org.wry.vault.entities.Credential;
import org.wry.vault.repositories.CredentialRepository;

@Service
public class CredentialService {

	@Autowired
	private CredentialRepository credentialRepository;

//	public CredentialResponse create(Credential credential) {
//		return CredentialResponse.generateResponse(credentialRepository.save(credential));
//	}
	
	public ResponseEntity<CredentialResponse> create(Credential credential) {
		return renderResponse(CredentialResponse.generateResponse(credentialRepository.save(credential)), HttpStatus.ACCEPTED);
	}

	public ResponseEntity<CredentialResponse> read(Integer id) {
		Optional<Credential> c = credentialRepository.findById(id);
		if(c.isPresent()) {
			return renderResponse(CredentialResponse.generateResponse(credentialRepository.findById(id).get()), HttpStatus.OK);
		}
		return renderResponse(CredentialResponse.custom("Credential not found"), HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<CredentialResponse> update(Integer id, CredentialRequest credentialRequest) {
		Optional<Credential> copt = credentialRepository.findById(id);
		if(copt.isPresent()) {
			Credential c = copt.get();
			c.setDateModified(LocalDateTime.now());
			c.setTag(credentialRequest.getTag());
			c.setWeblink(credentialRequest.getWeblink());
			c.setUsername(credentialRequest.getUsername());
			c.setPassword(credentialRequest.getPassword());
			c.setFavorite(credentialRequest.isFavorite());
			return renderResponse(CredentialResponse.generateResponse(credentialRepository.save(c)), HttpStatus.OK);
		}
		return renderResponse(CredentialResponse.custom("Credential not found"), HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<CredentialResponse> delete(Integer id) {
		Optional<Credential> copt = credentialRepository.findById(id);
		if(copt.isPresent()) {
			credentialRepository.delete(copt.get());
			return renderResponse(CredentialResponse.custom("Credential successfully deleted"), HttpStatus.OK);
		}
		return renderResponse(CredentialResponse.custom("Credential not found"), HttpStatus.NOT_FOUND);
	}
	
	private ResponseEntity<CredentialResponse> renderResponse(CredentialResponse credentialResponse, HttpStatus status) {
		return new ResponseEntity<>(credentialResponse, status);
	}
}
