package com.example.pruebaSQL.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.pruebaSQL.models.User;

@Repository
public class UserRepositories {
    private final JdbcTemplate sql;

    @Autowired
    public UserRepositories(JdbcTemplate sql){
        this.sql = sql;
    }

    public User getUserById(int id){
        return sql.queryForObject("SELECT * FROM user WHERE id = ?", new Object[]{id}, BeanPropertyRowMapper.newInstance(User.class));
    }

    public List<User> getAlluser(){
        return sql.query("SELECT * FROM user", BeanPropertyRowMapper.newInstance(User.class));
    }

    public void newUser(User user){
        sql.update("INSERT INTO user (name, last) VALUES (?,?)",user.getName(), user.getLast());
    }

    public void updateUser(int id, User user){
        sql.update("UPDATE user SET name = ?, last = ? WHERE id = ?", user.getName(), user.getLast(), id);
    }

    public void deleteById(int id){
        sql.update("DELETE FROM user WHERE id = ?", id);
    }
}
