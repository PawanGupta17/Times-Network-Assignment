package com.devpawan.YoutubeVideoDownloader.Service;

import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class YTDownService {
    private final String ytdlPath = "src/main/resources/bin/yt-dlp.exe";
    public void downloadVideo(String url) throws Exception{
        Path dir = Paths.get("downloads");
        if(!Files.exists(dir)){
            Files.createDirectory(dir);
        }
        String comd = ytdlPath + " -o " + dir + "/%(title)s.%(ext)s " + url;
        Process process = Runtime.getRuntime().exec(comd);
        process.waitFor();
    }
}
