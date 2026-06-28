package org.skypro.skyshop.dop;

import org.skypro.skyshop.BestResultNotFound.BestResultNotFound;
import org.skypro.skyshop.Product;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;

import static java.nio.file.Files.lines;

public class SearchEngine {
    private final HashSet<Searchable> lines;

    public SearchEngine(int cell) {
        this.lines = new HashSet<>(cell);
    }

    public void add(Searchable element) {
        if (element == null) {
            return;
        }

        boolean isAdded = lines.add(element);

        if (!isAdded) {
            System.out.println("Нет свободного места для добавления элемента.");
        }
    }

    public Searchable[] search(String query) {
        Searchable[] results = new Searchable[5];
        int resultCount = 0;

        for (Searchable line: lines) {
            if (line == null) {
                continue;
            }

            if (resultCount == 5) {
                break;
            }

            if (line.searchTerm().contains(query)) {
                results[resultCount] = line;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SearchEngine that = (SearchEngine) o;
        return Objects.equals(lines, that.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lines);
    }

}
