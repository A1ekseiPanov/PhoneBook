package com.example.phonebook.repositories;

import com.example.phonebook.models.Post.UserPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPostRepository extends JpaRepository<UserPost,Long> {
}
