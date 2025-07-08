
package com.infosys.Admin_REST.proxy;

import com.infosys.Admin_REST.model.Admin;
import com.infosys.Admin_REST.model.Course;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
@FeignClient(url = "http://localhost:8081/Admin/", value = "course")
public interface Adminproxy {

    @GetMapping("/allCourse")
    List<Course> getAllCourse();
}