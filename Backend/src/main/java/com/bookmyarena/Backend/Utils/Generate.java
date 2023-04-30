package com.bookmyarena.Backend.Utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.UUID;

public class Generate {
    public static String fileName(String fileName){
        String random = UUID.randomUUID().toString();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        LocalDateTime now = LocalDateTime.now();
        return fileName.substring(0,fileName.lastIndexOf('.')).concat(random).concat(dtf.format(now));
    }
}
