package com.quake.logReader.controller;

import com.quake.logReader.models.Log;
import com.quake.logReader.service.LogReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/arquivoLog")
@CrossOrigin("*")
public class LogReaderController {

    @Autowired
    private LogReaderService logReaderService;

    @PostMapping
    public Log upload(@RequestParam("arquivo") MultipartFile log) {
        try {
            final File systemDir = new File(System.getProperty("java.io.tmpdir"), log.getName());
            Files.deleteIfExists(Paths.get(systemDir.getPath()));
            Files.createDirectories(Paths.get(systemDir.getPath()));
            log.transferTo(systemDir);
            List<String> lines = Files.lines(Paths.get(systemDir.getPath())).collect(Collectors.toList());

            return logReaderService.logReader(lines, new Log());
        } catch (IOException e) {
            e.printStackTrace();
            return new Log();
        }
    }
}
