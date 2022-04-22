package priv.mw.service.system.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import priv.mw.domain.Assets;
import priv.mw.exception.ClientException;
import priv.mw.mapper.system.FileMapper;
import priv.mw.service.system.FileService;
import priv.mw.utils.FileUtils;
import priv.mw.utils.RandomUtils;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;
import java.util.logging.SimpleFormatter;

@Service("FileServiceImpl")
public class FileServiceImpl implements FileService {

    @Value("#{tidy.tidyFileCachePath}")
    private String tidyFileCachePath;


    private FileMapper fileMapper;

    @Autowired
    public void setFileMapper(FileMapper fileMapper) {
        this.fileMapper = fileMapper;
    }

    @Override
    @Transactional
    public Assets uploadFile(MultipartFile file, Integer uId) throws ClientException {
        String fileName = file.getOriginalFilename();
        String uuid = UUID.nameUUIDFromBytes((fileName + RandomUtils.getRandomString(20, true)).getBytes()).toString();
        LocalDateTime localDateTime = LocalDateTime.now();
        String fileSuffix = FileUtils.fileSuffix(fileName);
//        String targetName = uuid + localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-ddHH:mm:ss")) + "." + fileSuffix;
        String reqName = uuid + "." + fileSuffix;
        String fileType = FileUtils.fileType(fileSuffix);
        if(fileType == null){
            throw new ClientException("文件类型不支持！");
        }

        Assets assets = new Assets(null, uId,  uuid, reqName, fileType, localDateTime);
        fileMapper.saveFile(assets);
        String targetName =assets.getId() + "_"+  uuid + "." + fileSuffix;
        FileUtils.saveFile(file, fileType, targetName,tidyFileCachePath);
        return assets;
    }
}
