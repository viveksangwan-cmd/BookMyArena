package com.bookmyarena.Backend.Service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

public interface IFileStorageService {
    public void save(MultipartFile file,String name,String path);
    public Resource load(String filename,String path);
    public void deleteAll(String path);
    public Stream<Path> loadAll(String path);
}
