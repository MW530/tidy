package priv.mw.controller.system;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import priv.mw.exception.ClientException;

@RestController
public class Error {
    @RequestMapping("/**")
    public String NotFound() throws ClientException {
        throw new ClientException("请求地址出错！");
    }
}
