
        package com.example.LibraryManagement.services;

import com.example.LibraryManagement.entity.Library;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LibraryService {

    private static final List<Library> libraryList = new ArrayList<>();


    static {
        libraryList.add(new Library(1, "Java", "Gosling", 60));
        libraryList.add(new Library(2, "React", "Saran", 100));
        libraryList.add(new Library(3, "Spring", "Mani", 200));
        libraryList.add(new Library(4, "Python", "Nani", 250));
    }


    public List<Library> getAll() {
        return new ArrayList<>(libraryList);
    }


    public Optional<Library> get(int id) {
        return libraryList.stream()
                .filter(library -> library.getId() == id)
                .findFirst();
    }


    public String createLibrary(Library lib) {

        boolean exists = libraryList.stream()
                .anyMatch(library -> library.getId() == lib.getId());

        if (exists) {
            return "Book ID already exists";
        }

        libraryList.add(lib);

        return "Book Created Successfully";
    }


    public String updateLibrary(int id, Library lib) {

        Optional<Library> existingBook = get(id);

        if (existingBook.isEmpty()) {
            return "Book Not Found";
        }

        Library library = existingBook.get();

        library.setBook(lib.getBook());
        library.setAuthor(lib.getAuthor());
        library.setPages(lib.getPages());

        return "Book Updated Successfully";
    }


    public boolean deleteLibrary(int id) {
        return libraryList.removeIf(library -> library.getId() == id);
    }
}

