package ru.job4j.tracker;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

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
            statement.execute();
            try (ResultSet resultSet = statement.getGeneratedKeys()) {
                if (resultSet.next()) {
                    item.setId(resultSet.getInt(1));
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        int rsl = -1;
        try (PreparedStatement statement = cn.prepareStatement("update items SET name=?, created=? where id=?")) {
            statement.setString(1, item.getName());
            statement.setTimestamp(2, Timestamp.valueOf(item.getCreated()));
            statement.setInt(3, id);
            rsl = statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return rsl > 0;
    }

    @Override
    public boolean delete(int id) {
        int rsl = -1;
        try (PreparedStatement statement = cn.prepareStatement("delete from items where id=?")) {
            statement.setInt(1, id);
            rsl = statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rsl > 0;

    }

    @Override
    public List<Item> findAll() {
        List<Item> items = new ArrayList<>();
        try (PreparedStatement statement = cn.prepareStatement("select*from items")) {
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
    public List<Item> findByName(String key) {
        return findAll().stream()
                .filter(item -> item.getName().contains(key))
                .collect(Collectors.toList());
    }

    @Override
    public Item findById(int id) {
        Item item = new Item();
        try (PreparedStatement statement = cn.prepareStatement("select*from items where id=?")) {
            statement.setInt(1, id);
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