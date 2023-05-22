package com.example.NewsPaper.Slack;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Data
public class SlackLoad {
    private String text;
    public SlackLoad(String text){
        this.text=text;
    }

}