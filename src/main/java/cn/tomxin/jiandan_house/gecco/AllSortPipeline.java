package cn.tomxin.jiandan_house.gecco;

import cn.tomxin.jiandan_house.entity.Category;
import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.pipeline.Pipeline;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.scheduler.SchedulerContext;
import com.geccocrawler.gecco.spider.HrefBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jackie on 18/1/15.
 */
@PipelineName("allSortPipeline")
public class AllSortPipeline implements Pipeline<AllSort> {
    @Override
    public void process(AllSort allSort) {
        System.out.println("-=======-");
        List<Category> categorys = new ArrayList<Category>();
        categorys.addAll(allSort.getMobileInternet());
        for(Category category : categorys) {
            List<HrefBean> hrefs = category.getCategorys();
            for(HrefBean href : hrefs) {
                System.out.println("title: " + href.getTitle() + " url: " + href.getUrl());
                String url = href.getUrl();
                HttpRequest currRequest = allSort.getRequest();
                SchedulerContext.into(currRequest.subRequest(url));
            }
        }
    }
}
