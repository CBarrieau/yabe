package models;
 
import java.util.*;
import javax.persistence.*;
 
import play.db.jpa.*;
import play.data.validation.*;
 
@Entity
public class Comment extends Model {
 
	@Required
    public String author;
	@Required
    public Date postedAt;
     
    @Lob
    @Required
    public String content;
    
    @ManyToOne
    @Required
    public Post post;
    
    public Comment(Post post, String author, String content) {
        this.post = post;
        this.author = author;
        this.content = content;
        this.postedAt = new Date();
    }
    
    public String toString() {
    	String message = "";
    	if (content.length() <= 200) {
    		message = content;
    	} //if
    	else {
    		message = content.substring(0, 200) + "...";
    	} //else
    	return author + " said: " + message + " on " + (postedAt.getYear() + 1900) + "/" + postedAt.getMonth() + "/" + postedAt.getDate();
    } 
 
}