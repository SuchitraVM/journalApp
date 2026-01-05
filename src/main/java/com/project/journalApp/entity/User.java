package com.project.journalApp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Builder
@Document(collection = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    private ObjectId id;

    @Indexed(unique = true)
    @NotBlank(message = "Username cannot be null or empty")
    private String userName;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotBlank(message = "Password cannot be null or empty")
    private String password;

    private List<String> roles;

    @JsonIgnore
    @DBRef(lazy = true)
    //keeping reference while linking journal entries from journalEntry
    private List<JournalEntry> journalEntries = new ArrayList<>();


}
