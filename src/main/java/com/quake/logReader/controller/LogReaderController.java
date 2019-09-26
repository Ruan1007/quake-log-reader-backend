package com.quake.logReader.controller;

import com.quake.logReader.models.Game;
import com.quake.logReader.service.LogReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/arquivoLog")
@CrossOrigin("*")
public class LogReaderController {

    @Autowired
    private LogReaderService logReaderService;

    @PostMapping
    public List<Game> upload(@RequestParam("arquivo") MultipartFile log) {
        try {
            File convFile = new File(System.getProperty("java.io.tmpdir")+"/"+log.getName());
            log.transferTo(convFile);
            return logReaderService.leituraLog(convFile);
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
