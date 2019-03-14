package com.vanv.kafka.service;

import com.vanv.kafka.domain.User;

public interface IUserService {
    User getUser(String username);
}
