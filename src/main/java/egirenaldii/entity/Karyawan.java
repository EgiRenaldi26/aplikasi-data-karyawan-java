package egirenaldii.entity;

public class Karyawan {
    
    private Integer id;
    private String nama;
    private String alamat;
    private String email;

    //Constructur
    public Karyawan() {

    }

    public Karyawan(Integer id,String nama, String alamat,  String email) {
        this.id = id;
        this.nama = nama;
        this.alamat = alamat;
        this.email = email;
    }
    public Karyawan( String nama, String alamat, String email) {
        this.nama = nama;
        this.alamat = alamat;
        this.email = email;
    }

    //Getter
    public Integer getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }
    public String getAlamat() {
        return alamat;
    }
    public String getEmail() {
        return email;
    }

    //Setter
    public void setId(Integer id) {
        this.id = id;
    }
    public void setnama(String nama) {
        this.nama =  nama;
    }
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public void setNama(String nama2) {
    }
}
   