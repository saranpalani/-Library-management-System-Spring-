
        package com.example.LibraryManagement.controller;

import com.example.LibraryManagement.entity.Library;
import com.example.LibraryManagement.services.LibraryService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library")
public class LibraryController {

    private final LibraryService libraryService;


    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }


    @GetMapping
    public ResponseEntity<List<Library>> getAllBooks() {
        return ResponseEntity.ok(libraryService.getAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Library> getBook(@PathVariable int id) {
        return libraryService.get(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PostMapping
    public ResponseEntity<String> createBook(@RequestBody Library lib) {

        String message = libraryService.createLibrary(lib);

        if (message.equals("Book ID already exists")) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(message);
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(message);
    }


    @PutMapping("/{id}")
    public ResponseEntity<String> updateBook(
            @PathVariable int id,
            @RequestBody Library lib) {

        String message = libraryService.updateLibrary(id, lib);

        if (message.equals("Book Not Found")) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(message);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable int id) {

        boolean deleted = libraryService.deleteLibrary(id);

        if (deleted) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}
