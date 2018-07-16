package starter.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping(value = "/test")
public class TestController {
    @RequestMapping(value = "/getOverallDesc/{imgid}",method = RequestMethod.GET)
    public String getOverallDesc(@PathVariable("imgid") String imgid){

        return "";
    }
}
