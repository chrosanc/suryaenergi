@Entity
@Table(name = "proyek")
public class Proyek {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String namaProyek;
    private String client;
    
    @Column(name = "tgl_mulai")
    private LocalDateTime tglMulai;

    @Column(name = "tgl_selesai")
    private LocalDateTime tglSelesai;

    private String pimpinanProyek;
    
    @Lob
    private String keterangan;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    // Getters and Setters
}
