package chiarafais.u5w2d2.services;

import chiarafais.u5w2d2.entities.BlogPost;
import chiarafais.u5w2d2.exceptions.NotFoundException;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class BlogPostsService {
    private List<BlogPost> blogPostsList = new ArrayList<>();

    public List<BlogPost> getBlogPostsList(){
        return this.blogPostsList;
    }

    public BlogPost saveBlogPost (BlogPost body){
        Random rndm = new Random();
        body.setId(rndm.nextInt(1,10000));
        this.blogPostsList.add(body);
        return body;
    }

    public BlogPost findById(int id){
        BlogPost found = null;
        for(BlogPost blogPost: this.blogPostsList){
            if(blogPost.getId() == id) found = blogPost;
        }
        if(found == null) throw new NotFoundException(id);
        else return found;
    }

    public BlogPost findByIdAndUpdate(int id, BlogPost updatedBlogPost){
        BlogPost found = null;
        for(BlogPost blogPost: this.blogPostsList){
            if(blogPost.getId() == id) {
                found = blogPost;
                found.setTitolo(updatedBlogPost.getTitolo());
                found.setContenuto(updatedBlogPost.getContenuto());
            }
        }
        if(found == null) throw new NotFoundException(id);
        else return found;
    }

    public void findByIdAndDelete(int id){
        Iterator<BlogPost> iterator = this.blogPostsList.iterator();

        while(iterator.hasNext()){
            BlogPost current = iterator.next();
            if(current.getId() == id){
                iterator.remove();
            }
        }

    }

}