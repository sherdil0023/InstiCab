package com.InstiCab.service.Implementation;

import com.InstiCab.dao.DriverDAO;
import com.InstiCab.models.Driver;
import com.InstiCab.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverServiceImpl implements DriverService {

    private final DriverDAO driverDAO;

    @Autowired
    public DriverServiceImpl(DriverDAO driverDAO){
        this.driverDAO = driverDAO;
    }

    @Override
    public Driver getDriverByDriverId(Long driverId) {
        return driverDAO.getDriverDataBydriverId(driverId);
    }

    @Override
    public Driver getDriverByUsername(String username) {
        return driverDAO.getDriverDataByUsername(username);
    }

    @Override
    public void saveDriver(Driver driver) {
        driverDAO.createDriver(driver);
    }

    @Override
    public List<Driver> getPendingDrivers() {
        return driverDAO.getAllPendingDrivers();
    }
}
