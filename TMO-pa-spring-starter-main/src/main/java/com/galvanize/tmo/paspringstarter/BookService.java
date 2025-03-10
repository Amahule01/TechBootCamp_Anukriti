package com.galvanize.tmo.paspringstarter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class BookService {
	
	
	
	
    private Map<Object, Book> repository = Arrays.asList(
            new Book[]{}).stream()
            .collect(Collectors.toConcurrentMap(s -> s.getId(), Function.identity()));
    private AtomicLong sequence = new AtomicLong(0);
	
	public Book createBook(Book book) {
		  long key = sequence.incrementAndGet();
	        book.setId(key);
	        repository.put(key, book);
	        return book;
	       
	}

	public Map<String, List<Book>> read() {
		List<Book> bookList = new ArrayList<Book>();
		bookList = repository.values().stream().collect(Collectors.toList());
		Map<String,List<Book>> bookMap= new HashMap<String,List<Book>>();
		bookMap.put("books", bookList);
		return bookMap;
	}

	public void delete() {
		repository.clear();
		    }
	}


