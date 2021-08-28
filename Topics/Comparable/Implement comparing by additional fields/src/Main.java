class Article implements Comparable<Article> {
    private String title;
    private int size;

    public Article(String title, int size) {
        this.title = title;
        this.size = size;
    }

    public String getTitle() {
        return this.title;
    }

    public int getSize() {
        return this.size;
    }

    @Override
    /*
     *  You should implement comparing articles by their size, and if their sizes are equal, compare them by title.
     */
    public int compareTo(Article otherArticle) {
        if (this.size == otherArticle.getSize()) {
            return this.title.compareTo(otherArticle.getTitle());
        } else {
            return Integer.compare(this.size, otherArticle.getSize());
        }
    }
}