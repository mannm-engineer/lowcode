package com.tool.lowcode.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class UserStory {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator = "user_story_seq")
    @SequenceGenerator(name = "user_story_seq", sequenceName = "user_story_id_seq", allocationSize = 1)
    private Long id;

    private String title;

    private String description;
}
