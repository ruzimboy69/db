import entity.Category;
import entity.Response;
import repository.CategoryRepository;
import utils.DatabaseConfig;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
//        try {
//            System.out.println(CategoryRepository.addCategory());
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        Scanner scanner=new Scanner(System.in);
//        System.out.println("id ni kiriitng:");
//        int id= scanner.nextInt();
//        scanner=new Scanner(System.in);
//        System.out.println("Nomini kiriting:");
//        String name=scanner.nextLine();
//        CategoryRepository.addCategory(id,name);
//        System.out.println("it is ok");
//        System.out.println(CategoryRepository.getCategories());

        Scanner scanner=new Scanner(System.in);
        System.out.println("nomi ni kiriitng:");
        String name= scanner.nextLine();
        scanner=new Scanner(System.in);
        System.out.println("type ni kiriting:");
        String type=scanner.nextLine();
        System.out.println("Yangi nomni   kiriting:");
        String n_name=scanner.nextLine();
        Response response=CategoryRepository.callFunction(name,type,n_name);
        System.out.println("it is ok");
        System.out.println(response);
        System.out.println(CategoryRepository.getCategories());

    }
}
