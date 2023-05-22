package com.example.NewsPaper.controllers;

import com.example.NewsPaper.Models.Articals;
import com.example.NewsPaper.Services.ArticaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "article")
public class ArticalsControllers {
    @Autowired
    ArticaServices articaServices;

    @RequestMapping(value = "AddArtical",method = RequestMethod.POST)
    public String AddArtical (@RequestParam String title, String content , String author, Date publishDate){
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
    @RequestMapping(value = "deleteArticleById", method = RequestMethod.POST)
    public String deleteArticleById(Integer id) {
        try {
            articaServices.deleteArticleById(id);
            return "deleted Successfully";

        } catch (Exception e) {
            return "failed";
        }
    }
        @RequestMapping(value ="UpdateArticals")
        public void UpdateArticals() throws ParseException {
            articaServices.UpdateArticals();

        }


}
