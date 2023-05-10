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
@RequestMapping("api/test")
public class HeathController {
    @GetMapping("/healthcheck")
    @ResponseBody
    private int healthCheck(){
        return Response.SC_OK;
    }

}
