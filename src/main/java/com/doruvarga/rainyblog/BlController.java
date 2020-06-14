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

    //http://localhost:8989/blog/2
    //asa poti sa vezi exact ce ai la id-u cu numarul 2
    @GetMapping("/blog/{id}")
    public Blog show(@PathVariable String id) {
        int blogId = Integer.parseInt(id);
        return blogRespository.findOne(blogId);
    }

    /**
     *
     * @param body
     * @return
     */
    @PostMapping("/blog/search")
    public List<Blog> search(@RequestBody Map<String, String> body) {
        String searchTerm = body.get("text");
        return blogRespository.findByTitleContainingOrContentContaining(searchTerm, searchTerm);

    }

    //localhost:8989/blog
    //in POSTMAN
    //create in POSTMan = POST
    @PostMapping("/blog")
    public Blog create(@RequestBody Map<String, String> body) {
        //serviceProcesareBlog.processBlog(body);
        String title = body.get("title");
        String content = body.get("content");
        //String text=body.get("text");
        return blogRespository.save(new Blog(title, content));
    }

//    @PostMapping("/blog")
//    public Blog create(@RequestBody BlogDTO body){
//        String title = body.getTitle();
//        String content = body.getContent();
//        Integer id = body.getId();
//        return blogRespository.save(new Blog(title, content, id));
//    }

    //update in POSTMan = PUT
    //Cand apelezi methoda in POSTMAN tre sa ai asta la url localhost:8989/blog/NUMARUL ID-ULUI
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

    //Cand apelezi methoda in POSTMAN tre sa ai asta la url localhost:8989/blog/NUMARUL ID-ULUI
    //asa va sterge datele cu id-ul respectiv
    @DeleteMapping("blog/{id}")
    public boolean delete(@PathVariable String id) {
        int blogId = Integer.parseInt(id);
        blogRespository.delete(blogId);
        return true;
    }

}
