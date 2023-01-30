package com.newprojectjdbc.todo;

import java.sql.Timestamp;
import java.util.Objects;

public class ToDoItem {
    private Integer id;
    private String description;
    private Boolean isComplete;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    //constructor overloading
    public ToDoItem() {
    }

    public ToDoItem(String description, Boolean isComplete) {
        this.description = description;
        this.isComplete = isComplete;
    }

    public ToDoItem(Integer id, String description, Boolean isComplete, Timestamp createdAt, Timestamp updatedAt) {
        this.id = id;
        this.description = description;
        this.isComplete = isComplete;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getComplete() {
        return isComplete;
    }

    public void setComplete(Boolean complete) {
        isComplete = complete;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ToDoItem toDoItem = (ToDoItem) o;
        return Objects.equals(id, toDoItem.id) && Objects.equals(description, toDoItem.description) && Objects.equals(isComplete, toDoItem.isComplete) && Objects.equals(createdAt, toDoItem.createdAt) && Objects.equals(updatedAt, toDoItem.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, isComplete, createdAt, updatedAt);
    }

    @Override
    public String toString() {
        return "ToDoItem{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", isComplete=" + isComplete +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }


}
