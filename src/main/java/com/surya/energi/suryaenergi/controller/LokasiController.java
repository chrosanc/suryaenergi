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
                })
                .orElseThrow(() -> new ResourceNotFoundException("Lokasi not found"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteLokasi(@PathVariable Long id) {
        return lokasiRepository.findById(id)
                .map(lokasi -> {
                    lokasiRepository.delete(lokasi);
                    return ResponseEntity.ok().build();
                })
                .orElseThrow(() -> new ResourceNotFoundException("Lokasi not found"));
    }
}
