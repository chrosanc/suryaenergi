@Entity
@Table(name = "lokasi")
public class Lokasi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String namaLokasi;
    private String negara;
    private String provinsi;
    private String kota;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    // Getters and Setters
}
