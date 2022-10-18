package com.InstiCab.dao;

import com.InstiCab.models.Trip;
import com.InstiCab.utils.RowMappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TripDAO {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public TripDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void saveTrip(Trip trip) throws Exception {
        final String sql = "INSERT INTO trip(status,start_latitude,start_longitude,end_latitude,end_longitude," +
                "passenger_id) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            jdbcTemplate.update(sql,trip.getStatus(),trip.getStartLatitude(),trip.getStartLongitude(),
                    trip.getEndLatitude(),trip.getEndLongitude(),trip.getPassengerId());
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public boolean tripAlreadyExists(Long passengerId) {
        final String sql = "SELECT * FROM trip WHERE status=0 AND passenger_id=?";
        try {
            return !jdbcTemplate.query(sql, RowMappers.tripRowMapper,passengerId).isEmpty();
        } catch (Exception e) {
            System.out.println(e);
            throw new UsernameNotFoundException("Error");
        }
    }

    public List<Trip> getTripList(Long driverId) throws Exception {
        final String sql = "SELECT * from trip WHERE driver_id = ?";
        try {
            return jdbcTemplate.query(sql,RowMappers.tripRowMapper,driverId);
        }catch (Exception e) {
            throw new Exception(e);
        }
    }
}
