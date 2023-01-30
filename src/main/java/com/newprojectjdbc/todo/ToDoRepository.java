package com.newprojectjdbc.todo;

import java.sql.*;
import java.util.ArrayList;

public class ToDoRepository {
    public ToDoRepository(){}

    public void createToDo(ToDoItem todo){
        String query = "INSERT INTO todos(description, status) values(?, ?)";
        try{
            PreparedStatement pstmt = this.getConnection().prepareStatement(query);
            pstmt.setString(1, todo.getDescription());
            pstmt.setBoolean(2, todo.getComplete());
            pstmt.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    public ArrayList<ToDoItem> findAllTodos(){
        ArrayList<ToDoItem> todoList = new ArrayList<>();
        String query = "SELECT * FROM todos";
        try{
            PreparedStatement pstmt = this.getConnection().prepareStatement(query);
            ResultSet resultSet = pstmt.executeQuery();
            while(resultSet.next()){
                todoList.add(new ToDoItem(
                        resultSet.getInt("id"),
                        resultSet.getString("description"),
                        resultSet.getBoolean("status"),
                        resultSet.getTimestamp("createdAt"),
                        resultSet.getTimestamp("updatedAt")
                        ));

            }
        } catch(SQLException e){
            e.printStackTrace();
        }

        return todoList;
    }

    private Connection getConnection(){
        String username = "root";
        String password = "rootroot";
        String database = "spring_todo";

        String url = "jdbc:mysql://localhost:3306/" + database;

        Connection connection = null;

        try{
            connection = DriverManager.getConnection(url, username, password);

        }catch (SQLException e){
            e.printStackTrace();
        }

        return connection;
    }
}
