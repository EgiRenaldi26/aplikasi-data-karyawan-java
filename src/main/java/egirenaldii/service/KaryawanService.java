package egirenaldii.service;

import egirenaldii.entity.Karyawan;

public interface KaryawanService {

    //add
    public void add(String nama, String alamat, String email);    
    //getAll
    public void getAll();
    //get by id
    public Karyawan getById(Integer id);
    //update
    public void update(Integer id, String nama, String alamat, String email);
    //delete
    public void delete(Integer id);
}
