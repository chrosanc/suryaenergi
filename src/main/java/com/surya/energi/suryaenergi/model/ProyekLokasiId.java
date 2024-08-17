@Embeddable
public class ProyekLokasiId implements Serializable {

    @Column(name = "proyek_id")
    private Long proyekId;

    @Column(name = "lokasi_id")
    private Long lokasiId;

    // Getters, Setters, hashCode, equals
}
