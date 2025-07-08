package com.Infosys.SpringRest.Controller;

import com.Infosys.SpringRest.beans.CloudVendor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cloudvendor")
public class CloudAPIServices {

    @GetMapping("/{vendorId}")
    public CloudVendor getCloudVendorDetail(@PathVariable String vendorId) {
        return new CloudVendor(vendorId, "vendor1", "Pune", "1234567890");
    }


    @PostMapping
    public String createCloudVendor(@RequestBody CloudVendor cloudVendor) {
        return "Cloud Vendor created: " + cloudVendor.toString();
    }


    @PutMapping("/{vendorId}")
    public String updateCloudVendor(@PathVariable String vendorId, @RequestBody CloudVendor cloudVendor) {
        return "Cloud Vendor with ID " + vendorId + " updated to: " + cloudVendor.toString();
    }

    @DeleteMapping("/{vendorId}")
    public String deleteCloudVendor(@PathVariable String vendorId) {
        return "Cloud Vendor with ID " + vendorId + " deleted.";
    }
}
