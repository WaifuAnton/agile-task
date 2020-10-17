package org.task.entity;

import java.util.List;

public class Page {
    private List<ImageBase> pictures;
    private int page;
    private int pageCount;
    private boolean hasMore;

    public List<ImageBase> getPictures() {
        return pictures;
    }

    public void setPictures(List<ImageBase> pictures) {
        this.pictures = pictures;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public boolean isHasMore() {
        return hasMore;
    }

    public void setHasMore(boolean hasMore) {
        this.hasMore = hasMore;
    }
}
