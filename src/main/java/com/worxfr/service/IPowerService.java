package com.worxfr.service;


import com.worxfr.common.ServerResponse;
import com.worxfr.pojo.User;

public interface IPowerService {
    ServerResponse add(User user);

    ServerResponse delete(User user);

    ServerResponse update(User user);

    ServerResponse deletes(User user);        // 批量删除权限

    ServerResponse search(User user);


}
