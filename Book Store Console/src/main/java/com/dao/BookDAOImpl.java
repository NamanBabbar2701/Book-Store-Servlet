package com.dao;

import com.model.Book;
import com.util.DBUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookDAOImpl implements BookDAO {
    @Override
    public int insert(Book book) {
        try {
            String sql = "insert into books(name, price) values(?, ?)";
            PreparedStatement preparedStatement = DBUtil.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, book.getName());
            preparedStatement.setFloat(2, book.getPrice());
            int res = 0;
            res = preparedStatement.executeUpdate();
            return res;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int delete(int id){
        try {

            String sql1 = "delete from books where id = ?";
            PreparedStatement preparedStatement1 = DBUtil.getConnection().prepareStatement(sql1);
            preparedStatement1.setInt(1, id);
            int res1 = 0;
            res1 = preparedStatement1.executeUpdate();
            return res1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int update(Book book){
        try{

            String sql2 = "update books SET name = ? , price = ? Where id = ?";
            PreparedStatement preparedStatement2 = DBUtil.getConnection().prepareStatement(sql2);
            preparedStatement2.setString(1, book.getName());
            preparedStatement2.setFloat(2,book.getPrice());
            preparedStatement2.setInt(3,book.getId());
            int res2 = 0;
            res2 = preparedStatement2.executeUpdate();
            return res2;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Book> view() {
        List<Book> books = new ArrayList<>();
        try {
            Statement statement = DBUtil.getConnection().createStatement();
            String sql = "select * from books";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next())
                books.add(new Book(
                                    resultSet.getInt(1),
                                    resultSet.getString(2),
                                    resultSet.getFloat(3))
                );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    @Override
    public Book view(int id) {
        return null;
    }

    @Override
    public List<Book> view(String name) {
        return List.of();
}

}