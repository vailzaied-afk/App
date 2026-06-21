package org.skypro.skyshop.dop;

import org.skypro.skyshop.BestResultNotFound.BestResultNotFound;

import java.util.ArrayList;

import static java.nio.file.Files.lines;

public class SearchEngine {
    private final ArrayList<Searchable> lines;

    public SearchEngine(int cell) {
        this.lines = new ArrayList<>(cell);
    }

    public void add(Searchable element) {
        if (element == null) {
            return;
        }

        for (int i = 0; i < lines.size(); i++) {
            if (lines.get(i) == null) {
                lines.set(i, element);
                return;
            }
        }
        System.out.println("Нет свободного места для добавления элемента.");
    }

    public Searchable[] search(String query) {
        Searchable[] results = new Searchable[5];
        int resultCount = 0;

        for (int i = 0; i < lines.size(); i++) {
            if (lines.get(i) == null) {
                continue;
            }

            if (resultCount == 5) {
                break;
            }

            if (lines.get(i).searchTerm().contains(query)) {
                results[resultCount] = lines.get(i);
                resultCount++;
            }
        }

        Searchable[] trimmedResults = new Searchable[resultCount];
        System.arraycopy(results, 0, trimmedResults, 0, resultCount);

        return trimmedResults;
    }
    public static int getSearchTerm(String str, String substring) {
        if (str == null || substring == null || substring.isEmpty() || str.isEmpty()) {
            return 0;
        }

        int count = 0;
        int index = 0;

        int substringIndex = str.indexOf(substring, index);

        while (substringIndex != -1) {
            count++;
            index = substringIndex + substring.length();
            substringIndex = str.indexOf(substring, index);
        }

        return count;
    }
    public Searchable searchBestMatch(String query) throws BestResultNotFound {
        Searchable bestMatch = null;
        int maxCount = 0;

        for (Searchable item : lines) {
            if (item == null) {
                continue;
            }

            int count = getSearchTerm(item.searchTerm(), query);

            if (count > maxCount) {
                maxCount = count;
                bestMatch = item;
            }
        }

        if (bestMatch == null) {
            throw new BestResultNotFound("Объект не найден по запросу", query);
        }

        return bestMatch;
    }
}
