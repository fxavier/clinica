package com.xavier.clinica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xavier.clinica.model.Clinica;
import com.xavier.clinica.repository.helper.clinica.ClinicasQueries;

@Repository
public interface Clinicas extends JpaRepository<Clinica, Long>, ClinicasQueries{

}
