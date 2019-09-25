package com.ross.manger.info.service.imp;

import com.ross.manger.info.entry.Page;
import com.ross.manger.info.service.ProjectService;
import com.ross.manger.info.service.imp.ProjectServiceImp;

import java.util.List;

public final class PageService {
    private static ProjectService proService=new ProjectServiceImp();
    public static Page paging(int pageNowValue, int pageSize){
        Page page=new Page();
        int pageNow=pageNowValue;

//        System.out.println(pageNow+"==pageNow");
        //拿到当前页数并设置page
        page.setPageNow(pageNow);
        //设置每页记录数
        page.setPageSize(pageSize);
        //设置上一页
        page.setPrev(pageNow-1);
        //设置下一页
        page.setNext(pageNow+1);

        //从数据库中得到所有的数据,总共有多少条
        int totalNum = getTotalNum();
        //设置总记录数
        page.setTotalNum(totalNum);

        int totalPage=0;
        System.out.println("388%12 ===="+(totalNum % pageSize));
        if( totalNum % pageSize == 0){
            //设置总页数
            totalPage = totalNum / pageSize;
        }else{
            //设置总页数
            totalPage = totalNum / pageSize + 1;
        }
        System.out.println("设置总页数："+totalPage);
        //设置最后一页
        page.setLast( totalPage);
        page.setTotalPage(totalPage);

        //防止页数越界
        if(pageNow < 1){
            pageNow = 1;
            page.setPrev(1);
        }
        if(pageNow > totalPage){
            pageNow = totalPage;
            page.setNext(totalPage);
        }
        //重新设置pageNow
        page.setPageNow(pageNow);


        if(pageNow < 2){
            //开始的位置
            page.setBegin(page.getFirst());
            //结束的位置
            page.setEnd(pageNow+2);
        }else if(pageNow > 3 && pageNow < page.getLast()-3){
            page.setBegin(pageNow-2);
            page.setEnd(pageNow+2);
        }else{
            //开始的位置
            page.setBegin(pageNow-2);
            //结束的位置
            page.setEnd(page.getLast());
        }

        System.out.println("pageNow---->>>"+pageNow+"pageSize===<<<"+pageSize);
//        查询当前页的数据并设置
        List data = findByPage( pageNow, pageSize);
        System.out.println(data);
        page.setData(data);
        //放回结果
        return page;
    }

    /**获取总记录数*/
    private static int getTotalNum() {
        System.out.println(proService.getAllRecordService()+"数据库中的总记录数");
        return proService.getAllRecordService();
    }


    private static List findByPage(int pageNow, int pageSize){
        return proService.getProjectAllDataPagingService((pageNow-1)*pageSize,pageSize);
    }
    private static List findByIdPage(Integer stuId,int pageNow, int pageSize){
        return proService.getProjectByStuIdDataPagingService(stuId,(pageNow-1)*pageSize,pageSize);
    }

    /*public static void main(String[] args) {
        Page page= PageService.paging("1",20);
        System.out.println(page);
        System.out.println("All:"+PageService.getTotalNum());
    }*/

}
