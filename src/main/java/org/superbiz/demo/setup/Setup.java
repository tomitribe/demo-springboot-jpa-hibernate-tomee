/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.superbiz.demo.setup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.superbiz.demo.dao.AuthorDao;
import org.superbiz.demo.dao.BookDao;
import org.superbiz.demo.model.Author;
import org.superbiz.demo.model.Book;

import javax.annotation.PostConstruct;
import java.util.ArrayList;

@Component
public class Setup {

    @Autowired
    private AuthorDao authorDao;

    @Autowired
    private BookDao bookDao;

    @PostConstruct
    public void setup() {
        createAuthorAndBook("Jane", "Austen", "Pride and Predudice", 1813);
        createAuthorAndBook("Harper", "Lee", "To Kill a Mockingbird", 1960);
        createAuthorAndBook("F. Scott", "Fitzgerald", "The Great Gatsby", 1925);
        createAuthorAndBook("Gabriel", "Márquez", "One Hundred Years of Solitude", 1967);
        createAuthorAndBook("Truman", "Capote", "In Cold Blood", 1965);
    }

    private void createAuthorAndBook(String firstName, String lastName, String title, int publicationYear) {
        Author author = new Author(firstName, lastName);
        Book book = new Book(title, publicationYear);

        authorDao.save(author);
        bookDao.save(book);

        final ArrayList<Author> authors = new ArrayList<>();
        authors.add(author);
        book.setAuthors(authors);
        bookDao.save(book);

        final ArrayList<Book> books = new ArrayList<>();
        books.add(book);
        author.setBooks(books);
        authorDao.save(author);
    }

}
