package com.tool.lowcode.controller;

import com.tool.lowcode.entity.UserStory;
import com.tool.lowcode.service.UserStoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v0/user-stories")
public class UserStoryController {

    private final UserStoryService userStoryService;

    public UserStoryController(UserStoryService userStoryService) {
        this.userStoryService = userStoryService;
    }

    @GetMapping
    public List<UserStory> getAllUserStories() {
        return userStoryService.getAllUserStories();
    }

    @GetMapping("/{id}")
    public Optional<UserStory> getUserStoryById(@PathVariable Long id) {
        return userStoryService.getUserStoryById(id);
    }

    @PostMapping
    public UserStory createUserStory(@RequestBody UserStory userStory) {
        return userStoryService.createUserStory(userStory);
    }

    @PutMapping("/{id}")
    public UserStory updateUserStory(@PathVariable Long id, @RequestBody UserStory updatedUserStory) {
        return userStoryService.updateUserStory(id, updatedUserStory);
    }

    @DeleteMapping("/{id}")
    public void deleteUserStory(@PathVariable Long id) {
        userStoryService.deleteUserStory(id);
    }
}
