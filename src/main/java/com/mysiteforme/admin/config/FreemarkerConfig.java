package com.mysiteforme.admin.config;

import com.mysiteforme.admin.freemark.*;
import freemarker.template.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by wangl on 2017/11/26.
 * todo:
 */
@Component
public class FreemarkerConfig {

    @Autowired
    private Configuration configuration;

    @Autowired
    private SystemDirective systemDirective;

    @Autowired
    private ArticleDirective articleDirective;

    @Autowired
    private IndexArticleDirective indexArticleDirective;

    @Autowired
    private ChannelDirective channelDirective;

    @Autowired
    private ParentChannelListDirective parentChannelListDirective;

    @Autowired
    private ArticleClickTempletModel articleClickTempletModel;

    @Autowired
    private SysUserTempletModel sysUserTempletModel;

    @Autowired
    private TagsTempletModel tagsTempletModel;

    @PostConstruct
    public void setSharedVariable() {
        //系统字典标签
        configuration.setSharedVariable("my",systemDirective);
        //博客文章标签
        configuration.setSharedVariable("ar",articleDirective);
        //博客首页文章列表标签
        configuration.setSharedVariable("myindex",indexArticleDirective);
        //博客栏目标签
        configuration.setSharedVariable("mychannel",channelDirective);
        //博客当前栏目所有父目录集合标签
        configuration.setSharedVariable("articleChannelList",parentChannelListDirective);

        //获取文章点击量标签
        configuration.setSharedVariable("clickNumber",articleClickTempletModel);
        //获取系统用户信息
        configuration.setSharedVariable("sysuser",sysUserTempletModel);

        configuration.setSharedVariable("tags",tagsTempletModel);
    }
}
