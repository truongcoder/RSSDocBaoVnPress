package a200390.pctruong.com.docbaodantri.ReadRSS;

import java.io.Serializable;

/**
 * Created by PCTRUONG on 1/20/2017.
 */

public class RSSItem implements Serializable {
    String title,  link, description;
    String pubdate, img ,content;
    Integer id;

    public RSSItem(String title, String link, String description, String pubdate, String img) {
        this.title = title;
        this.link = link;
        this.description = description;
        this.pubdate = pubdate;
        this.img = img;

    }
    public RSSItem(Integer id ,String title, String img ,  String pubdate ,String link) {
        this.id=id;
        this.title = title;
        this.img = img;
        this.pubdate = pubdate;
        this.link = link;



    }
    public RSSItem() {
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPubdate() {
        return pubdate;
    }

    public void setPubdate(String pubdate) {
        this.pubdate = pubdate;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
