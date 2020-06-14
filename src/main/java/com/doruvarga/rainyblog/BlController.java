package com.doruvarga.rainyblog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class BlController {

    @Autowired
   private BlRespository blogRespository;

    @GetMapping("/blog")
    public List<Blog> index() {
        return blogRespository.findAll();

    }

  
    @GetMapping("/blog/{id}")
    public Blog show(@PathVariable String id) {
        int blogId = Integer.parseInt(id);
        return blogRespository.findOne(blogId);
    }

  
    @PostMapping("/blog/search")
    public List<Blog> search(@RequestBody Map<String, String> body) {
        String searchTerm = body.get("text");
        return blogRespository.findByTitleContainingOrContentContaining(searchTerm, searchTerm);

    }

   
    @PostMapping("/blog")
    public Blog create(@RequestBody Map<String, String> body) {
        //serviceProcesareBlog.processBlog(body);
        String title = body.get("title");
        String content = body.get("content");
        //String text=body.get("text");
        return blogRespository.save(new Blog(title, content));
    }


    @PutMapping("/blog/{id}")
    public Blog update(@PathVariable String id, @RequestBody Map<String, String> body) {
        int blogId = Integer.parseInt(id);
        // getting blog
        Blog blog = blogRespository.findOne(blogId);
        blog.setTitle(body.get("title"));
        blog.setContent(body.get("content"));
        //blog.setText(body.get("text"));
        return blogRespository.save(blog);
    }


    @DeleteMapping("blog/{id}")
    public boolean delete(@PathVariable String id) {
        int blogId = Integer.parseInt(id);
        blogRespository.delete(blogId);
        return true;
    }

}
