package com.infosys.MySqlRest.service;

import com.infosys.MySqlRest.model.CloudVendor;
import com.infosys.MySqlRest.repos.CloudVendorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CloudvendorService implements CloudvendorserviceinIterface {

    @Autowired
    private CloudVendorRepo cloudVendorRepo;


    @Override
    public String createCloudVendor(CloudVendor cloudVendor) {
        cloudVendorRepo.save(cloudVendor);
        return "Cloud vendor created successfully!";
    }


    @Override
    public String updateCloudVendor(CloudVendor cloudVendor) {
        cloudVendorRepo.save(cloudVendor);
        return "Cloud vendor updated successfully!";
    }


    @Override
    public String deleteCloudVendor(String vendorId) {
        cloudVendorRepo.deleteById(vendorId);
        return "Cloud vendor deleted successfully!";
    }


    @Override
    public CloudVendor getCloudVendor(String vendorId) {
        Optional<CloudVendor> optional = cloudVendorRepo.findById(vendorId);
        return optional.orElse(null); // Return null if not found
    }


    @Override
    public List<CloudVendor> getAllCloudVendors() {
        return cloudVendorRepo.findAll();
    }
}
