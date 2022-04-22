package priv.mw.controller.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import priv.mw.annotation.UserId;
import priv.mw.domain.Assets;
import priv.mw.exception.ClientException;
import priv.mw.service.system.FileService;
import priv.mw.utils.FileUtils;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/file")
public class FileController {

    private FileService fileService;

    @Autowired
    public void setFileService(FileService fileService) {
        this.fileService = fileService;
    }

    @PostMapping("/uploadFile")
    public Assets uploadFile(@RequestParam("file") MultipartFile file, @UserId("base") Integer id) throws ClientException {
        System.out.println(file);
        System.out.println(file.getName());
        return fileService.uploadFile(file, id);
    }
}
