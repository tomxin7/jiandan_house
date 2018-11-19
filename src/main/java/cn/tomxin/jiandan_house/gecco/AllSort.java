package cn.tomxin.jiandan_house.gecco;

import cn.tomxin.jiandan_house.entity.Category;
import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Request;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.spider.HtmlBean;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author tomxin
 */
@Gecco(matchUrl = "https://www.douban.com/group/255608/" , pipelines={"consolePipeline", "allSortPipeline"})
public class AllSort implements HtmlBean {
    private static final long serialVersionUID = 665662335318691818L;

    @Request
    private HttpRequest request;

    // 移动互联网
    @HtmlField(cssPath="#group-topics > div:nth-child(2)")
    private List<Category> mobileInternet;

    public List<Category> getMobileInternet() {
        return mobileInternet;
    }

    public void setMobileInternet(List<Category> mobileInternet) {
        this.mobileInternet = mobileInternet;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public HttpRequest getRequest() {
        return request;
    }

    public void setRequest(HttpRequest request) {
        this.request = request;
    }
}
