package com.surya.energi.suryaenergi.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "proyek_lokasi")
public class ProyekLokasi {

    @EmbeddedId
    private ProyekLokasiId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("proyekId")
    private Proyek proyek;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("lokasiId")
    private Lokasi lokasi;

    // Default constructor
    public ProyekLokasi() {}

    // Constructor with parameters
    public ProyekLokasi(ProyekLokasiId id, Proyek proyek, Lokasi lokasi) {
        this.id = id;
        this.proyek = proyek;
        this.lokasi = lokasi;
    }

    // Getters and Setters

    public ProyekLokasiId getId() {
        return id;
    }

    public void setId(ProyekLokasiId id) {
        this.id = id;
    }

    public Proyek getProyek() {
        return proyek;
    }

    public void setProyek(Proyek proyek) {
        this.proyek = proyek;
    }

    public Lokasi getLokasi() {
        return lokasi;
    }

    public void setLokasi(Lokasi lokasi) {
        this.lokasi = lokasi;
    }
}
