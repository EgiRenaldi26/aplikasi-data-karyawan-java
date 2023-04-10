package egirenaldii;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.util.Scanner;

import egirenaldii.Util.DatabaseUtil;
import egirenaldii.Util.InputUtil;
import egirenaldii.repository.KaryawanRepo;
import egirenaldii.service.KaryawanService;
import egirenaldii.repository.Impl.KaryawanRepoImpl;
import egirenaldii.service.impl.KaryawanServiceImpl;
import egirenaldii.view.KaryawanView;

public class App 
{
    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);
    private static KaryawanService karyawanService;

  
    public static void main( String[] args )
    {
       Scanner scanner = new Scanner(System.in);
        String username, password, role;
        boolean isLoggedIn = false;

        // Database users
        String[][] users = {
                {"admin", "admin", "admin"},
                {"user", "user", "user"},
        };

        do {
            System.out.print("Enter username: ");
            username = scanner.nextLine();
            System.out.print("Enter password: ");
            password = scanner.nextLine();

            // Loop through users
            for (int i = 0; i < users.length; i++) {
                if (username.equals(users[i][0]) && password.equals(users[i][1])) {
                    role = users[i][2];
                    System.out.println("=========================================================================");
                    System.out.println("Selamat datang di PT EGI RENALDI MEDIA, " + username + " anda login sebagai, " + role + "");
                    System.out.println("=========================================================================");
                    System.out.println("*************************************************************************");
                    System.out.println("                                                                         ");
                    isLoggedIn = true;

                //     if (role.equals("admin") || role.equals("user")) {
                //         // datasource
                //         DataSource dataSource = DatabaseUtil.getDataSource();

                //         //set data
                //         KaryawanRepo karyawanRepo = new KaryawanRepoImpl(dataSource);
                //         KaryawanService bookService = new KaryawanServiceImpl(karyawanRepo);

                //         //view
                //         KaryawanView karyawanView = new KaryawanView(bookService);

                //         //show view
                //        karyawanView.showMenu();

                //     } else {
                //         System.out.println("Invalid role. Please try again.");
                //         isLoggedIn = false;
                //     }

                //     break;
                // }
            // }
            if (role.equals("admin")) {
            // datasource
            DataSource dataSource = DatabaseUtil.getDataSource();

            //set data
            KaryawanRepo karyawanRepo = new KaryawanRepoImpl(dataSource);
            KaryawanService karyawanService = new KaryawanServiceImpl(karyawanRepo);

            //view
            KaryawanView karyawanView = new KaryawanView(karyawanService);

            //show view
            karyawanView.showMenu();

                } else if (role.equals("user")) { // Jika role adalah user
                    //fitur user
                   // datasource
                    DataSource dataSource = DatabaseUtil.getDataSource();

                    //set data
                    KaryawanRepo karyawanRepo = new KaryawanRepoImpl(dataSource);
                    KaryawanService karyawanService = new KaryawanServiceImpl(karyawanRepo);

                    //view
                    KaryawanView karyawanView = new KaryawanView(karyawanService);

                    //show view
                    karyawanView.showMenuUser();
                    // DataSource dataSource = DatabaseUtil.getDataSource();
                    // KaryawanRepo karyawanRepo = new KaryawanRepoImpl(dataSource);
                    // KaryawanService karyawanService = new KaryawanServiceImpl(karyawanRepo);
                    // KaryawanView karyawanView = new KaryawanView(karyawanService);

                    // // Menambahkan filter agar user hanya bisa melihat data saja, tidak bisa CRUD
                    // karyawanView.setCanCreate(false);
                    // karyawanView.setCanUpdate(false);
                    // karyawanView.setCanDelete(false);

                    //show view
                    // karyawanView.showMenu();
                } else {
                    System.out.println("Invalid role. Please try again.");
                    isLoggedIn = false;
                }

                break;
                }
            }
            if (!isLoggedIn) {
                System.out.println("Username dan Password tidak di temukan");
            }
        } while (!isLoggedIn);
    }
}