package egirenaldii.repository;

import egirenaldii.entity.Karyawan;

public interface KaryawanRepo {
    
    //add
    public void add(Karyawan karyawan);
    //Get all
    public Karyawan[] getAll();
    //Get by id
    public Karyawan getById(Integer id);
    //update
    public boolean update(Karyawan karyawan);
    //Delete
    public boolean delete(Integer id);

}
