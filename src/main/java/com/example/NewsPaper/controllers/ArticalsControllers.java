package com.example.NewsPaper.controllers;

import com.example.NewsPaper.Models.Articals;
import com.example.NewsPaper.Services.ArticaServices;
import com.example.NewsPaper.Slack.SlackClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "article")
public class ArticalsControllers {
    @Autowired
    ArticaServices articaServices;
    @Autowired
    SlackClient slackClient;

    @RequestMapping(value = "AddArtical",method = RequestMethod.POST)
    public String AddArtical (@RequestParam String title, String content , String author, String publishDate){
        try {
            articaServices.AddArtical( title,content,author,publishDate);
            return "Artical added Successfully";
        }catch (Exception e){
            return "Failed";
        }
    }
    @RequestMapping(value = "getAllArticals", method = RequestMethod.GET)
    public List<Articals> getAllArticals() {
        List<Articals> articals = articaServices.getAllArticals();
        return articals;
    }

    @RequestMapping(value = "getByArticalId", method = RequestMethod.GET)
    public List<Articals> getByArticalId(@RequestParam Integer articalId) {
        List<Articals> getByArticalIdList = articaServices.getByArticalId(articalId);
        return getByArticalIdList;
    }
    @Scheduled(cron = "0 24 * * *")
    @RequestMapping(value = "getAllArticalsByIsActive", method = RequestMethod.GET)
    public List<Articals> getAllArticalsByIsActive(){
        List<Articals>  activeArticalsList = articaServices.getAllArticalsByIsActive();
        for(Articals articalData : activeArticalsList) {
            slackClient.sendMessage(articalData.getIsActive().toString());
            slackClient.sendMessage(articalData.getPublishDate());
        }
            return activeArticalsList;

    }
    @Scheduled(cron = "0 24 * * *")
    @RequestMapping(value = "getAllArticalsByInActive", method = RequestMethod.GET)
    public List<Articals> getAllArticalsByInActive(){
        List<Articals>  InactiveArticalsList = articaServices.getAllArticalsByInActive();
        for(Articals articalData : InactiveArticalsList) {
            slackClient.sendMessage(articalData.getIsActive().toString());
            slackClient.sendMessage(articalData.getPublishDate());
        }
        return InactiveArticalsList;
    }
    @RequestMapping(value = "deleteArticleById", method = RequestMethod.POST)
    public String deleteArticleById(Integer id) {
        try {
            articaServices.deleteArticleById(id);
            return "deleted Successfully";

        } catch (Exception e) {
            return "failed";
        }
    }
        @RequestMapping(value ="UpdateArticals", method = RequestMethod.PUT)
        public void UpdateArticals() throws ParseException {
            articaServices.UpdateArticals();

        }


}
