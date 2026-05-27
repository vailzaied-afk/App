package org.skypro.skyshop.dop;

public class SearchEngine {
    private Searchable[] lines;
    private int count;
    public SearchEngine() {

        lines = new Searchable[4];
    }
    public void add(Searchable element ) {

        if (count == lines.length) {
            return;
        }
        lines[count] = element;
        count++;

}
    public Searchable[] search(String query) {
        Searchable[] results = new Searchable[count];
        int resultCount = 0;


        for (int i = 0; i < count; i++) {
            String term = lines[i].searchTerm();


            if (term.contains(query)) {
                results[resultCount] = lines[i];
                resultCount++;
            }
        }
        Searchable[] trimmedResults = new Searchable[resultCount];
        System.arraycopy(results, 0, trimmedResults, 0, resultCount);

        return trimmedResults;
    }

}
