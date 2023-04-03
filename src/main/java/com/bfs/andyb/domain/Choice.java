package com.bfs.andyb.domain;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Choice {
    private int id;
    private int question_id;
    private String statement;
    private boolean is_correct;

}