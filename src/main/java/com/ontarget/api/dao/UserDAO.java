package com.ontarget.api.dao;

import com.ontarget.bean.User;

/**
 * Created by sumit on 12/2/14.
 */
public interface UserDAO {
    User getUser(long userId) throws Exception;
}