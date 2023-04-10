package egirenaldii.repository.Impl;

import egirenaldii.repository.KaryawanRepo;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Statement;
import java.util.List;

import javax.sql.DataSource;

import java.sql.PreparedStatement;

import egirenaldii.entity.Karyawan;

public class KaryawanRepoImpl implements KaryawanRepo{
    private DataSource dataSource;

    public KaryawanRepoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    @Override
    public void add(Karyawan karyawan) {
     
        //query
        String sql = "INSERT INTO karyawan (nama, alamat, email) VALUES (?,?,?)";
        //excute
        try (Connection connection = dataSource.getConnection(); 
        PreparedStatement statement = connection.prepareStatement(sql)) {

            //value
            statement.setString(1, karyawan.getNama());
            statement.setString(2, karyawan.getAlamat());
            statement.setString(3, karyawan.getEmail());
            // execute
            statement.executeUpdate();

        } catch (SQLException e) {       
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean update(Karyawan karyawan) {
        // Check if id is not null
        if (karyawan.getId() == null) {
            throw new IllegalArgumentException("Cannot update karyawan with null id");
        }

        //query
        String query = "UPDATE karyawan SET nama = ?, alamat = ?, email = ? WHERE id = ?";

        //execute
        try (Connection connection = dataSource.getConnection(); PreparedStatement statement = connection.prepareStatement(query)){

            //set value
            statement.setString(1, karyawan.getNama());
            statement.setString(2, karyawan.getAlamat());
            statement.setString(3, karyawan.getEmail());
            statement.setInt(4, karyawan.getId());

            //execute
            int rowsUpdated = statement.executeUpdate();

            return rowsUpdated > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean delete(Integer id) {
        String query = "DELETE FROM karyawan WHERE id = ?";

        try (Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(query)){

            statement.setInt(1, id);

            int rowsDeleted = statement.executeUpdate();

            return rowsDeleted > 0;
        
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public Karyawan[] getAll() {
        //query
        String query = "SELECT id, nama, alamat, email FROM karyawan";
        //execute
        try (Connection connection = dataSource.getConnection(); 
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query)){
        
            
            //initialize
            List<Karyawan> list = new ArrayList<Karyawan>();

            while (resultSet.next()) {
                //initialize
                Karyawan karyawan = new Karyawan();

                karyawan.setId(resultSet.getInt("id"));
                karyawan.setnama(resultSet.getString("nama"));
                karyawan.setAlamat(resultSet.getString("alamat"));
                karyawan.setEmail(resultSet.getString("email"));

                //add book
                list.add(karyawan);
            }
            //return
            return list.toArray(new Karyawan[] {});

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public Karyawan getById(Integer id) {
       //query
       String query = "SELECT id, nama, alamat,email FROM karyawan WHERE id = ?";

       //execute
       try (Connection connection = dataSource.getConnection();
       PreparedStatement statement = connection.prepareStatement(query)){

           //set value
           statement.setInt(1, id);

           try(ResultSet resultSet = statement.executeQuery();) {
           
               //initialize
            Karyawan karyawan = new Karyawan();
           
           while (resultSet.next()){
               //set value
               karyawan.setId(resultSet.getInt("id"));
               karyawan.setnama(resultSet.getString("nama"));
               karyawan.setAlamat(resultSet.getString("alamat"));
               karyawan.setEmail(resultSet.getString("email"));
           }

           //return
           return karyawan;
               
           }
           
       } catch (SQLException e) {
           throw new RuntimeException(e);
       }
    }
}
