package com.surya.energi.suryaenergi.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.surya.energi.suryaenergi.model.Lokasi;

@Repository
public interface LokasiRepository extends JpaRepository<Lokasi, Long> {
}
