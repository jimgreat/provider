package com.dubbo.back;

import com.jm.business.entity.Game;
import com.jm.business.entity.User;
import com.jm.business.service.GameService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.List;


@DubboService(version = "1.0.0")
@Slf4j
public class BackServiceImpl implements BackService {

    @Autowired
    GameService gameService;

    @Override
    public List<User> getUsers()
    {
        User u = User.builder().userName("Hi").build();
        List<User> li = Collections.singletonList(u);
        return li;
    }

    @Override
    public String back(String msg)
    {
        List<Game> li = gameService.list();
        int cnt = li.size();
        String r = "I'm Back 2 ["+msg+" with cnt:"+cnt+"]";
        log.info(r);
        return r;
    }
}
