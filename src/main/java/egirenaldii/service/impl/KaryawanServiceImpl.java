
package egirenaldii.service.impl;

import egirenaldii.entity.Karyawan;
import egirenaldii.repository.KaryawanRepo;
import egirenaldii.service.KaryawanService;

public class KaryawanServiceImpl implements KaryawanService {

    private KaryawanRepo karyawanRepo;

    public KaryawanServiceImpl(KaryawanRepo karyawanRepo) {
        this.karyawanRepo = karyawanRepo;
    }

    @Override   
    public void add(String nama, String alamat, String email) {
        Karyawan karyawan = new Karyawan(nama, alamat, email);
       
        //add karyawan
        karyawanRepo.add(karyawan);
        //return
        System.out.println("Karyawan Added Successfully : " + karyawan.getNama());
    }

    @Override
    public void getAll() {
        Karyawan[] list = karyawanRepo.getAll();

        //return
        for (Karyawan karyawan : list) {
            System.out.println(String.format("%d. %s -- (%s - %s)", karyawan.getId(), karyawan.getNama(), karyawan.getAlamat(),
                    karyawan.getEmail()));
        }
    }

    @Override
    public Karyawan getById(Integer id) {
        //get data
        Karyawan karyawan = karyawanRepo.getById(id);

        //return
        if (karyawan != null) {
            System.out.println(String.format("%d. %s -- (%s - %s)", karyawan.getId(), karyawan.getNama(), karyawan.getAlamat(),
                    karyawan.getEmail()));
        } else {
            System.out.println("Karyawan dengan ID " + id + " tidak ditemukan.");
        }

        return karyawan;
    }

    @Override
    public void update(Integer id, String nama, String alamat, String email) {
        Karyawan karyawan = karyawanRepo.getById(id);
        if (karyawan != null) {
            karyawan.setnama(nama);
            karyawan.setAlamat(alamat);
            karyawan.setEmail(email);
            karyawanRepo.update(karyawan);
        } else {
            System.out.println("Karyawan Dengan ID " + id + " not found.");
        }
    }
    

    @Override
    public void delete(Integer id) {
        //Update Data
        boolean success = karyawanRepo.delete(id);
        if (success) {
            System.out.println("Karyawan berhasil dihapus : " + id);
        } else {
            System.out.println("Karyawan dengan ID " + id + " tidak ditemukan.");
        }
    }
    
}

// package egirenaldii.service.impl;

// import egirenaldii.entity.Karyawan;
// import egirenaldii.repository.KaryawanRepo;
// import egirenaldii.service.KaryawanService;

// public class KaryawanServiceImpl implements KaryawanService{

//     private KaryawanRepo karyawanRepo;

//     public KaryawanServiceImpl(KaryawanRepo karyawanRepo){
//         this.karyawanRepo = karyawanRepo;
//     }


//     @Override   
//     public void add(String nama, String alamat, String email) {
//         Karyawan karyawan = new Karyawan(nama, alamat, email);
       
//         //add book
//         karyawanRepo.add(karyawan);
//         //return
//         System.out.println("Book Added Succecfully : " + karyawan.getNama());
//     }

//     @Override
//     public void getAll() {
//         Karyawan[] list = karyawanRepo.getAll();

//         //return
//         for (Karyawan karyawan : list) {

//             //1. Nanti kita Cerita hari ini ..(Orang - 2022)
//         System.out.println(String.format("%d. %s -- (%s - %d)", karyawan.getId(), karyawan.getNama(), karyawan.getAlamat(),
//             karyawan.getEmail()));
//         }
//     }

//     @Override
//     public Karyawan getById(Integer id) {
//         //get data
//         Karyawan karyawan = karyawanRepo.getById(id);

//         //return
//         System.out.println(String.format("%d. %s -- (%s - %d)", karyawan.getId(), karyawan.getNama(), karyawan.getAlamat(),
//         karyawan.getEmail()));

//         return karyawan;


//     }

//     @Override
//     public void update(Integer id, String nama, String alamat, String email) {
//         Karyawan karyawan = karyawanRepo.getById(id);
//         if (karyawan != null) {
//             karyawan.setnama(nama);
//             karyawan.setAlamat(alamat);
//             karyawan.setEmail(email);
//             karyawanRepo.update(karyawan);
//         } else {
//             System.out.println("Karyawan Dengan ID " + id + " not found.");
//         }
//     }

//     @Override
//     public void delete(Integer id) {
//         //Update Data
//         boolean succes = karyawanRepo.delete(id);//true or false
        
//         if (succes){
//         System.out.println("Karyawan berhasil di hapus :" + id);
//         }else {
//             System.out.println("Karyawan berhasil di hapus :" + id);

//         }
//     }
    
// }

