package chiarafais.u5w2d2.services;

import chiarafais.u5w2d2.entities.AutoreBlogPost;
import chiarafais.u5w2d2.exceptions.NotFoundException;
import org.springframework.stereotype.Service;
import java.util.*;


@Service
public class AutoriService {
    private List<AutoreBlogPost> autoriList = new ArrayList<>();

    public List<AutoreBlogPost> getAutoriList(){
        return this.autoriList;
    }

    public AutoreBlogPost saveAutore (AutoreBlogPost body){
        Random rndm = new Random();
        body.setId(rndm.nextInt(1,10000));
        this.autoriList.add(body);
        return body;
    }

    public AutoreBlogPost findById(int id){
        AutoreBlogPost found = null;
        for(AutoreBlogPost autore: this.autoriList){
            if(autore.getId() == id) found = autore;
        }
        if(found == null) throw new NotFoundException(id);
        else return found;
    }

    public AutoreBlogPost findByIdAndUpdate(int id, AutoreBlogPost updatedAutore){
        AutoreBlogPost found = null;
        for(AutoreBlogPost autore: this.autoriList){
            if(autore.getId() == id) {
                found = autore;
                found.setNome(updatedAutore.getNome());
                found.setCognome(updatedAutore.getCognome());
            }
        }
        if(found == null) throw new NotFoundException(id);
        else return found;
    }

    public void findByIdAndDelete(int id){
            Iterator<AutoreBlogPost> iterator = this.autoriList.iterator();

        while(iterator.hasNext()){
            AutoreBlogPost current = iterator.next();
            if(current.getId() == id){
                iterator.remove();
            }
        }

    }

}