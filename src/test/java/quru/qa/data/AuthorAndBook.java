package quru.qa.data;

public enum AuthorAndBook {
    PUSHKIN("Пушкин", "Капитанская дочка"),
    LERMONTOV("Лермонтов", "Герой нашего времени");

    private final String author;
    private final String book;

    AuthorAndBook(String author, String book) {
        this.author = author;
        this.book = book;
    }

    public String getAuthor() {
        return author;
    }

    public String getBook() {
        return book;
    }
}
