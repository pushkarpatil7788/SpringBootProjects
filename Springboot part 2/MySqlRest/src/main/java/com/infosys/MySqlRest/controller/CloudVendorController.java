package com.infosys.MySqlRest.controller;

import com.infosys.MySqlRest.model.CloudVendor;
import com.infosys.MySqlRest.service.CloudvendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cloudvendor")
public class CloudVendorController {

    @Autowired
    private CloudvendorService cloudvendorService;

    @GetMapping("/{vendorId}")
    public CloudVendor getCloudVendorDetail(@PathVariable("vendorId") String vendorId) {
        return cloudvendorService.getCloudVendor(vendorId);
    }

    @GetMapping
    public List<CloudVendor> getAllVendors() {
        return cloudvendorService.getAllCloudVendors();
    }


    @PostMapping
    public String createCloudVendor(@RequestBody CloudVendor cloudVendor) {
        cloudvendorService.createCloudVendor(cloudVendor);
        return "Cloud vendor created successfully!";
    }

    @PutMapping("/{vendorId}")
    public String updateCloudVendor(@PathVariable("vendorId") String vendorId,
                                    @RequestBody CloudVendor cloudVendor) {
        cloudVendor.setVendorId(vendorId);
        cloudvendorService.updateCloudVendor(cloudVendor);
        return "Cloud vendor updated successfully!";
    }


    @DeleteMapping("/{vendorId}")
    public String deleteCloudVendor(@PathVariable("vendorId") String vendorId) {
        cloudvendorService.deleteCloudVendor(vendorId);
        return "Cloud vendor deleted successfully!";
    }
}
