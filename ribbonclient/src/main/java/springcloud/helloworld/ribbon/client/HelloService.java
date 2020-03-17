package springcloud.helloworld.ribbon.client;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Service
@RestController
@Api(tags="ribbon controller示例")
public class HelloService {
    @Autowired RestTemplate restTemplate;
    @RequestMapping(value="/",method = RequestMethod.GET)
    @ApiOperation(value="demo示例")
    public String getHelloContent() {
        return restTemplate.getForObject("http://SERVICE-HELLOWORLD/",String.class);
    }

    @RequestMapping(value="/testApi",method = RequestMethod.GET)
    @ApiOperation(value="demo示例2")
    public String testApi(String s) {
        return s;
    }
}