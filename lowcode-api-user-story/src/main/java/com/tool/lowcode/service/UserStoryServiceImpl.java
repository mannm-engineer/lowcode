package com.tool.lowcode.service;

import com.tool.lowcode.entity.UserStory;
import com.tool.lowcode.repository.UserStoryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class UserStoryServiceImpl implements UserStoryService {

    private final UserStoryRepository userStoryRepository;

    public UserStoryServiceImpl(UserStoryRepository userStoryRepository) {
        this.userStoryRepository = userStoryRepository;
    }

    @Override
    public List<UserStory> getAllUserStories() {
        return userStoryRepository.findAll();
    }

    @Override
    public Optional<UserStory> getUserStoryById(Long id) {
        if (!userStoryRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return userStoryRepository.findById(id);
    }

    @Override
    public UserStory createUserStory(UserStory userStory) {
        return userStoryRepository.save(userStory);
    }

    @Override
    public UserStory updateUserStory(Long id, UserStory updatedUserStory) {
        if (!userStoryRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        updatedUserStory.setId(id);
        return userStoryRepository.save(updatedUserStory);
    }

    @Override
    public void deleteUserStory(Long id) {
        if (!userStoryRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        userStoryRepository.deleteById(id);
    }
}
