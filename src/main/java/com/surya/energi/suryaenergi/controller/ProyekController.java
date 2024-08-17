import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.surya.energi.suryaenergi.model.Lokasi;
import com.surya.energi.suryaenergi.model.Proyek;
import com.surya.energi.suryaenergi.model.ProyekLokasi;
import com.surya.energi.suryaenergi.model.ProyekLokasiId;
import com.surya.energi.suryaenergi.repository.LokasiRepository;
import com.surya.energi.suryaenergi.repository.ProyekLokasiRepository;
import com.surya.energi.suryaenergi.repository.ProyekRepository;

@RestController
@RequestMapping("/proyek")
public class ProyekController {

    @Autowired
    private ProyekRepository proyekRepository;

    @Autowired
    private ProyekLokasiRepository proyekLokasiRepository;

    @Autowired
    private LokasiRepository lokasiRepository;

    @PostMapping
    public Proyek createProyek(@RequestBody Proyek proyek, @RequestParam Long lokasiId) {
        proyek.setCreatedAt(LocalDateTime.now());
        Proyek savedProyek = proyekRepository.save(proyek);

        Lokasi lokasi = lokasiRepository.findById(lokasiId)
                .orElseThrow(() -> new ResourceNotFoundException("Lokasi not found"));

        ProyekLokasi proyekLokasi = new ProyekLokasi();
        proyekLokasi.setProyek(savedProyek);
        proyekLokasi.setLokasi(lokasi);
        proyekLokasiRepository.save(proyekLokasi);

        return savedProyek;
    }

    @GetMapping
    public List<Proyek> getAllProyek() {
        return proyekRepository.findAll();
    }

    @PutMapping("/{id}")
    public Proyek updateProyek(@PathVariable Long id, @RequestBody Proyek updatedProyek, @RequestParam Long lokasiId) {
        return proyekRepository.findById(id)
                .map(proyek -> {
                    proyek.setNamaProyek(updatedProyek.getNamaProyek());
                    proyek.setClient(updatedProyek.getClient());
                    proyek.setTglMulai(updatedProyek.getTglMulai());
                    proyek.setTglSelesai(updatedProyek.getTglSelesai());
                    proyek.setPimpinanProyek(updatedProyek.getPimpinanProyek());
                    proyek.setKeterangan(updatedProyek.getKeterangan());
                    Proyek savedProyek = proyekRepository.save(proyek);

                    ProyekLokasi proyekLokasi = proyekLokasiRepository.findById(new ProyekLokasiId(savedProyek.getId(), lokasiId))
                            .orElse(new ProyekLokasi());
                    proyekLokasi.setProyek(savedProyek);
                    proyekLokasi.setLokasi(lokasiRepository.findById(lokasiId)
                            .orElseThrow(() -> new ResourceNotFoundException("Lokasi not found")));
                    proyekLokasiRepository.save(proyekLokasi);

                    return savedProyek;
                })
                .orElseThrow(() -> new ResourceNotFoundException("Proyek not found"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProyek(@PathVariable Long id) {
        return proyekRepository.findById(id)
                .map(proyek -> {
                    proyekRepository.delete(proyek);
                    return ResponseEntity.ok().build();
                })
                .orElseThrow(() -> new ResourceNotFoundException("Proyek not found"));
    }
}
