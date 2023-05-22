package com.example.NewsPaper.controllers;

import com.example.NewsPaper.Models.Articals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ArticalsControllersTest {
    @Autowired
    ArticalsControllers articalsControllers;
    @Test
    void getAllArticals() throws Exception{
        List<Articals> allArticals = articalsControllers.getAllArticals();
        assertNotNull(allArticals);
    }
    @Test
    void getByArticalId()throws Exception {
        Articals articalsToTest;
        articalsToTest= (Articals) articalsControllers.getByArticalId(1);
        String Author=articalsToTest.getAuthor();
        assertEquals("John Doe",Author);
    }
}