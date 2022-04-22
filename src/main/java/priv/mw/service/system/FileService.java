package priv.mw.service.system;

import org.springframework.web.multipart.MultipartFile;
import priv.mw.domain.Assets;
import priv.mw.exception.ClientException;

public interface FileService {
    public Assets uploadFile(MultipartFile file, Integer uid) throws ClientException;
}
