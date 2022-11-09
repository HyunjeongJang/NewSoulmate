package tk.newsoulmate.domain.vo.response;

import tk.newsoulmate.domain.vo.Notice;

import java.util.List;

public class Items{
    private List<Notice> item;
    public List<Notice> getItem() {
        return item;
    }
    public void setItem(List<Notice> item) {
        this.item = item;
    }
}