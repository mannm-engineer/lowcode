package com.tool.lowcode.service;

import com.tool.lowcode.entity.UserStory;

import java.util.List;
import java.util.Optional;

public interface UserStoryService {

    List<UserStory> getAllUserStories();

    Optional<UserStory> getUserStoryById(Long id);

    UserStory createUserStory(UserStory userStory);

    UserStory updateUserStory(Long id, UserStory updatedUserStory);

    void deleteUserStory(Long id);
}
