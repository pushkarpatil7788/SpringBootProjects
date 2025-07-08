package com.infosys.MySqlRest.service;

import com.infosys.MySqlRest.model.CloudVendor;

import java.util.List;

public interface CloudvendorserviceinIterface {
    String createCloudVendor(CloudVendor cloudVendor);

    String updateCloudVendor(CloudVendor cloudVendor);

    String deleteCloudVendor(String vendorId);

    CloudVendor getCloudVendor(String vendorId);

    List<CloudVendor> getAllCloudVendors();
}
