package com.example.neelpatel.demonstration;
import java.util.List;

/**
 * Created by Neel Patel on 11/13/2017.
 */

public class Release {

    private List<Result> results = null;
    private Integer page;
    private Integer totalResults;
    private Integer totalPages;

    public List<Result> getResults() {
            return results;
    }

    public Integer getPage() {
        return page;
    }

    public Integer getTotalResults() {
            return totalResults;
    }

    public Integer getTotalPages() {
        return totalPages;
    }


}