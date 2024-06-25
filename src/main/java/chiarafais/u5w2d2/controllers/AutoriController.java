package chiarafais.u5w2d2.controllers;

import chiarafais.u5w2d2.entities.AutoreBlogPost;
import chiarafais.u5w2d2.services.AutoriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AutoriController {
    @Autowired
    private AutoriService autoriService;

    // 1. GET http://localhost:3001/authors (ritorna la lista di autori) //FUNZIONA
    @GetMapping
    private List<AutoreBlogPost> getAllAutori(){
        return this.autoriService.getAutoriList();
    }

    // 2. GET http://localhost:3001/authors/{authorId} (ritorna un singolo autore) //FUNZIONA
    @GetMapping("/{authorId}")
    private AutoreBlogPost findAutoreById(@PathVariable int authorId){
        return this.autoriService.findById(authorId);
    }

    // 3. POST http://localhost:3001/authors (+ body) (crea un nuovo autore) //FUNZIONA
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private AutoreBlogPost saveAutore(@RequestBody AutoreBlogPost body){
        return this.autoriService.saveAutore(body);
    }

    // 4. PUT http://localhost:3001/authors/{authorId} (+ body) (modifica lo specifico autore) //FUNZIONA
    @PutMapping("/{authorId}")
    private AutoreBlogPost findByIdAndUpdate(@PathVariable int authorId, @RequestBody AutoreBlogPost body){
        return this.autoriService.findByIdAndUpdate(authorId, body);
    }

    // 5. DELETE http://localhost:3001/authors/{authorId} (cancella lo specifico autore) //FUNZIONA
    @DeleteMapping("/{authorId}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // Status Code 204
    private void findAutoreByIdAndDelete(@PathVariable int authorId){
        this.autoriService.findByIdAndDelete(authorId);
    }
}
