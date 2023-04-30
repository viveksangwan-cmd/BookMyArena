package com.bookmyarena.Backend.Controllers;


import com.bookmyarena.Backend.Service.IFileStorageService;
import com.bookmyarena.Backend.Utils.Generate;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/test")
public class HeathController {

    @Autowired
    IFileStorageService fileStorageService;

    @Value("upload/${user_image_upload_path}")
    private String upload_path;

    @PostMapping(value = "/upload")
    private void uploadImage(@RequestParam("file") MultipartFile image){
        System.out.println(image.getOriginalFilename());
        String randomFileName = Generate.fileName(image.getOriginalFilename());
        fileStorageService.save(image,randomFileName,upload_path);
        fileStorageService.loadAll(upload_path);
    }

    @GetMapping("/healthcheck")
    @ResponseBody
    private int healthCheck(){
        return Response.SC_OK;
    }

}
