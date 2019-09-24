package com.ross.manger.info.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener()
public class OnlinePeopleNumber implements HttpSessionListener {

    private Integer onlineNum = 0;

    public Integer getOnlineNum() {
        return onlineNum;
    }

    public void setOnlineNum(Integer onlineNum) {
        this.onlineNum = onlineNum;
    }

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        if (getOnlineNum()>=0){
            onlineNum ++ ;
        }
        HttpSession session=httpSessionEvent.getSession();
        session.setAttribute("onlineNum",getOnlineNum());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        if (getOnlineNum()>0){
            onlineNum -- ;
        }else{
            setOnlineNum(0);
        }
        HttpSession session=httpSessionEvent.getSession();
        session.setAttribute("onlineNum",getOnlineNum());
    }
}
