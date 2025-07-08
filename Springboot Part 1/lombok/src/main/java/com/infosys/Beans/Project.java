package com.infosys.Beans;

import lombok.Data;
import org.springframework.stereotype.Component;


@Component
@Data  //@getter , @setter, @hashcode,@ToString,
public class Project {

    public String projectName;
    public String projectTeamName;

}
