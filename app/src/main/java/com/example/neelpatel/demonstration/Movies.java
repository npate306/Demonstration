package com.example.neelpatel.demonstration;

/**
 * Created by Neel Patel on 11/7/2017.
 */
import java.util.List;

public class Movies{

    private Integer page;
    private Integer totalResults;
    private Integer totalPages;
    private List<Result> results = null;

    public Integer getPage() {
        return page;
    }

    public Integer getTotalResults() {
        return totalResults;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public List<Result> getResults() {
        return results;
    }

}