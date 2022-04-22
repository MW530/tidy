package priv.mw.controller.system;

import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import priv.mw.exception.ClientException;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class ErrorController {

    @RequestMapping("/404")
    public String NotFound(HttpServletRequest request, HttpServletResponse response) throws ClientException, IOException {
        throw new ClientException("请求地址出错！");
    }
}
