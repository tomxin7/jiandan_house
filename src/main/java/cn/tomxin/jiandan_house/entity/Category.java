package cn.tomxin.jiandan_house.entity;

import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Text;
import com.geccocrawler.gecco.spider.HrefBean;
import com.geccocrawler.gecco.spider.HtmlBean;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class Category implements HtmlBean {

    @Text
    @HtmlField(cssPath = "dt a")
    private String url;

    @HtmlField(cssPath="tbody tr")
    private List<HrefBean> categorys;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<HrefBean> getCategorys() {
        return categorys;
    }

    public void setCategorys(List<HrefBean> categorys) {
        this.categorys = categorys;
    }
}
