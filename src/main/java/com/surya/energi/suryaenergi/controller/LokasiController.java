package com.surya.energi.suryaenergi.controller;


import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.surya.energi.suryaenergi.model.Lokasi;
import com.surya.energi.suryaenergi.repository.LokasiRepository;

@RestController
@RequestMapping("/lokasi")
public class LokasiController {

    @Autowired
    private LokasiRepository lokasiRepository;

    @PostMapping
    public Lokasi createLokasi(@RequestBody Lokasi lokasi) {
        lokasi.setCreatedAt(LocalDateTime.now());
        return lokasiRepository.save(lokasi);
    }

    @GetMapping
    public List<Lokasi> getAllLokasi() {
        return lokasiRepository.findAll();
    }

    @PutMapping("/{id}")
    public Lokasi updateLokasi(@PathVariable Long id, @RequestBody Lokasi updatedLokasi) {
        return lokasiRepository.findById(id)
                .map(lokasi -> {
                    lokasi.setNamaLokasi(updatedLokasi.getNamaLokasi());
                    lokasi.setNegara(updatedLokasi.getNegara());
                    lokasi.setProvinsi(updatedLokasi.getProvinsi());
                    lokasi.setKota(updatedLokasi.getKota());
                    return lokasiRepository.save(lokasi);
                }).orElseThrow();
                
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteLokasi(@PathVariable Long id) {
        return lokasiRepository.findById(id)
                .map(lokasi -> {
                    lokasiRepository.delete(lokasi);
                    return ResponseEntity.ok().build();
                })
                .orElseThrow();
    }
}
