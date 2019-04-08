package com.worxfr.service;


import com.worxfr.common.ServerResponse;
import com.worxfr.pojo.UserHunt;

public interface IPowerService {
    ServerResponse add(UserHunt userHunt);

    ServerResponse delete(UserHunt userHunt);

    ServerResponse update(UserHunt userHunt);

    ServerResponse deletes(UserHunt userHunt);        // 批量删除权限

    ServerResponse search(UserHunt userHunt);


}
