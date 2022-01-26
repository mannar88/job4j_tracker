package ru.job4j.tracker;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SqlTracker implements Store, AutoCloseable {

    private Connection cn;

    public void init() {
        try (InputStream in = SqlTracker.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            cn = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void close() throws Exception {
        if (cn != null) {
            cn.close();
        }
    }

    @Override
    public Item add(Item item) {
        try (PreparedStatement statement =
                     cn.prepareStatement("insert into items(name, created) values (?,?)       ", Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, item.getName());
            statement.setTimestamp(2, Timestamp.valueOf(item.getCreated()));
            if (!statement.execute()) {
                ResultSet resultSet = statement.getGeneratedKeys();
                resultSet.next();
                item.setId(resultSet.getInt(1));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        return deleteAndReplays(id, "update items set name='" + item.getName() + "'where id=") > 0;
    }

    @Override
    public boolean delete(int id) {
        return deleteAndReplays(id, "delete from items where id=") > 0;
    }

    private int deleteAndReplays(int id, String sql) {
        int rsl = -1;
        try (PreparedStatement statement = cn.prepareStatement(sql + id)) {
            rsl = statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rsl;

    }

    @Override
    public List<Item> findAll() {
        return searchItems("select*from items");
    }

    @Override
    public List<Item> findByName(String key) {
        return searchItems("select*from items where name LIKE '%" + key + "%'");
    }

    private List<Item> searchItems(String sql) {
        List<Item> items = new ArrayList<>();
        try (PreparedStatement statement = cn.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                items.add(new Item(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getTimestamp("created").toLocalDateTime()));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return items;
    }

    @Override
    public Item findById(int id) {
        Item item = new Item();
        try (PreparedStatement statement = cn.prepareStatement("select*from items where id=" + id)) {
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                item.setId(resultSet.getInt("id"));
                item.setName(resultSet.getString("name"));
                item.setCreated(resultSet.getTimestamp("created").toLocalDateTime());
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return item.getId() > 0 ? item : null;
    }

}