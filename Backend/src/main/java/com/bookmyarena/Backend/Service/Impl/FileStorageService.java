package com.bookmyarena.Backend.Service.Impl;

import com.bookmyarena.Backend.Service.IFileStorageService;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

@Service
public class FileStorageService implements IFileStorageService {

    @Override
    public void save(MultipartFile file,String name,String path) {
        Path root = Path.of(path);
        try{
            if(!Files.exists(root)){
                try{
                    Files.createDirectories(root);
                }catch (Exception e){
                    throw new RuntimeException("Unable to create folders");
                }
            }
            Files.copy(file.getInputStream(),root.resolve(name));
        }catch (Exception e){
            if(e instanceof FileAlreadyExistsException){
                throw new RuntimeException("File with this name already exits");
            }
            throw new RuntimeException("File upload failed "+e.getMessage());
        }
    }

    @Override
    public Resource load(String filename,String path) {
        return null;
    }

    @Override
    public void deleteAll(String path) {
        Path root = Path.of(path);
        FileSystemUtils.deleteRecursively(root.toFile());
    }

    @Override
    public Stream<Path> loadAll(String path) {
        Path root = Path.of(path);
        try{
            return Files.walk(root,1).filter(p -> !p.equals(root)).map(root::relativize);
        }catch (Exception e){
            throw new RuntimeException("Could not load the files");
        }
    }
}
