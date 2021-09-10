package com.galvanize.tmo.paspringstarter;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@RestController
public class LibraryController {
	@Autowired
	private BookService service;

    @GetMapping("/health")
    public void health() {

    }
    
    @GetMapping("/api/Books")
    public Map<String, List<Book>> read(){
        return service.read();
    }

    @PostMapping("/api/Books")
    public ResponseEntity<Book> create(@RequestBody Book book) throws URISyntaxException {
        Book createdBook = service.createBook(book);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
            .buildAndExpand(createdBook.getId())
            .toUri();

        return ResponseEntity.created(uri)
            .body(createdBook);

    }
	

    @DeleteMapping("/api/Books")
    public ResponseEntity<Object> deleteStudent() {
        service.delete();

        return ResponseEntity.noContent().build();
    }
	
}
