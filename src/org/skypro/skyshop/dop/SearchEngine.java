package org.skypro.skyshop.dop;

public class SearchEngine {
    private final Searchable[] lines;

    public SearchEngine(int cell) {
        lines = new Searchable[cell];
    }

    public void add(Searchable element) {
        if (element == null) {
            return;
        }

        for (int i = 0; i < lines.length; i++) {
            if (lines[i] == null) {
                lines[i] = element;
                return;
            }
        }
        System.out.println("Нет свободного места для добавления элемента.");
    }

    public Searchable[] search(String query) {
        Searchable[] results = new Searchable[5];
        int resultCount = 0;

        for (int i = 0; i < lines.length; i++) {
            if (lines[i] == null) {
                continue;
            }

            if (resultCount == 5) {
                break;
            }

            if (lines[i].searchTerm().contains(query)) {
                results[resultCount] = lines[i];
                resultCount++;
            }
        }

        Searchable[] trimmedResults = new Searchable[resultCount];
        System.arraycopy(results, 0, trimmedResults, 0, resultCount);

        return trimmedResults;
    }
}
