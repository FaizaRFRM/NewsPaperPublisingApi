package com.example.NewsPaper.Repositories;

import com.example.NewsPaper.Models.Articals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticalRepositories extends JpaRepository<Articals,Integer> {
        @Query("SELECT a from Articals a")
        List<Articals> getAllArticals();
    @Query(value = "SELECT c from Course c WHERE c.student.id = :id ")
    List<Articals> getByArticalId(@Param("id") Integer id);

}
