package com.zach.springboot.controller;

import com.zach.springboot.pojo.Article;
import com.zach.springboot.result.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/rest")
public class ArticleRestController {


    @RequestMapping(value = "/article",method = RequestMethod.POST)
    public AjaxResponse saveArticle(@RequestBody Map<String ,Object> map){
        List<Article> list = (List<Article>) map.get("data1");
        List<Article> article= (List<Article>) map.get("data2");
        log.info("List{}",list);
        log.info("Article{}",article);
        log.info("save{}",map);
        return AjaxResponse.success(map);
    }


    @RequestMapping(value = "/article/{id}" ,method = RequestMethod.DELETE)
    public AjaxResponse deleteArticle(@PathVariable Long id){
        log.info("deleteArticle:{}",id);
        return AjaxResponse.success(id);
    }

    @RequestMapping(value = "/article/{id}",method = RequestMethod.PUT)
    public AjaxResponse updateArticle(@PathVariable Long id, @RequestBody Article article){
        article.setId(id);
        log.info("update "+article);
        return AjaxResponse.success(article);

    }

    @RequestMapping(value = "/article/{id}/{name}",method = RequestMethod.GET,produces = "application/json")
    public AjaxResponse getArticle(@PathVariable Long id,@PathVariable String  name){
        Article article = Article.builder().id(id).author(name).content("Spring boot 2.0").createTime(new Date()).title("t1").build();
        return AjaxResponse.success(article);
    }
}
