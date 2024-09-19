package com.devpawan.YoutubeVideoDownloader.Controller;

import com.devpawan.YoutubeVideoDownloader.Service.YTDownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class YTController {
    @Autowired
    private YTDownService ytDownService;

    @GetMapping("/home")
    public String showPage(){
        return "home";
    }

    @PostMapping("/home")
    public String download(@RequestParam("url") String url, Model model){
        try{
            ytDownService.downloadVideo(url);
            model.addAttribute("message", "Video download Successfull");
        } catch (Exception e){
            model.addAttribute("message", "Error downloading video: " + e.getMessage());
        }
        return "home";
    }
}
