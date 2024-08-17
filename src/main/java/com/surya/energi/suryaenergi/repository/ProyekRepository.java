package com.surya.energi.suryaenergi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.surya.energi.suryaenergi.model.Proyek;

@Repository
public interface ProyekRepository extends JpaRepository<Proyek, Long> {
}
