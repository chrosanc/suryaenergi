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

    // Getters and Setters
}
