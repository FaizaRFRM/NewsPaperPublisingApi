package com.example.NewsPaper.Services;

import com.example.NewsPaper.Models.Articals;
import com.example.NewsPaper.Repositories.ArticalRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ArticaServices {
    @Autowired
    ArticalRepositories articalRepositories;
    public void AddArtical(String title,String content ,String author,Date publishDate) {
        Articals articalsInfo = new Articals();
        articalsInfo.setAuthor(title);
        articalsInfo.setContent(content);
        articalsInfo.setTitle(author);
        articalsInfo.setPublishDate(publishDate);
        articalRepositories.save(articalsInfo);
    }
    public List<Articals> getAllArticals() {
        return articalRepositories.getAllArticals();
    }
    public List<Articals> getByArticalId(Integer articalId){
        List<Articals> articalsList = articalRepositories.getByArticalId(articalId);
        return articalsList;
    }

}
