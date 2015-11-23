package za.ac.cput.project.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.project.domain.Client;
import za.ac.cput.project.module.ClientResource;
import za.ac.cput.project.services.ClientService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/10/24.
 */
@RestController
@RequestMapping("/api/**")
public class HomePage {

    @RequestMapping(value = "Home",method = RequestMethod.GET)
    public String Index(){
        return "this is my home page kwasa";
    }

    @RequestMapping(value = "Error",method = RequestMethod.GET)
    public String error(){
        return "this page was not found";
    }
}
