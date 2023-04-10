package egirenaldii.view;

import java.util.Scanner;

import egirenaldii.Util.InputUtil;
import egirenaldii.entity.Karyawan;
import egirenaldii.service.KaryawanService;

public class KaryawanView {
    
    //karyawan Service
    private KaryawanService karyawanService;
    private boolean canCreate;
    private boolean canUpdate;
    private boolean canDelete;
    private Object input;

    public KaryawanView(KaryawanService karyawanService){
        this.karyawanService = karyawanService;
    }

    //show menu
    public void showMenu(){
        while (true) {
            System.out.println("============ MAIN MENU ===========");
            System.out.println("1.INSERT DATA Karyawan");
            System.out.println("2.UPDATE DATA Karyawan");
            System.out.println("3.SHOW DATA Karyawan");
            System.out.println("4.SHOW DATA By ID");
            System.out.println("5.DELETE");
            System.out.println("<=.Exit");
            System.out.println("==================================");
            String input = InputUtil.input("Choose >");
        
            if(input.equals("1")) {
                insertData();
            }else if (input.equals("3")) {
                showData();
            }else if (input.equals("2")) {
                updateData();
            }else if (input.equals("4")) {
                showDataById();
            }else if(input.equals("X")) {
                break;
            }else if(input.equals("5")) {
                deleteData();
            }else {
                 System.out.println("Anda Tidak Memilih");
            }
        }
    }

    //show menu user
    public void showMenuUser(){
        while (true) {
            System.out.println("============ MENU UTAMA ===========");
            System.out.println("1.SHOW DATA Karyawan");
            System.out.println("2.SHOW DATA By ID");
            System.out.println("<=.Exit");
            System.out.println("==================================");
            String input = InputUtil.input("Choose >");

            if(input.equals("1")) {
                showData();
            }else if (input.equals("2")) {
                showDataById();
            }else if(input.equals("X")) {
                break;
            }else {
                System.out.println("Anda Tidak Memilih");
           }
        }

    }
    //insert data
    public void insertData(){
        System.out.println("========== PT EGIRENALDI MEDIA ===========");

        //get data input
        String nama = InputUtil.input("Masukan Nama Karyawan");
        String alamat = InputUtil.input("Masukan Alamat Karyawan");
        String email = InputUtil.input("Masukan Email Karyawan");
    
        //add data
        karyawanService.add(nama, alamat, email);
    }
    //update data
    public void updateData() {
        Scanner scanner = new Scanner(System.in);
    
        System.out.print("Masukan ID Karyawan: ");
    
        Integer id = scanner.nextInt();

        Karyawan karyawan = karyawanService.getById(id);
    
        scanner.nextLine(); // Consume newline left-over
    
        System.out.print("Masukan Nama Baru: ");
    
        String nama = scanner.nextLine();
    
        System.out.print("Masukan Alamat Baru: ");
    
        String alamat = scanner.nextLine();
    
        System.out.print("Masukan Email Baru: ");
    
        String email = scanner.nextLine();
    
        karyawanService.update(id, nama, alamat, email);
    
        System.out.println("Data Berhail di update");
        // System.out.println("======== UPDATE DATA =========");
        // System.out.println("------------------------------");
        // try (Scanner scanner = new Scanner(System.in)) {
        //     System.out.print("Masukan Book ID to Update: ");
        //     int id = scanner.nextInt();
   
        //     // get book by id
        //     Book book = bookService.getById(id);
   
        //     if (book == null) {
        //         System.out.println("Book with ID " + id + " Tidak Tersedia");
        //     } else {
        //         System.out.print("Masukan Nama Buku: ");
        //         String title = scanner.next();
   
        //         System.out.print("Masukan Nama Penulis: ");
        //         String author = scanner.next();
   
        //         System.out.print("Masukan Tahun Terbit: ");
        //         int year = scanner.nextInt();
   
        //         // update book
        //         bookService.update(id, title, author, year);
        //         System.out.println("Book data updated successfully");
        //     }
        // }
    }
    //show data
    public void showData(){

        System.out.println("========== SHOW DATA PT EGIRENALDI MEDIA ===========");

        //show
        karyawanService.getAll();
    }
    //delete data
    public void deleteData(){

        System.out.println("========== DELETE DATA PT EGIRENALDI MEDIA===========");

        String id = InputUtil.input("Id");

        //show
        karyawanService.delete(Integer.valueOf(id));
    }
    //show data byid
    public void showDataById(){

        System.out.println("========== SHOW DATA By ID ===========");

        String id = InputUtil.input("Id");

        //show
        karyawanService.getById(Integer.valueOf(id));
    }

    public void tambah() {
        System.out.println("anda tidak memiliki akses");
    }
}
