package com.ross.manger.info.service.imp;

import com.ross.manger.info.dao.PageDao;
import com.ross.manger.info.dao.imp.PageDaoImp;
import com.ross.manger.info.entry.Page;
import com.ross.manger.info.entry.Project;
import com.ross.manger.info.service.PageService;

import java.util.List;

public class PageServiceImp implements PageService {
    @Override
    public Page getPage(int dangPage) {
        PageDao pd=new PageDaoImp();
        Page p=new Page();
        p.setPageSum(pd.SumSize());
        p.setDangPage(dangPage);
        List <Project> pageList=pd.getPageList(dangPage, p.getPageSize());
        p.setGetPageList(pageList);
        return p;
    }
}
