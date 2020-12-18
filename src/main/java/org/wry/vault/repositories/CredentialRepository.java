package org.wry.vault.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.wry.vault.entities.Credential;

@Repository
public interface CredentialRepository extends CrudRepository<Credential, Integer>{
	
}
