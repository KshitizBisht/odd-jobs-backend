package com.oddJobs.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum DifficultyLevel {
    EASY("easy"),
    MEDIUM("medium"),
    HARD("hard");
    private final String level;
}
