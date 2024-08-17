package com.surya.energi.suryaenergi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.surya.energi.suryaenergi.model.ProyekLokasi;
import com.surya.energi.suryaenergi.model.ProyekLokasiId;

@Repository
public interface ProyekLokasiRepository extends JpaRepository<ProyekLokasi, ProyekLokasiId> {
}
