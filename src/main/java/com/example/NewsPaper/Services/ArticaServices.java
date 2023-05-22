package com.example.NewsPaper.Services;

import com.example.NewsPaper.Models.Articals;
import com.example.NewsPaper.Repositories.ArticalRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ArticaServices {
    @Autowired
    ArticalRepositories articalRepositories;
    public void AddArtical(String title,String content ,String author,String publishDate) {
        Articals articals = new Articals();
        articals.setAuthor(title);
        articals.setContent(content);
        articals.setTitle(author);
        articals.setPublishDate(publishDate);
        articalRepositories.save(articals);
    }
    public List<Articals> getAllArticals() {
        return articalRepositories.getAllArticals();
    }
    public List<Articals> getByArticalId(Integer articalId){
        List<Articals> articalsList = articalRepositories.getByArticalId(articalId);
        return articalsList;
    }
    public List<Articals> getAllArticalsByIsActive(){

        return articalRepositories.getAllArticalsByIsActive();
    }
    public List<Articals> getAllArticalsByInActive(){

        return articalRepositories.getAllArticalsByInActive();
    }
    public void deleteArticleById(Integer id) {
        Articals articals = articalRepositories.findById(id).get();
        articals.setIsActive(Boolean.valueOf("false"));
        articalRepositories.save(articals);
    }
    public void UpdateArticals() {
        Articals articals = new Articals();
        articals.setId(2);
        articals.setAuthor("Jane Smith");
        articals.setContent("The weather will be sunny with occasional rainfall and thunderstorms");
        articals.setTitle("Weather Forecast for Next Week");
        articals.setPublishDate ("2023-05-22");
        articalRepositories.save(articals);
    }

}
