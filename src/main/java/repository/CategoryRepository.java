package repository;

import entity.Category;
import entity.Response;
import utils.DatabaseConfig;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepository {

    public static List<Category> getCategories(){
        Connection ulanish = DatabaseConfig.connection();
        List<Category>categoryList = new ArrayList<>();
        try {
            Statement statement = ulanish.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from category");


            while (resultSet.next()){
                Category category = new Category();
//                System.out.println(resultSet.getInt(1));
//                System.out.println(resultSet.getString(2));
//                System.out.println(resultSet.getBoolean(3));
                // System.out.println("=========================================");
                category.setId(resultSet.getInt(1));
                category.setName(resultSet.getString(2));
                category.setActive(resultSet.getBoolean(3));
                categoryList.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categoryList;

    }
    public  static boolean addCategory(int id,String name ) throws SQLException {
        Connection connection=DatabaseConfig.connection();
        PreparedStatement preparedStatement= connection.prepareStatement("insert into category values(?,?,?)");
        preparedStatement.setInt(1,id);
        preparedStatement.setString(2,name);
        preparedStatement.setBoolean(3,true);
        return preparedStatement.execute();
    }

    public static  Response callFunction(String name,String type,String n_name) throws SQLException {
        Connection connection=DatabaseConfig.connection();
        Response response=new Response();
        CallableStatement callableStatement= connection.prepareCall("{call category_crud(?,?,?,?,?)}");
        callableStatement.setString(1,name);
        callableStatement.setString(2,type);
        callableStatement.setString(3,n_name);
        callableStatement.registerOutParameter(4,Types.BOOLEAN);
        callableStatement.registerOutParameter(5,Types.VARCHAR);

//        ResultSet resultSet=callableStatement.executeQuery();

        callableStatement.execute();

         response.setSuccess(callableStatement.getBoolean(4));
            response.setMessage(callableStatement.getString(5));

        return response;

    }
}