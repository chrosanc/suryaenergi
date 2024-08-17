package com.surya.energi.suryaenergi.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class ProyekLokasiId implements Serializable {

    public ProyekLokasiId(Long id, Long lokasiId1) {
    }

    @Column(name = "proyek_id")
    private Long proyekId;

    @Column(name = "lokasi_id")
    private Long lokasiId;

    // Getters, Setters, hashCode, equals
}
