package com.doruvarga.rainyblog;


import javax.persistence.*;

@Entity
@Table(name = "blog")
/*ai grija ca numele tabelului sa fie acelasi ca al clases
in cazul meu nu ii asa ca am pus @Table(name = "blog")
pt ca am scris numele tabelului in SQL cu b mic...
Daca ii acelasi, nu trebe sa pui dar ii de preferat sa fi precis
*/

public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String title;
    private String content;


    //private String text;

    public Blog() {
    }

    public Blog(String title, String content) {
        this.setTitle(title);
        this.setContent(content);
        //this.setText(text);
    }

    public Blog(int id, String title, String content) {
        this.setId(id);
        this.setTitle(title);
        this.setContent(content);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

//    public String getText() {
//        return text;
//    }
//
//    public void setText(String text) {
//        this.text = text;
//    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
