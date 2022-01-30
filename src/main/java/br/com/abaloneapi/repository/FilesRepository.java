package br.com.abaloneapi.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.abaloneapi.model.Files;

public interface FilesRepository extends JpaRepository<Files, UUID>{

}
