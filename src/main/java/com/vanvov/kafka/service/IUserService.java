package com.vanvov.kafka.service;

import com.vanvov.kafka.domain.User;

public interface IUserService {
    User getUser(String username);
}
